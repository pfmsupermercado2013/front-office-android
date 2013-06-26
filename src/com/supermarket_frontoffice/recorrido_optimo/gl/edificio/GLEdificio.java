package com.supermarket_frontoffice.recorrido_optimo.gl.edificio;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

import android.util.Log;

import com.supermarket_frontoffice.modelo_datos.Edificio;
import com.supermarket_frontoffice.modelo_datos.Estanteria;
import com.supermarket_frontoffice.modelo_datos.ParedEdificio;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLObject;
import com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario.GLEstanteriaDoble;
import com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario.GLEstanteriaSimple;


/** @clas GLEdificioSupermercado
 * 
 * @author fjvegaf
 *
 */
public class GLEdificio extends GLObject
{
	
	private static final String TAG= "GLEdificio";
	Edificio 						m_Edifico;			///< Objeto que contiene todos los datos del edificio del supermercado
	ArrayList< GLParedEdificio >	m_ListaGLParedes;	///< Lista de objetos de parederes de OpenGL.

	GLSueloEdificio					m_BuildingGround;
	
	/** Constructor
	 * 
	 * @param a_XPosInicial		 	Posición X del primer 
	 * @param a_YPosicionInicial
	 */
	public GLEdificio( Edificio a_Edifico )
	{
		
		super( );		
		m_Edifico= a_Edifico;
		m_ListaGLParedes= new ArrayList< GLParedEdificio >();
		
		m_BuildingGround= null; // new GLSueloEdificio( 28000.f, 28000.f, 30.f );
		
		this.createGLObject( );
		
	} // GLEdificioSupermercado
	
	
	/** Crea todos los objetos opengl que intervienen en el mobiliario
	 * 
	 * @return
	 */
	public boolean createGLObject( )
	{
		
		Log.d( TAG, "Creando los objetos OpenGL del mobiliario " );
		
		
		///
		/// Creación de la estanterías
		///
		ArrayList< ParedEdificio > listaParedes= m_Edifico.getListaParedes();
		
		
		float groundWidth= 0.f; 
		float groundLength= 0.f;
		
		
		for ( ParedEdificio pared: listaParedes ) {
						
			m_ListaGLParedes.add( new GLParedEdificio( pared ) );
			
			if ( ( pared.getV1().getVertice().getX() == pared.getV2().getVertice().getX()  ) && pared.getLargo() > groundLength ) {
				
				groundLength= pared.getLargo();
			}
			
			if ( ( pared.getV1().getVertice().getY() == pared.getV2().getVertice().getY()  ) && pared.getLargo() > groundWidth ) {
				
				groundWidth= pared.getLargo();
			}
		}
		
		Log.d( TAG, "Ground [ Width= " + groundWidth + "; Length= " + groundLength + "]" );
		m_BuildingGround= new GLSueloEdificio( groundWidth / 1.f, groundLength / 1.f, 30.f );
		
		return true;
		
	} // createGLObject
	
	
	/** Dibuja la estantería
	 * 
	 * @param a_Gl
	 */
	public void draw( GL10 a_Gl )
	{
		
		
			 
		m_BuildingGround.draw( a_Gl );
		
		
		for ( GLParedEdificio glPared: m_ListaGLParedes ) {
			
			glPared.draw( a_Gl );
		}

		
		//m_Seccion.draw( a_Gl );
	} // draw
	
	
} // GLEdificioSupermercado
