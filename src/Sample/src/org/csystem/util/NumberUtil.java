/*----------------------------------------------------------------------------------------------------------------------
	NumberUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import static java.lang.Math.log10;
import static java.lang.Math.abs;
import static java.lang.Math.pow;

public final class NumberUtil {
    private static final String [] ONES;
    private static final String [] TENS;

    static {
        ONES = new String[] {"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
        TENS = new String[] {"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};
    }

    private static int [] getDigits(long val, int n)
    {
        int [] digits = new int[val == 0 ? 1 : (int)(log10(abs(val)) / n) + 1];
        int powOfTen = (int)Math.pow(10, n);

        for (int i = digits.length - 1; i >= 0; digits[i--] = (int)(val % powOfTen), val /= powOfTen)
            ;

        return digits;
    }

    private static String numberToText3DigitsTR(int val)
    {
        if (val == 0)
            return "sıfır";

        String str = val < 0 ? "eksi" : "";
        val = Math.abs(val);

        int a, b, c;

        a = val / 100;
        b = val / 10 % 10;
        c = val % 10;

        if (a != 0) {
            if (a != 1)
                str += ONES[a];
            str += "yüz";
        }
        if (b != 0)
            str += TENS[b];

        if (c != 0)
            str += ONES[c];

        return str;
    }

    private NumberUtil()
    {
    }

    public static int countDigits(long val)
    {
        return val == 0 ? 1 : (int)log10(abs(val)) + 1;
    }

    public static void displayCollatz(int n)
    {
        if (n <= 0) {
            System.out.println("Geçersiz değer");
            return;
        }

        for (;;) {
            System.out.println(n);

            if (n == 1)
                break;

            if (n % 2 == 0)
                n /= 2;
            else
                n = 3 * n + 1;
        }
    }

    public static long factorial(int n)
    {
        long result = 1L;

        for (int i = 2; i <= n; ++i)
            result *= i;

        return result;
    }

    public static int getDigitalRoot(int val)
    {
        int root = abs(val);

        while (root > 9)
            root = sumDigits(root);

        return root;
    }

    public static int [] getDigits(long val)
    {
        return getDigits(val, 1);
    }

    public static int [] getDigitsInThrees(long val)
    {
        return getDigits(val, 3);
    }

    public static int [] getDigitsInTwos(long val)
    {
        return getDigits(val, 2);
    }

    public static int getDigitsFactorialSum(int val)
    {
        int sum = 0;

        while (val != 0) {
            sum += factorial(val % 10);
            val /= 10;
        }

        return sum;
    }

    public static int getDigitsPowSum(int val)
    {
        int n = countDigits(val);
        int sum = 0;

        while (val != 0) {
            sum += pow(val % 10, n);
            val /= 10;
        }

        return sum;
    }

    public static int getFibonacciNumber(int n)
    {
        if (n <= 0)
            return -1;

        if (n <= 2)
            return n - 1;

        int prev1 = 1, prev2 = 0, val = 0;

        for (int i = 2; i < n; ++i) {
            val = prev1 + prev2;
            prev2 = prev1;
            prev1 = val;
        }

        return val;
    }

    public static int getIndexOfPrimeNumber(int n)
    {
        int index = 1;
        int val = 2;

        for (;;) {
            if (val == n)
                return index;

            if (isPrime(val))
                ++index;

            ++val;
        }
    }

    public static int getNextFibonacciNumber(int val)
    {
        if (val < 0)
            return 0;

        int prev1 = 1, prev2 = 0, result;

        for (;;) {
            result = prev1 + prev2;

            if (result > val)
                return result;

            prev2 = prev1;
            prev1 = result;
        }
    }

    public static int getPrime(int n)
    {
        if (n <= 0)
            return -1;

        int count = 0;
        int val = 2;

        for (;;) {
            if (isPrime(val))
                ++count;

            if (count == n)
                return val;

            ++val;
        }
    }

    public static boolean isArmstrong(int val)
    {
        return val >= 0 && getDigitsPowSum(val) == val;
    }

    public static boolean isDecimalHarshad(int val)
    {
        if (val < 0)
            return false;

        return val % sumDigits(val) == 0;
    }

    public static boolean isEven(int val)
    {
        return val % 2 == 0;
    }

    public static boolean isFactorian(int val)
    {
        if (val <= 0)
            return false;

        return getDigitsFactorialSum(val) == val;
    }

    public static boolean isHardyRamanujan(int val)
    {
        if (val <= 0)
            return false;

        int count = 0;

        for (int x = 1; x * x * x < val;) {
            for (int y = x + 1; x * x * x + y * y * y <= val; ++y)  {
                if (x * x * x + y * y * y == val) {
                    ++count;
                    ++x;
                }
            }
            ++x;
        }

        return count >= 2;
    }

    public static boolean isOdd(int val)
    {
        return !isEven(val);
    }

    public static boolean isPalindrome(int val)
    {
        return reversed(val) == val;
    }

    public static boolean isPrime(int val)
    {
        if (val <= 1)
            return false;

        if (val % 2 == 0)
            return val == 2;

        if (val % 3 == 0)
            return val == 3;

        if (val % 5 == 0)
            return val == 5;

        if (val % 7 == 0)
            return val == 7;

        int sqrtVal = (int)Math.sqrt(val);

        for (int i = 11; i <= sqrtVal; i += 2)
            if (val % i == 0)
                return false;

        return true;
    }

    public static boolean isPrimeX(int val)
    {
        do {
            if (!isPrime(val))
                return false;
            val = sumDigits(val);
        } while (val > 9);

        return isPrime(val);
    }

    public static boolean isSuperPrime(int val)
    {
        return isPrime(val) && isPrime(getIndexOfPrimeNumber(val));
    }

    public static int max(int a, int b, int c)
    {
        return Math.max(Math.max(a, b),  c);
    }

    public static int mid(int a, int b, int c)
    {
        if (a <= b && b <= c || c <= b && b <= a)
            return b;

        if (b <= a && a <= c || c <= a && a <= b)
            return a;

        return c;
    }

    public static int min(int a, int b, int c)
    {
        return Math.min(Math.min(a, b),  c);
    }

    public static String numberToText(long val)
    {
        int [] digits = getDigitsInThrees(val);

        String result = "";

        //TODO:
        for (int digit : digits)
            result += numberToText3DigitsTR(digit) + " ";

        return result;
    }

    public static int reversed(int val)
    {
        int reverse = 0;

        while (val != 0) {
            reverse = reverse * 10 + val % 10;
            val /= 10;
        }

        return reverse;
    }

    public static int sumDigits(int val)
    {
        int sum = 0;

        while (val != 0) {
            sum += val % 10;
            val /= 10;
        }

        return Math.abs(sum);
    }
}
