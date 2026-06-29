class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int ans=0;
        for(String x: patterns){
            if(word.contains(x))ans++;
        }
        return ans;
    }
}