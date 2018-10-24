package leetcode;

// Let's call an array A a mountain if the following properties hold:
//
// A.length >= 3
// There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
// Given an array that is definitely a mountain,
// return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
//
// Example 1:
//
// Input: [0,1,0]
// Output: 1
// Example 2:
//
// Input: [0,2,1,0]
// Output: 1
public class PeakIndexInMountainArray_852 {

  public int peakIndexInMountainArray(int[] A) {
    if (A.length < 3) {
      return -1;
    }

    int index = 0;
    while (index < A.length - 1) {
      if (A[index] > A[index + 1]) {
        break;
      }
      index++;
    }

    return index;
  }

  // binary search
  public int peakIndexInMountainArray2(int[] A) {
    if (A.length < 3) {
      return -1;
    }

    int low = 0;
    int high = A.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (A[mid] < A[mid + 1]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return low;
  }
}
