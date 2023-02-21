package com.webserver;

public class WebServerSpring implements WebServer
{
    @Override
    public void runServer()
    {
        System.out.println("Spring web server running.");
    }

    @Override
    public String toString()
    {
        return "Web Server Spring";
    }
}
