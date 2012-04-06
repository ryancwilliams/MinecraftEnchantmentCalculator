/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ryancwilliams.minecraftenchantmentcalculator;

/**
 *
 * @author ryanwilliams
 */
public class EnchantmentSet {
    public final Enchantment[] enchantments;
    public final EnchantmentPower[] power;
    public final int mel;
    // Legacy Constructer
    public EnchantmentSet(Enchantment[] enchantments, EnchantmentPower[] power) {
        this(0,enchantments,power);
    }
    public EnchantmentSet(int mel, Enchantment[] enchantments, EnchantmentPower[] power) {
        this.mel = mel;
        this.enchantments = enchantments;
        this.power = power;
    }
    public EnchantmentPower getPower(Enchantment enchantment) {
        int length = this.enchantments.length;
        
        for(int c = 0;c < length;c++){
            if(this.enchantments[c]==enchantment){
                return this.power[c];
            }
        }
        return null;
    }
}
