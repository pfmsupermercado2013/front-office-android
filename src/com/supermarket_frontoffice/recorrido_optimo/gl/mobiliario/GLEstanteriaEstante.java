package com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario;


import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;
import com.supermarket_frontoffice.modelo_datos.EstanteriaEstante;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLBaseObject;


/** Clase abstracta que define una interfaz para los diferenets tipos de Estantes
 * 
 * @author fjvegaf
 *
 */
public abstract class GLEstanteriaEstante extends GLBaseObject
{

	
	private 	EstanteriaEstante 	m_Estante;
	protected	boolean			  	m_EstaSeleccionada;			///< Si se activa este flag se selecciona la sección cambiando de color 
	
	protected 	float 				m_ColoresSeleccion[];
	protected 	FloatBuffer 		m_ColorSeleccionBuffer;
	
	
	/** Constructor
	 * 
	 * @param a_Estante
	 * @param a_Vertices
	 * @param a_Normales
	 * @param a_Caras
	 * @param a_CoordTextura
	 * @param a_Colores
	 */
	public GLEstanteriaEstante( EstanteriaEstante 	a_Estante,
								float 				a_Vertices[], 
								float 				a_Normales[],
								short 				a_Caras[],
								float				a_CoordTextura[],
								float 				a_Colores[],
								float 				a_ColoresSeleccion[] )
	{
		
		this( a_Estante, a_Vertices, a_Normales, a_Caras, a_CoordTextura, a_Colores, false );
		this.setColoresSeleccion( a_ColoresSeleccion );
	} // GLEstanteriaEstante
	
	
	/** Constructor
	 * 
	 * @param a_Estante
	 * @param a_Vertices
	 * @param a_Normales
	 * @param a_Caras
	 * @param a_CoordTextura
	 * @param a_Colores
	 * @param a_EstaSeleccionada
	 */
	public GLEstanteriaEstante( EstanteriaEstante 	a_Estante,
								float 				a_Vertices[], 
								float 				a_Normales[],
								short 				a_Caras[],
								float				a_CoordTextura[],
								float 				a_Colores[],
								boolean 			a_EstaSeleccionada )
	{
		
		super( a_Vertices, a_Normales, a_Caras, a_CoordTextura, a_Colores );
		
		m_Estante= a_Estante;
		m_EstaSeleccionada= a_EstaSeleccionada;
		
	} // GLEstanteriaEstante
	
	
	/**
	 * 
	 * @param a_Gl
	 */
	public void draw( GL10 a_Gl )
	{
		
		
		// Contra las agujas del reloj		 
		a_Gl.glFrontFace(GL10.GL_CCW);
		 
//		// Habilitar el sacrificio de caras a ocultar		 
//		a_Gl.glEnable(GL10.GL_CULL_FACE);
//		 
//		// Aca se indica que cara se sacrificara, en este caso, la de atras		 
//		a_Gl.glCullFace(GL10.GL_BACK);
		 
		// Habilitar el buffer de vertices para la escritura y cuales se usaran para el renderizado
		a_Gl.glEnableClientState( GL10.GL_VERTEX_ARRAY );
		 
		// Especifica la localizacion y el formato de los datos de un array de vertices a utilizar para el renderizado
		//a_Gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
		a_Gl.glVertexPointer(3, GL10.GL_FLOAT, 0, m_VertexBuffer );
		a_Gl.glNormalPointer( GL10.GL_FLOAT, 0, m_NormalsBuffer );
		a_Gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, m_TexCoordsBuffer );

		
		// Habilita el buffer para el color del grafico		 
		a_Gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		 
		// Señala donde se encuentra el buffer del color		 
		//a_Gl.glColorPointer(4, GL10.GL_FLOAT, 0, m_ColorBuffer );
		
		//a_Gl.glColorPointer(4, GL10.GL_FLOAT, 0, super.m_ColorBuffer );
		if ( !this.m_EstaSeleccionada ) {
			
			// Señala donde se encuentra el buffer del color		 
			a_Gl.glColorPointer(4, GL10.GL_FLOAT, 0, super.m_ColorBuffer );
		}
		else {
			
			
			// Señala donde se encuentra el buffer del color		 
			a_Gl.glColorPointer(4, GL10.GL_FLOAT, 0, this.m_ColorSeleccionBuffer );
		}
		
		
		 
		//Dibujamos las superficies		 
		//a_Gl.glDrawElements( GL10.GL_TRIANGLE_STRIP, m_Caras.length, GL10.GL_UNSIGNED_SHORT, m_IndexBuffer );
		a_Gl.glDrawElements( GL10.GL_TRIANGLES, m_Caras.length, GL10.GL_UNSIGNED_SHORT, m_FacesBuffer );
		
		// draw data
		//a_Gl.glDrawArrays( GL10.GL_TRIANGLES, 0, m_GLEstanteriaExample.m_Estanteria_NumVerts );
		
		// Desactiva el buffer de los vertices		 
		a_Gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		 
		//Desactiva la caracteristica de sacrificios de las caras		 
		a_Gl.glDisable(GL10.GL_CULL_FACE);
		 
		// Desahilita el buffer del color		 
		a_Gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		
	} // draw
	
	
	
	/**
	 * @return the m_Estante
	 */
	public EstanteriaEstante getEstante( ) 
	{
		return m_Estante;
	}


	/**
	 * @param m_Estante the m_Estante to set
	 */
	public void setEstante( EstanteriaEstante a_Estante ) 
	{
		this.m_Estante = a_Estante;
	}
	
	
	/**
	 * @return the m_EstaSeleccionada
	 */
	public boolean isEstaSeleccionada( ) 
	{
		return m_EstaSeleccionada;
	}


	/**
	 * @param m_EstaSeleccionada the m_EstaSeleccionada to set
	 */
	public void setEstaSeleccionada( boolean a_EstaSeleccionada ) 
	{
		this.m_EstaSeleccionada= a_EstaSeleccionada;
	} 
	
	
	/**
	 * @return the m_Colores
	 */
	public float[] getColoresSeleccion() 
	{
		
		return m_ColoresSeleccion;
	}

	/**
	 * @param m_Colores the m_Colores to set
	 */
	public void setColoresSeleccion( float[] a_ColoresSeleccion ) 
	{
		
		m_ColoresSeleccion= a_ColoresSeleccion;
		
		if ( m_ColoresSeleccion != null ) {
			
			ByteBuffer colorbb = ByteBuffer.allocateDirect( m_ColoresSeleccion.length * 4 );	 
			colorbb.order( ByteOrder.nativeOrder() );	 
			m_ColorSeleccionBuffer = colorbb.asFloatBuffer();	 
			m_ColorSeleccionBuffer.put( m_ColoresSeleccion );		 
			m_ColorSeleccionBuffer.position(0);
		}
		else {
			
			m_ColorSeleccionBuffer= null;
		}
		
	} // setColoresSeleccion
		
	
} // GLEstanteriaEstante
