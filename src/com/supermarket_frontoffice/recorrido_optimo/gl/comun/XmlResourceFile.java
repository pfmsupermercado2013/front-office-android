package com.supermarket_frontoffice.recorrido_optimo.gl.comun;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

//import org.xmlpull.v1.XmlPullParser;

import com.supermarket_frontoffice.R;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.Log;
//import android.util.Xml;


/** @class XmlResourceFile
 * 
 * @author fjvegaf
 *
 */
public abstract class XmlResourceFile 
{
	
	public static final String TAG= "XmlResourceFile";
	
	private Context 				m_Context;
	protected int 					m_ResourceFile;
	protected XmlResourceParser 	m_Parser;
	boolean 						m_IsParser;
	

	
	
	
	/**
	 * 
	 */
	public XmlResourceFile( XmlResourceParser a_Parser )
	{

		m_Context= null;
		m_ResourceFile= 0;
		m_Parser= a_Parser;
		m_IsParser= true;
		
		
	} // XmlResourceFile
	
	
	/**
	 * 
	 */
	public XmlResourceFile( Context a_Context,
							int  a_ResourceFile )
	{

		m_Context= a_Context;
		m_ResourceFile= a_ResourceFile;
		m_Parser= null;
		m_IsParser= false;
		
	} // XmlResourceFile
	
	
	/** Cierra el fichero Xml
	 * 
	 * @return
	 * @throws IOException 
	 */
	public boolean close() 
	{
		
		try {
			
			m_Parser.close();
			
			m_IsParser= false;
			
			return true;
		}
		catch ( Exception e ) {
			
			Log.e( "XmlFile", "Error al intentar abrir el recurso " + m_ResourceFile + " Excepcion: " + e.getMessage() );
			
		}
		
		return false;
		
		
	} // close
	
	
	
	public boolean inputParser()
	{
		
		try {
			
			if ( m_IsParser ) {
				
				Log.d( TAG, "El recurso ya ha sido parseado previamente."  );
				return true;
			}
			
			Log.d( TAG, "Intentando abrir el recurso " + m_ResourceFile + "."  );
	
			m_Parser= m_Context.getResources().getXml( m_ResourceFile );				
			m_IsParser= true;
			
			return true;
		}
//		catch ( FileNotFoundException e ) {
//			
//			Log.e( TAG, "El recurso " + m_ResourceFile + " no se ha podido abrir. Excepción: " + e.getMessage()  );
//			//Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
//			
//		}
		catch ( Exception e ) {
			
			Log.e( TAG, "El recurso " + m_ResourceFile + " no se ha podido abrir. Excepción: " + e.getMessage()  );
		}
		
		return false;
		
	} // inputParser
	
	
	/** Método abstracto que debe ser implementado en las clases que lo hererar
	 * 
	 * @return
	 */
	public abstract boolean read();
	
	
	
	/** 
	 * 
	 * @return
	 */
	protected XmlResourceParser getParser( )
	{
		return this.m_Parser;
	} // getParser
	
} // end XmlResourceFile
