package com.supermarket_frontoffice.recorrido_optimo.gl.edificio;

import javax.microedition.khronos.opengles.GL10;

import android.util.Log;

import com.supermarket_frontoffice.modelo_datos.ParedEdificio;
import com.supermarket_frontoffice.modelo_datos.PuertaEdificio;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLVertice;


/**
 * 
 * @author fjvegaf
 *
 */
public class GLParedConPuertaEdificio extends GLParedEdificio
{

	private static final String TAG= "GLParedConPuertaEdificio";
	private PuertaEdificio m_PuertaEdificio;
	
	/** Constructor
	 * 
	 * @param a_Pared
	 */
	public GLParedConPuertaEdificio( 	ParedEdificio a_Pared, 
										PuertaEdificio a_PuertaEdificio )
	{
		
		super( a_Pared );
		
		m_PuertaEdificio= a_PuertaEdificio;
		
		super.setVertices( this.calculateVertices( a_Pared.getV1().getVertice(), a_Pared.getV2().getVertice(), a_Pared.getAncho() ) ); 
		
				
		super.setNormales( 			/// 7 Normales
				new float[] {
					0.0000f, -1.0000f, -0.0000f,
					-0.0128f, -0.0000f, 0.9999f,
					-0.0128f, 0.0000f, 0.9999f,
					0.0128f, 0.0000f, 0.9999f,
					-0.9999f, 0.0000f, -0.0128f,
					0.9999f, 0.0000f, 0.0128f,
					0.0000f, 1.0000f, -0.0000f,
				} );
		
		super.setCaras( 
				
				new short[ ] {  // 28 Caras
						
						//s 1
						0, 1, 2, //f 1/1/1 2/2/1 3/3/1 
						2, 3, 0, //f 3/3/1 4/4/1 1/1/1 
						//s 2
						4, 5, 6, //f 5/5/2 6/6/3 7/7/3 
						4, 6, 7, //f 5/5/2 7/7/3 8/8/2 
						4, 7, 8, //f 5/5/2 8/8/2 9/9/2 
						9, 4, 8, //f 10/10/3 5/5/2 9/9/2 
						9, 8, 0, //f 10/10/3 9/9/2 1/11/3 
						3, 9, 0, //f 4/12/3 10/10/3 1/11/3 
						10, 2, 1, //f 11/13/4 3/14/4 2/15/4 
						10, 1, 11, //f 11/13/4 2/15/4 12/16/4 
						10, 11, 12, //f 11/13/4 12/16/4 13/17/4 
						13, 10, 12, //f 14/18/4 11/13/4 13/17/4 
						13, 12, 14, //f 14/18/4 13/17/4 15/19/4 
						13, 14, 15, //f 14/18/4 15/19/4 16/20/4 
						//s 1
						14, 6, 5, //f 15/21/1 7/22/1 6/23/1 
						5, 15, 14, //f 6/23/1 16/24/1 15/21/1 
						//s 4
						5, 4, 13, //f 6/25/5 5/26/5 14/27/5 
						13, 15, 5, //f 14/27/5 16/28/5 6/25/5 
						//s 1
						4, 9, 10, //f 5/29/1 10/30/1 11/31/1 
						10, 13, 4, //f 11/31/1 14/32/1 5/29/1 
						//s 4
						9, 3, 2, //f 10/33/6 4/34/6 3/35/6 
						2, 10, 9, //f 3/35/6 11/36/6 10/33/6 
						8, 11, 1, //f 9/37/5 12/38/5 2/39/5 
						1, 0, 8, //f 2/39/5 1/40/5 9/37/5 
						//s 1
						7, 12, 11, //f 8/41/7 13/42/7 12/43/7 
						11, 8, 7, //f 12/43/7 9/44/7 8/41/7 
						//s 4
						6, 14, 12, //f 7/45/6 15/46/6 13/47/6 
						12, 7, 6,  //f 13/47/6 8/48/6 7/45/6 
	
					}
				);
		
		super.setCoordTextura( 				
				new float[] {		/// 48
						
						1.0000f, 0.2126f, 0.5000f,
						0.9994f, 1.0000f, 0.5000f,
						0.8768f, 0.9739f, 0.5000f,
						0.8774f, 0.1865f, 0.5000f,
						0.6685f, 1.1435f, 0.0704f,
						0.6685f, 0.5000f, 0.0704f,
						0.9994f, 0.5000f, 0.0000f,
						0.9994f, 1.5000f, 0.0000f,
						0.0000f, 1.5000f, 0.2126f,
						0.1226f, 1.1435f, 0.1865f,
						0.0000f, 0.5000f, 0.2126f,
						0.1226f, 0.5000f, 0.1865f,
						0.8768f, 1.1435f, 0.9739f,
						0.8768f, 0.5000f, 0.9739f,
						0.9994f, 0.5000f, 1.0000f,
						0.9994f, 1.5000f, 1.0000f,
						0.0000f, 1.5000f, 0.7874f,
						0.3309f, 1.1435f, 0.8578f,
						0.0000f, 0.5000f, 0.7874f,
						0.3309f, 0.5000f, 0.8578f,
						0.0000f, 0.7874f, 0.5000f,
						0.0006f, 0.0000f, 0.5000f,
						0.3315f, 0.0704f, 0.5000f,
						0.3309f, 0.8578f, 0.5000f,
						0.9296f, 0.5000f, 0.6685f,
						0.9296f, 1.1435f, 0.6685f,
						0.1422f, 1.1435f, 0.6691f,
						0.1422f, 0.5000f, 0.6691f,
						0.3315f, 0.0704f, 1.1435f,
						0.8774f, 0.1865f, 1.1435f,
						0.8768f, 0.9739f, 1.1435f,
						0.3309f, 0.8578f, 1.1435f,
						0.1865f, 1.1435f, 0.1226f,
						0.1865f, 0.5000f, 0.1226f,
						0.9739f, 0.5000f, 0.1232f,
						0.9739f, 1.1435f, 0.1232f,
						0.7874f, 1.5000f, 0.0000f,
						0.0000f, 1.5000f, 0.0006f,
						0.0000f, 0.5000f, 0.0006f,
						0.7874f, 0.5000f, 0.0000f,
						0.9994f, 0.0000f, 1.5000f,
						1.0000f, 0.7874f, 1.5000f,
						0.0006f, 1.0000f, 1.5000f,
						0.0000f, 0.2126f, 1.5000f,
						0.0000f, 0.5000f, 0.9994f,
						0.7874f, 0.5000f, 1.0000f,
						0.7874f, 1.5000f, 1.0000f,
						0.0000f, 1.5000f, 0.9994f,
					} 
				);
		
		super.setColores( 
				
				new float[] {	
						250.0f/255.f, 250.0f/255.f, 250.0f/255.f, 1.f, // V1
						250.0f/255.f, 250.0f/255.f, 250.0f/255.f, 1.f, // V2
						250.0f/255.f, 250.0f/255.f, 250.0f/255.f, 1.f, // V3
						250.0f/255.f, 250.0f/255.f, 250.0f/255.f, 1.f, // V4
						250.0f/255.f, 250.0f/255.f, 250.0f/255.f, 1.f, // V5
						250.0f/255.f, 250.0f/255.f, 250.0f/255.f, 1.f, // V6
						250.0f/255.f, 250.0f/255.f, 250.0f/255.f, 1.f, // V7
						184.0f / 255.f, 188.0f / 255.f, 151.0f / 255.f, 1.f, // V8
						184.0f / 255.f, 188.0f / 255.f, 151.0f / 255.f, 1.f, // V9
						250.0f/255.f, 250.0f/255.f, 250.0f/255.f, 1.f, // V10
						250.0f/255.f, 250.0f/255.f, 250.0f/255.f, 1.f, // V11
						184.0f / 255.f, 188.0f / 255.f, 151.0f / 255.f, 1.f, // V12
						184.0f / 255.f, 188.0f / 255.f, 151.0f / 255.f, 1.f, // V13
						250.0f/255.f, 250.0f/255.f, 250.0f/255.f, 1.f, // V14
						250.0f/255.f, 250.0f/255.f, 250.0f/255.f, 1.f, // V15
						250.0f/255.f, 250.0f/255.f, 250.0f/255.f, 1.f, // V16
					}	
				);
		
	} // GLParedConPuertaEdificio
	
	
	
