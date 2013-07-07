package com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario;

import javax.microedition.khronos.opengles.GL10;

import android.opengl.Matrix;

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
				
//				a_Gl.glTranslatef( ( glSeccion.getEstanteriaSeccion().getLargo() ) / 100.f, 0.f, 0.f );
//				largoSeccion += glSeccion.getEstanteriaSeccion().getLargo() / 100.f;
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
			
			
			
			float[] matrixModelo= new float[16];
			float[] vectorTranslacion= new float[4];
			float[] vectorTranslacionInicial= new float[] {1.f, 1.f, 1.f, 1.f };
			
			Matrix.setIdentityM( matrixModelo, 0 );
			Matrix.translateM( matrixModelo, 0, super.m_CoordenadaX, 0.f, super.m_CoordenadaY );
			Matrix.rotateM( matrixModelo, 0, super.m_RotacionXY, 0, 1, 0 );
			
			
			GLVertice currentPosicion= new GLVertice( ); //super.m_CoordenadaX, super.m_CoordenadaY, 0.f );
			
			short cont= 1;
			for ( GLEstanteriaSeccion glSeccion: m_ListaGLEstanteriaSeccion ) {
				
				Matrix.multiplyMV( vectorTranslacion, 0, matrixModelo, 0, vectorTranslacionInicial, 0 );
				
				
				currentPosicion.setX( vectorTranslacion[0] );
				currentPosicion.setY( vectorTranslacion[1] );
				currentPosicion.setZ( vectorTranslacion[2] );
				
//				currentPosicion.setX( vectorTranslacion[12] );
//				currentPosicion.setY( vectorTranslacion[13] );
//				currentPosicion.setZ( vectorTranslacion[14] );
				
				glSeccion.setCoordenadaRealSeccion( currentPosicion );
				
			
				
				/// Prepara la posición para la siguiente sección
				/// Si la sección es par se coloca a la derecha. Los inpares a la izquierda
				///
				if ( cont % 2 == 0 ) {
					
					Matrix.translateM( matrixModelo, 0, -glSeccion.getEstanteriaSeccion().getLargo() / 100.f, 0.f, 0.f );
					
					/// Si es par, se translada la longitud de la seccion y se rota para que pinte en sentido contrario
					//currentPosicion.incrementX( glSeccion.getEstanteriaSeccion().getLargo() / 100.f );
				}
				
				++cont;

			}
		}
		
			
		
	} // calcularCoordenadasRealSecciones
	
} // end class GLEstanteriaDoble
