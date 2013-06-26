package com.supermarket_frontoffice.recorrido_optimo.gl;

import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.modelo_datos.Estanteria;
import com.supermarket_frontoffice.recorrido_optimo.gl.edificio.GLSueloEdificio;
import com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario.GLCarritoCompra;
import com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario.GLEstanteria;
import com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario.GLEstanteriaDoble;
import com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario.GLEstanteriaSimple;
import com.supermarket_frontoffice.recorrido_optimo.xml.XmlResourceSupermercado;

import android.content.Context;
import android.opengl.GLU;
import android.opengl.GLSurfaceView.Renderer;
import android.util.Log;

/**
 * 
 * @author fjvegaf
 *
 */
public class GLSupermarketMapRenderer implements Renderer 
{
	
	private static final String TAG= "GLSupermarketMapRenderer";
	
	
	private XmlResourceSupermercado m_XmlResoursesSupermercado;		///< Clase que gestiona la lectura de los datos de los recursos Xml
	
	
	private GLSupermercado				m_GLSupermercado;			///< Objeto que dibuja todo el supermercado en OpenGL.
	//private ArrayList< GLEstanteria > m_ListaEstanteria;
	//private GLEstanteria m_Estanteria;
	
//	private float 		m_AnchoSupermercado;
//	private float 		m_LargoSupermercado;
	
	private float 		m_AspectRatio;								///< Ratio de escalado para la represeentación en OpenGL.
	
//	private float 		m_NearPosition;
//	private float 		m_FarPosition;
	
	private float 		m_RotateAngle;
	private float 		m_XPostInicial;
	private float 		m_YPostInicial;
	private float 		m_ZPostInicial;
	
	private boolean 	m_ActivateRotation;
	private boolean 	m_ActivateView2d;
	private float		m_ProcessZoom;
	
	//GLSueloEdificio		m_BuildingGround;
	GLCarritoCompra 	m_GlCarritoCompra;
	
	
	

	
	/** Constructor
	 * 
	 * @param a_Context
	 */
	GLSupermarketMapRenderer( Context a_Context, float a_ProcessZoom ) 
	{
		
		
		m_XmlResoursesSupermercado= new XmlResourceSupermercado( a_Context, R.xml.supermercado_edificio, R.xml.supermercado_mobiliario );
		
		m_GLSupermercado= null;
		//m_ListaEstanteria= new ArrayList< GLEstanteria >();	
					
//		m_AnchoSupermercado= 1000.f;
//		m_LargoSupermercado= 5000.f;
	
		m_AspectRatio= 0.f;
//		m_NearPosition= 0.1f;
//		m_FarPosition= 100.0f;
		
		
		m_RotateAngle= 0.0f;
		m_XPostInicial= -500.0f / 100.f;
		m_YPostInicial= 0.0f;
		m_ZPostInicial= 0.f;
		
		m_ActivateRotation= false;
		
		m_ActivateView2d= false;
		m_ProcessZoom= a_ProcessZoom;
		
				
		//m_BuildingGround= new GLSueloEdificio( 28000.f, 28000.f, 30.f );
		m_GlCarritoCompra= new GLCarritoCompra( a_Context );
		
		
		this.readXmlResources();
		
	} // GLSupermarketMapRenderer
	
	
	/** Lee de los Xml Resources los datos del Supermercado.
	 * 
	 *  Crea los objectos Opengl para representar los datos leídos.
	 * 
	 */
	public boolean readXmlResources()
	{
		
		
		Log.d( TAG, "Cargando el fichero XML Resources del Supermercado... ");

		if ( m_XmlResoursesSupermercado == null ) {
			
			Log.e( this.getClass().getSimpleName(), "No se ha creado el Objeto para la lectura de los Xml Resources del supermercado." );
			return false;
		}
		
		m_XmlResoursesSupermercado.read();
		
		m_GLSupermercado= new GLSupermercado( m_XmlResoursesSupermercado.getSupermercado() );


		return true;
	} // readXmlResources
		
	
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
		
		//Log.d( "GLSupermarketMapRendered", "Dibujando escenario ... " );
		
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
			
			GLU.gluLookAt( a_Gl, 0.f, -(float) m_ProcessZoom*7.f/10.f, 0.f,
					 		0.f, 0.f, 0.f,
							1.f, 0.0f, 0.0f );
	
			a_Gl.glRotatef( 180.f, 1, 0, 0 ); //
			a_Gl.glRotatef( -90.f, 0, 1, 0 ); //
//			a_Gl.glTranslatef( 0, 0, 0 );
			
			//a_Gl.glTranslatef( m_XPostInicial, m_YPostInicial, m_ZPostInicial );
		}
		else  {
			
	        // Set GL_MODELVIEW transformation mode
				a_Gl.glMatrixMode( GL10.GL_MODELVIEW );
				
				// Reemplaza la matriz actual con la matriz identidad		 
				a_Gl.glLoadIdentity();
				//Log.d( TAG, " Actual valor del Zoom= " + m_ProcessZoom );
				GLU.gluLookAt( a_Gl, 0.f, (float )m_ProcessZoom * 1.f /10.f, 0.8f,
						 		0.f, 0.9f, 0.f / 100.f,
								0.f, 1.0f, 0.0f );
				
//				GLU.gluLookAt( a_Gl, 0.f, 1.0f, 0.5f,
//				 		0.f, 0.9f, 0.f / 100.f,
//						0.f, 1.0f, 0.0f );
				
				
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
		
			//Log.d( "GLSupermarketMapRendered", "Dibujando el suelo" );
				
		a_Gl.glRotatef( m_RotateAngle, 0, 1, 0 ); 
		
		//Log.d( "GLSupermarketMapRendered", "Dibujando el carrito de la compra ... " );
		
		m_GlCarritoCompra.draw( a_Gl );
		//a_Gl.glTranslatef( 0, 50.f / 100.f, -50.f/ 100.f );	
		//Log.d( "GLSupermarketMapRendered", "Dibujado el carrito de la compra" );
		
		a_Gl.glTranslatef( m_XPostInicial, m_YPostInicial, m_ZPostInicial + 1.f );	
		
		
		// Traslada 4 unidades en el eje Z		 
		a_Gl.glRotatef( 2.f, 1, 0, 0 ); //
		//a_Gl.glRotatef( 180.f, 0, 1, 0 ); //
		
		//a_Gl.glRotatef( 180.f, 0, 1, 0 ); //
		//a_Gl.glRotatef( 15.f, 0, 1, 0 ); //
		//a_Gl.glRotatef( 30.f, 0, 1, 0 ); //
		
		//a_Gl.glTranslatef( -m_XPostInicial, -m_YPostInicial, -m_ZPostInicial );
		
		

		//m_BuildingGround.draw( a_Gl );
		
		
		m_GLSupermercado.draw( a_Gl );
		
//		// Dibuja nuestra piramide		 
//		for ( GLEstanteria estanteria : m_ListaEstanteria ) {
//			
//			//Log.d( "GLSupermarketMapRendered", "Estanteria " + contEstanteria++ );
//			estanteria.draw( a_Gl );
//		}
		
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
	


	/**
	 * 
	 * @param a_ProcessZoom
	 */
	public void setProcessZoom( int a_ProcessZoom )
	{	
		
		m_ProcessZoom= a_ProcessZoom;
		//m_ProcessZoom= (float) a_ProcessZoom * 7.f / 10.f;
		
		// Log.d( TAG, " onClickSeekBarZoom=> Zoom Value= " + a_ProcessZoom + " ["+ m_ProcessZoom + "]");
		
	} // setProcessZoom
	
	
	
}