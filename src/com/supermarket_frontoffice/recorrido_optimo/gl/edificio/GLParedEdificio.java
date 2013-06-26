package com.supermarket_frontoffice.recorrido_optimo.gl.edificio;

import javax.microedition.khronos.opengles.GL10;

import com.supermarket_frontoffice.modelo_datos.ParedEdificio;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLObject;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLVertice;
import com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario.GLEstanteriaEstante;


/** @class GLParedEdificio
 *  @brief Clase que dibuja una pared en OpenGL.
 * 
 * @author fjvegaf
 *
 */
public class GLParedEdificio extends GLObject 
{

	private ParedEdificio m_ParedEdificio;	///< Datos de una pared del Edificio del Supermercado
	
	
	
	public GLParedEdificio( ParedEdificio a_Pared )
	{

		
//		v  0.0580 0.0000 -0.0283		Vertices
//		v  0.0580 0.0000 -3.6485
//		v  179.0015 0.0000 -3.6485
//		v  179.0015 0.0000 -0.0283
//		v  0.0580 145.2682 -0.0283
//		v  179.0015 145.2682 -0.0283
//		v  179.0015 145.2682 -3.6485
//		v  0.0580 145.2682 -3.6485
		
//		vn 0.0000 -1.0000 -0.0000		Normales
//		vn 0.0000 1.0000 -0.0000
//		vn 0.0000 0.0000 1.0000
//		vn 1.0000 0.0000 -0.0000
//		vn 0.0000 0.0000 -1.0000
//		vn -1.0000 0.0000 -0.0000
		
//		vt 1.0000 0.0000 0.0000			Textura
//		vt 1.0000 1.0000 0.0000
//		vt 0.0000 1.0000 0.0000
//		vt 0.0000 0.0000 0.0000
		
//		s 2								Caras
//		f 1/1/1 2/2/1 3/3/1 
//		f 3/3/1 4/4/1 1/1/1 
//		s 4
//		f 5/4/2 6/1/2 7/2/2 
//		f 7/2/2 8/3/2 5/4/2 
//		s 8
//		f 1/4/3 4/1/3 6/2/3 
//		f 6/2/3 5/3/3 1/4/3 
//		s 16
//		f 4/4/4 3/1/4 7/2/4 
//		f 7/2/4 6/3/4 4/4/4 
//		s 32
//		f 3/4/5 2/1/5 8/2/5 
//		f 8/2/5 7/3/5 3/4/5 
//		s 64
//		f 2/4/6 1/1/6 5/2/6 
//		f 5/2/6 8/3/6 2/4/6 
		
		
		super(  
				GLParedEdificio.getVertices( a_Pared.getV1().getVertice(), a_Pared.getV2().getVertice(), a_Pared.getAncho() ),
//				new float[] {	
//					a_Pared.getV1().getVertice().getX(), 	0.f, 									a_Pared.getV1().getVertice().getY(),						// V1
//					a_Pared.getV1().getVertice().getX(), 	0.f, 									a_Pared.getV1().getVertice().getY() + a_Pared.getAncho(),	// V2
//					a_Pared.getV2().getVertice().getX(), 	0.f, 									a_Pared.getV2().getVertice().getY() + a_Pared.getAncho(),	// V3
//					a_Pared.getV2().getVertice().getX(), 	0.f, 									a_Pared.getV2().getVertice().getY(), // V4
//					a_Pared.getV1().getVertice().getX(), 	a_Pared.getV1().getVertice().getZ(), 	a_Pared.getV1().getVertice().getY(), // V5
//					a_Pared.getV2().getVertice().getX(), 	a_Pared.getV2().getVertice().getZ(), 	a_Pared.getV2().getVertice().getY(),	// V6
//					a_Pared.getV2().getVertice().getX(), 	a_Pared.getV2().getVertice().getZ(), 	a_Pared.getV2().getVertice().getY() + a_Pared.getAncho(), // V7
//					a_Pared.getV1().getVertice().getX(), 	a_Pared.getV1().getVertice().getZ(), 	a_Pared.getV1().getVertice().getY() + a_Pared.getAncho()  // V8	
//						},
						
//						new float[] {	
//								0.f, 						0.f, 0.f,											// V1
//								0.f, 						0.f, -a_ParedEdificio.getAncho(),					// V2
//								a_ParedEdificio.getLargo(), 0.f, -a_ParedEdificio.getAncho(),					// V3
//								a_ParedEdificio.getLargo(), 0.f, 0.f,											// V4
//								0.f, 						a_ParedEdificio.getV1().getVertice().getZ(), 0.f,	// V5
//								a_ParedEdificio.getLargo(), a_ParedEdificio.getV2().getVertice().getZ(), 0.f,	// V6
//								a_ParedEdificio.getLargo(), a_ParedEdificio.getV2().getVertice().getZ(), -a_ParedEdificio.getAncho(), // V7
//								0.f, 						a_ParedEdificio.getV1().getVertice().getZ(), -a_ParedEdificio.getAncho()  // V8	
//							},
						
		
				new float[] {
					
					0.0000f, -1.0000f, -0.0000f,
					0.0000f, 1.0000f, -0.0000f,
					0.0000f, 0.0000f, 1.0000f,
					1.0000f, 0.0000f, 0.0000f,
					0.0000f, 0.0000f, -1.0000f,
					-1.0000f, 0.0000f, -0.0000f
				},
				
				new short[ ] { 
					// s 2
					0, 1, 2,	// 1, 2, 3,
					2, 3, 0,	// 3, 4, 1,
					
					// s4
					4, 5, 6, 	// 5, 6, 7
					6, 7, 4,	// 7, 8, 5
					
					// s8
					0, 3, 5,	// 1, 4, 6
					5, 4, 0,	// 6, 5, 1

					// s16
					3, 2, 6, 	// 4, 3, 7
					6, 5, 3,	// 7, 6, 4
					
					// s32
					2, 1, 7,	// 3, 2, 8
					7, 6, 2,	// 8, 7, 3
					
					// s64
					1, 0, 4, 	// 2, 1, 5
					4, 7, 1		// 5, 8, 2
					
				},
				
				new float[] {
						
						1.0000f, 0.0000f, 0.0000f,
						1.0000f, 1.0000f, 0.0000f,
						0.0000f, 1.0000f, 0.0000f,
						0.0000f, 0.0000f, 0.0000f
					},
	
				new float[] {	
					87.f /255.f, 80.f / 255.f, 3.f / 255.f, 1.f,  // V1
					228.f / 255.f, 211.f / 255.f, 21.f / 255.f, 1.f, 1.f,	// V2
					228.f / 255.f, 211.f / 255.f, 21.f / 255.f, 1.f, 1.f,  // V3
					87.f /255.f, 80.f / 255.f, 3.f / 255.f, 1.f,  // V4
					172.f /255.f, 159.f / 255.f, 12.f / 255.f, 1.f,  // V5
					172.f /255.f, 159.f / 255.f, 12.f / 255.f, 1.f,	// V6
					228.f / 255.f, 211.f / 255.f, 21.f / 255.f, 1.f, 1.f,  // V7
					228.f / 255.f, 211.f / 255.f, 21.f / 255.f, 1.f, 1.f,  // V8
				}
			
			);
		
		
		m_ParedEdificio= a_Pared;
		
	} // GLParedEdificio
	
	
	/** Devuélve los vértices de la pared a partir de los punto V1 y V2.
	 * 
	 */
	public static float[] getVertices( GLVertice a_V1, GLVertice a_V2, float a_Ancho )
	{
		
		if ( a_V1.getX() == a_V2.getX() ) {
			
			return new float[] {	
					a_V1.getX(), 			0.f, 			a_V1.getY(),	// V1
					a_V1.getX() + a_Ancho, 	0.f, 			a_V1.getY(),	// V2
					a_V2.getX() + a_Ancho, 	0.f, 			a_V2.getY(),	// V3
					a_V2.getX(), 			0.f, 			a_V2.getY(), 	// V4
					a_V1.getX(), 			a_V1.getZ(), 	a_V1.getY(), 	// V5
					a_V2.getX(), 			a_V2.getZ(), 	a_V2.getY(),	// V6
					a_V2.getX() + a_Ancho, 	a_V2.getZ(), 	a_V2.getY(), 	// V7
					a_V1.getX() + a_Ancho, 	a_V1.getZ(), 	a_V1.getY()  	// V8	
						};
		}
		else if (  a_V1.getY() == a_V2.getY()) {
			
			
			return new float[] {	
					a_V1.getX(), 	0.f, 			a_V1.getY(),			// V1
					a_V1.getX(), 	0.f, 			a_V1.getY() + a_Ancho,	// V2
					a_V2.getX(), 	0.f, 			a_V2.getY() + a_Ancho,	// V3
					a_V2.getX(), 	0.f, 			a_V2.getY(), 			// V4
					a_V1.getX(), 	a_V1.getZ(), 	a_V1.getY(), 			// V5
					a_V2.getX(), 	a_V2.getZ(), 	a_V2.getY(),			// V6
					a_V2.getX(), 	a_V2.getZ(), 	a_V2.getY() + a_Ancho, 	// V7
					a_V1.getX(), 	a_V1.getZ(), 	a_V1.getY() + a_Ancho  	// V8	
						};
		}
		
		
		return null;
	} // getVertices
	
	
	/** Método abstracto que debe redefinir las clases que lo hereran
	 * 
	 * @param a_Gl
	 */
	public void draw( GL10 a_Gl ) 
	{
		
		if ( m_ParedEdificio == null ) {
			
			return;
		}
		
		
		
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
	
//		// Habilita el buffer para el color del grafico		 
//		a_Gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
//		 
//		// Señala donde se encuentra el buffer del color		 
//		a_Gl.glColorPointer(4, GL10.GL_FLOAT, 0, m_ColorBuffer );
		
		a_Gl.glColor4f( 0.9f, 0.9f, 0.6f, 1.f );
		
		a_Gl.glLineWidth( 1.f ); 
		 
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
	
} // GLParedEdificio
