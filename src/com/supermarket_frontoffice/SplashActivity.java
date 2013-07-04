package com.supermarket_frontoffice;

import com.supermarket_frontoffice.bd.SupermercadoSQLiteHelper;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends Activity {

 private static String TAG = SplashActivity.class.getName();
 private static long SLEEP_TIME = 5;    // Sleep for some time

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);

  this.requestWindowFeature(Window.FEATURE_NO_TITLE);    // Removes title bar
  this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,     WindowManager.LayoutParams.FLAG_FULLSCREEN);    // Removes notification bar

  setContentView(R.layout.splash);
  
  
  //CREACION DE LA BBDD
  
  SupermercadoSQLiteHelper usdbh = new SupermercadoSQLiteHelper(this);
  SQLiteDatabase db = usdbh.getWritableDatabase();
  
  //Borramos las tablas si ya estan creadas
  db.execSQL("DROP TABLE IF EXISTS NFC");
  db.execSQL("DROP TABLE IF EXISTS PAYBOX");
  db.execSQL("DROP TABLE IF EXISTS CATEGORIA");
  db.execSQL("DROP TABLE IF EXISTS PRODUCTO");
  db.execSQL("DROP TABLE IF EXISTS CARRITO");
  
  //Tablas que crearemos
  String sqlNFC = "CREATE TABLE NFC (codigo TEXT)";
  String sqlPAYBOX = "CREATE TABLE PAYBOX (codigo TEXT)";
  String sqlCATEGORIA = "CREATE TABLE CATEGORIA (idcategoria INTEGER, NombreCategoria TEXT, Descripcion TEXT)";
  String sqlPRODUCTO = "CREATE TABLE PRODUCTO (idproducto INTEGER, Categoria_Id_Categoria INTEGER, NombreProducto TEXT, Precio DECIMAL, Marca TEXT, CodigoEAN TEXT, Descripcion TEXT, idEstanteria INTEGER, idSeccion INTEGER, idEstante INTEGER)";	  
  String sqlCARRITO = "CREATE TABLE CARRITO (idproducto INTEGER, cantidad INTEGER, recogido BOOL)";	  
  
  //Creamos las tablas
  db.execSQL(sqlNFC);
  db.execSQL(sqlPAYBOX);
  db.execSQL(sqlCATEGORIA);
  db.execSQL(sqlPRODUCTO);
  db.execSQL(sqlCARRITO);
  
  //Realizamos unas cuantas insercciones
  if(db != null)
  {
//	  db.execSQL("INSERT INTO NFC (codigo) VALUES ('passNFC1')");
//	  db.execSQL("INSERT INTO NFC (codigo) VALUES ('passNFC2')");
//	  db.execSQL("INSERT INTO NFC (codigo) VALUES ('passNFC3')");
//	  
//	  db.execSQL("INSERT INTO PAYBOX (codigo) VALUES ('passPAYBOX1')");
//	  db.execSQL("INSERT INTO PAYBOX (codigo) VALUES ('passPAYBOX2')");
//	  db.execSQL("INSERT INTO PAYBOX (codigo) VALUES ('passPAYBOX3')");
//	  
//	  db.execSQL("INSERT INTO CATEGORIA (idcategoria,NombreCategoria,Descripcion) VALUES (1,'Vinos','Vinos de España y el Mundo')");
//	  db.execSQL("INSERT INTO CATEGORIA (idcategoria,NombreCategoria,Descripcion) VALUES (2,'Embutidos','Embutidos')");
//	  db.execSQL("INSERT INTO CATEGORIA (idcategoria,NombreCategoria,Descripcion) VALUES (3,'Panaderia','Panaderia')");
//	  db.execSQL("INSERT INTO CATEGORIA (idcategoria,NombreCategoria,Descripcion) VALUES (4,'Legumbres y Verduras','Legumbres y Verduras')");
//	  db.execSQL("INSERT INTO CATEGORIA (idcategoria,NombreCategoria,Descripcion) VALUES (5,'Lácteos','Lácteos')");
//	  db.execSQL("INSERT INTO CATEGORIA (idcategoria,NombreCategoria,Descripcion) VALUES (6,'Refrescos','Refrescos')");
//	  db.execSQL("INSERT INTO CATEGORIA (idproducto,NombreCategoria,Descripcion) VALUES (7,'Higiene Personal','Productos de Higiene Personal')");
//	  
//	  db.execSQL("INSERT INTO PRODUCTO (idcategoria,Categoria_Id_Categoria,NombreProducto,Precio,Marca,CodigoEA,Descripcion,idEstanteria,idSeccion,idEstante) VALUES (7,'Higiene Personal','Productos de Higiene Personal')");
    
  }
  db.close();
  
  // Start timer and launch main activity
  IntentLauncher launcher = new IntentLauncher();
  launcher.start();
}

 private class IntentLauncher extends Thread {
  @Override
  /**
   * Sleep for some time and than start new activity.
   */
  public void run() {
     try {
        // Sleeping
        Thread.sleep(SLEEP_TIME*500);
     } catch (Exception e) {
        Log.e(TAG, e.getMessage());
     }

     // Start main activity
     Intent intent = new Intent(SplashActivity.this, MainActivity.class);
     SplashActivity.this.startActivity(intent);
     SplashActivity.this.finish();
  }
}
}