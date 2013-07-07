package com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario;

import javax.microedition.khronos.opengles.GL10;

import android.opengl.Matrix;
import android.util.Log;


import com.supermarket_frontoffice.modelo_datos.Estanteria;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLVertice;


/** @class GLEstanteriaSimple
 *  @brief 
 * 
 * @author fjvegaf
 *
 */
public class GLEstanteriaSimple extends GLEstanteria 
{

	
	private static final String TAG= "GLEstanteriaSimple";
	
	/** Constructor
	 * 
	 * @param a_Estanteria
	 */
	public GLEstanteriaSimple( Estanteria a_Estanteria )
	{
		
		super( a_Estanteria );
		
	} // GLEstanteriaSimple
	
	
	/** Dibuja la estantería
	 * 
	 * @param a_Gl
	 */
	public void draw( GL10 a_Gl )
	{
		
		GLVertice currentPosicion= new GLVertice( super.m_CoordenadaX, super.m_CoordenadaY, 0.f );
		
		a_Gl.glTranslatef( super.m_CoordenadaX, 0, super.m_CoordenadaY );
		a_Gl.glRotatef( super.m_RotacionXY, 0, 1, 0 ); //
		
		for ( GLEstanteriaSeccion glSeccion: m_ListaGLEstanteriaSeccion ) {
			
			glSeccion.draw( a_Gl );
			
			currentPosicion.incrementX( glSeccion.getEstanteriaSeccion().getLargo() / 100.f );

			a_Gl.glTranslatef( ( glSeccion.getEstanteriaSeccion().getLargo() ) / 100.f, 0.f, 0.f );
		}
		a_Gl.glTranslatef( -(currentPosicion.getX() - m_CoordenadaX ), 0.f, 0.f );
		
		a_Gl.glRotatef( -m_RotacionXY, 0, 1, 0 ); //
		a_Gl.glTranslatef( -m_CoordenadaX, 0, -m_CoordenadaY );
		
		
		//m_Seccion.draw( a_Gl );
	} // draw
	
	/**
	 * 
	 */
	public void calcularCoordenadasRealSecciones( )
	{
		
		if ( ( m_ListaGLEstanteriaSeccion != null ) && (!m_ListaGLEstanteriaSeccion.isEmpty() )) {
			
			float[] matrixModelo= new float[] {
					0.f, 0.f, 0.f, 0.f,
					0.f, 0.f, 0.f, 0.f,
					0.f, 0.f, 0.f, 0.f,
					0.f, 0.f, 0.f, 0.f
			};
			
		
			Matrix.setIdentityM( matrixModelo, 0 );		
			Matrix.translateM( matrixModelo, 0, -super.m_CoordenadaX, 0.f, -super.m_CoordenadaY );			
			Matrix.rotateM( matrixModelo, 0, super.m_RotacionXY, 0, 1, 0 );

			short cont= 1;			
			for ( GLEstanteriaSeccion glSeccion: m_ListaGLEstanteriaSeccion ) {

				glSeccion.setCoordenadaRealSeccion( new GLVertice( matrixModelo[12], matrixModelo[13], matrixModelo[14] ) );
							
				Log.d( TAG, "[" + cont +"][Estanteria:" + super.m_Estanteria.getId() + "][Seccion:" + glSeccion.getEstanteriaSeccion().getId() + 
						"][Posicion:" + glSeccion.getCoordenadaRealSeccion().toString() + "]"  );
				
				
				Matrix.translateM( matrixModelo, 0, -glSeccion.getEstanteriaSeccion().getLargo() / 100.f, 0.f, 0.f );
				++cont;
			}
		}
	} // calcularCoordenadasRealSecciones

	
	
	
} // end class GLEstanteriaSimple
