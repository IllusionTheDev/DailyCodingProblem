package me.imillusion.dailycodingproblem;

import java.util.Scanner;

public class ArrayFold {

    /*
        Good morning! Here's your coding interview problem for today.

        This problem was asked by Stripe.

        reduce (also known as fold) is a function that takes in an array,
        a combining function, and an initial value and builds up a result
        by calling the combining function on each element of the array,
        left to right. For example, we can write sum() in terms of reduce:

        This should call add on the initial value with the first element of the array,
        and then the result of that with the second element of the array, and so on
        until we reach the end, when we return the sum of the array.

        Implement your own version of reduce.
     */

    public static void main(String[] args)
    {
        System.out.println("Input your array, split it using a space");
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            String line = scanner.nextLine();
            String[] lines = line.split(" ");

            int[] array = new int[lines.length];

            boolean valid = true;

            for(int i = 0; i < lines.length; i++)
            {
                String input = lines[i];

                if(!input.matches("\\d+"))
                {
                    valid = false;
                    System.out.println("Invalid sequence. Please try again");
                }
                else
                    array[i] = Integer.parseInt(input);

            }

            if(!valid)
                continue;

            sumArray(array, 0);
            break;
        }

    }

    private static void sumArray(int[] array, int start)
    {
        for(int i : array)
            start += i;

        System.out.println(start);
    }
}
