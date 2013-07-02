package com.supermarket_frontoffice.recorrido_optimo.gl.comun;

import javax.microedition.khronos.opengles.GL10;

import android.util.Log;

/** @class GLObject
 * 	Clase que dibuja un objeto cualquiera en OpenGL
 * 
 * 
 * @author fjvegaf
 *
 */
public class GLObject extends GLBaseObject
{
	
	
	private static final String TAG= "GLObject";
	

	
	/** Constructor
	 * 
	 */
	public GLObject()
	{
		super();
	} // GLObject
	
	
	/** Constructor
	 * 
	 * @param a_Vertices
	 * @param a_Normales
	 * @param a_Caras
	 * @param a_CoordTextura
	 * @param a_Colores
	 */
	public GLObject( 	float a_Vertices[], 
						float a_Normales[],
						short a_Caras[] ) 
	{
		super( a_Vertices, a_Normales, a_Caras );
	} // GLObject
	
	
	/** Constructor
	 * 
	 * @param a_Vertices
	 * @param a_Normales
	 * @param a_Caras
	 * @param a_CoordTextura
	 * @param a_Colores
	 */
	public GLObject( 	float a_Vertices[], 
						float a_Normales[],
						short a_Caras[],
						float a_CoordTextura[],
						float a_Colores[] ) 
	{
		
		super( a_Vertices, a_Normales, a_Caras, a_CoordTextura, a_Colores );

	} // GLObject
	
	
	
	/** Método abstracto que debe redefinir las clases que lo hereran
	 * 
	 * @param a_Gl
	 */
	public void draw( GL10 a_Gl )
	{
		

		if ( ( m_VertexBuffer == null ) || ( m_FacesBuffer == null ) ) {
			
			
			Log.e( TAG, "No se ha especificado vertices o caras para el objeto OpenGL" );
			return;
		}
		
		
		// Contra las agujas del reloj		 
		a_Gl.glFrontFace(GL10.GL_CCW);
		 
//		// Habilitar el sacrificio de caras a ocultar		 
//		a_Gl.glEnable(GL10.GL_CULL_FACE);
//		 
//		// Aca se indica que cara se sacrificara, en este caso, la de atras		 
//		a_Gl.glCullFace(GL10.GL_BACK);
		

		 
		// Especifica la localizacion y el formato de los datos de un array de vertices a utilizar para el renderizado
		a_Gl.glEnableClientState( GL10.GL_VERTEX_ARRAY );
		
		a_Gl.glVertexPointer(3, GL10.GL_FLOAT, 0, m_VertexBuffer );
		
		
		if ( m_NormalsBuffer != null ) {
				
			a_Gl.glNormalPointer( GL10.GL_FLOAT, 0, m_NormalsBuffer );
		}
		//a_Gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, m_TexCoordsBuffer );


		if ( m_ColorBuffer != null ) {
			
			// Habilita el buffer para el color del grafico		 
			a_Gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		 
			// Señala donde se encuentra el buffer del color		 
			a_Gl.glColorPointer(4, GL10.GL_FLOAT, 0, m_ColorBuffer );
			
		}
		else {
			
			a_Gl.glColor4f( super.m_DefaultColor.getRed() / 255.f, super.m_DefaultColor.getGreen() / 255.f, super.m_DefaultColor.getBlue() / 255.f, 1.f );
		}
		
		//Dibujamos las superficies		 
		a_Gl.glDrawElements( GL10.GL_TRIANGLES, m_Caras.length, GL10.GL_UNSIGNED_SHORT, m_FacesBuffer );
				
		
//		if ( m_ColorBuffer != null ) {
//			// Desactiva el buffer de los vertices		 
//			a_Gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
//		}
		
		a_Gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		
		// Desahilita el buffer del color		 
		a_Gl.glDisableClientState( GL10.GL_COLOR_ARRAY );  
		
		//Desactiva la caracteristica de sacrificios de las caras		 
		a_Gl.glDisable(GL10.GL_CULL_FACE);
		 

		
	
	} // draw 

} // GLObject
