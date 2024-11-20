package Ex0.src; /**
 * autour: @yehuda kerman 316367770
 1)	Given a natural even number n>4, we need to find two prime numbers that combine sum is n and print them, to do that, We will do a loop of checking n-odds number starting with 3 and check if they are prime number if yes the result is a prime number, if yes, that is the answer, if not check the next odd number – 5 is it prime? If yes check n-5, if not next odd number. Until it finds. Then print them.
 2)	 We need to find two prime numbers that the difference between them is n, We will do a loop of checking  if odd number is prime number if yes check the sum of a the prime number and n = prime nuber, good, not, next odd number. Until we find. Then print them
 3)	We need to find how much prime numbers there  between n  and 2, we will Create a counter starting by 1 and variable starting by 3 and empty string, then create a loop, is the variable prime number? If yes counter + 1 and add it to the string, then check the number+2, if not  number+2 and again while number <=n, then print the counter
 4)	We need to find which prime numbers are the dividers of n and print them, we start with two and check if it prime number if yes, then we check if n divide by the number number without remainder, if yes we divide n by it and enter it to string, now check if the new n is prime number, then check the next number, if not check the next number, until  n is prime number, then print the string.
 5)	We need to check and print how much time it took to do all those functions, we will check the time in the beginning and the end and subtract them to get the running time
 6)	We need to print my id.

 a)
    1)	input(n>4)	               	         //assuming n is natural number and bigger then 4
    2)	start_time = time now                // set timer to check runtime of the progrem
    3)	a = 3,b=0                            // a is a variable that we check if part of n, b is the result of n-a
    4)	bull_ans = false                     // bull_ans is variable to check if I got the answer and stop
    5)	while bull_ans == false              //loop to check while we don’t have the answer
    6)	b=n-a                                // subtract a from n to check if a & b are prime and =n
        a.	if a isprime(a)==true &&  isprime(b) // check if a & n-a is prime number
            1.	Print (n+”=”+a+”+”+b)
            2.	Bull_ans = true
        b.	Else:a=a+2
 b)
    1)	c=3                                 // c is variable to check every odd number if it is prime
    2)	bull_dif = false                    // variable to tell us if we found the answer
    3)	while bull_dif = false:             // loop to check all odd numbers
         a.	if isprime(c) && is prime (n+c):    // check if n is  the difference between two prime numbers
            1.	print (n+”=”+c+”+”+(n+c))           // printing the number
            2.	bull_dif= true                      // stopping the loop
         b.	else:
            1.	c=c+2                               // checking the next number
 c)
    1)	counter=1, d = 3                    //counter count how much prime numbers we have & c is checking
    2)	while d<n:                          // loop to check every odd number between 3 & n
         a.	if isprime(d)                       // if d is prime number add 1 to counter
            1.	counter = counter +1
            2.	d = d+2                             // add 2 to check the next odd number
         b.	else: d=d+2                         // if not check the next odd number
    3)	how_much_str=(counter+” prime numbers in [2,”+n+”)”) // how_much_str is a string to print how much prime numbers are
    4)	print how_much_str     // print the result
 d)
    1)	decomp_str =(n+ “= 2”) // decomp_str is a string that keep all the prime numbers that decompose n
    2)	new_n=n/2, e=2 // new_n is a variable that we divide and we know it divide by 2
    3)	while !isprime(new_n): // a loop while new_n is not a prime number
        a.	if isprime(e) && new_n%e == 0 //if e is prime number and new_n divide by e without remainder
            1.	add to decomp_str(“*”+e) // add the number to the string
            2.	new_n=new_n/e // divide by the number and check again
        b.	else:e= e+1 // if not divide without remainder or e is not prime number check the next number
    4)	add to decomp_str(“*”+new_n) // add new_n as the last prime number to the string
    5)	print decomp_str
    e)	print 316367770
 f)
    1)	stop timer //stop the timer after the last
    2)	print time


 isprime{
 1. 	Input(n >1)                       // assuming n is a natural number n>0
 2. 	ans =  true                        // ans is the variable representing “is n a prime”
 3. 	i = 2                                     // init value of I is 2 (the divider)
 4. 	while (i<sqrt(n)) {                       // loop over all number 2<=i<n
 5.             t = n%i                  	     // t is the value of n mod i.
 6.             if (t=0) {                         // if t is zero, n is NOT a prime number (I divide it)
 7.                  ans = false   	     //change the value of ans to false (not prime).
 } // if                            // the end of the “if” block
 8.              i = i+1                         // increment i by 1.
 } // while                           // the end of the “while” block
 9.   	return (ans)                      // returns the answer of the algorithm
 }

 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an number: ");
        int n = scan.nextInt();
        long strTime = System.currentTimeMillis();
        addPrime(n);
        subtaractPrime(n);
        countPrime(n);
        System.out.println("d) " + n + "=" + decompPrime(n));
        System.out.println("e) my id is 316367770");
        long endTime = System.currentTimeMillis();
        double runTime = (endTime - strTime) / 1000.0;
        System.out.println("f) running time is: " + runTime);
    }
    public static boolean isPrime(int n) {
        if ((n < 2) || (n > 2 && n % 2 == 0)) {
            return false;
        } else {
            if (n == 2) {
                return true;
            } else {
                for (int i = 3; i <= Math.sqrt((double) n); i += 2) {
                    if (n % i == 0) {
                        return false;
                    }
                }
                return true;
            }
        }
    }
    public static void subtaractPrime ( int n)
        {
            int c = 3, d = 0;
            boolean bullDif = false;
            while (bullDif == false)
            {
                    d = n + c;
                    if (isPrime(c) && isPrime(d))
                    {
                        System.out.println("b) "+n + "=" + c + "-" + d);
                        bullDif = true;
                    }
                    else
                    {
                        c = c + 2;
                    }
            }
        }
    public static void addPrime ( int n)
            {
                int a = 3, b = 0;
                boolean bullAns = false;
                while (bullAns == false) {
                    b = n - a;
                    if (isPrime(a) && isPrime(b)) {
                        System.out.println("a) "+n + "=" + a + "+" + b);
                        bullAns = true;
                    } else {
                        a = a + 2;
                    }
                }
            }
    public static void countPrime ( int n)
            {
                int count = 1;
                for (int a = 3; a < n; a += 2) {
                    if (isPrime(a)) {
                        count++;
                    }
                }
                System.out.println("c) "+ count + " prime numbers in [2," + n + ")");

            }

    public static String decompPrime (int n)
    {
        int a = n, b = 2;
        String decomp = "";
        while (!isPrime(a))
        {
            if (isPrime(b)&&a%b==0)
            {
                a=a/b;
                decomp+=b+"*";
            }
            else
            {
                b=b+1;
            }
        }
        decomp+=a;
        return decomp;
    }
}
