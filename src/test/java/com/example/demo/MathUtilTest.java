package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathUtilTest {
    //funktsiooniNimi_sisend_eeldatavVäljund
    @Test
    public void neg_negative_negative(){
        int result=MathUtil.neg(-4);
        assertEquals(-4,result);
    }

    @Test
    public void neg_positive_negative(){
        int result=MathUtil.neg(4);
        assertEquals(-4,result);
    }

    @Test
    public void min_positive(){
        int result=MathUtil.min(2,1);
        assertEquals(1,result);
    }

    @Test
    public void min_negative(){
        int result=MathUtil.min(-2,-1);
        assertEquals(-2,result);
    }

    @Test
    public void abs_negative_positive(){
        int result=MathUtil.abs(-3);
        assertEquals(3, result);
    }

    @Test
    public void isNumberEven_even_true(){
        boolean result=MathUtil.isNumberEven(2);
        assertTrue(result);
    }

    @Test
    public void isNumberEven_notEven_false(){
        boolean result=MathUtil.isNumberEven(1);
        assertFalse(result);
    }


    @Test
    public void closestToZero_positive(){
        int result=MathUtil.closestToZero(2,3,4);
        assertEquals(2,result);
    }

    @Test
    public void fibonacci1(){
        int result=MathUtil.fibonacci1(4);
        assertEquals(2,result);
    }
}
