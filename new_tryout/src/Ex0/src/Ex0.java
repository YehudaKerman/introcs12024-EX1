package Ex0.src; /**
 * autour: @yehuda kerman 316367770
 1)	Given a natural even number n>4, we need to find two prime numbers that combine sum is n and print them, to do that, We will do a loop of checking n-odds number starting with 3 and check if they are prime number if yes the result is a prime number, if yes, that is the answer, if not check the next odd number – 5 is it prime? If yes check n-5, if not next odd number. Until it finds. Then print them.
 2)	 We need to find two prime numbers that the difference between them is n, We will do a loop of checking  if odd number is prime number if yes check the sum of a the prime number and n = prime nuber, good, not, next odd number. Until we find. Then print them
 3)	We need to find how much prime numbers there  between n  and 2, we will Create a counter starting by 1 and variable starting by 3 and empty string, then create a loop, is the variable prime number? If yes counter + 1 and add it to the string, then check the number+2, if not  number+2 and again while number <=n, then print the counter
 4)	We need to find which prime numbers are the dividers of n and print them, we start with two and check if it prime number if yes, then we check if n divide by the number number without remainder, if yes we divide n by it and enter it to string, now check if the new n is prime number, then check the next number, if not check the next number, until  n is prime number, then print the string.
 5)	We need to check and print how much time it took to do all those functions, we will check the time in the beginning and the end and subtract them to get the running time
 6)	We need to print my id.

 main:{
    1)	input(n>4)	               	         //assuming n is natural number and bigger then 4
    2) check the time                        //checking the time to find the running time
    3) subtruct n                            //use the subtrsct funnction on n
    4) add n                                 //use the add funnction on n
    5) count n                               //use the count funnction on n
    6) didvide n                             //use the divide funnction on n
    7)	print 316367770                      //print my id
    8)	check the time //stop the timer after the last  //hecking the time to find the running time
    9)	print time at end-time at start}      // subtract the time of start from the end to find the running time and print
 a)subtruct:{
    1)	start_time = time now                // set timer to check runtime of the progrem
    2)	a = 3,b=0                            // a is a variable that we check if part of n, b is the result of n-a
    3)	bull_ans = false                     // bull_ans is variable to check if I got the answer and stop
    4)	while bull_ans == false              //loop to check while we don’t have the answer
    5)	b=n-a                                // subtract a from n to check if a & b are prime and =n
        a.	if a isprime(a)==true &&  isprime(b) // check if a & n-a is prime number
            1.	Print (n+”=”+a+”+”+b)
            2.	Bull_ans = true
        b.	Else:a=a+2}
 b) add{
    1)	c=3                                 // c is variable to check every odd number if it is prime
    2)	bull_dif = false                    // variable to tell us if we found the answer
    3)	while bull_dif = false:             // loop to check all odd numbers
         a.	if isprime(c) && is prime (n+c):    // check if n is  the difference between two prime numbers
            1.	print (n+”=”+c+”+”+(n+c))           // printing the number
            2.	bull_dif= true                      // stopping the loop
         b.	else:
            1.	c=c+2}                             // checking the next number
 c)count{
    1)	counter=1, d = 3                    //counter count how much prime numbers we have & c is checking
    2)	while d<n:                          // loop to check every odd number between 3 & n
         a.	if isprime(d)                       // if d is prime number add 1 to counter
            1.	counter = counter +1
            2.	d = d+2                             // add 2 to check the next odd number
         b.	else: d=d+2                         // if not check the next odd number
    3)	how_much_str=(counter+” prime numbers in [2,”+n+”)”) // how_much_str is a string to print how much prime numbers are
    4)	print how_much_str     // print the result}
 d) didvide{
    1)	decomp_str =(n+ “= 2”) // decomp_str is a string that keep all the prime numbers that decompose n
    2)	new_n=n/2, e=2 // new_n is a variable that we divide and we know it divide by 2
    3)	while !isprime(new_n): // a loop while new_n is not a prime number
        a.	if isprime(e) && new_n%e == 0 //if e is prime number and new_n divide by e without remainder
            1.	add to decomp_str(“*”+e) // add the number to the string
            2.	new_n=new_n/e // divide by the number and check again
        b.	else:e= e+1 // if not divide without remainder or e is not prime number check the next number
    4)	add to decomp_str(“*”+new_n) // add new_n as the last prime number to the string
    5)	print decomp_str}

 isprime{
 1. 	Input(n >1)                       // assuming n is a natural number n>0
 2. 	if n<2 or n%2=0                        // check off all the even number and 1
 a.     not prime                              //then the number is not prime number
 3.     else:
 4.     if n=2                                  //2 is prime number
 5.       is prime number                         //return true answer
 6.     else
 7.     for i=3, i<=sqrt(n),i+2                    // loop to check all the uneven numbers
 8.     if n%i=0                                  //if n divide by i without reminader
 9.     not prime                                 // return fals answer
 10.    else
 11.    return true
  }

 */
