package task;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5};
        int target = -8;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index != null && index >= 0) {
                // 该值已存在map中
                if (nums[i] * 2 == target) {
                    result[0] = index;
                    result[1] = i;
                    return result;
                }
            } else {
                map.put(nums[i], i);
            }
        }

        for (int i = 0; i < nums.length - 1; i++) {
            Integer secondIndex = map.get(target - nums[i]);
            if (secondIndex != null && secondIndex > i) {
                result[0] = i;
                result[1] = secondIndex;
                break;
            }
        }

        return result;
    }
}
