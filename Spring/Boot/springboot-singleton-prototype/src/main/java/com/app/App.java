package com.app;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {

    @Bean
    public Singleton getSingleton()
    {
        return new Singleton();
    }

    @Bean
    @Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode=ScopedProxyMode.TARGET_CLASS)
    public PrototypeEx getPrototypeEx()
    {
        return new PrototypeEx();
    }

    @Bean
    @Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Introspect getIntrospect(){
        Introspect i  = new Introspect();
        i.setSingleton(getSingleton());
        i.setPrototypeEx(getPrototypeEx());
        return i;
    	//return new Introspect();
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
