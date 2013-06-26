package com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario;

import com.supermarket_frontoffice.modelo_datos.EstanteriaEstante;

public class GLEstanteriaEstanteNormal extends GLEstanteriaEstante
{

	/** Constructor
	 * 
	 * @param a_Estante
	 */
	public GLEstanteriaEstanteNormal( EstanteriaEstante a_Estante ) 
	{
		
		
//		v  63.3771 30.3087 -1.7187
//		v  -0.8294 30.3087 -1.7187
//		v  -0.8294 25.5990 -1.7187
//		v  63.3771 25.5990 -1.7187
//		v  -0.8294 28.5753 -20.0604
//		v  63.3771 28.5753 -20.0604
//		v  -0.8294 28.5930 -34.4284
//		v  63.3771 28.5930 -34.4284
//		v  -0.8294 28.5930 -34.6046
//		v  63.3771 28.5930 -34.6046
//		v  -0.8294 30.8420 -34.0172
//		v  63.3771 30.8420 -34.0172
//		v  -0.8294 30.8420 -33.8214
//		v  63.3771 30.8420 -33.8214
//		v  -0.8294 30.3133 -34.0524
//		v  63.3771 30.3133 -34.0524
		
		super( a_Estante,  
				new float[] {				/* 16 Vértices */
				a_Estante.getLargo(), 	/*30.3087f*/ a_Estante.getAlto() - 0.5333f, -1.7187f,
				-0.8294f, 				/*30.3087f*/ a_Estante.getAlto() - 0.5333f, -1.7187f,
				-0.8294f, 				/*25.5990f*/ a_Estante.getAlto() - 5.243f, -1.7187f,
				a_Estante.getLargo(), 	/*25.5990f*/ a_Estante.getAlto() - 5.243f, -1.7187f,
				-0.8294f, 				/*28.5753f*/ a_Estante.getAlto() - 2.2667f, /*-20.0604f*/ -a_Estante.getAncho() + 14.5442f,
				a_Estante.getLargo(), 	/*28.5753f*/ a_Estante.getAlto() - 2.2667f, /*-20.0604f*/ -a_Estante.getAncho() + 14.5442f,
				-0.8294f, 				/*28.5930f*/ a_Estante.getAlto() - 2.249f, /*-34.4284f */ -a_Estante.getAncho() + 0.1762f,
				a_Estante.getLargo(),	/*28.5930f*/ a_Estante.getAlto() - 2.249f, /*-34.4284f */ -a_Estante.getAncho() + 0.1762f,
				-0.8294f, 				/*28.5930f*/ a_Estante.getAlto() - 2.249f, /*-34.6046f */ -a_Estante.getAncho(),
				a_Estante.getLargo(), 	/*28.5930f*/ a_Estante.getAlto() - 2.249f, /*-34.6046f*/ -a_Estante.getAncho(),
				-0.8294f, 				/*30.8420f*/ a_Estante.getAlto()		 , /*-34.0172f*/ -a_Estante.getAncho() + 0.5874f,
				a_Estante.getLargo(), 	/*30.8420f*/ a_Estante.getAlto()		 , /*-34.0172f*/ -a_Estante.getAncho() + 0.5874f,
				-0.8294f, 				/*30.8420f*/ a_Estante.getAlto()		 , /*-33.8214f*/ -a_Estante.getAncho() + 0.7832f,
				a_Estante.getLargo(), 	/*30.8420f*/ a_Estante.getAlto()		 , /*-33.8214f*/ -a_Estante.getAncho() + 0.7832f,
				-0.8294f, 				/*30.3133f*/ a_Estante.getAlto() - 0.5287f, /*-34.0524f*/ -a_Estante.getAncho() + 0.5522f,
				a_Estante.getLargo(), 	/*30.3133f*/ a_Estante.getAlto() - 0.5287f, /*-34.0524f*/ -a_Estante.getAncho() + 0.5522f,
				},
								
				new float[] {  /* 12 Normales */
				
					0.0000f, 0.0000f, 1.0000f,
					-0.0000f, -0.9871f, -0.1602f,
					0.0000f, -1.0000f, -0.0012f,
					-0.0000f, -1.0000f, -0.0012f,
					0.0000f, -1.0000f, -0.0000f,
					-0.0000f, 0.2527f, -0.9675f,
					-0.0000f, 1.0000f, -0.0000f,
					0.0000f, -0.4004f, 0.9163f,
					-0.0000f, 1.0000f, 0.0001f,
					0.0000f, 1.0000f, 0.0001f,
					1.0000f, 0.0000f, -0.0000f,
					-1.0000f, 0.0000f, -0.0000f
				},
				
				new short[ ] {  /* 28 Caras */
					//s 1
					0, 1, 2, // 1/1/1 2/1/1 3/1/1 
					2, 3, 0, //f 3/1/1 4/1/1 1/1/1 
					//s 4
					3, 2, 4, //f 4/1/2 3/1/2 5/1/2 
					4, 5, 3,//f 5/1/2 6/1/2 4/1/2 
					//s 2
					5, 4, 6, //f 6/1/3 5/1/4 7/1/3 
					6, 7, 5, //f 7/1/3 8/1/3 6/1/3 
					//s 4
					7, 6, 8, //f 8/1/5 7/1/5 9/1/5 
					8, 9, 7, //f 9/1/5 10/1/5 8/1/5 
					//s 2
					9, 8, 10, //f 10/1/6 9/1/6 11/1/6 
					10, 11, 9, //f 11/1/6 12/1/6 10/1/6 
					//s 4
					11, 10, 12, //f 12/1/7 11/1/7 13/1/7 
					12, 13, 11, //f 13/1/7 14/1/7 12/1/7 
					//s 2
					13, 12, 14, //f 14/1/8 13/1/8 15/1/8 
					14, 15, 13, //f 15/1/8 16/1/8 14/1/8 
					//s 4
					15, 14, 1, //f 16/1/9 15/1/10 2/1/9 
					1, 0, 15, //f 2/1/9 1/1/9 16/1/9 
					//s 16
					5, 15, 0, //f 6/1/11 16/1/11 1/1/11 
					0, 3, 5, //f 1/1/11 4/1/11 6/1/11 
					7, 9, 15, //f 8/1/11 10/1/11 16/1/11 
					15, 5, 7, //f 16/1/11 6/1/11 8/1/11 
					11, 13, 15, //f 12/1/11 14/1/11 16/1/11 
					15, 9, 11, //f 16/1/11 10/1/11 12/1/11 
					10, 8, 14, //f 11/1/12 9/1/12 15/1/12 
					14, 12, 10, //f 15/1/12 13/1/12 11/1/12 
					1, 14, 4, //f 2/1/12 15/1/12 5/1/12 
					4, 2, 1, //f 5/1/12 3/1/12 2/1/12 
					14, 8, 6, //f 15/1/12 9/1/12 7/1/12 
					6, 4, 14,//f 7/1/12 5/1/12 15/1/12 
				},
				
				new float[] {	/* 1 Texture Coords */
						
						1.0000f, 0.0000f, 0.0000f
				},

				new float[] {	
					0.8f, 0.8f, 0.8f, 1.f,  
					0.8f, 0.8f, 0.8f, 1.f,
					0.8f, 0.8f, 0.8f, 1.f,  
					0.8f, 0.8f, 0.8f, 1.f,
					0.8f, 0.8f, 0.8f, 1.f, 
					0.8f, 0.8f, 0.8f, 1.f,
					0.8f, 0.8f, 0.8f, 1.f,
					0.8f, 0.8f, 0.8f, 1.f,
					0.9f, 0.9f, 0.9f, 1.f,  
					0.9f, 0.9f, 0.9f, 1.f,
					0.9f, 0.9f, 0.9f, 1.f,  
					0.9f, 0.9f, 0.9f, 1.f,
					0.9f, 0.9f, 0.9f, 1.f,  
					0.9f, 0.9f, 0.9f, 1.f,
					0.9f, 0.9f, 0.9f, 1.f,  
					0.9f, 0.9f, 0.9f, 1.f
				}
				
		);
		
	} // GLEstanteriaEstanteNormal
	
	
} // GLEstanteriaEstanteNormal
