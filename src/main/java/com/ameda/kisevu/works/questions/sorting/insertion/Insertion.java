package com.ameda.kisevu.works.questions.sorting.insertion;
/*
*
@author ameda
@project InterviewPrac
*
*/

import java.util.Arrays;

public class Insertion {


    public static void main(String[] args) {

       int [] arr = {5,4,3,2,1};
        System.out.println("Not sorted >>"+ Arrays.toString(arr));

        insertion_sort(arr);

        System.out.println("Sorted >> "+ Arrays.toString(arr));
    }

    static void insertion_sort( int [] arr ){
        for ( int i = 0; i < arr.length-1; i++ ){
            for ( int j = i +1; j > 0; j-- ){
                if( arr[j] < arr[j-1] ){
                    swap(arr,j,j-1);
                }else{
                    break;
                }
            }
        }
    }

    static  void swap( int [] arr, int first, int second ){
        int temp = arr[first];
        arr[first]= arr[second];
        arr[second] = temp;
    }
}
