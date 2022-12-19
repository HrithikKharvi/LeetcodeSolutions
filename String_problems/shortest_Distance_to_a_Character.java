class Solution {
    public int[] shortestToChar(String s, char c) {
     int[] result = new int[s.length()];

     for(int i=0; i<result.length; i++){
         if(s.charAt(i) == c){
             result[i] = 0;
             continue;
         }
         int pointer1 = i-1;
         int pointer2 = i+1;
         int leftMin = Integer.MAX_VALUE;
         int rightMin = Integer.MAX_VALUE;
        while(pointer1>= 0 || pointer2 < s.length()){
            if(pointer1 >= 0){
                if(s.charAt(pointer1) == c){
                    leftMin = pointer1;
                    pointer1 = -1;
                }
               
            }

            if(pointer2 < s.length()){
                if(s.charAt(pointer2) == c){
                    rightMin = pointer2;
                    pointer2 = s.length();
                }
                
            }

             pointer1--;
             pointer2++;
        }
        leftMin = Math.abs(i - leftMin);
        rightMin = Math.abs(i - rightMin);
        result[i] = (leftMin < rightMin ? leftMin : rightMin);

     }

     return result;
    }
}
