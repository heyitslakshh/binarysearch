public class leet33 {
    public static void main(String[] args) {
        int arr[] = {19, 20, 21, 22, 23, 0, 1, 2, 3, 4, 5};
        System.out.println(search(arr,5));


    }
    static int search(int nums[],int target){
        if(piviot(nums)==-1){
            return binarysearch(nums,target,0, nums.length-1);
        }
        if (nums[piviot(nums)]==target){
            return piviot(nums);
        }
        if (nums[0]<=target){
           return binarysearch(nums,target,0,piviot(nums)-1);
        }

            return binarysearch(nums,target,piviot(nums)+1, nums.length-1);


    }

    static int binarysearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int middle = (start + (end - start) / 2);
            if (arr[middle] == target) {
                return middle;
            }
            if (arr[middle] >= target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }
        static int piviot ( int arr[]){
            int start = 0;
            int end = arr.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (mid < end && arr[mid] > arr[mid + 1]) {
                    return mid;
                }
                if (mid > start && arr[mid] < arr[mid - 1]) {
                    return mid - 1;
                }
                if (arr[start] >= arr[mid]) {
                    end = mid - 1;
                }
                if (arr[start] <= arr[mid]) {
                    start = mid + 1;
                }
            }
            return -1;
        }

}
