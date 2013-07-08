package com.supermarket_frontoffice.lista_compra;

import java.util.ArrayList;

import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.bd.SupermercadoDataSource;
import com.supermarket_frontoffice.modelo_datos.Categoria;
import com.supermarket_frontoffice.modelo_datos.ProductoCarrito;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

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
	
	/** Crea una lista de la compra
	 * 
	 * @return
	 */
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
		
//		itemsCarritoCompra.add( new CarritoCompraItem( "Solán de Cabras (agua) 1L", "Bebidas", 20, (float) 0.53 ) );		
//		itemsCarritoCompra.add( new CarritoCompraItem( "Tropicana (zumo naranja) 1 L", "Bebidas", 2, (float) 1.08 ) );		
//		itemsCarritoCompra.add( new CarritoCompraItem( "Coca-Cola 2L", "Bebidas", 1, (float) 0.79 ) );		
//		itemsCarritoCompra.add( new CarritoCompraItem( "Fanta Naranja 33cl", "Bebidas", 6, (float) 0.43 ) );		
//		itemsCarritoCompra.add( new CarritoCompraItem( "Carbonel(oliva suave) 1L", "Aceites", 2, (float) 3.90 ) );		
//		itemsCarritoCompra.add( new CarritoCompraItem( "Ibarra(Jeréz) 250ml", "Vinages", 1, (float) 3.16 ) );		
//		itemsCarritoCompra.add( new CarritoCompraItem( "Borges(basámilco) 250ml", "Vinages", 1, (float) 1.82 ) );
//		itemsCarritoCompra.add( new CarritoCompraItem( "Alhambra 1925 6x33cl", "Bebidas", 2, (float) 3.59 ) );
//		itemsCarritoCompra.add( new CarritoCompraItem( "Mahou 5 Estrellas (6x25cl", "Bebidas", 2, (float) 2.56 ) );
	
		return itemsCarritoCompra;
		
	}

}
