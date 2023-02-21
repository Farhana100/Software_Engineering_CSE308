package com.builder;

// Raspberry Pi with load sensor


import com.company.TeaGASSystem;
import com.components.*;

public class DiamondPackageSystemBuilder implements SystemBuilder
{
    private TeaGASSystem teaGASSystem;

    public DiamondPackageSystemBuilder()
    {
        this.teaGASSystem = new TeaGASSystem();
    }

    @Override
    public void buildMicrocontroller()
    {
        if (teaGASSystem.getStorage() == null)
        {
            RaspberryPi raspberryPi = new RaspberryPi();
            teaGASSystem.setMicrocontroller(raspberryPi);
            teaGASSystem.setStorage(raspberryPi);
        }
    }

    @Override
    public void buildWeightMeasurement()
    {
        teaGASSystem.setWeightMeasurement(new LoadSensor());
    }

    @Override
    public void buildId()
    {
        teaGASSystem.setId(new CardNFC());
    }

    @Override
    public void buildStorage()
    {
        this.buildMicrocontroller();
    }

    @Override
    public void buildDisplay()
    {
        if (teaGASSystem.getController() == null)
        {
            TouchScreen touchScreen = new TouchScreen();
            teaGASSystem.setController(touchScreen);
            teaGASSystem.setDisplay(touchScreen);
        }
    }

    @Override
    public void buildController()
    {
        this.buildDisplay();
    }

    @Override
    public void buildInternetConnection(int internetConnectionOP)
    {
        switch (internetConnectionOP)
        {
            case 1 -> this.teaGASSystem.setInternetConnection(new WiFiModule());
            case 2 -> this.teaGASSystem.setInternetConnection(new GSMModule());
            case 3 -> this.teaGASSystem.setInternetConnection(new Ethernet());
            default -> throw new IllegalStateException("Unexpected value: " + internetConnectionOP);
        }
    }

    @Override
    public String getInternetConnectionOptions()
    {
        return "1. WiFi\n" +
                "2. SIM card\n" +
                "3. Ethernet";
    }

    @Override
    public TeaGASSystem getSystem()
    {
        return teaGASSystem;
    }
}
