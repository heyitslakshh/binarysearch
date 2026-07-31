public class ceilingofnumber {
    public static void main(String[] args) {
        int[] arr = {2, 3, 45, 47, 78, 777, 888};
//        int[]arr= new int[]{67, 66, 65, 5, 4};
        System.out.println(ceiling(arr, 1000));


    }

    static int ceiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        if (target> arr[arr.length-1]){
            return -1;
        }
//        boolean orderagniotics = arr[start] < arr[end];


        while (start <= end) {
            int middle = (start + (end - start) / 2);
            if (arr[middle] == target) {
                return middle;
            }

//
                if (arr[middle] <= target) {
                    start = middle + 1;
                }
                if (arr[middle] >= target) {
                    end = middle - 1;
                }
//


            }




        return start;
    }
}
