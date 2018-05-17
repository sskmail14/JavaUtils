package com.app;

public class Introspect
{

    private PrototypeEx prototype;

    private Singleton singleton;
    

    public void setSingleton(Singleton singleton)
    {
        this.singleton = singleton;
    }

    public Singleton getSingleton()
    {
        return singleton;
    }

    public void setPrototypeEx(PrototypeEx prototype)
    {
        this.prototype = prototype;
    }

    public PrototypeEx getPrototypeEx()
    {
        return prototype;
    }
}