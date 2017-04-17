package algo;


public class WeightedQuickUnion {
	private int[] id;
	private int[] sizeRoot;
	private int count = 0;
	private int count2 = 0;
	
	public WeightedQuickUnion( int N){
		
		count=N;
		count2= N;
		
		id = new int[N];
		for (int i = 0; i < N ; i++)
			id[i] = i;
		
		sizeRoot = new int[N];
		for( int i = 0; i<N ;i++)
			sizeRoot[i] = 1;
		
	}
	
    public int getNumberNodes( int root)
    {
    	int numberOfNodes = 0;
    	for ( int i = 0; i<count2; i++)
    	{
    		if(id[i] == root)
    		numberOfNodes++;
    	}
    	
    	return numberOfNodes;
    }
	
	public void union( int p, int q ) {
		
		int i = find(p);
		int j = find(q);
		
		if( i == j ) 
			return;
		
		 
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
	
		/*
		if(getNumberNodes(i) < getNumberNodes(j))
		{
			id[i] = j;
		}
		else
		{
			id[j] = i;
		}*/
		
		count --;
	}
	
	public int find( int p){
		
		while (p != id[p]) p = id[p];
		return p;
		
		//return id[p];
	}
	
	boolean connected( int p , int q){
		
		return find(p) == find(q);
	}
	
	int count(){
		
		return count;
	}
}
