package com.supermarket_frontoffice.bd;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.supermarket_frontoffice.modelo_datos.Categoria;
import com.supermarket_frontoffice.modelo_datos.Producto;
import com.supermarket_frontoffice.modelo_datos.LocalizacionProducto;
import com.supermarket_frontoffice.modelo_datos.CarritoCompra;
import com.supermarket_frontoffice.modelo_datos.ProductoCarrito;

public class SupermercadoDataSource {
	private SQLiteDatabase db;
    private SupermercadoSQLiteHelper dbHelper;
    
    private String[] columnasNFC = { "codigo" };
    private String[] columnasPAYBOX = { "codigo" };
    private String[] columnasCATEGORIA = {"idcategoria" , "NombreCategoria" , "Descripcion"};
    private String[] columnasPRODUCTO = {"idproducto", "Categoria_Id_Categoria", "NombreProducto","Precio", "Marca","CodigoEAN", "Descripcion", "idEstanteria","idSeccion","idEstante"};
    private String[] columnasCARRITO = {"idproducto", "cantidad", "NombreProducto","recogido"};


     
     
    public SupermercadoDataSource(Context context) {
        dbHelper = new SupermercadoSQLiteHelper(context);
    }
 
    public void open() {
        db = dbHelper.getWritableDatabase();
    }
 
    public void close() {
        dbHelper.close();
    }
    
    public Producto getProductoByID(short id) {
        
        Cursor cursor = db.query("PRODUCTO", columnasPRODUCTO, "idproducto='"+id+"'", null,
                null, null, null,"1");
    		
        cursor.moveToFirst();
        Producto productoByID = cursorToProducto(cursor);
        cursor.close();
        return productoByID;
    }
 
    public ArrayList<Categoria> getAllCategorias() {
        ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
 
        Cursor cursor = db.query("CATEGORIA", columnasCATEGORIA, null, null,
                null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Categoria nuevaCategoria = cursorToCategoria(cursor);
            listaCategorias.add(nuevaCategoria);
            cursor.moveToNext();
        }
        cursor.close();
        return listaCategorias;
    }
    
    public List<Producto> getAllProductos() {
        List<Producto> listaProductos = new ArrayList<Producto>();
 
        Cursor cursor = db.query("PRODUCTO", columnasPRODUCTO, null, null,
                null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Producto nuevoProducto = cursorToProducto(cursor);
            listaProductos.add(nuevoProducto);
            cursor.moveToNext();
        }
        cursor.close();
        return listaProductos;
    }
    
    public List<Producto> getProductosByCategoriaID(short id) {
        List<Producto> listaProductos = new ArrayList<Producto>();
        
        Cursor cursor = db.query("PRODUCTO", columnasPRODUCTO, "Categoria_Id_Categoria='"+id+"'", null,
                null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Producto nuevoProducto = cursorToProducto(cursor);
            listaProductos.add(nuevoProducto);
            cursor.moveToNext();
        }
        cursor.close();
        return listaProductos;
    }
    
    public ArrayList<ProductoCarrito> getAllProductosCarrito() {
        ArrayList<ProductoCarrito> listaProductosCarrito = new ArrayList<ProductoCarrito>();
 
        Cursor cursor = db.query("CARRITO", columnasCARRITO, null, null,
                null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ProductoCarrito nuevoProductoCarrito = cursorToProductoCarrito(cursor);
            listaProductosCarrito.add(nuevoProductoCarrito);
            cursor.moveToNext();
        }
        cursor.close();
        return listaProductosCarrito;
    }
    
    public CarritoCompra getCarrito() {
        CarritoCompra carrito = new CarritoCompra((short)0);
        carrito.setListaCompra(this.getAllProductosCarrito());

        return carrito;
    }

    private Categoria cursorToCategoria(Cursor cursor) {
        Categoria categoria = new Categoria(cursor.getShort(0),cursor.getString(1), cursor.getString(2));
        return categoria;
    }
    
    private Producto cursorToProducto(Cursor cursor) {
    	LocalizacionProducto localizacionproducto = new LocalizacionProducto(cursor.getShort(7),cursor.getShort(8),cursor.getShort(9));
        Producto producto = new Producto(cursor.getShort(0),cursor.getString(2), cursor.getString(4),cursor.getShort(1),cursor.getString(5),cursor.getString(6),cursor.getFloat(3),localizacionproducto);
        return producto;
    }
    
    private ProductoCarrito cursorToProductoCarrito(Cursor cursor) {
       Producto producto = this.getProductoByID(cursor.getShort(0));
       boolean recogido=false;
       if(cursor.getShort(2)==1)
       {
    	   recogido=true;
       }  
       ProductoCarrito productoCarrito = new ProductoCarrito(producto.getCategoriaId(),producto.getNombreProducto(),producto.getMarca(),producto.getCategoriaId(),producto.getCodigoEAN(),producto.getDescripcion(),producto.getPrecio(),cursor.getShort(1),recogido,producto.getLocalizacion());
        return productoCarrito;
    }
}
