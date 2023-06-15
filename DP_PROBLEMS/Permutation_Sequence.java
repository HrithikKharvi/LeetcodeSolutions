class Solution {
    public String getPermutation(int n, int k) {
        int facValue = factorialOf(n);
        if(n == 1)return ""+n;

        int[] nums = new int[n];
        for(int i=1; i<=n; i++){
          nums[i-1] = i;
        }


        int countForEach = facValue / n;
        int index =  (k / countForEach);

        if(k % countForEach == 0) index--;

        List<List<Integer>> resultArray =  new ArrayList<>();
        int[] visited = new int[n];
        visited[index] = 1;

        List<Integer> currentList = new ArrayList<>();
        currentList.add(nums[index]);
        findPerms(index, nums, 1, currentList, resultArray, visited);

        int actualIndex = k - (countForEach * index);
        List<Integer> finalList = resultArray.get(actualIndex-1);

        String resultString = "";
        for(int i : finalList){
          resultString += i;
        }

        return resultString;
    }

    public void findPerms(int index, int[] nums, int count, List<Integer> currentList, List<List<Integer>> resultArray, int[] visited){
      if(count >= nums.length){
        List<Integer> newList = new ArrayList<>();
        newList.addAll(currentList);
        resultArray.add(newList);
        return;
      }

      for(int i=0; i<nums.length; i++){
        if(visited[i] == 1)continue;
        visited[i] = 1;
        currentList.add(nums[i]);
        findPerms(i, nums, count+1, currentList, resultArray, visited);
        currentList.remove(currentList.size() - 1);
        visited[i] = 0;
      }
    }

    public int factorialOf(int n){
      int product = 1;

      while(n > 0){
        product *= n;
        n--;
      }

      return product;
    }
}
