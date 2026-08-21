using System;

class Program
{
    static void Main(string[] args)
    {
        int[] array = { 9, 1, 8, 2, 7, 3, 6, 5, 4 };

        InsertionSort(array);

        foreach (int i in array)
        {
            Console.Write(i + " ");
        }
    }

    private static void InsertionSort(int[] array)
    {
        for (int i = 1; i < array.Length; i++)
        {
            int temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > temp)
            {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }
}