package com.supermarket_frontoffice.recorrido_optimo.gl.edificio;


import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLColor;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLObject;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLVertice;


/** @class GLBaldosaSueloEdificio
 * 
 * @author fjvegaf
 *
 */
public class GLBaldosaSueloEdificio extends GLObject
{
	
	
	//private GLColor m_Color;  /// Color de la baldosa

	
	/**
	 * 
	 * @param a_PosicionInferiorIzquierda
	 * @param a_PosicionSuperiorDerecha
	 */
	public GLBaldosaSueloEdificio(  GLVertice a_PosicionInferiorIzquierda, 
									GLVertice a_PosicionSuperiorDerecha )
	{
		this( a_PosicionInferiorIzquierda, a_PosicionSuperiorDerecha, new GLColor( 0.9f *255.f, 0.9f *255.f, 0.6f*255.f ) );
	}
	
	/**
	 * 
	 * @param a_PosicionInferiorIzquierda
	 * @param a_PosicionSuperiorDerecha
	 */
	public GLBaldosaSueloEdificio(  GLVertice a_PosicionInferiorIzquierda, 
									GLVertice a_PosicionSuperiorDerecha,
									GLColor a_Color )
	{
		super( 				
				new float[] {		/// Vertices		
						a_PosicionInferiorIzquierda.getX(), 0.f, a_PosicionInferiorIzquierda.getY(), 
						a_PosicionInferiorIzquierda.getX(), 0.f, a_PosicionSuperiorDerecha.getY(), 
						a_PosicionSuperiorDerecha.getX(), 	0.f, a_PosicionSuperiorDerecha.getY(), 
						a_PosicionSuperiorDerecha.getX(), 	0.f, a_PosicionInferiorIzquierda.getY(), 
				},
							
				new float[] { /// Normal
				
					0.0000f, 1.0000f, -0.0000f
				},
				
				new short[ ] { 		/// Caras
					// s 2
					0, 1, 2,	// 1, 2, 3,
					2, 3, 0,	// 3, 4, 1,	
				},
				
				new float[] {		//
						
						1.0000f, 0.0000f, 0.0000f
				},
	
				null		/// Colores
//				new float[] {	
//						0.9f, 0.9f, 0.6f, 1.f,  
//						0.9f, 0.9f, 0.6f, 1.f,
//						0.9f, 0.9f, 0.6f, 1.f,  
//						0.9f, 0.9f, 0.6f, 1.f,
//				}
			);
		
		//m_Color= a_Color;
		
		super.setDefaultColor( a_Color );
		
		//a_Gl.glColor4f( 0.9f, 0.9f, 0.6f, 1.f );
		
		
	} // GLBaldosaSueloEdificio
	
	
	
} // end class GLBaldosaSueloEdificio
