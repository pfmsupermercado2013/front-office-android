package com.supermarket_frontoffice.lista_compra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.bd.SupermercadoDataSource;
import com.supermarket_frontoffice.modelo_datos.Categoria;
import com.supermarket_frontoffice.modelo_datos.Producto;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
//import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
//import android.widget.Spinner;
import android.widget.TextView;


public class CatalogoProductosActivity extends Activity 
{

	
	private ArrayList<String> 			 	m_Categorias;
	private ArrayList< ArrayList<String> >  m_ProductosCategorias;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_catalogo_productos);
		

		ExpandableListView lstView= (ExpandableListView) findViewById( R.id.ExpandableListView01 );
		
		cargarDatos( );
		
		ExpandableListAdapter adapter= new ExpandableListCategoryAdapter( this, m_Categorias, m_ProductosCategorias );
	
		lstView.setAdapter( adapter );
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.catalogo_productos, menu);
		return true;
	}
	
	
    public void onClickDetallarProducto(View v) {
    	
	    Intent intent= new Intent(CatalogoProductosActivity.this, InformacionProductoActivity.class);
	    startActivity(intent);	
    }
	
    
    public void onClickAnyadirCarrito(View v) {
    	
	    Intent intent= new Intent(CatalogoProductosActivity.this, AnyadirCarritoActivity.class);
	    startActivity(intent);	
    }
    
    public void onClickGeolocalizarProducto(View v) {
    	
	    Intent intent= new Intent(CatalogoProductosActivity.this, GeolocalizarProductoActivity.class);
	    startActivity(intent);	
    }
    
    public void onClickSeleccionarProducto(View a_View ) {
    	
    	Resources res= getResources();
    	a_View.setBackgroundColor( res.getColor( R.color.green2 ) );
    	
 //   	LinearLayout layout= (CheckBox) a_View.findViewById( R.id.checkBoxItem );
//    	//LinearLayout layout= (LinearLayout) ckBoxView.getParent(); 
//
//    	Resources res= getResources();
//    	if ( ckBoxView.isChecked() ) {
//    		
//    		layout.setBackgroundColor( res.getColor( R.color.green2 ) );
//    	}
//    	else {
//    		layout.setBackgroundColor( res.getColor( R.color.grey2 ) );
//    	}
    	
    }
	

 

 
    private void cargarDatos( )
    {
    	
    	SupermercadoDataSource bd = new SupermercadoDataSource(this);
    	bd.open();
    	
    	m_Categorias= new ArrayList< String>();
    	m_ProductosCategorias= new ArrayList< ArrayList< String >>();
    	m_ProductosCategorias.add( new  ArrayList< String >() );	
    	
    	List<Categoria> listacategorias = bd.getAllCategorias();
    	
    	for( int i = 0 ; i < listacategorias.size() ; i++ ){
    		  
    		  //Añadimos la Categoria
    		  m_Categorias.add(listacategorias.get(i).getNombreCategoria());
    		  Log.d("Supermercado-Lista_Compra", "Añadida Categoria al Listview: "+ listacategorias.get(i).toString());
    		  
    		  
    		  //Añadimos los Productos a las Categorias
    		  List<Producto> listaproductoscategoria = bd.getProductosByCategoriaID(listacategorias.get(i).getId());
    		  ArrayList<String> nombreproductoscategoria = new ArrayList<String >();
    		  for( int j = 0 ; j < listaproductoscategoria.size() ; j++ ){
    			  nombreproductoscategoria.add(listaproductoscategoria.get(j).getNombreProducto());
        		  Log.d("Supermercado-Lista_Compra", "Añadidos Productos a la Categoria: "+ listaproductoscategoria.get(j).toString());

    		  }
    		  m_ProductosCategorias.add( i, nombreproductoscategoria);
			
    	}
        	
    	bd.close();
    	
    }


} // end class CatalogoProductosActivity





