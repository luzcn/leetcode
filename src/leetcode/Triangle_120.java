package leetcode;

import java.util.*;

// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//
// For example, given the following triangle
//
// [
//      [2],
//     [3,4],
//    [6,5,7],
//   [4,1,8,3]
// ]
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
public class Triangle_120 {


    // dp idea
    //
    // dp(level, index) to indicate the min path sum
    // dp(level, index) = min(dp(level + 1, index), dp(level + 1, index+1) + nums[level][i]
    // since the transfer function only checks level + 1, we can use a single array.
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }


        int m = triangle.size();
        int n = triangle.get(m - 1).size();

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(m - 1).get(i);
        }


        for (int level = m - 2; level >= 0; level--) {
            for (int i = 0; i < triangle.get(level).size(); i++) {
                dp[i] = Math.min(dp[i], dp[i + 1]) + triangle.get(level).get(i);
            }
        }

        return dp[0];
    }
}
