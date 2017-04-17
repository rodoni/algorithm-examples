package exercices;


public class AmazonExercices {
    
    public int minimumRemovals( String s1, String s2){
       
        String lowerString = " ";
        String toCheckString  = " ";
        int removals = -1;
        
        /* get the higher String */
        if(s1.length() > s2.length()){
            lowerString = s1;
            toCheckString = s2;
            }
        else{
            lowerString = s2;
            toCheckString = s1;
        }
        /* strings is equal return 0*/
        if(s1.equals(s2))
            return 0;

        else{ 
            for( int i = 0; i <= lowerString.length() - 1; i++){
                char character = lowerString.charAt(i);
                int occurences = countOccurrences(toCheckString,character); 
                
                if(occurences > 0){
                    removals = occurences - 1;
                }
             
            }
            
        }
        
        
        
        return removals;
    }
    
    /* to count occurrences */
    public static int countOccurrences(String baseString, char character)
    {
        int count = 0;
        for (int i=0; i < baseString.length(); i++)
        {
            if (baseString.charAt(i) == character)
            {
                 count++;
            }
        }
        return count;
    }
    
    int bestProfit(int priceHistory[]) {
        
        int size = priceHistory.length;
        int bestProfit = 0;
        int sell = 0;
        int sellLastIndex = 0;
        int buy = 0;
        buy = priceHistory[0];
        
        for ( int i = 1 ; i < size - 1; i++){
        
            if(buy > priceHistory[i])
                buy = priceHistory[i];
            
            if((buy < priceHistory[i])&&(sell < priceHistory[i])&&(i>sellLastIndex)){
                sell = priceHistory[i];
                sellLastIndex = i;
            }
                
        }
        
        
        return bestProfit;
        
    }

}
