package leetcode;

// Given a matrix A, return the transpose of A.
//
// The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
//
//
//
// Example 1:
//
// Input: [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[1,4,7],[2,5,8],[3,6,9]]
// Example 2:
//
// Input: [[1,2,3],[4,5,6]]
// Output: [[1,4],[2,5],[3,6]]
public class TransposeMatrix_867 {

  // copy directly
  public int[][] transpose(int[][] A) {

    int m = A.length;
    if (m == 0) {
      return null;
    }

    int n = A[0].length;

    int[][] res = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        res[i][j] = A[j][i];
      }
    }

    return res;
  }
}
