package tests;


import algo.QuickFind;
import algo.WeightedQuickUnion;

import java.util.Random;

import algo.MergeSort;



public class TestsAlgorithms {

	
	
	static MergeSort merge = new MergeSort();
	static QuickFind quickfind = new QuickFind(10);
	static WeightedQuickUnion quickunion = new WeightedQuickUnion(10);
    
	public static void main(String[] args){
		
		//Question 1 Coursera 
		quickfind.union(3, 9);
		quickfind.union(9, 4);
		quickfind.union(8, 6);
		quickfind.union(0, 4);
		quickfind.union(9, 1);
		quickfind.union(0, 5);
		
		System.out.println("Question 1: ");
		
		for ( int i = 0 ; i < 10 ; i++)
				System.out.print(quickfind.find(i)+" ");
		
		//Question 2 Coursera
		
		quickunion.union(6, 5);
		quickunion.union(2, 0);
		quickunion.union(3, 8);
		quickunion.union(6, 4);
		quickunion.union(4, 9);
		quickunion.union(6, 1);
		quickunion.union(2, 8);
		quickunion.union(1, 3);
		quickunion.union(9, 7);
		
		System.out.println("");
		System.out.println("Question 2: ");
		
		for ( int i = 0 ; i < 10 ; i++)
			System.out.print(quickunion.find(i)+" ");
		
		// Testing MergSort 
		 int[] a = new int[15];
		 for (int i = 1; i <= 15; i++)
		 {
		        a[i-1] = i;
		 }
		Random rg = new Random();
	    int tmp;
	    for (int i = 14; i > 0; i--)
	    {
	        int r = rg.nextInt(i+1);
	        tmp = a[r];
	        a[r] = a[i];
	        a[i] = tmp;
	    }
    	System.out.println("");
        System.out.println("Array:");
	    for (int i = 0; i < 15; i++)
	        System.out.print(a[i] + " ");
	    
	    MergeSort.sort(a);
	    System.out.println("");
	    for (int i = 0; i < 15; i++)
	        System.out.print(a[i] + " ");
				
	}
	
	
	

	
	
	
}
