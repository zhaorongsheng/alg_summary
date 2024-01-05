package org.leo.alg.array.impl;

import org.leo.alg.BaseAlg;

/**
 * @Author zhaorongsheng
 * @Date 2024/1/5 20:14
 * @Version 1.0
 * @Description 颜色分类：https://leetcode.cn/problems/sort-colors/description/
 */
public class ColorClassify extends BaseAlg {
    private int[] nums;
    @Override
    protected void prepare() {
        nums = new int[]{2,0,2,1,1,0};
    }

    @Override
    protected void run() {
        sortColors(nums);
        println(nums);
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        // i表示放0的当前位置，j表示放1的当前位置，k表示放2的当前位置
        int i = 0, j = nums.length - 1;
        int index = 0;
        while (index < nums.length && i < j && index <= j) {
            if (nums[index] == 0) {
                swap(index, i, nums);
                index++;
                i++;
            } else if (nums[index] == 1) {
                index++;
            } else if (nums[index] == 2) {
                swap(index, j, nums);
                j--;
            } else {
                return;
            }
        }
    }

    public void swap(int i, int j, int[] nums) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
