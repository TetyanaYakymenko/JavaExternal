package ua.com.project3.valid;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.XMLConstants;

import org.xml.sax.SAXException;

public class ValidatorSAX {
	public static String XML_FILE = "src" + File.separator + "ua" + File.separator + "com" + File.separator + "project3"
			+ File.separator + "xmlFlower" + File.separator + "greenhouse.xml";
	public static String XSD_SCHEMA = "src" + File.separator + "ua" + File.separator + "com" + File.separator
			+ "project3" + File.separator + "xmlFlower" + File.separator + "greenhouse.xsd";

	public static void main(String[] args) {
		Schema schema = null;
		String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory factory = SchemaFactory.newInstance(language);
		try {
			schema = factory.newSchema(new File(XSD_SCHEMA));
			Validator validator = schema.newValidator();
			Source source = new StreamSource(XML_FILE);
			validator.validate(source);
			System.out.println(XML_FILE + " is valid.");
		} catch (SAXException e) {
			System.err.print("validation " + XML_FILE + " is not valid because " + e.getMessage());
		} catch (IOException e) {
			System.err.print(XML_FILE + " is not valid because " + e.getMessage());
		}
	}
}
