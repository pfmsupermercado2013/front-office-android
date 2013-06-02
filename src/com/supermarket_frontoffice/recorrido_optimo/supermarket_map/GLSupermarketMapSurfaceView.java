package com.supermarket_frontoffice.recorrido_optimo.supermarket_map;

import java.util.ArrayList;
import java.util.Vector;

import android.app.AlertDialog;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.KeyEvent;
import android.view.MotionEvent;


public class GLSupermarketMapSurfaceView extends GLSurfaceView 
{

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
	public GLSupermarketMapSurfaceView( Context a_Context, ArrayList< Estanteria > a_ListaEstanteria ) 
	{
		super( a_Context );
		
		m_MapRenderer= new GLSupermarketMapRenderer( a_ListaEstanteria );
		super.setRenderer( m_MapRenderer );
		
		m_XMotionDown= 0.f;
		m_YMotionDown= 0.f;
		
		m_XMotionUp= 0.f;
		m_YMotionUp= 0.f;
		
		m_ActivateRotation= false;
		m_ActivateView2d= false;
		
	} // GLSupermarketMapSurfaceView
	
	
	/**
	 * 
	 */
	public void start() 
	{		
	} // start
	
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
							
						m_MapRenderer.rotatePosicionXZ( ( ( ( m_YMotionUp > m_YMotionDown )? 15.f: -15.f ) / 1.f ) /* % 360.f*/ );
						
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
	
	

} // End Class GLSupermarketMapSurfaceView
