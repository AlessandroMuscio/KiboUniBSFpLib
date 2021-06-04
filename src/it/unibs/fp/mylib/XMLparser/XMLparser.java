package it.unibs.fp.mylib.XMLparser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XMLparser {
  private XMLStreamReader reader;

  public XMLparser(String file_input_path) throws FileNotFoundException, XMLStreamException, FactoryConfigurationError {
    reader = (XMLInputFactory.newInstance()).createXMLStreamReader(file_input_path,
        new FileInputStream(file_input_path));
  }

  public <T> ArrayList<T> leggiXML(Class<T> aClass) throws XMLStreamException {
    ArrayList<T> objects = new ArrayList<>();
    try {
      T object = aClass.getDeclaredConstructor().newInstance();
    } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
        | NoSuchMethodException | SecurityException e) {
      e.printStackTrace();
    }

    while (reader.hasNext()) {

      switch (reader.getEventType()) {
        case XMLStreamConstants.START_ELEMENT:

          break;

        default:
          break;
      }

      reader.next();
    }

    return objects;
  }
}
