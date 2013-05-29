package com.supermarket_frontoffice.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

public class Utils {
	
	public static boolean myCustomAlert(String sCadena, Activity oActivity){
		AlertDialog alertDialog = new AlertDialog.Builder(oActivity).create();
		alertDialog.setTitle("Titulo");
		alertDialog.setMessage(sCadena);
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel(); //Cierra la ventana
			}
		});

		alertDialog.show();
		
		return true; 
	}
	
	public static void message(String sCadena, Activity oActivity){
		Toast.makeText(oActivity, sCadena, Toast.LENGTH_LONG).show();
	}
	
}
