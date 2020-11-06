package com.example.skill.overflow;

/**
 * @author : wangye
 * @date: 2020-09-15
 * @description:
 *
 * 在之前刷题的时候遇见一个问题，需要解决int相加后怎么判断是否溢出，如果溢出就返回Integer.MAX_VALUE
 *
 *
 * 直接调用是最方便的，但是为了追求速度，应该修改一下，理解判断思路，因为异常是十分耗时的操作，无脑异常有可能超时
 */
public class Test {
    public static int addExact(int x, int y) {
        int r = x + y;
        // HD 2-12 Overflow iff both arguments have the opposite sign of the result
        if (((x ^ r) & (y ^ r)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return r;
    }

    public static int subtractExact(int x, int y) {
        int r = x - y;
        // HD 2-12 Overflow iff the arguments have different signs and
        // the sign of the result is different than the sign of x
        if (((x ^ y) & (x ^ r)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return r;
    }

    public static int multiplyExact(int x, int y) {
        long r = (long)x * (long)y;
        if ((int)r != r) {
            throw new ArithmeticException("integer overflow");
        }
        return (int)r;
    }

    /**注意 long和int是不一样的
     *
     * @param x
     * @param y
     * @return
     */
    public static long multiplyExact(long x, long y) {
        long r = x * y;
        long ax = Math.abs(x);
        long ay = Math.abs(y);
        if (((ax | ay) >>> 31 != 0)) {
            // Some bits greater than 2^31 that might cause overflow
            // Check the result using the divide operator
            // and check for the special case of Long.MIN_VALUE * -1
            if (((y != 0) && (r / y != x)) ||
                    (x == Long.MIN_VALUE && y == -1)) {
                throw new ArithmeticException("long overflow");
            }
        }
        return r;
    }


    public static void main(String[] args) {
        int i = Test.addExact(45, 50);
        System.out.println(i);
    }
}
