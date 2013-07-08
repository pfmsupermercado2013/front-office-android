package com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.util.Log;

import com.supermarket_frontoffice.modelo_datos.Estanteria;
import com.supermarket_frontoffice.modelo_datos.LocalizacionProducto;
import com.supermarket_frontoffice.modelo_datos.Mobiliario;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLBaseObject;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLVertice;


/** @class GLMobiliario
 * 
 * @author fjvegaf
 *
 */
public class GLMobiliario extends GLBaseObject
{
	
	private static final String TAG= "GLMobiliario";

	private Mobiliario 					m_Mobiliario;							///< Datos de todo el mobiliario del supermercado
	private ArrayList< GLEstanteria > 	m_GLEstanterias;						///< Objetos OpenGL de las estanterias
	
	private GLMuebleCajaSupermercado    m_GLMuebleCajaSupermercado;  			///< Mueble de la caja del supermercado
	
	private GLFlechaLocalizacionProducto	m_GLFlechaLocalizacionProducto;	
	
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
	public GLMobiliario( Context a_Context, Mobiliario a_Mobiliario )
	{
		
		super();
		
		m_Mobiliario= a_Mobiliario;
		m_GLEstanterias= new ArrayList< GLEstanteria >();
				
		m_GLMuebleCajaSupermercado= new GLMuebleCajaSupermercado( a_Context, new GLVertice( 300.f / 100.f, -40.f / 100.f, 0.f ), 90.f );
		m_GLFlechaLocalizacionProducto= new GLFlechaLocalizacionProducto( a_Context,  new GLVertice( 350.f / 100.f, -40.f / 100.f, 100.f / 100.f ) );
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
		
		//a_Gl.glTranslatef( 800.f / 100.f, 0.f, -500.f / 100.f );
		//a_Gl.glRotatef( 0.f, 0, 1, 0 ); //
		
		/// Dibuja la caja del supermercado
		m_GLMuebleCajaSupermercado.draw( a_Gl );
		
		//a_Gl.glTranslatef( -800.f / 100.f, 0.f, 500.f / 100.f );
		//a_Gl.glTranslatef( 850.f / 100.f, 100.f / 100.f, -500.f / 100.f );
		
		m_GLFlechaLocalizacionProducto.draw( a_Gl );
		
		//m_Seccion.draw( a_Gl );
	} // draw
	
	
	/** Localiza/Deslocaliza el producto en el mapa.
	 *  Al activar la localización del producto en una estanteria, sección y estante concreto, se debe
	 *  pintar la sección y el estante especificado de otro color.
	 * 
	 * @param a_LocalizacionProducto
	 * @param a_FlagSeleccion
	 * @return
	 */
	public GLVertice localizarProducto( LocalizacionProducto a_LocalizacionProducto, boolean a_FlagSeleccion )
	{
		
		if ( a_LocalizacionProducto == null ) {
			
			return null;
		}
		
		
		Log.d( TAG, "Localizacion del producto: " + a_LocalizacionProducto );
		for ( GLEstanteria glEstanteria: m_GLEstanterias ) {
			
			if ( glEstanteria.getEstanteria().getId() == a_LocalizacionProducto.getEstanteriaId() ) {
							
				Log.d( TAG, "Localizado estanteria con el Id: " + glEstanteria.getEstanteria().getId() );
				return glEstanteria.localizarProducto(  a_LocalizacionProducto.getSeccionId(), 
														a_LocalizacionProducto.getEstanteId(), a_FlagSeleccion, 
														this.m_GLFlechaLocalizacionProducto );
			}
		} // end for
		
		return null;
		
	} // localizarProducto
	
		
	/** Localiza/Deslocaliza el producto en el mapa.
	 *  Al activar la localización del producto en una estanteria, sección y estante concreto, se debe
	 *  pintar la sección y el estante especificado de otro color.
	 * 
	 * @param a_LocalizacionProducto
	 * @param a_FlagSeleccion
	 * @return
	 */
	public boolean deslocalizarTodosProducto(  )
	{
		
		
		if ( m_GLEstanterias.isEmpty() ) {
			
			return false;
		}		
		
		for ( GLEstanteria glEstanteria: m_GLEstanterias ) {
			
			//glEstanteria.setEstaSeleccionada( false );
			glEstanteria.deslocalizarTodosProductos();
		}		
		
		return true;
		
	} // localizarProducto
	
	


	
	
	
} // GLMobiliario
