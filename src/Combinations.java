import java.util.ArrayList;
import java.util.Arrays;

public class Combinations {
public static 	ArrayList<Character[]> list = new ArrayList<Character[]>();
public static ArrayList<int[]> allCombinations =new ArrayList<int[]>();
	public static void findCombinationsUtil(int arr[], int index,int num, int reducedNum) 
	{ 	
	    // Base condition 
	    if (reducedNum < 0) 
	        return; 
	  
	    // If combination is  
	    // found, print it 
	    if (reducedNum == 0) 
	    {     Character[] combination = new Character[num];

	        for (int i = 0; i < index; i++) {
	               // System.out.print (arr[i] + " ");
	                combination[i]=(char) (arr[i]);
	                
	        }
	        Combinations.list.add(combination);
	            System.out.println(); 
	        return; 
	    } 
	  
	    // Find the previous number  
	    // stored in arr[]. It helps  
	    // in maintaining increasing  
	    // order 
	    int prev = (index == 0) ?  
	                          1 : arr[index - 1]; 
	  
	    // note loop starts from  
	    // previous number i.e. at 
	    // array location index - 1 
	    for (int k = prev; k <= num ; k++) 
	    { 
	        // next element of 
	        // array is k 
	        arr[index] = k; 
	  
	        // call recursively with 
	        // reduced number 
	        findCombinationsUtil(arr, index + 1, num,reducedNum - k); 
	    } 
	} 
	  
	/* Function to find out all  
	combinations of positive  
	numbers that add upto given 
	number. It uses findCombinationsUtil() */
	static ArrayList<Character[]> findCombinations(int n,int cities) 
	{  	ArrayList<Character[]> list = new ArrayList<Character[]>();

	    // array to store the combinations 
	    // It can contain max n elements 
	    int arr[] = new int [n]; 
	    int count=0;
	    // find all combinations 
	    findCombinationsUtil(arr, 0, n, n); 
	    for(int i=0;i<Combinations.list.size();i++)
	    {	 
	    	count=0;
	    	
	    	
	    		 if(cities>=n) {
	    			 Character[] combination = new Character [cities];
	    			 for(int j=0;j<n;j++) {
	    			 if(Combinations.list.get(i)[j]!= null)
	    			 {
	    				 combination[j]=Combinations.list.get(i)[j];
	    			 }else {
	    				 combination[j]=0;
	    			 }
	    			 
	    		 }
	    		    	list.add(combination);

	    		 }
	    		 else {
	    			 
	    			 for(int k=0;k<n;k++) {
	    				 if(Combinations.list.get(i)[k]!=null)
	    					 {count++;}
	    				 
	    			 }
	    			 if(count>cities) {
	    				 continue;
	    			 }
	    			 Character[] combination = new Character[cities];
	    			 for(int j=0;j<cities;j++) {
	    				 combination[j]=Combinations.list.get(i)[j];
	    			 }
	    		    	list.add(combination);

	    			 
	    		 }
	    		 for(int i1=0;i1<list.size();i1++)
	    			 for(int j=0;j<cities;j++)
	    			 {
	    				 if(list.get(i1)[j]==null)
	    					 list.get(i1)[j]=0;
	    			 }
	    	
	    }
	    Combinations.list.clear();
	    return list;
	} 
	 public static boolean permuteLexically(int[] data) {
		    int k = data.length - 2;
		    while (data[k] >= data[k + 1]) {
		        k--;
		        if (k < 0) {
		            return false;
		        }
		    }
		    int l = data.length - 1;
		    while (data[k] >= data[l]) {
		        l--;
		    }
		    swap(data, k, l);
		    int length = data.length - (k + 1);
		    for (int i = 0; i < length / 2; i++) {
		        swap(data, k + 1 + i, data.length - i - 1);
		    }
		   
		    return true;
		}
		 private static void swap(int[] data, int k, int l) {
				data[k]=data[k]+data[l];
				data[l]=data[k]-data[l];
				data[k]=data[k]-data[l];
			}
		 public static ArrayList<int[]> run(int armies,int cities){
			 ArrayList<Character[]> list=Combinations.findCombinations(armies, cities);
			 
			 
			 for(int i=0;i<list.size();i++)
			 {

				 int[] data = new int[cities];
					for(int j=0;j<cities;j++)
					{
						data[j]=(int)list.get(i)[j];
						//System.out.print(data[j]+" ");
					}
					
					 Arrays.sort(data);
					    do {
					    	
					    	
					    	
					    	//System.out.println(Arrays.toString(data));
					    	int []x=new int [cities];

					    	for(int j=0;j<cities;j++)
							{
								
					    		x[j]=data[j];
							}
					    	//System.out.println();
					        allCombinations.add(x);
			    		} while(Combinations.permuteLexically(data));
				 
			 }
			 
			 
			 
			 
			 
			 
			 
			 
			 return allCombinations;
		 }

}
