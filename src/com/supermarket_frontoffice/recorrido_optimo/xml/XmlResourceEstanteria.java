package com.supermarket_frontoffice.recorrido_optimo.xml;

import android.content.res.XmlResourceParser;
import android.util.Log;

import com.supermarket_frontoffice.modelo_datos.Estanteria;
import com.supermarket_frontoffice.modelo_datos.EstanteriaEstante;
import com.supermarket_frontoffice.modelo_datos.EstanteriaSeccion;
import com.supermarket_frontoffice.recorrido_optimo.gl.comun.XmlResourceFile;



/** @class XmlResourceEstanteria
 *  
 *  @brief Lee del Xml todos los datos de una estantería
 * 
 * 
 * @author fjvegaf
 *
 */
public class XmlResourceEstanteria extends XmlResourceFile 
{
		
	
	private static final String 	TAG= "XmlResourceEstanteria";
	
	private Estanteria 				m_Estanteria;
	
	
	/** Constructor
	 * 
	 * @param a_Parser
	 */
	public XmlResourceEstanteria( XmlResourceParser a_Parser )
	{
		
		super( a_Parser );		
		m_Estanteria= null; //new Estanteria( );
		
	} // XmlResourceEstanteria
	
	
		
	/** Lee todos los datos de las estantería
	 * 
	 * @return
	 */
	public boolean read( )
	{
		
		m_Estanteria= new Estanteria( );
		
		Estanteria.TTipoEstanteria tipoEstanteria= Estanteria.TTipoEstanteria.EstanteriaDesconocido;
		
		for ( int i = 0; i < super.m_Parser.getAttributeCount(); i++ ) {
			
			if ( super.m_Parser.getAttributeName(i).equals( "id" ) ) 	  			{ 	m_Estanteria.setId( Short.parseShort( super.m_Parser.getAttributeValue(i).trim() ) );			}
			else if ( super.m_Parser.getAttributeName(i).equals( "x" ) ) 			{	m_Estanteria.setPosicionX( Float.parseFloat( super.m_Parser.getAttributeValue(i).trim() ));	}
			else if ( super.m_Parser.getAttributeName(i).equals( "y" ) ) 			{	m_Estanteria.setPosicionY( Float.parseFloat( super.m_Parser.getAttributeValue(i).trim() )); 			}
			else if ( super.m_Parser.getAttributeName(i).equals( "rotacion_xy" ) ) {	m_Estanteria.setRotacionXY( Float.parseFloat( super.m_Parser.getAttributeValue(i).trim() )); }
			else if ( super.m_Parser.getAttributeName(i).equals( "tipo" ) ) 		{
				
				if ( super.m_Parser.getAttributeValue(i).equals( "doble" ) ) {	tipoEstanteria= Estanteria.TTipoEstanteria.EstanteriaDoble;		}
				else {													tipoEstanteria= Estanteria.TTipoEstanteria.EstanteriaSimple;	}
				
				m_Estanteria.setTipoEstanteria( tipoEstanteria );
				
			}
			
			//Log.d( TAG, "\t Atributo=> " + super.m_Parser.getAttributeName(i) + " = " + super.m_Parser.getAttributeValue(i) );
		}
		
	
		try {
			
			int event= super.m_Parser.next();
			
			while ( event != XmlResourceParser.END_DOCUMENT ) {
				
				   if ( event == XmlResourceParser.START_TAG ) {
			      
					   if ( super.m_Parser.getName().trim().equals( "seccion" ) ) {
						   
						   //Log.d( TAG, "<" + super.m_Parser.getName() + ">" );						   
						   EstanteriaSeccion seccion= new EstanteriaSeccion();
						   this.readSeccion( seccion );						   
						   m_Estanteria.addEstanteSeccion( seccion );
					   }
					   
//						Log.d( TAG, "<" + super.m_Parser.getName() + ">" );
//						for ( int i = 0; i < super.m_Parser.getAttributeCount(); i++ ) {
//							  
//							Log.d( TAG, "\t" + super.m_Parser.getAttributeName(i) + " = " + super.m_Parser.getAttributeValue(i) );
//						}
				   }
				 
//				   if ( event == XmlResourceParser.TEXT && 
//						super.m_Parser.getText().trim().length() != 0 ) {
//				      
//					   Log.d( TAG, "\t\t" + super.m_Parser.getText() );
//				   }
//				 
				   if ( event == XmlResourceParser.END_TAG ) {
				     
					   	if ( super.m_Parser.getName().trim().equals( "estanteria" ) ) {
						   
						   //Log.d( TAG, "<" + super.m_Parser.getName() + "> END ESTANTERIA" );		   
//							Log.d( TAG, "Mostrando datos de estantería ..." );
//							Log.d( TAG, m_Estanteria.toString() );
						   return true;
						   //this.readEstanteria();
					   }
				   }
				  
				   event = super.m_Parser.next();
			} // end While
		
		}
		catch ( Exception e ) {
			
			Log.e( TAG, "Error al intentar abrir el recurso " + m_ResourceFile + " Excepcion: " + e.getMessage() );
			return false;
		}

		
		//<estanteria id="1" x="50" y="0" rotacion_xy="0" tipo="simple"  modelo="" 
		
		

		
		
		return true;
		
	} // readEstanteria
	
	
	
