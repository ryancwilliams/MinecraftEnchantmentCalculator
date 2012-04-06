/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ryancwilliams.minecraftenchantmentcalculator.math;

/**
 *
 * @author ryanwilliams
 */
public class Factorial {
    /**
     * Calculates the factorial of a number
     * @param n the number (must be less than 20)
     * @return the factorial of that number (0 if the input is > 20 because of overflow error)
     */
    public static long Factorial(byte n) {
        // Create output varable
        long out = 1;
        //Remove values out of range of this function
        if(n > 20) {
            return 0;
        }
        // Caculate fatorial
        if(n == 0) {
            return 1;
        }
        for(;n > 0;n--) {
            out = out * n;
        }
        // Return factorial
        return out;
    }
}
