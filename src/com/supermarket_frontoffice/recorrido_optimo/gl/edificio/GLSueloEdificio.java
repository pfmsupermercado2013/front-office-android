package com.supermarket_frontoffice.recorrido_optimo.gl.edificio;

import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;

import android.util.Log;

import com.supermarket_frontoffice.modelo_datos.ParedEdificio;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLColor;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLBaseObject;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLVertice;



/** @class Dibuja el suelo del edificio
 * 
 * @author fjvegaf
 *
 */
public class GLSueloEdificio extends GLBaseObject
{

	private static final String TAG= "GLSueloEdificio";
	
	private ArrayList< ParedEdificio > 				m_ListaParedes; ///< Lista de paderes del edificio
	
	private GLVertice								m_EsquinaInferiorIzquierda;
	private GLVertice 								m_EsquinaSuperiorDerecha;
	
	private float 									m_AnchoBaldosa;
	private ArrayList< GLBaldosaSueloEdificio >		m_ListaBaldosas;
	

	
	/** Constuctor por defecto
	 * 
	 * @param a_ListaParedes
	 */
	public GLSueloEdificio( ArrayList< ParedEdificio > 	a_ListaParedes )
	{
		
		
		//this( 0.f, 0.f, 0.f );
		this( a_ListaParedes, 28000.f, 28000.f, 30.f );
		
		m_ListaBaldosas= new ArrayList< GLBaldosaSueloEdificio >();
	} // GLSueloEdificio
	
	
	/** Constructor
	 * 
	 * @param a_GroundWidth
	 * @param a_GroundLength
	 * @param a_AnchoBaldosa	Ancho y alto de cada baldosa
	 */
	public GLSueloEdificio( ArrayList< ParedEdificio > 	a_ListaParedes,
							float a_GroundWidth, 
							float a_GroundLength, 
							float a_AnchoBaldosa )
	{
		
		super();
				
//		super( getListaVertices( a_GroundWidth, a_GroundLength, a_FloorTileWidth ), 
//				null, 
//				getListaCaras( a_GroundWidth, a_GroundLength, a_FloorTileWidth ) );
		
		m_ListaParedes= a_ListaParedes;
		
		m_EsquinaInferiorIzquierda= null;
		m_EsquinaSuperiorDerecha= null;
		m_AnchoBaldosa= a_AnchoBaldosa;
		
		/// Obtiene las esquinas inferior izquierda y superior derecha del suelo
		this.getEsquinas();
		
		/// Crea las baldosas que componen el suelo
		this.createBaldosas();
		
		super.setVertices( this.getListaVertices( a_GroundWidth, a_GroundLength, m_AnchoBaldosa ) );
		super.setCaras( this.getListaCaras( a_GroundWidth, a_GroundLength, m_AnchoBaldosa ) );
		
		
		
	} // GLSueloEdificio
	

	
	/** Obtiene las esquinas inferior izquierda y superior derecha.
	 * 
	 * Las esquinas se obtienen a partir de las paderes pasadas. 
	 * Se actualizan los atributos m_EsquinaInferiorIzquierda y m_EsquinaSuperiorDerecha 
	 * 
	 */
	private void getEsquinas( )
	{
		
		

		if ( ( m_ListaParedes == null ) || m_ListaParedes.isEmpty() ) {
			
			return;
		}
		
		for ( ParedEdificio pared: m_ListaParedes ) {
			
			if ( ( m_EsquinaInferiorIzquierda == null ) || 
				(( pared.getV1().getVertice().getX() <= m_EsquinaInferiorIzquierda.getX()) && ( pared.getV1().getVertice().getY() >= m_EsquinaInferiorIzquierda.getY() )))  {
				
				//Log.d( TAG, "*** Actualiza EsquinaInferiorIzquierda V1 ... ");
				m_EsquinaInferiorIzquierda= pared.getV1().getVertice();
			}
			else if (( pared.getV2().getVertice().getX() <= m_EsquinaInferiorIzquierda.getX()) && ( pared.getV2().getVertice().getY() >= m_EsquinaInferiorIzquierda.getY()) ) {
				
				//Log.d( TAG, "*** Actualiza EsquinaInferiorIzquierda V2 ... ");
				m_EsquinaInferiorIzquierda= pared.getV2().getVertice();
			}
			
			if ( ( m_EsquinaSuperiorDerecha == null ) || 
					(( pared.getV1().getVertice().getX() >= m_EsquinaSuperiorDerecha.getX()) && ( pared.getV1().getVertice().getY() <= m_EsquinaSuperiorDerecha.getY()))) {
				
				//Log.d( TAG, "*** Actualiza EsquinaSuperiorDerecha V1... ");
				m_EsquinaSuperiorDerecha= pared.getV1().getVertice();
			}
			else if (( pared.getV2().getVertice().getX() >= m_EsquinaSuperiorDerecha.getX()) && ( pared.getV2().getVertice().getY() <= m_EsquinaSuperiorDerecha.getY()) ) {
			
				//Log.d( TAG, "*** Actualiza EsquinaSuperiorDerecha V2... ");
				m_EsquinaSuperiorDerecha= pared.getV2().getVertice();
			}
			
			
		} // end for
		
//		Log.d( TAG, "*** EsquinaInferiorIzquierda= "+ m_EsquinaInferiorIzquierda.toString() );
//		Log.d( TAG, "*** EsquinaSuperiorDerecha= " + m_EsquinaSuperiorDerecha.toString() );
		
	} // getEsquinas

	
	/** Crea todas las baldosas del suelo
	 * 
	 */
	private void createBaldosas()
	{
		
		m_ListaBaldosas= new ArrayList< GLBaldosaSueloEdificio >();
		
		int yCont= 0;
		int xCont= 0;
		for ( float x= m_EsquinaInferiorIzquierda.getX(); x < m_EsquinaSuperiorDerecha.getX(); x+= m_AnchoBaldosa  ) {
			
			xCont= ( yCont % 2 == 0 )? 0: 1;
			
			for ( float y= m_EsquinaInferiorIzquierda.getY(); y > m_EsquinaSuperiorDerecha.getY(); y-= m_AnchoBaldosa ) {
				
				m_ListaBaldosas.add( new GLBaldosaSueloEdificio( new GLVertice( x, y ), 
																new GLVertice( x + m_AnchoBaldosa, y - m_AnchoBaldosa ),
																( xCont % 2 == 0 )? new GLColor( 0.9f *255.f, 0.9f *255.f, 0.6f*255.f ): new GLColor( 255.f, 255.f, 255.f ) ) );
				
				++xCont;
			} // end for
		
			++yCont;
		} // end for
		
		
		
	} // createBaldosas
	
	
	/**
	 * 
	 * @param a_GroundWidth
	 * @param a_GroundLength
	 * @param a_FloorTileWidth
	 * @return
	 */
	private float[] getListaVertices( 	float a_GroundWidth, 
										float a_GroundLength, 
										float a_FloorTileWidth )
	{
		
		
		ArrayList<Float>  listGroundVertices= new ArrayList<Float>();
		

		float xIni= m_EsquinaInferiorIzquierda.getX();
		float xFin= m_EsquinaSuperiorDerecha.getX();
		for ( float y= m_EsquinaInferiorIzquierda.getY(); y > m_EsquinaSuperiorDerecha.getY(); y-= a_FloorTileWidth ) {
		
			listGroundVertices.add( xIni );
			listGroundVertices.add( 0.f );
			listGroundVertices.add( y );
			
			listGroundVertices.add( xFin );
			listGroundVertices.add( 0.f );
			listGroundVertices.add( y );
		
		} // end for
		
		
		float yIni= m_EsquinaInferiorIzquierda.getY();
		float yFin= m_EsquinaSuperiorDerecha.getY();
		for ( float x= m_EsquinaInferiorIzquierda.getX(); x < m_EsquinaSuperiorDerecha.getX(); x+= a_FloorTileWidth  ) {
		
			listGroundVertices.add( x );
			listGroundVertices.add( 0.f );
			listGroundVertices.add( yIni );
			
			listGroundVertices.add( x );
			listGroundVertices.add( 0.f );
			listGroundVertices.add( yFin );
		
		} // end for
		
		
		
//		for ( float x= m_EsquinaInferiorIzquierda.getX(); x < m_EsquinaSuperiorDerecha.getX(); x+= a_FloorTileWidth ) {
//			
////			listGroundVertices.add( x );
////			listGroundVertices.add( 0 );
////			listGroundVertices.add( x );
//	
//			for ( float y= m_EsquinaInferiorIzquierda.getY(); y > m_EsquinaSuperiorDerecha.getY(); y-= a_FloorTileWidth ) {
//				
//				listGroundVertices.add( x );
//				listGroundVertices.add( 0.f );
//				listGroundVertices.add( y );
//			}
//			
//		}
				
//		float fExtent = a_GroundWidth;
//		float fStep = a_FloorTileWidth;
//		//GLfloat y = -0.4f;
//		float y = 0.0f;
//		float iLine= 0;
//
//		//for( iLine = 0; iLine <= fExtent; iLine += fStep ) {
//		for( iLine = -fExtent; iLine <= fExtent; iLine += fStep ) {
//
//			// glVertex3f(iLine, y, fExtent);    // Draw Z lines
//			listGroundVertices.add( iLine );
//			listGroundVertices.add( y );
//			listGroundVertices.add( fExtent );
//			
//			// glVertex3f(iLine, y, -fExtent);
//			listGroundVertices.add( iLine );
//			listGroundVertices.add( y );
//			listGroundVertices.add( -fExtent );
//			
////			
////			groundCaras.add( cara++ );
////			groundCaras.add( cara++ );
//			
//			// glVertex3f(fExtent, y, iLine);
//			listGroundVertices.add( fExtent );
//			listGroundVertices.add( y );
//			listGroundVertices.add( iLine );
//			
//			// glVertex3f(-fExtent, y, iLine);
//			listGroundVertices.add( -fExtent );
//			listGroundVertices.add( y );
//			listGroundVertices.add( iLine );
//			
////			groundCaras.add( cara++ );
////			groundCaras.add( cara++ );
//			
//		}
		
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
	private short[] getListaCaras( 	float a_GroundWidth, 
									float a_GroundLength, 
									float a_FloorTileWidth  )
	{
	
		
		ArrayList<Short>  listGroundCaras= new ArrayList<Short>();
		
//		float xIni= m_EsquinaInferiorIzquierda.getX();
//		float xFin= m_EsquinaSuperiorDerecha.getX();
		
		short cara= 0;
//		float xIni= m_EsquinaInferiorIzquierda.getX();
//		float xFin= m_EsquinaSuperiorDerecha.getX();
		for ( float y= m_EsquinaInferiorIzquierda.getY(); y > m_EsquinaSuperiorDerecha.getY(); y-= a_FloorTileWidth ) {
		

			listGroundCaras.add( cara++ );
			listGroundCaras.add( cara++ );
		
		} // end for
		
		
//		float yIni= m_EsquinaInferiorIzquierda.getY();
//		float yFin= m_EsquinaSuperiorDerecha.getY();
		for ( float x= m_EsquinaInferiorIzquierda.getX(); x < m_EsquinaSuperiorDerecha.getX(); x+= a_FloorTileWidth  ) {
		
			listGroundCaras.add( cara++ );
			listGroundCaras.add( cara++ );
		
		} // end for
		

		
		
		
		
		
		
//		float fExtent = a_GroundWidth;
//		float fStep = a_FloorTileWidth;
//		//GLfloat y = -0.4f;
//		float y = 0.0f;
//		float iLine= 0;
//		
//		
//		Short cara= 0;
//		for( iLine = -fExtent; iLine <= fExtent; iLine += fStep ) {
//		//for( iLine = 0; iLine <= fExtent; iLine += fStep ) {
//		
////			// glVertex3f(iLine, y, fExtent);    // Draw Z lines
////			listGroundVertices.add( iLine );
////			listGroundVertices.add( y );
////			listGroundVertices.add( fExtent );
////			
////			// glVertex3f(iLine, y, -fExtent);
////			listGroundVertices.add( iLine );
////			listGroundVertices.add( y );
////			listGroundVertices.add( -fExtent );
//			
//			
//			listGroundCaras.add( cara++ );
//			listGroundCaras.add( cara++ );
//			
////			// glVertex3f(fExtent, y, iLine);
////			listGroundVertices.add( fExtent );
////			listGroundVertices.add( y );
////			listGroundVertices.add( iLine );
////			
////			// glVertex3f(-fExtent, y, iLine);
////			listGroundVertices.add( -fExtent );
////			listGroundVertices.add( y );
////			listGroundVertices.add( iLine );
//			
//			listGroundCaras.add( cara++ );
//			listGroundCaras.add( cara++ );
//			
//		}
			
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
		
		//a_Gl.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
		
		//a_Gl.glColor3f( 19.0f/ 255.f, 165.0f / 255.f, 227.0f / 255.f );		
		a_Gl.glLineWidth( 0.f ); 
		
		int cont= 0;
		for ( GLBaldosaSueloEdificio glBaldosa: m_ListaBaldosas ) {
			
			//Log.d( TAG, "Se pinta baldosa " + cont++ );
			glBaldosa.draw( a_Gl );
		}
		

//		// Contra las agujas del reloj		 
//		a_Gl.glFrontFace(GL10.GL_CCW);
//		 
////		// Habilitar el sacrificio de caras a ocultar		 
////		a_Gl.glEnable(GL10.GL_CULL_FACE);
////		 
////		// Aca se indica que cara se sacrificara, en este caso, la de atras		 
////		a_Gl.glCullFace(GL10.GL_BACK);
//		 
//		// Habilitar el buffer de vertices para la escritura y cuales se usaran para el renderizado
//		a_Gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
//		 
//		// Especifica la localizacion y el formato de los datos de un array de vertices a utilizar para el renderizado
//		a_Gl.glVertexPointer(3, GL10.GL_FLOAT, 0, m_VertexBuffer );
//		
//		
////		// Habilita el buffer para el color del grafico		 
////		a_Gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
////		 
////		// Señala donde se encuentra el buffer del color		 
////		a_Gl.glColorPointer(4, GL10.GL_FLOAT, 0, m_GroundColorBuffer );
//		a_Gl.glColor4f( 0.5f, 0.5f, 0.5f, 1.f );
//		//a_Gl.glColor4f( 0.9f, 0.9f, 0.6f, 1.f );
//		
//		
//		//Dibujamos las superficies		 
//		//a_Gl.glDrawElements( GL10.GL_TRIANGLE_STRIP, m_Caras.length, GL10.GL_UNSIGNED_SHORT, m_IndexBuffer );
//		//a_Gl.glDrawElements( GL10.GL_LINES, m_Caras.length, GL10.GL_UNSIGNED_SHORT, m_IndexBuffer );
//
//		a_Gl.glDrawElements( GL10.GL_LINES, m_Caras.length, GL10.GL_UNSIGNED_SHORT, m_FacesBuffer );
//		//a_Gl.glDrawElements( GL10.GL_LINES, m_Caras.length, GL10.GL_UNSIGNED_SHORT, m_FacesBuffer );
//		//a_Gl.glDrawArrays( GL10.GL_LINES, 0, m_GroundVertices.length );
//			
//
//		// Desactiva el buffer de los vertices		 
//		a_Gl.glDisableClientState( GL10.GL_VERTEX_ARRAY );
		
	} // draw
	
	
} // end GLGround
