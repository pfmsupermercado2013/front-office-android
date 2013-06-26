package com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario;

//import java.nio.ByteBuffer;
//import java.nio.ByteOrder;
//import java.nio.FloatBuffer;
//import java.nio.ShortBuffer;
//import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.util.Log;

import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLResourcesObject;



/** @class GLCarritoCompra
 * 
 * @author fjvegaf
 *
 */
public class GLCarritoCompra extends GLResourcesObject
{
	
	
	public GLCarritoCompra( Context a_Context )
	{
			
		super(  a_Context, 
				R.array.gl_carrito_compra_vertices,
				R.array.gl_carrito_compra_normales,
				R.array.gl_carrito_compra_caras );
	
	} // GLCarritoCompra
	
	
	/** Método abstracto que debe redefinir las clases que lo hereran
	 * 
	 * @param a_Gl
	 */
	public void draw( GL10 a_Gl )
	{
		
//		a_Gl.glRotatef( m_YRotate, 0, 1, 0 );
//		
//		m_YRotate+= 4.f;
		
		// Contra las agujas del reloj		 
		a_Gl.glFrontFace(GL10.GL_CCW);
		 
//		// Habilitar el sacrificio de caras a ocultar		 
//		a_Gl.glEnable(GL10.GL_CULL_FACE);
//		 
//		// Aca se indica que cara se sacrificara, en este caso, la de atras		 
//		a_Gl.glCullFace(GL10.GL_BACK);
		 
		// Habilitar el buffer de vertices para la escritura y cuales se usaran para el renderizado
		a_Gl.glEnableClientState( GL10.GL_VERTEX_ARRAY );
		 
		// Especifica la localizacion y el formato de los datos de un array de vertices a utilizar para el renderizado
		
		if ( ( m_VertexBuffer == null ) || ( m_FacesBuffer == null ) ) {
			
			
			Log.e( "GLCarritoCompra", "No se ha especificado vertices o caras para el carrito de la compra " );
			return;
		}
		
			
		a_Gl.glVertexPointer(3, GL10.GL_FLOAT, 0, m_VertexBuffer );
		
		if ( m_NormalsBuffer != null ) {
				
			a_Gl.glNormalPointer( GL10.GL_FLOAT, 0, m_NormalsBuffer );
		}
		//a_Gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, m_TexCoordsBuffer );


		if ( m_ColorBuffer != null ) {
			
			// Habilita el buffer para el color del grafico		 
			a_Gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		 
			// Señala donde se encuentra el buffer del color		 
			a_Gl.glColorPointer(4, GL10.GL_FLOAT, 0, m_ColorBuffer );
		}
		else {
			
			a_Gl.glColor4f( 38.f / 255.f, 50.f / 255.f, 85.f / 255.f, 1.f );
		}
		
		//Dibujamos las superficies		 
		//a_Gl.glDrawElements( GL10.GL_TRIANGLE_STRIP, m_Caras.length, GL10.GL_UNSIGNED_SHORT, m_IndexBuffer );
		a_Gl.glDrawElements( GL10.GL_TRIANGLES, m_Caras.length, GL10.GL_UNSIGNED_SHORT, m_FacesBuffer );
		
		// draw data
		//a_Gl.glDrawArrays( GL10.GL_TRIANGLES, 0, m_GLEstanteriaExample.m_Estanteria_NumVerts );
		
		// Desactiva el buffer de los vertices		 
		a_Gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		 
		//Desactiva la caracteristica de sacrificios de las caras		 
		a_Gl.glDisable(GL10.GL_CULL_FACE);
		 
		// Desahilita el buffer del color		 
		a_Gl.glDisableClientState(GL10.GL_COLOR_ARRAY);      
		
	
	} // draw 
	

} // end class GLCarritoCompra
