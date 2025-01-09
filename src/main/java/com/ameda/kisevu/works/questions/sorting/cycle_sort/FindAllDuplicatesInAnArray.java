package com.ameda.kisevu.works.questions.sorting.cycle_sort;
/*
*
@author ameda
@project InterviewPrac
*
*/

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    /*
    * Given an integer array nums of length n where  all the integers of nums
    * are in the range [1,n] and each integer appears once or twice, return an array
    * of all integers that appears twice
     * int [] nums = {4,3,2,7,8,2,3,1} [2,3]
    * */

    public static void main(String[] args) {
        int [] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findAllDuplicatesInAnArray(nums));
    }

    static List<Integer> findAllDuplicatesInAnArray( int [] arr ){
        int i = 0;

        while ( i < arr.length ){
            int correctIndex = arr[i]-1;
            if (arr[i] != arr[correctIndex] ){
                swap(arr, i, correctIndex);
            }else{
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for ( int index = 0; index < arr.length; index++ ){
            if ( arr[index] != index +1 ){
                ans.add(index + 1);
            }
        }
        return ans;
    }

    static  void swap( int [] arr , int first , int second ){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
