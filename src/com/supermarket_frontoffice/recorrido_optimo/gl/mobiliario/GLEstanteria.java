package com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

import android.util.Log;

import com.supermarket_frontoffice.modelo_datos.Estanteria;
import com.supermarket_frontoffice.modelo_datos.EstanteriaSeccion;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLVertice;


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
	
	private static final String TAG= "GLEstanteria";

	protected float 							 m_CoordenadaX;
	protected float 							 m_CoordenadaY;
	protected float 							 m_RotacionXY;
	protected Estanteria						 m_Estanteria;
	protected ArrayList< GLEstanteriaSeccion > 	 m_ListaGLEstanteriaSeccion;
	
	
	
	/** Constructor
	 * 
	 * @param a_Estanteria
	 */
	public GLEstanteria( Estanteria a_Estanteria )
	{
		
		
		m_Estanteria= a_Estanteria;
		m_CoordenadaX= a_Estanteria.getPosicionX() / 100.f;
		m_CoordenadaY= a_Estanteria.getPosicionY() / 100.f;
		m_RotacionXY= a_Estanteria.getRotacionXY();
		
		m_ListaGLEstanteriaSeccion= new ArrayList< GLEstanteriaSeccion >();
		
		ArrayList< EstanteriaSeccion > listaSecciones= m_Estanteria.getListaSecciones();
		
		for ( EstanteriaSeccion seccion: listaSecciones ) {
			
			m_ListaGLEstanteriaSeccion.add( new GLEstanteriaSeccionSimple( seccion ) );
		}
		
		this.calcularCoordenadasRealSecciones();
		
	} // GLEstanteria
	
	

	/** Dibuja la estantería
	 * 
	 * @param a_Gl
	 */
	public abstract void draw( GL10 a_Gl );
	
	
	/** Calcula la coordenada real de todas las secciones de la estantería
	 * 
	 */
	public abstract void calcularCoordenadasRealSecciones(  );
	

	
	/**  Selecciona la sección especificada dentro de la estantería
	 * 
	 * @param a_SeccionId
	 * @return
	 */
	public boolean seleccionarSeccion( short a_SeccionId, boolean a_FlagSeleccion )
	{
		
		if ( m_ListaGLEstanteriaSeccion.isEmpty() ) {
			
			return false;
		}		
		
		for ( GLEstanteriaSeccion glEstanteriaSeccion: m_ListaGLEstanteriaSeccion ) {
			
			if ( glEstanteriaSeccion.getEstanteriaSeccion().getId() == a_SeccionId ) {
				
				glEstanteriaSeccion.setEstaSeleccionada( a_FlagSeleccion );
				return true;
			}
		}		
		return false;
		
	} // seleccionarSeccion
	
		
	/** Selecciona la sección especificada dentro de la estantería
	 * 
	 * @param a_SeccionId
	 * @param a_EstanteId
	 * @param a_FlagSeleccion
	 * @return
	 */
	public GLVertice localizarProducto( 	short a_SeccionId, 
											short a_EstanteId, 
											boolean a_FlagSeleccion,
											GLFlechaLocalizacionProducto a_GLFlechaLocalizacion )
	{
		
		if ( m_ListaGLEstanteriaSeccion.isEmpty() ) {
			
			return null;
		}		
		
		for ( GLEstanteriaSeccion glEstanteriaSeccion: m_ListaGLEstanteriaSeccion ) {
			
			if ( glEstanteriaSeccion.getEstanteriaSeccion().getId() == a_SeccionId ) {
				
				
				//Log.d( TAG, "Localizado sección con el Id: " + glEstanteriaSeccion.getEstanteriaSeccion().getId() );
				glEstanteriaSeccion.setEstaSeleccionada( a_FlagSeleccion );
				
				glEstanteriaSeccion.setGLFlechaLocalizacionProducto( ( a_FlagSeleccion )? a_GLFlechaLocalizacion: null );
	
				if ( glEstanteriaSeccion.localizarProducto( a_EstanteId, a_FlagSeleccion ) ) {
					
					return glEstanteriaSeccion.getCoordenadaRealSeccion();
				}
			}
		}		
		return null;
		
	} // seleccionarSeccion
	
	
	/**  Selecciona la sección especificada dentro de la estantería
	 * 
	 * @param a_SeccionId
	 * @return
	 */
	public boolean deslocalizarTodosProductos( )
	{
		
		if ( m_ListaGLEstanteriaSeccion.isEmpty() ) {
			
			return false;
		}		
		
		for ( GLEstanteriaSeccion glEstanteriaSeccion: m_ListaGLEstanteriaSeccion ) {
			
			glEstanteriaSeccion.setEstaSeleccionada( false );
			glEstanteriaSeccion.deslocalizarTodosProductos();
		}		
		
		return true;
		
	} // seleccionarSeccion

	
	/**
	 * 
	 * @param a_SeccionId
	 * @return
	 */
	public GLVertice getCoordenadaRealSeccion( short a_SeccionId )
	{
		
		if ( ( m_ListaGLEstanteriaSeccion == null ) && m_ListaGLEstanteriaSeccion.isEmpty() ) {
			
			return null;
		}
		
		for ( GLEstanteriaSeccion glEstanteriaSeccion: m_ListaGLEstanteriaSeccion ) {
			
			if ( glEstanteriaSeccion.getEstanteriaSeccion().getId() == a_SeccionId ) {
				
				return glEstanteriaSeccion.getCoordenadaRealSeccion();
			}
		}	
		
		return new GLVertice();
	} // getCoordenadaRealSeccion


	/**
	 * @return the m_Estanteria
	 */
	public Estanteria getEstanteria() 
	{
		return m_Estanteria;
	}


	/**
	 * @param m_Estanteria the m_Estanteria to set
	 */
	public void setEstanteria( Estanteria a_Estanteria ) 
	{
		this.m_Estanteria= a_Estanteria;
	}


} // end class GLEstanteria
