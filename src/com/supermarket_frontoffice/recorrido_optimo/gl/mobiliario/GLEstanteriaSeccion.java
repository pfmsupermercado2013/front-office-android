package com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;

import android.util.Log;

import com.supermarket_frontoffice.modelo_datos.EstanteriaEstante;
import com.supermarket_frontoffice.modelo_datos.EstanteriaSeccion;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLBaseObject;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLVertice;


/** @class GLEstanteriaSeccion
 *  @brief Clase que dibuja todo una sección de la estantería.
 *  
 *  La estantería se dibuja en función de los valores Alto, Ancho y Largo, obtenidos para cada sección en la Base de Datos
 *  del sistema. Cada sección esta identificado con un id relativo a la estantería. 
 * 
 * @author fjvegaf
 *
 */
public abstract class GLEstanteriaSeccion extends GLBaseObject
{ 
	
	private static final String 					TAG= "GLEstanteriaSeccion";

	protected 	EstanteriaSeccion 					m_EstanteriaSeccion;		///< Contiene todos los datos de la sección
	protected 	ArrayList< GLEstanteriaEstante > 	m_ListaGLEstanteriaEstante;
	protected	boolean								m_EstaSeleccionada;			///< Si se activa este flag se selecciona la sección cambiando de color 
	protected 	GLVertice							m_CoordenadaRealSeccion;	///< Posición real en el mapa en el que se encuentra localizada la seccion
	
	
	protected float 								m_ColoresSeleccion[];
	protected FloatBuffer 							m_ColorSeleccionBuffer;
	
	protected GLFlechaLocalizacionProducto			m_GLFlechaLocalizacionProducto;	

	
	/** Constructor
	 * 
	 * @param a_EstanteriaSeccion		
	 * @param a_Vertices
	 * @param a_Normales
	 * @param a_Caras
	 * @param a_CoordTextura
	 * @param a_Colores
	 * @param a_ColoresSeleccion
	 */
	public GLEstanteriaSeccion( EstanteriaSeccion   a_EstanteriaSeccion,
								float 				a_Vertices[], 
								float 				a_Normales[],
								short 				a_Caras[],
								float				a_CoordTextura[],
								float 				a_Colores[],
								float 				a_ColoresSeleccion[] )
	{
		
		this( a_EstanteriaSeccion, a_Vertices, a_Normales, a_Caras, a_CoordTextura, a_Colores, false );
		
		
		
		this.setColoresSeleccion( a_ColoresSeleccion );
		
	} /// GLEstanteriaSeccion
	
	
	/** Constructor
	 * 	
	 * @param a_Id		Identificador de la sección de la estantería
	 * @param a_Alto	Altura total de la sección de la estantería
	 * @param a_Ancho	Anchura de la base de la sección de la estantería.
	 * @param a_Largo	Longitud de la sección.
	 */
	public GLEstanteriaSeccion( EstanteriaSeccion a_EstanteriaSeccion,
								float 				a_Vertices[], 
								float 				a_Normales[],
								short 				a_Caras[],
								float				a_CoordTextura[],
								float 				a_Colores[],
								boolean 			a_EstaSeleccionada )
	{
		
		super( a_Vertices, a_Normales, a_Caras, a_CoordTextura, a_Colores );

		m_EstanteriaSeccion= a_EstanteriaSeccion;
		m_ListaGLEstanteriaEstante= new ArrayList< GLEstanteriaEstante >();
		ArrayList< EstanteriaEstante > listaEstantes= a_EstanteriaSeccion.getListaEstantes();
		
		boolean isPrimerEstante= true;
		for ( EstanteriaEstante estante: listaEstantes ) {
			
			if ( isPrimerEstante ) 
			{
				
				m_ListaGLEstanteriaEstante.add( new GLEstanteriaEstanteBase( estante ) );
				isPrimerEstante= false;
			}
			else {
				
				m_ListaGLEstanteriaEstante.add( new GLEstanteriaEstanteNormal( estante ) );
			}
		}
		
		
		m_EstaSeleccionada= a_EstaSeleccionada;
		
		m_CoordenadaRealSeccion= null;
		
		m_ColoresSeleccion= null;
		m_ColorSeleccionBuffer= null;
		
		m_GLFlechaLocalizacionProducto= null;
		
	
	} // GLEstanteriaSeccion
	
	


	/**
	 * 
	 */
	public void draw( GL10 a_Gl ) 
	{
		 		
		
//		a_Gl.glRotatef( m_YRotate, 0, 1, 0 );
//		
//		m_YRotate+= 4.f;
		
		// Contra las agujas del reloj		 
		a_Gl.glFrontFace(GL10.GL_CCW);
		 
//		// Habilitar el sacrificio de caras a ocultar		 
//		a_Gl.glEnable(GL10.GL_CULL_FACE);
//		 
//		// Aca se indica que cara se sacrificara, en este caso, la de atras		 
//		a_Gl.glCullFace(GL10.GL_BACK);
		 
		// Habilitar el buffer de vertices para la escritura y cuales se usaran para el renderizado
		a_Gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		 
		// Especifica la localizacion y el formato de los datos de un array de vertices a utilizar para el renderizado
		//a_Gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
		a_Gl.glVertexPointer(3, GL10.GL_FLOAT, 0, m_VertexBuffer );
		a_Gl.glNormalPointer( GL10.GL_FLOAT, 0, m_NormalsBuffer );
		a_Gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, m_TexCoordsBuffer );

		
		// Habilita el buffer para el color del grafico		 
		a_Gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		 
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
		
