package com.supermarket_frontoffice.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SupermercadoSQLiteHelper extends SQLiteOpenHelper{
	//Sentencia SQL para crear la tabla de Usuarios 
    String sqlNFC = "CREATE TABLE NFC (codigo TEXT)";
    String sqlPAYBOX = "CREATE TABLE PAYBOX (codigo TEXT)";
    String sqlCATEGORIA = "CREATE TABLE CATEGORIA (idcategoria INTEGER, NombreCategoria TEXT, Descripcion TEXT)";
    String sqlPRODUCTO = "CREATE TABLE PRODUCTO (idproducto INTEGER, Categoria_Id_Categoria INTEGER, NombreProducto TEXT, Precio DECIMAL, Marca TEXT, CodigoEAN TEXT, Descripcion TEXT, idEstanteria INTEGER, idSeccion INTEGER, idEstante INTEGER)";	  
    String sqlCARRITO = "CREATE TABLE CARRITO (idproducto INTEGER, cantidad INTEGER, recogido BOOL)";	  

    
     public SupermercadoSQLiteHelper(Context contexto) {
        super(contexto, "DBSupermercado", null, 1);
    	Log.d("SupermercadoBaseDatos", "BBDD creada");

    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
    	
    	Log.d("SupermercadoBaseDatos", "Eliminadas Tablas1");
        //Eliminamos las tablas, por si quedaran datos
        db.execSQL("DROP TABLE IF EXISTS NFC");
        db.execSQL("DROP TABLE IF EXISTS PAYBOX");
        db.execSQL("DROP TABLE IF EXISTS CATEGORIA");
        db.execSQL("DROP TABLE IF EXISTS PRODUCTO");
        db.execSQL("DROP TABLE IF EXISTS CARRITO");

        Log.d("SupermercadoBaseDatos", "Eliminadas Tablas2");
        

        Log.d("SupermercadoBaseDatos", "Creadas Tablas1");
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlNFC);
        db.execSQL(sqlPAYBOX);
        db.execSQL(sqlCATEGORIA);
        db.execSQL(sqlPRODUCTO);
        db.execSQL(sqlCARRITO);
        Log.d("SupermercadoBaseDatos", "Creadas Tablas2");
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aquí utilizamos directamente la opción de
        //      eliminar la tabla anterior y crearla de nuevo vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la tabla antigua
        //      a la nueva, por lo que este método debería ser más elaborado.
 
        Log.d("SupermercadoBaseDatos", "Eliminadas Tablas1 (Actualización)");
        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS NFC");
        db.execSQL("DROP TABLE IF EXISTS PAYBOX");
        db.execSQL("DROP TABLE IF EXISTS CATEGORIA");
        db.execSQL("DROP TABLE IF EXISTS PRODUCTO");
        Log.d("SupermercadoBaseDatos", "Eliminadas Tablas2 (Actualización)");
 
        Log.d("SupermercadoBaseDatos", "Creadas Tablas1 (Actualización)");
        //Se crea la nueva versión de la tabla
        db.execSQL(sqlNFC);
        db.execSQL(sqlPAYBOX);
        db.execSQL(sqlCATEGORIA);
        db.execSQL(sqlPRODUCTO);
        db.execSQL(sqlCARRITO);
        Log.d("SupermercadoBaseDatos", "Creadas Tablas2 (Actualización)");
    }
}
