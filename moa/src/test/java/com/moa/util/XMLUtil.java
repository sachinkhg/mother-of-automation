package com.moa.util;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUtil {
	public Document document;
	
	public Document CreateDocument() {
        try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			document = documentBuilder.newDocument();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return document;
	}
	
	public Element CreateRootElement(String root_element_name) {
        Element element = document.createElement(root_element_name);
        document.appendChild(element);
        return element;
        
	}
	public Element CreateChildElement(Element parent_element, String child_element_name) {
        Element child_element = document.createElement(child_element_name);
        parent_element.appendChild(child_element);
        return child_element;
	}
	
	public void CreateChildElement(Element parent_element, String child_element_name, String text_node_to_append) {
     
        Element child_element = document.createElement(child_element_name);
        child_element.appendChild(document.createTextNode(text_node_to_append));
        parent_element.appendChild(child_element);
       
	}
	public Attr setElementAttribute(Element element, String attr_name, String attr_value) {
        Attr attr = document.createAttribute(attr_name);
        attr.setValue(attr_value);
        element.setAttributeNode(attr);
        return attr;
	}
	
	public void CreateXMLFile(String xmlFilePath) {
		try {
	        //transform the DOM Object to an XML File
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        DOMSource domSource = new DOMSource(document);
	        StreamResult streamResult = new StreamResult(new File(xmlFilePath));
	        transformer.transform(domSource, streamResult);
            System.out.println("Done creating XML File");
	    } catch (TransformerException tfe) {
	        tfe.printStackTrace();
	    }
	}
	
	public void GetElement(String xmlFilePath, String id) {
		try {
		File file = new File(xmlFilePath);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();   
		DocumentBuilder db = dbf.newDocumentBuilder();  
		Document doc = db.parse(file);  
		doc.getDocumentElement().normalize();  
		System.out.println("Root element: " + doc.getElementById("id"));  
		NodeList nList = doc.getElementsByTagName("TestSuite");
		
		for (int temp = 0; temp < nList.getLength(); temp++) {
	        Node nNode = nList.item(temp);
	        System.out.println("\nCurrent Element :" + nNode.getNodeName());
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void CreateXMLFileExample(String xmlFilePath) {
			CreateDocument();
			Element rootElement = CreateRootElement("company");
			Element childElement = CreateChildElement(rootElement, "employee");
			setElementAttribute(childElement, "id", "10");
			CreateChildElement(childElement, "firstName", "James");
			CreateChildElement(childElement, "firstName", "Harley");
			CreateChildElement(childElement, "department", "Human Resources");
			CreateChildElement(childElement, "email", "james@example.org");
			CreateXMLFile(xmlFilePath);
	   }
	}

