class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int count = 0;
        Arrays.sort(costs);
        for(int i=0; i< costs.length; i++){
          int currentElement = costs[i];
          System.out.println(currentElement);
          if(currentElement <= coins){
            coins -= currentElement;
            count++;
          }
        }

        return count;
    }
}
