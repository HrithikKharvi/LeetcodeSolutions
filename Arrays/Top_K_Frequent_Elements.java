class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;

        for(int i=0; i< nums.length; i++){
          if(map.containsKey(nums[i])){
            map.put(nums[i], map.get(nums[i]) + 1);
          }else{
            map.put(nums[i], 1);
          }
        }

        int[] result;
        if(map.size() < k){
          result = new int[map.size()];
        }else{
          result = new int[k];
        }

        Pair<Integer, Integer>[] list = new Pair[map.size()];

        count = 0;
        for(Map.Entry<Integer, Integer> item : map.entrySet()){
          int key = item.getKey();
          int value = item.getValue();
          list[count++] = new Pair(key, value);
        }

        sortList(list, 0, list.length);

        count = 0;
        for(Pair p : list){
          result[count++] = (int)p.getKey();
          if(count >= result.length)return result;
        }

        return result;     
    }


  public void sortList(Pair<Integer,Integer>[] list, int start, int end){
    if((end-start) <2)return;

    int mid = (start + end) /2;
    sortList(list, start, mid);
    sortList(list, mid, end);
    merge(list, start, mid, end);
  }

  public void merge(Pair<Integer, Integer>[] list, int start, int mid, int end){
    int i = start;
    int j = mid;

    Pair<Integer, Integer>[] tempArray = new Pair[list.length];
    int temp = 0;

    while(i < mid && j < end){
      tempArray[temp++] = list[i].getValue() > list[j].getValue() ? list[i++] : list[j++];
    }

    System.arraycopy(list, i, list, temp+start, mid-i);
    System.arraycopy(tempArray, 0, list, start, temp);
  }

}
