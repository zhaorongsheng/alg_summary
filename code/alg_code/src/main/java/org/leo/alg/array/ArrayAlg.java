package org.leo.alg.array;

import org.leo.alg.BaseAlg;
import org.leo.alg.array.impl.MaxArea;
import org.leo.alg.array.impl.TwoSum;

import java.util.Arrays;
import java.util.List;

/**
 * @Author zhaorongsheng
 * @Date 2024/1/2 19:40
 * @Version 1.0
 */
public class ArrayAlg {

    public static void main(String[] args) {
        List<BaseAlg> algList = Arrays.asList(
//                new TwoSum(),
                new MaxArea()
        );
        algList.forEach(BaseAlg::start);

    }
}
