class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder sb = new StringBuilder();
        if(n==0) return 0;
        int sum=0;
        while(n!=0){
            int temp=n%10;
            if(temp!=0)sb.insert(0,temp);
            sum+=temp;
            n=n/10;
        }
        return sum*(Long.parseLong(sb.toString()));
    }
}