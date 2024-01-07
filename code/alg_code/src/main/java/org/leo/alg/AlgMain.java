package org.leo.alg;

import org.leo.alg.array.impl.ColorClassify;
import org.leo.alg.array.impl.MaxArea;
import org.leo.alg.array.impl.ThreeNumSum;
import org.leo.alg.array.impl.TwoSum;
import org.leo.alg.string.LongestSubStrWORepeat;

import java.util.Arrays;
import java.util.List;

/**
 * @Author zhaorongsheng
 * @Date 2024/1/2 19:40
 * @Version 1.0
 */
public class AlgMain {

    public static void main(String[] args) {
        List<BaseAlg> algList = Arrays.asList(
            // 数组相关算法
//                new TwoSum(),
//                new MaxArea(),
                // new ThreeNumSum(),
                // new ColorClassify(),
                // 字符串相关
                new LongestSubStrWORepeat()

        );
        algList.forEach(BaseAlg::start);

    }
}
