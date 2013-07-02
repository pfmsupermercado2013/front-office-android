package com.supermarket_frontoffice.recorrido_optimo.gl.edificio;

import javax.microedition.khronos.opengles.GL10;

import com.supermarket_frontoffice.modelo_datos.ParedEdificio;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLBaseObject;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLVertice;
//import com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario.GLEstanteriaEstante;


/** @class GLParedEdificio
 *  @brief Clase que dibuja una pared en OpenGL.
 * 
 * @author fjvegaf
 *
 */
public abstract class GLParedEdificio extends GLBaseObject 
{

	private ParedEdificio m_ParedEdificio;	///< Datos de una pared del Edificio del Supermercado
	
	

	/**
	 * 
	 * @param a_Pared
	 */
	public GLParedEdificio( ParedEdificio a_Pared )
	{
	
		
		super( );
		
		//super.setVertices( this.calculateVertices( a_Pared.getV1().getVertice(), a_Pared.getV2().getVertice(), a_Pared.getAncho() ) ); 	
		m_ParedEdificio= a_Pared;
		
	} // GLParedEdificio
	
	
//	/** Devuélve los vértices de la pared a partir de los punto V1 y V2.
//	 * 
//	 */
	protected abstract float[] calculateVertices( GLVertice a_V1, GLVertice a_V2, float a_Ancho );
//	
//
//	protected abstract float[] calculateVertices( GLVertice a_V1, GLVertice a_V2, float a_Ancho );

	
	
	/** Método abstracto que debe redefinir las clases que lo hereran
	 * 
	 * @param a_Gl
	 */
	public void draw( GL10 a_Gl ) 
	{
		
		if ( m_ParedEdificio == null ) {
			
			return;
		}
		
		
		
		// Contra las agujas del reloj		 
		a_Gl.glFrontFace(GL10.GL_CCW);
		 
//		// Habilitar el sacrificio de caras a ocultar		 
//		a_Gl.glEnable(GL10.GL_CULL_FACE);
//		 
//		// Aca se indica que cara se sacrificara, en este caso, la de atras		 
//		a_Gl.glCullFace(GL10.GL_BACK);
		 
		// Habilitar el buffer de vertices para la escritura y cuales se usaran para el renderizado
		a_Gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		 
		// Especifica la localizacion y el formato de los datos de un array de vertices a utilizar para el renderizado
		//a_Gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
		a_Gl.glVertexPointer(3, GL10.GL_FLOAT, 0, m_VertexBuffer );
		a_Gl.glNormalPointer( GL10.GL_FLOAT, 0, m_NormalsBuffer );
		a_Gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, m_TexCoordsBuffer );
	
		// Habilita el buffer para el color del grafico		 
		a_Gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		 
		// Señala donde se encuentra el buffer del color		 
		a_Gl.glColorPointer(4, GL10.GL_FLOAT, 0, m_ColorBuffer );
		
		//a_Gl.glColor4f( 0.9f, 0.9f, 0.6f, 1.f );		
		//a_Gl.glColor4f( 204.0f/255.f, 213.0f/255.f, 225.0f/255.f, 1.f );
		
		a_Gl.glLineWidth( 1.f ); 
		//a_Gl.glPointSize( 2.f );
		 
		//Dibujamos las superficies		 
		//a_Gl.glDrawElements( GL10.GL_TRIANGLE_STRIP, m_Caras.length, GL10.GL_UNSIGNED_SHORT, m_IndexBuffer );
		a_Gl.glDrawElements( GL10.GL_TRIANGLES, m_Caras.length, GL10.GL_UNSIGNED_SHORT, m_FacesBuffer );
		//a_Gl.glDrawElements( GL10.GL_LINES, m_Caras.length, GL10.GL_UNSIGNED_SHORT, m_FacesBuffer );
		
		// draw data
		//a_Gl.glDrawArrays( GL10.GL_TRIANGLES, 0, m_GLEstanteriaExample.m_Estanteria_NumVerts );
		
		// Desactiva el buffer de los vertices		 
		a_Gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		 
		//Desactiva la caracteristica de sacrificios de las caras		 
		a_Gl.glDisable(GL10.GL_CULL_FACE);
		 
		// Desahilita el buffer del color		 
		a_Gl.glDisableClientState(GL10.GL_COLOR_ARRAY);      
		
		
	} // draw
	
} // GLParedEdificio
