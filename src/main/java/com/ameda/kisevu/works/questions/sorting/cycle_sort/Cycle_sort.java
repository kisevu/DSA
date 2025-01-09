package com.ameda.kisevu.works.questions.sorting.cycle_sort;
/*
*
@author ameda
@project InterviewPrac
*
*/

import java.util.Arrays;

public class Cycle_sort {

    public static void main(String[] args) {

        int [] vals = {4,0,2,1};

        System.out.println(find_missing_number(vals));
    }


    static void cyclic_sort( int [] arr ){
        int i = 0;
        while ( i < arr.length ){
            int correctIndex = arr[i] - 1;
            if(arr[i] != arr[correctIndex] ){
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }
    }

    /*
    *  Given an array nums containing n distinct  numbers in the range [0,n], return the only
    * number in the range that is missing from the array
    *  i.e [0,1] in three numbers 2 is the missing number
    *
    *  From Question, you are given 0 to N so it means there will N + 1 numbers
    *
    * Hint: if you're asked in the range [0,n] it means the indices corresponds to the actual values in them
    *       if you're asked in the range [1,n] it means every element will be at index = value-1;
    *
    *   so in the above the pattern is index = value
    * */

    static int find_missing_number( int [] arr ){

//        {4,0,2,1}
        int i = 0;
        while ( i < arr.length ){
            int correctIndex = arr[i];
            if ( arr[i] < arr.length && arr[i] != arr[correctIndex] ){
                swap(arr, i, correctIndex );
            }else {
                i++;
            }
        }

        //search for 1st missing number
        for ( int index = 0; index < arr.length; index++ ){
            if( arr[index] != index ){
                return index;
            }
        }

        return arr.length;
    }




    static void swap( int [] arr, int first, int second ){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
