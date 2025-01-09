package com.ameda.kisevu.works.questions.sorting.cycle_sort;
/*
*
@author ameda
@project InterviewPrac
*
*/

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {

    /*
    * Given an array nums of n integers  where nums[i] is in the range [1,n],
    *  return an array of all the integers in the range [1,n] that do not appear
    *   in nums
    *  i.e. nums = {4,3,2,7,8,2,3,1}
    *  output = [5,6]
    *  nums = {1,1}
    * output = [2]
    * Answer = all values without the correct ind ices is the answer
    *  Hint: if you're asked in the range [0,n] it means the indices corresponds to the actual values in them
     *       if you're asked in the range [1,n] it means every element will be at index = value-1;
     *
     *   so in the above the pattern is index = value -1
     * */

    public static void main(String[] args) {
        int [] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findAllDisappearedNumbers(arr));
    }


    static List<Integer> findAllDisappearedNumbers(int [] arr ){
//        {4,3,2,7,8,2,3,1}
        int i = 0;

        while ( i < arr.length ){ // 0 < 8 true
            int correctIndex = arr[i] -1; // arr[0] - 1  , correctIndex = 3

            if ( arr[i] != arr[correctIndex] ){ // if arr[0] 4 != arr[3] 7 true
                swap(arr,i,correctIndex);
            }else  {
                i++;
            }
        }

        //search for 1st missing numbers
        List<Integer> ans = new ArrayList<>();

        for ( int index = 0; index < arr.length; index++ ){
            if ( arr[index] != index + 1 ){
                ans.add(index + 1);
            }
        }
        return  ans;
    }

    static void swap( int [] arr , int first, int second ){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
