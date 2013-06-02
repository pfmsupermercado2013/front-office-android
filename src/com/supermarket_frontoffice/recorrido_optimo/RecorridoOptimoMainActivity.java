package com.supermarket_frontoffice.recorrido_optimo;

import java.util.ArrayList;
import java.util.Vector;

import com.supermarket_frontoffice.MainActivity;
import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.R.id;
import com.supermarket_frontoffice.R.layout;
import com.supermarket_frontoffice.R.menu;
import com.supermarket_frontoffice.lista_compra.ListaCompraActivity;
import com.supermarket_frontoffice.recorrido_optimo.supermarket_map.Estanteria;
import com.supermarket_frontoffice.recorrido_optimo.supermarket_map.EstanteriaEstante;
import com.supermarket_frontoffice.recorrido_optimo.supermarket_map.EstanteriaSeccion;
import com.supermarket_frontoffice.recorrido_optimo.supermarket_map.GLSupermarketMapSurfaceView;
import com.supermarket_frontoffice.recorrido_optimo.supermarket_map.Estanteria.TTipoEstanteria;
import com.supermarket_frontoffice.recorrido_optimo.supermarket_map.EstanteriaSeccion.TTipoEstanteSeccion;
//import com.supermarket_frontoffice.MainActivity.handleButton;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TableRow;

public class RecorridoOptimoMainActivity extends Activity 
{
	
	
	private GLSupermarketMapSurfaceView m_MapSurfaceView;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
	    
		super.onCreate(savedInstanceState);
		

		setContentView( R.layout.activity_recorrido_optimo_main );
		
		FrameLayout layout= (FrameLayout) findViewById(R.id.layoutButtonsMaps );
	    
		
	    m_MapSurfaceView= new GLSupermarketMapSurfaceView( this, this.getListaEstanteria() );
	    
	    //layout.setBackgroundResource( mapSurfaceView );
	    layout.addView( m_MapSurfaceView );
		

