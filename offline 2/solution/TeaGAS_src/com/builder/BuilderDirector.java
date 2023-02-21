package com.builder;

import com.company.TeaGASSystem;

public class BuilderDirector
{
    private SystemBuilder systemBuilder;
    private int internetOption;
    private int frameworkOption;

    public BuilderDirector(SystemBuilder systemBuilder, int internetOption, int frameworkOption)
    {
        this.systemBuilder = systemBuilder;
        this.internetOption = internetOption;
        this.frameworkOption = frameworkOption;
    }

    public TeaGASSystem getSystem()
    {
        return this.systemBuilder.getSystem();
    }

    public void constructSystem()
    {
        this.systemBuilder.buildMicrocontroller();
        this.systemBuilder.buildWeightMeasurement();
        this.systemBuilder.buildId();
        this.systemBuilder.buildStorage();
        this.systemBuilder.buildDisplay();
        this.systemBuilder.buildController();
        this.systemBuilder.buildInternetConnection(this.internetOption);
        this.systemBuilder.buildWebServer(this.frameworkOption);
    }
}
