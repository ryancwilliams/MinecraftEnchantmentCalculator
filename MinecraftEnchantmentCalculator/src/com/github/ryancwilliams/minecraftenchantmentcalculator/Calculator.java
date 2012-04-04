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
    private int melSize;
    
    private EnchantmentSet[] enc; // Array for possible enchantments
    private int encSize;
    
    private int depth = 1;
    
    private AppliedEnchantment[][] enca;
    
    public Calculator(Material material, Item item, int enchantmentLevel){
        this.material = material;
        this.item = item;
        this.encLevel = enchantmentLevel;
    }
    public void calculate() {
        this.modEncLevel();
        this.generateEnchantments();
        this.calculateDepth();
        
    }
    private void modEncLevel(){
        
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
    private void generateEnchantments() {
        
        this.melSize = this.melMax-this.melMin;
        
        //Create array
        this.enc = new EnchantmentSet[this.melSize];
        
        //Create the sets.
        for(int c = 0;c < this.melSize;c++) {
            //calucate mel for this set
            int melc = c + this.melMin;
            //generate enchantmentSet and then
            //add to array
            this.enc[c] = EnchantmentTools.getPossibleSet(melc, this.item);
        }
        
        this.encSize = this.enc[0].enchantments.length;
    }
    private void calculateDepth() {
        int meld = this.melMax;
        while(meld >=2) {
            meld = meld/2;
            this.depth++;
        }
    }
    private void applyEnchantments() {
        this.enca = new AppliedEnchantment[this.melSize][this.enc.length];
        
        //Create appliedEnchantments
        //Run once per mel
        for(int c = 0; c < this.melSize;c++) {
            this.enca[c] = EnchantmentTools.applyEnchantments(this.enc[c]);
        }
        
        //Generate subs for appliedEnchantments
        //Run once per mel
        for(int c = 0;c < this.melSize;c++) {
            //Run once per Enc
            for(int e = 0;c < this.encSize;c++) {
                this.enca[c][e].applyEnchantments(this.depth-1);
            }
        }
    }
}
