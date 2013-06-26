package com.supermarket_frontoffice.recorrido_optimo.gl.comun;


/** @class GLVertice
 *  
 *  Clase que contiene los vértices de 
 *  
 * @author fjvegaf
 *
 */
public class GLVertice 
{

	
	float m_X;
	float m_Y;
	float m_Z;
	
	
	/** Constructor por defecto
	 * 
	 */
	public GLVertice( ) 
	{
		this( 0, 0, 0 );
	} // GLVertice
	
	
	/** Constructor
	 * 
	 * @param a_X
	 * @param a_Y
	 */
	public GLVertice( float a_X, float a_Y ) 
	{
		this( a_X, a_Y, 0 );
	} // GLVertice
	
	
	/** Constructor
	 * 
	 * @param a_X
	 * @param a_Y
	 * @param a_Z
	 */
	public GLVertice( float a_X, float a_Y, float a_Z ) 
	{
		m_X= a_X;
		m_Y= a_Y;
		m_Z= a_Z;
	} // GLVertice
	
	
	/**
	 * @return the m_X
	 */
	public float getX( ) 
	{
		return m_X;
	}


	/**
	 * @param m_X the m_X to set
	 */
	public void setX( float a_X ) 
	{
		this.m_X = a_X;
	}


	/**
	 * @return the m_Y
	 */
	public float getY( ) 
	{
		return m_Y;
	}


	/**
	 * @param m_Y the m_Y to set
	 */
	public void setY( float a_Y ) 
	{
		this.m_Y = a_Y;
	}


	/**
	 * @return the m_Z
	 */
	public float getZ( ) 
	{
		return m_Z;
	}


	/**
	 * @param m_Z the m_Z to set
	 */
	public void setZ( float a_Z ) 
	{
		this.m_Z = a_Z;
	}
	
} // GLVertice
