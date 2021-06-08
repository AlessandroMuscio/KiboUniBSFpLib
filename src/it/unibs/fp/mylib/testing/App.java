package it.unibs.fp.mylib.testing;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.xml.stream.XMLStreamException;

import it.unibs.fp.mylib.XMLParser.XMLParser;

public class App {
  public static void main(String[] args) throws XMLStreamException {
    XMLParser parser = new XMLParser("D:/AllWorks/Projects/MyUniBSFpLib/src/it/unibs/fp/mylib/testing/PgAr_Map_5.xml");

    ArrayList<City> cities = parser.parseXML(City.class);

    for (City city : cities)
      System.out.println(city);
  }
}
