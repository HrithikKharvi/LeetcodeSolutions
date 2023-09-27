class Solution {
    public boolean isPowerOfFour(int n) {
        int i = 0;

        while(true){
          if(Math.pow(4, i) > n) break;
          if(Math.pow(4, i) == n)return true;

          i++;
        }

        return false;
    }
}
