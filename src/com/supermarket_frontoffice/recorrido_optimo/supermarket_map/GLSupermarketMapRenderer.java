package com.supermarket_frontoffice.recorrido_optimo.supermarket_map;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Vector;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import com.supermarket_frontoffice.recorrido_optimo.supermarket_map.Estanteria.TTipoEstanteria;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.opengl.GLU;
import android.opengl.GLSurfaceView.Renderer;

/**
 * 
 * @author fjvegaf
 *
 */
public class GLSupermarketMapRenderer implements Renderer 
{
	
	
	private ArrayList< GLEstanteria > m_ListaEstanteria;
	//private GLEstanteria m_Estanteria;
	
	private float 		m_AnchoSupermercado;
	private float 		m_LargoSupermercado;
	
	private float 		m_AspectRatio;
	
	private float 		m_NearPosition;
	private float 		m_FarPosition;
	
	private float 		m_RotateAngle;
	private float 		m_XPostInicial;
	private float 		m_YPostInicial;
	private float 		m_ZPostInicial;
	
	
	private float 		m_GroundVertices[];
	private short 		m_GroundCaras[];
	//private float 		m_GroundColor[];
	//private float 		m_GroundNormales[];
	//private float 		m_GroundCoordTextura[];
	private FloatBuffer m_GroundVerticesBuffer;
	private ShortBuffer m_GroundCarasBuffer;
	//private FloatBuffer m_GroundColorBuffer;
	
//	private short 		m_Caras[];
//	private float 		m_Colores[];
	
	
	private boolean 	m_ActivateRotation;
	private boolean 	m_ActivateView2d;
	
	
	
	
	
