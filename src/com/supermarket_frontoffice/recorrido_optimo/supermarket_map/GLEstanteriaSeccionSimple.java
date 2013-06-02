package com.supermarket_frontoffice.recorrido_optimo.supermarket_map;

import javax.microedition.khronos.opengles.GL10;

/** @class GLEstanteriaSeccionSimple
 * 
 *  @brief Clase que dibuja en OpenGL una sección simple de una estantería.
 * 
 * @author fjvegaf
 *
 */
public class GLEstanteriaSeccionSimple extends GLEstanteriaSeccion
{
	
	
	public GLEstanteriaSeccionSimple( EstanteriaSeccion a_EstanteriaSeccion ) 
	{
		
		super(  a_EstanteriaSeccion,
				new float[] {				/* 24 Vértices */
				/*64.0054f*/ a_EstanteriaSeccion.getLargo(), 5.0179f,  -1.1970f , 
				0.0002f,  5.0179f ,  -1.1970f , 
				0.0002f,  5.0179f ,  /*-33.7686f*/ -a_EstanteriaSeccion.getAnchoBase() , 
				/*64.0054f*/ a_EstanteriaSeccion.getLargo() ,  5.0179f ,  /*-33.7686f*/ - a_EstanteriaSeccion.getAnchoBase(), 
				/*64.0054f*/ a_EstanteriaSeccion.getLargo(),  5.8002f ,  -1.1970f , 
				/*64.0054f*/ a_EstanteriaSeccion.getLargo() ,  5.8002f ,  /*-33.7686f*/  -a_EstanteriaSeccion.getAnchoBase(), 
				0.0002f,  5.8002f ,  /*-33.7686f*/ -a_EstanteriaSeccion.getAnchoBase(), 
				0.0002f,  5.8002f ,  -1.1970f , 
				/*64.0054f*/ a_EstanteriaSeccion.getLargo(),  -0.0014f ,  -1.2590f , 
				0.0002f,  -0.0014f,  -1.2590f, 
				0.0002f,  -0.0014f,  /*-33.2616f*/ -( a_EstanteriaSeccion.getAnchoBase() - 0.507f ), 
				/*64.0054f*/ a_EstanteriaSeccion.getLargo() ,  -0.0014f,  /*-33.2616f*/ -( a_EstanteriaSeccion.getAnchoBase() - 0.507f ), 
				/*64.0054f*/ a_EstanteriaSeccion.getLargo() ,  5.4035f,  -1.2590f, 
				/*64.0054f*/ a_EstanteriaSeccion.getLargo() ,  5.4035f,  /*-33.2616f*/ -( a_EstanteriaSeccion.getAnchoBase() - 0.507f ), 
				0.0002f,  5.4035f,  /* -33.2616f */ -( a_EstanteriaSeccion.getAnchoBase() - 0.507f ), 
				0.0002f,  5.4035f,  -1.2590f, 
				/*64.0054f*/ a_EstanteriaSeccion.getLargo() ,  0.0683f,  -0.0004f, 
				0.0002f,  0.0683f,  -0.0004f, 
				0.0002f,  0.0683f,  -1.6005f, 
				/*64.0054f*/ a_EstanteriaSeccion.getLargo() ,  0.0683f,  -1.6005f, 
				/*64.0054f*/ a_EstanteriaSeccion.getLargo() ,  /*135.1904f*/ a_EstanteriaSeccion.getAlto(),  -0.0004f, 
				/*64.0054f*/ a_EstanteriaSeccion.getLargo() ,  /*135.1904f*/ a_EstanteriaSeccion.getAlto(),  -1.6005f, 
				0.0002f ,  /*135.1904f*/ a_EstanteriaSeccion.getAlto(),  -1.6005f , 
				0.0002f , /*135.1904f*/  a_EstanteriaSeccion.getAlto(),  -0.0004f 
			},
							
			new float[] {  /* 5 Normales */
			
				0.0000f, -1.0000f, -0.0000f,
				1.0000f, 0.0000f, -0.0000f,
				0.0000f, 0.0000f, -1.0000f,
				0.0000f, 0.0000f, 1.0000f,
				0.0000f, 1.0000f, -0.0000f
			},
			
			new short[ ] {  /* 28 Caras */
				// s 2
				0, 1, 2,	// 1, 2, 3,
				2, 3, 0,	// 3, 4, 1,
				// s 16
				4, 0, 3,	// 5, 1, 4,
				3, 5, 4,	// 4, 6, 5,
				
				// s 8
				5, 3, 2,	// 6, 4, 3,
				2, 6, 5,	// 3, 7, 6,
				
				// s 32
				7, 1, 0,	// 8, 2, 1,
				0, 4, 7,	// 1, 5, 8,
				
				// s 2
				8, 9, 10,	// 9, 10, 11,
				10, 11, 8,	// 11, 12, 9,
				
				// s 4
				12, 13, 14,	// 13, 14, 15,
				14, 15, 12,	// 15, 16, 13,
				
				// s 16
				12, 8, 11, 	// 13, 9, 12,
				11, 13, 12,	// 12, 14, 13,
				
				// s 8
				13, 11, 10,	// 14, 12, 11,
				10, 14, 13,	// 11, 15, 14,
				
				// s 32
				15, 9, 8,	// 16, 10, 9,
				8, 12, 15,	// 9, 13, 16,
				
				// s 2
				16, 17, 18,	// 17, 18, 19,
				18, 19, 16,	// 19, 20, 17,
				
				// s 4 
				20, 21, 22,	// 21, 22, 23,
				22, 23, 20,	// 23, 24, 21,
				
				// s 16
				20, 16, 19,	// 21, 17, 20,
				19, 21, 20,	// 20, 22, 21,
				
				// s 8
				21, 19, 18,	// 22, 20, 19,
				18, 22, 21,	// 19, 23, 22,
				
				// s 32
				23, 17, 16,	// 24, 18, 17,
				16, 20, 23	// 17, 21, 24
			},
			
			new float[] {	/* 4 Texture Coords */
					
				1.0000f, 0.0000f, 0.0000f,
				1.0000f, 1.0000f, 0.0000f,
				0.0000f, 0.0000f, 0.0000f,
				0.0000f, 1.0000f, 0.0000f
			},

			new float[] {	
				1.0f, 0.0f, 0.0f, 1.f, 
				1.0f, 0.0f, 0.0f, 1.f, 
				1.0f, 0.0f, 0.0f, 1.f, 
				0.8f, 0.0f, 0.0f, 1.f, 
				0.8f, 0.0f, 0.0f, 1.f, 
				0.8f, 0.0f, 0.0f, 1.f,
				
				0.9f, 0.0f, 0.0f, 1.f, 
				0.9f, 0.0f, 0.0f, 1.f, 
				0.9f, 0.0f, 0.0f, 1.f, 
				0.8f, 0.0f, 0.0f, 1.f, 
				0.8f, 0.0f, 0.0f, 1.f, 
				0.8f, 0.0f, 0.0f, 1.f,
				
				0.8f, 0.0f, 0.0f, 1.f, 
				0.8f, 0.0f, 0.0f, 1.f, 
				0.8f, 0.0f, 0.0f, 1.f, 
				
				0.3f, 0.3f, 0.3f, 1.f,  
				0.4f, 0.4f, 0.4f, 1.f,  
				0.5f, 0.5f, 0.5f, 1.f, 
					
				0.6f, 0.6f, 0.6f, 1.f,  
				0.7f, 0.7f, 0.7f, 1.f,
				0.8f, 0.8f, 0.8f, 1.f,  
				0.8f, 0.8f, 0.8f, 1.f,
				0.9f, 0.9f, 0.9f, 1.f,  
				0.9f, 0.9f, 0.9f, 1.f
			}
			
		);
	
	} // GLEstanteriaSeccionSimple
	
	
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
		
		float totalAltura= 0.f;
		for ( GLEstanteriaEstante glEstante: m_ListaGLEstanteriaEstante ) {
			
			glEstante.draw( a_Gl );
			a_Gl.glTranslatef( 0.f, glEstante.getEstante().getAlto() / m_AspectRatio, 0.f );
			totalAltura += glEstante.getEstante().getAlto() / m_AspectRatio;
		}
		a_Gl.glTranslatef( 0.f, -totalAltura, 0.f );
		
	} // end draw

} // end class GLEstanteriaSeccionSimple
