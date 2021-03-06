package leetcode;

import java.util.Arrays;

// Given a picture consisting of black and white pixels, find the number of black lonely pixels.
//
// The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and
// white pixels respectively.
//
// A black lonely pixel is character 'B' that located at a specific position where the same row and
// same column don't have any other black pixels.
//
// Example: Input: [['W', 'W', 'B'], ['W', 'B', 'W'], ['B', 'W', 'W']]
//
// Output: 3 Explanation: All the three 'B's are black lonely pixels. Note: The range of width and
// height of the input 2D array is [1,500].
public class LonelyPixel_531 {

  public int findLonelyPixel(char[][] picture) {

    if (picture.length == 0 || picture[0].length == 0) {
      return 0;
    }

    int m = picture.length;
    int n = picture[0].length;

    int[] rows = new int[m];
    int[] columns = new int[n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (picture[i][j] == 'B') {
          columns[j]++;
          rows[i]++;
        }
      }
    }

    int lonelyPixelInRow = Arrays.stream(rows).filter(s -> s == 1).toArray().length;
    int lonelyPixelInColumn = Arrays.stream(columns).filter(s -> s == 1).toArray().length;

    return Math.min(lonelyPixelInColumn, lonelyPixelInRow);
  }
}

//   public int findLonelyPixelDFS(char[][] picture) {
//     if (picture.length == 0 || picture[0].length == 0) {
//       return 0;
//     }
//
//     int m = picture.length;
//     int n = picture[0].length;
//     int res = 0;
//
//     for (int i = 0; i < m; i++) {
//       for (int j = 0; j < n; j++) {
//         if (picture[i][j] == 'B') {
//
//         }
//       }
//     }
//
//     return res;
//   }
//
//   private boolean isLonely(char[][] picture, int i, int j, int x, int y, boolean[][] visited) {
//     if (x < 0 || x >= picture.length || y < 0 || y >= picture[0].length || visited[x][y]) {
//       return true;
//     }
//
//     visited[x][y] = true;
//     if (picture[x][y] == 'B' && x != i && y != j) {
//       return false;
//     }
//
//     return isLonely(picture, i, j, x + 1, y, visited)
//         && isLonely(picture, i, j, x - 1, y, visited)
//         && isLonely(picture, i, j, x, y + 1, visited)
//         && isLonely(picture, i, j, x, y + 1, visited);
//   }
