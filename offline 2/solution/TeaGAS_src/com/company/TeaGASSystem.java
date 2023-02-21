package com.company;

import com.components.*;
import com.webserver.WebServer;

public class TeaGASSystem implements SystemPlan
{
    private MicroController microController;
    private WeightMeasurement weightMeasurement;
    private Id id;
    private Storage storage;
    private Display display;
    private InternetConnection internetConnection;
    private Controller controller;
    private WebServer webServer;

    @Override
    public void setMicrocontroller(MicroController microcontroller)
    {
        this.microController = microcontroller;
    }

    @Override
    public void setWeightMeasurement(WeightMeasurement weightMeasurement)
    {
        this.weightMeasurement = weightMeasurement;
    }

    @Override
    public void setId(Id id)
    {
        this.id = id;
    }

    @Override
    public void setStorage(Storage storage)
    {
        this.storage = storage;
    }

    @Override
    public void setDisplay(Display display)
    {
        this.display = display;
    }

    @Override
    public void setInternetConnection(InternetConnection internetConnection)
    {
        this.internetConnection = internetConnection;
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    @Override
    public void setWebServer(WebServer webServer)
    {
        this.webServer = webServer;
    }

    public MicroController getMicroController()
    {
        return microController;
    }

    public Storage getStorage()
    {
        return storage;
    }

    public Display getDisplay()
    {
        return display;
    }

    public Controller getController()
    {
        return controller;
    }

    public void runMicroController()
    {
        this.microController.runMiController();
    }

    public void measureWeight()
    {
        this.weightMeasurement.measureWeight();
    }

    public void scanId(Id id)
    {

        this.id.scanId();
    }

    public void setStorage()
    {

        this.storage.store();
    }

    public void runDisplay()
    {
        this.display.runDisplay();
    }

    public void connectToInternet()
    {
        this.internetConnection.connectToInternet();
    }

    public void runController()
    {
        this.controller.runController();
    }

    public void runServer()
    {
        this.webServer.runServer();
    }

    @Override
    public String toString()
    {
        return "<<---------Tea Garden Automation System---------->>\n\n" +
                "Microcontroller/Microprocessor:\t" + microController.toString() + "\n" +
                "Weight Measurement:\t" + weightMeasurement.toString() + "\n" +
                "Identification:\t" + id.toString() + "\n" +
                "Storage:\t" + storage.toString() + "\n" +
                "Display:\t" + display.toString() + "\n" +
                "Internet connection:\t" + internetConnection.toString() + "\n" +
                "Controller:\t" + controller.toString() + "\n" +
                "Web Server framework:\t" + webServer.toString() + "\n\n";
    }

}
