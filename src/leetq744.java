public class leetq744 {

        public static void main(String[] args) {
            char[] letters = {'b','c','e','f','h'};
//        int[]letters= new int[]{67, 66, 65, 5, 4};
            System.out.println(ceiling(letters, 'h'));


        }

        static char ceiling(char[] letters, char target) {
            int start = 0;
            int end = letters.length - 1;
//            if (target>=letters[letters.length-1]){
//                return letters[0];
//            }
//        boolean orderagniotics = arr[start] < arr[end];


            while (start <= end) {
                int middle = (start + (end - start) / 2);
//                if (arr[middle] == target) {
//                    return arr[start];
//                }

//
                if (letters[middle] <= target) {
                    start = middle + 1;
                }
                if (letters[middle] >= target) {
                    end = middle - 1;
                }
//


            }




            return letters [start% letters.length];
        }

}
