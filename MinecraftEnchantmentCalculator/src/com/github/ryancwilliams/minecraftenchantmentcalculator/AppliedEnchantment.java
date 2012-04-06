/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ryancwilliams.minecraftenchantmentcalculator;

/**
 *
 * @author ryanwilliams
 */
public class AppliedEnchantment {
    public final EnchantmentSet available;
    public final Enchantment enchantment;
    public final EnchantmentPower power;
    
    public AppliedEnchantment(EnchantmentSet available,Enchantment enchantment,EnchantmentPower power) {
        this.available = available;
        this.enchantment = enchantment;
        this.power = power;
    }
    public double getProbability() {
        return EnchantmentProbabilityTools.getProbability(this.available.mel, this.available.depth, this.available.enchantments, this.enchantment);
    }
}
