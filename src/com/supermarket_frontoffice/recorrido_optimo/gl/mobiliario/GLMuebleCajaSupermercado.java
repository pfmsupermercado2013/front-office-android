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
		
//		super(  a_Context, 
//				R.array.gl_mueble_caja_vertices,
//				R.array.gl_mueble_caja_normales,
//				R.array.gl_mueble_caja_caras );
//		
//		super.setColores( 
//				new float[] {	
//						25.f/255.f, 25.f/255.f, 25.f/255.f, 1.f,
//						26.f/255.f, 26.f/255.f, 26.f/255.f, 1.f,
//						27.f/255.f, 27.f/255.f, 27.f/255.f, 1.f,
//						28.f/255.f, 28.f/255.f, 28.f/255.f, 1.f,
//						29.f/255.f, 29.f/255.f, 29.f/255.f, 1.f,
//						30.f/255.f, 30.f/255.f, 30.f/255.f, 1.f,
//						35.f/255.f, 35.f/255.f, 35.f/255.f, 1.f,
//						40.f/255.f, 40.f/255.f, 40.f/255.f, 1.f,
//						45.f/255.f, 45.f/255.f, 45.f/255.f, 1.f,
//						50.f/255.f, 50.f/255.f, 50.f/255.f, 1.f,
//						55.f/255.f, 55.f/255.f, 55.f/255.f, 1.f,
//						60.f/255.f, 60.f/255.f, 60.f/255.f, 1.f,
//						65.f/255.f, 65.f/255.f, 65.f/255.f, 1.f,
//						70.f/255.f, 70.f/255.f, 70.f/255.f, 1.f,
//						71.f/255.f, 71.f/255.f, 71.f/255.f, 1.f,
//						72.f/255.f, 72.f/255.f, 72.f/255.f, 1.f,
//						76.f/255.f, 76.f/255.f, 76.f/255.f, 1.f,
//						102.f/255.f, 102.f/ 255.f, 102.f/255.f, 1.f,
//						103.f/255.f, 103.f/ 255.f, 103.f/255.f, 1.f,
//						104.f/255.f, 104.f/ 255.f, 104.f/255.f, 1.f,
//						105.f/255.f, 105.f/ 255.f, 105.f/255.f, 1.f,
//						106.f/255.f, 106.f/ 255.f, 106.f/255.f, 1.f,
//						107.f/255.f, 107.f/ 255.f, 107.f/255.f, 1.f,
//						108.f/255.f, 108.f/ 255.f, 108.f/255.f, 1.f,
//						109.f/255.f, 109.f/ 255.f, 109.f/255.f, 1.f,
//						127.f/255.f, 127.f/255.f, 127.f/255.f, 1.f,
//						153.f/255.f, 153.f/255.f, 153.f/255.f, 1.f,
//						178.f/255.f, 178.f/255.f, 178.f/255.f, 1.f,  
//						204.f/255.f, 204.f/255.f, 204.f/255.f, 1.f
//					}
//				);
		

		//a_Gl.glColor4f( 76.f / 255.f, 76.f / 255.f, 76.f / 255.f, 1.f );
	
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
	
	
//	/** Método abstracto que debe redefinir las clases que lo hereran
//	 * 
//	 * @param a_Gl
//	 */
//	public void draw( GL10 a_Gl )
//	{
//		
////		a_Gl.glRotatef( m_YRotate, 0, 1, 0 );
////		
////		m_YRotate+= 4.f;
//		
//		// Contra las agujas del reloj		 
//		a_Gl.glFrontFace(GL10.GL_CCW);
//		 
////		// Habilitar el sacrificio de caras a ocultar		 
////		a_Gl.glEnable(GL10.GL_CULL_FACE);
////		 
////		// Aca se indica que cara se sacrificara, en este caso, la de atras		 
////		a_Gl.glCullFace(GL10.GL_BACK);
//		 
//		// Habilitar el buffer de vertices para la escritura y cuales se usaran para el renderizado
//		a_Gl.glEnableClientState( GL10.GL_VERTEX_ARRAY );
//		 
//		// Especifica la localizacion y el formato de los datos de un array de vertices a utilizar para el renderizado
//		
//		if ( ( m_VertexBuffer == null ) || ( m_FacesBuffer == null ) ) {
//			
//			
//			Log.e( "GLCarritoCompra", "No se ha especificado vertices o caras para el carrito de la compra " );
//			return;
//		}
//		
//			
//		a_Gl.glVertexPointer(3, GL10.GL_FLOAT, 0, m_VertexBuffer );
//		
//		if ( m_NormalsBuffer != null ) {
//				
//			a_Gl.glNormalPointer( GL10.GL_FLOAT, 0, m_NormalsBuffer );
//		}
//		//a_Gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, m_TexCoordsBuffer );
//
//
//		if ( m_ColorBuffer != null ) {
//			
//			// Habilita el buffer para el color del grafico		 
//			a_Gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
//		 
//			// Señala donde se encuentra el buffer del color		 
//			a_Gl.glColorPointer(4, GL10.GL_FLOAT, 0, m_ColorBuffer );
//		}
//		else {
//			
//			a_Gl.glColor4f( 76.f / 255.f, 76.f / 255.f, 76.f / 255.f, 1.f );
//		}
//		
//		//Dibujamos las superficies		 
//		//a_Gl.glDrawElements( GL10.GL_TRIANGLE_STRIP, m_Caras.length, GL10.GL_UNSIGNED_SHORT, m_IndexBuffer );
//		a_Gl.glDrawElements( GL10.GL_TRIANGLES, m_Caras.length, GL10.GL_UNSIGNED_SHORT, m_FacesBuffer );
//		
//		// draw data
//		//a_Gl.glDrawArrays( GL10.GL_TRIANGLES, 0, m_GLEstanteriaExample.m_Estanteria_NumVerts );
//		
//		// Desactiva el buffer de los vertices		 
//		a_Gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
//		 
//		//Desactiva la caracteristica de sacrificios de las caras		 
//		a_Gl.glDisable(GL10.GL_CULL_FACE);
//		 
//		// Desahilita el buffer del color		 
//		a_Gl.glDisableClientState(GL10.GL_COLOR_ARRAY);      
//		
//	
//	} // draw 
	
}
