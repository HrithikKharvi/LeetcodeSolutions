class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int[] ans = new int[k];
        Arrays.sort(arr);
        int median = arr[(arr.length-1)/2];

        int i = 0;
        int j = arr.length-1;
        int count = 0;
        while(i <= j){
          if(Math.abs(arr[i] - median) > Math.abs(arr[j] - median)){
            ans[count++] = arr[i++];
          }else{
            ans[count++] = arr[j--];
          }
          if(count == k)break;
        }

        return ans;
    }
}