	/** Constructor
	 * 
	 */
	GLSupermarketMapRenderer( ArrayList< Estanteria > a_ListaEstanteria  ) 
	{
		
		//m_ListaEstanteria= a_ListaEstanteria;
		
		m_ListaEstanteria= new ArrayList< GLEstanteria >();
		
		for ( Estanteria estanteria: a_ListaEstanteria ) {
			
			switch ( estanteria.getTipoEstanteria() ) {
			
				case EstanteriaSimple:
					
					m_ListaEstanteria.add( new GLEstanteriaSimple( estanteria ) );
					break;
				
				case EstanteriaDoble:	
					m_ListaEstanteria.add( new GLEstanteriaDoble( estanteria ) );
					break;
					
				default:
					break;
				
			};
			
		}
		
		//m_ListaEstanteria.add( new GLEstanteria( (short)1, 30.f/ 100.f, 20.f / 100.f, 30.f ) ); 
		
		//m_Estanteria= new GLEstanteria( (short)1, 30.f/ 100.f, 20.f / 100.f, 30.f );
		
		m_AnchoSupermercado= 1000.f;
		m_LargoSupermercado= 5000.f;
	
		m_AspectRatio= 0.f;
		m_NearPosition= 0.1f;
		m_FarPosition= 100.0f;
		
		
		m_RotateAngle= 0.0f;
		m_XPostInicial= -500.0f / 100.f;
		m_YPostInicial= 0.0f;
		m_ZPostInicial= 0.f;
		
		m_ActivateRotation= false;
		
		m_ActivateView2d= false;
		
		
		this.createVerticesGround();
		
		
	}
	
	
	/**	Crea los vertices del suelo del supermercado
	 * 
	 */
	private void createVerticesGround( )
	{
		//private 	m_GroundVertices;
		ArrayList<Float>  groundVertices= new ArrayList<Float>();
		
		
		ArrayList<Short>  groundCaras= new ArrayList<Short>();
		
		float fExtent = 280.0f;
		float fStep = 0.3f;
		//GLfloat y = -0.4f;
		float y = 0.0f;
		float iLine= 0;

	
		
		Short cara= 0;
		for( iLine = -fExtent; iLine <= fExtent; iLine += fStep ) {

			// glVertex3f(iLine, y, fExtent);    // Draw Z lines
			groundVertices.add( iLine );
			groundVertices.add( y );
			groundVertices.add( fExtent );
			
			// glVertex3f(iLine, y, -fExtent);
			groundVertices.add( iLine );
			groundVertices.add( y );
			groundVertices.add( -fExtent );
			
			
			groundCaras.add( cara++ );
			groundCaras.add( cara++ );
			
			// glVertex3f(fExtent, y, iLine);
			groundVertices.add( fExtent );
			groundVertices.add( y );
			groundVertices.add( iLine );
			
			// glVertex3f(-fExtent, y, iLine);
			groundVertices.add( -fExtent );
			groundVertices.add( y );
			groundVertices.add( iLine );
			
			groundCaras.add( cara++ );
			groundCaras.add( cara++ );
			
		}
		
		m_GroundVertices= new float[ groundVertices.size() ];
		
		m_GroundCaras= new short[ groundCaras.size() ];
		
		for ( int i= 0; i < groundVertices.size(); ++i) {
			
			m_GroundVertices[i]= ( float ) groundVertices.get( i );
			
			//m_GroundColor[i]= 0.5f;
		}
		
		
	//	m_GroundColor= new float[ groundVertices.size() / 3 ];
		

		
		for ( int i= 0; i < groundCaras.size(); ++i) {
			
			m_GroundCaras[i]= ( short ) groundCaras.get( i );
		}
		
		
		// un float es de 4 bytes, por lo que multiplicaremos el numero de vertices por 4 
		ByteBuffer vbb= ByteBuffer.allocateDirect( m_GroundVertices.length * 4 );
		 
		vbb.order(ByteOrder.nativeOrder());	 
		m_GroundVerticesBuffer = vbb.asFloatBuffer();	 
		m_GroundVerticesBuffer.put( m_GroundVertices );	 
		m_GroundVerticesBuffer.position(0);
		
		// un short es de 2 bytes, por lo que multiplicaremos el numero de vertices por 2 
		ByteBuffer ibb2 = ByteBuffer.allocateDirect( m_GroundCaras.length * 2);
		ibb2.order(ByteOrder.nativeOrder());	 
		m_GroundCarasBuffer = ibb2.asShortBuffer();	 
		m_GroundCarasBuffer.put( m_GroundCaras );	 
		m_GroundCarasBuffer.position(0);
		
		
//		ByteBuffer colorbb = ByteBuffer.allocateDirect( m_GroundColor.length * 4);	 
//		colorbb.order( ByteOrder.nativeOrder() );	 
//		m_GroundColorBuffer = colorbb.asFloatBuffer();	 
//		m_GroundColorBuffer.put( m_GroundColor );		 
//		m_GroundColorBuffer.position(0);
		
	} // end createVerticesGround
	
	
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * android.opengl.GLSurfaceView.Renderer#onSurfaceCreated(javax.
         * microedition.khronos.opengles.GL10, javax.microedition.khronos.
         * egl.EGLConfig)
	 */
	@Override
	public void onSurfaceCreated( GL10 a_Gl, EGLConfig config ) 
	{
		
		
		// Establece el color de fondo (r,g,b,a)		 
		a_Gl.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
		 
		// Habilita el sombreado suave		 
		a_Gl.glShadeModel( GL10.GL_SMOOTH );
		 
		// Configura el buffer de profundidad		 
		a_Gl.glClearDepthf( 1.0f );
		 
		// Habilita el testeo de profundidad		 
		a_Gl.glEnable( GL10.GL_DEPTH_TEST );
		 
		// El tipo de testeo de profundidad a hacer		 
		a_Gl.glDepthFunc( GL10.GL_LEQUAL );
		 
		// Calculo de perspectivas		 
		a_Gl.glHint( GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST );
		
		
		
		//a_Gl.glDisable( GL10.GL_CULL_FACE | GL10.GL_DEPTH_TEST );
		
//		///
//		/// MODO MALLADO
//		///
//		glPolygonMode( GL_FRONT_AND_BACK, GL_LINE );
//		glDisable( GL_CULL_FACE | GL_DEPTH_TEST );
//		//glDisable( GL_DEPTH_TEST );
//		glClear( GL_COLOR_BUFFER_BIT );
		 
	} // onSurfaceCreated
	
	
	/* Dibuja el contorno y suelo del supermercado
	 * 
	 *
	 * @see
	 * android.opengl.GLSurfaceView.Renderer#onSurfaceChanged(javax.
         * microedition.khronos.opengles.GL10, int, int)
	 */
	public void drawGround( GL10 a_Gl )
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
		a_Gl.glVertexPointer(3, GL10.GL_FLOAT, 0, m_GroundVerticesBuffer );
		
		
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

		
		a_Gl.glDrawElements( GL10.GL_LINES, m_GroundCaras.length, GL10.GL_UNSIGNED_SHORT, m_GroundCarasBuffer );
		//a_Gl.glDrawArrays( GL10.GL_LINES, 0, m_GroundVertices.length );
			

		// Desactiva el buffer de los vertices		 
		a_Gl.glDisableClientState( GL10.GL_VERTEX_ARRAY );
		
	} // drawGround
	

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * android.opengl.GLSurfaceView.Renderer#onDrawFrame(javax.
         * microedition.khronos.opengles.GL10)
	 */
	@Override
	public void onDrawFrame( GL10 a_Gl ) 
	{
		
		// Limpia la pantalla y el buffer de profundidad		 
		a_Gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		 
		 
        // Set GL_MODELVIEW transformation mode
//		a_Gl.glMatrixMode( GL10.GL_MODELVIEW );
		
//		// Reemplaza la matriz actual con la matriz identidad		 
		a_Gl.glLoadIdentity();

		
		if ( m_ActivateView2d ) {
			
	        // Set GL_MODELVIEW transformation mode
			a_Gl.glMatrixMode( GL10.GL_MODELVIEW );
			
			// Reemplaza la matriz actual con la matriz identidad		 
			a_Gl.glLoadIdentity();
			
			GLU.gluLookAt( a_Gl, 0.f, -7.f, 0.f,
					 		0.f, 0.f, 0.f,
							1.f, 0.0f, 0.0f );
	
			a_Gl.glRotatef( 180.f, 1, 0, 0 ); //
			a_Gl.glRotatef( -90.f, 0, 1, 0 ); //
//			a_Gl.glTranslatef( 0, 0, 0 );
			
			a_Gl.glTranslatef( m_XPostInicial, m_YPostInicial, m_ZPostInicial );
		}
		else  {
			
	        // Set GL_MODELVIEW transformation mode
				a_Gl.glMatrixMode( GL10.GL_MODELVIEW );
				
				// Reemplaza la matriz actual con la matriz identidad		 
				a_Gl.glLoadIdentity();
				
				GLU.gluLookAt( a_Gl, 0.f, 0.8f, 3.f,
						 		0.f, 0.f, 0.f,
								0.f, 1.0f, 0.0f );
				
				a_Gl.glTranslatef( m_XPostInicial, m_YPostInicial, m_ZPostInicial );
		}
		
		
        // When using GL_MODELVIEW, you must set the camera view
        //GLU.gluLookAt( a_Gl, 0, 0, -5, 0f, 0f, 0f, 0f, 1.0f, 0.0f );
//		GLU.gluLookAt( a_Gl, 0.f /*m_XPostInicial*/, 2.f /*m_YPostInicial*/, -7.f /*m_ZPostInicial*/,
//				 		0.f, 0.f, 0.f,
//						0.f, 1.0f, 0.0f );
//		
//		GLU.gluLookAt( a_Gl, m_XPostInicial, m_YPostInicial, m_ZPostInicial,
//		 		0.f, 0.f, 0.f,
//				0.f, 1.0f, 0.0f );
		
			
			
		a_Gl.glRotatef( m_RotateAngle, 0, 1, 0 ); 
		
			
		
		
		// Traslada 4 unidades en el eje Z		 
		a_Gl.glRotatef( 2.f, 1, 0, 0 ); //
		//a_Gl.glRotatef( 180.f, 0, 1, 0 ); //
		
		//a_Gl.glRotatef( 180.f, 0, 1, 0 ); //
		//a_Gl.glRotatef( 15.f, 0, 1, 0 ); //
		//a_Gl.glRotatef( 30.f, 0, 1, 0 ); //
		
		//a_Gl.glTranslatef( -m_XPostInicial, -m_YPostInicial, -m_ZPostInicial );
		
		
		this.drawGround( a_Gl );
		
		// Dibuja nuestra piramide		 
		for ( GLEstanteria estanteria : m_ListaEstanteria ) {
			
			estanteria.draw( a_Gl );
		}
		
//		for (Tweet tweet : tweets) {                
//		    for(long forId : idFromArray){
//		        long tweetId = tweet.getId();
//		        if(forId != tweetId){
//		            String twitterString = tweet.getText();
//		            db.insertTwitter(twitterString, tweetId);
//		        }
//		    }
//		}
//		m_Estanteria.draw( a_Gl );
		
		//a_Gl.glTranslatef( m_XPostInicial, m_YPostInicial, m_ZPostInicial );
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * android.opengl.GLSurfaceView.Renderer#onSurfaceChanged(javax.
         * microedition.khronos.opengles.GL10, int, int)
	 */
	@Override
	public void onSurfaceChanged( GL10 a_Gl, int a_Width, int a_Height ) 
	{
		
		m_AspectRatio= (float) a_Width / (float) a_Height;
		
		a_Gl.glViewport( 0, 0, a_Width, a_Height );
		 
		// Selecciona la matriz de proyeccion
		a_Gl.glMatrixMode( GL10.GL_PROJECTION );
		 
		// Reinicia la matriz de proyeccion		 
		a_Gl.glLoadIdentity();
		 
		// Calcula la proporcion del aspecto de la ventana		 
		GLU.gluPerspective( a_Gl, 45.0f, m_AspectRatio, 0.1f, 100.0f );
		 
		// Selecciona la matriz de la vista del modelo		 
		a_Gl.glMatrixMode( GL10.GL_MODELVIEW );
		 
		// Reinicia la matriz de la vista del modelo		 
		a_Gl.glLoadIdentity();
	} // end onSurfaceChanged
	
	

	
	public void rotatePosicionXZ( float a_RotateAngle ) 
	{
		m_RotateAngle += a_RotateAngle;
	}
	
	public float getXPostInicial( ) 
	{
		return m_XPostInicial;
	}

	public void setXPostInicial( float a_XPostInicial ) 
	{
		m_XPostInicial = a_XPostInicial;
	}
	
	public void movePosicionX( float a_XPosicion ) 
	{
		m_XPostInicial += a_XPosicion;
	}


	public float getYPostInicial( ) 
	{
		return m_YPostInicial;
	}


	public void setYPostInicial( float a_YPostInicial ) 
	{
		m_YPostInicial = a_YPostInicial;
	}
	
	public void movePosicionY( float a_YPosicion ) 
	{
		m_YPostInicial += a_YPosicion;
	}

	
	public float getZPostInicial( ) 
	{
		return m_ZPostInicial;
	}

	
	public void setZPostInicial( float a_ZPostInicial ) 
	{
		m_ZPostInicial = a_ZPostInicial;
	}
	
	public void movePosicionZ( float a_ZPosicion ) 
	{
		m_ZPostInicial += a_ZPosicion;
	}
	
	
	public boolean isActivateRotation() 
	{
		return m_ActivateRotation;
	}


	public void setActivateRotation( boolean a_ActivateRotation ) 
	{
		m_ActivateRotation = a_ActivateRotation;
	}
	
	
	public boolean isActivateView2d() 
	{
		return m_ActivateView2d;
	}

	
	public void setActivateView2d( boolean a_ActivateView2d ) 
	{
		m_ActivateView2d = a_ActivateView2d;
	}
	
}