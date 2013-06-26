package com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

import com.supermarket_frontoffice.modelo_datos.EstanteriaEstante;
import com.supermarket_frontoffice.modelo_datos.EstanteriaSeccion;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLObject;


/** @class GLEstanteriaSeccion
 *  @brief Clase que dibuja todo una secci�n de la estanter�a.
 *  
 *  La estanter�a se dibuja en funci�n de los valores Alto, Ancho y Largo, obtenidos para cada secci�n en la Base de Datos
 *  del sistema. Cada secci�n esta identificado con un id relativo a la estanter�a. 
 * 
 * @author fjvegaf
 *
 */
public abstract class GLEstanteriaSeccion extends GLObject
{ 
	

	protected EstanteriaSeccion 					m_EstanteriaSeccion;		///< Contiene todos los datos de la secci�n
	protected ArrayList< GLEstanteriaEstante > 	m_ListaGLEstanteriaEstante;
	
	//private float m_YRotate;
	


		
	/** Constructor
	 * 	
	 * @param a_Id		Identificador de la secci�n de la estanter�a
	 * @param a_Alto	Altura total de la secci�n de la estanter�a
	 * @param a_Ancho	Anchura de la base de la secci�n de la estanter�a.
	 * @param a_Largo	Longitud de la secci�n.
	 */
	
	/** Constructor
	 * 
	 * @param a_EstanteriaSeccion	Datos de la Secci�n de la estanter�a
	 */
	public GLEstanteriaSeccion( EstanteriaSeccion a_EstanteriaSeccion,
								float 				a_Vertices[], 
								float 				a_Normales[],
								short 				a_Caras[],
								float				a_CoordTextura[],
								float 				a_Colores[] )
	{
		
		super( a_Vertices, a_Normales, a_Caras, a_CoordTextura, a_Colores );

		
		
		
		m_EstanteriaSeccion= a_EstanteriaSeccion;

		//m_YRotate= 0.f;
		

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
		
	} // GLEstanteriaSeccion
	
	
	
	public abstract void draw( GL10 a_Gl );



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

	
	
	
} // GLEstanteriaSeccion
