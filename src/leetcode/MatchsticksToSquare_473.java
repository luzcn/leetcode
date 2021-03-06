package leetcode;

import java.util.HashSet;

// Remember the story of Little Match Girl?
// By now, you know exactly what matchsticks the little match girl has,
//
// please find out a way you can make one square by using up all those matchsticks.
//
// You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
//
//Your input will be several matchsticks the girl has, represented with their stick length.
// Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
//
//Example 1:
//Input: [1,1,2,2,2]
//Output: true
//
//Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
//Example 2:
//Input: [3,3,3,3,4]
//Output: false
//
//Explanation: You cannot find a way to form a square with all the matchsticks.
public class MatchsticksToSquare_473 {


  // DFS solution
  // - all the numbers are positive
  // - we need to split the sorted array into 4 sub arrays with equal sums
  public boolean makesquare(int[] nums) {
    if (nums.length < 4) {
      return false;
    }

    HashSet<Integer> visited = new HashSet<>();

    return dfs(nums, 0, 0, visited, 0);
  }


  private boolean dfs(int[] nums, int count, int target, HashSet<Integer> visited, int sum) {

    for (int i = 0; i < nums.length; i++) {
      if (visited.contains(i)) {
        continue;
      }

      sum += nums[i];
      System.out.println(sum);

      visited.add(i);
      dfs(nums, count, target, visited, sum);
//      visited.remove(i);
    }
    return false;
  }
}
