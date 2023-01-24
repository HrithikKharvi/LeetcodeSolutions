class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> res = new ArrayList<>();

      if(intervals.length > 10000)return null;
        merge(intervals, 0, intervals.length);
        for(int[] mat : intervals){
          System.out.println(Arrays.toString(mat));
        }

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] arr : intervals){
          if(arr[0] <= end){
            end = Math.max(end, arr[1]);
          }else{
            res.add(new int[]{start, end});
            start = arr[0];
            end = arr[1];
          }
        }

        res.add(new int[]{start, end});

        return res.toArray(new int[0][]);
    }

    public void merge(int[][] mat, int start, int end){
      if(end - start < 2)return;

      int mid = (start + end) /2;
      merge(mat, start, mid);
      merge(mat, mid, end);
      sort(mat, start, end, mid);
    }

    public void sort(int[][] mat, int start, int end, int mid){
      int i=start;
      int j = mid;
      int tempIndex = 0;
      int[][] temp = new int[mat.length][mat[0].length];

      while(i < mid && j < end){
        temp[tempIndex++] = mat[i][0] < mat[j][0] ? mat[i++] : mat[j++]; 
      }

      System.arraycopy(mat, i, mat, start+tempIndex, mid - i);
      System.arraycopy(temp, 0, mat, start, tempIndex);
    }

}
