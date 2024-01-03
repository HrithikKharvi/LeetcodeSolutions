class Solution {
    public int numberOfBeams(String[] bank) {
        int m = bank.length;
        int n = bank[0].length();

        int start = -1;
        int end = -1;
        int tot = 0;

        for(int i=0; i<m; i++){
          int count = 0;
          for(int j=0; j<n; j++){
            char currentString = bank[i].charAt(j);
            if(currentString == '1')count++;
          }

          if(count > 0){
            if(start == -1){
              start = count;
            }else{
              end = start;
              start = count;
              tot += start * end;
            }
          }
        }

        return tot;

    }
}
