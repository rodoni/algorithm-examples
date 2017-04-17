package exercices;

import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;

public class RandomizedQueue<Item> implements Iterable<Item>{
	
    private Item[] node;
    private int N;
    
	 // construct an empty randomized queue
	 public RandomizedQueue(){
		   node = (Item[]) new Object[2];
		   N=0;
	 }
	   
	   // is the queue empty?
	public boolean isEmpty(){
	    return N == 0;
		   
	}
	   
	   // return the number of items on the queue   
	public int size(){                    
		   return N;
	}
	   
	private void resize(int max){
	    Item[] temp = (Item[]) new Object[max];
	    
	    for(int i=0; i<N ; i++){
	        temp[i] = node[i];
	    }
	    node=temp;
	}
	// add the item
	public void enqueue(Item item){
	        
	    if(item == null) throw new NullPointerException();
	    
	    if(N == node.length)
	        resize(node.length *2);
	    
	    node[N++] = item;
	        
	}
	   
	//remove and return a random item
	public Item dequeue(){
	
	    if(N == 0)
	        throw new NoSuchElementException();
	    int index = (int)(StdRandom.uniform(N));
	    Item temp = node[index];
	    
	    if(index != N -1)
	        node[index] = node[N-1];
	    N--;
	    
	    if(N >= 0 && N == node.length/4)
	        resize(node.length/2);
	    
	    return temp;
	    
	}
	   
	 // return (but do not remove) a random item
	 public Item sample(){
	     
	     if(N == 0) throw new NoSuchElementException();
	     
	     int index = (int)(StdRandom.uniform(N));
	     return node[index];
	     
	 }
	   
	   // return an independent iterator over items in random order
	 @Override
	 public Iterator<Item> iterator(){
	     
	     return new ReverseArrayIterator();
	       
	 }
	   
	 private class ReverseArrayIterator implements Iterator<Item> {
	     
	     private int index = 0;
	     private Item[] r;
	     public ReverseArrayIterator() {
	         r = (Item[]) new Object[N];
	         for(int i=0; i<N; i++)
	             r[i] = node[i];
	         StdRandom.shuffle(r);
	     }
	     public boolean hasNext() {
	         return index < N;
	     }
	     public void remove() {
	         throw new java.lang.UnsupportedOperationException();
	     }
	     public Item next() {
	         if (!hasNext()) throw new java.util.NoSuchElementException();
	         Item item = r[index++];
	         return item;
	     }
	     }
	   // unit testing
	    public static void main(String[] args) {   // unit testing
	        RandomizedQueue<String> deque = new RandomizedQueue<String> ();
	        deque.enqueue("aa");
	        deque.enqueue("bb");
	        deque.enqueue("cc");
	        deque.enqueue("dd");
	        deque.dequeue();
	        deque.dequeue();
	        deque.dequeue();
	        deque.dequeue();
	        //deque.dequeue();
	        StdOut.print("size:"+deque.size());
	     }
}
