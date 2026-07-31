public class infinitearr {
    public static void main(String[] args) {
        int rt[]={12,44,67,68,89,90,100,137,190};
        System.out.println(ans(rt,90));

    }
    static int ans(int arr[],int target){
       int start=0;
       int end=1;
       if (arr[end]<target){
           int temp=end+1;
           end=end+(end-start+1)*2;
           start=temp;
       }
       return binary(start,end,target,arr);
    }

    static int binary(int start, int end, int target, int arr[]) {
        while (start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // potential ans found
                return mid;
            }
        }
        return -1;
    }
}
