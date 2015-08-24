package com.arseb.escolazo;

import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/*
 * Esta clase obtiene los extractos oficiales de los sorteos de Lotería Nacional.
 * Se obtienen mediante una URL como:
 * http://www.loteria-nacional.gov.ar/Internet/Extractos/Quiniela_XML.php?fechasorteo=23062015&tiposorteo=ves
 * Es necesario crear una cadena que contenga la fecha codificada, el sorteo (primera, matutino, vespertino, nocturno)
 * como así también el tipo de juego: Quiniela, Loto, etcétera. 
 */
// ToDo: ver si las clases URLConnReader y XMLParser se pueden hacer inner classes de ésta.
public class ExtractoLoteriaNacional {
	private Date myDate;
	private Document mydom;
	
	@SuppressWarnings("unused")
	private CharSequence myCodedDate;
	
	// Constantes utilizadas para identificar qué sorteo requerimos para una fecha determinada.
	private final CharSequence PRIMERA = "pri";
	private final CharSequence MATUTINA = "mat";
	private final CharSequence VESPERTINA = "ves";
	private final CharSequence NOCTURNA = "noc";
	private final CharSequence URL_QUINIELANACIONAL = "http://www.loteria-nacional.gov.ar/Internet/Extractos/Quiniela_XML.php";
	private final CharSequence URI_PARAMETER_TIPOSORTEO = "tiposorteo=";
	private final CharSequence URI_PARAMETER_FECHASORTEO = "fechasorteo=";

	public ExtractoLoteriaNacional() {
		// TODO Revisar si hace falta añadir algo al constructor
	}
	
	private void parseXML (InputStream myinput)
			throws ParserConfigurationException, SAXException, IOException
	{
		// ToDo: agregar excepciones no contempladas.
		DocumentBuilderFactory mydombuilderfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder mydombuilder = mydombuilderfactory.newDocumentBuilder();
		mydom = mydombuilder.parse(myinput); 
	}
	
	private InputStream getfile (URL myurl) throws IOException, ConnectException, MalformedURLException {
		// ToDo: agregar excepciones no previstas aun.
        URLConnection myurlconn = myurl.openConnection();
        InputStream mybuffer = myurlconn.getInputStream();
        return mybuffer;
        
	}
	
	public void obtenersorteoQuinielaNacionalTest(){
		CharSequence myuri = URL_QUINIELANACIONAL + "?" + URI_PARAMETER_FECHASORTEO + "20150823" + "&" + URI_PARAMETER_TIPOSORTEO + NOCTURNA;
		System.out.print(myuri);
	}

	public Date getMyDate() {
		return myDate;
	}

	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}

}
