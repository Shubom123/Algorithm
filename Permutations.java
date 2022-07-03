package com.algorithm;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        permute("ABCDEF");
    }

    public static void permute(String str){
        char[] temp = str.toCharArray();
        // Step 1. Sort the string
        Arrays.sort(temp);
        System.out.println("String " + String.valueOf(temp));
        int index = 0;
        int lowest = 0;
        while(true){
            // Step 2. Rightmost char smallest than its neighbour
            for(int i = 0; i < temp.length - 1; i++){
                if(temp[i] < temp[i+1]){
                    lowest = i;
                }
            }
            // index of CHAR1
            index = lowest;
            // Step3. Find the ceiling of the
            int j = findCeiling(temp, index);
            // Breaking condition at this juncture
            // all permutations are printed
            if(j == index) break;

            swap(temp, index, j);
            String a = String.valueOf(temp);
            // Step4. Sort the substring
            char[] b = a.substring(index + 1).toCharArray();
            Arrays.sort(b);
            a = a.substring(0, index + 1) + String.valueOf(b);
            temp = a.toCharArray();
            System.out.println( "String " + String.valueOf(temp));
            //}
        }
    }

    /**
     *
     */
    public static int findCeiling(char[] temp, int index){
        int k = index;
        char test = temp[index];
        while (k < temp.length - 1){
            if(temp[index] < temp[k + 1]){
                index = k + 1;
                break;
            }
            k++;
        }
        k = index;
        while (k < temp.length - 1){
            if((temp[index] > temp[k + 1]) && (temp[k + 1] > test)){
                index = k + 1;
            }
            k++;
        }
        return index;
    }

    private static void swap(char[] str, int i, int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
