/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ryancwilliams.minecraftenchantmentcalculator;

/**
 *
 * @author ryanwilliams
 */
public enum Enchantment {
    
    PROTECTION ("Protection",EnchantmentType.PROTECTION,1,21,17,37,33,53,49,69,-1,-1, //For 1.2.4
            10,Item.HELMET,Item.CHESTPLATE,Item.LEGGINGS,Item.BOOTS),
    FIREPROTECTION ("Fire Protection",EnchantmentType.PROTECTION,10,22,18,30,26,38,34,46,-1,-1, //For 1.2.4
            5,Item.HELMET,Item.CHESTPLATE,Item.LEGGINGS,Item.BOOTS),
    FEATHERFALLING ("Feather Falling",EnchantmentType.GENERAL,5,15,11,21,17,27,23,33,-1,-1, //For 1.2.4
            5,Item.BOOTS),
    BLASTPROTECTION ("Blast Protection",EnchantmentType.PROTECTION,5,17,13,25,21,33,29,41,-1,-1, //For 1.2.4
            2,Item.HELMET,Item.CHESTPLATE,Item.LEGGINGS,Item.BOOTS),
    PROJECTILEPROTECTION ("Projectile Protection",EnchantmentType.PROTECTION,3,18,9,24,15,30,21,36,-1,-1, //For 1.2.4
            5,Item.HELMET,Item.CHESTPLATE,Item.LEGGINGS,Item.BOOTS),
    RESPRIATION ("Respiration",EnchantmentType.GENERAL,10,40,20,50,30,60,-1,-1,-1,-1, //For 1.2.4
            2,Item.HELMET),
    AQUAAFFINITY ("Aqua Affinity",EnchantmentType.GENERAL,1,41,-1,-1,-1,-1,-1,-1,-1,-1, //For 1.2.4
            2,Item.HELMET),
    SHARPNESS ("Sharpness",EnchantmentType.DAMAGE,1,21,17,37,33,53,49,69,65,85, //For 1.2.4
            10,Item.SWORD),
    SMITE ("Smite",EnchantmentType.DAMAGE,5,25,13,33,21,41,29,49,37,57, //For 1.2.4
            5,Item.SWORD),
    BANEOFARTHROPODS ("Bane of Arthropods",EnchantmentType.DAMAGE,5,25,13,33,21,41,29,49,37,57, //For 1.2.4
            5,Item.SWORD),
    KNOCKBACK ("Knockback",EnchantmentType.GENERAL,5,55,25,75,-1,-1,-1,-1,-1,-1, //For 1.2.4
            5,Item.SWORD),
    FIREASPECT ("Fire Aspect",EnchantmentType.GENERAL,10,60,30,80,-1,-1,-1,-1,-1,-1, //For 1.2.4
            2,Item.SWORD),
    LOOTING ("Looting",EnchantmentType.GENERAL,20,70,32,82,44,94,-1,-1,-1,-1, //For 1.2.4
            2,Item.SWORD),
    EFFICIENCY ("Efficiency",EnchantmentType.GENERAL,1,51,16,66,31,81,46,96,61,111, //For 1.2.4
            10,Item.PICKAXE,Item.SHOVEL,Item.AXE),
    SILKTOUCH ("Silk Touch",EnchantmentType.MINING,25,75,-1,-1,-1,-1,-1,-1,-1,-1, //For 1.2.4
            1,Item.PICKAXE,Item.SHOVEL,Item.AXE),
    UNBREAKING ("Unbreaking",EnchantmentType.GENERAL,5,55,15,65,25,75,-1,-1,-1,-1, //For 1.2.4
            5,Item.PICKAXE,Item.SHOVEL,Item.AXE),
    FORTUNE ("Fortune",EnchantmentType.MINING,20,70,32,82,44,94,-1,-1,-1,-1, //For 1.2.4
            2,Item.PICKAXE,Item.SHOVEL,Item.AXE),
    POWER ("Power",EnchantmentType.GENERAL,1,16,11,26,21,36,31,46,41,56, //For 1.2.4
            10,Item.BOW),
    PUNCH ("Punch",EnchantmentType.GENERAL,12,37,32,57,-1,-1,-1,-1,-1,-1, //For 1.2.4
            2,Item.BOW),
    FLAME ("Flame",EnchantmentType.GENERAL,20,50,-1,-1,-1,-1,-1,-1,-1,-1, //For 1.2.4
            2,Item.BOW),
    INIFINITY ("Infinity",EnchantmentType.GENERAL,20,50,-1,-1,-1,-1,-1,-1,-1,-1, //For 1.2.4
            1,Item.BOW);
    
    
    private final String name;
    private final EnchantmentType type;
    private final int minLevelI;
    private final int maxLevelI;
    private final int minLevelII;
    private final int maxLevelII;
    private final int minLevelIII;
    private final int maxLevelIII;
    private final int minLevelIV;
    private final int maxLevelIV;
    private final int minLevelV;
    private final int maxLevelV;
    private final int weight;
    private final Item[] items;
    