	/** Lee las secciones de la estantería
	 * 
	 * @return
	 */
	public boolean readSeccion( EstanteriaSeccion ar_Seccion )
	{

		
		for ( int i = 0; i < super.m_Parser.getAttributeCount(); i++ ) {
			
			if ( super.m_Parser.getAttributeName(i).equals( "id" ) ) 	  	{ 	ar_Seccion.setId( Short.parseShort( super.m_Parser.getAttributeValue(i).trim() ) );			}
			else if ( super.m_Parser.getAttributeName(i).equals( "alto" )) 	{	ar_Seccion.setAlto( Float.parseFloat( super.m_Parser.getAttributeValue(i).trim() ));	}
			else if ( super.m_Parser.getAttributeName(i).equals( "ancho" )) {	ar_Seccion.setAnchoBase( Float.parseFloat( super.m_Parser.getAttributeValue(i).trim() )); 			}
			else if ( super.m_Parser.getAttributeName(i).equals( "largo" )) {	ar_Seccion.setLargo( Float.parseFloat( super.m_Parser.getAttributeValue(i).trim() )); }

			//Log.d( TAG, "\t Atributo=> " + super.m_Parser.getAttributeName(i) + " = " + super.m_Parser.getAttributeValue(i) );
		}
		
//		Log.d( TAG, "Mostrando datos de estantería ..." );
//		Log.d( TAG, seccion.toString() );

		try {
			
			int event= super.m_Parser.next();
			
			while ( event != XmlResourceParser.END_DOCUMENT ) {
				
				   if ( event == XmlResourceParser.START_TAG ) {
			      
					   if ( super.m_Parser.getName().trim().equals( "estante" ) ) {
						   
						   //Log.d( TAG, "<" + super.m_Parser.getName() + ">" );						   
						   EstanteriaEstante estante= new EstanteriaEstante();
						   
						   this.readEstante( estante );
						   
						   ar_Seccion.addEstanteriaEstante( estante );
						   
					   }
					   
//						Log.d( TAG, "<" + super.m_Parser.getName() + ">" );
//						for ( int i = 0; i < super.m_Parser.getAttributeCount(); i++ ) {
//							  
//							Log.d( TAG, "\t" + super.m_Parser.getAttributeName(i) + " = " + super.m_Parser.getAttributeValue(i) );
//						}
				   }
				 
//				   if ( event == XmlResourceParser.TEXT && 
//						super.m_Parser.getText().trim().length() != 0 ) {
//				      
//					   Log.d( TAG, "\t\t" + super.m_Parser.getText() );
//				   }
//				 
				   if ( event == XmlResourceParser.END_TAG ) {
				     
					   	if ( super.m_Parser.getName().trim().equals( "seccion" ) ) {
						   
						   //Log.d( TAG, "<" + super.m_Parser.getName() + "> END SECCION" );						   
						   return true;
						   //this.readEstanteria();
					   }
				   }
				  
				   event = super.m_Parser.next();
			} // end While
		
		}
		catch ( Exception e ) {
			
			Log.e( TAG, "Error al intentar abrir el recurso " + m_ResourceFile + " Excepcion: " + e.getMessage() );
			return false;
		}

		
		//<estanteria id="1" x="50" y="0" rotacion_xy="0" tipo="simple"  modelo="" 
		
	
		return true;
		
		
	} // end readSeccion

	
	/** Lee los estantes de una sección de la estantería
	 * 
	 * @return
	 */
	public boolean readEstante( EstanteriaEstante ar_Estante )
	{

		
		for ( int i = 0; i < super.m_Parser.getAttributeCount(); i++ ) {
			
			if ( super.m_Parser.getAttributeName(i).equals( "id" ) ) 	  	{ 	ar_Estante.setId( Short.parseShort( super.m_Parser.getAttributeValue(i).trim() ) );			}
			else if ( super.m_Parser.getAttributeName(i).equals( "alto" )) 	{	ar_Estante.setAlto( Float.parseFloat( super.m_Parser.getAttributeValue(i).trim() ));	}
			else if ( super.m_Parser.getAttributeName(i).equals( "ancho" )) {	ar_Estante.setAncho( Float.parseFloat( super.m_Parser.getAttributeValue(i).trim() )); 			}
			else if ( super.m_Parser.getAttributeName(i).equals( "largo" )) {	ar_Estante.setLargo( Float.parseFloat( super.m_Parser.getAttributeValue(i).trim() )); }
		
			//Log.d( TAG, "\t Atributo=> " + super.m_Parser.getAttributeName(i) + " = " + super.m_Parser.getAttributeValue(i) );
		}
		
		
		try {
			
			int event= super.m_Parser.next();
			if ( event == XmlResourceParser.END_TAG ) {
				     
				if ( super.m_Parser.getName().trim().equals( "estante" ) ) {
				   
					//Log.d( TAG, "<" + super.m_Parser.getName() + "> END ESTANTE" );   
					return true;
				   //this.readEstanteria();
				}
			}
		
		}
		catch ( Exception e ) {
			
			Log.e( TAG, "Error al intentar abrir el recurso " + m_ResourceFile + " Excepcion: " + e.getMessage() );
			return false;
		}
		
//		Log.d( TAG, "Mostrando datos de estantería ..." );
//		Log.d( TAG, seccion.toString() );
//
//		try {
//			
//			int event= super.m_Parser.next();
//			while ( event != XmlResourceParser.END_DOCUMENT ) {
//				
////				   if ( event == XmlResourceParser.START_TAG ) {
////			      
////					   if ( super.m_Parser.getName().trim().equals( "estante" ) ) {
////						   
////						   Log.d( TAG, "<" + super.m_Parser.getName() + ">" );
////						   
////						   //this.readEstanteria();
////					   }
////					   
//////						Log.d( TAG, "<" + super.m_Parser.getName() + ">" );
//////						for ( int i = 0; i < super.m_Parser.getAttributeCount(); i++ ) {
//////							  
//////							Log.d( TAG, "\t" + super.m_Parser.getAttributeName(i) + " = " + super.m_Parser.getAttributeValue(i) );
//////						}
////				   }
//				 
////				   if ( event == XmlResourceParser.TEXT && 
////						super.m_Parser.getText().trim().length() != 0 ) {
////				      
////					   Log.d( TAG, "\t\t" + super.m_Parser.getText() );
////				   }
////				 
//				   if ( event == XmlResourceParser.END_TAG ) {
//				     
//					   	if ( super.m_Parser.getName().trim().equals( "estante" ) ) {
//						   
//						   Log.d( TAG, "<" + super.m_Parser.getName() + "> END SECCION" );
//						   
//						   return true;
//						   //this.readEstanteria();
//					   }
//				   }
//				  
//				   event = super.m_Parser.next();
//			} // end While
//		
//		}
//		catch ( Exception e ) {
//			
//			Log.e( TAG, "Error al intentar abrir el fichero " + m_ResourceFile + " Excepcion: " + e.getMessage() );
//			return false;
//		}

		
		//<estanteria id="1" x="50" y="0" rotacion_xy="0" tipo="simple"  modelo="" 
		
	
		return true;
		
		
	} // end readSeccion
	
	
	/** Devuelve el objeto de estantería
	 * 
	 * @return
	 */
	Estanteria getEstanteria( )
	{
		return m_Estanteria;
	} // getEstanteria
	
	
} // XmlResourceEstanteria
