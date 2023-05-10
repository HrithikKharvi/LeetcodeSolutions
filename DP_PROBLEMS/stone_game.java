class Solution {
    public boolean stoneGame(int[] piles) {
        boolean isAlice = true;

        int i = 0;
        int j = piles.length-1;

        int aSum = 0;
        int bSum = 0;

        while(i != j){
          if(piles[i] > piles[j]){
            if(isAlice){
              aSum += piles[i];
            }else{
              bSum += piles[i];
            }
            i++;
          }else{
             if(isAlice){
               aSum += piles[j];
            }else{
              bSum += piles[j];
            }

            j--;
          }
        }


        return aSum > bSum;
    }
}
