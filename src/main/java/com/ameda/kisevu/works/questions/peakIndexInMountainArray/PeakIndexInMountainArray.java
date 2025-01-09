package com.ameda.kisevu.works.questions.peakIndexInMountainArray;
/*
*
@author ameda
@project InterviewPrac
*
*/

public class PeakIndexInMountainArray {
    /*
    *  Find the peak index of a mountain array
    *  An array can be considered a mountain if the following properties hold
    *  - arr.length >= 3
    *  - There exists some i with 0 < i < arr.length - 1 such that
    *   - arr[0] < arr[i] < ... arr[i-1] < arr[i]
    *    - arr[i] > arr [i + 1] .... > arr[arr.length-1]
    *
    *    Array mountain means that numbers will increase and then decrease
    *    Array mountain is also known as Bitonic array
    * */
    public static void main(String[] args) {

//        int [] arr = {0,1,2};
        int [] arr = {1,2,1,3,5,6,4};
        System.out.println( target_in_mountain_array(arr,2) );
    }

    static int peakIndex(int [] arr ){
        int start = 0;
        int end = arr.length - 1;

        while( start < end ){
            int mid = start + ( end - start ) /2;
            if( arr[mid] > arr[mid+1] ){
                //desc  part of the array you in
                end = mid;
            }else{
                //asc part of the array you in
                 start = mid + 1;
            }
        }
        return start; // or end as both are equal
    }

    /*
    *  Find peak element in an array
    * */

    static int find_peak_element( int [] arr ) {
        int start = 0;
        int end = arr.length - 1;

        while( start < end ){
            int mid = start + ( end - start ) /2;
            if( arr[mid] > arr[mid+1] ){
                //desc  part of the array you in
                end = mid;
            }else{
                //asc part of the array you in
                start = mid + 1;
            }
        }
        return start; // or end as both are equal
    }

    /*
    *  searching in bitonic array or mountain array  for target = value
    * */
    static int target_in_mountain_array( int [] arr , int target ){
        //solution Find peak, search in asc and search in desc
        int peak = peakIndex(arr);

        int firstTry = order_agnostic_binary_search(arr,target,0,peak);
        if( firstTry != -1 ){
            System.out.println("Entry found in this ascending half.");
            return firstTry;
        }

        //search in the second array
        System.out.println("Entry found in descending half");
        return order_agnostic_binary_search(arr, target, peak + 1, arr.length-1);
    }

    static int binary_search( int [] arr , int target , int start, int end ){

        while ( start <= end ){
            int mid = start + ( end -start )/2;

            if ( target < arr[mid] ){
                end = mid -1;
            } else if ( target > arr[mid] ){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //order agnostic binary search
    static int order_agnostic_binary_search( int [] arr , int target , int start , int end){

        boolean isAscending = arr[start] < arr[end];

        while ( start <= end ){
            int mid = start + ( end - start )/2;

            if ( target == arr[mid] ){
                return mid;
            }

            if( isAscending ){
                if ( target < arr[mid] ){
                    end = mid -1;
                } else {
                    start = mid +1;
                }
            }else {
                if ( target > arr[mid] ){
                    end = mid -1;
                }else{
                    start = mid +1;
                }
            }
        }
        return -1;
    }

}
