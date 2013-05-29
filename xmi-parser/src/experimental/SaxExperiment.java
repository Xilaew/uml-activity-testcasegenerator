package experimental;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxExperiment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler() {

				boolean inActivity = false;

				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {
					String s;
					if ((attributes != null
							&& (s = attributes.getValue("xmi:type")) != null && s
								.equals("uml:Activity")) || inActivity == true) {
						System.out.println("Start Element :" + qName);
						inActivity = true;
					}

				}

				public void endElement(String uri, String localName,
						String qName) throws SAXException {
					if (inActivity == true) {
						System.out.println("End Element :" + qName);
					}

				}

				public void characters(char ch[], int start, int length)
						throws SAXException {

				}

			};

			saxParser.parse("./someActivitys.xmi", handler);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
