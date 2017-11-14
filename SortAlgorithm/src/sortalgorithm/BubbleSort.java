package sortalgorithm;

public class BubbleSort {
	  public void sort(Product arr[])
	    {
	        int n = arr.length;
	        for (int i = 0; i < n-1; i++)
	            for (int j = 0; j < n-i-1; j++)
	                if (arr[j].getQty() > arr[j+1].getQty())
	                {
	                    // swap temp and arr[i]
	                    Product temp = arr[j];
	                    arr[j] = arr[j+1];
	                    arr[j+1] = temp;
	                }
	    }
}
