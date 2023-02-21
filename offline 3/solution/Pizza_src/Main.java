package com.company;

import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Order order = new FrenchFries(new BeefPizza());
        System.out.println(order.description() + "\t:\t" + order.getCost());

        order = new OnionRings(new VeggiPizza());
        System.out.println(order.description() + "\t:\t" + order.getCost());

        order  = new FrenchFries(new Coke(new VeggiPizza()));
        System.out.println(order.description() + "\t:\t" + order.getCost());

        order  = new Coffee(new OnionRings(new VeggiPizza()));
        System.out.println(order.description() + "\t:\t" + order.getCost());

        order = new BeefPizza();
        System.out.println(order.description() + "\t:\t" + order.getCost());

        System.out.println();
        System.out.println();


        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            System.out.println("1. Place Order");
            System.out.println("2. Set prices");
            System.out.println("Enter 0 to Exit.");

            int option = scanner.nextInt();
            if(option == 0) break;

            switch (option)
            {
                case 1 -> {
                    System.out.println("Pizza:");
                    System.out.println("\t1. Veggi Pizza");
                    System.out.println("\t2. Beef Pizza");
                    System.out.println();
                    System.out.println("Appetizer:");
                    System.out.println("\t3. French Rry");
                    System.out.println("\t4. Onion Rings");
                    System.out.println();
                    System.out.println("Drinks:");
                    System.out.println("\t5. Coke");
                    System.out.println("\t6. Coffee");
                    System.out.println("\n Enter 0 to Exit");

                    order = null;
                    while(true){
                        int order_op = scanner.nextInt();
                        if(order_op == 0)break;

                        order = switch (order_op)
                                {
                                    case 1 -> new VeggiPizza();
                                    case 2 -> new BeefPizza();
                                    case 3 -> new FrenchFries(order);
                                    case 4 -> new OnionRings(order);
                                    case 5 -> new Coke(order);
                                    case 6 -> new Coffee(order);
                                    default -> order;
                                };
                    }

                    if (order != null)
                    {
                        System.out.println(order.description() + "\t:\t" + order.getCost());
                    }
                }
                case 2 -> {
                    System.out.println("Choose option to set price\n");
                    System.out.println("Pizza:");
                    System.out.println("\t1. Veggi Pizza");
                    System.out.println("\t2. Beef Pizza");
                    System.out.println();
                    System.out.println("Appetizer:");
                    System.out.println("\t3. French Rry");
                    System.out.println("\t4. Onion Rings");
                    System.out.println();
                    System.out.println("Drinks:");
                    System.out.println("\t5. Coke");
                    System.out.println("\t6. Coffee");
                    System.out.println("\n Enter 0 to Exit");

                    int setPrice_op = scanner.nextInt();

                    if(setPrice_op != 0)
                    {
                        System.out.println("Enter price:");
                        int price = scanner.nextInt();

                        switch (setPrice_op)
                        {
                            case 1 -> VeggiPizza.setCost(price);
                            case 2 -> BeefPizza.setCost(price);
                            case 3 -> FrenchFries.setCost(price);
                            case 4 -> OnionRings.setCost(price);
                            case 5 -> Coke.setCost(price);
                            case 6 -> Coffee.setCost(price);
                        };
                    }
                }
                default -> throw new IllegalStateException("Unexpected value: " + option);
            }
        }

    }
}
