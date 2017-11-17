package sortalgorithm;

public class QuickSort {

	int _flow = -1;
	
	public QuickSort(int flow)
	{
		_flow = flow;
	}
	
    private int cnt;

    public void sort(Product[] values) {

        if (values ==null || values.length==0){
            return;
        }
        cnt = values.length;
        quicksort(values, 0, cnt - 1);       
    }

    int partitionStr(Product arr[], int low, int high)
    {
        int pivot = arr[high].getQty(); 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j].getQty() <= pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                Product temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        Product temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
    
    int partitionInt(Product arr[], int low, int high)
    {
        int pivot = high; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j].getName().compareTo(arr[pivot].getName()) <= 
           		 arr[pivot].getName().compareTo(arr[j].getName()))
            {
                i++;

                // swap arr[i] and arr[j]
                Product temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        Product temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
 
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void quicksort(Product arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is 
              now at right place */
        	int pi = 0;
            if (_flow==1){
            	pi = partitionInt(arr, low, high);
            }
            else if (_flow==2){
            	pi = partitionStr(arr, low, high);
            }
        	
            
 
            // Recursively sort elements before
            // partition and after partition
            quicksort(arr, low, pi-1);
            quicksort(arr, pi+1, high);
        }
    }    
    

}