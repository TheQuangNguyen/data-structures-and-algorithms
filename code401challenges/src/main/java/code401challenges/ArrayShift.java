package code401challenges;

public class ArrayShift {

    // Write a function called insertShiftArray which takes in an array and the value to be added.
    // Without utilizing any of the built-in methods available to your language,
    // return an array with the new value added at the middle index.

    public static int[] insertShiftArray(int[] arr, int numberToAdd) {
        int[] shiftArray = new int[arr.length+1];
        int middleIndex = shiftArray.length/2;
        int pointer = 0;    // pointer to traverse through input array

        // loop through the new array and insert values from the input array into new array
        // unless the index is equals to middleIndex
        for (int i = 0; i < shiftArray.length; i++) {
            if (i == middleIndex) {
                shiftArray[i] = numberToAdd;
            } else {
                shiftArray[i] = arr[pointer++];
            }
        }

        return shiftArray;
    }

    // write a second function that removes an element from the middle index
    // and shifts other elements in the array to fill the new gap.

    public static int[] removeShiftArray(int[] arr) {

        // checks if the input array is empty
        if (arr.length == 0) {
            return new int[]{};
        }

        int[] shiftArray = new int[arr.length -1];
        int middleIndex = arr.length / 2;
        int pointer = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i == middleIndex) {
                continue;
            } else {
                shiftArray[pointer++] = arr[i];
            }
        }
        return shiftArray;
    }
}