    Enchantment(String name, EnchantmentType type, int minLevelI, int maxLevelI,
            int minLevelII, int maxLevelII, int minLevelIII, int maxLevelIII,
            int minLevelIV, int maxLevelIV, int minLevelV, int maxLevelV, 
            int weight, Item... items){
        this.name = name;
        this.type = type;
        this.minLevelI = minLevelI;
        this.maxLevelI = maxLevelI;
        this.minLevelII = minLevelII;
        this.maxLevelII = maxLevelII;
        this.minLevelIII = minLevelIII;
        this.maxLevelIII = maxLevelIII;
        this.minLevelIV = minLevelIV;
        this.maxLevelIV = maxLevelIV;
        this.minLevelV = minLevelV;
        this.maxLevelV = maxLevelV;
        this.weight = weight;
        this.items = items;
        
    }
    /**
     * Returns the name of the enchantment
     * @return the name of the enchantment
     */
    @Override
    public String toString() {
        return this.name;
    }
    public String getName() {
        return this.name;
    }
    public EnchantmentType getType() {
        return this.type;
    }
    public int getMin(EnchantmentPower power) {
        int output;
        switch (power) {
            case I: 
                output = this.minLevelI; 
                break;
            case II:
                output = this.minLevelII; 
                break;
            case III: 
                output = this.minLevelIII; 
                break;
            case IV: 
                output = this.minLevelIV; 
                break;
            case V: 
                output = this.minLevelV; 
                break;
            default: 
                output = -1;
                break;
        }
        return output;
    }
    public int getMax(EnchantmentPower power) {
        int output;
        switch (power) {
            case I: 
                output = this.maxLevelI; 
                break;
            case II:
                output = this.maxLevelII; 
                break;
            case III: 
                output = this.maxLevelIII; 
                break;
            case IV: 
                output = this.maxLevelIV; 
                break;
            case V: 
                output = this.maxLevelV; 
                break;
            default: 
                output = -1;
                break;
        }
        return output;
    }
    public Item[] getItems() {
        return this.items;
    }
    public boolean checkItem(Item item) {
        int length = this.items.length;
        //run once per element in this.items[]
        for(int c = 0; c < length; c++) {
            //Check if item is = to item at items[c]
            if(item.equals(this.items[c])){
                return true;
            }
        }
        return false;
    }
    public EnchantmentPower[] getPower(int mel) {
        int ac = 0; // Array counter
        
        // Power Flags
        boolean I = false;
        boolean II = false;
        boolean III = false;
        boolean IV = false;
        boolean V = false;
        
        // Check Powers
        // I
        if(this.checkPower(EnchantmentPower.I, mel)){
            ac++;
            I = true;
        }
        // II
        if(this.checkPower(EnchantmentPower.II, mel)){
            ac++;
            II = true;
        }
        // III
        if(this.checkPower(EnchantmentPower.III, mel)){
            ac++;
            III = true;
        }
        // IV
        if(this.checkPower(EnchantmentPower.IV, mel)){
            ac++;
            IV = true;
        }
        // V
        if(this.checkPower(EnchantmentPower.V, mel)){
            ac++;
            V = true;
        }
        
        //Return If None
        if(!I && !II && !III && !IV && !V){
            EnchantmentPower[] output = {null};
            return output;
        }
        
        //Create output array  
        EnchantmentPower[] output = new EnchantmentPower[ac];
        int ah = 0; //array head
        
        //load array
        //I
        if(I){
            output[ah] = EnchantmentPower.I;
            ah++;
        }
        //II
        if(II){
            output[ah] = EnchantmentPower.II;
            ah++;
        }
        //III
        if(III){
            output[ah] = EnchantmentPower.III;
            ah++;
        }
        //IV
        if(IV){
            output[ah] = EnchantmentPower.IV;
            ah++;
        }
        //V
        if(V){
            output[ah] = EnchantmentPower.V;
            ah++;
        }
        
        return output;
    }
    public boolean checkPower(EnchantmentPower power,int mel) {
        if((this.getMin(power) <= mel) && (mel <= this.getMax(power))){
            return true;
        } else {
            return false;
        }
    }
    public int getWeight() {
        return this.weight;
    }
}