	/** Devuélve los vértices de la pared a partir de los punto V1 y V2.
	 * 
	 */
	protected float[] calculateVertices( GLVertice a_V1, GLVertice a_V2, float a_Ancho )
	{
		
		float xIniPuerta= 0.f;
		float xFinPuerta= 0.f;
		float altoPuerta= 0.f;
		
		if ( m_PuertaEdificio != null ) {
			
			
			Log.d( TAG, "calculateVertices:: [" + m_PuertaEdificio.toString() + "]" );
			
			
			xIniPuerta= m_PuertaEdificio.getXLeft();
			xFinPuerta= xIniPuerta + m_PuertaEdificio.getLargo();
			altoPuerta= m_PuertaEdificio.getAlto();
			
			Log.d( TAG, "calculateVertices:: [xIniPuerta=" + xIniPuerta + "][xFinPuerta= "+ xFinPuerta +"][altoPuerta= " + altoPuerta + "]" );
		}
		
//		xIniPuerta= m_PuertaEdificio.getXLeft();
//		xFinPuerta= xIniPuerta + m_PuertaEdificio.getLargo();
//		altoPuerta= m_PuertaEdificio.getAlto();
		
		if ( a_V1.getX() == a_V2.getX() ) {
			
//			return new float[] {
//					
//					a_V1.getX() + a_Ancho, 					0.f, 			a_V1.getY(),	// V1
//					a_V1.getX(), 							0.f, 			a_V1.getY(),	// V2
//					a_V1.getX() + xIniPuerta, 				0.f, 			a_V1.getY(),	// V3
//					a_V1.getX() + xIniPuerta  + a_Ancho, 	0.f, 			a_V1.getY(), 	// V4
//					
//					a_V1.getX() + xFinPuerta + a_Ancho, 	altoPuerta, 	a_V1.getY(), 	// V5
//					a_V1.getX() + xFinPuerta + a_Ancho, 	0.f, 			a_V1.getY(),	// V6
//					a_V2.getX() + a_Ancho, 					0.f, 			a_V2.getY(), 	// V7
//					a_V2.getX() + a_Ancho, 					a_V2.getZ(), 	a_V2.getY(),  	// V8
//					
//					
//					a_V1.getX() + a_Ancho, 					a_V1.getZ(), 	a_V1.getY(),	// V9
//					a_V1.getX() + xIniPuerta + a_Ancho, 	altoPuerta, 	a_V1.getY(),	// V10
//					a_V1.getX() + xIniPuerta, 				altoPuerta, 	a_V1.getY(),	// V11
//					a_V1.getX(), 							a_V1.getZ(), 	a_V1.getY(), 	// V12
//					
//					a_V2.getX(), 							a_V2.getZ(), 	a_V2.getY(), 	// V13
//					a_V1.getX() + xFinPuerta, 				altoPuerta, 	a_V1.getY(),	// V14
//					a_V2.getX(), 							0.f, 			a_V2.getY(), 	// V15
//					a_V1.getX() + xIniPuerta, 				0.f, 			a_V1.getY()  	// V16
//		
//				};
			

		}
		else if (  a_V1.getY() == a_V2.getY()) {
			
			
			return new float[] {
					
					a_V1.getX(), 				0.f, 			a_V1.getY() + a_Ancho,	// V1
					a_V1.getX(), 				0.f, 			a_V1.getY(),			// V2
					a_V1.getX() + xIniPuerta, 	0.f, 			a_V1.getY(),			// V3
					a_V1.getX() + xIniPuerta, 	0.f, 			a_V1.getY() + a_Ancho, 	// V4
					
					a_V1.getX() + xFinPuerta, 	altoPuerta, 	a_V1.getY() + a_Ancho, 	// V5
					a_V1.getX() + xFinPuerta, 	0.f, 			a_V1.getY() + a_Ancho,	// V6
					a_V2.getX(), 				0.f, 			a_V2.getY() + a_Ancho, 	// V7
					a_V2.getX(), 				a_V2.getZ(), 	a_V2.getY() + a_Ancho,  // V8
					
					
					a_V1.getX(), 				a_V1.getZ(), 	a_V1.getY() + a_Ancho,	// V9
					a_V1.getX() + xIniPuerta, 	altoPuerta, 	a_V1.getY() + a_Ancho,	// V10
					a_V1.getX() + xIniPuerta, 	altoPuerta, 	a_V1.getY(),			// V11
					a_V1.getX(), 				a_V1.getZ(), 	a_V1.getY(), 			// V12
					
					a_V2.getX(), 				a_V2.getZ(), 	a_V2.getY(), 			// V13
					a_V1.getX() + xFinPuerta, 	altoPuerta, 	a_V1.getY(),			// V14
					a_V2.getX(), 				0.f, 			a_V2.getY(), 			// V15
					a_V1.getX() + xFinPuerta, 	0.f, 			a_V1.getY()  			// V16
		
				};
			
//			return new float[] {	
//					a_V1.getX(), 	0.f, 			a_V1.getY(),			// V1
//					a_V1.getX(), 	0.f, 			a_V1.getY() + a_Ancho,	// V2
//					a_V2.getX(), 	0.f, 			a_V2.getY() + a_Ancho,	// V3
//					a_V2.getX(), 	0.f, 			a_V2.getY(), 			// V4
//					a_V1.getX(), 	a_V1.getZ(), 	a_V1.getY(), 			// V5
//					a_V2.getX(), 	a_V2.getZ(), 	a_V2.getY(),			// V6
//					a_V2.getX(), 	a_V2.getZ(), 	a_V2.getY() + a_Ancho, 	// V7
//					a_V1.getX(), 	a_V1.getZ(), 	a_V1.getY() + a_Ancho  	// V8	
//				};
		}
		
		
		return null;
	} // getVertices
	
	
	/** Método abstracto que debe redefinir las clases que lo hereran
	 * 
	 * @param a_Gl
	 */
	public void draw( GL10 a_Gl ) 
	{
		
		// Contra las agujas del reloj		 
		a_Gl.glFrontFace(GL10.GL_CCW);
		 
//		// Habilitar el sacrificio de caras a ocultar		 
//		a_Gl.glEnable(GL10.GL_CULL_FACE);
//		 
//		// Aca se indica que cara se sacrificara, en este caso, la de atras		 
//		a_Gl.glCullFace(GL10.GL_BACK);
		 
		// Habilitar el buffer de vertices para la escritura y cuales se usaran para el renderizado
		a_Gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		 
		// Especifica la localizacion y el formato de los datos de un array de vertices a utilizar para el renderizado
		//a_Gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
		a_Gl.glVertexPointer(3, GL10.GL_FLOAT, 0, m_VertexBuffer );
		a_Gl.glNormalPointer( GL10.GL_FLOAT, 0, m_NormalsBuffer );
		a_Gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, m_TexCoordsBuffer );
	
