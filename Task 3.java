class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] ans =new int[nums.length];
        int index =0;
        for(int num :nums){
            if(num % 2==0){
                ans[index++]=num;
            }
        }
        for(int num :nums){
            if(num % 2 !=0){
                ans[index++]=num;
            }
        }
        return ans;
    }
}



Input
nums =[3,1,2,4]

Output
[2,4,3,1]

Expected
[2,4,3,1]
