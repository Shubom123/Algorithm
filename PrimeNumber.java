package com.algorithm;
import java.util.Scanner;

public class PrimeNumber {
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

    public static void main(String[] args) {
// here we set max no = 1000
        System.out.println("Enter max number: ");
        Scanner scanner = new Scanner( System.in );
        String input = scanner.nextLine();
        int maxNumber = Integer.parseInt( input );
        System.out.print("\nList of the prime number between 0 - " + maxNumber+"\n");
        System.out.println("The prime numbers between 0-1000 are: ");
        PrimeNumber primeNumbers = new PrimeNumber();
        for (int index = 2; index <= maxNumber; index++) {
            boolean isPrime = primeNumbers.checkIfPrime(index);
            if (isPrime) {
                System.out.print("\t"+index+"\t");
            }
        }

    }
}
