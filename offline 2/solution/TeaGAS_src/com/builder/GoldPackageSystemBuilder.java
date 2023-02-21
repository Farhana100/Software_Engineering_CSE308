package com.builder;

import com.company.TeaGASSystem;
import com.components.*;

// Arduino with weight module

public class GoldPackageSystemBuilder implements SystemBuilder
{
    private TeaGASSystem teaGASSystem;

    public GoldPackageSystemBuilder()
    {
        this.teaGASSystem = new TeaGASSystem();
    }

    @Override
    public void buildMicrocontroller()
    {
        teaGASSystem.setMicrocontroller(new ArduinoMega());
    }

    @Override
    public void buildWeightMeasurement()
    {
        teaGASSystem.setWeightMeasurement(new WeightModule());
    }

    @Override
    public void buildId()
    {
        teaGASSystem.setId(new CardRFID());
    }

    @Override
    public void buildStorage()
    {
        teaGASSystem.setStorage(new SDcard());
    }

    @Override
    public void buildDisplay()
    {
        teaGASSystem.setDisplay(new LEDdisplay());
    }

    @Override
    public void buildController()
    {
        teaGASSystem.setController(new Button());
    }

    @Override
    public void buildInternetConnection(int internetConnectionOP)
    {
        switch (internetConnectionOP)
        {
            case 1 -> this.teaGASSystem.setInternetConnection(new WiFiModule());
            case 2 -> this.teaGASSystem.setInternetConnection(new GSMModule());
            default -> throw new IllegalStateException("Unexpected value: " + internetConnectionOP);
        }
    }


    @Override
    public String getInternetConnectionOptions()
    {
        return "1. WiFi\n" +
                "2. SIM card";
    }

    @Override
    public TeaGASSystem getSystem()
    {
        return teaGASSystem;
    }
}
