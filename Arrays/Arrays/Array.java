package Arrays;

public class Array{
    private int [] arr;
    int lastIndex = 0;
    Array(int size)
    {
        this.arr = new int [size]; //Creates a static element
    }

    public void insert(int data)
    {
        if(lastIndex < this.arr.length)
        {
            this.arr[lastIndex++] = data;
            return;
        }
        
    }

    public int get(int index)
    {
        return this.arr[index];
    }
    public static int [][] divide(int [] arr)
    {
        int first[],second[];
        int len = arr.length;
        first = new int [len/2];
        if(len%2==0)
        {
            second = new int [len/2];
        }
        else
        {
            second = new int [(len/2)+1]; 
        }
        int firstCount = 0;
        int secondCount = 0; 
        while(secondCount+len/2 < len)
        {
            if(firstCount<len/2)
            {
                first[firstCount] = arr[firstCount];
                firstCount++;
            }
            second[secondCount] = arr[(len/2)+secondCount];
            secondCount++;
        }
        int [][] returnArr = {first,second};
        return returnArr;
    }

    
    public static int[] append(int []a,int []b,int b_count)
    {
        for(int i=b_count;i<b.length;i++)
        {
            a[a.length-b.length+i]=b[i];
        }
        return a;
    }
    public static int[] merge(int []a,int []b)
    {

        //We insert elements of b in c one by one.
        int b_count = 0;
        int a_count = 0;
        int count = 0;
        int [] merged = new int[a.length+b.length];
        while(true)
        {
            if(a[a_count]>b[b_count])
            {
                merged[count] = b[b_count];
                b_count++;
                if(b_count>=b.length)
                {
                    merged = append(merged, a,a_count);
                    return merged;
                }
            }
            else
            {
                merged[count] = a[a_count];
                a_count++;
                if(a_count>=a.length)
                {
                    merged = append(merged, b,b_count);
                    return merged;
                }
            }
            count++;
        }
    }

    public static int[] mergeSort(int [] arr)
    {
        if (arr.length==1)
        {
            return arr;
        }
        int [][] subarrays = divide(arr);
        int [] first = mergeSort(subarrays[0]);
        int [] second = mergeSort(subarrays[1]);
        int [] merged_Array = merge(first, second);
        return merged_Array;
    }

    public static int [] sort(int [] arr, boolean mergeSort)
    {
        if (mergeSort==true)
        {
            if(arr.length==1)
            {
                return arr;
            }
            int [][]subarrays = divide(arr);
            int [] first = subarrays[0];
            sort(first,true);
            int [] second = subarrays[1];
            sort(second, true);
            //int merged_Array = merge(first,second);   
            //return merged_Array;
        }
        return arr;
    }
    
    
    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 1000); // Adjust the range as needed
        }
        return arr;
    }
    public static void main(String[] args) {
        for (int size = 100; size <= 100000; size += 1000) {
            int[] arr = generateRandomArray(size);

            long startTime = System.nanoTime();
            mergeSort(arr);
            long endTime = System.nanoTime();

            long duration = endTime - startTime;

            System.out.println("Input Size: " + size + ", Execution Time: " + duration + " nanoseconds");
        }
    }
}