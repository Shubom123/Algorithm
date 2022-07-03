package com.algorithm;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public int binarySearch(String[] words, String search) {
        int start = 0, length = words.length - 1;

        while (start <= length) {
            int middle = start + (length - start) / 2;
            int result = search.compareTo(words[middle]);

            if (result == 0)
                return middle;

            if (result > 0)
                start = middle + 1;
            else
                length = middle - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binaryObj = new BinarySearch();

        Scanner scanner = new Scanner(System.in);
        // create array list
        String[] words = {"shubom", "supali", "jyoti", "mishon", "smriri","bhanu"};
        // array list is ascending order
        Arrays.sort(words);
        System.out.println("List of Words :");
        System.out.println(Arrays.toString(words));
        System.out.println("Enter the word you want to search");
        String search = scanner.nextLine();
        scanner.close();
        int result = binaryObj.binarySearch(words, search);

        if (result != -1) //word is found
            System.out.println("word is found at "
                    + "index " + result);
        else
            System.out.println("word is not present in the list");

    }
}
