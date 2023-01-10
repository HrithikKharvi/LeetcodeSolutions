class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

      for(int i=0; i< matrix.length; i++){
        
        if(binarySearch(matrix, target, i))return true;
      }
        return false;
    }

    public boolean binarySearch(int[][] matrix, int searchNumber, int i){
      int start = 0;
      int[] currentArray = matrix[i];
      int end = currentArray.length;

      while(start < end){
        int mid = (start + end) /2;
        System.out.println(mid);
        System.out.println(mid);

        if(currentArray[mid] == searchNumber){
          return true;
        }else if(currentArray[mid] > searchNumber){
          end = mid;
        }else{
          start = mid+1;
        }
      }

      return false;
    }
}
