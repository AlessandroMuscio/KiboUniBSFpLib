package it.unibs.fp.mylib.XMLparser;

public class XMLattribute {
  private String name;
  private String value;

  public XMLattribute(String name, String value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public String getValue() {
    return value;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof XMLattribute) {
      XMLattribute XMLattribute_obj = (XMLattribute) obj;

      return (name.equals(XMLattribute_obj.name) && value.equals(XMLattribute_obj.value));
    }

    return false;
  }

  @Override
  public String toString() {
    return String.format("XMLattribute: [Name: %s, Value: %s]", name, value);
  }
}
