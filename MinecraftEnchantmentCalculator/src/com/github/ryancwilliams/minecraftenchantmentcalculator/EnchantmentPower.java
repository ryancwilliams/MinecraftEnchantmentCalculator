/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ryancwilliams.minecraftenchantmentcalculator;

/**
 *
 * @author ryanwilliams
 */
public enum EnchantmentPower {
    I (1),
    II (2),
    III (3),
    IV (4),
    V (5);
    
    private final int power;
    
    EnchantmentPower(int power){
        this.power = power;  
    }
    
    public int getPower(){
        return this.power;
    }
}
