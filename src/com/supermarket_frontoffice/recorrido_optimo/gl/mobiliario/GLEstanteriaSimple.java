package com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario;

import javax.microedition.khronos.opengles.GL10;

import com.supermarket_frontoffice.modelo_datos.Estanteria;


/** @class GLEstanteriaSimple
 *  @brief 
 * 
 * @author fjvegaf
 *
 */
public class GLEstanteriaSimple extends GLEstanteria 
{

	
	/** Constructor
	 * 
	 * @param a_Estanteria
	 */
	public GLEstanteriaSimple( Estanteria a_Estanteria )
	{
		
		super( a_Estanteria );
		
	} // GLEstanteriaSimple
	
	
	/** Dibuja la estantería
	 * 
	 * @param a_Gl
	 */
	public void draw( GL10 a_Gl )
	{
		
		a_Gl.glTranslatef( m_CoordenadaX, 0, m_CoordenadaY );
		a_Gl.glRotatef( m_RotacionXY, 0, 1, 0 ); //
		
		float largoSeccion= 0.f;
		for ( GLEstanteriaSeccion glSeccion: m_ListaGLEstanteriaSeccion ) {
			
			glSeccion.draw( a_Gl );
			a_Gl.glTranslatef( ( glSeccion.getEstanteriaSeccion().getLargo() ) / 100.f, 0.f, 0.f );
			largoSeccion += glSeccion.getEstanteriaSeccion().getLargo() / 100.f;
		}
		
		a_Gl.glTranslatef( -largoSeccion, 0.f, 0.f );
		a_Gl.glRotatef( -m_RotacionXY, 0, 1, 0 ); //
		a_Gl.glTranslatef( -m_CoordenadaX, 0, -m_CoordenadaY );
		
		//m_Seccion.draw( a_Gl );
	} // draw
	
	
	
	
} // end class GLEstanteriaSimple
