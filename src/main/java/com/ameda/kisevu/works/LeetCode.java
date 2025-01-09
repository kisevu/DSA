package com.ameda.kisevu.works;
/*
*
@author ameda
@project InterviewPrac
*
*/

import java.util.Arrays;

public class LeetCode {


    public static void main(String[] args) {
        char [] letters = {'c','f','j'};

//        System.out.println(nextGreaterCharacter(letters,'a'));

        int [] vals = {5,7,7,7,7,8,8,10};

//        System.out.println(Arrays.toString( first_n_last_positions(vals,8)));
        System.out.println(floor(vals,9));
    }


    static int ceiling( int [] arr , int target ){
        if ( target > arr[arr.length-1] ){
            System.out.println("If target has a large value than the large value in the array terminate");
            return  -1;
        }

        int start = 0;
        int end = arr.length-1;

        while ( start <= end ){

            int  mid = start + ( end - start )/2;

            if ( target <= arr[mid] ){
                end = mid -1;
            }else  if ( target >= arr[mid] ){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }

    static  int floor( int [] arr , int target ){

        int start = 0;
        int end = arr.length-1;

        while ( start <= end ){

            int  mid = start + ( end - start )/2;

            if ( target <= arr[mid] ){
                end = mid -1;
            }else  if ( target >= arr[mid] ){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return end;
    }


    static int [] first_n_last_positions( int [] arr, int target){
        int [] ans = {-1,-1};

        int start = search( arr, target,true);
        int end = search(arr, target, false);
        ans[0] = start;
        ans[1] = end;
        return ans;
    }

    static int search(int [] arr , int target , boolean first ){
        int ans = -1;

        int start = 0;
        int end = arr.length-1;

        while ( start <= end ){
            int mid = start + (end - start )/2;

            if ( target < arr[mid] ){
                end = mid - 1;
            }else  if ( target > arr[mid] ){
                start = mid + 1;
            } else {
                ans = mid;
                if (first){
                    end = mid -1;
                }else {
                    start = mid + 1;
                }
            }
        }

        return ans;
    }

    private static char nextGreaterCharacter(char [] ch, char target ){
       int start = 0;
       int end = ch.length-1;

       while ( start <= end ){
           int mid = start + (end - start)/2;
           if( target < ch[mid] ){
               end = mid -1;
           }
           else {
               start = mid + 1;
           }
       }
       return ch[start%ch.length];
    }

}
