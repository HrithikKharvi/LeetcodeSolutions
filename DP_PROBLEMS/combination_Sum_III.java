class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        findCombination(k, 1, 0, n, 0, new ArrayList<Integer>(), list);

        return list;
    }

    public void findCombination(int k, int currentNumber, int count, int target, int currentSum, ArrayList<Integer> currentList, List<List<Integer>> list){
      if(currentNumber > 9){
        if(currentSum == target && count == k){
            System.out.println(currentList);
          List<Integer> newList = new ArrayList<>();
          newList = (ArrayList) currentList.clone();
          list.add(newList);
        }
          return;
      }

      if(currentSum == target && count == k){
            System.out.println(currentList);
          List<Integer> newList = new ArrayList<>();
          newList = (ArrayList) currentList.clone();
          list.add(newList);
          return;
        }

      count++;
      currentSum += currentNumber;
      currentList.add(currentNumber);
      System.out.println(currentList);
      findCombination(k, currentNumber+1, count, target, currentSum, currentList, list);

      count--;
      currentSum -= currentNumber;
      currentList.remove(currentList.size() - 1);

      findCombination(k, currentNumber+1, count, target, currentSum, currentList, list);

    }

}
