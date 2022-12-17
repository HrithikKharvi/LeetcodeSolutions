class RecentCounter {

    ArrayList<Integer> counts;
    int requests;
    public RecentCounter() {
        counts = new ArrayList<Integer>();
        requests = 0;
    }
    
    public int ping(int t) {
     int start = t - 3000;
     int end = t;
     counts.add(t);
     return checkPings(start, end, counts);
    }

    public int checkPings(int start, int end, ArrayList<Integer> counts){
      int count  = 0;

      for(int i=0; i<counts.size(); i++){
        if(counts.get(i) >= start && counts.get(i) <= end)count++;
      }

      return count;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
