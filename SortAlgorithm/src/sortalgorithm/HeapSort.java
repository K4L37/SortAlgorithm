package sortalgorithm;

public class HeapSort {
	public void sort(Product arr[])
    {
        int n = arr.length;
 
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        for (int i=n-1; i>=0; i--)
        {
            Product temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            heapify(arr, i, 0);
        }
    }
	private void heapify(Product arr[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
 
        if (l < n && arr[l].getQty() > arr[largest].getQty())
            largest = l;
 
        if (r < n && arr[r].getQty() > arr[largest].getQty())
            largest = r;
 
        if (largest != i)
        {
            Product swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            heapify(arr, n, largest);
        }
    }
}
