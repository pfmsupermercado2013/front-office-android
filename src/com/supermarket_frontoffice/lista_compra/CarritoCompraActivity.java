package com.supermarket_frontoffice.lista_compra;

import java.util.ArrayList;

import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.bd.SupermercadoDataSource;
import com.supermarket_frontoffice.modelo_datos.Categoria;
import com.supermarket_frontoffice.modelo_datos.Producto;
import com.supermarket_frontoffice.modelo_datos.ProductoCarrito;
import com.supermarket_frontoffice.recorrido_optimo.RecorridoOptimoMainActivity;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class CarritoCompraActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState ) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_carrito_compra);
		
		ArrayList< CarritoCompraItem > itemsCarritoCompra= crearItemsCarritoCompra();
		
		ListView listView= ( ListView ) findViewById( R.id.listViewCarritoCompra );
		
		listView.setAdapter( new ListViewAdapter( this, R.layout.listview_item_carrito_compra, itemsCarritoCompra ) {
		
				@Override
				public void onItemView( Object a_ItemIn, View a_View ) {
					
					CheckBox cbProducto= (CheckBox) a_View.findViewById( R.id.checkBoxItem );
					cbProducto.setText( ((CarritoCompraItem) a_ItemIn).getNombreProducto() );
					
					
					
					EditText edCantidad= (EditText) a_View.findViewById( R.id.editTextCantidadItem );
					edCantidad.setText( String.valueOf( ((CarritoCompraItem) a_ItemIn).getCantidad() ) );
					edCantidad.setEnabled( false );
					
					EditText edPrecioUnidad= (EditText) a_View.findViewById( R.id.editTextPrecioUdsItem );
					edPrecioUnidad.setText( String.valueOf( ((CarritoCompraItem) a_ItemIn).getPrecioUnidadProducto() ) );
					edPrecioUnidad.setEnabled( false );
					
					EditText edPrecioTotal= (EditText) a_View.findViewById( R.id.editTextPrecioTotalItem );
					edPrecioTotal.setText( String.valueOf( ((CarritoCompraItem) a_ItemIn).getPrecioTotalProducto() ) );
					edPrecioTotal.setEnabled( false );
		
				}
	
			}		
		);
		
		EditText editTextTotalPagar= ( EditText ) findViewById( R.id.editTextCantidadProductoCarrito );
		
		float totalPagar= (float)0.;
		
		for ( int i= 0; i < itemsCarritoCompra.size(); ++i ) {
			
			totalPagar += itemsCarritoCompra.get( i ).getPrecioTotalProducto();
		}
		
		editTextTotalPagar.setText( String.valueOf( totalPagar ) );
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.carrito_compra, menu);
		return true;
	}
	
	
	
    @SuppressLint("ResourceAsColor")
	public void onClickCheckedItem( View a_View ) 
    {
    	 	
    	CheckBox ckBoxView= (CheckBox) a_View.findViewById( R.id.checkBoxItem );
    	LinearLayout layout= (LinearLayout) ckBoxView.getParent(); 

    	Resources res= getResources();
    	if ( ckBoxView.isChecked() ) {
    		
    		layout.setBackgroundColor( res.getColor( R.color.green2 ) );
    	}
    	else {
    		layout.setBackgroundColor( res.getColor( R.color.grey2 ) );
    	}
    	
    }
    
	public void onClickGeolocalizarProducto(View a_View)
	{
		ImageView imgView= (ImageView) a_View.findViewById( R.id.imageViewGeolocalizarProducto );
    	LinearLayout layout= (LinearLayout) imgView.getParent().getParent( ); 
    	CheckBox ckBoxView= (CheckBox) layout.findViewById( R.id.checkBoxItem );
    	
    	Log.d("Supermercado-Carrito", "Se pulso sobre geolocalizar "+ckBoxView.getText());

    	SupermercadoDataSource bd = new SupermercadoDataSource(this);
    	bd.open();
    	Producto producto = bd.getProductoByNombre((String) ckBoxView.getText());
    	bd.close();
		Intent intent = new Intent( this, RecorridoOptimoMainActivity.class );
		intent.putExtra("producto", producto );
	    startActivity( intent );	
	}
    
	public void onClickDetallarProducto( View a_View ) 
    {
    	 	
    	ImageView imgView= (ImageView) a_View.findViewById( R.id.imageDetallarProducto );
    	LinearLayout layout= (LinearLayout) imgView.getParent().getParent( ); 
    	CheckBox ckBoxView= (CheckBox) layout.findViewById( R.id.checkBoxItem );
    	
    	Log.d("Supermercado-Carrito", "Se pulso sobre detallar "+ckBoxView.getText());

    	SupermercadoDataSource bd = new SupermercadoDataSource(this);
    	bd.open();
    	Producto producto = bd.getProductoByNombre((String) ckBoxView.getText());
    	bd.close();
		Intent intent= new Intent(this, InformacionProductoActivity.class);
		intent.putExtra("idproducto", producto.getId());
		startActivity(intent);
    }
	
	public void onClickBorraDeCarrito(View a_View)
	{
		Log.d("Supermercado-Carrito", "Se pulso sobre borrar todo");
		SupermercadoDataSource db = new SupermercadoDataSource(this);
		db.open();
		db.borrarCarrito();
		db.close();
		finish();
		startActivity(getIntent());
	}
	
	public void onClickBorraDeCarritoProducto(View a_View)
	{
		ImageView imgView= (ImageView) a_View.findViewById( R.id.imageViewDelete);
    	LinearLayout layout= (LinearLayout) imgView.getParent().getParent( ); 
    	CheckBox ckBoxView= (CheckBox) layout.findViewById( R.id.checkBoxItem );
    	
    	Log.d("Supermercado-Carrito", "Se pulso sobre borrar "+ckBoxView.getText());
    	
    	SupermercadoDataSource db = new SupermercadoDataSource(this);
		db.open();
    	Producto producto = db.getProductoByNombre((String) ckBoxView.getText());
		db.borrarProductoCarrito(producto.getId());
		db.close();
		finish();
		startActivity(getIntent());
	}
	
	private ArrayList< CarritoCompraItem > crearItemsCarritoCompra( )
	{
		SupermercadoDataSource bd= new SupermercadoDataSource(this);
		bd.open();
		ArrayList<ProductoCarrito> productoscarrito = bd.getAllProductosCarrito();
				
		ArrayList< CarritoCompraItem > itemsCarritoCompra= new ArrayList< CarritoCompraItem >();
		
		for( int i = 0 ; i < productoscarrito.size() ; i++ ){
			Categoria categoria = bd.getCategoriaByID(productoscarrito.get(i).getProducto().getCategoriaId());
			itemsCarritoCompra.add( new CarritoCompraItem( productoscarrito.get(i).getProducto().getNombreProducto(), categoria.getNombreCategoria(), productoscarrito.get(i).getCantidad(), productoscarrito.get(i).getProducto().getPrecio() ) );		
		}
		bd.close();
		return itemsCarritoCompra;
		
	}

}
