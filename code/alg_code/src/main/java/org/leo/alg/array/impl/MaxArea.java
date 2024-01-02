package org.leo.alg.array.impl;

import org.leo.alg.BaseAlg;

/**
 * @Author zhaorongsheng
 * @Date 2024/1/2 20:14
 * @Version 1.0
 * @Description 盛最多水容器：https://leetcode.cn/problems/container-with-most-water/description/
 */
public class MaxArea extends BaseAlg {
    private int[] height;


    @Override
    protected void prepare() {
        height = new int[]{1,8,6,2,5,4,8,3,7};
    }

    @Override
    protected void run() {
        Integer maxAree = calc(height);
        assert maxAree == 49;

    }

    private int calc(int[] height) {
        if (height == null || height.length < 2) {
            return -1;
        }

        int i =0, j = height.length - 1;
        int maxArea = -1;
        while (i < j) {
            // 计算当前面积，如果大于最大值，则更新
            int curArea = (j - i) * Math.min(height[i], height[j]);
            if (curArea > maxArea) {
                maxArea = curArea;
            }
            // 移动高度小的模板（高度高的模板移动，肯定比当前小，故无需移动）
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxArea;

    }
}