		findViewById( R.id.btnOk ).setOnClickListener(new handleButton1());
		findViewById( R.id.btnNuevo ).setOnClickListener(new handleButton2());
			  
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recorrido_optimo_main, menu);
		return true;
	}

	
    public void onClickMap2d( View v ) 
    {
    	
    	m_MapSurfaceView.setActivateView2d( true );
    }
    
    public void onClickMap3d( View v ) 
    {
    	m_MapSurfaceView.setActivateView2d( false );
    }
    
    
    public void onClickRotation( View v ) 
    {
    	
    	//myCustomAlert("onClickRotation");
    	m_MapSurfaceView.setActivateRotation( true );
	    
    }
    
    
    public void onClickTranslation( View v ) 
    {
    	//myCustomAlert("onClickTranslation");
    	m_MapSurfaceView.setActivateRotation( false );
	    
    }
	
	
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

	
	/** Crea una virtual lista de estantería
	 * 
	 * @return
	 */
	public ArrayList< Estanteria > getListaEstanteria( ) 
	{
		
		
		ArrayList< Estanteria > listaEstanteria= new ArrayList< Estanteria >(); 
		
//		short a_Id, 
//		TTipoEstanteSeccion a_TipoSeccion,
//		float a_Alto,
//		float a_Largo,
//		float a_AchoBase )
		
		
		Estanteria estanteria1= new Estanteria( (short) 2,  Estanteria.TTipoEstanteria.EstanteriaSimple, 50.f, 0.f, 0.f );
		
		ArrayList< EstanteriaEstante > listEstantesEstanteria1= new ArrayList< EstanteriaEstante >();
		listEstantesEstanteria1.add( new EstanteriaEstante( (short) 1, 25.f, 64.005f, 33.768f ) );
		listEstantesEstanteria1.add( new EstanteriaEstante( (short) 2, 25.f, 64.005f, 33.768f ) );
		listEstantesEstanteria1.add( new EstanteriaEstante( (short) 3, 25.f, 64.005f, 33.768f ) );
		listEstantesEstanteria1.add( new EstanteriaEstante( (short) 4, 25.f, 64.005f, 33.768f ) );
		
		
		//new GLEstanteriaSeccion( (short)1, 135.192f, 33.768f, 64.005f );
		estanteria1.addEstanteSeccion( new EstanteriaSeccion( (short) 1, EstanteriaSeccion.TTipoEstanteSeccion.SeccionSimple,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria1.addEstanteSeccion( new EstanteriaSeccion( (short) 2, EstanteriaSeccion.TTipoEstanteSeccion.SeccionSimple,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria1.addEstanteSeccion( new EstanteriaSeccion( (short) 3, EstanteriaSeccion.TTipoEstanteSeccion.SeccionSimple,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria1.addEstanteSeccion( new EstanteriaSeccion( (short) 4, EstanteriaSeccion.TTipoEstanteSeccion.SeccionSimple,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria1.addEstanteSeccion( new EstanteriaSeccion( (short) 5, EstanteriaSeccion.TTipoEstanteSeccion.SeccionSimple,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria1.addEstanteSeccion( new EstanteriaSeccion( (short) 6, EstanteriaSeccion.TTipoEstanteSeccion.SeccionSimple,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		
		listaEstanteria.add( estanteria1 );
		
		
		Estanteria estanteria2= new Estanteria( (short) 2,  Estanteria.TTipoEstanteria.EstanteriaSimple, 0.f, -500.f, -90.f );
		
	
		//new GLEstanteriaSeccion( (short)1, 135.192f, 33.768f, 64.005f );
		estanteria2.addEstanteSeccion( new EstanteriaSeccion( (short) 1, EstanteriaSeccion.TTipoEstanteSeccion.SeccionSimple,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria2.addEstanteSeccion( new EstanteriaSeccion( (short) 2, EstanteriaSeccion.TTipoEstanteSeccion.SeccionSimple,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria2.addEstanteSeccion( new EstanteriaSeccion( (short) 3, EstanteriaSeccion.TTipoEstanteSeccion.SeccionSimple,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria2.addEstanteSeccion( new EstanteriaSeccion( (short) 4, EstanteriaSeccion.TTipoEstanteSeccion.SeccionSimple,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria2.addEstanteSeccion( new EstanteriaSeccion( (short) 5, EstanteriaSeccion.TTipoEstanteSeccion.SeccionSimple,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria2.addEstanteSeccion( new EstanteriaSeccion( (short) 6, EstanteriaSeccion.TTipoEstanteSeccion.SeccionSimple,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria2.addEstanteSeccion( new EstanteriaSeccion( (short) 7, EstanteriaSeccion.TTipoEstanteSeccion.SeccionSimple,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		
		
		listaEstanteria.add( estanteria2 );
		
		
		
//		Estanteria estanteria2= new Estanteria( (short) 1,  Estanteria.TTipoEstanteria.EstanteriaDoble, 0.f, 0.f, 90.f );
//		
//		//new GLEstanteriaSeccion( (short)1, 135.192f, 33.768f, 64.005f );
//		
//
//		estanteria2.addEstanteSeccion( new EstanteriaSeccion( (short) 1, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
//		estanteria2.addEstanteSeccion( new EstanteriaSeccion( (short) 2, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
//		estanteria2.addEstanteSeccion( new EstanteriaSeccion( (short) 3, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
//		estanteria2.addEstanteSeccion( new EstanteriaSeccion( (short) 4, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
//		estanteria2.addEstanteSeccion( new EstanteriaSeccion( (short) 5, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
//		estanteria2.addEstanteSeccion( new EstanteriaSeccion( (short) 6, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
//		
//		listaEstanteria.add( estanteria2 );
//		
//		
//
//		
		
		Estanteria estanteria3= new Estanteria( (short) 3,  Estanteria.TTipoEstanteria.EstanteriaDoble, 200.f, -500.f, -90.f );
		estanteria3.addEstanteSeccion( new EstanteriaSeccion( (short) 1, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria3.addEstanteSeccion( new EstanteriaSeccion( (short) 2, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria3.addEstanteSeccion( new EstanteriaSeccion( (short) 3, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria3.addEstanteSeccion( new EstanteriaSeccion( (short) 4, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria3.addEstanteSeccion( new EstanteriaSeccion( (short) 5, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria3.addEstanteSeccion( new EstanteriaSeccion( (short) 6, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria3.addEstanteSeccion( new EstanteriaSeccion( (short) 7, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria3.addEstanteSeccion( new EstanteriaSeccion( (short) 8, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria3.addEstanteSeccion( new EstanteriaSeccion( (short) 9, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria3.addEstanteSeccion( new EstanteriaSeccion( (short) 10, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		listaEstanteria.add( estanteria3  );
		
		Estanteria estanteria4= new Estanteria( (short) 3,  Estanteria.TTipoEstanteria.EstanteriaDoble, 400.f, -500.f, -90.f );	
		estanteria4.addEstanteSeccion( new EstanteriaSeccion( (short) 1, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria4.addEstanteSeccion( new EstanteriaSeccion( (short) 2, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria4.addEstanteSeccion( new EstanteriaSeccion( (short) 3, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria4.addEstanteSeccion( new EstanteriaSeccion( (short) 4, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria4.addEstanteSeccion( new EstanteriaSeccion( (short) 5, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria4.addEstanteSeccion( new EstanteriaSeccion( (short) 6, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria4.addEstanteSeccion( new EstanteriaSeccion( (short) 7, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria4.addEstanteSeccion( new EstanteriaSeccion( (short) 8, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria4.addEstanteSeccion( new EstanteriaSeccion( (short) 9, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria4.addEstanteSeccion( new EstanteriaSeccion( (short) 10, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		listaEstanteria.add( estanteria4  );
		
		Estanteria estanteria5= new Estanteria( (short) 3,  Estanteria.TTipoEstanteria.EstanteriaDoble, 600.f, -500.f, -90.f );	
		estanteria5.addEstanteSeccion( new EstanteriaSeccion( (short) 1, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria5.addEstanteSeccion( new EstanteriaSeccion( (short) 2, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria5.addEstanteSeccion( new EstanteriaSeccion( (short) 3, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria5.addEstanteSeccion( new EstanteriaSeccion( (short) 4, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria5.addEstanteSeccion( new EstanteriaSeccion( (short) 5, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria5.addEstanteSeccion( new EstanteriaSeccion( (short) 6, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria5.addEstanteSeccion( new EstanteriaSeccion( (short) 7, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria5.addEstanteSeccion( new EstanteriaSeccion( (short) 8, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria5.addEstanteSeccion( new EstanteriaSeccion( (short) 9, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		estanteria5.addEstanteSeccion( new EstanteriaSeccion( (short) 10, EstanteriaSeccion.TTipoEstanteSeccion.SeccionDoble,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
		listaEstanteria.add( estanteria5  );
		
		
//		
//		
//		Estanteria estanteria4= new Estanteria( (short) 2,  Estanteria.TTipoEstanteria.EstanteriaSimple, 0.f, 550.f, 0.f );
//		
//		//new GLEstanteriaSeccion( (short)1, 135.192f, 33.768f, 64.005f );
//		estanteria4.addEstanteSeccion( new EstanteriaSeccion( (short) 1, EstanteriaSeccion.TTipoEstanteSeccion.SeccionSimple,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
//		estanteria4.addEstanteSeccion( new EstanteriaSeccion( (short) 2, EstanteriaSeccion.TTipoEstanteSeccion.SeccionSimple,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
//		estanteria4.addEstanteSeccion( new EstanteriaSeccion( (short) 3, EstanteriaSeccion.TTipoEstanteSeccion.SeccionSimple,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
//		estanteria4.addEstanteSeccion( new EstanteriaSeccion( (short) 4, EstanteriaSeccion.TTipoEstanteSeccion.SeccionSimple,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
////		estanteria4.addEstanteSeccion( new EstanteriaSeccion( (short) 5, EstanteriaSeccion.TTipoEstanteSeccion.SeccionSimple,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
////		estanteria4.addEstanteSeccion( new EstanteriaSeccion( (short) 6, EstanteriaSeccion.TTipoEstanteSeccion.SeccionSimple,  135.192f, 64.005f, 33.768f, listEstantesEstanteria1 ) );
////		
//		
//		listaEstanteria.add( estanteria4  );
		
		//listaEstanteria.add( new GLEstanteria( (short)1, 30.f/ 100.f, 20.f / 100.f, 30.f ) ); 
		
		
		
		
		return listaEstanteria;
		
	}
	
	
	
} // RecorridoOptimoMainActivity
