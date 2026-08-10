class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth =0;
        for(int[] customer : accounts){
            int Wealth =0;
            for(int money : customer){
                Wealth +=money;
            }
            maxWealth =Math.max(maxWealth,Wealth);
        }
        return maxWealth;
    }
}

Input
accounts =[[1,2,3],[3,2,1]]

Output
6

Expected
6
