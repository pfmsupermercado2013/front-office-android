package com.supermarket_frontoffice.modelo_datos;



/** @class Supermercado
 *  @brief Clase que almacena todos los datos relacionados con el supermercado
 * 
 * @author fjvegaf
 *
 */
public class Supermercado 
{

	Edificio	m_Edificio;
	Mobiliario 	m_Mobiliario;			///< Mobiliario el Supermercado
	
	
	
	/** Constructor null
	 * 
	 */
	public Supermercado( )
	{
		m_Edificio= new Edificio();
		m_Mobiliario= new Mobiliario();
		
	} // Supermercado
	
	
	/** Constructor
	 * 
	 * @param a_Edificio
	 * @param a_Mobiliario
	 */
	public Supermercado( Edificio a_Edificio, Mobiliario a_Mobiliario )
	{
		m_Edificio= a_Edificio;
		m_Mobiliario= a_Mobiliario;
		
	} // Supermercado
	
	
	/**
	 * @return the m_Edificio
	 */
	public Edificio getEdificio( ) 
	{
		return m_Edificio;
	}


	/**
	 * @param m_Edificio the m_Edificio to set
	 */
	public void setEdificio( Edificio a_Edificio ) 
	{
		this.m_Edificio= a_Edificio;
	}


	/**
	 * @return the m_Mobiliario
	 */
	public Mobiliario getMobiliario( ) 
	{
		return m_Mobiliario;
	}


	/**
	 * @param m_Mobiliario the m_Mobiliario to set
	 */
	public void setMobiliario( Mobiliario a_Mobiliario ) 
	{
		this.m_Mobiliario= a_Mobiliario;
	}
	
	
	/** Devuelve un String con toda la información de la clase
	 * 
	 */
	public String toString( )
	{
		
		
		String strOut= new String( "[[Supermercado]]" );
		
		if ( m_Edificio != null ) {

			strOut += "\n\t" + m_Edificio.toString();
		}
	
		if ( m_Mobiliario != null ) {

			strOut += "\n\t" + m_Mobiliario.toString();
		}
		
		
		
		return strOut;
	
	} // toString

	
	
} //Supermercado
