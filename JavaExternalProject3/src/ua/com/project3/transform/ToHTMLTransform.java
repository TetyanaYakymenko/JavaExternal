package ua.com.project3.transform;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class ToHTMLTransform {
    static String FILE_XML = "src" + File.separator + "ua" + File.separator + "com" + File.separator + "project3" +
            File.separator + "xmlFlower" + File.separator + "greenhouse.xml";
    static String FILE_XSL = "src" + File.separator + "ua" + File.separator + "com" + File.separator + "project3" +
            File.separator + "xmlFlower" + File.separator + "greenhouse.xsl";
    static String FILE_HTML_OUTPUT = "src" + File.separator + "ua" + File.separator + "com" + File.separator + "project3" +
            File.separator + "files" + File.separator + "greenhouse.html";

    public static void main(String[] args) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(FILE_XSL));

            transformer.transform(new StreamSource(FILE_XML),
                    new StreamResult(FILE_HTML_OUTPUT));
            System.out.println("Transform " + FILE_XML + " complete");
        } catch (TransformerException e) {
            System.err.println("Impossible transform file " + FILE_XML + " : " + e);
        }
    }
}
