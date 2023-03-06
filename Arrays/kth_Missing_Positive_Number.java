class Solution {
    public int findKthPositive(int[] arr, int k) {
        int[] missing = new int[k];

       int count = 0;
       int index = 0;
       int number = 1;

       while(count < arr.length && index < k){
         if(arr[count] == number){
           number++;
           count++;
         }else{
           missing[index++] = number;
           number++;
         }
       }

      while(index < k){
        missing[index++] = number++;
      }

        return missing[k-1];
    }
}
