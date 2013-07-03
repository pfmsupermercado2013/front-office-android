package com.supermarket_frontoffice.recorrido_optimo;

import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.modelo_datos.CarritoCompra;
import com.supermarket_frontoffice.modelo_datos.LocalizacionProducto;
import com.supermarket_frontoffice.modelo_datos.Producto;
import com.supermarket_frontoffice.recorrido_optimo.gl.GLSupermarketMapSurfaceView;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
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
		
	
	private Producto					m_Producto;
//	
//	ProgressDialog 						m_ProgressBar;
//	private int 						m_ProgressBarStatus = 0;
//	private Handler 					m_ProgressBarHandler = new Handler();
	
	
//	public RecorridoOptimoMainActivity( )
//	{
//		super();
//		
//		Log.d( TAG, "Constructor RecorridoOptimoMainActivity" );
//		
//		m_MapSurfaceView= null; // new GLSupermarketMapSurfaceView( this, m_GLSeekBarZoom.getProgress() );
//		m_GLSeekBarZoom= null;
//		
//		
//	} // RecorridoOptimoMainActivity
	
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
		CarritoCompra carritoCompra= (CarritoCompra ) intent.getParcelableExtra( "carrito_compra" );
		Producto producto= ( Producto ) intent.getParcelableExtra( "producto" );
		
		
		FrameLayout layout= (FrameLayout) findViewById(R.id.layoutButtonsMaps );
		m_GLSeekBarZoom= (VerticalSeekBar) findViewById( R.id.seekBarZoom );
		m_GLSeekBarZoom.setOnSeekBarChangeListener( this );
		
		m_MapSurfaceView= new GLSupermarketMapSurfaceView( this, m_GLSeekBarZoom.getProgress() );



		if ( carritoCompra != null ) {
			
			m_MapSurfaceView.setCarritoCompra( carritoCompra );
		}
		else if ( producto != null ) {
			
			m_MapSurfaceView.setProducto( producto );
		}
		
		
		
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
    	m_MapSurfaceView.setProcessZoom( 7 ); 
    	m_GLSeekBarZoom.setProgress( 7 );
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

    
    
//	/**
//	 * 
//	 * @author fjvegaf
//	 *
//	 */
//	class handleButton1 implements OnClickListener 
//	{
//	        public void onClick(View v) {
//	        	//myCustomAlert("Carrito de la compra vacio. Imposible iniciar la compra guiada");
//		}
//	}
//	
//	
//	class handleButton2 implements OnClickListener 
//	{
//	        public void onClick(View v) {
//	        	//myCustomAlert("Fin del recorrido de compra. Pague su compra en caja");
//		}
//	}
	
	public boolean myCustomAlert(String sCadena) {
		
		AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setTitle("Titulo");
		alertDialog.setMessage(sCadena);
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel(); //Cierra la ventana
			}
		});
//		alertDialog.setIcon(R.drawable.icon);
		alertDialog.show();
		
		return true;
		
	}


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
