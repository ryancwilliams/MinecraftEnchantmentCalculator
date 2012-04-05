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
    
    private AppliedEnchantment[] subs;
    private boolean hasSubs = false;
    
    public AppliedEnchantment(EnchantmentSet available,Enchantment enchantment,EnchantmentPower power) {
        this.available = available;
        this.enchantment = enchantment;
        this.power = power;
    }
    public AppliedEnchantment[] getSubs() {
        return this.subs;
    }
    public void applyEnchantments() {
        this.subs = EnchantmentTools.applyEnchantments(available);
        this.hasSubs = true;
    }
    public void applyEnchantments(int times) {
        this.applyEnchantments();
        times--;
        
        int length = this.subs.length;
        
        for (int c = 0;c < length;c++) {
            this.subs[c].applyEnchantments(times);
        }
    }
    public boolean hasSubs() {
        return this.hasSubs;
    }
}
