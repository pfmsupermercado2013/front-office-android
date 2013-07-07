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
		
//		a_Gl.glTranslatef( currentPosicion.getX(), 0.f, currentPosicion.getY() );
//		a_Gl.glRotatef( super.m_RotacionXY, 0, 1, 0 ); //
		
		a_Gl.glTranslatef( super.m_CoordenadaX, 0, super.m_CoordenadaY );
		a_Gl.glRotatef( super.m_RotacionXY, 0, 1, 0 ); //
		
		//float largoSeccion= 0.f;
		for ( GLEstanteriaSeccion glSeccion: m_ListaGLEstanteriaSeccion ) {
			
			glSeccion.draw( a_Gl );
			glSeccion.setCoordenadaRealSeccion( currentPosicion );
			
			currentPosicion.incrementX( glSeccion.getEstanteriaSeccion().getLargo() / 100.f );
//			a_Gl.glTranslatef( currentPosicion.getX() - m_CoordenadaX, 0.f, 0.f );
			
			a_Gl.glTranslatef( ( glSeccion.getEstanteriaSeccion().getLargo() ) / 100.f, 0.f, 0.f );
			//largoSeccion += glSeccion.getEstanteriaSeccion().getLargo() / 100.f;
		}
		a_Gl.glTranslatef( -(currentPosicion.getX() - m_CoordenadaX ), 0.f, 0.f );
		
		//a_Gl.glTranslatef( -largoSeccion, 0.f, 0.f );
		a_Gl.glRotatef( -m_RotacionXY, 0, 1, 0 ); //
		a_Gl.glTranslatef( -m_CoordenadaX, 0, -m_CoordenadaY );
		
		//a_Gl.glTranslatef( -currentPosicion.getX(), 0, -currentPosicion.getY() );
		
		//m_Seccion.draw( a_Gl );
	} // draw
	
	/**
	 * 
	 */
	public void calcularCoordenadasRealSecciones(   )
	{
		
		if ( ( m_ListaGLEstanteriaSeccion != null ) && (!m_ListaGLEstanteriaSeccion.isEmpty() )) {
			
			float[] matrixRotacion= new float[16];
			
			float[] vectorTranslacionInicial= new float[] {super.m_CoordenadaX, 0.f, super.m_CoordenadaY, 1.f };
			//float[] vectorTranslacion= new float[] { 0.f, 0.f, 0.f, 0.f };
			
			
			Matrix.setIdentityM( matrixRotacion, 0 );		
			//Matrix.translateM( matrixRotacion, 0, super.m_CoordenadaX, 0.f, super.m_CoordenadaY );			
			
			Matrix.rotateM( matrixRotacion, 0, super.m_RotacionXY, 0, 1, 0 );
			Matrix.multiplyMV( vectorTranslacionInicial, 0, matrixRotacion, 0, vectorTranslacionInicial, 0 );
			
			
			//GLVertice currentPosicion= new GLVertice( super.m_CoordenadaX, super.m_CoordenadaY, 0.f );
			GLVertice currentPosicion= new GLVertice( ); //vectorModelo[0], vectorModelo[1], vectorModelo[2] );
			
			
			
			//Matrix.multiplyMV( vectorTranslacion, 0, matrixRotacion, 0, vectorTranslacionInicial, 0 );
			
//			currentPosicion.setX( matrixRotacion[12] );
//			currentPosicion.setY( matrixRotacion[13] );
//			currentPosicion.setZ( matrixRotacion[14] );
			

			
			for ( GLEstanteriaSeccion glSeccion: m_ListaGLEstanteriaSeccion ) {
				

				currentPosicion.setX( vectorTranslacionInicial[0] );
				currentPosicion.setY( vectorTranslacionInicial[1] );
				currentPosicion.setZ( vectorTranslacionInicial[2] );
				
				
				
				glSeccion.setCoordenadaRealSeccion( currentPosicion );
				
				
				//Log.d( TAG, "[Estanteria:" + super.m_Estanteria.getId() + "][Seccion:" + glSeccion.getEstanteriaSeccion().getId() + "][Posicion:" + currentPosicion.toString() + "]"  );
				
				vectorTranslacionInicial[0] -= glSeccion.getEstanteriaSeccion().getLargo() / 100.f;
				Matrix.multiplyMV( vectorTranslacionInicial, 0, matrixRotacion, 0, vectorTranslacionInicial, 0 );
				
				//Matrix.translateM( matrixRotacion, 0, -glSeccion.getEstanteriaSeccion().getLargo() / 100.f, 0.f, 0.f );
				//currentPosicion.incrementX( glSeccion.getEstanteriaSeccion().getLargo() / 100.f );
			}
		}
	} // calcularCoordenadasRealSecciones

	
	
	
} // end class GLEstanteriaSimple
