package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        JCC jcc = new JCC();
        JWSA jwsa = new JWSA(jcc);
        JRTA jrta = new JRTA(jcc);
        JPDC jpdc = new JPDC(jcc);
        JTRC jtrc = new JTRC(jcc);

        Scanner scanner = new Scanner(System.in);

        while(true){
            String[] cmd = scanner.nextLine().strip().split("\\s+");

            if(cmd[0].equals("Init")){
                // create

                jcc.setJpdc(jpdc);
                jcc.setJrta(jrta);
                jcc.setJtrc(jtrc);
                jcc.setJwsa(jwsa);

                System.out.println("All four services are initiated through mediator");
            }
            else if(cmd[0].equals("JWSA")){
                if(cmd[1].equals("SERVE")){
                    jwsa.Serve();
                }
                else{
                    jwsa.AskForService(cmd[1]);
                }
            }
            else if(cmd[0].equals("JRTA")){
                if(cmd[1].equals("SERVE")){
                    jrta.Serve();
                }
                else{
                    jrta.AskForService(cmd[1]);
                }
            }
            else if(cmd[0].equals("JPDC")){
                if(cmd[1].equals("SERVE")){
                    jpdc.Serve();
                }
                else{
                    jpdc.AskForService(cmd[1]);
                }
            }
            else if(cmd[0].equals("JTRC")){
                if(cmd[1].equals("SERVE")){
                    jtrc.Serve();
                }
                else{
                    jtrc.AskForService(cmd[1]);
                }
            }
            else{
                System.out.println("wrong command");
            }
        }
    }
}
