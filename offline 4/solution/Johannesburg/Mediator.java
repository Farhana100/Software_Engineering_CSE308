package com.company;

public interface Mediator
{
    void Serve(PublicServiceOrg org);
    void requestService(PublicServiceOrg org, String service);
}
