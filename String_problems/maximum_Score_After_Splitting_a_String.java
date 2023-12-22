class Solution {
    public int maxScore(String s) {
        int oneCount = 0;
        int maxCount = 0;
        int zeroCount = 0;

        for(int i=0; i< s.length(); i++)if(s.charAt(i) == '1')oneCount++;

        for(int i=0; i<s.length()-1; i++)if(s.charAt(i) == '0'){
          zeroCount++;
          maxCount = Math.max(maxCount, zeroCount+oneCount);
        }else{
          oneCount--;
          maxCount = Math.max(maxCount, zeroCount+oneCount);
        }

        return maxCount;
    }
}
