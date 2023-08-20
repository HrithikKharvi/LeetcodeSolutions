class Solution {
    public int hIndex(int[] citations) {
     int cited = 0;
     for(int i=0; i<citations.length; i++)if(citations[i] > 0)cited++;

     Arrays.sort(citations);

     int count = 0;
     int i = citations.length-1;
     while(i >= 0){
       if(citations[i] < cited){
         if(count >= cited)return cited;
         cited--;
       }else{
         count++;
         i--;
       }
     }

     return cited;
    }
}
