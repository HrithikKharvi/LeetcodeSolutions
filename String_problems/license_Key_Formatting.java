class Solution {
    public String licenseKeyFormatting(String s, int k) {
      s = s.replaceAll("-", "");
     int firstSetCount = s.length()%k;
     String finalString = "";
     System.out.println(s.length());

     for(int i=0; i< firstSetCount; i++){
       finalString += s.charAt(i);
     }

     int count = 0;
     String tempString = "";
     for(int i=firstSetCount; i< s.length(); i++){
       String currentString = "" + s.charAt(i);
       if(count == k){
         if(finalString == ""){
           finalString = tempString;
         }else{
           finalString += "-" + tempString;
         }
          tempString = currentString;
           count = 1;
       }else{
         count++;
         tempString += currentString;
       }
     }

     if(tempString.length() > 0){
       finalString += finalString.length() > 0 ? "-" + tempString : tempString;
     }

    return finalString.toUpperCase();

    }
}
