package it.unibs.fp.mylib.XMLparser;

public class XMLtag {
  private String name;
  private XMLattribute[] attributes;

  public XMLtag(String name, XMLattribute... attributes) {
    this.name = name;
    this.attributes = attributes;
  }

  public XMLtag(String name) {
    this(name, new XMLattribute[0]);
  }

  public String getName() {
    return name;
  }

  public XMLattribute[] getAttributes() {
    return attributes;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAttributes(XMLattribute[] attributes) {
    this.attributes = attributes;
  }

  public XMLattribute searchAttributeByName(String attribute_name) {
    for (XMLattribute attribute : attributes) {
      if (name.equals(attribute_name))
        return attribute;
    }

    return null;
  }
}
