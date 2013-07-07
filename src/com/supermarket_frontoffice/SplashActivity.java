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
  
  Log.e("Supermercado-BD", "Creadas tablas correctamente");
  
  //Realizamos unas cuantas insercciones
  if(db != null)
  {
	  db.execSQL("INSERT INTO NFC (codigo) VALUES ('passNFC1')");
	  db.execSQL("INSERT INTO NFC (codigo) VALUES ('passNFC2')");
	  db.execSQL("INSERT INTO NFC (codigo) VALUES ('passNFC3')");
	  
	  Log.e("Supermercado-BD", "Insertado correctamente filas en NFC");
	  
	  db.execSQL("INSERT INTO PAYBOX (codigo) VALUES ('passPAYBOX1')");
	  db.execSQL("INSERT INTO PAYBOX (codigo) VALUES ('passPAYBOX2')");
	  db.execSQL("INSERT INTO PAYBOX (codigo) VALUES ('passPAYBOX3')");
	  
	  Log.e("Supermercado-BD", "Insertado correctamente filas en PAYBOX");
	  
	  db.execSQL("INSERT INTO CATEGORIA (idcategoria,NombreCategoria,Descripcion) VALUES (1,'Vinos','Vinos de España y el Mundo')");
	  db.execSQL("INSERT INTO CATEGORIA (idcategoria,NombreCategoria,Descripcion) VALUES (2,'Embutidos','Embutidos')");
	  db.execSQL("INSERT INTO CATEGORIA (idcategoria,NombreCategoria,Descripcion) VALUES (3,'Panaderia','Panaderia')");
	  db.execSQL("INSERT INTO CATEGORIA (idcategoria,NombreCategoria,Descripcion) VALUES (4,'Legumbres y Verduras','Legumbres y Verduras')");
	  db.execSQL("INSERT INTO CATEGORIA (idcategoria,NombreCategoria,Descripcion) VALUES (5,'Lácteos','Lácteos')");
	  db.execSQL("INSERT INTO CATEGORIA (idcategoria,NombreCategoria,Descripcion) VALUES (6,'Refrescos','Refrescos')");
	  db.execSQL("INSERT INTO CATEGORIA (idcategoria,NombreCategoria,Descripcion) VALUES (7,'Higiene Personal','Productos de Higiene Personal')");
	  
	  Log.e("Supermercado-BD", "Insertado correctamente filas en CATEGORIA");
	  
	  db.execSQL("INSERT INTO PRODUCTO (idproducto,Categoria_Id_Categoria,NombreProducto,Precio,Marca,CodigoEAN,Descripcion,idEstanteria,idSeccion,idEstante) VALUES (1,1,'Vino Tempranillo',2.5,'Valdepeñas','12031304134013','Vino de Valdepeñas',1,1,1)");
	  db.execSQL("INSERT INTO PRODUCTO (idproducto,Categoria_Id_Categoria,NombreProducto,Precio,Marca,CodigoEAN,Descripcion,idEstanteria,idSeccion,idEstante) VALUES (8,1,'Vino Peleon',1.5,'Fuentes','12031324134013','Vino barato',1,1,2)");
	  db.execSQL("INSERT INTO PRODUCTO (idproducto,Categoria_Id_Categoria,NombreProducto,Precio,Marca,CodigoEAN,Descripcion,idEstanteria,idSeccion,idEstante) VALUES (2,2,'Chorizo',1.5,'Embutidos S.A','3131304134013','Embutido de Calidad',2,1,1)");
	  db.execSQL("INSERT INTO PRODUCTO (idproducto,Categoria_Id_Categoria,NombreProducto,Precio,Marca,CodigoEAN,Descripcion,idEstanteria,idSeccion,idEstante) VALUES (3,3,'Tigreton',2,'Grefusa','55235555','Bollo con Chocolate',3,2,1)");
	  db.execSQL("INSERT INTO PRODUCTO (idproducto,Categoria_Id_Categoria,NombreProducto,Precio,Marca,CodigoEAN,Descripcion,idEstanteria,idSeccion,idEstante) VALUES (4,4,'Tomates',0.4,'La Huerta','5232555','Tomates frescos',3,1,1)");
	  db.execSQL("INSERT INTO PRODUCTO (idproducto,Categoria_Id_Categoria,NombreProducto,Precio,Marca,CodigoEAN,Descripcion,idEstanteria,idSeccion,idEstante) VALUES (5,5,'Batidos',5,'Pascual','3255555','Batido de Chocolate',3,5,1)");
	  db.execSQL("INSERT INTO PRODUCTO (idproducto,Categoria_Id_Categoria,NombreProducto,Precio,Marca,CodigoEAN,Descripcion,idEstanteria,idSeccion,idEstante) VALUES (6,6,'Coca Cola',1,'Coca Cola S.A','13131313','Refrescon con cafeina',3,2,2)");
	  db.execSQL("INSERT INTO PRODUCTO (idproducto,Categoria_Id_Categoria,NombreProducto,Precio,Marca,CodigoEAN,Descripcion,idEstanteria,idSeccion,idEstante) VALUES (7,7,'Pasta de Dientes',2.3,'Colgate','34234555','Dentrifico anti-caries',3,3,1)");
	  db.execSQL("INSERT INTO PRODUCTO (idproducto,Categoria_Id_Categoria,NombreProducto,Precio,Marca,CodigoEAN,Descripcion,idEstanteria,idSeccion,idEstante) VALUES (9,7,'Fluor',3.3,'Licor del polo','343234555','Fluo',3,3,2)");
	  db.execSQL("INSERT INTO PRODUCTO (idproducto,Categoria_Id_Categoria,NombreProducto,Precio,Marca,CodigoEAN,Descripcion,idEstanteria,idSeccion,idEstante) VALUES (10,3,'Anacardos',1.3,'Hacendado','8480000340276','Frutos secos - Anacardos',4,1,1)");
	  db.execSQL("INSERT INTO PRODUCTO (idproducto,Categoria_Id_Categoria,NombreProducto,Precio,Marca,CodigoEAN,Descripcion,idEstanteria,idSeccion,idEstante) VALUES (11,6,'Chivas Regal',20.5,'Chivas Brothers Ltd','5000299212851','Whisky escoces',1,2,1)");
	  db.execSQL("INSERT INTO PRODUCTO (idproducto,Categoria_Id_Categoria,NombreProducto,Precio,Marca,CodigoEAN,Descripcion,idEstanteria,idSeccion,idEstante) VALUES (12,7,'Espuma',1.5,'Garnier','8480000440242','Espuma para el pelo',2,2,1)");



	  Log.e("Supermercado-BD", "Insertado correctamente filas en PRODUCTO");
	  
	  db.execSQL("INSERT INTO CARRITO (idproducto,cantidad,recogido) VALUES (3,6,0)");
	  db.execSQL("INSERT INTO CARRITO (idproducto,cantidad,recogido) VALUES (2,1,0)");
	  db.execSQL("INSERT INTO CARRITO (idproducto,cantidad,recogido) VALUES (1,2,0)");
	  db.execSQL("INSERT INTO CARRITO (idproducto,cantidad,recogido) VALUES (11,1,0)");
	  
	  Log.e("Supermercado-BD", "Insertado correctamente filas en CARRITO");

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