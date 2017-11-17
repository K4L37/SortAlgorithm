package sortalgorithm;


import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SortMain {
	public static void main(String args[]) {	

		//PARAMETER INFORMATION
		String dataType = "AlphaNumeric";
		String sortBy = "Brand";
		String dataPoint = "100K";
		int numOfSampling = 5;
		
		String txtFile = "D:\\" + dataType + "_" + sortBy + "_" + dataPoint + ".txt";
		String sortedVal = sortBy;

		BufferedReader br = null;
        String line = "";
        Product[] products = null;
        Product prod = null;
        int i = 0;
        int samplCtr = 0;
		try
		{			
			br = new BufferedReader(new FileReader(txtFile));     
	        int lineCount = (int)Files.lines(Paths.get(txtFile)).count();
	        System.out.println("Sorting Qty: " + lineCount + " items");
	        products = new Product[lineCount]; 

	        while ((line = br.readLine()) != null) {	
	            String[] data = line.split(",");
	            prod = new Product(data[0],data[1],data[2], Integer.parseInt(data[3]));                       
	            products[i]=prod;
	            i++;
	        }        
	        
	        long startTime;
	        long stopTime;
	        long elapsedTime;	
	        Product[] prodUnsorted = null;
	        
	        long val1,val2,val3,val4,val5,val6,val7;
	        
	        //Initialize Sorting Class with added int parameters.
	        //1 == Sort by Integer, 2 == Sort by String.
	        int sortFlag = 2;  //<- set this to control switch flag. 	        
	        String strType = sortFlag == 1 ? "Integer" : "String";
	        
	        ArrayList<String> samples = new ArrayList<String>();
	        
	        for(int sampl=0; sampl < numOfSampling; sampl++) {

	        	samplCtr = sampl + 1;
		        //-----------------------------------------------------	
	        	System.out.println("\nSAMPLING [" + samplCtr + "]");

	        	//Quick Sorting
		        prodUnsorted = new Product[lineCount]; 
		        prodUnsorted = products.clone();	        
		        startTime = System.currentTimeMillis();	
		        System.out.println("Sorting Quick..");
		        QuickSort quickSort = new QuickSort(sortFlag);        
		        quickSort.sort(prodUnsorted); 
		        stopTime = System.currentTimeMillis();
		        elapsedTime = stopTime - startTime;	 
		        /*System.out.println("QUICK SORT");
		        System.out.println("------------------------");
		        System.out.println("BEG: " + startTime);
		        System.out.println("END: " + stopTime);
		        System.out.println("------------------------");
		        System.out.println("Elapsed: " + elapsedTime +"\n" ); */	        
		        val1=elapsedTime;
	    
		        //Merge Sorting
		        prodUnsorted = new Product[lineCount]; 
		        prodUnsorted = products.clone();	
		        startTime = System.currentTimeMillis();	
		        System.out.println("Sorting Merge..");
		        MergeSort mergeSort = new MergeSort(sortFlag);
		        mergeSort.sort(prodUnsorted);      
		        stopTime = System.currentTimeMillis();
		        elapsedTime = stopTime - startTime;	 
		        /*System.out.println("MERGE SORT");
		        System.out.println("------------------------");
		        System.out.println("BEG: " + startTime);
		        System.out.println("END: " + stopTime);	        
		        System.out.println("------------------------");
		        System.out.println("Elapsed: " + elapsedTime +"\n");*/
		        val2=elapsedTime;
		        
		        //Heap Sorting
		        prodUnsorted = new Product[lineCount]; 
		        prodUnsorted = products.clone();
		        startTime = System.currentTimeMillis();	
		        System.out.println("Sorting Heap..");
		        HeapSort heapSort = new HeapSort(sortFlag);
		        heapSort.sort(prodUnsorted);      
		        stopTime = System.currentTimeMillis();
		        elapsedTime = stopTime - startTime;	 
		        /*System.out.println("HEAP SORT");
		        System.out.println("------------------------");
		        System.out.println("BEG: " + startTime);
		        System.out.println("END: " + stopTime);	        
		        System.out.println("------------------------");
		        System.out.println("Elapsed: " + elapsedTime +"\n");*/       
		        val3=elapsedTime;
		        
		        //Bubble Sorting
		        prodUnsorted = new Product[lineCount]; 
		        prodUnsorted = products.clone();
		        startTime = System.currentTimeMillis();	
		        System.out.println("Sorting Bubble..");
		        BubbleSort bubbleSort = new BubbleSort(sortFlag);
		        bubbleSort.sort(prodUnsorted);    
		        stopTime = System.currentTimeMillis();
		        elapsedTime = stopTime - startTime;	   
		        /*System.out.println("BUBBLE SORT");
		        System.out.println("------------------------");
		        System.out.println("BEG: " + startTime);
		        System.out.println("END: " + stopTime);	        
		        System.out.println("------------------------");
		        System.out.println("Elapsed: " + elapsedTime +"\n");*/
		        val4=elapsedTime;
		        
		        //Insertion Sorting
		        prodUnsorted = new Product[lineCount]; 
		        prodUnsorted = products.clone();
		        startTime = System.currentTimeMillis();	
		        System.out.println("Sorting Insert..");
		        InsertionSort insertSort = new InsertionSort(sortFlag);
		        insertSort.sort(prodUnsorted);    
		        stopTime = System.currentTimeMillis();
		        elapsedTime = stopTime - startTime;	   
		        /*System.out.println("INSERTION SORT");
		        System.out.println("------------------------");
		        System.out.println("BEG: " + startTime);
		        System.out.println("END: " + stopTime);	        
		        System.out.println("------------------------");
		        System.out.println("Elapsed: " + elapsedTime +"\n");*/
		        val5=elapsedTime;
		        
		        //Selection Sorting
		        prodUnsorted = new Product[lineCount]; 
		        prodUnsorted = products.clone();
		        startTime = System.currentTimeMillis();	
		        System.out.println("Sorting Select..");
		        SelectionSort selectSort = new SelectionSort(sortFlag);
		        selectSort.sort(prodUnsorted);      
		        stopTime = System.currentTimeMillis();
		        elapsedTime = stopTime - startTime;	   
		        /*System.out.println("SELECTION SORT");
		        System.out.println("------------------------");
		        System.out.println("BEG: " + startTime);
		        System.out.println("END: " + stopTime);	        
		        System.out.println("------------------------");
		        System.out.println("Elapsed: " + elapsedTime +"\n");*/      
		        val6=elapsedTime;
		        
		        //Radix Sorting	String      
		        prodUnsorted = new Product[lineCount]; 
		        prodUnsorted = products.clone();        
		        startTime = System.currentTimeMillis();	
		        System.out.println("Sorting Radix..");
		        RadixSort radixSort = new RadixSort(sortFlag);	        
		        radixSort.sort(prodUnsorted);
		        stopTime = System.currentTimeMillis();
		        elapsedTime = stopTime - startTime;	   
		        /*System.out.println("RADIX SORT");
		        System.out.println("------------------------");
		        System.out.println("BEG: " + startTime);
		        System.out.println("END: " + stopTime);	        
		        System.out.println("------------------------");
		        System.out.println("Elapsed: " + elapsedTime +"\n");*/      
		        val7=elapsedTime;
		        
		        //Show Data for counter checking
		        /*System.out.println("DATA: ");
		        for(Product p : prodUnsorted ){
		        	System.out.println(p.getName() + "," + p.getCategory() + "," +
		         				p.getBrand() + "," + p.getQty());
		        }*/ 
		        //System.out.println("DATA TYPE,SORTED COLUMN,DATA POINT,QUICK,MERGE,HEAP,BUBBLE,INSERTTION,SELECTION,RADIX");
		        //System.out.println("QUICK,MERGE,HEAP,BUBBLE,INSERTTION,SELECTION,RADIX");	        
		        /*System.out.println(strType + "," + "QUANTITY" + "," + lineCount + "," +  val1 + "," + val2 + "," +
		        		val3 + "," + val4 + "," + val5 + "," + val6 +  ","+ val7);*/
		        
		        samples.add(strType + "," + sortedVal + "," + dataPoint + "," +  val1 + "," + val2 + "," + val3 + "," + val4 + "," + val5 + "," + val6 +  ","+ val7);
	        }
	        //System.out.println( samples );
	        System.out.println("DATA TYPE,SORTED COLUMN,DATA POINT,QUICK,MERGE,HEAP,BUBBLE,INSERTTION,SELECTION,RADIX");

	        for (String n : samples )
	            System.out.println(n);

	        br.close();
		}
	    catch(Exception ex){
	    	System.out.println(ex.getCause());
	    } 
    }
}
