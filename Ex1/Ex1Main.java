package Ex1;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals("quit")) {
                System.out.println("num1=" + num1 + "is number: "+ Ex1.isNumber(num1) + " , value: "
                        + Ex1.number2Int(num1)); //print the number, if its valid number and its value in 10 base
                if (!(Ex1.isNumber(num1))) {
                    System.out.println("ERR: num1 is in the wrong format! ("+num1+")");//if the number is not valid - error
                }
                else
                {
                    System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                    num2 = sc.next();
                    System.out.println("num2=" + num2 + "is number: "+ Ex1.isNumber(num2) + " , value: "
                            + Ex1.number2Int(num2));//print the number, if its valid number and its value in 10 base
                    if (!(Ex1.isNumber(num2))) {
                        System.out.println("ERR: num2 is in the wrong format! ("+num2+")");//if the number is not valid - error
                    }
                    else
                    {
                        System.out.println("Enter a base for output: a number [2,16]");
                        int base = Integer.parseInt(sc.next());
                        if (base>16||base<2){
                            System.out.println("ERR: base must be between 2 and 16");
                            continue;
                        }
                        else
                        {
                            String addRes = Ex1.numAdd(num1, num2, base); //compute the sum of the numbers
                            String multRes = Ex1.multNUm(num1, num2, base);//compute the multiplier of the numbers
                            String [] numArr = {num1, num2, addRes, multRes};
                            int i = Ex1.maxIndex(numArr); //find the max between the numbers
                            System.out.println(num1 + " + " + num2 + " = " + addRes);
                            System.out.println(num1 + " * " + num2 + " = " + multRes);
                            System.out.println("Max number over ["+num1+", "+ num2 + ", " + addRes + ", "
                                    + multRes + "] is: "+ numArr[i]);
                        }
                    }
                }

            }
        }
        System.out.println("quiting now...");
    }
}
