package com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario;

import android.content.Context;

import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLColor;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLResourceObject;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLResourcesObjects;


/**
 * 
 * @author fjvegaf
 *
 */
public class GLFlechaLocalizacionProducto  extends GLResourcesObjects
{

	
	/** Constructor
	 * 
	 * @param a_Context
	 */
	public GLFlechaLocalizacionProducto(Context a_Context ) 
	{
		
		super(	a_Context, 
				R.array.gl_flecha_localizacion_producto_siguiente_vertices, 
				R.array.gl_flecha_localizacion_producto_siguiente_normales, 
				R.array.gl_flecha_localizacion_producto_siguiente_caras );
		
		super.setDefaultColor( new GLColor( 255.f, 255.f, 0.f ) );
		
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
		
		
	

} // GLFlechaLocalizacionProducto
