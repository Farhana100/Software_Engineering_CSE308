package com.company;

public class JTRC implements PublicServiceOrg
{
    // TELECOM

    private Mediator mediator;

    public JTRC(Mediator mediator){
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
        return "JRTC";
    }
}
