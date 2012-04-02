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
            Item.HELMET,Item.CHESTPLATE,Item.LEGGINGS,Item.BOOTS),
    FIREPROTECTION ("Fire Protection",EnchantmentType.PROTECTION,10,22,18,30,26,38,34,46,-1,-1, //For 1.2.4
            Item.HELMET,Item.CHESTPLATE,Item.LEGGINGS,Item.BOOTS),
    FEATHERFALLING ("Feather Falling",EnchantmentType.GENERAL,5,15,11,21,17,27,23,33,-1,-1, //For 1.2.4
            Item.BOOTS),
    BLASTPROTECTION ("Blast Protection",EnchantmentType.PROTECTION,5,17,13,25,21,33,29,41,-1,-1, //For 1.2.4
            Item.HELMET,Item.CHESTPLATE,Item.LEGGINGS,Item.BOOTS),
    PROJECTILEPROTECTION ("Projectile Protection",EnchantmentType.PROTECTION,3,18,9,24,15,30,21,36,-1,-1, //For 1.2.4
            Item.HELMET,Item.CHESTPLATE,Item.LEGGINGS,Item.BOOTS),
    RESPRIATION ("Respiration",EnchantmentType.PROTECTION,10,40,20,50,30,60,-1,-1,-1,-1, //For 1.2.4
            Item.HELMET),
    AQUAAFFINITY ("Aqua Affinity",EnchantmentType.PROTECTION,1,41,-1,-1,-1,-1,-1,-1,-1,-1, //For 1.2.4
            Item.HELMET),
    SHARPNESS ("Protection",EnchantmentType.PROTECTION,1,21,17,37,33,53,49,69,-1,-1,
            Item.HELMET,Item.CHESTPLATE,Item.LEGGINGS,Item.BOOTS),
    SMITE ("Protection",EnchantmentType.PROTECTION,1,21,17,37,33,53,49,69,-1,-1,
            Item.HELMET,Item.CHESTPLATE,Item.LEGGINGS,Item.BOOTS),
    BANEOFARTHROPODS ("Protection",EnchantmentType.PROTECTION,1,21,17,37,33,53,49,69,-1,-1,
            Item.HELMET,Item.CHESTPLATE,Item.LEGGINGS,Item.BOOTS),
    KNOCKBACK ("Protection",EnchantmentType.PROTECTION,1,21,17,37,33,53,49,69,-1,-1,
            Item.HELMET,Item.CHESTPLATE,Item.LEGGINGS,Item.BOOTS),
    FIREASPECT ("Protection",EnchantmentType.PROTECTION,1,21,17,37,33,53,49,69,-1,-1,
            Item.HELMET,Item.CHESTPLATE,Item.LEGGINGS,Item.BOOTS),
    LOOTING ("Protection",EnchantmentType.PROTECTION,1,21,17,37,33,53,49,69,-1,-1,
            Item.HELMET,Item.CHESTPLATE,Item.LEGGINGS,Item.BOOTS),
    EFFICIENCY ("Protection",EnchantmentType.PROTECTION,1,21,17,37,33,53,49,69,-1,-1,
            Item.HELMET,Item.CHESTPLATE,Item.LEGGINGS,Item.BOOTS),
    SILKTOUCH ("Protection",EnchantmentType.PROTECTION,1,21,17,37,33,53,49,69,-1,-1,
            Item.HELMET,Item.CHESTPLATE,Item.LEGGINGS,Item.BOOTS),
    UNBREAKING ("Protection",EnchantmentType.PROTECTION,1,21,17,37,33,53,49,69,-1,-1,
            Item.HELMET,Item.CHESTPLATE,Item.LEGGINGS,Item.BOOTS),
    FORTUNE ("Protection",EnchantmentType.PROTECTION,1,21,17,37,33,53,49,69,-1,-1,
            Item.HELMET,Item.CHESTPLATE,Item.LEGGINGS,Item.BOOTS),
    POWER ("Protection",EnchantmentType.PROTECTION,1,21,17,37,33,53,49,69,-1,-1,
            Item.HELMET,Item.CHESTPLATE,Item.LEGGINGS,Item.BOOTS),
    PUNCH ("Protection",EnchantmentType.PROTECTION,1,21,17,37,33,53,49,69,-1,-1,
            Item.HELMET,Item.CHESTPLATE,Item.LEGGINGS,Item.BOOTS),
    FLAME ("Protection",EnchantmentType.PROTECTION,1,21,17,37,33,53,49,69,-1,-1,
            Item.HELMET,Item.CHESTPLATE,Item.LEGGINGS,Item.BOOTS),
    INIFINITY ("Protection",EnchantmentType.PROTECTION,1,21,17,37,33,53,49,69,-1,-1,
            Item.HELMET,Item.CHESTPLATE,Item.LEGGINGS,Item.BOOTS);
    
    
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
    private final Item[] items;
    
    Enchantment(String name, EnchantmentType type, int minLevelI, int maxLevelI,
            int minLevelII, int maxLevelII, int minLevelIII, int maxLevelIII,
            int minLevelIV, int maxLevelIV, int minLevelV, int maxLevelV, 
            Item... items){
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
        this.items = items;
        
    }
}
