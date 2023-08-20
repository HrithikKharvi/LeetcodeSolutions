class Solution {
    public int hIndex(int[] citations) {
     int cited = 0;
     for(int i=0; i<citations.length; i++)if(citations[i] > 0)cited++;

     while(cited > 0){

       int count = 0;
      for(int i=0; i<citations.length; i++){
        if(citations[i] >= cited)count++;
      }

      if(count >= cited)return cited;
       cited--;
     }   

     return 0;
    }
}
