package com.springmvc.event;

import org.springframework.context.ApplicationEvent;

public class CustomTriggerEvent extends ApplicationEvent {
    String id;
    String eName;


    public CustomTriggerEvent(Object source, String id, String eName) {
        super(source);
        this.id = id;
        this.eName = eName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }
}
