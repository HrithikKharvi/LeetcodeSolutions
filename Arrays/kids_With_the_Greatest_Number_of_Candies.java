class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;

        for(int i : candies){
          if(i > maxCandies)maxCandies = i;
        }

        List<Boolean> result = new ArrayList<>();

        for(int i : candies){
          if(i + extraCandies >= maxCandies)result.add(true);
          else result.add(false);
        }

        return result;
    }
}
