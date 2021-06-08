package it.unibs.fp.mylib.XMLParser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class XMLParser {
  private XMLStreamReader xmlReader = null;

  public XMLParser(String fileName) {
    try {
      XMLInputFactory xmlFactory = XMLInputFactory.newInstance();
      xmlReader = xmlFactory.createXMLStreamReader(fileName, new FileInputStream(fileName));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public <T extends Parsable> ArrayList<T> parseXML(Class<T> obj) throws XMLStreamException {
    String elementName = null;
    XMLTag XMLTag;
    ArrayList<T> objList = new ArrayList<>();
    T t = null;

    try {
      t = obj.getDeclaredConstructor().newInstance();
    } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
      e.printStackTrace();
    }

    while (xmlReader.hasNext()) {
      assert t != null;

      switch (xmlReader.getEventType()) {
        case XMLStreamConstants.START_ELEMENT:
          elementName = t.containsAttribute(xmlReader.getLocalName()) ? xmlReader.getLocalName() : null;

          for (int i = 0; i < xmlReader.getAttributeCount(); i++) {
            String name = xmlReader.getAttributeLocalName(i);
            String value = xmlReader.getAttributeValue(i);
            XMLTag = elementName != null ? new XMLTag(elementName, new XMLAttribute(name, value))
                : new XMLTag(name, value);
            t.setAttribute(XMLTag);
          }
          break;

        case XMLStreamConstants.END_ELEMENT:
          if (t.getStartString().equals(xmlReader.getLocalName())) {
            objList.add(t);
            try {
              t = obj.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | NoSuchMethodException | InvocationTargetException
                | IllegalAccessException e) {
              e.printStackTrace();
            }
          }
          break;

        case XMLStreamConstants.CHARACTERS:
          if (xmlReader.getText().trim().length() > 0 && elementName != null) {
            XMLTag = new XMLTag(elementName, xmlReader.getText());
            t.setAttribute(XMLTag);
          }
          break;
      }

      xmlReader.next();
    }
    return objList;
  }
}
