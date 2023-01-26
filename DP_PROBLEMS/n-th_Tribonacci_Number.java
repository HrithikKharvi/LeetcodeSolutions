class Solution {
    public int tribonacci(int n) {
        if(n <= 1)return n;
        int[] res = new int[n+1];

        res[0] = 0;
        res[1] = 1;
        res[2] = 1;
        int start = 0;
        int next = 1;
        int third = 2;

        for(int i=3; i<= n; i++){
          res[i] = res[start] + res[next] + res[third];

          start++;
          next++;
          third++;
        }

        return res[n];
    }
}
