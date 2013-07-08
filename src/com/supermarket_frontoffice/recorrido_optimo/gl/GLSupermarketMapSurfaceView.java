package com.supermarket_frontoffice.recorrido_optimo.gl;


import com.supermarket_frontoffice.modelo_datos.CarritoCompra;
import com.supermarket_frontoffice.modelo_datos.Producto;
import com.supermarket_frontoffice.modelo_datos.ProductoCarrito;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;



/** @class GLSupermarketMapSurfaceView
 * 
 * @author fjvegaf
 *
 */
public class GLSupermarketMapSurfaceView extends GLSurfaceView 
{
	
	
	private static final String TAG= "GLSupermarketMapSurfaceView";

	private GLSupermarketMapRenderer 	m_MapRenderer;
	private float 						m_XMotionDown;
	private float 						m_YMotionDown;
	private float 						m_XMotionUp;
	private float 						m_YMotionUp;
	private boolean 					m_ActivateRotation;
	private boolean 					m_ActivateView2d;
	
	
	
	
	/** Constructor
	 * 
	 * @param a_Context
	 */
	public GLSupermarketMapSurfaceView( Context a_Context, float a_ProcessZoom ) 
	{
		super( a_Context );
		
			
		m_MapRenderer= new GLSupermarketMapRenderer( a_Context, a_ProcessZoom );
		
		m_XMotionDown= 0.f;
		m_YMotionDown= 0.f;
		
		m_XMotionUp= 0.f;
		m_YMotionUp= 0.f;
		
		m_ActivateRotation= false;
		m_ActivateView2d= false;
		
		//m_ProcessZoom= 50;
		
	} // GLSupermarketMapSurfaceView
	
	
	/** Inicializa el mapa
	 * 
	 * @return
	 */
	public void setRenderer( )
	{
		//m_MapRenderer.initialize();
		super.setRenderer( m_MapRenderer );
		
	} // initialize
	
	
	
	/** Inicializa el mapa
	 * 
	 * @return
	 */
	public void initialize()
	{
		m_MapRenderer.initialize();
		super.setRenderer( m_MapRenderer );
		
	} // initialize
	
	
	/**
	 * 
	 */
	public void start() 
	{		
	} // start
	
	
	/**
	 * 
	 */
	public boolean onTouchEvent( final MotionEvent a_Event )
	{
		
		if ( a_Event.getAction() == MotionEvent.ACTION_DOWN ) {
			
			m_XMotionDown= a_Event.getX();
			m_YMotionDown= a_Event.getY();
		}
		
		if ( a_Event.getAction() == MotionEvent.ACTION_UP ) {
			
			//final= a_Event.getEventTime();
			m_XMotionUp= a_Event.getX();
			m_YMotionUp= a_Event.getY();
			
			queueEvent( new Runnable() {
				
				public void run() {
					
					if ( m_ActivateRotation ) {
						

						m_MapRenderer.rotatePosicionXZ((( ( m_YMotionUp > m_YMotionDown )? 90.f: -90.f ) / 1.f ) /* % 360.f*/ );
						
					}
					else {
						
						m_MapRenderer.movePosicionX( ( m_XMotionUp - m_XMotionDown ) / 100.f );
						m_MapRenderer.movePosicionZ( ( m_YMotionUp - m_YMotionDown ) / 100.f );
					}

						
				}
			});
		}
		
		return true;
		//return super.onTouchEvent( a_Event );
		
	}
	
	
	
	public boolean isActivateRotation() 
	{
		return m_ActivateRotation;
	}



	public void setActivateRotation( boolean a_ActivateRotation ) 
	{
		m_ActivateRotation= a_ActivateRotation;
		m_MapRenderer.setActivateRotation( a_ActivateRotation );
	}
	
	
	public boolean isActivateView2d() 
	{
		
		return m_ActivateView2d; 
	} // isActivateView2d

	
	public void setActivateView2d( boolean a_ActivateView2d ) 
	{
		m_ActivateView2d= a_ActivateView2d;
		m_MapRenderer.setActivateView2d( a_ActivateView2d );
	} // setActivateView2d
	
	
	public void setProcessZoom( int a_ProcessZoom )
	{
		
		//m_ProcessZoom= a_ProcessZoom;
		m_MapRenderer.setProcessZoom( a_ProcessZoom );
	}
	
	

	
	/**
	 * 
	 * @param a_CarritoCompra
	 */
	public void setCarritoCompra( CarritoCompra a_CarritoCompra ) 
	{
		m_MapRenderer.setCarritoCompra( a_CarritoCompra );
	} // setCarritoCompra
	
	
	/**
	 * 
	 * @param a_Producto
	 */
	public void setProducto( Producto a_ProductoCarrito ) 
	{
		m_MapRenderer.setProducto( a_ProductoCarrito );
		
	} // setProducto


	/**
	 * @return the m_MapRenderer
	 */
	public GLSupermarketMapRenderer getMapRenderer() 
	{
		return m_MapRenderer;
	}
	

} // End Class GLSupermarketMapSurfaceView
