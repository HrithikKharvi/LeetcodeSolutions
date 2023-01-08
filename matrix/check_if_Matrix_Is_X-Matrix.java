/* RUNTIME:- BEATS 100% 
*  SPACE:- BEATS 84.23%
* time complexity:- m * n
* space complexity:- O(1)
*/
class Solution {
    public boolean checkXMatrix(int[][] grid) {
        // int i = 0;
        // int j = 0;
        // int k = 0;
        
       for(int i=0; i< grid.length; i++){
         for(int j=0; j< grid.length; j++){
           if(j == i || j == grid.length - i - 1){
             if(grid[i][j] == 0)return false;
           }else{
             if(grid[i][j] != 0)return false;
           }
         }
       }

        return true;
    }
}
