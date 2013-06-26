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
 *  @brief Clase que dibuja todo una sección de la estantería.
 *  
 *  La estantería se dibuja en función de los valores Alto, Ancho y Largo, obtenidos para cada sección en la Base de Datos
 *  del sistema. Cada sección esta identificado con un id relativo a la estantería. 
 * 
 * @author fjvegaf
 *
 */
public abstract class GLEstanteriaSeccion extends GLObject
{ 
	

	protected EstanteriaSeccion 					m_EstanteriaSeccion;		///< Contiene todos los datos de la sección
	protected ArrayList< GLEstanteriaEstante > 	m_ListaGLEstanteriaEstante;
	
	//private float m_YRotate;
	


		
	/** Constructor
	 * 	
	 * @param a_Id		Identificador de la sección de la estantería
	 * @param a_Alto	Altura total de la sección de la estantería
	 * @param a_Ancho	Anchura de la base de la sección de la estantería.
	 * @param a_Largo	Longitud de la sección.
	 */
	
	/** Constructor
	 * 
	 * @param a_EstanteriaSeccion	Datos de la Sección de la estantería
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
