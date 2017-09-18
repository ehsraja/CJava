package com.sam.jaxp;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomEg {

	
	 public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		 
			//Build Document
			
			ClassLoader classLoader = ParseKnownXMLStructure.class.getClassLoader();
			File file = new File(classLoader.getResource("employees.xml").getFile());
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
			
			System.out.println("root : " + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("employee");

			System.out.println("----------------------------");
			for(int i = 0 ; i <nList.getLength() ; i++ ){
				Node staff = nList.item(i);
				if(staff.getNodeType() == Node.ELEMENT_NODE){
					 Element eElement = (Element) staff;
					 NamedNodeMap nodeMap=  staff.getAttributes();
					 for(int j =0 ; j< nodeMap.getLength();j++){
						Node child =  nodeMap.item(j);
						System.out.println(" NodeName " + child.getNodeName() + "Node value" + child.getNodeValue());
					 }
					 System.out.println("First Name : "  + eElement.getElementsByTagName("firstName").item(0).getTextContent());
				}
			}	}
}
