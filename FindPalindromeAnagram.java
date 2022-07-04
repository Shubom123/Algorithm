package com.algorithm;
import java.util.Scanner;
import java.util.ArrayList;

public class FindPalindromeAnagram {
    public static void frequency(int number, int[] digitFrequency){
        while (number > 0){
            int digit = number % 10;
            digitFrequency[digit]++;
            number /= 10;
        }
    }
    public static boolean checkIfPrime(int numberToCheck) {

        boolean isPrime = true;

        if (numberToCheck == 1 || numberToCheck == 0) {
            return false;
        }

        for (int index = 2; index <= numberToCheck / 2; index++) {
            if (numberToCheck % index == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }
    public static boolean checkIfAnagram(int num1, int num2){
        int[] A = new int[10];
        int[] B = new int[10];

        frequency(num1,A);
        frequency(num2,B);

        for(int i=0; i<10; i++){
            if(A[i] != B[i]){
                return false;
            }
        }
        return true;
    }
    public void checkIfPalindrome(ArrayList<Integer> listOfPrimes){
        boolean foundPalindrome = false;
        for(int index = 0 ; index< listOfPrimes.size() ; index++) {
            foundPalindrome = false;
            int remainder, sum = 0;
            int number = listOfPrimes.get(index);
            while (number > 0) {
                remainder = number % 10; // getting remainder
                sum = (sum * 10) + remainder;
                number = number / 10;
            }
            if (listOfPrimes.contains(number))
                foundPalindrome = true;

            if(foundPalindrome) {
                System.out.println("Found Palindrome for: "+number);
            }
        }
        if(!foundPalindrome) {
            System.out.println("Did not find any Palindrome");
        }
    }
    public static void main(String[] args) {

        Scanner scannerObject = new Scanner(System.in);
        FindPalindromeAnagram primeNumbers = new FindPalindromeAnagram();
        ArrayList<Integer> primeNumbersArray = new ArrayList<Integer>();

        System.out.println("Enter the number to check if anagram exists: ");
        int userInput = scannerObject.nextInt();
        scannerObject.close();
        //check no is prime no or not
        for (int index = 2; index <= 1000; index++) {
            boolean isPrime = FindPalindromeAnagram.checkIfPrime(index);
            if (isPrime) {
                System.out.println(index);
                primeNumbersArray.add(index);
//check no is anagram or not
                boolean isAnagram = checkIfAnagram(index, userInput);
                if (isAnagram)
                    System.out.println(index + " is an Anagram");

            }
        }
        // check number is palindrome or not
        primeNumbers.checkIfPalindrome(primeNumbersArray);
    }
}

