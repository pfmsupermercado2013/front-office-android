package com.supermarket_frontoffice.recorrido_optimo.supermarket_map;

/** @class EstanteriaEstante
 * 
 *  @brief Informaci�n de cada uno de los estantes que componen una secci�n de la estanter�a.
 * 
 * @author fjvegaf
 *
 */
public class EstanteriaEstante 
{
	
	private short 	m_Id;  		///< Identificador del Estante
	private float	m_Alto;		///< Altura del estante. 
	private float	m_Ancho;	///< Ancho de Estante. Puede ser superior al acho de la secci�n.
	private float	m_Largo;	///< Longitud del Estante. No puede ser superior a la longitud de la seccion.
	
	
	/** Contructor
	 * 
	 * @param a_Id
	 * @param a_Alto
	 * @param a_Ancho
	 * @param a_Largo
	 */
	public EstanteriaEstante( short a_Id, float a_Alto, float a_Largo , float a_Ancho )
	{
		
		m_Id= a_Id;
		m_Alto= a_Alto;
		m_Ancho= a_Ancho;
		m_Largo= a_Largo;
		
	} // EstanteriaEstante
	
	
	/**
	 * @return the m_Id
	 */
	public short getId( ) 
	{
		return m_Id;
	}


	/**
	 * @param m_Id the m_Id to set
	 */
	public void setId( short a_Id ) 
	{
		this.m_Id = a_Id;
	}


	/**
	 * @return the m_Alto
	 */
	public float getAlto( ) 
	{
		return m_Alto;
	}


	/**
	 * @param m_Alto the m_Alto to set
	 */
	public void setAlto( float a_Alto ) 
	{
		this.m_Alto = a_Alto;
	}



	/**
	 * @return the m_Ancho
	 */
	public float getAncho( ) 
	{
		return m_Ancho;
	}



	/**
	 * @param m_Ancho the m_Ancho to set
	 */
	public void setAncho( float a_Ancho ) 
	{
		this.m_Ancho = a_Ancho;
	}


	/**
	 * @return the m_Largo
	 */
	public float getLargo() 
	{
		return m_Largo;
	}


	/**
	 * @param m_Largo the m_Largo to set
	 */
	public void setLargo( float a_Largo ) 
	{
		this.m_Largo = a_Largo;
	}



} // EstanteriaEstante
