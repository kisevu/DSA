package com.ameda.kisevu.works.questions.sorting.cycle_sort;
/*
*
@author ameda
@project InterviewPrac
*
*/

public class FindDuplicateNumber {

    /*
    * Given an array of integers nums containing n + 1 integers where each
    * integer is in the range [1,n] inclusive.
    *
    * There's only one repeated number in nums, return this repeated number.
    *  i.e. int [] nums {1,3,4,2,2} output = 2
    * Hint: so in the above the pattern is index = value -1
    * */
    public static void main(String[] args) {
        int [] nums =  {1,3,4,2,2};
        System.out.println(repeated_numbers(nums));
    }

    static int repeated_numbers( int [] arr ){

        int i = 0;

        while ( i < arr.length ){

            if( arr[i] != i + 1){
                int correct = arr[i]-1;
                if(arr[i] != arr[correct] ){
                    swap(arr,i,correct);
                }else {
                  return arr[i];
                }
            } else {
                i++;
            }
        }
        //if no duplicates return
        return -1;
    }



    static  void swap( int [] arr, int first, int second ){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
