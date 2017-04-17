package algo;


public class MergeSort {
	
	private static int[] aux;
	
	
	public static void sort( int[] a ){
		
		aux = new int[a.length];
		sort(a,0,a.length -1);
		
	}

	private static void sort ( int[] array, int lower, int high){
		
		if( high <= lower) return;
		int mid = lower + (high - lower)/2;
		sort( array , lower , mid);
		sort( array , mid +1 , high);
		merge(array, lower, mid, high);
		
		
	}
	
	public static void merge( int[] array, int lower, int mid, int high)
	{
		int i = lower;
		int j = mid + 1;
		
		for( int k = lower; k <= high ; k ++)
			aux[k] = array[k];
				
		for( int k = lower; k <= high ; k++){
			
			if( i > mid)
				array[k] = aux[j++];
			else if ( j > high)
				array[k] = aux[i++];
			else if ( aux[j] < aux[i])
				array[k] = aux[j++];
			else
				array[k] = aux[i++];			
		}
		    System.out.println(" ");
	        System.out.print(i + " "+j+" ");
	        
	}
		
	
		
	
}
