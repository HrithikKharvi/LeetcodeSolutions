class Solution {
    public int minimumLength(String s) {
        int count = s.length();
        int i = 0;
        int j = count-1;

        while(i < j){
            char currI = s.charAt(i);
            char currJ = s.charAt(j);
            int countI = 0;
            int countJ = 0;
            if(currI != currJ)break;

            while(i < j){
                char curr = s.charAt(i);
                if(curr != currI)break;
                countI++;
                i++;
            }
            if(i == j)countI++;

            while(i < j){
                char curr = s.charAt(j);
                if(curr != currJ)break;
                countJ++;
                j--;
            }
            count = count - (countI + countJ);
        }

        return count;
    }
}
