package com.ameda.kisevu.works.questions.rotation_count_in_rotated_array;
/*
*
@author ameda
@project InterviewPrac
*
*/

public class RotationCountInRotatedSortedArray {


    /*
    * find rotated count in
    * rotated sorted array
    * rotation count = pivot index value  + 1
    * */

    public static void main(String[] args) {

        int [] arr = {1,2,3,4,5,6,7};

        System.out.println("Array is rotated "+ rotation_count_in_rotated_sorted_array(arr));
    }

    static  int rotation_count_in_rotated_sorted_array( int [] arr ){
        int pivot = findPivot(arr);
        return pivot + 1;
    }
    static int findPivot(int [] arr ){
        int start = 0;
        int end = arr.length - 1;

        while ( start <= end ){
            int  mid = start + (end - start)/2;

            //4 cases over here
            if( mid < end && arr[mid] > arr[mid + 1 ] ){
                System.out.println("Pivot found here check 1");
                return mid;
            }

            if( mid > start && arr[mid] < arr[mid-1] ){
                System.out.println("Pivot found here check 2");
                return mid -1;
            }

            if( arr[mid] <= arr[start] ){
                System.out.println("Pivot found here check 3");
                end = mid -1; //here we ignore the greater side
            } else {
                System.out.println("Pivot found here check 4");
                start = mid +1; // here we ignore the smaller side
            }
        }
        return -1;
    }
}
