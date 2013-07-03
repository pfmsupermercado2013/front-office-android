package com.supermarket_frontoffice.pago;

import java.io.IOException;
import java.nio.charset.Charset;

import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.lista_compra.ListaCompraActivity;
import com.supermarket_frontoffice.utils.Utils;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.MifareUltralight;
import android.os.Bundle;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.util.Printer;
import android.view.Menu;


public class PagoNFCActivity extends Activity {

	final String TAG = PagoNFCActivity.class.getSimpleName();
	NfcAdapter mNfcAdapter;
	boolean mInWriteMode;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pago_nfc);
		
		mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (mNfcAdapter == null) { //TO TEST
           
            finish();
            
            return;
        }
        else{
        	Utils.message(NfcAdapter.ACTION_NDEF_DISCOVERED, this);
        
        }
        
		//TODO: Quitar cuando de verdad funcione NFC
		try {
			
			enableWriteMode();
			
			payNFCDone();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

	private void enableWriteMode() {
		mInWriteMode = true;
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
		IntentFilter tagDetected = new IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED);
		IntentFilter[] filters = new IntentFilter[] { tagDetected };

		mNfcAdapter.enableForegroundDispatch(this, pendingIntent, filters, null);
	}


	public void onNewIntent(Intent intent) {
		if(mInWriteMode) {
			mInWriteMode = false;

			Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
			//writeTag(tag);
		}
	}


	
	
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pago_nfc, menu);
		return true;
	}
	
	
	//Esta función se ejecuta cuando el pago por NFC es correcto
	private void payNFCDone(){
		
		Intent intent = new Intent(PagoNFCActivity.this, FinalizarPagoActivity.class);
		startActivity(intent);
	}

	

}
