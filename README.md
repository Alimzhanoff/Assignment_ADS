# Assignment 1 - Recursion
**Student:** Alimzhan Adilzhan
**Group:** IT-2504


All my codes was wrote in Main.java used principles of OOP. 

**Task 1

*Description*
Write a recursive function that takes an integer as input and
prints every digit of the given number on a separate line. 
*Explanation*
To print digits from left to right, we first make a recursive call with `n / 10` to reach the first digit, and then print the remainder `n % 10` after the recursion returns(5 4 8 1 ) in each row

**Task 2
*Descrition*
Write recursive functions to fill an array with user input and calculate the average value of its elements.
*Explanation*
The fillArray function recursively moves through the array indices to store input. The findSum function adds the current element to the sum of the remaining n-1 elements, and the result is divided by the array length in main.

*Task 3*
*Description*
Write the recursive function to check if a given number a positive integer n is a prime number.
*Explanation*
Explanation
The function checkNumber tries to divide n by an incrementing divisor d starting from 2. If n is divisible by any $d$ before reaching sqrt of n, it's "Composite"; otherwise, it's "Prime!".

*Task 4*
Description
Write a recursive function to calculate the factorial of a given number n.
Explanation
Factorial is defined as n! = n*(n-1)!. The recursion continues until the base case n <= 1 is reached, where the result is 1.

*Task 5*
Description
Write a recursive function to find the $n$-th number in the Fibonacci sequence.
Explanation
The function uses the formula F(n) = F(n- 1) + F(n + 2) with base case F(0) = 0 and F(1) = 1. it builds a recursion tree to calculate the value.

*Task 6*
Description
Write a recursive function to calculate n raised to the power of d.
Explanation
The function multiplies n by the result of power(n, d-1). The process stops when the exponent d reaches 0, returning 1 (since n^0 = 1).

*Task 7*
Description
Write a recursive function that reads $n$ integers and prints them in reverse order.
Explanation
The function reverseArray takes the last index of the array and prints the element, then calls itself with index - 1 until it reaches the beginning of the array.

*Task 8*
Description
Write a recursive function to check if a string consists only of digits.
Explanation
The function checks the first character using Character.isDigit(). If true, it calls itself with the rest of the string (substring(1)). If any character is not a digit, it returns "No".

*Task 9*
Description
Write a recursive function to find the binomial coefficient C(b, k).
Explanation
Based on Pascal's identity: C(b, k) = C(b-1, k-1) + C(b-1, k). The recursion bottoms out when k=0 or k=b, where the value is always 1.

*Task 10*
Description
Write a recursive function to find the Greatest Common Divisor (GCD) of two numbers using the Euclidean Algorithm.
Explanation
The function implements the logic GCD(a, s1) = GCD(s1, a (mod(s1)). When the second number becomes 0, the first number is the GCD.

























