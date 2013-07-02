package com.supermarket_frontoffice.recorrido_optimo.gl.edificio;

import com.supermarket_frontoffice.modelo_datos.ParedEdificio;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLVertice;



public class GLParedSinPuertaEdificio extends GLParedEdificio 
{

	
	private static final String TAG= "GLParedSinPuertaEdificio";
	
	
	/** Constructor
	 * 
	 * @param a_Pared
	 */
	public GLParedSinPuertaEdificio( ParedEdificio a_Pared )
	{

		super( a_Pared );
		
		super.setVertices( this.calculateVertices( a_Pared.getV1().getVertice(), a_Pared.getV2().getVertice(), a_Pared.getAncho() ) ); 
		
		super.setNormales( 			
				new float[] {
					0.0000f, -1.0000f, -0.0000f,
					0.0000f, 1.0000f, -0.0000f,
					0.0000f, 0.0000f, 1.0000f,
					1.0000f, 0.0000f, 0.0000f,
					0.0000f, 0.0000f, -1.0000f,
					-1.0000f, 0.0000f, -0.0000f
				} );
		
		super.setCaras( 
				
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
						
					}
				);
		
		super.setCoordTextura( 				
				new float[] {		
						1.0000f, 0.0000f, 0.0000f,
						1.0000f, 1.0000f, 0.0000f,
						0.0000f, 1.0000f, 0.0000f,
						0.0000f, 0.0000f, 0.0000f
					} 
				);
		
		super.setColores( 
				
				new float[] {	
						250.0f/255.f, 250.0f/255.f, 250.0f/255.f, 1.f, // V1 
						250.0f/255.f, 250.0f/255.f, 250.0f/255.f, 1.f, // V2 
						250.0f/255.f, 250.0f/255.f, 250.0f/255.f, 1.f, // V3 
						250.0f/255.f, 250.0f/255.f, 250.0f/255.f, 1.f, // V4 
						184.0f/255.f, 188.0f/255.f, 151.0f/255.f, 1.f, // V5 
						184.0f/255.f, 188.0f/255.f, 151.0f/255.f, 1.f, // V6 
						184.0f/255.f, 188.0f/255.f, 151.0f/255.f, 1.f, // V7 
						184.0f/255.f, 188.0f/255.f, 151.0f/255.f, 1.f, // V8 
					}	
				);
		

		
	} // GLParedEdificio
	
	
	/** Devuélve los vértices de la pared a partir de los punto V1 y V2.
	 * 
	 */
	protected float[] calculateVertices( GLVertice a_V1, GLVertice a_V2, float a_Ancho )
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
	
} // end class 
