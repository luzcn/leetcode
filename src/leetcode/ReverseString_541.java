package leetcode;

// Given a string and an integer k, you need to reverse the first k characters for every 2k characters
// counting from the start of the string.
//
// - If there are less than k characters left, reverse all of them.
//
// - If there are less than 2k but greater than or equal to k characters,
// then reverse the first k characters and left the other as original.
//
// Example:
// Input: s = "abcdefg", k = 2
// Output: "bacdfeg"
//
// Restrictions:
// - The string consists of lower English letters only.
// - Length of the given string and k will in the range [1, 10000]
public class ReverseString_541 {

  private StringBuilder res = new StringBuilder();

  private void dfs(String s, int k) {
    if (s.length() < k) {

      res.append((new StringBuilder(s)).reverse().toString());
      return;
    }

    if (s.length() < 2 * k) {
      res.append((new StringBuilder(s.substring(0, k))).reverse().toString());
      res.append(s.substring(k));
      return;
    }

    res.append((new StringBuilder(s.substring(0, k))).reverse().toString());
    res.append(s, k, 2 * k);

    dfs(s.substring(2 * k), k);
  }

  public String reverseStr(String s, int k) {

    dfs(s, k);

    return res.toString();
  }
}
