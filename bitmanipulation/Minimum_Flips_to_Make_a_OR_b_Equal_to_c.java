
class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;

        int visitor = 1;
        int cVal = c;

        while(a != 0 && b != 0 && c != 0){
          int maskAValue = (a & visitor);
          int maskBValue = (b & visitor);
          int maskCValue = (c & visitor);


          if(maskCValue == 0){
            if(maskAValue != 0)count++;
            if(maskBValue != 0)count++;
          }else{
            if(maskAValue != 1 && maskBValue != 1){
              count++;
            }
          }
          a = a >> 1;
          b = b >> 1;
          c = c >> 1;
        }

        while(a != 0){
          int maskAValue = (a & visitor);
          int maskCValue = (c & visitor);
          if(maskCValue == 0){
            if(maskAValue != 0)count++;
          }else{
            if(maskAValue != 1){
              count++;
            }
          }
          a = a >> 1;
          c = c >> 1;
        }

        while(b != 0){
          int maskBValue = (b & visitor);
          int maskCValue = (c & visitor);
          if(maskCValue == 0){
            if(maskBValue != 0)count++;
          }else{
            if(maskBValue != 1){
              count++;
            }
          }
          b = b >> 1;
          c = c >> 1;
        }

         while(c != 0){
          int maskCValue = (c & visitor);
          if(maskCValue == 1){
            count++;
          }
          c = c >> 1;
        }

        return count;
    }
}
