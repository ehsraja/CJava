package com.sam.xslt;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XsltSam {
	
	 public static void main(String[] args) throws TransformerException {
		    String stylesheetPathname = "src\\main\\resources\\doc.xsl" ;
		    String inputPathname ="src\\main\\resources\\input.xml" ;
		    String outputPathname = "src\\main\\resources\\doc.xml";

		    Writer outputWriter = new StringWriter();
		    Result outputResult = new StreamResult(outputWriter);
		    
		    TransformerFactory factory = TransformerFactory.newInstance();
		    Source stylesheetSource = new StreamSource(new File(stylesheetPathname).getAbsoluteFile());
		    Transformer transformer = factory.newTransformer(stylesheetSource);
		    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		 //   transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		    Source inputSource = new StreamSource(new File(inputPathname).getAbsoluteFile());
		//    Result outputResult = new StreamResult(new File(outputPathname).getAbsoluteFile());
		    transformer.transform(inputSource, outputResult);
		    String outputString = outputWriter.toString();
		    System.out.println(outputString);
		    
		  }

}
