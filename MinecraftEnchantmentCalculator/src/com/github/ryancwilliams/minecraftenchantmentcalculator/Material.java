/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ryancwilliams.minecraftenchantmentcalculator;

/**
 *
 * @author ryanwilliams
 */
public enum Material {
    WOOD (0,15),
    LEATHER (15,0),
    STONE (0,5),
    IRON (9,14),
    CHAIN (12,0),
    DIAMOND (10,10),
    GOLD (25,22);
    
    private final int ArmorEnc;
    private final int ToolEnc;
    
    Material(int ArmorEnc,int ToolEnc) {
        this.ArmorEnc = ArmorEnc;
        this.ToolEnc = ToolEnc;
    }
    
    public int ArmorEnc() {
        return this.ArmorEnc;
    }
    
    public int ToolEnc() {
        return this.ToolEnc;
    }
}
