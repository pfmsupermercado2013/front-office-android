package com.supermarket_frontoffice.recorrido_optimo;

import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.modelo_datos.CarritoCompra;
import com.supermarket_frontoffice.modelo_datos.Producto;
import com.supermarket_frontoffice.modelo_datos.ProductoCarrito;
import com.supermarket_frontoffice.recorrido_optimo.gl.GLSupermarketMapSurfaceView;
import com.supermarket_frontoffice.recorrido_optimo.gl.mobiliario.GLEstanteria;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.VerticalSeekBar;



/** @class RecorridoOptimoMainActivity
 * 
 * @author fjvegaf
 *
 */
public class RecorridoOptimoMainActivity extends Activity implements OnSeekBarChangeListener
{
	
	private static final String 		TAG= "RecorridoOptimoMainActivity";
	
	private GLSupermarketMapSurfaceView m_MapSurfaceView;
	private VerticalSeekBar 			m_GLSeekBarZoom;
		
	private CarritoCompra				m_CarritoCompra;
	private Producto					m_Producto;
	//private ProductoCarrito				m_ProductoCarrito;
	
	private TextView 					m_TextProducto;
	private int							m_CurrentProductoCarritoCompra;
//	
//	ProgressDialog 						m_ProgressBar;
//	private int 						m_ProgressBarStatus = 0;
//	private Handler 					m_ProgressBarHandler = new Handler();

	
	/** 
	 * 
	 */
	@Override
	protected void onCreate( Bundle savedInstanceState ) 
	{
	    
		super.onCreate( savedInstanceState );
		
		setContentView( R.layout.activity_recorrido_optimo_main );
		
		
		///
		/// Se lee los datos pasados del activity que lo llama
		/// Puede recibir dos tipos de objetos. CarritoCompra y Producto
		///
		Intent intent= getIntent();
		
		Log.d( TAG, "Antes de leer el carrito_compra");
		m_CarritoCompra= (CarritoCompra ) intent.getParcelableExtra( "carrito_compra" );
		
		Log.d( TAG, "Antes de leer el producto");
		m_Producto= ( Producto ) intent.getParcelableExtra( "producto" );
		
//		m_ProductoCarrito= ( ProductoCarrito ) intent.getParcelableExtra( "producto_carrito" );
////		Log.d( TAG, "Despues de leer el producto "  );
////		Log.d( TAG, "Producto =>" + m_Producto.toString() );

		FrameLayout layout= (FrameLayout) findViewById( R.id.layoutButtonsMaps );
		m_GLSeekBarZoom= (VerticalSeekBar) findViewById( R.id.seekBarZoom );
		m_GLSeekBarZoom.setOnSeekBarChangeListener( this );
		
		m_MapSurfaceView= new GLSupermarketMapSurfaceView( this, m_GLSeekBarZoom.getProgress() );
		m_TextProducto= (TextView) findViewById( R.id.textProductoRecorridoOptimo );

		if ( m_CarritoCompra != null ) {
			
			m_MapSurfaceView.setCarritoCompra( m_CarritoCompra );
			
			if ( !m_CarritoCompra.getListaCompra().isEmpty() ) {
			
				m_TextProducto.setText( "(" + m_CarritoCompra.getListaCompra().get( 0 ).getCantidad() + ")" +  m_CarritoCompra.getListaCompra().get( 0 ).getProducto().getNombreProducto() );
				m_CurrentProductoCarritoCompra= 0;
			}
		}
		else if ( m_Producto != null ) {
			
			Log.d( TAG, "Añadiendo producto al surfaceView" );
			m_MapSurfaceView.setProducto( m_Producto );	
			
			Log.d( TAG, "Mostrando texto del producto" );
			m_TextProducto.setText( m_Producto.getNombreProducto() );
		}

		
		
		
		
		m_MapSurfaceView.setActivateView2d( true );
	    m_MapSurfaceView.initialize();

	    layout.addView( m_MapSurfaceView, 0 );
			  
	} // onCreate

	
	/**
	 * 
	 */
	@Override
	public boolean onCreateOptionsMenu( Menu menu ) 
	{
		
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recorrido_optimo_main, menu);
		
