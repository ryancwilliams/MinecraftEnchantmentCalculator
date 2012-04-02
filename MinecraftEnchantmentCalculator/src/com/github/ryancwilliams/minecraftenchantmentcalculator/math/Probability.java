/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ryancwilliams.minecraftenchantmentcalculator.math;

/**
 *
 * @author ryanwilliams
 */
public class Probability {
    public static double TriangularDistribution(double value, double min, double max, double mode){
        if (value < min){
            return 0;
        } else if ((min <= value) && (value <= mode)){
            return (2 * (value - min))/((max - min) * (mode - min));
        } else if ((mode < value) && (value <= max)){
            return (2 * (max - value))/((max - min)*(max - mode));
        } else if (max < value){
            return 0;
        }
        return -1;
    }
}
