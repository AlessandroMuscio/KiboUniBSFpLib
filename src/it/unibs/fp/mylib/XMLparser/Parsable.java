package it.unibs.fp.mylib.XMLParser;

import java.util.HashMap;
import java.util.function.Consumer;

public interface Parsable {
  HashMap<String, Consumer<String>> setters = new HashMap<>();

  default void setAttribute(XMLTag xmlTag) {
    setSetters();
    Consumer<String> method = setters.get(xmlTag.getTagName());
    if (method != null)
      method.accept(xmlTag.getTagValue());
    XMLAttribute[] attributes = xmlTag.getAttributes();
    if (attributes != null) {
      for (XMLAttribute a : attributes) {
        method = setters.get(a.getName());
        if (method != null)
          method.accept(a.getValue());
      }
    }
  }

  default boolean containsAttribute(String tag) {
    return setters.get(tag) != null;
  }

  void setSetters();

  String getStartString();
}
