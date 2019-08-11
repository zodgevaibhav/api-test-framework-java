package com.openvz.api_test.request_manupulations;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

public  class XMLRequestManupulation implements IRequestManupulation {

	public String getNodeValue(String xmlRequest, String xPath) {
		Document document = getDocument(xmlRequest);
		
		Node node = document.selectSingleNode(xPath);
		assertFalse(null==node,"Node element is null, check xpath and request");
		document =null;
		return node.getText();
	}

	public String updateNodeValue(String xmlRequest, String xPath, String valueToUpdate) {
		Document document = getDocument(xmlRequest);
		
		Node node = document.selectSingleNode(xPath);
		node.setText(valueToUpdate);
		
		return document.asXML();
	}

	public String formatRequest(String request) {
		
		        try{
		            Transformer serializer= SAXTransformerFactory.newInstance().newTransformer();
		            serializer.setOutputProperty(OutputKeys.INDENT, "yes");
		            serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		            Source xmlSource=new SAXSource(new InputSource(new ByteArrayInputStream(request.getBytes())));
		            StreamResult res =  new StreamResult(new ByteArrayOutputStream());            
		            serializer.transform(xmlSource, res);
		            return new String(((ByteArrayOutputStream)res.getOutputStream()).toByteArray());
		        }catch(Exception e){
		        	assertTrue(false,"Unable to format XML"+e.getLocalizedMessage());
		            return request;
		        }
	}
	
	private Document getDocument(String request)
	{
		Document doc = null;
		SAXReader reader = new SAXReader();
		try {
		doc = reader.read(new InputSource(new StringReader(request)));
		}catch(Exception e) {
			e.printStackTrace();
		}
		assertTrue(null!=doc, "Provided XML is not proper XML file, please check and correct");
		return doc ;
	}

}
