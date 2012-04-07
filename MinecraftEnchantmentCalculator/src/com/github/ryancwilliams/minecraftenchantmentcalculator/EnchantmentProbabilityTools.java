/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ryancwilliams.minecraftenchantmentcalculator;

import com.github.ryancwilliams.minecraftenchantmentcalculator.math.Factorial;

/**
 *
 * @author ryanwilliams
 */
public class EnchantmentProbabilityTools {
    private static int calculateTWeight(Enchantment[] enc) {
        int length = enc.length;
        int weight = 0;
        for(int c = 0;c < length;c++) {
            weight = weight + enc[c].getWeight();
        }
        return weight;
    }
    private static double caculateSubP(int mel) {
        double out;
        out = (mel + 1)/50;
        return out;
    }
    /**
     * Gets the probability that a enchantment set will be selected.
     * @param mel the mel of this enchantment set
     * @param depth the depth to calculate to
     * @param enca the set of enchantments to chose from
     * @param enc the enchantments in the set to check
     * @return the probability of that enchantment set without the mel probability
     */
    public static double getProbability(int mel, int depth, Enchantment[] enca, Enchantment... enc) {
        int length = enc.length;
        int tweight = calculateTWeight(enca);
        // Create output varable
        double prob;
        
        prob = caculateTSubP(mel, depth) * caculateTEncP(tweight,enc) * Factorial.Factorial( (byte)depth);
        
        return prob;
    }
    private static double caculateTSubP(int mel,int depth) {
        double out = 1;
        for(;depth > 0;depth--) {
            int lel = caculateMel(mel, depth);
            out = out * caculateSubP(lel);
        }
        return out;
    }
    //BUG caculateTEncP does not account for Conflicting enchantments
    private static double caculateTEncP(int tweight,Enchantment... enc) {
        int prams = enc.length;
        int tw = tweight;
        double out = 1;
        for(int c = 0;c < prams;c++) {
            int cw = enc[c].getWeight();
            double cp = cw/tw;
            out = out * cp;
            tw = tw - cw;
        }
        return out;
    }
    /**
     * Calculates the mel for the depth
     * @param mel the mel
     * @param depth the depth to calculate to
     * @return the mel for the depth
     */
    private static int caculateMel(int mel,int depth) {
        int out = (mel/(2 ^ depth));
        return out;
    }
    /**
     * Calculates the weight of the conflicting enchantments. Does not remove 
     * the weight of the enchantment being applied. 
     * @param enca The available enchantments
     * @param enc The enchantment being applied.
     * @return The weight of the conflicting enchantments
     */
    private static int caculateCWeight(Enchantment[] enca,Enchantment enc) {
        int length = enca.length;
        int weight = 0;
        for(int c = 0;c < length;c++) {
            Enchantment cenc = enca[c];
            if(EnchantmentTools.isConflicting(cenc, enc)){
                //Check if same enchantment
                if(cenc == enc) {
                    //Do nothing Because this does not remove the weight of the curent enchantment
                } else {
                    weight = weight + cenc.getWeight();
                }
                
            }
        }
        return weight;
    }
}
