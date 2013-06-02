package com.supermarket_frontoffice.recorrido_optimo.supermarket_map;

import javax.microedition.khronos.opengles.GL10;


/** @class GLEstanteriaSeccionDoble
 * 
 * @author fjvegaf
 *
 */
public class GLEstanteriaSeccionDoble extends GLEstanteriaSeccion
{

	/**
	 * 
	 * @param a_EstanteriaSeccion
	 */
	public GLEstanteriaSeccionDoble( EstanteriaSeccion a_EstanteriaSeccion ) 
	{
		
		super(  a_EstanteriaSeccion,
				new float[] {				/* 48 Vértices */
				-0.2112f, 									 0.0000f, 0.0000f,
				/*63.7940f*/ a_EstanteriaSeccion.getLargo(), 0.0000f, 0.0000f,
				/*63.7940f*/ a_EstanteriaSeccion.getLargo(), 0.0000f, 1.6002f,
				-0.2112f, 									 0.0000f, 1.6002f,
				/*63.7940f*/ a_EstanteriaSeccion.getLargo(), /*135.1222f*/ a_EstanteriaSeccion.getAlto(), 1.6002f,
				/*63.7940f*/ a_EstanteriaSeccion.getLargo(), /*135.1222f*/ a_EstanteriaSeccion.getAlto(), 0.0000f,
				-0.2112f, 									 /*135.1222f*/ a_EstanteriaSeccion.getAlto(), 0.0000f,
				-0.2112f, 									 /*135.1222f*/ a_EstanteriaSeccion.getAlto(), 1.6002f,
				-0.2112f, 									 -0.0696f, 1.2587f,
				/*63.7940f*/ a_EstanteriaSeccion.getLargo(), -0.0696f, 1.2587f,
				/*63.7940f*/ a_EstanteriaSeccion.getLargo(), -0.0696f, /*33.2613f*/ a_EstanteriaSeccion.getAnchoBase() /2.f - 0.5069f,
				-0.2112f, 									 -0.0696f, /*33.2613f*/ a_EstanteriaSeccion.getAnchoBase() /2.f - 0.5069f,
				/*63.7940f*/ a_EstanteriaSeccion.getLargo(), 5.3352f, /*33.2613f*/ a_EstanteriaSeccion.getAnchoBase() /2.f - 0.5069f,
				/*63.7940f*/ a_EstanteriaSeccion.getLargo(), 5.3352f, 1.2587f,
				-0.2112f, 									 5.3352f, 1.2587f,
				-0.2112f, 									 5.3352f, /*33.2613f*/ a_EstanteriaSeccion.getAnchoBase() /2.f - 0.5069f,
				-0.2112f, 									 4.9497f, 1.1967f,
				/*63.7940f*/ a_EstanteriaSeccion.getLargo(), 4.9497f, 1.1967f,
				/*63.7940f*/ a_EstanteriaSeccion.getLargo(), 4.9497f, /*33.7682f*/ a_EstanteriaSeccion.getAnchoBase() /2.f,
				-0.2112f, 									 4.9497f, /*33.7682f*/ a_EstanteriaSeccion.getAnchoBase() /2.f,
				/*63.7940f*/ a_EstanteriaSeccion.getLargo(), 5.7320f, /*33.7682f*/ a_EstanteriaSeccion.getAnchoBase() /2.f,
				/*63.7940f*/ a_EstanteriaSeccion.getLargo(), 5.7320f, 1.1967f,
				-0.2112f, 									 5.7320f, 1.1967f,
				-0.2112f, 									 5.7320f, /*33.7682f*/ a_EstanteriaSeccion.getAnchoBase() /2.f,
				/*63.7941f*/ a_EstanteriaSeccion.getLargo(), 0.0000f, -0.8738f,
				-0.2111f,	 								 0.0000f, -0.8738f,
				-0.2111f, 									 0.0000f, -2.4739f,
				/*63.7941f*/ a_EstanteriaSeccion.getLargo(), 0.0000f, -2.4739f,
				/*63.7941f*/ a_EstanteriaSeccion.getLargo(), /*135.1222f*/ a_EstanteriaSeccion.getAlto(), -0.8737f,
				/*63.7941f*/ a_EstanteriaSeccion.getLargo(), /*135.1222f*/ a_EstanteriaSeccion.getAlto(), -2.4738f,
				-0.2112f, 									 /*135.1222f*/ a_EstanteriaSeccion.getAlto(), -2.4739f,
				-0.2112f, 									 /*135.1222f*/ a_EstanteriaSeccion.getAlto(), -0.8737f,
				/*63.7941f*/ a_EstanteriaSeccion.getLargo(), -0.0697f, -2.1324f,
				-0.2112f, 									 -0.0697f, -2.1324f,
				-0.2111f, 								     -0.0696f, /*-34.1351f*/ -a_EstanteriaSeccion.getAnchoBase() /2.f + 0.5069f,
				/*63.7941f*/ a_EstanteriaSeccion.getLargo(), -0.0696f, /*-34.1350f*/ -a_EstanteriaSeccion.getAnchoBase() /2.f + 0.5069f,
				/*63.7941f*/ a_EstanteriaSeccion.getLargo(),  5.3352f, -2.1324f,
				/*63.7941f*/ a_EstanteriaSeccion.getLargo(),  5.3353f, /*-34.1350f*/ -a_EstanteriaSeccion.getAnchoBase() /2.f + 0.5069f,
				-0.2111f, 									  5.3352f, /*-34.1351f*/ -a_EstanteriaSeccion.getAnchoBase() /2.f + 0.5069f,
				-0.2112f, 									  5.3352f, -2.1324f,
				/*63.7941f*/ a_EstanteriaSeccion.getLargo(),  4.9497f, -2.0704f,
				-0.2112f, 									  4.9497f, -2.0704f,
				-0.2111f, 									  4.9497f, /*-34.6420f*/ -a_EstanteriaSeccion.getAnchoBase() /2.f,
				/*63.7941f*/ a_EstanteriaSeccion.getLargo(),  4.9497f, /*34.6420f*/ -a_EstanteriaSeccion.getAnchoBase() /2.f,
				/*63.7941f*/ a_EstanteriaSeccion.getLargo(),  5.7320f, -2.0704f,
				/*63.7941f*/ a_EstanteriaSeccion.getLargo(),  5.7320f, /*34.6420f*/ -a_EstanteriaSeccion.getAnchoBase() /2.f,
				-0.2111f, 									  5.7320f, /*34.6420f*/ -a_EstanteriaSeccion.getAnchoBase() /2.f,
				-0.2112f, 									  5.7320f, -2.0704f,
			},
							
			new float[] {  /* 9 Normales */
			
				0.0000f, -1.0000f, -0.0000f,
				0.0000f, 1.0000f, -0.0000f,
				0.0000f, 0.0000f, 1.0000f,
				0.0000f, 0.0000f, -1.0000f,
				-1.0000f, 0.0000f, -0.0000f,
				-0.0000f, -0.0000f, 1.0000f,
				-1.0000f, -0.0000f, -0.0000f,
				-0.0000f, 1.0000f, 0.0000f,
				-0.0000f, 0.0000f, 1.0000f,
			},
			
			new short[ ] {  /* 60 Caras */
				//	s 2
				0, 1, 2,	//	f 1/1/1 2/1/1 3/1/1 
				2, 3, 0,	//	f 3/1/1 4/1/1 1/1/1 
				//	s 4
				4, 5, 6,	//	f 5/1/2 6/1/2 7/1/2 
				6, 7, 4,	//	f 7/1/2 8/1/2 5/1/2 
				//	s 8
				3, 2, 4,	//	f 4/2/3 3/1/3 5/3/3 
				4, 7, 3,	//	f 5/3/3 8/4/3 4/2/3 
				//	s 32
				1, 0, 6,	//	f 2/2/4 1/1/4 7/3/4 
				6, 5, 1,	//	f 7/3/4 6/4/4 2/2/4 
				//	s 64
				0, 3, 7,	//	f 1/2/5 4/1/5 8/3/5 
				7, 6, 0,	//	f 8/3/5 7/4/5 1/2/5 
				
				//	usemtl 16___Defaultè
				//	s 2
				8, 9, 10,	//	f 9/1/1 10/1/1 11/1/1 
				10, 11, 8,	//	f 11/1/1 12/1/1 9/1/1 
				
				//	s 4
				12, 13, 14,	//	f 13/1/2 14/1/2 15/1/2 
				14, 15, 12,	//	f 15/1/2 16/1/2 13/1/2 
				//	s 8
				11, 10, 12,	//	f 12/2/3 11/1/3 13/3/3 
				12, 15, 11,	//	f 13/3/3 16/4/3 12/2/3 
				//	s 32
				9, 8, 14,	//	f 10/2/4 9/1/4 15/3/4 
				14, 13, 9,	//	f 15/3/4 14/4/4 10/2/4 
				//	s 64
				8, 11, 15,	//	f 9/2/5 12/1/5 16/3/5 
				15, 14, 8,	//	f 16/3/5 15/4/5 9/2/5 
				//	usemtl 16___Defaultïï
				//	s 2
				16, 17, 18,	//	f 17/1/1 18/1/1 19/1/1 
				18, 19, 16,	//	f 19/1/1 20/1/1 17/1/1 
				//	s 4
				20, 21, 22,	//	f 21/1/2 22/1/2 23/1/2 
				22, 23, 20,	//	f 23/1/2 24/1/2 21/1/2 
				//	s 8
				19, 18, 20,	//	f 20/2/3 19/1/3 21/3/3 
				20, 23, 19,	//	f 21/3/3 24/4/3 20/2/3 
				//	s 32
				17, 16, 22,	//	f 18/2/4 17/1/4 23/3/4 
				22, 21, 17,	//	f 23/3/4 22/4/4 18/2/4 
				//	s 64
				16, 19, 23,	//	f 17/2/5 20/1/5 24/3/5 
				23, 22, 16,	//	f 24/3/5 23/4/5 17/2/5 
				//	usemtl 16___Default
				//	s 2
				24, 25, 26,	//	f 25/1/1 26/1/1 27/1/1 
				26, 27, 24,	//	f 27/1/1 28/1/1 25/1/1 
				//	s 4
				28, 29, 30,	//	f 29/1/2 30/1/2 31/1/2 
				30, 31, 28,	//	f 31/1/2 32/1/2 29/1/2 
				//	s 8
				29, 27, 26,	//	f 30/3/4 28/1/4 27/2/4 
				26, 30, 29,	//	f 27/2/4 31/4/4 30/3/4 
				//	s 32
				31, 25, 24,	//	f 32/3/6 26/1/6 25/2/6 
				24, 28, 31,	//	f 25/2/6 29/4/6 32/3/6 
				//	s 64
				30, 26, 25,	//	f 31/3/7 27/1/7 26/2/7 
				25, 31, 30,	//	f 26/2/7 32/4/7 31/3/7 
				//	usemtl 16___Defaultè
				//	s 2
				32, 33, 34,	//	f 33/1/1 34/1/1 35/1/1 
				34, 35, 32,	//	f 35/1/1 36/1/1 33/1/1 
				//	s 4
				36, 37, 38,	//	f 37/1/8 38/1/8 39/1/8 
				38, 39, 36,	//	f 39/1/8 40/1/8 37/1/8 
				//	s 8
				37, 35, 34,	//	f 38/3/4 36/1/4 35/2/4 
				34, 38, 37,	//	f 35/2/4 39/4/4 38/3/4 
				//	s 32
				39, 33, 32,	//	f 40/3/6 34/1/6 33/2/6 
				32, 36, 39,	//	f 33/2/6 37/4/6 40/3/6 
				//	s 64
				38, 34, 33,	//	f 39/3/5 35/1/5 34/2/5 
				33, 39, 38,	//	f 34/2/5 40/4/5 39/3/5 
				
				//	usemtl 16___Defaultïï
				//	s 2
				40, 41, 42,	//	f 41/1/1 42/1/1 43/1/1 
				42, 43, 40,	//	f 43/1/1 44/1/1 41/1/1 
				//	s 4
				44, 45, 46,	//	f 45/1/8 46/1/8 47/1/8 
				46, 47, 44,	//	f 47/1/8 48/1/8 45/1/8 
				//	s 8
				45, 43, 42,	//	f 46/3/4 44/1/4 43/2/4 
				42, 46, 45,	//	f 43/2/4 47/4/4 46/3/4 
				//	s 32
				47, 41, 40,	//	f 48/3/9 42/1/9 41/2/9 
				40, 44, 47,	//	f 41/2/9 45/4/9 48/3/9 
				//	s 64
				46, 42, 41,	//	f 47/3/5 43/1/5 42/2/5 
				41, 47, 46,	//	f 42/2/5 48/4/5 47/3/5 

			},
			
			new float[] {	/* 4 Texture Coords */
					
				1.0000f, 0.0000f, 0.0000f,
				0.0000f, 0.0000f, 0.0000f,
				1.0000f, 1.0000f, 0.0000f,		
				0.0000f, 1.0000f, 0.0000f
			},

			new float[] {	
				
				
				0.6f, 0.6f, 0.6f, 1.f,  
				0.7f, 0.7f, 0.7f, 1.f,
				0.8f, 0.8f, 0.8f, 1.f,  
				0.8f, 0.8f, 0.8f, 1.f,
				
				0.6f, 0.6f, 0.6f, 1.f,   /// Alto 
				0.6f, 0.6f, 0.6f, 1.f,				
				0.7f, 0.7f, 0.7f, 1.f, 
				0.7f, 0.7f, 0.7f, 1.f,
				
				0.8f, 0.8f, 0.8f, 1.f, 
				0.8f, 0.8f, 0.8f, 1.f,  
				0.8f, 0.8f, 0.8f, 1.f,  
				0.9f, 0.9f, 0.9f, 1.f, 
				
				
				0.9f, 0.9f, 0.9f, 1.f, 
				0.9f, 0.0f, 0.0f, 1.f, 
				0.8f, 0.0f, 0.0f, 1.f, 
				0.8f, 0.0f, 0.0f, 1.f, 
				
				0.8f, 0.0f, 0.0f, 1.f, 
				0.8f, 0.0f, 0.0f, 1.f,				
				0.9f, 0.0f, 0.0f, 1.f, 
				0.9f, 0.0f, 0.0f, 1.f,
				
				0.9f, 0.0f, 0.0f, 1.f, 
				0.6f, 0.6f, 0.6f, 1.f, 
				0.6f, 0.6f, 0.6f, 1.f, 
				0.6f, 0.6f, 0.6f, 1.f,
								
				0.6f, 0.6f, 0.6f, 1.f,   /// Alto 
				0.6f, 0.6f, 0.6f, 1.f,				
				0.7f, 0.7f, 0.7f, 1.f, 
				0.7f, 0.7f, 0.7f, 1.f,
				
				0.7f, 0.7f, 0.7f, 1.f, 
				0.7f, 0.7f, 0.7f, 1.f,
				0.8f, 0.8f, 0.8f, 1.f, 
				0.8f, 0.8f, 0.8f, 1.f,
				
				0.8f, 0.0f, 0.0f, 1.f, 
				0.8f, 0.0f, 0.0f, 1.f, 
				0.8f, 0.0f, 0.0f, 1.f, 
				0.8f, 0.0f, 0.0f, 1.f,				
				
				1.0f, 0.0f, 0.0f, 1.f, 
				1.0f, 0.0f, 0.0f, 1.f, 
				1.0f, 0.0f, 0.0f, 1.f, 
				0.8f, 0.0f, 0.0f, 1.f, 
				
				0.8f, 0.0f, 0.0f, 1.f, 
				0.8f, 0.0f, 0.0f, 1.f,			
				1.0f, 0.0f, 0.0f, 1.f, 
				1.0f, 0.0f, 0.0f, 1.f, 
				
				1.0f, 0.0f, 0.0f, 1.f, 
				1.0f, 0.0f, 0.0f, 1.f, 
				1.0f, 0.0f, 0.0f, 1.f, 
				1.0f, 0.0f, 0.0f, 1.f,
								

			}
			
		);
	
	} // GLEstanteriaSeccionDoble
	
	
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
}
