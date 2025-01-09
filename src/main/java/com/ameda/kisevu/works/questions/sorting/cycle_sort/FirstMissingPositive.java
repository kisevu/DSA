package com.ameda.kisevu.works.questions.sorting.cycle_sort;
/*
*
@author ameda
@project InterviewPrac
*
*/

public class FirstMissingPositive {

    /*
    * Given an unsorted integer array nums, return the smallest  missing positive integer.
    * You must implement an algorithm  that returns 0(n) time  and use constant  extra space
    * .i.e nums = {1,2,0 } ==> sorted {0,1,2} output = 3 ( smallest missing positive integer, if -ve are provided
    * we should ignore them)
    * */

    public static void main(String[] args) {
        int [] nums = {1,2,0 };

        System.out.println(find_first_missing_number(nums));
    }

    static int find_first_missing_number( int [] arr ){
        int i = 0;

        while ( i < arr.length ){
            int correctIndex = arr[i] -1;
            if(arr[i] > 0 && arr[i] < arr.length && arr[i] != arr[correctIndex] ){
                swap(arr, i, correctIndex);
            }else {
                i++;
            }
        }

        for ( int index = 0; index < arr.length; index++ ){
            if(arr[index] != index + 1){
                return index + 1;
            }
        }
        return arr.length + 1;
    }


    static void swap( int [] arr , int first, int second ){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }



}
