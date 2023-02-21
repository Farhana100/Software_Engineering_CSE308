package com.company;


import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass
{
    ArrayList<Integer> input = new ArrayList<Integer>();
    ArrayList<Integer> output;
    Random random = new Random();

    @BeforeEach
    public void setup() throws Exception {
        // let's see what to do with this
        System.out.println("Starting test");
    }

    @AfterEach
    public void cleanup() throws Exception {
        // let's see what to do with this
        System.out.println("testing ended");
        input.clear();
    }

    @Test
    @DisplayName("Sorting a Null list")
    public void testNull(){
        // check ascending
        output = Sort.sort(null, "ascending");
        assert output == null;

        // check descending
        output = Sort.sort(null, "descending");
        assert output == null;
    }

    @Test
    @DisplayName("Sorting a blank list")
    public void testBlank(){
        // check ascending
        output = Sort.sort(input, "ascending");
        assert checkListNotAltered(input, output) & checkOrder(output, "ascending");

        // check descending
        output = Sort.sort(input, "descending");
        assert checkListNotAltered(input, output) & checkOrder(output, "descending");
    }

    @Test
    @DisplayName("Sorting just one number")
    public void testOne(){
        // all positive
        randGenerate(1, 0, Integer.MAX_VALUE);
        output = Sort.sort(new ArrayList<Integer>(input), "ascending");
        assert checkListNotAltered(input, output) & checkOrder(output, "ascending");

        output = Sort.sort(new ArrayList<Integer>(input), "descending");
        assert checkListNotAltered(input, output) & checkOrder(output, "descending");
        input.clear();

        // all negative
        randGenerate(1, 0, Integer.MAX_VALUE);
        for (int i = 0; i < 1; i++)
        {
            input.set(i, input.get(i) -  Integer.MIN_VALUE);
        }

        output = Sort.sort(new ArrayList<Integer>(input), "ascending");
        assert checkListNotAltered(input, output) & checkOrder(output, "ascending");

        output = Sort.sort(new ArrayList<Integer>(input), "descending");
        assert checkListNotAltered(input, output) & checkOrder(output, "descending");
        input.clear();


        //  zero
        input.add(0);
        output = Sort.sort(new ArrayList<Integer>(input), "ascending");
        assert checkListNotAltered(input, output) & checkOrder(output, "ascending");

        output = Sort.sort(new ArrayList<Integer>(input), "descending");
        assert checkListNotAltered(input, output) & checkOrder(output, "descending");
        input.clear();
    }


    @Test
    @DisplayName("Sorting two numbers")
    public void testTwo(){
        // all positive
        randGenerate(2, 0, Integer.MAX_VALUE);
        output = Sort.sort(new ArrayList<Integer>(input), "ascending");
        assert checkListNotAltered(input, output) & checkOrder(output, "ascending");

        output = Sort.sort(new ArrayList<Integer>(input), "descending");
        assert checkListNotAltered(input, output) & checkOrder(output, "descending");
        input.clear();

        // all negative
        randGenerate(2, 0, Integer.MAX_VALUE);
        for (int i = 0; i < 2; i++)
        {
            input.set(i, input.get(i) -  Integer.MIN_VALUE);
        }

        output = Sort.sort(new ArrayList<Integer>(input), "ascending");
        assert checkListNotAltered(input, output) & checkOrder(output, "ascending");

        output = Sort.sort(new ArrayList<Integer>(input), "descending");
        assert checkListNotAltered(input, output) & checkOrder(output, "descending");
        input.clear();


        // mixed
        randGenerate(2, 0, Integer.MAX_VALUE);
        for (int i = 0; i < 2; i++)
        {
            input.set(i, input.get(i) -  random.nextInt(Integer.MAX_VALUE));
        }

        output = Sort.sort(new ArrayList<Integer>(input), "ascending");
        assert checkListNotAltered(input, output) & checkOrder(output, "ascending");

        output = Sort.sort(new ArrayList<Integer>(input), "descending");
        assert checkListNotAltered(input, output) & checkOrder(output, "descending");
        input.clear();

    }

    @Test
    @DisplayName("The size and numbers of the list are initialized randomly")
    public void testRandomSizeAndNum(){
        // all positive
        randGenerate(random.nextInt(500), 0, Integer.MAX_VALUE);
        output = Sort.sort(new ArrayList<Integer>(input), "ascending");
        assert checkListNotAltered(input, output) & checkOrder(output, "ascending");

        output = Sort.sort(new ArrayList<Integer>(input), "descending");
        assert checkListNotAltered(input, output) & checkOrder(output, "descending");
        input.clear();

        // all negative
        randGenerate(random.nextInt(500), 0, Integer.MAX_VALUE);
        for (int i = 0; i < input.size(); i++)
        {
            input.set(i, input.get(i) -  Integer.MIN_VALUE);
        }

        output = Sort.sort(new ArrayList<Integer>(input), "ascending");
        assert checkListNotAltered(input, output) & checkOrder(output, "ascending");

        output = Sort.sort(new ArrayList<Integer>(input), "descending");
        assert checkListNotAltered(input, output) & checkOrder(output, "descending");
        input.clear();


        // mixed
        randGenerate(random.nextInt(500), 0, Integer.MAX_VALUE);
        for (int i = 0; i < input.size(); i++)
        {
            input.set(i, input.get(i) -  random.nextInt(Integer.MAX_VALUE));
        }

        output = Sort.sort(new ArrayList<Integer>(input), "ascending");
        assert checkListNotAltered(input, output) & checkOrder(output, "ascending");

        output = Sort.sort(new ArrayList<Integer>(input), "descending");
        assert checkListNotAltered(input, output) & checkOrder(output, "descending");
        input.clear();

    }

    @Test
    @DisplayName("The numbers in the is sorted in ascending order")
    public void testSortedAsc(){

        randGenerate(20, 0, Integer.MAX_VALUE, "ascending");

        output = Sort.sort(new ArrayList<Integer>(input), "ascending");
        assert checkListNotAltered(input, output) & checkOrder(output, "ascending");

        output = Sort.sort(new ArrayList<Integer>(input), "descending");
        assert checkListNotAltered(input, output) & checkOrder(output, "descending");
    }

    @Test
    @DisplayName("The numbers in the is sorted in descending order")
    public void testSortedDesc(){

        randGenerate(25, 0, Integer.MAX_VALUE, "descending");

        output = Sort.sort(new ArrayList<Integer>(input), "ascending");
        assert checkListNotAltered(input, output) & checkOrder(output, "ascending");

        output = Sort.sort(new ArrayList<Integer>(input), "descending");
        assert checkListNotAltered(input, output) & checkOrder(output, "descending");
    }

    @Test
    @DisplayName("All the numbers in the list are equal")
    public void testAllEqual(){
        // all positive
        randGenerate(10, 45, 46);
        output = Sort.sort(new ArrayList<Integer>(input), "ascending");
        assert checkListNotAltered(input, output) & checkOrder(output, "ascending");

        output = Sort.sort(new ArrayList<Integer>(input), "descending");
        assert checkListNotAltered(input, output) & checkOrder(output, "descending");
        input.clear();

        // all negative
        randGenerate(10, -46, -45);
        for (int i = 0; i < 10; i++)
        {
            input.set(i, input.get(i) -  Integer.MIN_VALUE);
        }

        output = Sort.sort(new ArrayList<Integer>(input), "ascending");
        assert checkListNotAltered(input, output) & checkOrder(output, "ascending");

        output = Sort.sort(new ArrayList<Integer>(input), "descending");
        assert checkListNotAltered(input, output) & checkOrder(output, "descending");
        input.clear();


        // zero
        randGenerate(10, 0, 1);

        output = Sort.sort(new ArrayList<Integer>(input), "ascending");
        assert checkListNotAltered(input, output) & checkOrder(output, "ascending");

        output = Sort.sort(new ArrayList<Integer>(input), "descending");
        assert checkListNotAltered(input, output) & checkOrder(output, "descending");
        input.clear();

    }



    @RepeatedTest(5)
    @DisplayName("Testing if a random order is returned")
    public void testSortRepeat(){

        input.add(-132090);
        input.add(0);
        input.add(322);
        input.add(0);
        input.add(4);
        input.add(-89);

        output = Sort.sort(new ArrayList<Integer>(input), "ascending");
        assert checkListNotAltered(input, output) & checkOrder(output, "ascending");

        output = Sort.sort(new ArrayList<Integer>(input), "descending");
        assert checkListNotAltered(input, output) & checkOrder(output, "descending");
    }



    private void randGenerate(int size, int lowerBound, int upperBound)
    {
        for (int i = 0; i < size; i++)
        {
            input.add(lowerBound + random.nextInt(upperBound-lowerBound));
        }
    }

    private void randGenerate(int size, int lowerBound, int upperBound, String order)
    {
        int sign = 1;
        if(order.equalsIgnoreCase("descending")) sign = -1;

        input.add(lowerBound);
        for (int i = 1; i < size; i++)
        {
            input.add(input.get(i-1) + sign*random.nextInt(upperBound-lowerBound));
        }
    }


    private boolean checkListNotAltered(ArrayList <Integer> input, ArrayList <Integer> output){
        ArrayList  <Integer> inCopy = new ArrayList<Integer>(input);
        for (Integer out:output)
        {
            if(inCopy.contains(out)){
                inCopy.remove(out);
            }
            else{
                return false;
            }
        }

        return inCopy.isEmpty();
    }

    private boolean checkOrder(ArrayList <Integer> output, String order){
        if(order.equalsIgnoreCase("ascending")){
            int n = output.size();
            for (int i = 1; i < n; i++)
            {
                if (output.get(i-1) > output.get(i)) return false;
            }

            return true;
        }
        else{
            int n = output.size();
            for (int i = 1; i < n; i++)
            {
                if (output.get(i-1) < output.get(i)) return false;
            }

            return true;
        }
    }
}
