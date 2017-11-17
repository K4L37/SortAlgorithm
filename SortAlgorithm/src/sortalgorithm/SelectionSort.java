package sortalgorithm;

public class SelectionSort {
	
	int _flow = -1;
	
	public SelectionSort(int flow)
	{
		_flow = flow;
	}
	
	public void sort(Product[] arr){  
		
		if (_flow==1) {
	        for (int i = 0; i < arr.length - 1; i++)  
	        {  
	            int index = i;  
	            for (int j = i + 1; j < arr.length; j++){  
	                if (arr[j].getQty() < arr[index].getQty()){  
	                    index = j;//searching for lowest index  
	                }  
	            }  
	            Product p = arr[index];   
	            arr[index] = arr[i];  
	            arr[i] = p;  
	        } 
		}
		else if (_flow==2) {
	        for (int i = 0; i < arr.length - 1; i++)  
	        {  
	            int index = i;  
	            for (int j = i + 1; j < arr.length; j++){              	
	                
	            	int comparisonResult1 = arr[index].getName().compareTo(arr[j].getName());
	        		int comparisonResult2 = arr[j].getName().compareTo(arr[index].getName());	 
	            	
	                //if (arr[j].getQty() < arr[index].getQty()){
	        		if (comparisonResult1 > comparisonResult2) {
	                    index = j;//searching for lowest index  
	                }  
	            }  
	            Product p = arr[index];   
	            arr[index] = arr[i];  
	            arr[i] = p;  
	        }  
		}
    }
}

