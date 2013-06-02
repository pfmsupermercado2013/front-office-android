package com.supermarket_frontoffice.recorrido_optimo.supermarket_map;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;


/** @class GLEstanteria
 *  @brief Clase que pinta con OpenGL toda la estantería.
 *  
 *  Cada elemento de la estantería son pintados por objetos distintos.
 *  Existe un objeto por cada sección de la estantería y por cada estante de cada sección.
 *  Esta clase coloca todos esos objetos a las posición donde se especifica la estantería en la Base de Datos.
 *  La estantería puede estar rotada según el ángulo especificado también en la Base de Datos.
 *  
 *  Definimos como punto de origen, la posición inferior izquierda del supermercado.
 * 
 * @author fjvegaf
 *
 */
public abstract class GLEstanteria 
{
	

	protected float 							 m_CoordenadaX;
	protected float 							 m_CoordenadaY;
	protected float 							 m_RotacionXY;
	protected Estanteria						 m_Estanteria;
	protected ArrayList< GLEstanteriaSeccion > 	 m_ListaGLEstanteriaSeccion;
	
	
	
	/** Constructor
	 * 
	 * 
	 * @param a_Estanteria
	 */
	public GLEstanteria( Estanteria a_Estanteria )
	{
		
		
		m_Estanteria= a_Estanteria;
//		a_Id= m_Id;
		m_CoordenadaX= a_Estanteria.getPosicionX() / 100.f;
		m_CoordenadaY= a_Estanteria.getPosicionY() / 100.f;
		m_RotacionXY= a_Estanteria.getRotacionXY();
		
		m_ListaGLEstanteriaSeccion= new ArrayList< GLEstanteriaSeccion >();
		
		ArrayList< EstanteriaSeccion > listaSecciones= m_Estanteria.getListaSecciones();
		
		for ( EstanteriaSeccion seccion: listaSecciones ) {
			
			m_ListaGLEstanteriaSeccion.add( new GLEstanteriaSeccionSimple( seccion ) );
			
//			switch ( seccion.getTipoSeccion() ) {
//				
//				case SeccionSimple:
//					
//					m_ListaGLEstanteriaSeccion.add( new GLEstanteriaSeccionSimple( seccion ) );
//					break;
//				
//				case SeccionDoble:
//				default:
//					
//					m_ListaGLEstanteriaSeccion.add( new GLEstanteriaSeccionDoble( seccion ) );
//					break;
//			}
		}
		
		//m_Seccion= new GLEstanteriaSeccion( (short)1, 135.192f, 33.768f, 64.005f );
	}
	
	

	/** Dibuja la estantería
	 * 
	 * @param a_Gl
	 */
	public abstract void draw( GL10 a_Gl );
//	{
//		
//		a_Gl.glTranslatef( m_CoordenadaX, 0, m_CoordenadaY );
//		a_Gl.glRotatef( m_RotacionXY, 0, 1, 0 ); //
//		
//		float largoSeccion= 0.f;
//		for ( GLEstanteriaSeccion glSeccion: m_ListaGLEstanteriaSeccion ) {
//			
//			glSeccion.draw( a_Gl );
//			a_Gl.glTranslatef( ( glSeccion.getEstanteriaSeccion().getLargo() ) / 100.f, 0.f, 0.f );
//			largoSeccion += glSeccion.getEstanteriaSeccion().getLargo() / 100.f;
//		}
//		
//		a_Gl.glTranslatef( -largoSeccion, 0.f, 0.f );
//		a_Gl.glRotatef( -m_RotacionXY, 0, 1, 0 ); //
//		a_Gl.glTranslatef( -m_CoordenadaX, 0, -m_CoordenadaY );
//		
//		//m_Seccion.draw( a_Gl );
//	} // draw


}
