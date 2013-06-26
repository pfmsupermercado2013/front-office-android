package com.supermarket_frontoffice.recorrido_optimo.xml;

import android.content.Context;
import android.util.Log;

import com.supermarket_frontoffice.modelo_datos.Supermercado;


/** @class XmlResourceSupermercado
 *  @brief Clase que realiza la lectura de todos los datos del supermercado.
 * 
 * @author fjvegaf
 *
 */
public class XmlResourceSupermercado 
{
	
	
	public static final String TAG= "XmlResourceSupermercado";
	Supermercado				m_Supermercado;					///< Objeto que contiene todos los datos del supermercado.
	
	XmlResourceEdificio			m_XmlResourceEdificio;			///< Recurso Xml con los valores de edificio del supermercado
	XmlResourceMobiliario  		m_XmlResourceMobiliario;		///< Recurso Xml con los valores de mobiliario
	
	
	/** Constructor
	 * 
	 * @param a_Context
	 * @param a_ResourceEdificio
	 * @param a_ResourceMobiliario
	 */
	public XmlResourceSupermercado( Context a_Context,
									int a_ResourceEdificio,
									int a_ResourceMobiliario )
	{
		
		m_Supermercado= new Supermercado();
		m_XmlResourceEdificio= new XmlResourceEdificio(  a_Context, a_ResourceEdificio, m_Supermercado.getEdificio() );
		m_XmlResourceMobiliario= new XmlResourceMobiliario( a_Context, a_ResourceMobiliario, m_Supermercado.getMobiliario() );
				
	} // XmlResourceSupermercado

	
	/**
	 * 
	 * @return
	 */
	public boolean read( )
	{
		
		Log.d( TAG, "Inicializando lectura de los datos del supermercado ... " );
		
		Log.d( TAG, "Inicializando lectura de los datos del edificio supermercado ... " );
		m_XmlResourceEdificio.read();
		
		Log.d( TAG, "Inicializando lectura de los datos del mobiliario supermercado ... " );
		m_XmlResourceMobiliario.read();
		
		
	   Log.d( TAG, "Mostrando todos los datos del supermercado ..." );
	   Log.d( TAG, m_Supermercado.toString() );
	   
	   Log.d( TAG, "Terminada la lectura de los datos del supermercado" );
		
		return true;
		
	} // read
	
	
	/**
	 * 
	 * @return
	 */
	public Supermercado getSupermercado( )
	{
		return m_Supermercado;
	}
	
} // XmlResourceSupermercado
