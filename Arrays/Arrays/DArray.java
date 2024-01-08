package Arrays;
import java.lang.reflect.Array;
import java.util.Arrays;
public class DArray <T> {
    private T[] arr;
    public int length=0;
    public int current_index=0;
    
    @SuppressWarnings("unchecked")
    public DArray(Class<T> type,int size)
    {
        //Creates an array of size and type
        length = size;
        arr = Arrays.copyOf((T[]) Array.newInstance(type, size),size);
    }
    
    public T gets(int index)
    {
        //Returns the value at index
        return arr[index];
    }

    public void set(int index,T value)
    {
        arr[index] = value;
    }
    public void set(T value)
    {
        if(current_index == length-1)
        {
            resize();
        }
        arr[current_index] = value;
        current_index++;
    }

    public void resize()
    {
        arr = Arrays.copyOf(arr, length*2);
        length *= 2;
    }

    public static <T extends Comparable<T>> int compare(T a,T b)
    {
        if (a != null && b != null) {
            return a.compareTo(b);
        } else {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
    }
    
    public void trim()
    {
        //Trims to the allocated size
        arr = Arrays.copyOf(arr, current_index);
        length = current_index;
    }

    public void insert(T value, int index)
    {
        T[] temp = Arrays.copyOf(arr, index+2);
        temp[index+1]=value;
        ;
        current_index++;
        length++;
    }

    public static void main(String[] args) {
        DArray<Integer> exampleArray = new DArray<Integer>(Integer.class, 10);
        for(int i =0;i<12;i++)
        {
            exampleArray.set(i);
            exampleArray.insert((i*8), i);
        }
        for(int i =0;i<exampleArray.current_index;i++)
        {
            System.out.printf("Value: %d\n",exampleArray.gets(i));
        }
        exampleArray.trim();
        System.out.printf("Value: %d\tCurrnet Index: %d\tLength: %d\n",exampleArray.gets(exampleArray.current_index-1),exampleArray.current_index,exampleArray.length);
    }
}
