package org.leo.alg.array.impl;

import org.leo.alg.BaseAlg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zhaorongsheng
 * @Date 2024/1/3 20:02
 * @Version 1.0
 * @Description 三数之和： https://leetcode.cn/problems/3sum/submissions/
 */
public class ThreeNumSum extends BaseAlg {
    private int[] nums;

    @Override
    protected void prepare() {
        nums = new int[]{-1,0,1,2,-1,-4};
    }

    @Override
    protected void run() {
        List<List<Integer>> res = threeSum(nums);
        assert res.size() == 2 && res.get(0).size() == 3 && res.get(1).size() == 3;

    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            // 不合法数据删除
            return null;
        }
        // 排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] > 0) {
                // 排序后，如果第一个元素大于0，则后面的和肯定不可能等于0，直接返回
                break;
            }
            if (index > 0 && nums[index] == nums[index - 1]) {
                // 和上个元素一样，直接忽略此值，避免出现重复结果
                continue;
            }
            int left = index + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[index] + nums[left] + nums[right] == 0) {
                    result.add(Arrays.asList(nums[index], nums[left], nums[right]));
                    // 移除相同的数据，不重复添加
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[index] + nums[left] + nums[right] < 0) {
                    left++;
                } else if (nums[index] + nums[left] + nums[right] > 0) {
                    right--;
                }
            }
        }
        return result;
    }
}
