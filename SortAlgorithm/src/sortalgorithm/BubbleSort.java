package sortalgorithm;

public class BubbleSort {
	
	int _flow = -1;
	
	public BubbleSort(int flow)
	{
		_flow = flow;
	}
	
	public void sort(Product arr[])
    {
		if (_flow == 1) {			
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
		else if (_flow == 2){
	        int n = arr.length;
	        for (int i = 0; i < n-1; i++){
	            for (int j = 0; j < n-i-1; j++){
	            	//20171114       
	            	int comparisonResult1 = arr[j].getName().compareTo(arr[j+1].getName());
	        		int comparisonResult2 = arr[j+1].getName().compareTo(arr[j].getName());	          	
	        		
	                if (comparisonResult1 > comparisonResult2)
	                {
	                    // swap temp and arr[i]
	                    Product temp = arr[j];
	                    arr[j] = arr[j+1];
	                    arr[j+1] = temp;
	                }
	            }
	        }
		}
    }
	
	

}

