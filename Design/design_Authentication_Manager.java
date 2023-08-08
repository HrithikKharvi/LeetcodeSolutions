class AuthenticationManager {

  int timeToLive = 0;
  Map<String, Integer> map = new HashMap<>();

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(!map.containsKey(tokenId))return;
        int expTime = map.get(tokenId) + this.timeToLive;
        if(currentTime >= expTime)return;
        map.put(tokenId, currentTime);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count = 0;

        for(Map.Entry<String, Integer> item : map.entrySet()){
          String token = item.getKey();
          int expTime = item.getValue() + this.timeToLive;

          if(currentTime < expTime)count++;
        }

        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
