public class mountain {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,11,10,9,8,7};
        System.out.println(mountain(arr));
    }
    static int mountain(int arr[]){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int middle=start+(end-start)/2;
            if(arr[middle]>arr[middle+1]){
                end=middle;
            }
            else{
                start=middle+1;

            }

        }
        return start;
    }
}
