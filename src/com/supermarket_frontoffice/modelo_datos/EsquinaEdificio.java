package com.supermarket_frontoffice.modelo_datos;

import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLVertice;


/** @class EsquinaEdificio
 * 
 * 
 * 
 * @author fjvegaf
 *
 */
public class EsquinaEdificio 
{

	
	short 		m_Id;			//< Identificador de la esquina
	GLVertice 	m_Vertice;		//< Coordenadas donde se encuentra la esquina
	
	
	/** Constructor por defecto
	 * 
	 */
	public EsquinaEdificio(  )
	{
		
		this( (short)0, new GLVertice() );
	
	} // EsquinaEdificio
	
	
	/** Constructor
	 * 
	 * @param a_X
	 * @param a_Y
	 */
	public EsquinaEdificio( short 		a_Id,
							GLVertice 	a_Vertice )
	{
		
		m_Id= a_Id;
		m_Vertice= a_Vertice;
		
	} // EsquinaEdificio
	
	
	/** Constructor copia
	 * 
	 * @param a_X
	 * @param a_Y
	 */
	public EsquinaEdificio( EsquinaEdificio a_EsquinaEdificio )
	{
		
		m_Id= a_EsquinaEdificio.m_Id;
		m_Vertice= a_EsquinaEdificio.m_Vertice;
		
	} // EsquinaEdificio


	/**
	 * @return the m_Id
	 */
	public short getId() 
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
	 * @return the m_Vertice
	 */
	public GLVertice getVertice( ) 
	{
		return m_Vertice;
	}


	/**
	 * @param m_Vertice the m_Vertice to set
	 */
	public void setVertice( GLVertice a_Vertice )
	{
		this.m_Vertice= a_Vertice;
	}
	
	/** Devuelve un String con toda la información de la clase
	 * 
	 */
	public String toString( )
	{
		
		return new String( "[[Esquina Id=" + this.m_Id + "] V(" + this.m_Vertice.getX() + ", " + this.m_Vertice.getY() + ", " + this.m_Vertice.getZ() + ") ]" );
	
	} // toString
	
	
} // EsquinaEdificioSupermercado
