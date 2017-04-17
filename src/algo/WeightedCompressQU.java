package algo;

public class WeightedCompressQU {
    
    
	private int[] id;
	private int[] sizeRoot;
	private int count = 0;
	
	public WeightedCompressQU( int N){
		
		count=N;
		
		id = new int[N];
		for (int i = 0; i < N ; i++)
			id[i] = i;
		
		sizeRoot = new int[N];
		for( int i = 0; i<N ;i++)
			sizeRoot[i] = 1;
		
	}
	
	public void union( int p, int q) {
		
		int i = find(p);
		int j = find(q);
		
		if( i == j ) return;
		
		if(sizeRoot[i] < sizeRoot[j])
		{
			
			id[i] = j;
			sizeRoot[j] += sizeRoot[i];
		}
		else
		{
			id[j] = i;
			sizeRoot[i] += sizeRoot[j];
		}
		
		count --;
	}
	
	public int find( int p){
		
		while (p != id[p]) 
		{
			id[p] = id[id[p]];
			p= id[p];
		}
		return p;
		
	}
	
	public boolean connected( int p , int q){
		
		return find(p) == find(q);
	}
	
	int count(){
		
		return count;
	}
}
