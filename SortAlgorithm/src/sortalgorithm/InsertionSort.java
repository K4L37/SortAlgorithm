package sortalgorithm;

public class InsertionSort {
	
	int _flow = -1;
	
	public InsertionSort(int flow)
	{
		_flow = flow;
	}
	
	public void sort(Product arr[])
    {
		if ( _flow==1) {
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
		else if (_flow==2){
	        int n = arr.length;
	        for (int i=1; i<n; ++i)
	        {
	            //Product key = arr[i];
	        	int key = i;
	            int j = i-1;
	 
	            /* Move elements of arr[0..i-1], that are
	               greater than key, to one position ahead
	               of their current position */
	            
	        	int comparisonResult1 = arr[j].getName().compareTo(arr[key].getName());
	    		int comparisonResult2 = arr[key].getName().compareTo(arr[j].getName());	            
	            
	            while (j>=0 && comparisonResult1 > comparisonResult2)
	            {
	                arr[j+1] = arr[j];
	                j = j-1;
	            }
	            arr[j+1] = arr[key];
	        }
		}
    }
	

}

