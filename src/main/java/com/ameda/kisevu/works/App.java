package com.ameda.kisevu.works;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )

    {
        int [] arr = {-18, -12, -4, 0, 2, 3, 4, 15,16,18,22,45,89};
        int [] reversed = {89,45,22,18,16,15,4,3,2,0,-4,-12,-18};
//
//        System.out.println(order_agnostic_binary_search(arr,3));
//        System.out.println(order_agnostic_binary_search(reversed,3));

        System.out.println(infinite_array_find_target(arr,4));

    }

    static int infinite_array_find_target( int [] arr , int target ){

        // take the array in chunks

        int start = 0;
        int end = 1;

         while ( target >= end ){
             int newStart = end + 1;
             end = end + ( end - start + 1)*2;
             start = newStart;
         }
         return binarySearch(arr, target, start , end);
    }


    static int binarySearch(int [] arr , int target , int start , int end ){
         while ( start <= end ){
             int mid = start + ( end - start )/2;
             if( target < arr[mid] ){
                 end = mid -1;
             }else if (target > arr[mid] ){
                 start = mid + 1;
             } else {
                 return mid;
             }
         }
         return -1;
    }


    static int order_agnostic_binary_search(int [] arr , int target ){

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

        return -1;
    }
}
