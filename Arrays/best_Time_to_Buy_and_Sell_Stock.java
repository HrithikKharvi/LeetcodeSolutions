/* BEST APPROCH FOR SOLVING THIS PROBLEM WITH O(N) TIME AND SPACE COMPLEXITY
*CREATE THE ARRAY TO STORE THE MINIMUM VALUE IN THE LEFT FOR THAT INDEX
*LOOP THROUGH THE ARRAY AND IF THE MINIMUM VALUE FOR THAT INDEX IS LESS THAN THE VALUE AT THAT POSITION AT ORIGINAL ARRAY CHECK AND UPDATE THE MINIMUM VALUE
*/

class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int[] visited = new int[prices.length];
        if(prices.length < 2)return 0;

        visited[0] = Integer.MAX_VALUE;
        for(int i=1; i<prices.length; i++){
          min = Math.min(min, prices[i-1]);
          visited[i] = min;
        }

        int max = 0;
        System.out.println(Arrays.toString(visited));

        for(int i=0; i< prices.length; i++){
          if(visited[i] < prices[i])max = Math.max(max, (prices[i] - visited[i]));
        }

        return max;
    }
}
