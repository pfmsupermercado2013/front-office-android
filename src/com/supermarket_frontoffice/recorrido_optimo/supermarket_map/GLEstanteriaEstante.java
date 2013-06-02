package com.supermarket_frontoffice.recorrido_optimo.supermarket_map;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;


/** Clase abstracta que define una interfaz para los diferenets tipos de Estantes
 * 
 * @author fjvegaf
 *
 */
public abstract class GLEstanteriaEstante extends GLObject
{

	
	private EstanteriaEstante m_Estante;
	
	
	/** Constructor
	 * 
	 * @param a_Estante
	 * @param a_Vertices
	 * @param a_Normales
	 * @param a_Caras
	 * @param a_CoordTextura
	 * @param a_Colores
	 */
	public GLEstanteriaEstante( EstanteriaEstante 	a_Estante,
								float 				a_Vertices[], 
								float 				a_Normales[],
								short 				a_Caras[],
								float				a_CoordTextura[],
								float 				a_Colores[] )
	{
		
		super( a_Vertices, a_Normales, a_Caras, a_CoordTextura, a_Colores );
		
		m_Estante= a_Estante;
		
	} // GLEstanteriaEstante
	
	
	/**
	 * 
	 * @param a_Gl
	 */
	public void draw( GL10 a_Gl )
	{
		
		
		// Contra las agujas del reloj		 
		a_Gl.glFrontFace(GL10.GL_CCW);
		 
//		// Habilitar el sacrificio de caras a ocultar		 
//		a_Gl.glEnable(GL10.GL_CULL_FACE);
//		 
//		// Aca se indica que cara se sacrificara, en este caso, la de atras		 
//		a_Gl.glCullFace(GL10.GL_BACK);
		 
		// Habilitar el buffer de vertices para la escritura y cuales se usaran para el renderizado
		a_Gl.glEnableClientState( GL10.GL_VERTEX_ARRAY );
		 
		// Especifica la localizacion y el formato de los datos de un array de vertices a utilizar para el renderizado
		//a_Gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
		a_Gl.glVertexPointer(3, GL10.GL_FLOAT, 0, m_VertexBuffer );
		a_Gl.glNormalPointer( GL10.GL_FLOAT, 0, m_NormalsBuffer );
		a_Gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, m_TexCoordsBuffer );

		
		// Habilita el buffer para el color del grafico		 
		a_Gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		 
		// Señala donde se encuentra el buffer del color		 
		a_Gl.glColorPointer(4, GL10.GL_FLOAT, 0, m_ColorBuffer );
		 
		//Dibujamos las superficies		 
		//a_Gl.glDrawElements( GL10.GL_TRIANGLE_STRIP, m_Caras.length, GL10.GL_UNSIGNED_SHORT, m_IndexBuffer );
		a_Gl.glDrawElements( GL10.GL_TRIANGLES, m_Caras.length, GL10.GL_UNSIGNED_SHORT, m_FacesBuffer );
		
		// draw data
		//a_Gl.glDrawArrays( GL10.GL_TRIANGLES, 0, m_GLEstanteriaExample.m_Estanteria_NumVerts );
		
		// Desactiva el buffer de los vertices		 
		a_Gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		 
		//Desactiva la caracteristica de sacrificios de las caras		 
		a_Gl.glDisable(GL10.GL_CULL_FACE);
		 
		// Desahilita el buffer del color		 
		a_Gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		
	} // draw
	
	
	
	
	
	
	/**
	 * @return the m_Estante
	 */
	public EstanteriaEstante getEstante( ) 
	{
		return m_Estante;
	}


	/**
	 * @param m_Estante the m_Estante to set
	 */
	public void setEstante( EstanteriaEstante a_Estante ) 
	{
		this.m_Estante = a_Estante;
	}
	
		
	
} // GLEstanteriaEstante
