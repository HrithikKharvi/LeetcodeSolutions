class Solution {
    public int kthFactor(int n, int k) {
        int counter = 0;

        int start = 1;

        while(start <= n){
          if(n % start == 0)counter++;
          if(counter == k)return start;
          start++;
        }

        return -1;
    }
}
