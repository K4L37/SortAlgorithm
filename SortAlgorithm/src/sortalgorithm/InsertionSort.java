package sortalgorithm;

public class InsertionSort {
	void sort(Product arr[])
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            Product key = arr[i];
            int j = i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j].getQty() > key.getQty())
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }
}
