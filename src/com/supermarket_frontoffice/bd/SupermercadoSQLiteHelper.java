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
        //Se ejecuta la sentencia SQL de creaci�n de la tabla
        db.execSQL(sqlNFC);
        db.execSQL(sqlPAYBOX);
        db.execSQL(sqlCATEGORIA);
        db.execSQL(sqlPRODUCTO);
        db.execSQL(sqlCARRITO);
        Log.d("SupermercadoBaseDatos", "Creadas Tablas2");
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aqu� utilizamos directamente la opci�n de
        //      eliminar la tabla anterior y crearla de nuevo vac�a con el nuevo formato.
        //      Sin embargo lo normal ser� que haya que migrar datos de la tabla antigua
        //      a la nueva, por lo que este m�todo deber�a ser m�s elaborado.
 
        Log.d("SupermercadoBaseDatos", "Eliminadas Tablas1 (Actualizaci�n)");
        //Se elimina la versi�n anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS NFC");
        db.execSQL("DROP TABLE IF EXISTS PAYBOX");
        db.execSQL("DROP TABLE IF EXISTS CATEGORIA");
        db.execSQL("DROP TABLE IF EXISTS PRODUCTO");
        Log.d("SupermercadoBaseDatos", "Eliminadas Tablas2 (Actualizaci�n)");
 
        Log.d("SupermercadoBaseDatos", "Creadas Tablas1 (Actualizaci�n)");
        //Se crea la nueva versi�n de la tabla
        db.execSQL(sqlNFC);
        db.execSQL(sqlPAYBOX);
        db.execSQL(sqlCATEGORIA);
        db.execSQL(sqlPRODUCTO);
        db.execSQL(sqlCARRITO);
        Log.d("SupermercadoBaseDatos", "Creadas Tablas2 (Actualizaci�n)");
    }
}
