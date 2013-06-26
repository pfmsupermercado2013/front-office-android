package com.supermarket_frontoffice.recorrido_optimo.xml;


import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.Log;

import com.supermarket_frontoffice.modelo_datos.Edificio;
import com.supermarket_frontoffice.modelo_datos.EsquinaEdificio;
import com.supermarket_frontoffice.modelo_datos.ParedEdificio;
import com.supermarket_frontoffice.modelo_datos.PuertaEdificio;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.XmlResourceFile;


/** @class XmlResourceEdificio
 * 
 * @author fjvegaf
 *
 */
public class XmlResourceEdificio extends XmlResourceFile 
{
	
	
	private static final String TAG= "XmlResourceEdificio";
	
	private Edificio 					m_Edificio;				///< Mobiliario el Supermercado
	
	/** Constructor
	 * 
	 * @param a_Context
	 * @param a_ResourceFile
	 */
	public XmlResourceEdificio( Context a_Context,
								int a_ResourceFile )
	{
		this( a_Context, a_ResourceFile, new Edificio() );		
	} // XmlResourceEdificio
	
	
	/** Constructor
	 * 
	 * @param a_XmlFichero
	 */
	public XmlResourceEdificio( Context a_Context,
								  int a_ResourceFile,
								  Edificio a_Edificio )
	{
		
		super( a_Context, a_ResourceFile );		
		m_Edificio= a_Edificio;
		
	} // XmlResourceSupermercado

	
	/** Inicializa la lectura de todos los elementos del edificio del supermercado
	 * 
	 * @return true si se ha realizado correctamente la lectura de los datos del edificio.
	 */
	public boolean read( )
	{
		
		Log.d( TAG, "Antes de parsear el fichero" );
		
		if ( !super.inputParser() ) {
			
			Log.e( TAG, "No se ha podido parsear el fichero Xml" );
			return false;
		}
		
		Log.d( TAG, "Buscando los datos del edificio ... " );
		
		try {
			
						
			int event= super.m_Parser.next();
			
			while ( event != XmlResourceParser.END_DOCUMENT ) {
			
				//Log.d( TAG, "[out]<" + super.m_Parser.getName() + ">" );
				if ( event == XmlResourceParser.START_TAG ) {

					if ( super.m_Parser.getName().trim().equals( "edificio" ) ) {
					   
						Log.d( TAG, "<" + super.m_Parser.getName() + ">" );
						this.readEdificio();
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
	
	
	
	/** Lee todos los datos del edificio del supermercado.
	 * 
	 * @return
	 */
	public boolean readEdificio( )
	{
		
		
		Log.d( TAG, "Lectura del datos del Edificio ... " );
		
		try {
		
			int event= super.m_Parser.next();
			
			while ( event != XmlResourceParser.END_DOCUMENT ) {
				
				   if ( event == XmlResourceParser.START_TAG ) {
			    
					   Log.d( TAG, "[out]<" + super.m_Parser.getName() + ">" );
					   if ( super.m_Parser.getName().trim().equals( "lista-esquinas" ) ) {
						   
						   Log.d( TAG, "<" + super.m_Parser.getName() + ">" );
						   this.readEsquinas();						  
						   
//						   Log.d( TAG, "Mostrando todos los datos de la estantería del supermercado ..." );
//						   Log.d( TAG, m_XmlResourseEstanteria.getEstanteria().toString() );
					   } // end if
					   else if ( super.m_Parser.getName().trim().equals( "lista-paredes" ) ) {
						   
						   Log.d( TAG, "<" + super.m_Parser.getName() + ">" );
						   this.readParedes();						  
						   
//						   Log.d( TAG, "Mostrando todos los datos de la estantería del supermercado ..." );
//						   Log.d( TAG, m_XmlResourseEstanteria.getEstanteria().toString() );
					   } // end if
					   else if ( super.m_Parser.getName().trim().equals( "lista-puertas" ) ) {
						   
						   Log.d( TAG, "<" + super.m_Parser.getName() + ">" );
						   this.readPuertas();						  
						   
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
	
	
	/** Lee todos los datos de todas las esquinas del edificio
	 * 
	 * @return
	 */
	public boolean readEsquinas( )
	{
		
		
		Log.d( TAG, "Lectura del datos de las esquinas del edificio ... " );
		
		try {
		
			int event= super.m_Parser.next();
			
			while ( event != XmlResourceParser.END_DOCUMENT ) {
				
				   if ( event == XmlResourceParser.START_TAG ) {
			      
					   if ( super.m_Parser.getName().trim().equals( "esquina" ) ) {
						   
						   //Log.d( TAG, "<" + super.m_Parser.getName() + ">" );
						   this.readEsquina();	   
						   
					   } // end if
				   } // end if
				 			 
				   if ( event == XmlResourceParser.END_TAG && super.m_Parser.getName().trim().equals( "lista-esquinas" ) ) {
				     
					   Log.d( TAG, "</" + super.m_Parser.getName() + ">" );
					   return true;
				   }
				  
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
		
	} // readEsquinas
	
	
	/** Lee todos los datos de todas las pederes del supermercado.
	 * 
	 * @return
	 */
	public boolean readParedes( )
	{
		
		
		Log.d( TAG, "Lectura del datos de las paderes del edificio ... " );
		
		try {
		
			int event= super.m_Parser.next();
			
			while ( event != XmlResourceParser.END_DOCUMENT ) {
				
				   if ( event == XmlResourceParser.START_TAG ) {
			      
					   if ( super.m_Parser.getName().trim().equals( "pared" ) ) {
						   
						   Log.d( TAG, "<" + super.m_Parser.getName() + ">" );
						   this.readPared();
						   
						   //m_XmlResourseEstanteria.read();						  
						   
						   
//						   Log.d( TAG, "Mostrando todos los datos de la estantería del supermercado ..." );
//						   Log.d( TAG, m_XmlResourseEstanteria.getEstanteria().toString() );
						   
					   } // end if
				   } // end if
				 			 
				   if ( event == XmlResourceParser.END_TAG && super.m_Parser.getName().trim().equals( "lista-paredes" ) ) {
					     
					   Log.d( TAG, "</" + super.m_Parser.getName() + ">" );
					   return true;
				   }
				  
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
		
	} // readParedes
	
	
	/** Lee todos los datos de todas las paredes del supermercado.
	 * 
	 * @return
	 */
	public boolean readEsquina( )
	{
		
		Log.d( TAG, "Lectura del datos de la esquina ... " );
		
		
		EsquinaEdificio esquina= new EsquinaEdificio();
		for ( int i = 0; i < super.m_Parser.getAttributeCount(); i++ ) {
			
			if ( super.m_Parser.getAttributeName(i).equals( "id" ) ) 	{ 	
				
				//Log.d( TAG, "ID=> " + Short.parseShort( super.m_Parser.getAttributeValue(i).trim() ) );
				esquina.setId( Short.parseShort( super.m_Parser.getAttributeValue(i).trim() ) );			 
			}
			else if ( super.m_Parser.getAttributeName(i).equals( "x" )) {	
				//Log.d( TAG, "X=> " + Float.parseFloat( super.m_Parser.getAttributeValue(i).trim()  ) );
				esquina.getVertice().setX( Float.parseFloat( super.m_Parser.getAttributeValue(i).trim() ));	 }
			else if ( super.m_Parser.getAttributeName(i).equals( "y" )) {	
				//Log.d( TAG, "Y=> " + Float.parseFloat( super.m_Parser.getAttributeValue(i).trim()  ) );
				esquina.getVertice().setY(  Float.parseFloat( super.m_Parser.getAttributeValue(i).trim() )); }
			else if ( super.m_Parser.getAttributeName(i).equals( "z" )) {	
				//Log.d( TAG, "Z=> " + Float.parseFloat( super.m_Parser.getAttributeValue(i).trim()  ) );
				esquina.getVertice().setZ(  Float.parseFloat( super.m_Parser.getAttributeValue(i).trim() )); }

			//Log.d( TAG, "\t Atributo=> " + super.m_Parser.getAttributeName(i) + " = " + super.m_Parser.getAttributeValue(i) );
		}
		
		Log.d( TAG, "Datos de la Esquina ===>" );
		Log.d( TAG, esquina.toString() );
		
		m_Edificio.addEsquina( esquina );
		
//		ArrayList< EsquinaEdificio > 	m_ListaEsquinas; 
//		ArrayList< ParedEdificio > 		m_ListaParedes; 
		return true;
	}
	
	
	/** Lee todos los datos de todas las pederes del supermercado.
	 * 
	 * @return
	 */
	public boolean readPared( )
	{
		
		Log.d( TAG, "Lectura del datos de la pared ... " );
		
		ParedEdificio pared= new ParedEdificio();
		
		for ( int i = 0; i < super.m_Parser.getAttributeCount(); i++ ) {
			
			if ( super.m_Parser.getAttributeName(i).equals( "id" ) ) { 	
				
				//Log.d( TAG, "ID=> " + Short.parseShort( super.m_Parser.getAttributeValue(i).trim() ) );
				pared.setId( Short.parseShort( super.m_Parser.getAttributeValue(i).trim() ) );			 
			}
			else if ( super.m_Parser.getAttributeName(i).equals( "id_esquina_a" )) {	
				
				//Log.d( TAG, "id_esquina_a=> Id:" + super.m_Parser.getAttributeValue(i).trim() );
//				EsquinaEdificio esquina= new EsquinaEdificio();
//				short idEsquina= Short.parseShort( super.m_Parser.getAttributeValue(i).trim() );
//				if ( this.m_Edificio.findEsquina( idEsquina, esquina ) ) {
//					
//					Log.d( TAG, "id_esquina_a => Esquina =>" + esquina.toString() + "\n" );
//					pared.setV1( esquina );
//					Log.d( TAG, "id_esquina_a => Despues de setV1 " );
//				}				
//				else {
//					
//					Log.d( TAG, "Pared-Esquina A - No se ha definido ninguna esquina con el Id " + idEsquina );
//				}
				
				
				//Log.d( TAG, "id_esquina_a=> " + super.m_Parser.getAttributeValue(i).trim() );
				
				short idEsquina= Short.parseShort( super.m_Parser.getAttributeValue(i).trim() );
				
				EsquinaEdificio esquina= this.m_Edificio.findEsquina( idEsquina );
				if ( esquina != null ) {
					
					pared.setV1( esquina );
				}		
				else {
					
					Log.d( TAG, "Pared-Esquina A - No se ha definido ninguna esquina con el Id " + idEsquina );
				}
			}
			else if ( super.m_Parser.getAttributeName(i).equals( "id_esquina_b" )) {	
				
				
				//Log.d( TAG, "id_esquina_b=> " + super.m_Parser.getAttributeValue(i).trim() );
				
				short idEsquina= Short.parseShort( super.m_Parser.getAttributeValue(i).trim() );
				
				EsquinaEdificio esquina= this.m_Edificio.findEsquina( idEsquina );
				if ( esquina != null ) {
					
					pared.setV2( esquina );
				}		
				else {
					
					Log.d( TAG, "Pared-Esquina B - No se ha definido ninguna esquina con el Id " + idEsquina );
				}
				
//				if ( this.m_Edificio.findEsquina( idEsquina, esquina ) ) {
//					
//					pared.setV2( esquina );
//				}		
//				else {
//					
//					Log.d( TAG, "Pared-Esquina B - No se ha definido ninguna esquina con el Id " + idEsquina );
//				}
			}
			else if ( super.m_Parser.getAttributeName(i).equals( "ancho" )) {	
				
				//Log.d( TAG, "ancho=> " + super.m_Parser.getAttributeValue(i).trim() );
				pared.setAncho(  Float.parseFloat( super.m_Parser.getAttributeValue(i).trim() )); 
			}

			//Log.d( TAG, "\t Atributo=> " + super.m_Parser.getAttributeName(i) + " = " + super.m_Parser.getAttributeValue(i) );
		}
		
		Log.d( TAG, "Datos de la Pared ===>" );
		Log.d( TAG, pared.toString() );
		
		m_Edificio.addPared( pared );
		
		return true;
	} // end readPared
	
	
	
	/** Lee todos los datos de todas las pederes del supermercado.
	 * 
	 * @return
	 */
	public boolean readPuertas( )
	{
		
		
		Log.d( TAG, "Lectura del datos de las puertas del edificio ... " );
		
		try {
		
			int event= super.m_Parser.next();
			
			while ( event != XmlResourceParser.END_DOCUMENT ) {
				
				   if ( event == XmlResourceParser.START_TAG ) {
			      
					   if ( super.m_Parser.getName().trim().equals( "puerta" ) ) {
						   
						   Log.d( TAG, "<" + super.m_Parser.getName() + ">" );
						   this.readPuerta();
						   
						   //m_XmlResourseEstanteria.read();						  
						   
						   
//						   Log.d( TAG, "Mostrando todos los datos de la estantería del supermercado ..." );
//						   Log.d( TAG, m_XmlResourseEstanteria.getEstanteria().toString() );
						   
					   } // end if
				   } // end if
				 			 
				   if ( event == XmlResourceParser.END_TAG && super.m_Parser.getName().trim().equals( "lista-puertas" ) ) {
					     
					   Log.d( TAG, "</" + super.m_Parser.getName() + ">" );
					   return true;
				   }
				  
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
		
	} // readParedes
	
	
	/** Lee todos los datos de todas las pederes del supermercado.
	 * 
	 * @return
	 */
	public boolean readPuerta( )
	{
		
		Log.d( TAG, "Lectura del datos de la puerta ... " );
		
		PuertaEdificio puerta= new PuertaEdificio();
		
		for ( int i = 0; i < super.m_Parser.getAttributeCount(); i++ ) {
			
			if ( super.m_Parser.getAttributeName(i).equals( "id" ) ) { 	
				
				//Log.d( TAG, "ID=> " + Short.parseShort( super.m_Parser.getAttributeValue(i).trim() ) );
				puerta.setId( Short.parseShort( super.m_Parser.getAttributeValue(i).trim() ) );			 
			}
			else if ( super.m_Parser.getAttributeName(i).equals( "id_pared" )) {	
								
				//Log.d( TAG, "id_esquina_a=> " + super.m_Parser.getAttributeValue(i).trim() );
				
				short idPared= Short.parseShort( super.m_Parser.getAttributeValue(i).trim() );
				
				ParedEdificio pared= this.m_Edificio.findPared( idPared );
				if ( pared != null ) {
					
					puerta.setPared( pared );
				}		
				else {
					
					Log.d( TAG, "Pared-Esquina A - No se ha definido ninguna pared con el Id " + idPared );
				}
			}
			else if ( super.m_Parser.getAttributeName(i).equals( "x_left" )) {	
				
				//Log.d( TAG, "ancho=> " + super.m_Parser.getAttributeValue(i).trim() );
				puerta.setXLeft( Float.parseFloat( super.m_Parser.getAttributeValue(i).trim() )); 
			}
			else if ( super.m_Parser.getAttributeName(i).equals( "alto" )) {	
				
				//Log.d( TAG, "ancho=> " + super.m_Parser.getAttributeValue(i).trim() );
				puerta.setAlto(  Float.parseFloat( super.m_Parser.getAttributeValue(i).trim() )); 
			}
			else if ( super.m_Parser.getAttributeName(i).equals( "largo" )) {	
				
				//Log.d( TAG, "ancho=> " + super.m_Parser.getAttributeValue(i).trim() );
				puerta.setLargo(  Float.parseFloat( super.m_Parser.getAttributeValue(i).trim() )); 
			}

			//Log.d( TAG, "\t Atributo=> " + super.m_Parser.getAttributeName(i) + " = " + super.m_Parser.getAttributeValue(i) );
		}
		
		Log.d( TAG, "Datos de la Pared ===>" );
		Log.d( TAG, puerta.toString() );
		
		m_Edificio.addPuerta( puerta );
		
		return true;
	} // end readPuerta
	
} // XmlResourceEdificio
