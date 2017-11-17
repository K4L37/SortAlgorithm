package sortalgorithm;

import java.util.Arrays;

public class RadixSort {
	
	int _flow = -1;
	
	public RadixSort(int flow)
	{
		_flow = flow;
	}
	
	public void sort(Product[] prods){
		if (_flow==1){
			sortIntArr(prods);
		}
		else if (_flow==2){
			//assume max car of string.
			int max = 256;
			sortStrArr(prods, max);
		}
	}
	
	private int getMax(Product arr[], int n)
    {
        int mx = arr[0].getQty();
        for (int i = 1; i < n; i++)
            if (arr[i].getQty() > mx)
                mx = arr[i].getQty();
        return mx;
    }

    private void countSort(Product arr[], int n, int exp)
    {
        Product output[] = new Product[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        for (i = 0; i < n; i++)
            count[ (arr[i].getQty()/exp)%10 ]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i].getQty()/exp)%10 ] - 1] = arr[i];
            count[ (arr[i].getQty()/exp)%10 ]--;
        }

        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

	public void sortStrArr(Product[] a, int W) { 
	      int N = a.length;
	      int R = 256;
	      Product[] aux = new Product[N];
	      
	      int len = W;
	      
	      OUTER:
	      for (int d = len-1; d >= 0; d--) { 
	         int[] count = new int[R+1];  
	         for (int i = 0; i < N; i++){

	        	 int wordCnt = a[i].getName().length()-1;
	        	 
	        	 if (d <= wordCnt)
	        		 count[a[i].getName().charAt(d) + 1]++;
	        	 else
	        		 continue OUTER;
	         }
	         
	         for (int r = 0; r < R; r++)     
	            count[r+1] += count[r];
	         
      
	         for (int i = 0; i < N; i++) {
	        	 aux[count[a[i].getName().charAt(d)]++] = a[i];
	         }
	         
	         for (int i = 0; i < N; i++)    
	            a[i] = aux[i];	         
	         
	      }
	 }
	 
    public void sortIntArr(Product arr[])
    {
    	int n = arr.length;
        int m = getMax(arr, n);

        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }    

	public void sortStrArr2(String[] a, int W)
	 {  // Sort a[] on leading W characters.
	      int N = a.length;
	      int R = 256;
	      String[] aux = new String[N];
	      for (int d = W-1; d >= 0; d--)
	      { // Sort by key-indexed counting on dth char.
	         int[] count = new int[R+1];     // Compute frequency counts.
	         for (int i = 0; i < N; i++)
	             count[a[i].charAt(d) + 1]++;
	         for (int r = 0; r < R; r++)     // Transform counts to indices.
	            count[r+1] += count[r];
	         for (int i = 0; i < N; i++)     // Distribute.
	            aux[count[a[i].charAt(d)]++] = a[i];
	         for (int i = 0; i < N; i++)     // Copy back.
	            a[i] = aux[i];
	      }
	  }
    
    
}

