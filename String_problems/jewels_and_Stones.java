class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        String remainingStones = stones.replaceAll("[" + jewels + "]", "");
        System.out.println(remainingStones);

        return stones.length() - remainingStones.length();

    }
}
