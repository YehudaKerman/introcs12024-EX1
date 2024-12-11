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
            if (!(isNumber(num)))
            {
                ans = -1;
            }
            else
            {
                if (isBase10(num))
                {
                  ans = Integer.parseInt(num);
                }
                else
                {
                    ans = 0;
                    int base = whatBase(num);
                    for (int i = num.length()-3; i >= 0; i--)
                    {
                        int digit = whatBase(num.charAt(i));
                       ans = ans + (digit * (int) (Math.pow(base,(num.length()-i-3))));//
                    }
                }
            }
            ////////////////////
            return ans;
        }
        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
        public static boolean isNumber(String a) {
            boolean ans = true;
            if (a.equals(""))
            {
                ans = false;
            }
            else
                if (isBase10(a))
                {
                    ans = true;
                }
                else {
                    if (a.length()<3 || a.charAt(a.length()-2) != 'b')
                    {
                        ans = false;
                    } else {
                        if ((whatBase(a) ==-1))
                        {
                            ans = false;
                        }
                        else
                        {
                            for (int i = 0; i < a.length() - 2 && ans == true; i++)
                            {
                                if (((whatBase(a.charAt(i))) >= whatBase(a)) || ((whatBase(a.charAt(i))==-1)))
                                {
                                    ans = false;
                                }
                            }
                        }
                    }
                }
                ////////////////////
                return ans;
        }
        /**
        /////////
         */
        public static boolean isBase10(String a) //need to make a test
        {
            boolean ans = true;
            for (int i = 0; i < a.length() && ans == true; i++)
            {
                char c = a.charAt(i);
                if ((int) c <48 || ((int) c) > 57)
                {
                    ans = false;
                }

            }
            return ans;
        }
        /**
         * //////
         */
        public static int whatBase (char a)
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
         *
         * @param a
         * @return
         */
        public static int whatBase (String a)
        {
            int ans = -1;
            if (isBase10(a))
            {
                ans = 10;
            }
            ans = whatBase(a.charAt(a.length()-1));
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
                char cbase = intToBase(base);
                ans = "b"+cbase;
                for (int i = num; i > 0; i=i/base)
                {
                    int lastDigit = i%base;
                    char lastChar = intToBase(lastDigit);
                    ans = lastChar + ans;
                }
            }
            ////////////////////
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
     *
     * @param n
     * @return
     */
    public static char intToBase (int n) {
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
     *
     * @param a
     * @param b
     * @param base
     * @return
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
     *
     * @param a
     * @param b
     * @param base
     * @return
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
