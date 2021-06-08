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
}
