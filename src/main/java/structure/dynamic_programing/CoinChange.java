package structure.dynamic_programing;

/**
 * https://leetcode-cn.com/problems/coin-change/
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *  
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */

public class CoinChange {
    public static void main(String[] args) {

        int[] coins = new int[]{1,2,5};
        int amount = 11;

        SolutionA solutionA = new SolutionA();
        System.out.println(solutionA.coinChange(coins, amount));

        SolutionB solutionB = new SolutionB();
        System.out.println(solutionB.coinChange(coins,amount));

        SolutionC solutionC = new SolutionC();
        System.out.println(solutionC.coinChange(coins,amount));
    }

    /**
     * 递归
     */
    public static class SolutionA {
        int res = Integer.MAX_VALUE;
        public int coinChange(int[] coins, int amount) {
            if(coins.length == 0){
                return -1;
            }

            findWay(coins,amount,0);

            // 如果没有任何一种硬币组合能组成总金额，返回 -1。
            if(res == Integer.MAX_VALUE){
                return -1;
            }
            return res;
        }

        public void findWay(int[] coins,int amount,int count){
            if(amount < 0){
                return;
            }
            if(amount == 0){
                res = Math.min(res,count);
            }

            for(int i = 0;i < coins.length;i++){
                findWay(coins,amount-coins[i],count+1);
            }
        }
    }

    /**
     * 记忆化搜索
     */
    static class SolutionB {
        int[] memo;
        public int coinChange(int[] coins, int amount) {
            if(coins.length == 0){
                return -1;
            }
            memo = new int[amount];

            return findWay(coins,amount);
        }
        // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
        // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
        public int findWay(int[] coins,int amount){
            if(amount < 0){
                return -1;
            }
            if(amount == 0){
                return 0;
            }
            // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
            // 直接的返回memo[n] 的最优值
            if(memo[amount-1] != 0){
                return memo[amount-1];
            }
            int min = Integer.MAX_VALUE;
            for(int i = 0;i < coins.length;i++){
                int res = findWay(coins,amount-coins[i]);
                if(res >= 0 && res < min){
                    min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
                }
            }
            memo[amount-1] = (min == Integer.MAX_VALUE ? -1 : min);
            return memo[amount-1];
        }
    }

    /**
     * 动态规划
     *
     * 自底向上的动态规划
     */
    static class SolutionC {
        public int coinChange(int[] coins, int amount) {
            // 自底向上的动态规划
            if(coins.length == 0){
                return -1;
            }

            // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
            int[] memo = new int[amount+1];
            memo[0] = 0;
            for(int i = 1; i <= amount;i++){
                int min = Integer.MAX_VALUE;
                for(int j = 0;j < coins.length;j++){
                    if(i - coins[j] >= 0 && memo[i-coins[j]] < min){
                        min = memo[i-coins[j]] + 1;
                    }
                }
                // memo[i] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min);
                memo[i] = min;
            }

            return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
        }
    }




}
