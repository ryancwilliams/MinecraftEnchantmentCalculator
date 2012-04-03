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
    public EnchantmentSet(Enchantment[] enchantments, EnchantmentPower[] power) {
        this.enchantments = enchantments;
        this.power = power;
    }
}
