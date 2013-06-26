package com.supermarket_frontoffice.modelo_datos;


/** @class PuertaSupermercado
 * 
 * @author fjvegaf
 *
 */
public class PuertaEdificio 
{

	
	private short 			m_Id;		///< Identificador de la pared
	private ParedEdificio 	m_Pared; 	///< Pared donde se encuentra la puerta

	private float			m_XLeft; 	///< Posición inicial (en X) con respecto a la pared en la que se coloca la puerta (cm) 
	private float			m_Alto; 	///< Altura de la puerta (cm)
	private float			m_Largo;	///< Longitud de la puerta (cm)
	
	
	
	/** Constructor por defecto
	 * 	
	 */
	public PuertaEdificio( )
	{
		
		this( (short) 0, new ParedEdificio(), 0.f, 0.f, 0.f );
		
	} // PuertaEdificio
	
	
	/** Constructor
	 * 
	 * @param a_Id
	 * @param a_Pared
	 * @param a_XLeft
	 * @param a_Alto
	 * @param a_Largo
	 */
	public PuertaEdificio( 	short 			a_Id, 
							ParedEdificio	a_Pared,
							float			a_XLeft, 
							float			a_Alto,
							float			a_Largo )
	{
		
		m_Id= a_Id;
		m_Pared= a_Pared;
		m_XLeft= a_XLeft; 
		m_Alto= a_Alto;
		m_Largo= a_Largo;
		
	} // PuertaEdificio


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
	 * @return the m_Pared
	 */
	public ParedEdificio getPared( ) 
	{
		return m_Pared;
	}


	/**
	 * @param m_Pared the m_Pared to set
	 */
	public void setPared( ParedEdificio a_Pared ) 
	{
		this.m_Pared = a_Pared;
	}


	/**
	 * @return the m_XLeft
	 */
	public float getXLeft( ) 
	{
		return m_XLeft;
	}


	/**
	 * @param m_XLeft the m_XLeft to set
	 */
	public void setXLeft( float a_XLeft ) 
	{
		this.m_XLeft = a_XLeft;
	}

	
	/**
	 * @return the m_Alto
	 */
	public float getAlto() 
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
	 * @return the m_Largo
	 */
	public float getLargo( ) 
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
	
	
	/** Devuelve un String con toda la información de la clase
	 * 
	 */
	public String toString( )
	{
		
		return new String( "[[Puerta Id=" + this.m_Id + "][" + this.m_Pared.toString() + "] XLeft= "+ this.m_XLeft + "; Alto= "+ this.m_Alto + "; Largo= " + this.m_Largo + " ]" );
	
	} // toString
	
	
	
} // PuertaSupermercado
