import java.util.Arrays;

public class SortedSearch {
    private static int recurMidIndex(int start, int end, int lessThan, int[] sortedArray) {
        if (sortedArray.length == 0) {
            return 0;
        }
        int mid = start + (end - start)/2;
        if (sortedArray[mid] == lessThan) {
            return mid;
        }
        if (mid <= start) {//end - start =2
            if (sortedArray[mid] < lessThan) {
                if (mid +1 >= end) {
                    return mid;
                } else if (sortedArray[mid+1] >= lessThan) {
                    return mid+1;
                }
            } else {
                return mid-1;
            }
        }
        if (sortedArray[mid] > lessThan) {
            end = mid;
        } else {
            start = mid;
        }
        return recurMidIndex(start, end, lessThan, sortedArray);
    }

    public static int countNumbers(int[] sortedArray, int lessThan) {
        //return (int)Arrays.stream(sortedArray).dropWhile(i -> i < lessThan).count();
        int mid = (int)Math.ceil(sortedArray.length / 2.0) -1;

        return recurMidIndex(0, sortedArray.length, lessThan, sortedArray) +1;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 3, 5, 7 }, 4));
    }
}
