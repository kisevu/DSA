package com.ameda.kisevu.works.questions.split_array_largest_sum;
/*
*
@author ameda
@project InterviewPrac
*
*/

import java.util.Arrays;

public class SplitArrayLargestSum {

    /*
    * Given an array of nums which consists of non-negative integers and an
    * integer m, you can split the array into m no-empty continuous sub-arrays
    * Write an algorithm to minimize the largest sum among these m sub-arrays
    *
    * i.e. int [] nums = {7,2,5,10,8} m = 2; output = 18  where we have {7,2,5}=14 and {10,8} = 18 as below
    * Explanation: There are four ways to split nums into two sub-arrays
    * The best way is to split it into [7,2,5] and [10,8] , where the
    * largest sum among the two sub-arrays is only 18
    *
    * We could have other subdivisions and the max of the two subdivision should be compared for each
    * outcome and the minimum for our case comes to 18 hence the choosing of 18 above
    * */

    public static void main(String[] args) {
        int [] nums = {7,2,5,10,8};

        System.out.println(splitArrayLargestSum(nums,2));

    }

    static int splitArrayLargestSum( int [] nums , int m ){

        int start = 0;
        int end = 0;

        for ( int i = 0; i< nums.length; ++i){
            start = Math.max(start, nums[i]); // at the end of the loop, this contains the max value
            end += nums[i];
        }

        //binary search to be applied
        while ( start < end ){
            int mid = start + (end -start)/2;

            //calculate how many pieces  you can divide this with this max sum
            int sum = 0;
            int pieces = 1; // at least it should be divided into 1 piece and that's the entire array
            for ( int num : nums ){
                if ( sum + num > mid ){
                    // you cannot add this to the sub-array, make a new sub-array
                    //say you add this num in new sub-array , then sum = num
                    sum = num;
                    pieces++;
                }else{
                    //keep adding in this sum
                    sum += num;
                }
            }

            if( pieces > m ){
                start = mid + 1;
            }else {
                end = mid;
            }
        }

        return end;  // because start == end
    }

}
