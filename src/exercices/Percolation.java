



import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/* coursera course */

public class Percolation {
	
	private boolean[][] opened;
	private int top = 0;
	private int bottom;
	private int size;
	private WeightedQuickUnionUF qf;
	
	       // create N-by-N grid, with all sites blocked
		   public Percolation(int N){
			   size = N;
			   bottom = size*size+1;
			   qf = new WeightedQuickUnionUF(size*size + 2);
			   opened = new boolean[size][size];	
			   qf.union(top, bottom);
		   }
		   
		   // open site (row i, column j) if it is not open already
		   public void open(int i, int j){
			   
			   opened[i -1][j -1] = true;
		  
			   if(i == 1){
				   qf.union(getQFindex(i,j), top);
			   }
			   
			   if(j > 1 && isOpen(i,j-1)){
				   qf.union(getQFindex(i, j), getQFindex(i,j - 1));
			   }
			   
			   if( j < size && isOpen(i, j + 1)){
				   qf.union(getQFindex(i, j), getQFindex(i,j+1));
			   }
			   
			   if( i > 1 && isOpen(i -1, j)){
				   qf.union(getQFindex(i, j), getQFindex(i - 1, j));
			   }
			   
			   if( i < size && isOpen(i + 1 , j)){
				   qf.union(getQFindex(i, j), getQFindex(i+1, j));
			   }
		   }
		   
		   // is site (row i, column j) open?
		   public boolean isOpen( int i, int j){
			   
			   return opened[i-1][j-1];
		   }
	
		   
		   public boolean isFull(int i, int j){
			  
			   if(0<i&&i<=size&&0<j&&j<=size)
				   return  qf.connected(top, getQFindex(i,j));
			   else{
				   throw new IndexOutOfBoundsException();
			   }
			   
		   }
		   
		   // does the system percolate?
		   public boolean percolates(){
		       
			   return qf.connected(top, bottom);
		   }
		  

		
		   private int getQFindex(int i , int j){
			   return size*(i-1)+j;
		   }

}
