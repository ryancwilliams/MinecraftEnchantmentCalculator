/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ryancwilliams.minecraftenchantmentcalculator;

/**
 *
 * @author ryanwilliams
 */
public class Calculator {
    
    private Material material;
    private Item item;
    
    private int encLevel;
    
    private int melMin;
    private int melMax;
    private double melMode;
    
    public Calculator(Material material, Item item, int enchantmentLevel){
        this.material = material;
        this.item = item;
        this.encLevel = enchantmentLevel;
    }
    void modEncLevel(){
        
        int Encb;
        // Caculate Enchantability
        if (this.item.type() == Type.ARMOR){
            Encb = this.material.ArmorEnc();
        } else if (this.item.type() == Type.TOOL) {
            Encb = this.material.ToolEnc();
        } else {
            Encb = 0;
        }
        // Caculate Enchantability if bow
        if (this.item == Item.BOW){
            Encb = 1;
        }
        
        // Caculate Min modified enchantment level
        this.melMin = this.encLevel + 1;
        // Caculate Max modified enchantment level
        this.melMax = this.encLevel + (Encb * 2) + 1;
        // Caculate Mode for modified enchantment level
        this.melMode = ((this.melMax - this.melMin) / 2) + this.melMin;
    }
}
