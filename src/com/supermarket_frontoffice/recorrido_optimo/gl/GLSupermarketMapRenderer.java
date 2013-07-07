package com.supermarket_frontoffice.recorrido_optimo.gl;


import java.util.ArrayList;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.modelo_datos.CarritoCompra;
import com.supermarket_frontoffice.modelo_datos.ParedEdificio;
import com.supermarket_frontoffice.modelo_datos.Producto;
import com.supermarket_frontoffice.modelo_datos.ProductoCarrito;
import com.supermarket_frontoffice.modelo_datos.PuertaEdificio;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.GLVertice;
import com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario.GLCarritoCompra;
import com.supermarket_frontoffice.recorrido_optimo.xml.XmlResourceSupermercado;

import android.content.Context;
import android.opengl.GLU;
import android.opengl.GLSurfaceView.Renderer;
import android.util.Log;
import android.view.View;

/**
 * 
 * @author fjvegaf
 *
 */
public class GLSupermarketMapRenderer implements Renderer 
{
	
	private static final String TAG= "GLSupermarketMapRenderer";
	
	private Context 				m_Context;
	private XmlResourceSupermercado m_XmlResoursesSupermercado;		///< Clase que gestiona la lectura de los datos de los recursos Xml
	private GLSupermercado			m_GLSupermercado;				///< Objeto que dibuja todo el supermercado en OpenGL.
	
	private CarritoCompra 			m_CarritoCompra;				///< Lista de productos del carrito de la compra que se debe localizar.
	//private int						m_CurrentProductoCarritoCompra; ///< Producto que se está representando actualmente.
	
	private Producto				m_Producto;						///< Datos del producto concreto que se desea localizar.
		
	private float 					m_AspectRatio;					///< Ratio de escalado para la represeentación en OpenGL.
	
	private float 					m_RotateAngle;
	
	private GLVertice				m_VectorInicial; 
	private GLVertice				m_vectorInicialProducto; 

	
	private boolean 				m_ActivateRotation;
	private boolean 				m_ActivateView2d;
	private float					m_ProcessZoom;
	
	GLCarritoCompra 				m_GlCarritoCompra;
	
	
	

	
	/** Constructor
	 * 
	 * @param a_Context
	 */
	GLSupermarketMapRenderer( Context a_Context, float a_ProcessZoom ) 
	{
		
		m_Context= a_Context;
		m_XmlResoursesSupermercado= new XmlResourceSupermercado( a_Context, R.xml.supermercado_edificio, R.xml.supermercado_mobiliario );
		
		m_GLSupermercado= null;
		m_CarritoCompra= null;
		m_Producto= null;	
		
		m_AspectRatio= 0.f;
		m_RotateAngle= 0.0f;
		
		m_VectorInicial= new GLVertice();
		m_vectorInicialProducto= null;
		
		m_ActivateRotation= false;
		
		m_ActivateView2d= false;
		m_ProcessZoom= a_ProcessZoom;
		
		m_GlCarritoCompra= new GLCarritoCompra( a_Context );
		
		
		//this.readXmlResources();
		
	} // GLSupermarketMapRenderer
	
	
	/** Inicializa el mapa
	 * 
	 * @return
	 */
	public void initialize()
	{

		
		m_GLSupermercado= null;
	
		m_AspectRatio= 0.f;		
		m_RotateAngle= 0.0f;
		
		this.readXmlResources();
		
		///
		/// Situa el carrito de la compra en la puerta principal
		///
		ArrayList<PuertaEdificio> listaPuertas= m_XmlResoursesSupermercado.getSupermercado().getEdificio().getListaPuertas();
		
		if ( listaPuertas.isEmpty() ) {
			
			m_VectorInicial.setX(-720.0f / 100.f ); 
			m_VectorInicial.setY( 0.0f ); 
			m_VectorInicial.setZ( -350.0f / 100.f ); 
			
		}
		else {
			
			PuertaEdificio puerta= listaPuertas.get( 0 );
			ParedEdificio paredPuerta= puerta.getPared();
		
			m_VectorInicial.setX( -( paredPuerta.getV1().getVertice().getX() + puerta.getXLeft() + ( puerta.getLargo() / 2.f ) )  / 100.f ); 
			m_VectorInicial.setY( 0.0f ); 
			m_VectorInicial.setZ( -( paredPuerta.getV1().getVertice().getY() + 200.f ) / 100.f ); 

		}
		
		
	} // initialize
	
	
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
		
