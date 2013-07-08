package com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;

import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLColor;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLResourceObject;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLResourcesObjects;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLVertice;


/**
 * 
 * @author fjvegaf
 *
 */
public class GLFlechaLocalizacionProducto  extends GLResourcesObjects
{

	
	//private GLVertice 	m_PosicionFlecha;
	
	/** Constructor
	 * 
	 * @param a_Context
	 */
	public GLFlechaLocalizacionProducto(    Context a_Context/*,
											GLVertice 	a_PosicionFlecha*/  ) 
	{
		
		super(	a_Context, 
				R.array.gl_flecha_localizacion_producto_siguiente_vertices, 
				R.array.gl_flecha_localizacion_producto_siguiente_normales, 
				R.array.gl_flecha_localizacion_producto_siguiente_caras );
		
		super.setDefaultColor( new GLColor( 255.f, 255.f, 0.f ) );
		
		//m_PosicionFlecha= a_PosicionFlecha;
		
		///
		/// Se añade los componentes restantes de la caja
		///
		this.addComponent( a_Context );
		
	} // GLFlechaLocalizacionProducto
	
	
	/** Añade todos los componentes del mueble de la caja del supermercado
	 * 
	 */
	protected void addComponent( Context a_Context )
	{
		
		
		///
		/// Aro superior de la flecha
		///
		GLResourceObject aroSuperior= new GLResourceObject( a_Context, 
										R.array.gl_flecha_aro_localizacion_producto_siguiente_vertices,
										R.array.gl_flecha_aro_localizacion_producto_siguiente_normales,
										R.array.gl_flecha_aro_localizacion_producto_siguiente_caras );
		aroSuperior.setDefaultColor( new GLColor( 0.f, 127.f, 0.f, 1.f ) );
		
		super.addObject( aroSuperior );
		
	} // addComponent
		
	
	/** Método abstracto que debe redefinir las clases que lo hereran
	 * 
	 * @param a_Gl
	 */
	public void draw( GL10 a_Gl )
	{
		
		
		//a_Gl.glTranslatef( this.m_PosicionFlecha.getX(), this.m_PosicionFlecha.getZ(), this.m_PosicionFlecha.getY() );
		//a_Gl.glRotatef( this.m_RotacionXYFlecha, 0, 1, 0 );
		
		super.draw( a_Gl );
		
		//a_Gl.glRotatef( -this.m_RotacionXYFlecha, 0, 1, 0 );
		//a_Gl.glTranslatef( -this.m_PosicionFlecha.getX(), -this.m_PosicionFlecha.getZ(), -this.m_PosicionFlecha.getY() );
		
	
	} // draw 
		
	

} // GLFlechaLocalizacionProducto
