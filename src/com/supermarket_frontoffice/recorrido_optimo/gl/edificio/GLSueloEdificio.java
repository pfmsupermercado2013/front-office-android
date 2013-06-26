package com.supermarket_frontoffice.recorrido_optimo.gl.edificio;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLObject;

import android.content.Context;


/** @class Dibuja el suelo del edificio
 * 
 * @author fjvegaf
 *
 */
public class GLSueloEdificio extends GLObject
{


	/** Constuctor por defecto
	 * 
	 */
	public GLSueloEdificio( )
	{
		
		//this( 0.f, 0.f, 0.f );
		this( 28000.f, 28000.f, 30.f );
	} // GLSueloEdificio
	
	
	/** Constructor
	 * 
	 * @param a_GroundWidth
	 * @param a_GroundLength
	 * @param a_FloorTileWidth
	 */
	public GLSueloEdificio( float a_GroundWidth, 
							float a_GroundLength, 
							float a_FloorTileWidth )
	{
		
		super( getListaVertices( a_GroundWidth, a_GroundLength, a_FloorTileWidth ), 
				null, 
				getListaCaras( a_GroundWidth, a_GroundLength, a_FloorTileWidth ) );
	} // GLSueloEdificio
	
	
	/**
	 * 
	 * @param a_GroundWidth
	 * @param a_GroundLength
	 * @param a_FloorTileWidth
	 * @return
	 */
	public static float[] getListaVertices( float a_GroundWidth, 
											float a_GroundLength, 
											float a_FloorTileWidth  )
	{
		
		
		ArrayList<Float>  listGroundVertices= new ArrayList<Float>();
		
				
		float fExtent = a_GroundWidth;
		float fStep = a_FloorTileWidth;
		//GLfloat y = -0.4f;
		float y = 0.0f;
		float iLine= 0;

		//for( iLine = 0; iLine <= fExtent; iLine += fStep ) {
		for( iLine = -fExtent; iLine <= fExtent; iLine += fStep ) {

			// glVertex3f(iLine, y, fExtent);    // Draw Z lines
			listGroundVertices.add( iLine );
			listGroundVertices.add( y );
			listGroundVertices.add( fExtent );
			
			// glVertex3f(iLine, y, -fExtent);
			listGroundVertices.add( iLine );
			listGroundVertices.add( y );
			listGroundVertices.add( -fExtent );
			
//			
//			groundCaras.add( cara++ );
//			groundCaras.add( cara++ );
			
			// glVertex3f(fExtent, y, iLine);
			listGroundVertices.add( fExtent );
			listGroundVertices.add( y );
			listGroundVertices.add( iLine );
			
			// glVertex3f(-fExtent, y, iLine);
			listGroundVertices.add( -fExtent );
			listGroundVertices.add( y );
			listGroundVertices.add( iLine );
			
//			groundCaras.add( cara++ );
//			groundCaras.add( cara++ );
			
		}
		
		float[] groundVertices= new float[ listGroundVertices.size() ];
		
		for ( int i= 0; i < listGroundVertices.size(); ++i) {
			
			groundVertices[i]= ( float ) listGroundVertices.get( i );
			
			//m_GroundColor[i]= 0.5f;
		}
		
		return groundVertices;
		
	} // 
	
	
	/**
	 * 
	 * @param a_GroundWidth
	 * @param a_GroundLength
	 * @param a_FloorTileWidth
	 * @return
	 */
	public static short[] getListaCaras( float a_GroundWidth, 
											float a_GroundLength, 
											float a_FloorTileWidth  )
	{
	
		
		ArrayList<Short>  listGroundCaras= new ArrayList<Short>();
		
		
		float fExtent = a_GroundWidth;
		float fStep = a_FloorTileWidth;
		//GLfloat y = -0.4f;
		float y = 0.0f;
		float iLine= 0;
		
		
		Short cara= 0;
		for( iLine = -fExtent; iLine <= fExtent; iLine += fStep ) {
		//for( iLine = 0; iLine <= fExtent; iLine += fStep ) {
		
//			// glVertex3f(iLine, y, fExtent);    // Draw Z lines
//			listGroundVertices.add( iLine );
//			listGroundVertices.add( y );
//			listGroundVertices.add( fExtent );
//			
//			// glVertex3f(iLine, y, -fExtent);
//			listGroundVertices.add( iLine );
//			listGroundVertices.add( y );
//			listGroundVertices.add( -fExtent );
			
			
			listGroundCaras.add( cara++ );
			listGroundCaras.add( cara++ );
			
//			// glVertex3f(fExtent, y, iLine);
//			listGroundVertices.add( fExtent );
//			listGroundVertices.add( y );
//			listGroundVertices.add( iLine );
//			
//			// glVertex3f(-fExtent, y, iLine);
//			listGroundVertices.add( -fExtent );
//			listGroundVertices.add( y );
//			listGroundVertices.add( iLine );
			
			listGroundCaras.add( cara++ );
			listGroundCaras.add( cara++ );
			
		}
			
		short[] groundCaras= new short[ listGroundCaras.size() ];
		
		for ( int i= 0; i < listGroundCaras.size(); ++i) {
			
			groundCaras[i]= ( short ) listGroundCaras.get( i );
		}

		
		return groundCaras;
	
	} // getListaCaras
	
	
	
	/** Método abstracto que debe redefinir las clases que lo hereran
	 * 
	 * @param a_Gl
	 */
	public void draw( GL10 a_Gl ) 
	{
		
		
		
		//a_Gl.glColor3f( 19.0f/ 255.f, 165.0f / 255.f, 227.0f / 255.f );		

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
		a_Gl.glVertexPointer(3, GL10.GL_FLOAT, 0, m_VertexBuffer );
		
		
//		// Habilita el buffer para el color del grafico		 
//		a_Gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
//		 
//		// Señala donde se encuentra el buffer del color		 
//		a_Gl.glColorPointer(4, GL10.GL_FLOAT, 0, m_GroundColorBuffer );
		
		a_Gl.glColor4f( 0.9f, 0.9f, 0.6f, 1.f );
		
		a_Gl.glLineWidth( 0.f ); 
		//Dibujamos las superficies		 
		//a_Gl.glDrawElements( GL10.GL_TRIANGLE_STRIP, m_Caras.length, GL10.GL_UNSIGNED_SHORT, m_IndexBuffer );
		//a_Gl.glDrawElements( GL10.GL_LINES, m_Caras.length, GL10.GL_UNSIGNED_SHORT, m_IndexBuffer );

		
		a_Gl.glDrawElements( GL10.GL_LINES, m_Caras.length, GL10.GL_UNSIGNED_SHORT, m_FacesBuffer );
		//a_Gl.glDrawArrays( GL10.GL_LINES, 0, m_GroundVertices.length );
			

		// Desactiva el buffer de los vertices		 
		a_Gl.glDisableClientState( GL10.GL_VERTEX_ARRAY );
		
	} // draw
	
	
} // end GLGround
