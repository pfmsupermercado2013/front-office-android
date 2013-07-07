package com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario;

import javax.microedition.khronos.opengles.GL10;

import android.opengl.Matrix;
import android.util.Log;

import com.supermarket_frontoffice.modelo_datos.Estanteria;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLVertice;


/** @class GLEstanteriaDoble
 *  @brief 
 * 
 * @author fjvegaf
 *
 */
public class GLEstanteriaDoble extends GLEstanteria 
{
	
	private static final String TAG= "GLEstanteriaDoble";

	/** Constructor
	 * 
	 * @param a_Estanteria
	 */
	public GLEstanteriaDoble( Estanteria a_Estanteria )
	{
		super( a_Estanteria );
	} // GLEstanteriaDoble
	
	
	
	/** Dibuja la estantería
	 * 
	 * @param a_Gl
	 */
	public void draw( GL10 a_Gl )
	{
		
		a_Gl.glTranslatef( m_CoordenadaX, 0, m_CoordenadaY );
		a_Gl.glRotatef( m_RotacionXY, 0, 1, 0 ); //
		
		float largoSeccion= 0.f;
		
		short cont= 1;
		for ( GLEstanteriaSeccion glSeccion: m_ListaGLEstanteriaSeccion ) {
			
			glSeccion.draw( a_Gl );
			
			++cont;
			
			/// Prepara la posición para la siguiente sección
			/// Si la sección es par se coloca a la derecha. Los inpares a la izquierda
			///
			if ( cont % 2 == 0 ) {
				
				/// Si es par, se translada la longitud de la seccion y se rota para que pinte en sentido contrario
				
				a_Gl.glTranslatef( ( glSeccion.getEstanteriaSeccion().getLargo() ) / 100.f, 0.f, 0.f );
				a_Gl.glRotatef( -180.f, 0, 1, 0 ); //
				largoSeccion += glSeccion.getEstanteriaSeccion().getLargo() / 100.f;
			}
			else {
				
				///
				/// Si es impar se situa a la izquierda, después de la anterior
				///
				a_Gl.glRotatef( 180.f, 0, 1, 0 ); //
	
			}

		}
		
		if ( cont % 2 == 0 ) {
			
			a_Gl.glRotatef( 180.f, 0, 1, 0 ); //
		}
		
		a_Gl.glTranslatef( -largoSeccion, 0.f, 0.f );
		a_Gl.glRotatef( -m_RotacionXY, 0, 1, 0 ); //
		a_Gl.glTranslatef( -m_CoordenadaX, 0, -m_CoordenadaY );
		
		//m_Seccion.draw( a_Gl );
	} // draw
	
	
	/**
	 * 
	 */
	public void calcularCoordenadasRealSecciones(   )
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
				
				
				Log.d( TAG, "[" + cont +"][Estanteria:" + super.m_Estanteria.getId() + "][Seccion:" + glSeccion.getEstanteriaSeccion().getId() + "][Posicion:" + glSeccion.getCoordenadaRealSeccion().toString() + "]"  );
				
				/// Prepara la posición para la siguiente sección
				/// Si la sección es par se coloca a la derecha. Los inpares a la izquierda
				///
				if ( cont % 2 == 0 ) {
					
					Matrix.translateM( matrixModelo, 0, -glSeccion.getEstanteriaSeccion().getLargo() / 100.f, 0.f, 0.f );
				}
				
				++cont;

			}
		}
		
			
		
	} // calcularCoordenadasRealSecciones
	
} // end class GLEstanteriaDoble
