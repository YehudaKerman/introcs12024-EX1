package Ex1;
/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
        /**
         * Convert the given number (num) to a decimal representation (as int).
         * It the given number is not in a valid format returns -1.
         * @param num a String representing a number in basis [2,16]
         * @return
         */
        public static int number2Int(String num) {
            int ans = -1;
            // add your code here
            if (!(isNumber(num))) //check if the number valid
            {
                ans = -1;
            }
            else
            {
                if (isBase10(num)) //check for base 10 and convert to int if so
                {
                  ans = Integer.parseInt(num);
                }
                else
                {
                    ans = 0;
                    int base = converteChar2BaseOrInt(num); // check in what base the number is
                    for (int i = num.length()-3; i >= 0; i--) // loop to convert each cahr to int
                    {
                        int digit = converteChar2BaseOrInt(num.charAt(i));
                       ans = ans + (digit * (int) (Math.pow(base,(num.length()-i-3))));//algoritem by wikipedia to find
                        // base 10 of number by converting each digit and multiply by the base to the power
                        //the order of the digit the in the given number from right to left
                    }
                }
            }
            return ans;
        }
        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param  a String representing a number
         * @return true iff the given String is in a number format
         */
        public static boolean isNumber(String a) {
            boolean ans = true;
            if (a.equals("")) // for empty strings
            {
                ans = false;
            }
            else
                if (isBase10(a))
                {
                    ans = true;
                }
                else {
                    if (a.length()<3 || a.charAt(a.length()-2) != 'b') // checks for numbers without b
                    {
                        ans = false;
                    } else {
                        if ((converteChar2BaseOrInt(a) ==-1)) // bases that not in [2,16]
                        {
                            ans = false;
                        }
                        else
                        {
                            for (int i = 0; i < a.length() - 2 && ans == true; i++)
                            {
                                if (((converteChar2BaseOrInt(a.charAt(i))) >= converteChar2BaseOrInt(a)) ||
                                        ((converteChar2BaseOrInt(a.charAt(i))==-1)))//check if the numbers in the string
                                    //are bigger than the base or not acceptably char for the program
                                {
                                    ans = false;
                                }
                            }
                        }
                    }
                }
                return ans;
        }
        /**
         * This static function checks if the given String (a) is in a valid is in base 10 and not with the format.
         * @param a a String representing a number
         * @return true iff the given String is in a base10 without format
         */
        public static boolean isBase10(String a) //need to make a test
        {
            boolean ans = true;
            for (int i = 0; i < a.length() && ans == true; i++)
            {
                char c = a.charAt(i);
                if ((int) c <48 || ((int) c) > 57) // 0-9
                {
                    ans = false;
                }

            }
            return ans;
        }
        /**
         * This static function convert the chars in the number to their equivalents numbers in 10 base
         * to understend the number and the base
         * @param a is char in the string representing the number
         * @return int of the number eequivalent to the char
         */
        public static int converteChar2BaseOrInt(char a)
        {
            char [] baseArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
            int ans = -1;
            for (int i = 0; i < 17 && ans == -1; i++)
            {
                if (a == baseArr[i])
                {
                    ans = i;
                }
            }
            return ans;
        }

        /**
         * This static function convert the last char in the number to his equivalent base in format of 10 base
         * @param a is the string representing the number
         * @return int of the number eequivalent to the base return -1 if number is not valid
         */
        public static int converteChar2BaseOrInt(String a)
        {
            int ans = -1;
            if (isBase10(a))
            {
                ans = 10;
            }
            else {
                ans = converteChar2BaseOrInt(a.charAt(a.length()-1));//check the base
            }
            return ans;
        }
    /**
         * Calculate the number representation (in basis base)
         * of the given natural number (represented as an integer).
         * If num<0 or base is not in [2,16] the function should return "" (the empty String).
         * @param num the natural number (include 0).
         * @param base the basis [2,16]
         * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
         */
        public static String int2Number(int num, int base) {
            String ans = "";
            if (num <0 || base < 0 || base > 16)
            {
                ans = "";
            }
            else {
                char cbase = int2Char(base);
                ans = "b"+cbase;
                for (int i = num; i > 0; i=i/base)// an algorithm by wikipidia to conert numbers from 10 base to any base
                    //by finding the remainder of dividing by the desired base and add it from right to left
                {
                    int lastDigit = i%base;
                    char lastChar = int2Char(lastDigit);
                    ans = lastChar + ans;
                }
            }
            return ans;
        }

        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true iff the two numbers have the same values.
         */
        public static boolean equals(String n1, String n2) {
            boolean ans = true;
            int a = number2Int(n1);
            int b = number2Int(n2);
            if (a != b)
            {
                ans = false;
            }
            return ans;
        }

    /**
     * This static function convert int repersent a char in certain bases to creat the number as string
     * @param n int repersent a char in certain bases
     * @return a char represnt the number
     */
    public static char int2Char(int n) {
            char ans = 0;
            if (n>17 || n<0)
            {
               ans = '!';
            }
            else {
                char[] baseArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
                ans = baseArr[n];
            }
            return ans;
        }
        /**
         * This static function search for the array index with the largest number (in value).
         * In case there are more than one maximum - returns the first index.
         * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
         * @param arr an array of numbers
         * @return the index in the array in with the largest number (in value).
         *
         */
    public static int maxIndex(String[] arr) {
            int ans = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == null)
                {
                    ans = ans;
                }
                else{
                    int a = number2Int(arr[ans]);
                    int b = number2Int(arr[i]);
                    if (b>a)
                    {
                        ans = i;
                    }
                }

            }
            return ans;
        }

    /**
     * This static function compute the sum of two numbers and return the sum in required base
     * @param a is a string represent the first number
     * @param b is a string represent the second number
     * @param base is int represent the desired base
     * @return a string representing the sum in desired base
     */
        public static String numAdd(String a, String b, int base)
        {
            int first = number2Int(a);
            int second = number2Int(b);
            int sum = first + second;
            String ans = int2Number(sum, base);
            return ans;
        }

    /**
     ** This static function compute the multiplier product of two numbers and return the sum in required base
     * @param a is a string represent the first number
     * @param b is a string represent the second number
     * @param base is int represent the desired base
     * @return a string representing the multiplier product in desired base
     */
    public static String multNUm(String a, String b, int base)
    {
        int first = number2Int(a);
        int second = number2Int(b);
        int sum = first * second;
        String ans = int2Number(sum, base);
        return ans;
    }
}
