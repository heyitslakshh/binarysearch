import java.util.Arrays;

public class startingandlastindex {
    public static void main(String[] args) {
        int num[]={2,3,3,3,3,4,4,7};
        System.out.println(Arrays.toString(index(num,3)));

    }
    static int[] index(int nums[],int target){
        int ans[]={-1,-1};

       ans[0]=binary(nums,target,true);
       ans[1]=binary(nums,target,false);
       return ans;
    }
    static int binary(int nums[],int target,boolean firstindex){
        int start = 0;
        int end = nums.length - 1;
        int ans =-1;
//        if(target<nums[start]){
//            return  ans;
//        }
//


        while (start <= end) {
            int middle = (start + (end - start) / 2);
//            if (nums[middle] == target) {
//                 ans =middle;
//                return ans;
//            }

//
            if (nums[middle] < target) {
                start = middle + 1;
            }
            else if (nums[middle] >target) {
                end = middle - 1;
            }
            else {
                ans=middle;

                if (firstindex) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }

//


        }
        return ans;

    }
}
