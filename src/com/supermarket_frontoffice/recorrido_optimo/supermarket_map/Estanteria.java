package com.supermarket_frontoffice.recorrido_optimo.supermarket_map;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;


/** @class Clase contiene todos los datos de una estantería en OPenGL
 * 
 * @author fjvegaf
 *
 */
public class Estanteria 
{
	
	
	public enum TTipoEstanteria {
		
		EstanteriaSimple,
		EstanteriaDoble,
		FrigorificoAltoSimple,
		FrigorificoBajoSimple,
		FrigorificoBajoDoble		
	};
	

	private short 			m_Id;
	private TTipoEstanteria m_TipoEstanteria;
	private float 			m_PosicionX;
	private float 			m_PosicionY;
	private float 			m_RotacionXY;
	private ArrayList< EstanteriaSeccion > m_ListaSecciones;

	
	
	
	/** Constructor
	 * 
	 * @param a_Id				Identificador de la estantería
	 * @param a_TipoEstanteria	Tipo de estantería
	 * @param a_PosicionX		Coordenada X de la estantería
	 * @param a_PosicionY		Coordenada Y de la estantería
	 * @param a_RotacionXY		Rotación XY de la estantería
	 * 
	 */
	public Estanteria( 	short 			a_Id,
						TTipoEstanteria a_TipoEstanteria,
						float 			a_PosicionX, 
						float 			a_PosicionY, 
						float 			a_RotacionXY  ) 
	{
		this( a_Id, a_TipoEstanteria, 
				a_PosicionX, a_PosicionY, a_RotacionXY,
				new ArrayList< EstanteriaSeccion >() );
	}; // Estanteria
	
	
	/** Constructor
	 * 
	 * @param a_Id				Identificador de la estantería
	 * @param a_TipoEstanteria	Tipo de estantería
	 * @param a_PosicionX		Coordenada X de la estantería
	 * @param a_PosicionY		Coordenada Y de la estantería
	 * @param a_RotacionXY		Rotación XY de la estantería
	 * @param a_ListaSecciones  Lista de secciones que tiene la estantería
	 */
	public Estanteria( 	short 			a_Id,
						TTipoEstanteria a_TipoEstanteria,
						float 			a_PosicionX, 
						float 			a_PosicionY, 
						float 			a_RotacionXY, 
						ArrayList< EstanteriaSeccion > a_ListaSecciones ) 
	{
		
		m_Id= a_Id;
		m_TipoEstanteria= a_TipoEstanteria;
		m_PosicionX= a_PosicionX;
		m_PosicionY= a_PosicionY;
		m_RotacionXY= a_RotacionXY;
			
		m_ListaSecciones= a_ListaSecciones;
		
	} // end Estanteria


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
	 * @return the m_TipoEstanteria
	 */
	public TTipoEstanteria getTipoEstanteria( ) 
	{
		return m_TipoEstanteria;
	}


	/**
	 * @param m_TipoEstanteria the m_TipoEstanteria to set
	 */
	public void setTipoEstanteria( TTipoEstanteria a_TipoEstanteria ) 
	{
		this.m_TipoEstanteria= a_TipoEstanteria;
	}
	
	
	/**
	 * @return the m_PosicionX
	 */
	public float getPosicionX( ) 
	{
		return m_PosicionX;
	}


	/**
	 * @param m_PosicionX the m_PosicionX to set
	 */
	public void setPosicionX( float a_PosicionX ) 
	{
		this.m_PosicionX = a_PosicionX;
	}


	/**
	 * @return the m_PosicionY
	 */
	public float getPosicionY( ) 
	{
		return m_PosicionY;
	}


	/**
	 * @param m_PosicionY the m_PosicionY to set
	 */
	public void setPosicionY( float a_PosicionY ) 
	{
		this.m_PosicionY = a_PosicionY;
	}


	/**
	 * @return the m_RotacionXY
	 */
	public float getRotacionXY( ) 
	{
		return m_RotacionXY;
	}


	/**
	 * @param m_RotacionXY the m_RotacionXY to set
	 */
	public void setRotacionXY( float a_RotacionXY ) 
	{
		this.m_RotacionXY = a_RotacionXY;
	}
	
	
	
	
	/**
	 * @return the m_ListaSecciones
	 */
	public ArrayList<EstanteriaSeccion> getListaSecciones() {
		return m_ListaSecciones;
	}


	/**
	 * @param m_ListaSecciones the m_ListaSecciones to set
	 */
	public void setListaSecciones( ArrayList<EstanteriaSeccion> a_ListaSecciones ) 
	{
		this.m_ListaSecciones = a_ListaSecciones;
	}
	
	/**
	 * @param m_ListaSecciones the m_ListaSecciones to set
	 */
	public void addEstanteSeccion( EstanteriaSeccion a_Estante ) 
	{
		this.m_ListaSecciones.add( a_Estante );
	}

	
		 
	
	
} // // End class Estanteria
