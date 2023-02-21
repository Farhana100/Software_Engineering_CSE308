package com.company;

public class JWSA implements PublicServiceOrg
{
    // WATER

    private Mediator mediator;

    public JWSA(Mediator mediator){
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
        return "JWSA";
    }
}
