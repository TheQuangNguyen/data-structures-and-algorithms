package code401challenges;

public class ArrayShift {

    // Write a function called insertShiftArray which takes in an array and the value to be added.
    // Without utilizing any of the built-in methods available to your language,
    // return an array with the new value added at the middle index.


    public static int[] insertShiftArray(int[] arr, int numberToAdd) {
        int[] shiftArray = new int[arr.length+1];
        int middleIndex = shiftArray.length/2;
        int pointer = 0;    // pointer to traverse through input array

        // loop through the new array and insert values from the input array into new array unless the index is equals
        // to
        for (int i = 0; i < shiftArray.length; i++) {
            if (i == middleIndex) {
                shiftArray[i] = numberToAdd;
            } else {
                shiftArray[i] = arr[pointer++];
            }
        }

        return shiftArray;
    }
}
