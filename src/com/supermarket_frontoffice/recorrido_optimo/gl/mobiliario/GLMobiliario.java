package com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

import android.util.Log;

import com.supermarket_frontoffice.modelo_datos.Estanteria;
import com.supermarket_frontoffice.modelo_datos.Mobiliario;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLObject;


/** @class GLMobiliario
 * 
 * @author fjvegaf
 *
 */
public class GLMobiliario extends GLObject
{
	
	private static final String TAG= "GLMobiliario";

	Mobiliario 					m_Mobiliario;			///< Datos de todo el mobiliario del supermercado
	ArrayList< GLEstanteria > 	m_GLEstanterias;		///< Objetos OpenGL de las estanterias
	
//	/** Constructor copia
//	 * 
//	 */
//	public GLMobiliario( )
//	{	
//		this( null );
//		
//	} // GLMobiliario
	
	
	/**
	 * 
	 * @param a_GLMobiliario
	 */
	public GLMobiliario( Mobiliario a_Mobiliario )
	{
		super();
		
		m_Mobiliario= a_Mobiliario;
		m_GLEstanterias= new ArrayList< GLEstanteria >();
		
		this.createGLObject();
		
	} // GLMobiliario
	
	
	/** Crea todos los objetos opengl que intervienen en el mobiliario
	 * 
	 * @return
	 */
	public boolean createGLObject()
	{
		
		Log.d( TAG, "Creando los objetos OpenGL del mobiliario " );
		
		
		///
		/// Creación de la estanterías
		///
		ArrayList< Estanteria > listaEstanteria= m_Mobiliario.getListaEstanteria();
		
		
		for ( Estanteria estanteria: listaEstanteria ) {
			
			switch ( estanteria.getTipoEstanteria() ) {
			
				case EstanteriaSimple:
					
					m_GLEstanterias.add( new GLEstanteriaSimple( estanteria ) );
					break;
				
				case EstanteriaDoble:	
					m_GLEstanterias.add( new GLEstanteriaDoble( estanteria ) );
					break;
					
				default:
					break;
				
			};
			
		}
		
		return true;
	} // createGLObject
	
	
	/** Dibuja la estantería
	 * 
	 * @param a_Gl
	 */
	public void draw( GL10 a_Gl )
	{
		
		
		for ( GLEstanteria estanteria: m_GLEstanterias ) {
			
			//Log.d( "GLSupermarketMapRendered", "Estanteria " + contEstanteria++ );
			estanteria.draw( a_Gl );
		}
		
		//m_Seccion.draw( a_Gl );
	} // draw
	
} // GLMobiliario
