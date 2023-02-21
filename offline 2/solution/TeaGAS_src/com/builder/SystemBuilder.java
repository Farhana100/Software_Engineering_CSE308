package com.builder;

import com.company.TeaGASSystem;
import com.webserver.WebServerFactory;

public interface SystemBuilder
{
    void buildMicrocontroller();
    void buildWeightMeasurement();
    void buildId();
    void buildStorage();
    void buildDisplay();
    void buildController();

    String getInternetConnectionOptions();
    void buildInternetConnection(int internetConnectionOP);

    default String getWebDevelopmentOptions(){return WebServerFactory.getWebDevelopmentOptions();};
    default void buildWebServer(int webServerOP)
    {
        WebServerFactory webServerFactory = new WebServerFactory();
        this.getSystem().setWebServer(webServerFactory.getInstance(webServerOP));
    }

    TeaGASSystem getSystem();
}
