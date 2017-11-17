package sortalgorithm;

public class MergeSort {
	
	int _flow = -1;
	
	public MergeSort(int flow)
	{
		_flow = flow;
	}
	
    private Product[] numbers;
    private Product[] helper;

    private int number;
	
	public void sort(Product arr[])
	{
		if ( _flow == 1){
			sortInteger(arr, 0, arr.length-1);
		}
		else if ( _flow == 2){
	        this.numbers = arr;
	        number = arr.length;
	        this.helper = new Product[number];
	        mergeString(0, number - 1);
		}
	}
	
	private void CombineIntArr(Product arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
 
     
        Product L[] = new Product [n1];
        Product R[] = new Product [n2];
 
     
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
 

        int i = 0, j = 0;
 
   
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i].getQty() <= R[j].getQty())
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 

        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 

        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
	private void sortInteger(Product arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            sortInteger(arr, l, m);
            sortInteger(arr , m+1, r);
 
            // Merge the sorted halves
            CombineIntArr(arr, l, m, r);
        }
    }
	
    private void CombineStrArr(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
        	int comparisonResult1 = helper[i].getName().compareTo(helper[j].getName());
        	int comparisonResult2 = helper[j].getName().compareTo(helper[i].getName());
            //if (helper[i].getName() <= helper[j].getName()) {
        	if (comparisonResult1 <= comparisonResult2) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }
        // Since we are sorting in-place any leftover elements from the right side
        // are already at the right position.

    }
	
    private void mergeString(int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergeString(low, middle);
            // Sort the right side of the array
            mergeString(middle + 1, high);
            // Combine them both
            CombineStrArr(low, middle, high);
        }
    }
	
   


}

