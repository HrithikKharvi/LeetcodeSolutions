class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        formCombination(0, 1, n, k, result, new ArrayList<>());

        return result;
    }

    public void formCombination(int count, int n, int target, int k, List<List<Integer>> result, List<Integer> currentList){
      if(n > target || count == k){
        if(count != k)return;
        List<Integer> newList = new ArrayList<>();
        newList.addAll(currentList);
        result.add(newList);
        return;
      }

      currentList.add(n);

      formCombination(count+1, n+1, target, k, result, currentList);

      currentList.remove(currentList.size()-1);

      formCombination(count, n+1, target, k, result, currentList);
    }

}
