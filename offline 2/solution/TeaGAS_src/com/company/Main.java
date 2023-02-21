package com.company;


import com.builder.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a package:");

        System.out.println("1. Silver (ATMega32 with load sensor)");
        System.out.println("2. Gold (Arduino with weight module)");
        System.out.println("3. Diamond (Raspberry Pi with load sensor)");
        System.out.println("4. Platinum (Raspberry Pi with weight module)");

        int choice = scanner.nextInt();
        SystemBuilder systemBuilder;

        switch (choice)
        {
            case 1 -> systemBuilder = new SilverPackageSystemBuilder();
            case 2 -> systemBuilder = new GoldPackageSystemBuilder();
            case 3 -> systemBuilder = new DiamondPackageSystemBuilder();
            case 4 -> systemBuilder = new PlatinumPackageSystemBuilder();
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }

        System.out.println("Choose Internet connection method:");
        System.out.println(systemBuilder.getInternetConnectionOptions());

        int connectionOption = scanner.nextInt();

        System.out.println("Choose a framework for the web server:");
        System.out.println(systemBuilder.getWebDevelopmentOptions());

        int frameworkOption = scanner.nextInt();

        BuilderDirector builderDirector = new BuilderDirector(systemBuilder, connectionOption, frameworkOption);
        builderDirector.constructSystem();

        TeaGASSystem teaGASSystem = builderDirector.getSystem();

        System.out.println(teaGASSystem);

    }
}
