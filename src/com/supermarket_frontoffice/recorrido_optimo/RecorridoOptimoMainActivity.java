package com.supermarket_frontoffice.recorrido_optimo;

import java.util.ArrayList;
import java.util.Vector;

import com.supermarket_frontoffice.MainActivity;
import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.R.id;
import com.supermarket_frontoffice.R.layout;
import com.supermarket_frontoffice.R.menu;
import com.supermarket_frontoffice.lista_compra.ListaCompraActivity;
import com.supermarket_frontoffice.modelo_datos.Estanteria;
import com.supermarket_frontoffice.modelo_datos.EstanteriaEstante;
import com.supermarket_frontoffice.modelo_datos.EstanteriaSeccion;
import com.supermarket_frontoffice.modelo_datos.Estanteria.TTipoEstanteria;
import com.supermarket_frontoffice.recorrido_optimo.gl.GLSupermarketMapSurfaceView;
import com.supermarket_frontoffice.recorrido_optimo.xml.XmlResourceMobiliario;
//import com.supermarket_frontoffice.recorrido_optimo.supermarket.componentes.EstanteriaSeccion.TTipoEstanteSeccion;
//import com.supermarket_frontoffice.MainActivity.handleButton;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TableRow;
import android.widget.VerticalSeekBar;

public class RecorridoOptimoMainActivity extends Activity implements OnSeekBarChangeListener
{
	
	private static final String TAG= "RecorridoOptimoMainActivity";
	
	private GLSupermarketMapSurfaceView m_MapSurfaceView;
	private VerticalSeekBar 			m_VertSeekBarZoom;
	
	/**
	 * 
	 */
	@Override
	protected void onCreate( Bundle savedInstanceState ) 
	{
	    
		super.onCreate( savedInstanceState );

		
		setContentView( R.layout.activity_recorrido_optimo_main );
		
		
		FrameLayout layout= (FrameLayout) findViewById(R.id.layoutButtonsMaps );
	    
		
	    m_VertSeekBarZoom= (VerticalSeekBar) findViewById( R.id.seekBarZoom );
	    m_VertSeekBarZoom.setOnSeekBarChangeListener( this );
	    //m_MapSurfaceView.setProcessZoom( m_VertSeekBarZoom.getProgress() ); 	
		
		Log.d("RecorridoOptimoMainActivity", "Cargando el mapa ...");
	    m_MapSurfaceView= new GLSupermarketMapSurfaceView( this, m_VertSeekBarZoom.getProgress() );
	    
	    

	    
	    //layout.setBackgroundResource( mapSurfaceView );
	    layout.addView( m_MapSurfaceView, 0 );

		

//		findViewById( R.id.btnOk ).setOnClickListener(new handleButton1());
//		findViewById( R.id.btnNuevo ).setOnClickListener(new handleButton2());
//			  
	    
	}

	
	/**
	 * 
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
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
    	m_VertSeekBarZoom.setProgress( 7 );
    	m_MapSurfaceView.setActivateView2d( true );
    }
    
    
    /**
     * 
     * @param v
     */
    public void onClickMap3d( View v ) 
    {
    	m_MapSurfaceView.setProcessZoom( 10 ); 
    	m_VertSeekBarZoom.setProgress( 10 );
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
	 * @author fjvegaf
	 *
	 */
	class handleButton1 implements OnClickListener 
	{
	        public void onClick(View v) {
	        	//myCustomAlert("Carrito de la compra vacio. Imposible iniciar la compra guiada");
		}
	}
	
	
	class handleButton2 implements OnClickListener 
	{
	        public void onClick(View v) {
	        	//myCustomAlert("Fin del recorrido de compra. Pague su compra en caja");
		}
	}
	
	public boolean myCustomAlert(String sCadena){
		
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

    	Log.d( TAG, " onClickSeekBarZoom=> Zoom Value= " + progress );
    	
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
