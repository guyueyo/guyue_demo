package com.mySampleApplication.client.model.style;
import com.google.gwt.dom.client.Element;

public class CssStyleChange {
    private String cssName ;
    private String elementId ;

    public CssStyleChange() {
    }

    public CssStyleChange(String cssName, String elementId) {
        this.cssName = cssName;
        this.elementId = elementId;
    }

    public String getCssName() {
        return cssName;
    }

    public void setCssName(String cssName) {
        this.cssName = cssName;
    }

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }
}
