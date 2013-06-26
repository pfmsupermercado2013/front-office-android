package com.supermarket_frontoffice.modelo_datos;

import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLVertice;


/** @class ParedEdificioSupermercado
 * 
 * @author fjvegaf
 *
 */
public class ParedEdificio 
{
	
	private short 			m_Id;		//< Identificador de la pared
	private EsquinaEdificio m_V1; 		//< Coordenada superior izquierda de la pared
	private EsquinaEdificio m_V2; 		//< Coordenada superior derecha de la pared

	private float			m_Largo; //< Longitud de la pared (cm)
	//private float			m_Altura; 	//< Altura de la pared (cm)
	private float			m_Ancho;	//< Ancho de la pared (cm)
	
	
	
	/** Constructor por defecto
	 * 
	 */
	public ParedEdificio( ) 
	{
		
		this( (short)0, new EsquinaEdificio(), new EsquinaEdificio(), 40.f );
		
	} // ParedEdificio
	
	
	/** Constructor
	 * 
	 * @param a_V1
	 * @param a_V2
	 */
	public ParedEdificio( 	short 			a_Id,
							EsquinaEdificio a_V1,
							EsquinaEdificio a_V2  ) 
	{
		
		this( a_Id, a_V1, a_V2, 40.f );
		
	} // ParedEdificio
	
		
	/** Constructor
	 * 
	 * @param a_V1		Coordenada Superior izquierda de la pared
	 * @param a_V2		Coordenada Superior derecha de la pared
	 * @param a_Anchura Grosor de la pared
	 */
	public ParedEdificio( 	short 			a_Id,
							EsquinaEdificio a_V1,
							EsquinaEdificio a_V2,
							float			a_Ancho ) 
	{
		
		m_Id= a_Id;
		m_V1= a_V1;
		m_V2= a_V2;
		
		m_Largo= getModuloVertices( m_V1.getVertice(), m_V2.getVertice() ); 
		//m_Altura= m_V1.getVertice().getZ();
		m_Ancho= a_Ancho;
		
	} // ParedEdificio
	
	
	/**
	 * 
	 * @param a_V1
	 * @param a_V2
	 * @return
	 */
	public static float getModuloVertices( GLVertice a_V1, GLVertice a_V2 )
	{
		
		return (float)( Math.sqrt( 
					Math.pow( a_V2.getX() - a_V1.getX(), 2.f ) +
					Math.pow( a_V2.getY() - a_V1.getY(), 2.f ) ) );
	
	} // getModuloVertices

	
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
	 * @return the m_V1
	 */
	public EsquinaEdificio getV1() 
	{
		return m_V1;
	}


	/**
	 * @param m_V1 the m_V1 to set
	 */
	public void setV1( EsquinaEdificio a_V1 ) 
	{
		
		this.m_V1 = a_V1;
		m_Largo= getModuloVertices( m_V1.getVertice(), m_V2.getVertice() ); 
		
	} // setV1


	/**
	 * @return the m_V2
	 */
	public EsquinaEdificio getV2() 
	{
		return m_V2;
	}


	/**
	 * @param m_V2 the m_V2 to set
	 */
	public void setV2( EsquinaEdificio a_V2 ) 
	{
		this.m_V2 = a_V2;
		m_Largo= getModuloVertices( m_V1.getVertice(), m_V2.getVertice() );	
	}


	/**
	 * @return the m_Longitud
	 */
	public float getLargo() 
	{
		return m_Largo;
	}
	


	/**
	 * @return the m_Anchura
	 */
	public float getAncho() 
	{
		return m_Ancho;
	}


	/**
	 * @param m_Anchura the m_Anchura to set
	 */
	public void setAncho( float a_Ancho ) 
	{
		this.m_Ancho = a_Ancho;
	}
	
	
	/** Devuelve un String con toda la información de la clase
	 * 
	 */
	public String toString( )
	{
		
		return new String( "[[Pared Id=" + this.m_Id + "] [V1:" + this.m_V1.toString() + "][V2:" + this.m_V2.toString() + "] Largo= "+ this.m_Largo + "; Ancho= " + this.m_Ancho + " ]" );
	
	} // toString
	
	
} // ParedEdificio
