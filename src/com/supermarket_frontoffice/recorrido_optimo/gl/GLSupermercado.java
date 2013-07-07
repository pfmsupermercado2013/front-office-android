package com.supermarket_frontoffice.recorrido_optimo.gl;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.util.Log;

import com.supermarket_frontoffice.modelo_datos.Supermercado;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLBaseObject;
import com.supermarket_frontoffice.recorrido_optimo.gl.edificio.GLEdificio;
import com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario.GLMobiliario;


/** @class GLSupermercado
 * 
 * 	Clase que dibujo todo el escenario y los objetos que aparecen en el supermercado
 * 
 * @author fjvegaf
 *
 */
public class GLSupermercado extends GLBaseObject
{

	private static final String TAG= "GLSupermercado";
	
	private Supermercado  	m_Supermercado; ///< Clase que contiene todos los datos del supermercado
	private GLEdificio		m_GLEdificio;
	private GLMobiliario 	m_GLMobiliario;			///< Mobiliario el Supermercado
	
	
	/**
	 *  Constructor por defecto
	 */
	public GLSupermercado( Context a_Context )
	{
		this( a_Context, null );
	} // GLSupermercado
	
	/**
	 *  Constructor por defecto
	 */
	public GLSupermercado( Context a_Context, Supermercado  a_Supermercado )
	{
		
		super();
		m_Supermercado= a_Supermercado;
		
		m_GLEdificio= new GLEdificio( a_Supermercado.getEdificio() );
		m_GLMobiliario= new GLMobiliario( a_Context, a_Supermercado.getMobiliario() );	
		
	} // GLSupermercado
	
	
	/** Dibuja todo el supermercado
	 * 
	 * @param a_Gl
	 */
	public void draw( GL10 a_Gl )
	{
		
		if ( m_Supermercado == null ) {
			
			Log.e( TAG, "El Objecto Supermercado es null!" );
			return;
		}
		
		if ( m_GLEdificio != null ) {
			
			//Log.d( TAG, "Se inicializa el pintado del edifico supermercado" );
			
			m_GLEdificio.draw( a_Gl );
		}
		else {
			
			//Log.e( TAG, "El objeto Edificio del supermercado es null!" );
		}
		
		
		
		if ( m_GLMobiliario != null ) {
			
			//Log.d( TAG, "Se inicializa el pintado del mobiliario supermercado" );
			m_GLMobiliario.draw( a_Gl );
			
		}
		else {
			
			//Log.e( TAG, "El objeto Mobiliario del supermercado es null!" );
		}
		
	} // draw

	/**
	 * @return the m_Supermercado
	 */
	public Supermercado getSupermercado() 
	{
		return m_Supermercado;
	}

	/**
	 * @param m_Supermercado the m_Supermercado to set
	 */
	public void setSupermercado( Supermercado a_Supermercado ) 
	{
		this.m_Supermercado= a_Supermercado;
	}

	/**
	 * @return the m_GLEdificio
	 */
	public GLEdificio getGLEdificio() 
	{
		return m_GLEdificio;
	}

	/**
	 * @param m_GLEdificio the m_GLEdificio to set
	 */
	public void setGLEdificio( GLEdificio a_GLEdificio ) 
	{
		this.m_GLEdificio= a_GLEdificio;
	}

	/**
	 * @return the m_GLMobiliario
	 */
	public GLMobiliario getGLMobiliario( ) 
	{
		return m_GLMobiliario;
	}

	/**
	 * @param m_GLMobiliario the m_GLMobiliario to set
	 */
	public void setGLMobiliario( GLMobiliario a_GLMobiliario ) 
	{
		this.m_GLMobiliario= a_GLMobiliario;
	}
	
} // GLSupermercado
