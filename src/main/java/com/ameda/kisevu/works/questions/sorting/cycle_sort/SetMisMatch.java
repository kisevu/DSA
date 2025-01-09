package com.ameda.kisevu.works.questions.sorting.cycle_sort;
/*
*
@author ameda
@project InterviewPrac
*
*/

import java.util.Arrays;

public class SetMisMatch {

    /*
    *  You have a set of integers s, which originally contains all the numbers from
    * 1 to n. Unfortunately,  due to some error, one of the numbers in s got
    * duplicated to another number in the set , which results in repetition of
    * one number and loss of another number.
    *
    * You are given an integer array nums representing the data status  of this set
    * after the error.
    *
    * Find the number that occurs twice and the number that is missing and return them
    * in the form of an array
    * .i.e int [] nums = {1,2,2,4} output = [2,3]
    * */

    public static void main(String[] args) {
        int [] nums = {1,2,2,4};

        System.out.println(Arrays.toString( duplicate_and_missing_no((nums))));
    }

    static int [] duplicate_and_missing_no( int [] arr ){
        int i = 0;
        while ( i < arr.length ){
            int correctIndex = arr[i]-1;
            if (arr[i] != arr[correctIndex] ){
                swap(arr, i,correctIndex);
            }else {
                i++;
            }
        }

        for ( int index = 0; index < arr.length; index++ ){
            if( arr[index] !=  index + 1 ){
                return new int [] {arr[index], index + 1};
            }
        }
        return new int [] {-1,-1};
    }

    static void swap( int [] arr, int first, int second ){
        int temp =  arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
