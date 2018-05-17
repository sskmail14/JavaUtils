package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Service
{

    @Autowired
    private Introspect introspect;

    public String getInfo()
    {
        return "Prototype :: "+introspect.getPrototypeEx().toString()+"Singleton ::"+introspect.getSingleton().toString()+"<br>"+"Prototype :: "+introspect.getPrototypeEx().toString()+"Singleton ::"+introspect.getSingleton().toString();
    }
}