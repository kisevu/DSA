package com.ameda.kisevu.works.questions.sorting.selection;
/*
*
@author ameda
@project InterviewPrac
*
*/

import java.util.Arrays;

public class SelectionSort {


    public static void main(String[] args) {

        int [] arr = {6,5,4,3,2,1};
        System.out.print(" Before swap >> "+ Arrays.toString(arr) +"\n");

        selection_sort(arr);

        System.out.print(" After swap >> "+ Arrays.toString(arr) +"\n");
    }

    static  void selection_sort( int [] arr ){
//        {5,4,3,2,1}
        for ( int i =0; i <arr.length; i++ ){
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr, maxIndex, last);
        }
    }

    static  int getMaxIndex( int [] arr, int start, int end ){
        int max = start; // assume start is the max

        for ( int i = start; i <= end; i++ ){
            if ( arr[max] < arr[i] ){
                max = i;
            }
        }
        return max;
    }

    static void swap( int [] arr, int first, int second ){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
