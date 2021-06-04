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

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof XMLtag) {
      XMLtag XMLtag_obj = (XMLtag) obj;

      if (name.equals(XMLtag_obj.name)) {
        if (attributes.length == XMLtag_obj.attributes.length) {
          for (int i = 0; i < attributes.length; i++) {
            if (!attributes[i].equals(XMLtag_obj.attributes[i]))
              return false;
          }

          return true;
        }
      }
    }

    return false;
  }
}
