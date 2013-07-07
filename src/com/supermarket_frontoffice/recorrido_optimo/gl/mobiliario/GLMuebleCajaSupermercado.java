package com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario;


import android.content.Context;
import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLColor;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLResourceObject;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLResourcesObjects;


/** @GLMuebleCajaSupermercado
 * 
 *  Objeto OpenGL de la caja de Supermercado
 * 
 * @author fjvegaf
 *
 */
public class GLMuebleCajaSupermercado  extends GLResourcesObjects
{

	/** Constructor
	 * 
	 * @param a_Context
	 */
	public GLMuebleCajaSupermercado( Context a_Context )
	{
		
		///
		/// La base es el borde amarillo de la superficie del mueble de la caja del supermercado
		///
		super(  a_Context,
				R.array.gl_mueble_caja_borde_amarillo_vertices,
				R.array.gl_mueble_caja_borde_amarillo_normales,
				R.array.gl_mueble_caja_borde_amarillo_caras );
		
		super.setDefaultColor( new GLColor( 130.f, 127.f, 0.f, 1.f ) );
		
		///
		/// Se añade los componentes restantes de la caja
		///
		this.addComponent( a_Context );
		
	
	} // GLCarritoCompra
	
	
	/** Añade todos los componentes del mueble de la caja del supermercado
	 * 
	 */
	protected void addComponent( Context a_Context )
	{
		
		
		///
		/// Superficie y bordes
		///
		GLResourceObject superficieCinta= new GLResourceObject( a_Context, 
										R.array.gl_mueble_caja_superficie_cinta_vertices,
										R.array.gl_mueble_caja_superficie_cinta_normales,
										R.array.gl_mueble_caja_superficie_cinta_caras );
		superficieCinta.setDefaultColor( new GLColor( 0.f, 0.f, 0.f, 1.f ) );
		
		
		GLResourceObject bordeExterior= new GLResourceObject( a_Context, 
										R.array.gl_mueble_caja_borde_Exterior_vertices,
										R.array.gl_mueble_caja_borde_Exterior_normales,
										R.array.gl_mueble_caja_borde_Exterior_caras );
		bordeExterior.setDefaultColor( new GLColor( 0.f, 0.f, 255.f, 1.f ) );
		
		GLResourceObject bordeRojo= new GLResourceObject( a_Context, 
										R.array.gl_mueble_caja_borde_rojo_vertices,
										R.array.gl_mueble_caja_borde_rojo_normales,
										R.array.gl_mueble_caja_borde_rojo_caras );
		bordeRojo.setDefaultColor( new GLColor( 255.f, 0.f, 0.f, 1.f ) );
		
		GLResourceObject superficieFinCompra= new GLResourceObject( a_Context, 
				R.array.gl_mueble_caja_superficie_fin_compra_vertices,
				R.array.gl_mueble_caja_superficie_fin_compra_normales,
				R.array.gl_mueble_caja_superficie_fin_compra_caras );
		superficieFinCompra.setDefaultColor( new GLColor( 178.f, 178.f, 178.f, 1.f ) );
		
		
		GLResourceObject protectorCaja= new GLResourceObject( a_Context, 
				R.array.gl_mueble_caja_protector_vertices,
				R.array.gl_mueble_caja_protector_normales,
				R.array.gl_mueble_caja_protector_caras );
		protectorCaja.setDefaultColor( new GLColor( 204.f, 204.f, 204.f, 0.5f ) );
		
		
		///
		/// Soportes
		///
		GLResourceObject soporteIzqDelantero= new GLResourceObject( a_Context, 
														R.array.gl_mueble_caja_soporte_izquierdo_frontal_vertices,
														R.array.gl_mueble_caja_soporte_izquierdo_frontal_normales,
														R.array.gl_mueble_caja_soporte_izquierdo_frontal_caras,
														0,
														R.array.gl_mueble_caja_soporte_izquierdo_frontal_colores );
		//soporteIzqDelantero.setDefaultColor( new GLColor( 178.f, 178.f, 178.f, 1.f ) );
		
		GLResourceObject soporteIzqTrasero= new GLResourceObject( a_Context, 
														R.array.gl_mueble_caja_soporte_izquierdo_trasero_vertices,
														R.array.gl_mueble_caja_soporte_izquierdo_trasero_normales,
														R.array.gl_mueble_caja_soporte_izquierdo_trasero_caras );
		soporteIzqTrasero.setDefaultColor( new GLColor( 178.f, 178.f, 178.f, 1.f ) );
		
		GLResourceObject soporteDerecho= new GLResourceObject( a_Context, 
												R.array.gl_mueble_caja_soporte_derecho_vertices,
												R.array.gl_mueble_caja_soporte_derecho_normales,
												R.array.gl_mueble_caja_soporte_derecho_caras );
		
		soporteDerecho.setDefaultColor( new GLColor( 178.f, 178.f, 178.f, 1.f ) );
		
		
		super.addObject( superficieCinta );
		super.addObject( superficieFinCompra );
		
		super.addObject( bordeExterior );
		super.addObject( bordeRojo );
		super.addObject( protectorCaja );
		
		super.addObject( soporteIzqDelantero );
		super.addObject( soporteIzqTrasero );
		super.addObject( soporteDerecho );
		
		
	} // addComponent
	

	
}
