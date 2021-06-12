/*----------------------------------------------------------------------------------------------------------------------
	ArrayUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Random;

public final class ArrayUtil {
    private static void bubbleSortAscending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k + 1] < a[k])
                    swap(a, k, k + 1);
    }

    private static void bubbleSortDescending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k + 1] > a[k])
                    swap(a, k, k + 1);
    }

    private static void selectionSortAscending(int [] a)
    {
        int min, minIndex;

        for (int i = 0; i < a.length - 1; ++i) {
            min = a[i];
            minIndex = i;

            for (int k = i + 1; k < a.length; ++k)
                if (a[k] < min) {
                    min = a[k];
                    minIndex = k;
                }

            a[minIndex] = a[i];
            a[i] = min;
        }
    }

    private static void selectionSortDescending(int [] a)
    {
        int max, maxIndex;

        for (int i = 0; i < a.length - 1; ++i) {
            max = a[i];
            maxIndex = i;

            for (int k = i + 1; k < a.length; ++k)
                if (a[k] > max) {
                    max = a[k];
                    maxIndex = k;
                }

            a[maxIndex] = a[i];
            a[i] = max;
        }
    }

    private ArrayUtil()
    {
    }

    public static void bubbleSort(int [] a, boolean descending)
    {
        if (descending)
            bubbleSortDescending(a);
        else
            bubbleSortAscending(a);
    }

    public static void bubbleSort(int [] a)
    {
        bubbleSort(a, false);
    }


    public static int [] copyOf(int [] a, int newLength)
    {
        int [] r = new int[newLength];

        int length = Math.min(a.length, newLength);

        for (int i = 0; i < length; ++i)
            r[i] = a[i];

        return r;
    }

    public static void display(int [] a)
    {
        display(1, a);
    }

    public static void display(int n, int [] a)
    {
        String fmt = String.format("%%0%dd ", n);

        for (int val : a)
            System.out.printf(fmt, val);

        System.out.println();
    }

    public static void display(int n, int [][] a)
    {
        for (int [] array : a)
            display(n, array);
    }

    public static void display(String [] str)
    {
        display('\n', str);
    }

    public static void display(char sep, String [] str)
    {
        for (String s : str)
            System.out.printf("%s%c", s, sep);
    }

    public static void drawHistogram(int [] data, int n, char ch)
    {
        int mavValue = max(data);

        for (int val : data) {
            int count = (int)Math.ceil((double)val * n / mavValue);

            while (count -- > 0)
                System.out.print(ch);

            System.out.println();
        }
    }

    public static void fillRandomArray(int [] a, int min, int max) //[min, max)
    {
        fillRandomArray(new Random(), a, min, max);
    }

    public static void fillRandomArray(Random r, int [] a, int min, int max) //[min, max)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] = r.nextInt(max - min) + min;
    }

    public static int [] generateRandomArray(int n, int min, int max) //[min, max)
    {
        return generateRandomArray(new Random(), n, min, max);
    }

    public static int [] generateRandomArray(Random r, int n, int min, int max) //[min, max)
    {
        int [] a = new int[n];

        fillRandomArray(r, a, min, max);

        return a;
    }

    public static int [][] generateRandomMatrix(int row, int col, int min, int max)
    {
        return generateRandomMatrix(new Random(), row, col, min, max);
    }

    public static int [][] generateRandomMatrix(Random r, int row, int col, int min, int max)
    {
        int [][] m = new int[row][];

        for (int i = 0; i < row; ++i)
            m[i] = generateRandomArray(r, col, min, max);

        return m;
    }

    public static int [][] generateRandomSquareMatrix(int n, int min, int max)
    {
        return generateRandomSquareMatrix(new Random(), n, min, max);
    }

    public static int [][] generateRandomSquareMatrix(Random r, int n, int min, int max)
    {
        return generateRandomMatrix(r, n, n, min, max);
    }

    public static int [] getHistogramData(int [] a, int n) //[0, n]
    {
        int [] data = new int[n + 1];

        for (int val : a)
            ++data[val];

        return data;
    }

    public static boolean isMatrix(int [][] a)
    {
        for (int i = 1; i < a.length; ++i)
            if (a[i].length != a[0].length)
                return false;

        return true;
    }

    public static boolean isSquareMatrix(int [][] a)
    {
        return isMatrix(a) && a.length == a[0].length;
    }

    public static int max(int [] a)
    {
        int result = a[0];

        for (int i = 1; i < a.length; ++i)
            if (result < a[i])
                result = a[i];

        return result;
    }

    public static int min(int [] a)
    {
        int result = a[0];

        for (int i = 1; i < a.length; ++i)
            if (result > a[i])
                result = a[i];

        return result;
    }

    public static int partition(int [] a, int threshold)
    {
        int partitionIndex = 0;

        while (partitionIndex != a.length && a[partitionIndex] < threshold)
            ++partitionIndex;

        if (partitionIndex == a.length)
            return partitionIndex;

        for (int i = partitionIndex + 1; i < a.length; ++i)
            if (a[i] < threshold)
                swap(a, i, partitionIndex++);

        return partitionIndex;
    }

    public static void reverse(int [] a)
    {
        int halfLength = a.length / 2;

        for (int i = 0; i < halfLength; ++i)
            swap(a, i, a.length - 1 - i);
    }

    public static void reverse(char [] a)
    {
        int halfLength = a.length / 2;

        for (int i = 0; i < halfLength; ++i)
            swap(a, i, a.length - 1 - i);
    }

    public static void selectionSort(int [] a, boolean descending)
    {
        if (descending)
            selectionSortDescending(a);
        else
            selectionSortAscending(a);
    }

    public static void selectionSort(int [] a)
    {
        selectionSort(a, false);
    }

    public static int sum(int [] a)
    {
        int total = 0;

        for (int val : a)
            total += val;

        return total;
    }


    public static int sum(int [][] a)
    {
        int total = 0;

        for (int[] array : a)
            total += sum(array);

        return total;
    }

    public static int sumDiagonal(int [][] a)
    {
        int total = 0;

        for (int i = 0; i < a.length; ++i)
            total += a[i][i];

        return total;
    }

    public static void swap(int [] a, int i, int k)
    {
        int temp;

        temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }

    public static void swap(double [] a, int i, int k)
    {
        double temp;

        temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }

    public static void swap(char [] a, int i, int k)
    {
        char temp;

        temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }

    public static int [][] transpose(int [][] a)
    {
        int row = a.length;
        int col = a[0].length;
        int [][] t = new int[col][row];

        for (int i = 0; i < row; ++i)
            for (int j = 0; j < col; ++j)
                t[j][i] = a[i][j];

        return t;
    }
}
