class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int tl=low;
        int nol=0;
        while(tl!=0){
            nol++;
            tl=tl/10;
        }
        List<Integer> ans = new ArrayList<>();
        String str="123456789";
        int curr=low;
        int start=0;
        int end=nol;
        while(nol<=9){
            curr=Integer.parseInt(str.substring(start,end));
            if(curr>high) break;
            if(curr>=low && curr<=high) ans.add(curr);
            start++;
            end++;
            if(end>9){
                start=0;
                end=++nol;
            }
        }
        return ans;
    }
}