		m_GLSupermercado= new GLSupermercado( m_Context, m_XmlResoursesSupermercado.getSupermercado() );

		if ( m_Producto != null ) {
			
			m_vectorInicialProducto= m_GLSupermercado.getGLMobiliario().localizarProducto( m_Producto.getLocalizacion(), true );
			
			if ( m_vectorInicialProducto != null ) {
				
				Log.d( TAG, "[Producto] Despues de localizarProducto => Vector inicial del producto =>" + m_vectorInicialProducto.toString() );
			}
			else {
				
				Log.d( TAG, "[Producto] Despues de localizarProducto => m_vectorInicialProducto == null" );
			}
			
//			if (coordenadaProducto != null ) {
//				
//				m_VectorInicial= coordenadaProducto;
//			}
					
		}
		
		if ( ( m_CarritoCompra != null ) && ( !m_CarritoCompra.getListaCompra().isEmpty() ) ) {
			
			m_vectorInicialProducto= m_GLSupermercado.getGLMobiliario().localizarProducto( m_CarritoCompra.getListaCompra().get( 0 ).getProducto().getLocalizacion(), true );
			
			if ( m_vectorInicialProducto != null ) {
				
				Log.d( TAG, "[CarritoCompra] Despues de localizarProducto => Vector inicial del producto =>" + m_vectorInicialProducto.toString() );
			}
			else {
				
				Log.d( TAG, "[CarritoCompra] Despues de localizarProducto => m_vectorInicialProducto == null" );
			}
			
		}
		
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
		//a_Gl.glClearColor(186.f/255.0f, 141.f/255.0f, 71.f/255.0f, 0.0f);
		//a_Gl.glClearColor(30.f/255.0f, 43.f/255.0f, 0.f/255.0f, 0.0f);
		a_Gl.glClearColor(92.f/255.0f, 132.f/255.0f, 0.f/255.0f, 0.0f);
		 
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
		
		if ( m_vectorInicialProducto != null ) {
			
			//Log.d( TAG, "Vector inicial del producto =>" + m_vectorInicialProducto.toString() );			
			m_VectorInicial= m_vectorInicialProducto;
		}
		
		
		
		// Limpia la pantalla y el buffer de profundidad		 
		a_Gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		 
		 
        // Set GL_MODELVIEW transformation mode
		a_Gl.glMatrixMode( GL10.GL_MODELVIEW );
		
		// Reemplaza la matriz actual con la matriz identidad		 
		a_Gl.glLoadIdentity();

		
		if ( m_ActivateView2d ) {
						
			GLU.gluLookAt( a_Gl, 0.f, -(float) m_ProcessZoom*7.f/10.f, 0.f,
					 		0.f, 0.f, 0.f,
							1.f, 0.0f, 0.0f );
	
			a_Gl.glRotatef( 180.f, 1, 0, 0 ); //
			a_Gl.glRotatef( -90.f, 0, 1, 0 ); //
//			a_Gl.glTranslatef( 0, 0, 0 );		
			//a_Gl.glTranslatef( m_XPostInicial, m_YPostInicial, m_ZPostInicial );
		}
		else  {
			
			GLU.gluLookAt( a_Gl, 0.f, (float )m_ProcessZoom * 1.f /10.f, 0.8f,
					 		0.f, 0.9f, 0.f / 100.f,
							0.f, 1.0f, 0.0f );
				
		}
		
		
		a_Gl.glRotatef( m_RotateAngle, 0, 1, 0 ); 
		
		if ( m_CarritoCompra != null ) {
			
			m_GlCarritoCompra.draw( a_Gl );
		}
		
		//a_Gl.glTranslatef( m_XPostInicial, m_YPostInicial, m_ZPostInicial );	
		a_Gl.glTranslatef( m_VectorInicial.getX(), m_VectorInicial.getY(), m_VectorInicial.getZ() );	
		
