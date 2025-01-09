package com.ameda.kisevu.works.questions.sorting.bubble;
/*
*
@author ameda
@project InterviewPrac
*
*/

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int [] arr = {200,10,2,22,12,45};

        System.out.print(" Before sorting "+Arrays.toString(arr)+"\n");
        bubble_sort(arr);

        System.out.print(" After sorting " +Arrays.toString(arr)+"\n");

        System.out.println(binary_search(arr,12));
    }

    static  void bubble_sort( int [] arr ){
        boolean swapped;
        // run the steps n-1 times
        for( int i = 0; i < arr.length; ++i ){
            // for each step, max item will come at the last respective index
            swapped = false;
            for ( int j = 1; j < arr.length -i; ++j ){
                // swap if item is smaller than the previous item
                if ( arr[j] < arr[j-1] ){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

    static int binary_search( int [] arr, int target ){
        int start = 0;
        int end = arr.length-1;

        while ( start <= end ){
            int mid = start + ( end - start )/2;

            if( target < arr[mid] ){
                end = mid - 1;
            }else if ( target > arr[mid] ){
                start = mid + 1;
            } else{
                return  mid;
            }
        }

        return -1;
    }
}
