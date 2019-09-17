package code401challenges;

import java.util.Arrays;

public class ArrayReverse {
  // main method for running my code
  public static void main(String[] args) {
    int[] arrToReverse = new int[] { 89, 2354, 3546, 23, 10, -923, 823, -12 };
    int[] reversedArray = reverseArray(arrToReverse);
    int[] reversedArrayInPlace = reverseArrayInPlace(arrToReverse);
    System.out.println(Arrays.toString(reversedArray));
    System.out.println(Arrays.toString(reversedArrayInPlace));
  }

  // arrayReverse method

  public static int[] reverseArray(int[] arr) {
    int arrayLength = arr.length;
    int[] reversedArr = new int[arrayLength];

    int index = 0;

    for (int i = arrayLength - 1; i >= 0; i--) {
      reversedArr[index] = arr[i];
      index++;
    }

    return reversedArr;
  }

  public static int[] reverseArrayInPlace(int[] arr) {
    int pointerForward = 0;
    int pointerBackward = arr.length - 1;

    while (pointerForward < pointerBackward) {
      int temp = arr[pointerForward];
      arr[pointerForward] = arr[pointerBackward];
      arr[pointerBackward] = temp;
      pointerForward++;
      pointerBackward--;
    }

    return arr;
  }
}