package exercices;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item>{

    
    private class node{
        
        Item item;
        node prev;
        node next;
        
    }
    private node first;
    private node last;
    private int N;
    
	//construct an empty deque
    public Deque(){
    
        N = 0;
        first = last = null;
		   
	}
	   
	// is the deque empty?
	public boolean isEmpty(){
	
	    return N==0;
	}
	   
	//return the number of items on the deque
    public int size(){
	
        return N;
	}
	   
	//add the item to the front
	public void addFirst(Item item){
	
	    if(item == null) throw new NullPointerException();
	    
	    node oldfirst = first;
	    first = new node();
	    first.item = item;
	    first.next = oldfirst;
	    
	    if(isEmpty()) last = first;
	    else
	        oldfirst.prev = first;
	
	    N++;
	}
	
	// add the item to the end
	public void addLast(Item item) 
	{
	    if(item == null) throw new NullPointerException();
		   
	    node oldlast = last;
	    last = new node();
	    last.item = item;
	    last.prev = oldlast;
	    if(isEmpty()) last=first;
	    else
	        oldlast.next = last;
	    
	    N++;
	    
	   }
	   // remove and return the item from the front
	   public Item removeFirst()  {
		 
	       if(isEmpty())
		      throw new NoSuchElementException();
	       
	       Item item = first.item;
	       first =  first.next;
	       N--;
	       if(isEmpty())
	           last = null;
	       else
	           first.prev = null;
	       
	       return item;
	   }
	   
	   // remove and return the item from the end
	   public Item removeLast(){
	       
	       if(isEmpty())
	           throw new NoSuchElementException();
	       
	       Item item = last.item;
	       last = last.prev;
	       N--;
	       if(isEmpty())
	           first = null;
	       else
	           last.next = null;
	       
	       return item;
		   
	   }
	   
	   private class ListIterator implements Iterator<Item>{

	       private node current = first;
	     
	       @Override
	       public boolean hasNext() {
	           return current != null;
	       }

	       @Override
	       public Item next() {
	           if(!hasNext()){
	               throw new NoSuchElementException();
	           }
            
	           Item item = current.item;
	           current = current.next;
	           return item;
	       }

	       @Override
	       public void remove() {
	           throw new UnsupportedOperationException();
            
	       }
	       
	   }
	   
	   // return an iterator over items in order from front to end
	   public Iterator<Item> iterator(){
	     return new ListIterator();
	   }
	   
	   // unit testing
	   public static void main(String[] args){
	       
	       Deque<String> deque = new Deque<String> ();
	       deque.addFirst("aa");
	       deque.addFirst("bb");
	       deque.addFirst("cc");
	       deque.addLast("dd");
	       StdOut.println(deque.removeFirst());
	       StdOut.println(deque.removeFirst());
	       StdOut.println(deque.removeFirst());
	       StdOut.println(deque.removeLast());
	       StdOut.print("size:"+deque.size());
	   }
	   
}
