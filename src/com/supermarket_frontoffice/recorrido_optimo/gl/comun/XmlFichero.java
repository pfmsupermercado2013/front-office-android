package com.supermarket_frontoffice.recorrido_optimo.gl.comun;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;

import android.content.Context;
import android.util.Log;
import android.util.Xml;



/** @class XmlFile
 * 
 * 	Clase base para la lectura y escritura de ficheros
 * 
 * @author fjvegaf
 *
 */
public abstract class XmlFichero 
{

	private Context 			m_Context;
	protected String 			m_XmlNombreFichero;
	protected FileInputStream 	m_InputStream;
	protected XmlPullParser 	m_Parser;
	
	
	/** Constructor
	 * 
	 * @param a_XmlFileName
	 */
	public XmlFichero( Context a_Context,
					String a_XmlNombreFichero )
	{
		
		m_Context= a_Context;
		m_XmlNombreFichero= a_XmlNombreFichero;
		m_InputStream= null;
		m_Parser= null;
		
	} // XmlFile
	
	/** Abre el fichero Xml
	 * 
	 * @return
	 */
	public boolean open()
	{
		
		try {
			
			
			
			Log.d( "XmlFile", "Intentando abrir el fichero " + m_XmlNombreFichero + "."  );
			m_InputStream= m_Context.openFileInput( m_XmlNombreFichero );
			
			return true;
		}
		catch ( FileNotFoundException e ) {
			
			Log.e( "XmlFile", "El fichero " + m_XmlNombreFichero + " no se ha podido abrir. Excepción: " + e.getMessage()  );
			//Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
			
		}
		catch ( Exception e ) {
			
			Log.e( "XmlFile", "El fichero " + m_XmlNombreFichero + " no se ha podido abrir. Excepción: " + e.getMessage()  );
		}
		
		
		return false;
		
	} // openFile
	
	
	/** Cierra el fichero Xml
	 * 
	 * @return
	 * @throws IOException 
	 */
	public boolean close() 
	{
		
		try {
			
			m_InputStream.close();
			
			return true;
		}
		catch ( IOException e ) {
			
			Log.e( "XmlFile", "Error al intentar abrir el fichero " + m_XmlNombreFichero + " Excepcion: " + e.getMessage() );
			
		}
		
		return false;
		
		
	} // close
	
	public boolean inputParser()
	{
		
		m_Parser= Xml.newPullParser();
		
		try {
			
		
			m_Parser.setInput( m_InputStream, "UTF-8" );
			return true;
		}
		catch ( Exception e ) {
			
			Log.e( "XmlFile", "Error al intentar abrir el fichero " + m_XmlNombreFichero + " Excepcion: " + e.getMessage() );
			
		}
		return false;
		
	} // inputParser
	
		
	/** Clase abstracta que define la lectura del Xml
	 * 
	 * @return
	 */
	public abstract boolean read( );
	
	
	
	
	
	
} // XmlFile
