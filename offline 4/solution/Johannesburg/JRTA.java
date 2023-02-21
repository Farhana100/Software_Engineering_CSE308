package com.company;

public class JRTA implements PublicServiceOrg
{
    // TRANSPORT

    private Mediator mediator;

    public JRTA(Mediator mediator){
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
        return "JRTA";
    }
}
