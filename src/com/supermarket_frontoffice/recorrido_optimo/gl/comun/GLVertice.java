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

	
//	/** Comprueba que el vector  es menos que el vector pasado.
//	 * 
//	 * @param a_Vertice
//	 * @return Devuelve true si este vector es menor que el vector pasado y false en caso contrario
//	 */
//	public boolean isMinus( GLVertice a_Vertice )
//	{
//		
//		if ( this.isEqual( a_Vertice ) ) {
//			
//			return false;
//		}
//		
//		if ( ( m_X < a_Vertice.getX() ) ) {
//			
//		}
//		
//		return true;
//	} //
	
	
	/** 
	 * 
	 * @param a_Vertice
	 * @return
	 */
	public float module( GLVertice a_Vertice )
	{
		
	}
	
	
	
	/** Comprueba que el vector  es igual que el vector pasado.
	 * 
	 * @param a_Vertice
	 * @return Devuelve true si este vector es igual que el vector pasado y false en caso contrario
	 */
	public boolean isEqual( GLVertice a_Vertice )
	{
		
		if ( ( m_X < a_Vertice.getX() ) && ( m_Y < a_Vertice.getY() ) && ( m_Z < a_Vertice.getZ() )  ) {
			
			return true;
		}
		
		return false;
	} //
	
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
	 * @param m_X the m_X to set
	 */
	public void incrementX( float a_X ) 
	{
		this.m_X += a_X;
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
	 * @param m_X the m_X to set
	 */
	public void incrementY( float a_Y ) 
	{
		this.m_Y += a_Y;
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
	
	
	/**
	 * @param m_X the m_X to set
	 */
	public void incrementZ( float a_Z ) 
	{
		this.m_Z += a_Z;
	}
	
	/** Devuelve un String con toda la información de la clase
	 * 
	 */
	public String toString( )
	{

		
		return new String( "(" + m_X + ", " + m_Y + ", " + m_Z + ")" );
	
	} // toString
	
} // GLVertice
