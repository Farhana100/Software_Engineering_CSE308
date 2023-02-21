package com.webserver;

public class WebServerFactory
{
    public WebServer getInstance(int framework)
    {
        WebServer webServer;

        switch (framework)
        {
            case 1 -> webServer = new WebServerDjango();
            case 2 -> webServer = new WebServerSpring();
            case 3 -> webServer = new WebServerLaravel();
            default -> throw new IllegalStateException("Unexpected value: " + framework);
        }

        return  webServer;
    }

    public static String getWebDevelopmentOptions()
    {
        return "1. Django\n" +
                "2. Spring\n" +
                "3. Laravel";
    }
}
