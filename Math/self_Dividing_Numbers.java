class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=left; i<=right; i++){
          if(isValid(i)){
            arr.add(i);
          }
        }

        return arr;
    }

    public boolean isValid(int i){
      int n = i;

      while(n != 0){
        int k = n % 10;
        if(k == 0 || i % k != 0)return false;
        else{
          n = n / 10;
        }
      }

      return true;
    }

}
