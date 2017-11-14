package sortalgorithm;

public class SelectionSort {
	public void sort(Product[] arr){  
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
}
