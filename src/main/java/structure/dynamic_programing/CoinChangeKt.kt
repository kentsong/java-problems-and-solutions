package structure.dynamic_programing

class CoinChangeKt {

    //暴力法
    class Solution {
        lateinit var memo: IntArray
        var result: Int = Int.MAX_VALUE
        fun coinChange(coins: IntArray, amount: Int): Int {
            if (coins.size == 0) result - 1

            find(coins, amount, 0)

            if (result == Int.MAX_VALUE) return -1
            return result
        }

        fun find(coins: IntArray, amount: Int, coinCount: Int) {
            if (amount < 0) return

            if (amount == 0) {
                result = Math.min(coinCount, result)
            }

            for (coinNun in coins) {
                find(coins, amount - coinNun, 1 + coinCount)
            }
        }
    }

    // 備忘錄法
    class Solution_B {
        lateinit var memo: IntArray

        fun coinChange(coins: IntArray, amount: Int): Int {
            if (coins.size == 0) return -1
            memo = IntArray(amount)

            return find(coins, amount, 0)
        }

        fun find(coins: IntArray, amount: Int, coinCount: Int): Int {
            if (amount < 0) return -1
            if (amount == 0) return 0

            if(memo[amount - 1] != 0){
                return memo[amount - 1]
            }

            var min: Int = Int.MAX_VALUE
            for (coinNun in coins) {
                val result = find(coins, amount - coinNun, 1 + coinCount)
                if (result >= 0 && result < min) {
                    min = result + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
                }
            }

            memo[amount - 1] = if (min == Int.MAX_VALUE) -1 else min
            return memo[amount - 1]
        }
    }
}