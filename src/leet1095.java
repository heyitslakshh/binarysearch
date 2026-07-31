public class leet1095 {
    public static void main(String[] args) {
        int arr[]={2,3,4,5,6,19,18,17,15,14};
        System.out.println(search(arr,14));

    }
    static int search(int arr[],int target){
      int peak=peakIndexInMountainArray(arr);
      int firsttry=binarysearch(arr,target,0,peak) ;
      if (firsttry!=-1){
          return firsttry;
      }
      return binarysearch(arr,target,peak+1,arr.length-1);
    }

    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                // you are in dec part of array
                // this may be the ans, but look at left
                // this is why end != mid - 1
                end = mid;
            } else {
                // you are in asc part of array
                start = mid + 1; // because we know that mid+1 element > mid element
            }
        }
        return start;
    }

    static int binarysearch(int[] arr, int target, int start, int end) {
//        int start = 0;
//        int end = arr.length - 1;
        boolean orderagniotics = arr[start] < arr[end];


        while (start <= end) {
            int middle = (start + (end - start) / 2);
            if (arr[middle] == target) {
                return middle;
            }

            if (orderagniotics) {
                if (arr[middle] <= target) {
                    start = middle + 1;
                }
                if (arr[middle] >= target) {
                    end = middle - 1;
                }
//


            } else {
                if (arr[middle] <= target) {
                    end = middle - 1;
//
                }
                if (arr[middle] >= target) {
                    start = middle + 1;
                }
            }

        }
        return -1;
    }
}

