package com.supermarket_frontoffice.recorrido_optimo.supermarket_map;

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
public abstract class GLObject 
{
	
	

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
	
	
	
	/** Constructor
	 * 
	 * @param a_Vertices
	 * @param a_Normales
	 * @param a_Caras
	 * @param a_CoordTextura
	 * @param a_Colores
	 */
	public GLObject( 	float a_Vertices[], 
						float a_Normales[],
						short a_Caras[],
						float a_CoordTextura[],
						float a_Colores[] ) 
	{
		
		m_AspectRatio= 100.f;
		
		m_Vertices= a_Vertices;
		

		for ( int i= 0; i < m_Vertices.length; ++i ) {
			
			m_Vertices[i] /= m_AspectRatio;
		}
		
		m_Normales= a_Normales;
		m_Caras= a_Caras;
		m_CoordTextura= a_CoordTextura;
		m_Colores= a_Colores;
			
		
		// un float es de 4 bytes, por lo que multiplicaremos el numero de vertices por 4 
		ByteBuffer vbb= ByteBuffer.allocateDirect( m_Vertices.length * 4 );
		 
		vbb.order(ByteOrder.nativeOrder());	 
		m_VertexBuffer = vbb.asFloatBuffer();	 
		m_VertexBuffer.put( m_Vertices );	 
		m_VertexBuffer.position(0);
		
		
		// un float es de 4 bytes, por lo que multiplicaremos el numero de vertices por 4 
		ByteBuffer ibb = ByteBuffer.allocateDirect( m_Normales.length * 4 );
		 
		ibb.order(ByteOrder.nativeOrder());	 
		m_NormalsBuffer = ibb.asFloatBuffer();	 
		m_NormalsBuffer.put( m_Normales );	 
		m_NormalsBuffer.position(0);
		
		
		// un short es de 2 bytes, por lo que multiplicaremos el numero de vertices por 2 
		ByteBuffer ibb2 = ByteBuffer.allocateDirect( m_Caras.length * 2);
		 
		ibb2.order(ByteOrder.nativeOrder());	 
		m_FacesBuffer = ibb2.asShortBuffer();	 
		m_FacesBuffer.put( m_Caras );	 
		m_FacesBuffer.position(0);
		
		
		ByteBuffer cbb = ByteBuffer.allocateDirect( m_CoordTextura.length * 4);	 
		cbb.order( ByteOrder.nativeOrder() );	 
		m_TexCoordsBuffer = cbb.asFloatBuffer();	 
		m_TexCoordsBuffer.put( m_CoordTextura );		 
		m_TexCoordsBuffer.position(0);
		
		
		ByteBuffer colorbb = ByteBuffer.allocateDirect( m_Colores.length * 4);	 
		colorbb.order( ByteOrder.nativeOrder() );	 
		m_ColorBuffer = colorbb.asFloatBuffer();	 
		m_ColorBuffer.put( m_Colores );		 
		m_ColorBuffer.position(0);
		
	} // GLObject
	
	
	/** Método abstracto que debe redefinir las clases que lo hereran
	 * 
	 * @param a_Gl
	 */
	public abstract void draw( GL10 a_Gl );
	
	
} // end class GLObject
