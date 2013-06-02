package com.supermarket_frontoffice.recorrido_optimo.supermarket_map;

import java.util.ArrayList;


/** @class Seccion
 * 
 *  @brief Clase que encapsula los datos correspondientes a una sección de la estantería
 * 
 * @author fjvegaf
 *
 */
public class EstanteriaSeccion 
{
	
	
	public enum TTipoEstanteSeccion {
		
		SeccionSimple,
		SeccionDoble
	};
	
	
	private short 				m_Id; 						///< Indentificador de la seccion
	private TTipoEstanteSeccion m_TipoSeccion; 				///< Tipo de Sección de la estantería.
	private float 				m_Alto;  					///< Longitud de la sección
	private float 				m_Largo;  					///< Longitud de la sección
	private float 				m_AnchoBase; 				///< Ancho de la Base de la sección
	
	private ArrayList< EstanteriaEstante > m_ListaEstantes;
	
	
	/** Constructor
	 * 
	 * @param a_Id				Identificador de la Sección dentro de la estantería
	 * @param a_TipoSeccion		Tipo de Sección. Se diferencia entre sección simple y 
	 * 							sección doble.
	 * @param a_Alto			Altura total de la sección
	 * @param a_Largo			Longitud de la sección.
	 * @param a_AnchoBase		Anchura de la Base de la Sección
	 */
	public EstanteriaSeccion( 	short a_Id, 
								TTipoEstanteSeccion a_TipoSeccion,
								float a_Alto,
								float a_Largo,
								float a_AchoBase )
	{
	
		this( a_Id, a_TipoSeccion, a_Alto, a_Largo, a_AchoBase, new ArrayList< EstanteriaEstante >() );
		
	} // EstanteriaSeccion
	
	
	/** Constructor
	 * 
	 * @param a_Id				Identificador de la Sección dentro de la estantería
	 * @param a_TipoSeccion		Tipo de Sección. Se diferencia entre sección simple y 
	 * 							sección doble.
	 * @param a_Alto			Altura total de la sección
	 * @param a_Largo			Longitud de la sección.
	 * @param a_AnchoBase		Anchura de la Base de la Sección
	 * @param a_ListaEstantes	Lista de Estantes que contiene la sección
	 */
	public EstanteriaSeccion( 	short a_Id, 
								TTipoEstanteSeccion a_TipoSeccion,
								float a_Alto,
								float a_Largo,
								float a_AchoBase,
								 ArrayList< EstanteriaEstante > a_ListaEstantes )
	{
		
		m_Id= a_Id;
		m_TipoSeccion= a_TipoSeccion;
		m_Alto= a_Alto;
		m_Largo= a_Largo;
		m_AnchoBase= a_AchoBase;	///  Corresponde al ancho del Estante 1 de la Sección
		
		m_ListaEstantes= a_ListaEstantes;
		
	} // EstanteriaSeccion
	
	
	/**
	 * @return the m_Id
	 */
	public short getId( ) 
	{
		return m_Id;
	}


	/**
	 * @param a_Id the m_Id to set
	 */
	public void setId( short a_Id ) 
	{
		this.m_Id = a_Id;
	} // setId
	
	
	/**
	 * @return the m_TipoSeccion
	 */
	public TTipoEstanteSeccion getTipoSeccion( ) 
	{
		return m_TipoSeccion;
	}


	/**
	 * @param m_TipoSeccion the m_TipoSeccion to set
	 */
	public void setTipoSeccion( TTipoEstanteSeccion a_TipoSeccion ) 
	{
		this.m_TipoSeccion= a_TipoSeccion;
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
	 * @return the m_Largo
	 */
	public float getLargo( ) 
	{
		return m_Largo;
	} // getLargo


	/**
	 * @param m_Largo the m_Largo to set
	 */
	public void setLargo( float a_Largo ) 
	{
		this.m_Largo= a_Largo;
	} // setLargo

	
	
	/**
	 * @return the m_AnchoBase
	 */
	public float getAnchoBase( ) 
	{
		return m_AnchoBase;
	}


	/**
	 * @param m_AnchoBase the m_AnchoBase to set
	 */
	public void setAnchoBase( float a_AnchoBase ) 
	{
		this.m_AnchoBase = a_AnchoBase;
	}

	
	/**
	 * @return the m_ListaEstantes
	 */
	public ArrayList<EstanteriaEstante> getListaEstantes() 
	{
		return m_ListaEstantes;
	}
	

	/**
	 * @param m_ListaEstantes the m_ListaEstantes to set
	 */
	public void setListaEstantes( ArrayList<EstanteriaEstante> a_ListaEstantes ) 
	{
		this.m_ListaEstantes = a_ListaEstantes;
	}

	
	/**
	 * @param m_ListaEstantes the m_ListaEstantes to set
	 */
	public void addEstanteriaEstante( EstanteriaEstante a_EstanteriaEstante ) 
	{
		this.m_ListaEstantes.add( a_EstanteriaEstante );
	}
	
	
} // EstanteriaSeccion