		float totalAltura= 0.f;
		for ( GLEstanteriaEstante glEstante: m_ListaGLEstanteriaEstante ) {
			
			glEstante.draw( a_Gl );
			a_Gl.glTranslatef( 0.f, glEstante.getEstante().getAlto() / m_AspectRatio, 0.f );
			totalAltura += glEstante.getEstante().getAlto() / m_AspectRatio;
		}
		
		
		if ( this.m_EstaSeleccionada ) {
			
			a_Gl.glTranslatef(  this.m_EstanteriaSeccion.getAnchoBase() / ( 2.f * m_AspectRatio ), 
								40.f / m_AspectRatio, 
								- this.m_EstanteriaSeccion.getLargo() / ( 2.f * m_AspectRatio ) 
								);
			
			this.m_GLFlechaLocalizacionProducto.draw( a_Gl );
			
			a_Gl.glTranslatef(  -this.m_EstanteriaSeccion.getAnchoBase() / ( 2.f * m_AspectRatio), 
					-40.f / m_AspectRatio, 
					this.m_EstanteriaSeccion.getLargo() / ( 2.f * m_AspectRatio ) 
					);	
		} // end  if
		
		
		
		
		a_Gl.glTranslatef( 0.f, -totalAltura, 0.f );
		
		
		
	} // end draw

	
	/**  Selecciona la sección especificada dentro de la estantería
	 * 
	 * @param a_SeccionId
	 * @return
	 */
	public boolean localizarProducto(   short a_EstanteId, 
										boolean a_FlagSeleccion )
	{
		
		if ( m_ListaGLEstanteriaEstante.isEmpty() ) {
			
			return false;
		}		
		
		for ( GLEstanteriaEstante glEstanteriaEstante: m_ListaGLEstanteriaEstante ) {
			
			if ( glEstanteriaEstante.getEstante().getId() == a_EstanteId ) {
				
				//Log.d( TAG, "Localizado estante con el Id: " + glEstanteriaEstante.getEstante().getId() );
				glEstanteriaEstante.setEstaSeleccionada( a_FlagSeleccion );
				return true;
			}
		}		
		return false;
		
	} // seleccionarSeccion
	
	
	/**  Selecciona la sección especificada dentro de la estantería
	 * 
	 * @param a_SeccionId
	 * @return
	 */
	public boolean deslocalizarTodosProductos( )
	{
		
		if ( m_ListaGLEstanteriaEstante.isEmpty() ) {
			
			return false;
		}		
		
		for ( GLEstanteriaEstante glEstanteriaEstante: m_ListaGLEstanteriaEstante ) {
			
			glEstanteriaEstante.setEstaSeleccionada( false );
		}		
		return true;
		
	} // seleccionarSeccion
	
	
	



	

	/**
	 * @return the m_EstanteriaSeccion
	 */
	public EstanteriaSeccion getEstanteriaSeccion( ) 
	{
		return m_EstanteriaSeccion;
	}


	/**
	 * @param m_EstanteriaSeccion the m_EstanteriaSeccion to set
	 */
	public void setEstanteriaSeccion( EstanteriaSeccion a_EstanteriaSeccion ) 
	{
		this.m_EstanteriaSeccion= a_EstanteriaSeccion;
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
	
	
	/**
	 * @return the m_CoordenadaRealSeccion
	 */
	public GLVertice getCoordenadaRealSeccion() 
	{
		return m_CoordenadaRealSeccion;
	}


	/**
	 * @param m_CoordenadaRealSeccion the m_CoordenadaRealSeccion to set
	 */
	public void setCoordenadaRealSeccion( GLVertice a_CoordenadaRealSeccion ) 
	{
		this.m_CoordenadaRealSeccion= a_CoordenadaRealSeccion; 
	}
	
	/**
	 * @return the m_GLFlechaLocalizacionProducto
	 */
	public GLFlechaLocalizacionProducto getGLFlechaLocalizacionProducto( ) 
	{
		
		return m_GLFlechaLocalizacionProducto;
		
	} // getGLFlechaLocalizacionProducto


	/**
	 * @param m_GLFlechaLocalizacionProducto the m_GLFlechaLocalizacionProducto to set
	 */
	public void setGLFlechaLocalizacionProducto( GLFlechaLocalizacionProducto a_GLFlechaLocalizacionProducto ) 
	{
		
		this.m_GLFlechaLocalizacionProducto= a_GLFlechaLocalizacionProducto;
		
	} // setGLFlechaLocalizacionProducto
	
} // GLEstanteriaSeccion
