class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int i = 0;
        int j = 0;
        while(i<arr.length && j < arr.length){
          int twoTimes = arr[i] * 2;
          
          if(arr[j] == twoTimes && i != j)return true;
          if(i == j && twoTimes == 0){
            j++;
          }
          if(arr[j] < twoTimes)j++;
          else if(arr[j] > twoTimes)i++;
        }

        return false;
    }
}
