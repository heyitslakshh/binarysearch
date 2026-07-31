public class Main {
    public static void main(String[] args) {
//        int[] arr = {2, 3, 45, 47, 78, 777, 888};
        int[]arr= new int[]{67, 66, 65, 5, 4};
        System.out.println(binarysearch(arr, 4));


    }

    static int binarysearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean orderagniotics = arr[start] < arr[end];


        while (start <= end) {
            int middle = (start + (end - start) / 2);
            if (arr[middle] == target) {
                return middle;
            }

                if(orderagniotics){
                    if (arr[middle] <= target) {
                        start = middle + 1;
                    }
                    if (arr[middle] >= target) {
                        end = middle - 1;
                }
//


            }
                else {
                if (arr[middle]<=target) {
                end=middle-1;
//
            }
             if(arr[middle]>=target){
                start=middle+1;
            }
                }

        }
        return -1;
    }
}

