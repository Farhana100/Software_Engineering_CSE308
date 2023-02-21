package com.company;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class JCC implements Mediator
{
    private JWSA jwsa; // WATER
    private JRTA jrta; // TRANSPORT
    private JTRC jtrc; // TELECOM
    private JPDC jpdc; // POWER

    private Queue<String> jwsaQ; // WATER
    private Queue<String> jrtaQ; // TRANSPORT
    private Queue<String> jtrcQ; // TELECOM
    private Queue<String> jpdcQ; // POWER

    public JCC(){
        jwsaQ = new LinkedList<String>();
        jrtaQ = new LinkedList<String>();
        jtrcQ = new LinkedList<String>();
        jpdcQ = new LinkedList<String>();
    }

    public void setJrta(JRTA jrta)
    {
        this.jrta = jrta;
    }

    public void setJpdc(JPDC jpdc)
    {
        this.jpdc = jpdc;
    }

    public void setJtrc(JTRC jtrc)
    {
        this.jtrc = jtrc;
    }

    public void setJwsa(JWSA jwsa)
    {
        this.jwsa = jwsa;
    }

    @Override
    public void Serve(PublicServiceOrg org)
    {
        if(org instanceof JWSA){

            // WATER
            if(jwsaQ.isEmpty()){
                System.out.println("Service not required");
                return;
            }

            System.out.println("JWSA serves the request of " + jwsaQ.poll());

        }
        else if(org instanceof JRTA){

            // TRANSPORT
            if(jrtaQ.isEmpty()){
                System.out.println("Service not required");
                return;
            }

            System.out.println("JRTA serves the request of " + jrtaQ.poll());

        }
        else if(org instanceof JTRC){

            // TELECOM
            if(jtrcQ.isEmpty()){
                System.out.println("Service not required");
                return;
            }

            System.out.println("JTRC serves the request of " + jtrcQ.poll());

        }
        else if(org instanceof JPDC){

            // POWER
            if(jpdcQ.isEmpty()){
                System.out.println("Service not required");
                return;
            }

            System.out.println("JPDC serves the request of " + jpdcQ.poll());

        }

    }

    @Override
    public void requestService(PublicServiceOrg org, String service)
    {
        System.out.println(org.toString() + " requests for " + service + " service");

        if(service.equals("WATER")){
            jwsaQ.add(org.toString());
        }
        else if(service.equals("TRANSPORT")){
            jrtaQ.add(org.toString());
        }
        else if(service.equals("TELECOM")){
            jtrcQ.add(org.toString());
        }
        else if(service.equals("POWER")){
            jpdcQ.add(org.toString());
        }
    }
    // the mediator
}
