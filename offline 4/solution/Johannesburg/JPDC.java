package com.company;

public class JPDC implements PublicServiceOrg
{
    // POWER

    private Mediator mediator;

    public JPDC(Mediator mediator){
        this.mediator = mediator;
    }

    @Override
    public void Serve()
    {
        mediator.Serve(this);
    }

    @Override
    public void AskForService(String service)
    {
        mediator.requestService(this, service);
    }

    @Override
    public String toString()
    {
        return "JPDC";
    }
}
