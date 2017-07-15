package com.github.dolphin.client.event;

import java.util.EventObject;

/**
 * @author ste7en.liu@gmail.com
 * @version 1.0.0
 * @since 2017/7/9
 */
public class ConfigurationEvent extends EventObject {

    private EventType type;
    private String propertyName;
    private Object propertyValue;

    public ConfigurationEvent(Object source, EventType type, String propertyName, Object propertyValue) {
        super(source);
        this.type = type;
        this.propertyName = propertyName;
        this.propertyValue = propertyValue;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Object getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(Object propertyValue) {
        this.propertyValue = propertyValue;
    }
}
