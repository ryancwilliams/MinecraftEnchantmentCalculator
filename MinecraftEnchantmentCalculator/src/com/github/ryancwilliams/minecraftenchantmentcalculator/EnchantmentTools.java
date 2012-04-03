/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ryancwilliams.minecraftenchantmentcalculator;

/**
 *
 * @author ryanwilliams
 */
public class EnchantmentTools {
    public static Enchantment[] getPossible(int mel,Item item){
        Enchantment[] enc;
        enc = getEnchantments(item);
        enc = filterEnchantmentsPower(enc,mel);
        return enc;
    }
    public static EnchantmentPower getPower(Enchantment enc, int mel){
        EnchantmentPower powers[] = enc.getPower(mel);
        
        //return if null
        if(powers[0] == null){
            return null;
        }
        
        int max = powers.length;
        EnchantmentPower output = powers[(max - 1)];
        return output;
    }
    public static EnchantmentPower[] getPower(Enchantment[] enc, int mel){
        //Create output array
        int length = enc.length;
        EnchantmentPower[] output = new EnchantmentPower[length];
        //Prossess array
        for(int c = 0;c < length;c++) {
            output[c] = getPower(enc[c],mel);
        }
        
        return output;
    }
    public static Enchantment[] getEnchantments(Item item) {
        Enchantment enc[] = Enchantment.values();
        
        //Create output tmp list
        int length = enc.length;
        Enchantment[] encolist = new Enchantment[128];
        int encoh = 0;
        
        //Scan enc
        //run once for each Enchantment
        for (int c = 0; c < length;c++) {
            if (enc[c].checkItem(item)) {
                encolist[encoh] = enc[c];
                encoh++;
            }
        }
        
        //create short output list
        Enchantment[] output = new Enchantment[encoh];
        int oh = 0;
        for(;oh < encoh;oh++) {
            output[oh] = encolist[oh];
        }
        
        return output;
    }
    public static Enchantment[] filterEnchantmentsPower(Enchantment[] enc, int mel){
        int length = enc.length;
        
        //Create output tmp list
        Enchantment[] encolist = new Enchantment[128];
        int encoh = 0;
        
        //Scan enc
        for(int c = 0; c < length; c++) {
            if(getPower(enc[c],mel) != null){
                encolist[encoh] = enc[c];
                encoh++;
            }
        }
        
        //create short output list
        Enchantment[] output = new Enchantment[encoh];
        int oh = 0;
        for(;oh < encoh;oh++) {
            output[oh] = encolist[oh];
        }
        
        return output;
    }
    
}
