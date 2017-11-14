package sortalgorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SortMain {
    public static void main(String args[]) {	

        //FILE DATA - NEED TO HARD_CODE \\PATH\FILE (NO TIME)
        
    	String txtFile = "D:\\Sort_By_Brand_100K.txt";                      //FOR PC-WINDOWS
        //String txtFile = "/Users/Clark/Desktop/record.txt";   //FOR MAC

        BufferedReader br = null;
        String line = "";
        
        //INVENTORY DATA MODEL
        Product[] products = null;
        Product prod = null;
        
        int i = 0;
    
        try
        {
            
            /*
             * READ FILE DATA SOURCE
            */
                        
            br = new BufferedReader(new FileReader(txtFile));     
            int lineCount = (int)Files.lines(Paths.get(txtFile)).count();
            System.out.println("Sorting: " + lineCount + " items\n");
            products = new Product[lineCount]; 

            while ((line = br.readLine()) != null) {	
                String[] data = line.split(",");
                prod = new Product(data[0],data[1],data[2], Integer.parseInt(data[3]));                       
                products[i]=prod;
                i++;
            }        

            //INITIALIZED TIMER
            long startTime;
            long stopTime;
            //long elapsedTime;	
            
            long quickTime;
            long mergeTime;
            long heapTime;
            long bubbleTime;
            long insertTime;
            long selectTime;
            long radixTime;


            /*
             * QUICK SORT
            */

            startTime = System.currentTimeMillis();	

            //PREFORM SORTING
            QuickSort quickSort = new QuickSort();
            quickSort.sort(products); 

            stopTime = System.currentTimeMillis();
            quickTime = stopTime - startTime;	 

            System.out.println("QUICK SORT");
            System.out.println("------------------");
            System.out.println("BEG: " + startTime);
            System.out.println("END: " + stopTime);
            System.out.println("------------------");
            System.out.println("Time Spent: " + quickTime +" milliseconds\n\n" );
            
            
            
            // DISPLAY DATA - ACTIVATE IF YOU NEED TO SHOW/CHECK SORTING 
            // YOU'LL HAVE TO MOVE THIS UNDER/AFTER EACH SORTING ALGORITHM
            /*
            System.out.println("DATA: ");
            for(Product p : products ){	
            	System.out.println(p.getName() + "," + p.getCategory() + "," +
             				p.getBrand() + "," + p.getQty());
            }
            */


            /*
             * MERGE SORT
            */

            mergeTime = System.currentTimeMillis();	
            
            //PREFORM SORTING
            MergeSort mergeSort = new MergeSort();
            mergeSort.sort(products);      
            
            stopTime = System.currentTimeMillis();
            mergeTime = stopTime - startTime;	 
            
            System.out.println("MERGE SORT");
            System.out.println("------------------");
            System.out.println("BEG: " + startTime);
            System.out.println("END: " + stopTime);	        
            System.out.println("------------------");
            System.out.println("Time Spent: " + mergeTime +" milliseconds\n");
            
            
            /*
             * HEAP SORT
            */
            
            heapTime = System.currentTimeMillis();	
            
            //PREFORM SORTING
            HeapSort heapSort = new HeapSort();
            heapSort.sort(products);      
            
            stopTime = System.currentTimeMillis();
            heapTime = stopTime - startTime;	 
            
            System.out.println("HEAP SORT");
            System.out.println("------------------");
            System.out.println("BEG: " + startTime);
            System.out.println("END: " + stopTime);	        
            System.out.println("------------------");
            System.out.println("Time Spent: " + heapTime +" milliseconds\n");


            /*
             * BUBBLE SORT
            */
            
            bubbleTime = System.currentTimeMillis();	
            
            //PREFORM SORTING
            BubbleSort bubbleSort = new BubbleSort();
            bubbleSort.sort(products);    
            
            stopTime = System.currentTimeMillis();
            bubbleTime = stopTime - startTime;	   
            
            System.out.println("BUBBLE SORT");
            System.out.println("------------------");
            System.out.println("BEG: " + startTime);
            System.out.println("END: " + stopTime);	        
            System.out.println("------------------");
            System.out.println("Time Spent: " + bubbleTime +" milliseconds\n");        

            
            /*
             * INSERTION SORT
            */
            
            startTime = System.currentTimeMillis();	
            
            //PREFORM SORTING
            InsertionSort insertSort = new InsertionSort();
            insertSort.sort(products);    

            stopTime = System.currentTimeMillis();
            insertTime = stopTime - startTime;	   

            System.out.println("INSERTION SORT");
            System.out.println("------------------");
            System.out.println("BEG: " + startTime);
            System.out.println("END: " + stopTime);	        
            System.out.println("------------------");
            System.out.println("Time Spent: " + insertTime +" milliseconds\n");   

            
            /*
             * SELECTION SORT
            */
                        
            startTime = System.currentTimeMillis();	
            
            //PREFORM SORTING
            SelectionSort selectSort = new SelectionSort();
            selectSort.sort(products);      
            
            stopTime = System.currentTimeMillis();
            selectTime = stopTime - startTime;	   
            
            System.out.println("SELECTION SORT");
            System.out.println("------------------");
            System.out.println("BEG: " + startTime);
            System.out.println("END: " + stopTime);	        
            System.out.println("------------------");
            System.out.println("Time Spent: " + selectTime +" milliseconds\n");

            
            /*
             * RADIX SORT
            */
                        
            startTime = System.currentTimeMillis();	
            
            //PREFORM SORTING
            RadixSort radixSort = new RadixSort();
            radixSort.sort(products, lineCount);	        
            
            stopTime = System.currentTimeMillis();
            radixTime = stopTime - startTime;	   
            
            System.out.println("RADIX SORT");
            System.out.println("------------------");
            System.out.println("BEG: " + startTime);
            System.out.println("END: " + stopTime);	        
            System.out.println("------------------");
            System.out.println("Time Spent: " + radixTime +" milliseconds\n");
            
            System.out.println(txtFile);
            System.out.println("1,Quick Sort,"  + quickTime );
            System.out.println("2,Merge Sort, "  + mergeTime  );
            System.out.println("3,Heap Sort," +  heapTime  );
            System.out.println("4,Bubble Sort," +  bubbleTime  );
            System.out.println("5,Insertion Sort," + insertTime  );
            System.out.println("6,Selection Sort," +  selectTime  );
            System.out.println("7,Radix Sort, " +  radixTime  );
            
            /*System.out.println("Quick Sort," + startTime + "," +  stopTime + "," + quickTime );
            System.out.println("Merge Sort, " + startTime + "," +  stopTime + "," + mergeTime  );
            System.out.println("Heap Sort," + startTime + "," +  stopTime + "," + heapTime  );
            System.out.println("Bubble Sort," + startTime + "," +  stopTime + "," + bubbleTime  );
            System.out.println("Insertion Sort," + startTime + "," +  stopTime + "," + insertTime  );
            System.out.println("Selection Sort," + startTime + "," +  stopTime + "," + selectTime  );
            System.out.println("Radix Sort, " + startTime + "," +  stopTime + "," + radixTime  );*/
            
            br.close();
            
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
