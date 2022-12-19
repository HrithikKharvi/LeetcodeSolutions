class Solution {
    public boolean validMountainArray(int[] arr) {
        int i = 0;
        boolean isValid = true;
        if(arr.length <= 2 )return false;

        for(; i<arr.length-1; i++){
            if(arr[i] >= arr[i+1])break;
        }
        if(i == arr.length-1 || i == 0)return false;
        i++;

        for(; i< arr.length; i++){
            if(arr[i] < arr[i-1])isValid = true;
            else{
                isValid = false;
                break;
            }
        }

        return isValid;
    }
}
