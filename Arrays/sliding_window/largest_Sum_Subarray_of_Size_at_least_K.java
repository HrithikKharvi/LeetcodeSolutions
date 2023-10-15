//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Compute obj = new Compute();
            System.out.println(obj.maxSumWithK(a, n, k));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long maxSumWithK(long a[], long n, long k)
    {
        long[] sumArray = new long[a.length];
        int[] maxArray = new int[a.length];
    
        
        long sum = 0;
        
        for(int i=0; i<n; i++){
            sum += a[i];
            
            sumArray[i] = sum;
        }
        
        int maxIndex = Integer.MIN_VALUE;
        int N = a.length;
        
        maxArray[N-1] = N-1;
        
        for(int i=N-2; i>=0; i--){
            if(i == N-2){
                maxIndex = sumArray[i] >= sumArray[i+1] ? i : i+1;
                maxArray[i] = maxIndex;
            }else{
                maxIndex = sumArray[maxIndex] >= sumArray[i] ? maxIndex : i;
                maxArray[i] = maxIndex;
            }
        }
        long maxSum = Integer.MIN_VALUE;
        long currentSum = 0;
        
        
        for(int i=0; i<= N-((int) k); i++){
            int ind = maxArray[i + ((int)k) - 1];
            
            if((ind-i+1) >= k){
                long tot = sumArray[ind] - currentSum;
                maxSum = tot > maxSum ? tot : maxSum;
            }
            
            currentSum += a[i];
        }
        
        return maxSum;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
