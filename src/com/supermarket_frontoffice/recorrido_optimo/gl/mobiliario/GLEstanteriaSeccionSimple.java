package com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario;


import com.supermarket_frontoffice.modelo_datos.EstanteriaSeccion;

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

			new float[] {					//// Colores
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
			},
			
			new float[] {					//// Colores Selección de productos
				
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
					233.f/255.f, 233.f/255.f, 31.f/255.f, 1.f,
				}
			
		);
	
	} // GLEstanteriaSeccionSimple
	

} // end class GLEstanteriaSeccionSimple
