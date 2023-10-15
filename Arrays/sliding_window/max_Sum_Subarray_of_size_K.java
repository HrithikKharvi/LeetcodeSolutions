class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        long maxSum = 0;
        int i = 0;
        int j = 0;
        int count = 0;
        long currentSum = 0;
        
        while(i < N){
            count++;
            currentSum += (long) Arr.get(i);
            
            if(count == K){
                maxSum = maxSum > currentSum ? maxSum : currentSum;
                currentSum -= Arr.get(j);
                j++;
                i++;
                count--;
            }else{
                i++;
            }
        }
        
        return maxSum;
    }
}
