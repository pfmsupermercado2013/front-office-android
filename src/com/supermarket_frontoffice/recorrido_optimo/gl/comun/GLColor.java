package com.supermarket_frontoffice.recorrido_optimo.gl.comun;

/** @GLColor
 * 
 * @author fjvegaf
 *
 */
public class GLColor 
{
	
	private float m_Red;
	private float m_Green;	
	private float m_Blue;
	private float m_Alpha;
	
	



	/** Constructor
	 * 
	 * @param a_Green
	 * @param a_Red
	 * @param a_Blue
	 */
	public GLColor( float a_Red, 
					float a_Green, 
					float a_Blue,
					float a_Alpha )
	{
		
		m_Red= a_Red;
		m_Green= a_Green;
		m_Blue= a_Blue;
		m_Alpha= a_Alpha;
	} // GLColor
	
	
	/** Constructor
	 * 
	 * @param a_Green
	 * @param a_Red
	 * @param a_Blue
	 */
	public GLColor( float a_Red,
					float a_Green, 
					float a_Blue )
	{
		
		m_Red= a_Red;
		m_Green= a_Green;
		m_Blue= a_Blue;
		m_Alpha= 1.f;
	} // GLColor


	/**
	 * @return the m_Green
	 */
	public float getGreen() 
	{
		return m_Green;
	}


	/**
	 * @param m_Green the m_Green to set
	 */
	public void setGreen( float a_Green ) 
	{
		this.m_Green= a_Green;
	}


	/**
	 * @return the m_Red
	 */
	public float getRed() 
	{
		return m_Red;
	}


	/**
	 * @param m_Red the m_Red to set
	 */
	public void setRed( float a_Red ) 
	{
		this.m_Red= a_Red;
	}


	/**
	 * @return the m_Blue
	 */
	public float getBlue() 
	{
		return m_Blue;
	}


	/**
	 * @param m_Blue the m_Blue to set
	 */
	public void setBlue( float a_Blue ) 
	{
		this.m_Blue= a_Blue;
	}
	
	
	/**
	 * @return the m_Alpha
	 */
	public float getAlpha() 
	{
		return m_Alpha;
	}


	/**
	 * @param m_Alpha the m_Alpha to set
	 */
	public void setAlpha( float a_Alpha ) 
	{
		this.m_Alpha = a_Alpha;
	}
	
	
	
} // end class GLColor
