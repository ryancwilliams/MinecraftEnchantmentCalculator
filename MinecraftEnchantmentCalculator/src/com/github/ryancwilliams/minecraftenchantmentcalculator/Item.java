/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ryancwilliams.minecraftenchantmentcalculator;

/**
 *
 * @author ryanwilliams
 */
public enum Item {
    
    //Enum Names and Values
    HELMET (Type.ARMOR),
    CHESTPLATE (Type.ARMOR),
    LEGGINGS (Type.ARMOR),
    BOOTS (Type.ARMOR),
    SWORD (Type.TOOL),
    PICKAXE (Type.TOOL),
    SHOVEL (Type.TOOL),
    AXE (Type.TOOL),
    BOW (Type.TOOL);
    
    //Constants for the enum
    private final Type type;
    //Deffination of the Enum Values
    Item(Type type){
        this.type = type;
    }
    //Functions
    public Type type(){
        return this.type;
    }
}
