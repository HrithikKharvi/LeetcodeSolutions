class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

      int[] result = new int[arr1.length];
      Map<Integer, Integer> map = new HashMap<>();

      int end = arr1.length-1;
      int count = 0;

        for(int i=0; i< arr1.length; i++){
          boolean isPresent = false;
          for(int j=0; j<arr2.length; j++){
            if(arr2[j] == arr1[i]){
              isPresent = true;
              break;
            }
          }
          if(!isPresent){
            result[end - count++] = arr1[i];
          }else{
            if(map.containsKey(arr1[i])){
              map.put(arr1[i], map.get(arr1[i])+1);
            }else{
              map.put(arr1[i], 1);
            }
          }
        }

        int pointer = 0;
        int breaker = count;
        for(int i=0; i<arr2.length; i++){
          count = map.get(arr2[i]);

          while(count > 0){
            result[pointer++] = arr2[i];
            count--;
          }
        }

      merge(result, result.length - breaker, result.length);

      return result;
    }

    public void merge(int[] arr, int start, int end){
      if((end-start) < 2)return;

      int mid = (start + end) /2;

      merge(arr, start, mid);
      merge(arr, mid, end);

      sort(arr, start, mid, end);
    }

    public void sort(int[] arr, int start, int mid, int end){
      if(arr[mid-1] < arr[mid])return;

      int i = start;
      int j = mid;

      int[] tempArray = new int[arr.length];
      int tempIndex = 0;

      while(i < mid && j < end){
        tempArray[tempIndex++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
      }

      int counter = 0;
      for(int k=i; k<mid; k++){
        arr[start + tempIndex + counter] = arr[k];
        counter++;
      }

      for(int k=0; k<tempIndex; k++){
        arr[start + k] = tempArray[k];
      }

    }
}