		// Habilita el buffer para el color del grafico		 
		a_Gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		 
		// Señala donde se encuentra el buffer del color		 
		a_Gl.glColorPointer(4, GL10.GL_FLOAT, 0, m_ColorBuffer );
		
		//a_Gl.glColor4f( 201.0f / 255.f, 188.0f / 255.f, 151.0f / 255.f, 1.f );
		
		a_Gl.glLineWidth( 1.f ); 
		//a_Gl.glPointSize( 1.f );
		 
		//Dibujamos las superficies		 
		//a_Gl.glDrawElements( GL10.GL_TRIANGLE_STRIP, m_Caras.length, GL10.GL_UNSIGNED_SHORT, m_IndexBuffer );
		a_Gl.glDrawElements( GL10.GL_TRIANGLES, m_Caras.length, GL10.GL_UNSIGNED_SHORT, m_FacesBuffer );
		//a_Gl.glDrawElements( GL10.GL_POINTS, m_Caras.length, GL10.GL_UNSIGNED_SHORT, m_FacesBuffer );
		
		// draw data
		//a_Gl.glDrawArrays( GL10.GL_TRIANGLES, 0, m_GLEstanteriaExample.m_Estanteria_NumVerts );
		
		// Desactiva el buffer de los vertices		 
		a_Gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		 
		//Desactiva la caracteristica de sacrificios de las caras		 
		a_Gl.glDisable(GL10.GL_CULL_FACE);
		 
		// Desahilita el buffer del color		 
		a_Gl.glDisableClientState(GL10.GL_COLOR_ARRAY);      
		
		
	} // draw
	
} // end class GLParedConPuertaEdificio
