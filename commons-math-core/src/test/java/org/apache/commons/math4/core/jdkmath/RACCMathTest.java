package org.apache.commons.math4.core.jdkmath;

import org.junit.Test;

public class RACCMathTest {
    @Test
    public void testMC1(){
        assert(AccurateMath.cbrt(AccurateMath.pow(10,1024)) == Double.POSITIVE_INFINITY);
    }
    @Test
    public void testMC1b(){
        assert(AccurateMath.cbrt(1) == 1.0);
    }

    @Test
    public void testMC2(){
        assert(AccurateMath.cbrt(AccurateMath.pow(10,-1023)) == 0);
    }

    /**
     * Cuberoot of 1e310 calculated to be around 2.15e103
     */
    @Test
    public void testMC3(){
        double cbrt = AccurateMath.cbrt(1e-310);
        assert(cbrt > 1e-104 && cbrt < 1e-103 );
    }
}
