import java.util.Scanner;

public class SelectionSort
{
    static void display(int[] arr)
    {
        for(int el : arr)
        {
            System.out.print("  " + el);
        }
    }

    static int[] sorting(int[] arr)
    {
        for(int i = 0; i < arr.length-1; i++)
        {
            for(int j = i+1; j < arr.length; j++)
            {
                if(arr[i] > arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println("\n\nPass : " + (i+1));
            display(arr);
        }
        return arr;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = sc.nextInt();

        // int[] arr = {12, 45, 8, 5, 16};
        int[] arr = new int[n];

        System.out.println("-----Enter array elements-----");
        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.println("\n----Unsorted Array----");
        display(arr);
        arr = sorting(arr);
        System.out.println("\n\n----Sorted Array----");
        display(arr);
        sc.close();
    }
}