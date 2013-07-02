package com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario;

import com.supermarket_frontoffice.modelo_datos.EstanteriaEstante;


/** @class GLEstanteriaEstanteBase
 *  @brief 
 * 
 * @author fjvegaf
 *
 */
public class GLEstanteriaEstanteBase extends GLEstanteriaEstante
{

	
	
	/** Constructor
	 * 
	 * @param a_Estante
	 */
	public GLEstanteriaEstanteBase( EstanteriaEstante a_Estante ) 
	{
		
		
		super( a_Estante,  
				new float[] {				
					a_Estante.getLargo() , 5.8002f, -1.5626f, 
					a_Estante.getLargo(),  5.8002f, -a_Estante.getAncho(), 
					-0.1315f,  5.8002f, -a_Estante.getAncho(), 
					-0.1315f, 5.8002f,  -1.5626f, 
				},
								
				new float[] { /// Normal
				
					0.0000f, 1.0000f, -0.0000f
				},
				
				new short[ ] { 
					// s 2
					0, 1, 2,	// 1, 2, 3,
					2, 3, 0,	// 3, 4, 1,	
				},
				
				new float[] {
						
						1.0000f, 0.0000f, 0.0000f
				},

				new float[] {	
					0.8f, 0.8f, 0.8f, 1.f,  
					0.8f, 0.8f, 0.8f, 1.f,
					0.9f, 0.9f, 0.9f, 1.f,  
					0.9f, 0.9f, 0.9f, 1.f,
				}
				
		);
		
	} // GLEstanteriaEstanteBase
	
	
	
} // end class GLEstanteriaEstanteBase
