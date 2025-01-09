package com.ameda.kisevu.works.questions.infiniteArray;
/*
*
@author ameda
@project InterviewPrac
*
*/



/*
 * Find position of an element in a sorted array of infinite numbers
 * ( here we do not know the size of the array )
 *
 * Given we do not know the length and the start end positions.
 * When we do binary search, what we are typically doing is dividing the array into chunks i.e initial
 * size is N, after division it will N/2, N/4 ...
 * Now with this question at hand we'll be re-building it back up and so it will be doubled
 * so for a size lets say 2,3 which is length 2 next will be 4,5,6,7 which is length 4 and is doubled.
 * For whichever range of the chunked size where the target lies is when we do a binary search to find the target
 * */
public class InfiniteArray {

    public static void main(String[] args) {

        int [] arr = {3, 5, 7,9,10,90,
                100,130,140,160,170};
        int target  = 10;

        System.out.println(ans(arr,target));

    }


    static int ans ( int [] arr , int target ){
        //find the first range
        //find start with a box of size  2

        int start = 0;
        int end = 1;

        // i.e {2,3,5,6,7,8,10,11,12,15,29,23,30}

        while ( target > arr[end] ){
            int newStart = end + 1;
            //double the box value
            //end = previous end +  sizeOfbox*2;
            // e - ( s + 1) ->  ( e - s + 1 )
            //first , the size of the window was 2
            //so for a start, the last end = 1, size * 2 because of 2 elements is  4 ( elements are 2 and 3 )
            //so end + doubled_size; (1) - lastIndex + (4) - doubled size  = 5  so new end is index 5
            end = end + ( end - start + 1) * 2;
            // so new size of the box is 4 for instance
            // 4 = e - s + 1; so 4 = 5 -2 + 1
            start = newStart;
        }
        return binarySearch(arr,target, start, end);
    }

    static int binarySearch( int [] arr , int target , int start , int end ){

        while ( start <= end ){
            int mid  = start + ( end - start ) /2;

            if ( target < arr[mid] ){
                end = mid -1;
            }else if( target > arr[mid] ){
                start = mid + 1;
            } else  {
                return  mid;
            }
        }

        return -1;
    }

}
