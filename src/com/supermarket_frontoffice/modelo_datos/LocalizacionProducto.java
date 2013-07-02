package com.supermarket_frontoffice.modelo_datos;


/** @class LocalizacionProducto
 * 
 * @author fjvegaf
 *
 */
public class LocalizacionProducto
{
	
	private short 	m_EstanteriaId;  	///< Id de estantería
	private short 	m_SeccionId;		///< Id de sección
	private short 	m_EstanteId;		///< Id de estante
	
	
	/** Constructor
	 * 
	 * @param a_EstanteriaId
	 * @param a_SeccionId
	 * @param a_EstanteId
	 */
	public LocalizacionProducto( 	short a_EstanteriaId,
									short a_SeccionId,
									short a_EstanteId )
	{
		
		m_EstanteriaId= a_EstanteriaId;
		m_SeccionId= a_SeccionId;
		m_EstanteId= a_EstanteId;
		
	} // LocalizacionProducto


	/**
	 * @return the m_EstanteriaId
	 */
	public short getEstanteriaId( ) 
	{
		return m_EstanteriaId;
	}


	/**
	 * @param m_EstanteriaId the m_EstanteriaId to set
	 */
	public void setEstanteriaId(short m_EstanteriaId ) 
	{
		this.m_EstanteriaId = m_EstanteriaId;
	}


	/**
	 * @return the m_SeccionId
	 */
	public short getSeccionId() 
	{
		return m_SeccionId;
	}


	/**
	 * @param m_SeccionId the m_SeccionId to set
	 */
	public void setSeccionId( short m_SeccionId ) 
	{
		this.m_SeccionId = m_SeccionId;
	}


	/**
	 * @return the m_EstanteId
	 */
	public short getEstanteId( ) 
	{
		return m_EstanteId;
	} // getEstanteId


	/**
	 * @param m_EstanteId the m_EstanteId to set
	 */
	public void setEstanteId( short m_EstanteId ) 
	{
		this.m_EstanteId = m_EstanteId;
	}

} // end LocalizacionProducto
