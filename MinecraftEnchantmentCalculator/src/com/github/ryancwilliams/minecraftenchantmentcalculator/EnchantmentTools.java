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
    public static EnchantmentSet getPossibleSet(int mel, Item item){
        Enchantment[] se = getPossible(mel,item);
        EnchantmentPower[] sp = getPower(se,mel);
        EnchantmentSet output = new EnchantmentSet(mel,0,se,sp);
        return output;
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
    /**
     * Removes enchantments that conflict with a enchantment from a array.
     * @param possible The array of enchantments
     * @param enchantment The enchantment to check against
     * @return A array that contains the non-conflicting enchantments
     */
    public static Enchantment[] removeConflict(Enchantment[] possible,Enchantment enchantment) {
        int length = possible.length;
        
        boolean[] valid = new boolean[length]; //Result flags
        int inh = 0; //Search Counter
        for(int c = 0;c < length;c++) {
            if(isConflicting(possible[c],enchantment)){
                valid[c] = false;
            } else {
                valid[c] = true;
                inh++;
            }
        }
        
        Enchantment[] oute = new Enchantment[inh]; //Output array with size from counter
        int outh = 0; //Out head
        
        for(int c = 0;c < length;c++){
            if(valid[c]){
                oute[outh] = possible[c];
                outh++;
            }
        }
        
        return oute;
    } 
    /**
     * Checks if 2 enchantments conflict with each other
     * @param enca The first Enchantment
     * @param encb The second Enchantment
     * @return TRUE if the enchantments conflict
     */
    public static boolean isConflicting(Enchantment enca,Enchantment encb) {
        //Check if same enchantment
        if(enca==encb){
            return true;
        }
        //Check if same type
        if(enca.getType()==encb.getType()){
            //Check if EnchantmentType is GENERAL and return false if true
            if(enca.getType()==EnchantmentType.GENERAL){
                return false;
            } else {
                return true;
            }
        }
        //Return false if not returned aready
        return false;
    }
    public static int getWeightSum(Enchantment[] enchantment) {
        int length = enchantment.length;
        
        int out = 0;
        for(int c = 0;c < length;c++){
            //Add weight of enchantment to out
            out = out + enchantment[c].getWeight();
        }
        return out;
    }
    public static int getWeightSum(EnchantmentSet set) {
        int out = getWeightSum(set.enchantments);
        return out;
    }
    /**
     * Removes a enchantment from a array
     * @param enchantments the array
     * @param element the enchantment to remove
     * @return the array without the enchantment
     */
    public static Enchantment[] removeEnchantment(Enchantment[] enchantments,Enchantment element) {
        int size = enchantments.length;
        Enchantment[] out = new Enchantment[(enchantments.length - 1)];
        int outh = 0;
        for(int c = 0;c < size;c++) {
            if(enchantments[c] != element) {
                out[outh] = enchantments[c];
                outh++;
            }
        }
        return out;
    }
    /**
     * Checks if enchantment is present in a array
     * @param enchantments the array
     * @param element the enchantment
     * @return TRUE if the enchantment is present in the array
     */
    public static boolean contains(Enchantment[] enchantments,Enchantment element) {
        int length = enchantments.length;
        
        for(int c = 0;c < length;c++) {
            if(enchantments[c] == element) {
                return true;
            }
        }
        
        return false;
    }
    /**
     * Gets the total weight of all Enchantments of a given type
     * @param type the type to get the weight of
     * @return the weight of all enchantments of that type
     */
    public int getTypeWeight(EnchantmentType type) {
        Enchantment[] enc = Enchantment.values();
        int length = enc.length;
        
        int out = 0;
        for(int c = 0;c < length;c++) {
            if(enc[c].getType() == type) {
                out = out + enc[c].getWeight();
            }
        }
        return out;
    }
    /**
     * XORs the two arrays of Enchantments.
     * @param enca the first array.
     * @param encb the second array;
     * @return The XORed array.
     */
    public Enchantment[] compareExclusive(Enchantment[] enca,Enchantment[] encb) {
        int lengtha = enca.length;
        int lengthb = encb.length;
        
        //Create include arrays
        boolean[] inca = new boolean[lengtha];
        boolean[] incb = new boolean[lengthb];
        
        //Include all
        // for enca
        for(int c = 0;c < lengtha;c++){
            inca[c] = true;
        }
        // for encb
        for(int c = 0;c < lengthb;c++){
            incb[c] = true;
        }
        
        //Do search
        //Search enca
        for(int a = 0;a < lengtha;a++) {
            //Cache Current Status
            boolean cinca = inca[a];
            //Check if excluded
            if(cinca == true) {
                //Cache Current Enchantment
                Enchantment cenc = enca[a];
                //Search encb
                for(int b = 0;b < lengthb;b++) {
                    //Check if excluded
                    if(incb[b] == true) {
                        // If no check if present
                        if(encb[b] == cenc) {
                        //Exclude both
                        incb[b] = false;
                        cinca = false;
                        }
                    }
                    
                }
                inca[a] = cinca;
            }
        }
        
        // Count TRUEs in include arrays
        int lengthout = 0;
        //  For inca
        for(int c = 0;c < lengtha;c++){
            if(inca[c] == true) {
                lengthout++;
            }
        }
        //  For incb
        for(int c = 0;c < lengtha;c++){
            if(incb[c] == true) {
                lengthout++;
            }
        }
        
        // Create output array
        Enchantment[] output = new Enchantment[lengthout];
        int outh = 0;
        
        // Load output array
        // With enca
        for(int a = 0;a < lengtha;a++) {
            if(inca[a] == true) {
                output[outh] = enca[a];
            }
        }
        // With encb
        for(int b = 0;b < lengtha;b++) {
            if(incb[b] == true) {
                output[outh] = encb[b];
            }
        }
        
        return output;
    }
}
