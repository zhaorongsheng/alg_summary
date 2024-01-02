package org.leo.alg.array.impl;

import org.leo.alg.BaseAlg;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhaorongsheng
 * @Date 2024/1/2 19:43
 * @Version 1.0
 * @Description 题目：https://leetcode.cn/problems/two-sum/
 */
public class TwoSum extends BaseAlg {
    private int[] nums;
    private int target;

    @Override
    public void prepare() {
        nums = new int[]{2,7,11,15};
        target = 9;
    }

    @Override
    public void run() {
        int[] result = getIndex(nums, target);
        assert result != null && result.length == 2;
        assert result[0] == 0 && result[1] == 1;

    }

    /**
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     * @param nums
     * @param target
     * @return
     */
    private int[] getIndex(int[] nums, int target) {
        if (nums == null && nums.length < 2) {
            return null;
        }

        // 通过hash表，降低查找target-x的时间复杂度
        Map<Integer, Integer> valueIndex = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            // 获取目标值
            int targetValue = target - nums[index];
            // 获取目标值对应的索引
            Integer targetIndex = valueIndex.getOrDefault(targetValue, null);
            if (targetIndex != null) {
                // 找到索引，则配对成功，返回
                return new int[]{targetIndex, index};
            } else {
                // 未找到索引，则加入map中
                valueIndex.put(nums[index], index);
            }
        }
        return null;
    }
}
