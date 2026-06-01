#lc283
class Solution {
    public void moveZeroes(int[] nums) {
        int current=0,zeros=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[current]=nums[i];
                current++;
            }
            else zeros++;
        }
        while(zeros!=0){
            nums[nums.length-zeros]=0;
            zeros--;
        }
    }
}