package com.supermarket_frontoffice.pago;

import com.supermarket_frontoffice.R;
import com.supermarket_frontoffice.utils.Utils;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


public class PagoNFCActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pago_nfc);
		
		NfcAdapter mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        /*if (mNfcAdapter == null) { //TO TEST
           
        	Utils.message(getString(R.string.NFCDisable), this);
        	
            finish(); 
            
            return;
        }*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pago_nfc, menu);
		return true;
	}

}
