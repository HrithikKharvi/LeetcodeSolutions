class Solution {
    public int findFinalValue(int[] nums, int original) {

       boolean isFound = true;

       while(isFound){
         isFound = false;

         for(int i=0; i< nums.length; i++){
           if(nums[i] == original){
             original = original * 2;
             isFound = true;
             break;
           }
         }
       } 
       
        return original;
    }
}
