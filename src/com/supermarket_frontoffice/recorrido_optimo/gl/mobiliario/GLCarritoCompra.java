package com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario;



import android.content.Context;

import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLColor;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLResourceObject;



/** @class GLCarritoCompra
 * 
 * @author fjvegaf
 *
 */
public class GLCarritoCompra extends GLResourceObject
{
	
	
	public GLCarritoCompra( Context a_Context )
	{
			
		super(  a_Context, 
				R.array.gl_carrito_compra_vertices,
				R.array.gl_carrito_compra_normales,
				R.array.gl_carrito_compra_caras );
		
		super.setDefaultColor( new GLColor( 38.f, 50.f, 85.f ) );
	
		//a_Gl.glColor4f( 38.f / 255.f, 50.f / 255.f, 85.f / 255.f, 1.f );
		
	} // GLCarritoCompra
	
	
	

} // end class GLCarritoCompra
