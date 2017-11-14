package sortalgorithm;

public class QuickSort {


    private int cnt;

    public void sort(Product[] values) {
        // check for empty or null array
        if (values ==null || values.length==0){
            return;
        }
        cnt = values.length;
        quicksort(values, 0, cnt - 1);     
        
    }

 int partition(Product arr[], int low, int high)
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


 void quicksort(Product arr[], int low, int high)
 {
     if (low < high)
     {
         /* pi is partitioning index, arr[pi] is 
           now at right place */
         int pi = partition(arr, low, high);

         // Recursively sort elements before
         // partition and after partition
         quicksort(arr, low, pi-1);
         quicksort(arr, pi+1, high);
     }
 }
}