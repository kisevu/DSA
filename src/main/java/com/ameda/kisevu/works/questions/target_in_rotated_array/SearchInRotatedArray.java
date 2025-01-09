package com.ameda.kisevu.works.questions.target_in_rotated_array;
/*
*
@author ameda
@project InterviewPrac
*
*/

public class SearchInRotatedArray {


    /*
    * Search in rotated sorted array
    *
    *   [2,4,5,7,8,9,10,12]
      1 rotation [12,2,4,5,7,8,9,10]
      2 rotation [10,12,2,4,5,7,8,9]
      *  1st approach is finding the pivot number / largest number in the array or number that gets changed i.e. 12
      * [3,4,5,6,7(7 is the pivot ),0, 1,2 ] hence apply binary search for asc sub arrays in the array
    * */


    public static void main(String[] args) {
        int [] vals = {4,5,6,7,0,1,2};

        System.out.println(search(vals,2));
    }

    static  int search(int [] vals , int target ){
        int pivot = find_pivot(vals);

        //if pivot was not found, then it means that the array is not rotated
        if ( pivot == -1){
            //do normal binary search cause array is not rotated
            return binarySearch(vals,target,0,vals.length-1);
        }

        //if pivot is found, then u have 2 sorted arrays
        if( vals[pivot] == target ){
            System.out.println(" target is equal to pivot ");
            return  pivot;
        }

        if( target >= vals[0] ){
            System.out.println(" target falls in pivot - 1 ");
            return binarySearch(vals,target,0,pivot - 1);
        }
        System.out.println(" target falls in pivot + 1 ");
        return binarySearch(vals,target,pivot + 1, vals.length-1);
    }

    // the below solution won't work for duplicate values
    static int find_pivot(int [] arr ){
        int start = 0;
        int end = arr.length-1;
        while( start <= end ){
            int mid = start + (end - start)/2;
            //4 cases over here
            if( mid < end && arr[mid] > arr[mid +1 ] ){
                System.out.println("Pivot found here check 1");
                return mid;
            }

            if( mid > start && arr[mid] < arr[mid-1] ){
                System.out.println("Pivot found here check 2");
                return mid -1;
            }

            if( arr[mid] <= arr[start] ){
                System.out.println("Pivot found here check 3");
                end = mid -1; //here we ignore the greater side
            } else {
                System.out.println("Pivot found here check 4");
                start = mid +1; // here we ignore the smaller side
            }

        }
        System.out.println("Pivot not found check 5");
        return -1;
    }

    static int find_pivot_for_duplicates( int [] arr ){

        int start = 0;
        int end = arr.length-1;
        while( start <= end ){
            int mid = start + (end - start)/2;
            //4 cases over here
            if( mid < end && arr[mid] > arr[mid +1 ] ){
                System.out.println("Pivot found here check 1");
                return mid;
            }

            if( mid > start && arr[mid] < arr[mid-1] ){
                System.out.println("Pivot found here check 2");
                return mid -1;
            }
            if( arr[mid] == arr[start] && arr[mid] == arr[end] ){
                // if elements at middle, start, end are equal
                //skipp duplicates

                //NOTE if the start and end were the pivot
                //check if start is pivot
                if( arr[start] > arr[start + 1]){
                    //here start is pivot
                    return start;
                }
                start++;

                //check if end is pivot
                if ( arr[end] < arr[end-1] ){
                    return end - 1;
                }
                end--;
            } else if ( arr[start] < arr[mid]  || ( arr[start] == arr[mid]  && arr[mid] > arr[end] )){
                start = mid + 1;
            }else {
                end = mid - 1;
            }

        }
        System.out.println("Pivot not found check 5");
        return -1;
    }





    static  int binarySearch(int [] arr , int target , int start , int end ){

        while ( start <= end ){
            int mid = start + (end -start)/2;

            if( target < arr[mid] ){
                end = mid - 1;
            }else if ( target > arr[mid] ){
                start = mid + 1;
            } else  {
                return mid;
            }
        }
        return -1;
    }


}
