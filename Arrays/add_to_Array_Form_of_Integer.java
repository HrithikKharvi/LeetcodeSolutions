class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> arr = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        int rem = 0;
        for(int i=num.length-1; i>=0; i--){
          if(k > 0 || rem > 0){
            arr.addFirst((num[i] + rem + (k%10))%10);
            rem = (num[i] + rem + (k%10))/10;
            System.out.println(num[i] + rem + (k%10));
            k = k/10;
          }else{
            arr.addFirst(num[i]);
          }
        }
          while(k != 0){
            arr.addFirst((rem + (k % 10))%10);
            rem = (rem + (k%10)) / 10;
            System.out.println(rem);
            k = k / 10;

          }
          if(rem > 0)arr.addFirst(rem);

        for(Integer i : arr){
          result.add(i);
        }

        return result;
    }
}
