/// Assignment 1: Recursion
//Student: Serikkazy Akarys
//Group: SE-2514

/// Task 1. Print Digits of a Number
//public static void printNumber(int n) {
//    if (n == 0) {
//        return;
//    }
//    printNumber(n / 10);
//    System.out.println(n % 10);
//}
//public static void main(String[] args) {
//    printNumber(5481);
//}

/// Task 2. Average of Elements
//public static int sum(int[] arr, int n) {
//    if (n == 0) {
//        return 0;
//    }
//    return arr[n - 1] + sum(arr, n - 1);
//}
//public static void main(String[] args) {
//    int[] arr = {3, 2, 4, 1};
//
//    int total = sum(arr, arr.length);
//    double average = (double) total / arr.length;
//    System.out.println(average);
//}

/// Task 3. Prime Number Check
//public static boolean isPrime(int n, int i) {
//    if (n <= 2) {
//        return n == 2;
//    }
//    if (n % i == 0) {
//        return false;
//    }
//    if (i * i > n) {
//        return true;
//    }
//    return isPrime(n, i + 1);
//}
//public static void main(String[] args) {
//    int n = 7;
//
//    if (isPrime(n, 2)) {
//        System.out.println("Prime");
//    } else {
//        System.out.println("Composite");
//    }
//}

///Task 4. Factorial
//public static int factorial(int n) {
//    if (n == 0 || n == 1) {
//        return 1;
//    }
//    return n * factorial(n - 1);
//}
//public static void main(String[] args) {
//    int n = 5;
//
//    System.out.println(factorial(n));
//}

///Task 5. Fibonacci Number
//public static int fibonacci(int n) {
//    if (n == 0) {
//        return 0;
//    }
//    if (n == 1) {
//        return 1;
//    }
//    return fibonacci(n - 1) + fibonacci(n - 2);
//}
//public static void main(String[] args) {
//    int n = 17;
//
//    System.out.println(fibonacci(n));
//}

///Task 6. Power Function
//public static int power(int a, int n) {
//    if (n == 0) {
//        return 1;
//    }
//    return a * power(a, n - 1);
//}
//public static void main(String[] args) {
//    int a = 2;
//    int n = 10;
//
//    System.out.println(power(a, n));
//}

///Task 7. Reverse Output
//public static void reverse(int n) {
//    if (n == 0) {
//        return;
//    }
//    int x = n % 10;
//    System.out.print(x + " ");
//
//    reverse(n / 10);
//}
//public static void main(String[] args) {
//    int n = 1234;
//
//    reverse(n);
//}

///Task 8. Check Digits in String
//public static boolean isDigits(String s, int index) {
//    if (index == s.length()) {
//        return true;
//    }
//    if (!Character.isDigit(s.charAt(index))) {
//        return false;
//    }
//    return isDigits(s, index + 1);
//}
//public static void main(String[] args) {
//    String s = "123a12";
//
//    if (isDigits(s, 0)) {
//        System.out.println("Yes");
//    } else {
//        System.out.println("No");
//    }
//}

///Task 9. Count Characters in a String
//public static int countChar(String s) {
//    if (s.equals("")) {
//        return 0;
//    }
//    return 1 + countChar(s.substring(1));
//}
//public static void main(String[] args) {
//    String s = "hello";
//
//    System.out.println(countChar(s));
//}

///Task 10. Greatest Common Divisor (GCD)
public static int gcd(int a, int b) {
    if (b == 0) {
        return a;
    }
    return gcd(b, a % b);
}

public static void main(String[] args) {
    int a = 32;
    int b = 48;

    System.out.println(gcd(a, b));
}
