package com.supermarket_frontoffice.modelo_datos;

import java.util.ArrayList;


/** @class Mobiliario
 *  @brief Clase que almacena los datos del inmobiliario del Supermercado 
 * 
 * 
 * @author fjvegaf
 *
 */
public class Mobiliario 
{
	
	
	ArrayList< Estanteria > m_ListaEstanteria;  ///< Lista de estanterías
	

	/** Constructor
	 * 
	 */
	public Mobiliario( )
	{
		
		m_ListaEstanteria= new ArrayList< Estanteria >(); 
		
	} // Mobiliario
	
	
	
	/**
	 * @return the m_ListaEstanteria
	 */
	public ArrayList<Estanteria> getListaEstanteria() 
	{
		return m_ListaEstanteria;
	}


	/**
	 * @param m_ListaEstanteria the m_ListaEstanteria to set
	 */
	public void setListaEstanteria( ArrayList<Estanteria> m_ListaEstanteria ) 
	{
		this.m_ListaEstanteria = m_ListaEstanteria;
	}
	
	/**
	 * @param m_ListaEstanteria the m_ListaEstanteria to set
	 */
	public void addEstanteria( Estanteria a_Estanteria ) 
	{
		this.m_ListaEstanteria.add( a_Estanteria );
	}
	
	
	/** Devuelve un String con toda la información de la clase
	 * 
	 */
	public String toString( )
	{
		
		
		String strOut= new String( "[[Mobiliario]]" );
	
		if ( !m_ListaEstanteria.isEmpty() ) {
			
			for ( Estanteria estanteria: m_ListaEstanteria ) {
				
				strOut += "\t" + estanteria.toString() + "\n";
			}
		}
		return strOut;
	
	} // toString
	
	
	
	
} // Mobiliario