		return true;
	}

	
	
	/**
	 * 
	 * @param v
	 */
    public void onClickMap2d( View v ) 
    {
    	m_MapSurfaceView.setProcessZoom( 12 ); 
    	m_GLSeekBarZoom.setProgress( 12 );
    	m_MapSurfaceView.setActivateView2d( true );
    } // onClickMap2d
    
    
    /**
     * 
     * @param v
     */
    public void onClickMap3d( View v ) 
    {
    	m_MapSurfaceView.setProcessZoom( 10 ); 
    	m_GLSeekBarZoom.setProgress( 10 );
    	m_MapSurfaceView.setActivateView2d( false );
    }
    
    /**
     * 
     * @param v
     */
    public void onClickRotation( View v ) 
    {
    	
    	//myCustomAlert("onClickRotation");
    	m_MapSurfaceView.setActivateRotation( true );
	    
    }
    
    
    /**
     * 
     * @param v
     */
    public void onClickTranslation( View v ) 
    {
    	//myCustomAlert("onClickTranslation");
    	m_MapSurfaceView.setActivateRotation( false );
	    
    }

    
    
    
    /**
     * 
     * @param v
     */
    public void onClickNextProducto( View v ) 
    {
		
    	if ( m_CarritoCompra != null ) {
		
    		++m_CurrentProductoCarritoCompra;
			if ( ( m_CurrentProductoCarritoCompra < m_CarritoCompra.getListaCompra().size() ) &&
			     ( m_CurrentProductoCarritoCompra >= 0 ) ) {
			
				//m_TextProducto.setText( m_CarritoCompra.getListaCompra().get( m_CurrentProductoCarritoCompra ).getNombreProducto() );
				m_TextProducto.setText( "(" + m_CarritoCompra.getListaCompra().get( m_CurrentProductoCarritoCompra ).getCantidad() + ")" +  m_CarritoCompra.getListaCompra().get( m_CurrentProductoCarritoCompra ).getProducto().getNombreProducto() );
				m_MapSurfaceView.getMapRenderer().updateProductoCarritoCompra( m_CurrentProductoCarritoCompra );
			}
			else if ( m_CurrentProductoCarritoCompra >= m_CarritoCompra.getListaCompra().size() ) {
				
				m_CurrentProductoCarritoCompra= m_CarritoCompra.getListaCompra().size() - 1;
			}
			else if ( m_CurrentProductoCarritoCompra < 0 ) {
				
				m_CurrentProductoCarritoCompra= 0;
			}
			
		}
	    
    }
    
    
    /**
     * 
     * @param v
     */
    public void onClickPreviousProducto( View v ) 
    {
		
    	if ( m_CarritoCompra != null ) {
		
    		--m_CurrentProductoCarritoCompra;
    		
			if (( m_CurrentProductoCarritoCompra < m_CarritoCompra.getListaCompra().size() ) && ( m_CurrentProductoCarritoCompra >= 0 ) ){
			

				//m_TextProducto.setText( m_CarritoCompra.getListaCompra().get( m_CurrentProductoCarritoCompra ).getNombreProducto() );
				m_TextProducto.setText( "(" + m_CarritoCompra.getListaCompra().get( m_CurrentProductoCarritoCompra ).getCantidad() + ")" +  m_CarritoCompra.getListaCompra().get( m_CurrentProductoCarritoCompra ).getProducto().getNombreProducto() );

				m_MapSurfaceView.getMapRenderer().updateProductoCarritoCompra( m_CurrentProductoCarritoCompra );
				
			}
			else if ( m_CurrentProductoCarritoCompra >= m_CarritoCompra.getListaCompra().size() ) {
				
				m_CurrentProductoCarritoCompra= m_CarritoCompra.getListaCompra().size() - 1;
			}
			else if ( m_CurrentProductoCarritoCompra < 0 ) {
				
				m_CurrentProductoCarritoCompra= 0;
			}
			
		}
	    
    } //
    
    

    
  

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
									boolean fromUser) 
	{

    	//Log.d( TAG, " onClickSeekBarZoom=> Zoom Value= " + progress );
    	
    	//findViewById( R.id.btnOk );
    	
    	m_MapSurfaceView.setProcessZoom( progress ); 	
	}


	@Override
	public void onStartTrackingTouch(SeekBar seekBar) 
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStopTrackingTouch(SeekBar seekBar) 
	{
		// TODO Auto-generated method stub
		
	}

	
	
	
} // RecorridoOptimoMainActivity
