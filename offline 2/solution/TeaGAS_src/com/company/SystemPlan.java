package com.company;

import com.components.*;
import com.webserver.WebServer;

public interface SystemPlan
{
    void setMicrocontroller(MicroController microcontroller);
    void setWeightMeasurement(WeightMeasurement weightMeasurement);
    void setId(Id id);
    void setStorage(Storage storage);
    void setDisplay(Display display);
    void setInternetConnection(InternetConnection internetConnection);
    void setController(Controller controller);
    void setWebServer(WebServer webServer);

    @Override
    String toString();
}
