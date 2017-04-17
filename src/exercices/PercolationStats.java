package exercices;

import edu.princeton.cs.algs4.StdRandom;

import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

import exercices.Percolation;

/* coursera course */

public class PercolationStats{
	
    private int experimentsCount;
    private Percolation pr;
    private double[] fractions;
    
    // perform T independent experiments on an N-by-N grid
	public PercolationStats(int N, int T){
		 	
		
	if (N <= 0 || T <= 0) {
	            throw new IllegalArgumentException("Given N <= 0 || T <= 0");
        }

        experimentsCount = T;
        fractions = new double[experimentsCount];
        for (int expNum = 0; expNum < experimentsCount; expNum++) {
            pr = new Percolation(N);
            int openedSites = 0;
            while (!pr.percolates()) {
                int i = StdRandom.uniform(1, N + 1);
                int j = StdRandom.uniform(1, N + 1);
                if (!pr.isOpen(i, j)) {
                    pr.open(i, j);
                    openedSites++;
                }
            }
            double fraction = (double) openedSites / (N * N);
            fractions[expNum] = fraction;
        }
	}
	
	   // sample mean of percolation threshold
	   public double mean(){
		   return StdStats.mean(fractions);
		   
	   }
	   
	   // sample standard deviation of percolation threshold
	   public double stddev(){
		   
		   return StdStats.stddev(fractions);
		   
	   }
	   
	   // low  endpoint of 95% confidence interval
	   public double confidenceLo(){
		   
		   return mean() - ((1.95*stddev())/ Math.sqrt(experimentsCount));
	   }
	   
	   // high endpoint of 95% confidence interval
	   public double confidenceHi(){
		   
		   return mean() + ((1.95*stddev())/ Math.sqrt(experimentsCount));
	   }

	   public static void main(String[] args){

     		int N = Integer.parseInt(args[0]);
	        int T = Integer.parseInt(args[1]);
	        PercolationStats ps = new PercolationStats(N, T);

	        String confidence = ps.confidenceLo() + ", " + ps.confidenceHi();
	        StdOut.println("mean                    = " + ps.mean());
	        StdOut.println("stddev                  = " + ps.stddev());
	        StdOut.println("95% confidence interval = " + confidence);
	   }

}
