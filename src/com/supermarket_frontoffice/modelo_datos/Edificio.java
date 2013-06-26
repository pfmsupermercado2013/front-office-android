package com.supermarket_frontoffice.modelo_datos;

import java.util.ArrayList;
import java.util.Iterator;


import android.util.Log;



/** @class Edificio
 * 
 * @author fjvegaf
 *
 */
public class Edificio 
{

	private static final String TAG= "Edificio";
	
	//! Lista de los vertices de cada esquina de las paredes
	ArrayList< EsquinaEdificio > 	m_ListaEsquinas; 
	ArrayList< ParedEdificio > 		m_ListaParedes; 
	ArrayList< PuertaEdificio > 	m_ListaPuertas; 
	
	/** Constructor por defecto
	 *
	 */
	public Edificio( )
	{		

		this( new ArrayList< EsquinaEdificio >( ), new ArrayList< ParedEdificio >( ), new ArrayList< PuertaEdificio >( ) );
		
	} // EdificioSupermercado

	
	/** Constructor
	 * 
	 * @param a_ListaEsquinas Lista de esquinas de edificio
	 */
	public Edificio( 	ArrayList< EsquinaEdificio > 	a_ListaEsquinas,
						ArrayList< ParedEdificio > 		a_ListaParedes,
						ArrayList< PuertaEdificio > 	a_ListaPuertas )
	{		
		
		m_ListaEsquinas= a_ListaEsquinas;
		m_ListaParedes= a_ListaParedes; 
		m_ListaPuertas= a_ListaPuertas; 
		
	} // EdificioSupermercado
	
	
	/** Comprueba que las esquinas especificadas en las paredes existen en el sistema
	 * 
	 *  Las esquinas tienen que estar ordenadas según su creación.
	 *  
	 * @return
	 */
	public boolean comprobarParedes( ) 
	{
		
		
		if ( m_ListaEsquinas.size() < 2 ) {
			
			Log.e( TAG, "No se ha especificado ninguna esquina del edificio" );
			return false;
		}
		
		if ( m_ListaParedes.size() < 2 ) {
			
			Log.e( TAG, "No se ha especificado ninguna pared del edificio" );
			return false;
		}
		
		for ( ParedEdificio pared: m_ListaParedes ) {
			
			if ( !m_ListaEsquinas.contains( pared.getV1() ) || !m_ListaEsquinas.contains( pared.getV2() ) ) {
				
				return false;
			}
		}
		
		return true;
		
	} // comprobarParedes
	
	
	/** Crea las paredes del edificio a partir de las esquinas.
	 * 
	 *  Las esquinas tienen que estar ordenadas según su creación.
	 *  
	 * @return
	 */
	public boolean crearParedes( ArrayList< EsquinaEdificio > a_ListaEsquinas ) 
	{
		
		
		if ( a_ListaEsquinas.size() < 2 ) {
			
			Log.e( "Edificio", "No se ha especificado ninguna esquina del edificio" );
			return false;
		}
		
		Iterator< EsquinaEdificio > iter= a_ListaEsquinas.iterator();
		
		EsquinaEdificio esquinaA= iter.next();
		EsquinaEdificio esquinaB= null;
		EsquinaEdificio esquinaInicial= esquinaA;
		
		short currentIdPared= 1;
		while ( iter.hasNext() ) {
			
			esquinaB= iter.next();
			m_ListaParedes.add( new ParedEdificio( currentIdPared++, esquinaA, esquinaB ) );
			
			esquinaA= esquinaB;
		}
		
		m_ListaParedes.add( new ParedEdificio( currentIdPared, esquinaB, esquinaInicial ) );
		
		
		return true;
		
	} // crearParedes
	
	
	
	/**
	 * @return the m_ListaEsquinas
	 */
	public EsquinaEdificio findEsquina( short a_EsquinaId  ) 
	{
		
		for ( EsquinaEdificio esquina: m_ListaEsquinas ) {
			
			if ( esquina.getId() == a_EsquinaId ) {
				
				return esquina;
				
//				Log.d( TAG, "id_esquina=> Esquina =>" + ar_Esquina.toString() + "\n" );
//				return true;
			}
		}
		
		return null;
	} // end findEsquina
	
	
	/**
	 * @return the m_ListaEsquinas
	 */
	public ParedEdificio findPared( short a_ParedId  ) 
	{
		
		for ( ParedEdificio pared: m_ListaParedes ) {
			
			if ( pared.getId() == a_ParedId ) {
				
				return pared;
				
//				Log.d( TAG, "id_esquina=> Esquina =>" + ar_Esquina.toString() + "\n" );
//				return true;
			}
		}
		
		return null;
	} // end findEsquina
	
	/**
	 * @return the m_ListaEsquinas
	 */
	public ArrayList<EsquinaEdificio> getListaEsquinas( ) 
	{
		return m_ListaEsquinas;
	}


	/**
	 * @param m_ListaEsquinas the m_ListaEsquinas to set
	 */
	public void setListaEsquinas( ArrayList<EsquinaEdificio> a_ListaEsquinas ) 
	{
		this.m_ListaEsquinas= a_ListaEsquinas;
	}

	
	/**
	 * @param m_ListaEsquinas the m_ListaEsquinas to set
	 */
	public void addEsquina( EsquinaEdificio a_Esquina ) 
	{
		this.m_ListaEsquinas.add( a_Esquina );
	}
	

	/**
	 * @return the m_ListaParedes
	 */
	public ArrayList<ParedEdificio> getListaParedes( ) 
	{
		return m_ListaParedes;
	}


	/**
	 * @param m_ListaParedes the m_ListaParedes to set
	 */
	public void setListaParedes( ArrayList<ParedEdificio> a_ListaParedes ) 
	{
		this.m_ListaParedes= a_ListaParedes;
	}
	
	
	/**
	 * @param m_ListaParedes the m_ListaParedes to set
	 */
	public void addPared( ParedEdificio a_Pared ) 
	{
		this.m_ListaParedes.add( a_Pared );
	}
	
	
	
	/**
	 * @return the m_ListaParedes
	 */
	public ArrayList<PuertaEdificio> getListaPuertas( ) 
	{
		return m_ListaPuertas;
	}


	/**
	 * @param m_ListaParedes the m_ListaParedes to set
	 */
	public void setListaPuertas( ArrayList<PuertaEdificio> a_ListaPuertas ) 
	{
		this.m_ListaPuertas= a_ListaPuertas;
	}
	
	
	/**
	 * @param m_ListaParedes the m_ListaParedes to set
	 */
	public void addPuerta( PuertaEdificio a_Puerta ) 
	{
		this.m_ListaPuertas.add( a_Puerta );
	}


	/** Devuelve un String con toda la información de la clase
	 * 
	 */
	public String toString( )
	{
		
		
		String strOut= new String( "[[Edificio]]" );
		
		if ( !m_ListaEsquinas.isEmpty() ) {
			
			for ( EsquinaEdificio esquina: m_ListaEsquinas ) {
				
				strOut += "\t" + esquina.toString() + "\n";
			}
		}
		
		if ( !m_ListaParedes.isEmpty() ) {
			
			for ( ParedEdificio pared: m_ListaParedes ) {
				
				strOut += "\t" + pared.toString() + "\n";
			}
		}
		
		
		if ( !m_ListaPuertas.isEmpty() ) {
			
			for ( PuertaEdificio puerta: m_ListaPuertas ) {
				
				strOut += "\t" + puerta.toString() + "\n";
			}
		}
		
		return strOut;
	
	} // toString
	
	
} // EdificioSupermercado