		// Traslada 4 unidades en el eje Z		 
		a_Gl.glRotatef( 2.f, 1, 0, 0 ); //
		//a_Gl.glRotatef( 180.f, 0, 1, 0 ); 
		//a_Gl.glTranslatef( -m_XPostInicial, -m_YPostInicial, -m_ZPostInicial );
		
		
		m_GLSupermercado.draw( a_Gl );
		

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
	
	
	/**
	 * 
	 * @return
	 */
	public GLVertice updateProductoCarritoCompra( int a_CurrentProductoCarritoCompra ) 
	{
		
		if ( ( m_CarritoCompra == null ) || ( a_CurrentProductoCarritoCompra >= m_CarritoCompra.getListaCompra().size() ) ) {
			
			return null;
		}
		
		m_GLSupermercado.getGLMobiliario().deslocalizarTodosProducto();
		m_vectorInicialProducto= m_GLSupermercado.getGLMobiliario().localizarProducto( m_CarritoCompra.getListaCompra().get( a_CurrentProductoCarritoCompra ).getProducto().getLocalizacion(), true );
		
		
		if ( m_vectorInicialProducto != null ) {
			
			Log.d( TAG, "[CarritoCompra] Despues de localizarProducto => Vector inicial del producto =>" + m_vectorInicialProducto.toString() );
		}
		else {
			
			Log.d( TAG, "[CarritoCompra] Despues de localizarProducto => m_vectorInicialProducto == null" );
		}	
		
		return m_vectorInicialProducto;
		
		
	} // nextProductoCarritoCompra
	
    /**
     * 
     * @param v
     */
    public boolean ordenarCarrito(   ) 
    {
    	
		if ( ( m_CarritoCompra == null ) || ( m_CarritoCompra.getListaCompra().isEmpty() ) ) {
				
			return false;
		}
		
		ArrayList< ProductoCarrito > listaProductos= m_CarritoCompra.getListaCompra();
		ArrayList< ProductoCarrito > listaOrdenadaProductos= new ArrayList< ProductoCarrito >();
		 
		GLVertice posVectorActual= null; 
		GLVertice posVectorAnterior= null;
		
//		for ( ProductoCarrito producto: listaProductos ) {
//			
//			posVectorActual= m_GLSupermercado.getGLMobiliario().localizarProducto( producto.getLocalizacion(), false );
//			
//			if ( ( posVectorAnterior == null ) || ( ) )  {
//				
//				listaOrdenadaProductos.
//			}
//		}
		
		
		
			
		 
		 
    	
		
		
    	return true;
    } // ordenarCarrito

	
	/**
	 * 
	 * @param a_RotateAngle
	 */
	public void rotatePosicionXZ( float a_RotateAngle ) 
	{
		m_RotateAngle += a_RotateAngle;
	}
	
	
	

	
	public void movePosicionX( float a_XPosicion ) 
	{
		//m_XPostInicial += a_XPosicion;
		this.m_VectorInicial.incrementX( a_XPosicion );
	}

	
	public void movePosicionY( float a_YPosicion ) 
	{
		//m_YPostInicial += a_YPosicion;
		this.m_VectorInicial.incrementY( a_YPosicion );
	}

	
	public void movePosicionZ( float a_ZPosicion ) 
	{
		//m_ZPostInicial += a_ZPosicion;
		
		this.m_VectorInicial.incrementZ( a_ZPosicion );
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
		
	} // setProcessZoom
	
	
	/**
	 * @return the m_GLSupermercado
	 */
	public GLSupermercado getGLSupermercado() 
	{
		return m_GLSupermercado;
	}


	/**
	 * @param m_GLSupermercado the m_GLSupermercado to set
	 */
	public void setGLSupermercado( GLSupermercado a_GLSupermercado ) 
	{
		this.m_GLSupermercado = a_GLSupermercado;
	}
	
	
	/**
	 * 
	 * @param a_CarritoCompra
	 */
	public void setCarritoCompra( CarritoCompra a_CarritoCompra ) 
	{
		m_CarritoCompra= a_CarritoCompra;
	} // setCarritoCompra
	
	
	/**
	 * 
	 * @param a_Producto
	 */
	public void setProducto( Producto a_Producto ) 
	{
		m_Producto= a_Producto;
		
		//m_GLSupermercado.getGLMobiliario().localizarProducto( m_Producto.getLocalizacion(), true );
	} // setProducto



	
	
	
}