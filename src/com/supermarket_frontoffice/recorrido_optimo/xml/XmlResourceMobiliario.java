package com.supermarket_frontoffice.recorrido_optimo.xml;


import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.Log;
import com.supermarket_frontoffice.modelo_datos.Mobiliario;
//import com.supermarket_frontoffice.recorrido_optimo.comun.XmlResourceEstanteria;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.XmlResourceFile;




/** @class XmlResourceMobiliario
 * 
 * @author fjvegaf
 *
 */
public class XmlResourceMobiliario extends XmlResourceFile 
{
	
	
	private static final String TAG= "XmlResourceMobiliario";
	
	
	private Mobiliario 					m_Mobiliario;				///< Mobiliario el Supermercado
	private XmlResourceEstanteria		m_XmlResourseEstanteria;
	
	
	/** Constructor
	 * 
	 * @param a_XmlFichero
	 */
	public XmlResourceMobiliario( Context a_Context,
									int a_ResourceFile )
	{
		
		this( a_Context, a_ResourceFile, new Mobiliario() );
		
	} // XmlResourceSupermercado
	
	
	/** Constructor
	 * 
	 * @param a_XmlFichero
	 */
	public XmlResourceMobiliario( Context a_Context,
								  int a_ResourceFile,
								  Mobiliario a_Mobiliario )
	{
		
		super( a_Context, a_ResourceFile );
		
		m_Mobiliario= a_Mobiliario;
		m_XmlResourseEstanteria= null; 
		
	} // XmlResourceSupermercado
	
	
	
	/** Inicializa la lectura de todos los elementos que componen el supermercado
	 * 
	 * @return true si se ha realizado correctamente la lectura del supermercado.
	 */
	public boolean read( )
	{
		
		
		if ( !super.inputParser() ) {
			
			Log.e( TAG, "No se ha podido parsear el fichero Xml" );
			return false;
		}
		
		//Log.d( TAG, "Buscando los datos del mobiliario ... " );
		
		try {
			
			
			m_XmlResourseEstanteria= new XmlResourceEstanteria( super.getParser() );
		
			int event= super.m_Parser.next();
			
			while ( event != XmlResourceParser.END_DOCUMENT ) {
				
			   if ( event == XmlResourceParser.START_TAG ) {

				   if ( super.m_Parser.getName().trim().equals( "mobiliario" ) ) {
					   
					   //Log.d( TAG, "<" + super.m_Parser.getName() + ">" );
					   this.readMobiliario();
					   
					   
				   }
					   
//					Log.d( TAG, "<" + super.m_Parser.getName() + ">" );
//					for ( int i = 0; i < super.m_Parser.getAttributeCount(); i++ ) {
//							  
//						Log.d( TAG, "\t" + super.m_Parser.getAttributeName(i) + " = " + super.m_Parser.getAttributeValue(i) );
//					}
				   
			   } // end if
				 
			  
				event = super.m_Parser.next();
			}
		
		}
		catch ( Exception e ) {
			
			Log.e( TAG, "Error al intentar abrir el fichero " + m_ResourceFile + " Excepcion: " + e.getMessage() );
			return false;
		}
		
		
		if (!super.close() ) {
			
			Log.e( TAG, "Error al cerrar el fichero Xml.");
			return false;
		}

		return true;
	
	} // read
	

	
	
	/** Lee todos los datos del mobiliario del supermercado.
	 * 
	 * @return
	 */
	public boolean readMobiliario( )
	{
		
		
		Log.d( TAG, "Lectura del Mobiliario ... " );
		
		try {
		
			int event= super.m_Parser.next();
			
			while ( event != XmlResourceParser.END_DOCUMENT ) {
				
				   if ( event == XmlResourceParser.START_TAG ) {
			      
					   if ( super.m_Parser.getName().trim().equals( "estanteria" ) ) {
						   
						   //Log.d( TAG, "<" + super.m_Parser.getName() + ">" );
						   	   
						   m_XmlResourseEstanteria.read();						  
						   
						   this.m_Mobiliario.addEstanteria( m_XmlResourseEstanteria.getEstanteria() );
						   
						   
//						   Log.d( TAG, "Mostrando todos los datos de la estantería del supermercado ..." );
//						   Log.d( TAG, m_XmlResourseEstanteria.getEstanteria().toString() );
						   
					   } // end if
				   } // end if
				 			 
//				   if ( event == XmlResourceParser.END_TAG ) {
//				     
//					   Log.d( TAG, "</" + super.m_Parser.getName() + ">" );
//				   }
				  
				   event = super.m_Parser.next();
			}
		
		}
		catch ( Exception e ) {
			
			Log.e( TAG, "Error al intentar abrir el recurso " + m_ResourceFile + " Excepcion: " + e.getMessage() );
			return false;
		}
		
//		Log.d( TAG, "Mostrando todos los datos del inmobiliario del supermercado ..." );
//		Log.d( TAG, this.m_Mobiliario.toString() );
		
		return true;
		
	} // read
	
	

	/**
	 * 
	 * @return
	 */
	Mobiliario getMobiliario( )
	{
		return this.m_Mobiliario;
	}
	

} // XmlFicheroSupermercadoComponentes
