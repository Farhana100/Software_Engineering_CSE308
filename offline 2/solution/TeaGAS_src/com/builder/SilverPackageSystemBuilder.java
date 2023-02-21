package com.builder;

// ATMega32 with load sensor

import com.company.TeaGASSystem;
import com.components.*;

public class SilverPackageSystemBuilder implements SystemBuilder
{
    private TeaGASSystem teaGASSystem;

    public SilverPackageSystemBuilder()
    {
        this.teaGASSystem = new TeaGASSystem();
    }

    @Override
    public void buildMicrocontroller()
    {
        teaGASSystem.setMicrocontroller(new ATMega32());
    }

    @Override
    public void buildWeightMeasurement()
    {
        teaGASSystem.setWeightMeasurement(new LoadSensor());
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
        teaGASSystem.setDisplay(new LCDdisplay());
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
