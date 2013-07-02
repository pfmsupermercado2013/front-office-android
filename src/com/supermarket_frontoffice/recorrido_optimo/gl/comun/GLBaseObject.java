package com.supermarket_frontoffice.recorrido_optimo.gl.comun;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;


/** @class GLObject
 *  @brief Clase abstracta que almacena los datos necesarios para dibujar un objeto en la escena
 * 
 * @author fjvegaf
 *
 */
public abstract class GLBaseObject 
{
	
	private static final String TAG= "GLBaseObject";

	protected float 		m_AspectRatio;
	
	protected float 		m_Vertices[];
	protected float 		m_Normales[];
	protected short 		m_Caras[];
	protected float			m_CoordTextura[];
	protected float 		m_Colores[];
	
	protected FloatBuffer 	m_VertexBuffer;
	protected FloatBuffer 	m_NormalsBuffer;	 
	protected FloatBuffer 	m_TexCoordsBuffer;	
	protected FloatBuffer 	m_ColorBuffer;	 
	protected ShortBuffer 	m_FacesBuffer;  /// caras 
	
	
	protected GLColor 		m_DefaultColor;  /// Color de la baldosa
	
	
	
	/** Constructor por defecto
	 * 
	 */
	public GLBaseObject( ) 
	{
		this( null, null, null, null, null );
	} // GLObject
	
	/** Constructor
	 * 
	 * @param a_Vertices
	 * @param a_Normales
	 * @param a_Caras
	 * @param a_CoordTextura
	 * @param a_Colores
	 */
	public GLBaseObject( 	float a_Vertices[], 
							float a_Normales[],
							short a_Caras[] ) 
	{
		this( a_Vertices, a_Normales, a_Caras, null, null );
	} // GLObject
	
	
	/** Constructor
	 * 
	 * @param a_Vertices
	 * @param a_Normales
	 * @param a_Caras
	 * @param a_CoordTextura
	 * @param a_Colores
	 */
	public GLBaseObject( 	float a_Vertices[], 
							float a_Normales[],
							short a_Caras[],
							float a_CoordTextura[],
							float a_Colores[] ) 
	{
		
		m_AspectRatio= 100.f;
		
		this.setVertices( a_Vertices );	
		this.setNormales( a_Normales );
		this.setCaras( a_Caras );
		this.setCoordTextura( a_CoordTextura );	
		this.setColores( a_Colores );
		
		m_DefaultColor= null;
		
	} // GLObject
	
	
	/**
	 * @return the m_Vertices
	 */
	public float[] getVertices() 
	{
		return m_Vertices;
	}

	/**
	 * @param m_Vertices the m_Vertices to set
	 */
	public void setVertices( float[] a_Vertices ) 
	{
		
		m_Vertices = a_Vertices;
		
		if ( m_Vertices != null ) {
			
			for ( int i= 0; i < m_Vertices.length; ++i ) {
				
				m_Vertices[i] /= m_AspectRatio;
			}
					
			// un float es de 4 bytes, por lo que multiplicaremos el numero de vertices por 4 
			ByteBuffer vbb= ByteBuffer.allocateDirect( m_Vertices.length * 4 );
			 
			vbb.order(ByteOrder.nativeOrder());	 
			m_VertexBuffer = vbb.asFloatBuffer();	 
			m_VertexBuffer.put( m_Vertices );	 
			m_VertexBuffer.position(0);
		}
		else {
			m_VertexBuffer=  null;
		}
	}
	
	
	
	/**
	 * @return the m_Normales
	 */
	public float[] getNormales() 
	{
		return m_Normales;
	}

	/**
	 * @param m_Normales the m_Normales to set
	 */
	public void setNormales( float[] a_Normales ) 
	{
		m_Normales = a_Normales;
		
		if ( m_Normales != null ) {
			
			
			// un float es de 4 bytes, por lo que multiplicaremos el numero de vertices por 4 
			ByteBuffer ibb = ByteBuffer.allocateDirect( m_Normales.length * 4 );
			 
			ibb.order(ByteOrder.nativeOrder());	 
			m_NormalsBuffer = ibb.asFloatBuffer();	 
			m_NormalsBuffer.put( m_Normales );	 
			m_NormalsBuffer.position(0);
		}
		else {
			
			m_NormalsBuffer= null;
		}
	} // setNormales



	/**
	 * @return the m_Caras
	 */
	public short[] getCaras() 
	{
		return m_Caras;
	}

	/**
	 * @param m_Caras the m_Caras to set
	 */
	public void setCaras( short[] a_Caras ) 
	{
		
		m_Caras = a_Caras;
		
		if ( m_Caras != null ) {
			
			// un short es de 2 bytes, por lo que multiplicaremos el numero de vertices por 2 
			ByteBuffer ibb2 = ByteBuffer.allocateDirect( m_Caras.length * 2);
			 
			ibb2.order(ByteOrder.nativeOrder());	 
			m_FacesBuffer = ibb2.asShortBuffer();	 
			m_FacesBuffer.put( m_Caras );	 
			m_FacesBuffer.position(0);
		}
		else {

			m_FacesBuffer= null;
		}
	} // setCaras


	/**
	 * @return the m_CoordTextura
	 */
	public float[] getCoordTextura() 
	{
		return m_CoordTextura;
	}

	/**
	 * @param m_CoordTextura the m_CoordTextura to set
	 */
	public void setCoordTextura( float[] a_CoordTextura ) 
	{
		
		m_CoordTextura = a_CoordTextura;
		
		if ( m_CoordTextura != null ) {
			
			
			ByteBuffer cbb = ByteBuffer.allocateDirect( m_CoordTextura.length * 4);	 
			cbb.order( ByteOrder.nativeOrder() );	 
			m_TexCoordsBuffer = cbb.asFloatBuffer();	 
			m_TexCoordsBuffer.put( m_CoordTextura );		 
			m_TexCoordsBuffer.position(0);
		}
		else {
			
			m_TexCoordsBuffer= null;
		}
	}


	/**
	 * @return the m_Colores
	 */
	public float[] getColores() {
		
		return m_Colores;
	}

	/**
	 * @param m_Colores the m_Colores to set
	 */
	public void setColores( float[] a_Colores ) 
	{
		
		m_Colores= a_Colores;
		
		if ( m_Colores != null ) {
			
			ByteBuffer colorbb = ByteBuffer.allocateDirect( m_Colores.length * 4 );	 
			colorbb.order( ByteOrder.nativeOrder() );	 
			m_ColorBuffer = colorbb.asFloatBuffer();	 
			m_ColorBuffer.put( m_Colores );		 
			m_ColorBuffer.position(0);
		}
		else {
			
			m_ColorBuffer= null;
		}
		
	} // setColores

	
//	/** Dibuja los elementos que compones
//	 * 
//	 * @param a_Gl
//	 */
//	public void drawElements( GL10 a_Gl )
//	{
//		
//	} // drawElements

	
	/** Método abstracto que debe redefinir las clases que lo hereran
	 * 
	 * @param a_Gl
	 */
	public abstract void draw( GL10 a_Gl );
	
	
	/**
	 * @return the m_DefaultColor
	 */
	public GLColor getDefaultColor( ) 
	{
		return m_DefaultColor;
	} // getDefaultColor
	

	/**
	 * @param m_DefaultColor the m_DefaultColor to set
	 */
	public void setDefaultColor( GLColor a_DefaultColor )  
	{
		this.m_DefaultColor= a_DefaultColor;
	} // setDefaultColor
	
	
} // end class GLObject
