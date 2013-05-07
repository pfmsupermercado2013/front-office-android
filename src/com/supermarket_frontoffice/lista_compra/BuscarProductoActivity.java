package com.supermarket_frontoffice.lista_compra;

import java.util.ArrayList;

import com.supermarket_frontoffice.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

public class BuscarProductoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buscar_producto);
		
		ExpandableListView lstView= (ExpandableListView) findViewById( R.id.ExpandableViewOpcionesBusqueda );

		ExpandableOpcionesBusquedaAdapter adapter= new ExpandableOpcionesBusquedaAdapter( this );
	
		lstView.setAdapter( adapter );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.buscar_producto, menu);
		return true;
	}
	
	
    public void onClickBuscarProducto( View v ) {
    	
		ExpandableListView lstView= (ExpandableListView) findViewById( R.id.ExpandableViewResultadoBusqueda );
		

//		ExpandableOpcionesBusquedaAdapter adapter= new ExpandableOpcionesBusquedaAdapter( this );
//	
//		lstView.setAdapter( adapter );
		
		ArrayList<String> resultadoBusqueda= new ArrayList<String>();
		resultadoBusqueda.add("Resultado de la busqueda (4 Productos)");
		
		ArrayList<String> listaResultados= new ArrayList<String>();
		listaResultados.add("Coca-Cola 2L");
		listaResultados.add("Pepsi-cola 2L");
		listaResultados.add("Coca-Cola 33cl");
		listaResultados.add("Pepsi-cola 33cl");
		
		ArrayList< ArrayList<String> > listaTodosResultados= new ArrayList< ArrayList<String> >();
		listaTodosResultados.add( 0, listaResultados );
       
		
		ExpandableListAdapter adapter= new ExpandableListCategoryAdapter( this, resultadoBusqueda, listaTodosResultados );
	
		lstView.setAdapter( adapter );
	    //Intent intent = new Intent( BuscarProductoActivity.this, CatalogoProductosActivity.class);
	    //startActivity(intent);	
    }

}
