package com.jstarcraft.ai.math.algorithm.correlation;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.jstarcraft.ai.math.algorithm.correlation.distance.AngularDistanceTestCase;
import com.jstarcraft.ai.math.algorithm.correlation.distance.ChebychevDistanceTestCase;
import com.jstarcraft.ai.math.algorithm.correlation.distance.EuclideanDistanceTestCase;
import com.jstarcraft.ai.math.algorithm.correlation.distance.HammingDistanceTestCase;
import com.jstarcraft.ai.math.algorithm.correlation.distance.LevensteinDistanceTestCase;
import com.jstarcraft.ai.math.algorithm.correlation.distance.MSDDistanceTestCase;
import com.jstarcraft.ai.math.algorithm.correlation.distance.MSEDistanceTestCase;
import com.jstarcraft.ai.math.algorithm.correlation.distance.ManhattanDistanceTestCase;
import com.jstarcraft.ai.math.algorithm.correlation.distance.NormDistanceTestCase;
import com.jstarcraft.ai.math.algorithm.correlation.distance.SpearmanFootruleDistanceTestCase;

@RunWith(Suite.class)
@SuiteClasses({
        // 距离测试集
        AngularDistanceTestCase.class,

        ChebychevDistanceTestCase.class,

        EuclideanDistanceTestCase.class,

        HammingDistanceTestCase.class,

        LevensteinDistanceTestCase.class,

        ManhattanDistanceTestCase.class,

        MSDDistanceTestCase.class,

        MSEDistanceTestCase.class,

        NormDistanceTestCase.class,

        SpearmanFootruleDistanceTestCase.class })
public class DistanceTestSuite {

}