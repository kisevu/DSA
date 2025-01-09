package com.ameda.kisevu.works.questions.ceiling;
/*
*
@author ameda
@project InterviewPrac
*
*/

import java.util.Arrays;

public class Ceiling {

    /* Ceiling ( Smallest number >= target ).
    *  smallest element in an array greater or equal to the target element
    *  {1,2,3,5,6,7,8} target = 5 ceiling = 5;
    *  {1,2,3,5,6,7,8} target = 4 ceiling = 5;
    *
    *  in the solution here if we'll not be returning the target
    *  we'll be returning the ceiling value and its is more or less same as binary search
    *
    * Question: find no. >= target
    *
    * When loop breaks start = end + 1;
    *
    * Next big no. when target not found is going to be start
    *
    * In an event when the answer does not lie between start and end then it means the end
    * and the start will shift positions hence will be having start returned as the target
    *  The reason for taking start and end is that the answer lies between them.
    * This scenario occurs when the target is not found, but we're trying to find a number
    * Since start will be a head of end and now start is the greater element hence it qualifies
    * to be returned as the result here
    *
    * Floor( Greatest number <= target ).
    * If the Question is inverted and that we're looking for the floor of a target then
    * in an event the answer was not found then it lies at the end and not the start like previous.
    *
     * */

    public static void main(String[] args) {

        int [] arr = {2, 3 , 5, 9, 14, 16, 18};
        int target = 15;
        int ans = find_ceiling(arr,target);
//        System.out.println(ans);

        char [] letters = {'c','f','j'};

        System.out.println(nextGreaterCharacter(letters,'a'));

        int [] vals = {5,7,7,7,7,8,8,10};

//        System.out.println(Arrays.toString(position_of_first_and_last(vals,10)));


    }

    //smallest no. >= target

    //if the target is greater than  the greatest number in the array hence the check
    static int find_ceiling( int [] arr , int target ){

         if( target > arr[arr.length-1] ){
             System.out.println(" target is greater than the "+ (arr.length-1));
             return -1; // no ceiling
         }

        int start = 0;
        int end = arr.length-1;

        boolean isAsc = arr[start] < arr[end];

        while ( start <= end ){
            int mid = start + ( end - start )/2;

            if ( arr[mid] == target ) {
                return mid;
            }

            if( isAsc ){
                if( target < arr[mid] ){
                    end = mid - 1;
                } else{
                    start = mid + 1;
                }
            } else  {
                if ( target > arr[mid] ){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }


        return start;
    }

    //greatest no. <= target
    static  int find_floor( int [] arr, int target ){
        int start = 0;
        int end = arr.length-1;


        boolean isAsc = arr[start] < arr[end];

        while ( start <= end ){
            int mid = start + ( end - start )/2;

            if ( arr[mid] == target ) {
                return mid;
            }

            if( isAsc ){
                if( target < arr[mid] ){
                    end = mid - 1;
                } else{
                    start = mid + 1;
                }
            } else  {
                if ( target > arr[mid] ){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }


        return end;
    }

    //Find the smallest Letter Greater  Than Target
    /*
    * Given characters  array letters that is sorted  in non-decreasing  order
    * and a character  target, return the smallest  character in the array that is
    * larger than target
    * Note: The letters wrap around if target == 'z' and ['a','b'] the answer is 'a'
    *
    * */


    static char nextGreaterCharacter ( char [] letters, char target ){
        int start = 0;
        int end = letters.length-1;

        while ( start <= end ){
            int mid = start + ( end - start )/2;
            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return letters[start % letters.length]; // letters[0];
    }

    /*
    *  Question: Find first and Last Position of Element in Sorted Array
    *
    * Given an array of integers nums sorted in ascending order, find the starting and ending
    * position of a given target value
    * if target is not found in the array return [-1,-1]
    * You must write an algorithm with o(log n)
    * */


    static int [] position_of_first_and_last(int [] arr, int target ){
        //i.e int [] arr = {5,7,7,7,7,8,8,10};

        int [] ans = {-1,-1};

        int start = search(arr, target, true);
        int end = search(arr,target,false);
        ans[0] = start;
        ans[1] = end;
        return ans;
    }

    private static int search( int [] arr, int target, boolean find_start_index ){
        int ans = -1;

        //check 1st occurrence of if target is in first
        int start = 0;
        int end = arr.length-1;

        while ( start <= end ){
            int mid = start + ( end -start )/2;

            if( target > arr[mid] ){
                start = mid + 1;
            }else  if ( target < arr[mid] ){
                end = mid - 1;
            } else {
                //potential ans found here
                ans = mid;
                if( find_start_index){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }


}