import java.util.Scanner;
public class Main {
    /**
     * The main function receives an even number bigger than 4 from the user, and then calls multiple functions that
     * its prime components. I.e., which prime numbers it's a sum of, which two prime number it is the difference of,
     * how many prime numbers are between the number and 2, and what are its primary factors
     * For example, for the number 6 the answers will be:3+3,5+6=11,3 prime numbers,2*3=6
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an even number bigger then 4: ");//even number>4
        int n = scan.nextInt();
        long strTime = System.currentTimeMillis();              //check the time for running time
        addPrime(n);                                            //check sum of what prime number =n and print them
        subtractPrime(n);                                      //check which prime number + n = prime number and print them
        countPrime(n);                                          //check how much prime numbers are between 2 and n and print it
        System.out.println("d) " + n + "=" + decompPrime(n));   //print all the prime numbers that decompose n
        System.out.println("e) my id is 316367770");            //print my id
        long endTime = System.currentTimeMillis();              //check the end time for running time
        double runTime = (endTime - strTime) / 1000.0;          //check the difrence in time beetwen end and start in seconds
        System.out.println("f) running time is: " + runTime);   //print the running time
    }

    /**
     * isPrime function uses an algorithm to find if n is a prime number
     * The function first checks if the number is 0,1, or any other even number and return False,
     * and if it's 2, return True
     * Then the function checks if n is divisible without a remainder by all the odd numbers between 3 and square root of n
     * because if n is not divisible without a remainder by any of those numbers, it won't be divisible by a larger number
     * If n isn't divisible without a remainder by all of those numbers then n is a prime number, return True
     * @param n int Number received from function to check
     * @return True/False
     */
    public static boolean isPrime(int n) {
        if ((n < 2) || (n > 2 && n % 2 == 0)) // if n smaller then 2 or divide without reminder by 2
        {
            return false;
        } else {
            if (n == 2) // special case
            {
                return true;
            } else
                {
                for (int i = 3; i <= Math.sqrt((double) n); i += 2)// check all the odd numbers until square root of n
                {
                    if (n % i == 0)//if it divide without remainder then its not prime number
                    {
                       return false;
                    }
                }
                return true;
            }
        }
    }

    /**
     * subtractPrime checks what are the 2 prime numbers that n is the sum of
     * as stated in the Goldbach's conjecture.
     * The function checks every odd number (i) starting from 3 on.
     * If i is prime and if n-i is prime, then the function will print the prime
     * numbers that add up to n
     * @param n int Number received from user to check
     */
    public static void subtractPrime(int n)
        {
            int c = 3, d = 0; //starting variables
            boolean bullDif = false;
            while (bullDif == false)
            {
                    d = n + c;
                    if (isPrime(c) && isPrime(d))//if they are prime print them
                    {
                        System.out.println("b) "+n + "=" + c + "-" + d);
                        bullDif = true;
                    }
                    else                        // if not check the next odd number
                    {
                        c = c + 2;
                    }
            }
        }

    /**
     * addPrime is a function that finds two prime numbers that n is their difference
     * The function checks all the odd numbers (i) if they are prime. If i is prime and
     * (i + n) is prime, then the function prints the prime numbers that n is their difference
      * @param n int Number received from user to check
     */
    public static void addPrime (int n)
            {
                int a = 3, b = 0;           //variables for the calculation
                boolean bullAns = false;
                while (bullAns == false)    //a loop until we find the numbers
                {
                    b = n - a;
                    if (isPrime(a) && isPrime(b)) //if they both true print the solution
                    {
                        System.out.println("a) "+n + "=" + a + "+" + b);
                        bullAns = true;
                    } else                  //else check the next odd number
                    {
                        a = a + 2;
                    }
                }
            }

    /**
     * countPrime counts all the prime numbers between 2 and n
     * The function already takes 2 into account and start counting
     * from 3, then checks all the odd numbers until n and prints
     * the final amount
      * @param n int Number received from user to check
     */
    public static void countPrime ( int n)
            {
                int count = 1; //start from 1 because 2 is allways between 2 and n
                for (int a = 3; a < n; a += 2) //loop that check all the odd numbers
                {
                    if (isPrime(a)) // if it's prime add 1 to the count
                    {
                        count++;
                    }
                }
                System.out.println("c) "+ count + " prime numbers in [2," + n + ")"); // print the amount

            }

    /**
     * decompPrime finds all the primary factors that compose n
     * The function checks by which prime number n is divisible
     * without a remainder, starting with 2, and repeats the same
     * process with the quotient until we end up with a prime quotient
     * Then return all the components as a string
     * @param n int Number received from user to check
     * @return decomp
     */
    public static String decompPrime (int n)
    {
        int a = n, b = 2; // the starters for the calculation
        String decomp = ""; //empty string to insert all the prime numbers
        while (!isPrime(a)) // while the result isn't prime number
        {
            if (isPrime(b)&&a%b==0) // if the odd number is prime and a is divide by b without remainder
            {
                a=a/b;              //divide a by b
                decomp+=b+"*";      //add b to the string
            }
            else                    //check the next odd number
            {
                b=b+1;
            }
        }
        decomp+=a;                  //add the last prime number a it self to the string
        return decomp;              //return the string
    }
}
