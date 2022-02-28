import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;


/*
Given an array nums containing n distinct numbers in the range [0, n],
 return the only number in the range that is missing from the array.
 */

class Program {

    public static int missing(int [] nums){
        int length = nums.length;
        int vectorSum = 0, sum = 0;
        for(int i=0; i<length; ++i){
            vectorSum += nums[i];
            sum += i;
        }
        sum += length;
        if(sum == vectorSum)
            return 0;
        return sum - vectorSum;
    }

    public static void main(String[] args) {
        int[] numbers = new int[3];
        numbers[0] = 3;
        numbers[1] = 0;
        numbers[2] = 1;
        System.out.print(missing(numbers));
    }
}
