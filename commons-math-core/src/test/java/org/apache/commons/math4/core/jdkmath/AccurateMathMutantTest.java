package org.apache.commons.math4.core.jdkmath;

import org.junit.Test;

public class AccurateMathMutantTest {
    double a;
    @Test
    public void testMutants2(){
        a = 0.9;
        assert(AccurateMath.asinh(a) != AccurateMathMutant.asinh2(a));
    }
    @Test
    public void testMutants3(){
        a = 0.9;
        assert(AccurateMath.asinh(a) != AccurateMathMutant.asinh3(a));
    }
    @Test
    public void testMutants4(){
        a = -0.9;
        assert(AccurateMath.asinh(a) != AccurateMathMutant.asinh4(a));
    }
    @Test
    public void testMutants5(){
        a = -0.9;
        assert(AccurateMath.asinh(a) != AccurateMathMutant.asinh5(a));
    }
    @Test
    public void testMutants6(){
        a = 0.167;
        assert(AccurateMath.asinh(a) != AccurateMathMutant.asinh6(a));
    }
    @Test
    public void testMutants7(){
        a = 0.5;
        assert(AccurateMath.asinh(a) != AccurateMathMutant.asinh7(a));
    }
    @Test
    public void testMutants8(){
        a = 0.1;
        assert(AccurateMath.asinh(a) != AccurateMathMutant.asinh8(a));
    }
    @Test
    public void testMutants9(){
        a = 0.0965;
        assert(AccurateMath.asinh(a) != AccurateMathMutant.asinh9(a));
    }
    @Test
    public void testMutants10(){
        a = 0.12;
        assert(AccurateMath.asinh(a) != AccurateMathMutant.asinh10(a));
    }
    @Test
    public void testMutants11(){
        a = 0.036;
        assert(AccurateMath.asinh(a) != AccurateMathMutant.asinh11(a));
    }
    @Test
    public void testMutants12(){
        a = 0.05;
        assert(AccurateMath.asinh(a) != AccurateMathMutant.asinh12(a));
    }
    @Test
    public void testMutants13(){
        a = 0.0036;
        assert(AccurateMath.asinh(a) != AccurateMathMutant.asinh13(a));
    }
    @Test
    public void testMutants14(){
        a = 0.0066;
        assert(AccurateMath.asinh(a) != AccurateMathMutant.asinh14(a));
    }
    @Test
    public void testMutants15(){
        a = 0.0021;
        assert(AccurateMath.asinh(a) != AccurateMathMutant.asinh15(a));
    }
    @Test
    public void testMutants16(){
        a = .4;
        assert(AccurateMath.asinh(a) != AccurateMathMutant.asinh16(a));
    }


}
