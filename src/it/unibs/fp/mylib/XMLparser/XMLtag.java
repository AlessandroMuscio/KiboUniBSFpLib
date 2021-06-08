package it.unibs.fp.mylib.XMLParser;

import java.util.Arrays;

public class XMLTag {
  private String tagName;
  private String tagValue;
  private XMLAttribute[] attributes;

  public XMLTag(String tagName, String tagValue, XMLAttribute... attributes) {
    this.tagName = tagName;
    this.tagValue = tagValue;
    this.attributes = attributes;
  }

  public XMLTag(String tagName, XMLAttribute... attributes) {
    this(tagName, null, attributes);
  }

  public XMLTag(String tagName, String tagValue) {
    this(tagName, tagValue, new XMLAttribute[0]);
  }

  public XMLTag(String tagName) {
    this(tagName, (String) null);
  }

  public String getTagName() {
    return tagName;
  }

  public void setTagName(String tagName) {
    this.tagName = tagName;
  }

  public String getTagValue() {
    return tagValue;
  }

  public void setTagValue(String tagValue) {
    this.tagValue = tagValue;
  }

  public XMLAttribute[] getAttributes() {
    return attributes;
  }

  @Override
  public String toString() {
    return "XMLTag{" + "tagName='" + tagName + '\'' + ", tagValue='" + tagValue + '\'' + ", attributes="
        + Arrays.toString(attributes) + '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof XMLTag) {
      XMLTag XMLtag_obj = (XMLTag) obj;

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
