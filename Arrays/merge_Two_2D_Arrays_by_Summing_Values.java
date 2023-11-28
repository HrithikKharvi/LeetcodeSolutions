class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<List<Integer>> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < nums1.length && j < nums2.length){

          int id1 = nums1[i][0];
          int id2 = nums2[j][0];

          if(id1 == id2){
            int sum = nums1[i][1] + nums2[j][1];
            List<Integer> arr = new ArrayList<>();
            arr.add(id1);
            arr.add(sum);
            result.add(arr);
            i++;
            j++;
          }else if(id1 < id2){
            List<Integer> arr = new ArrayList<>();
            arr.add(id1);
            arr.add(nums1[i][1]);
            result.add(arr);
            i++;
          }else{
            List<Integer> arr = new ArrayList<>();
            arr.add(id2);
            arr.add(nums2[j][1]);
            result.add(arr);
            j++;
          }
        }

        while(i < nums1.length){
          List<Integer> arr = new ArrayList<>();
          arr.add(nums1[i][0]);
          arr.add(nums1[i][1]);

          result.add(arr);
          i++;
        }

        while(j < nums2.length){

          List<Integer> arr = new ArrayList<>();

          arr.add(nums2[j][0]);
          arr.add(nums2[j][1]);

          result.add(arr);

          j++;
        }

        int[][] resultArray = new int[result.size()][2];

        for(int k=0; k<result.size(); k++){
          int[] arr = new int[2];
          arr[0] = result.get(k).get(0);
          arr[1] = result.get(k).get(1);
          resultArray[k] = arr;
        }

        return resultArray;

    }
}
