/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ryancwilliams.minecraftenchantmentcalculator;

/**
 *
 * @author ryanwilliams
 */
public class EnchantmentProbability {
    
    private final int mel;
    private final int depth;
    private final double subp;
    
    private final AppliedEnchantment[] enc;
    private final double[] probability;
    private final Enchantment[] enchantment;
    private final EnchantmentPower[] power;
    private final int length;
    
    private EnchantmentProbability[] subprobs;
    private boolean subscal = false;
    
    private boolean subHasSubs = false;
    
    /**
     * Creates a EnchantmentProbability object
     * @param enc the Enchantments to calculate
     * @param mel the modified enchantment level for this level
     * @param depth the depth of this level
     */
    public EnchantmentProbability(AppliedEnchantment[] enc,int mel,int depth) {
        this.mel = mel;
        this.depth = depth;
        this.subp = this.caculateSubP();
        
        this.subHasSubs = enc[0].hasSubs();
        
        this.enc = enc;
        this.length = enc.length;
        
        //Create Arrays
        this.enchantment = new Enchantment[this.length];
        this.power = new EnchantmentPower[this.length];
        //Load Arrays
        for(int c = 0;c < this.length;c++) {
            this.enchantment[c] = this.enc[c].enchantment;
            this.power[c] = this.enc[c].power;
        }
        
        this.probability = this.calculateProbability();
    }
    private double[] calculateProbability() {
        double[] out = new double[this.length];
        
        double tweight = this.calculateTWeight();
        for(int c = 0;c < this.length;c++) {
            out[c] = ((this.enchantment[c].getWeight())/tweight);
        }
        return out;
    }
    private int calculateTWeight() {
        int weight = 0;
        for(int c = 0;c < this.length;c++) {
            weight = weight + this.enchantment[c].getWeight();
        }
        return weight;
    }
    private double caculateSubP() {
        double out;
        out = ((this.mel/2)+1)/50;
        return out;
    }
    private int findEnchantment(Enchantment enc) {
        for(int c = 0;c < this.length;c++) {
            if(this.enchantment[c] == enc) {
                return c;
            }
        }
        return -1;
    }
    /**
     * Gets the probability that a enchantment will be selected at this depth
     * @param enc the enchantment to check
     * @return the probability of that enchantment
     */
    public double getProbability(Enchantment enc) {
        int i = this.findEnchantment(enc);
        if (i == -1) {
            return 0; // return 0 if bad entry because the probability of nonlisted entried is 0
        }
        return this.probability[i];
    }
    /**
     * Gets the probability that a enchantment will be selected at all depths deeper than this depth
     * @param enc the enchantment to check
     * @return the probability of that enchantment
     */
    public double getProbabilityD(Enchantment enc) {
        // Get prob for this level
        double prob = this.getProbability(enc);
        // Get prob for sublevels
        for(int c = 0;c < this.length;c++) {
            //Caculate sub prob (using * because these valves are ANDed)
            double probe = this.probability[c] * this.subp * this.subprobs[c].getProbabilityD(enc);
            //Caculate total prob sofar (using + because these vales are ORed)
            prob = prob + probe;
        }
        return prob;
    }
    /**
     * Gets the probability that a enchantment set will be selected at all depths deeper than this depth
     * @param enc the enchantments in the set to check
     * @return the probability of that enchantment set
     */
    public double getProbabilityD(Enchantment... enc) {
        int prams = enc.length;
        // Create output varable
        double prob = 0;
        // Create done and end flag
        boolean done;
        boolean end;
        // Set done flag
        if(prams == 1) {
            done = true;
        } else {
            done = false;
        }    
        // Set end flag
        if(this.subscal) {
            end = false;
        } else {
            end = true;
        }
        // Check if this branch is dead
        boolean dead = true;
        if(prams <= (this.depth+1)) {
            dead = false;
        } else if(done) {
            dead = false;
        }
        // Check if this should run
        if(!dead) {
            // Get prob for this level and its subs
            // Run once for each index
            for(int i = 0;i < this.length;i++) {
                // Get probability for this level
                double probp = this.probability[i];
                // Get enchantment in this index
                Enchantment enci = this.enchantment[i];
                // Create output varable for subs
                double probll = 0;
                // Create a array of enchantments for subs to check
                Enchantment[] subenc;
                // Check if this index has one of the enchantments
                if(EnchantmentTools.contains(enc, enci)){
                    // Check if this is last enchantment
                    if(done) {
                        probll = 1;// Set to 1 because next level does not mater
                        subenc = null;
                    } else {
                        // Remove this enchantment from subs checklist
                        subenc = EnchantmentTools.removeEnchantment(enc,enci);
                    }
                } else {
                    // Copy input list to subs checklist
                    subenc = enc;
                }
                // Check subs
                if(!end && (probll == 0)){
                    //Set to prob of next level
                    probll = this.subp * this.subprobs[i].getProbabilityD(subenc);
                } else if(end && (probll == 0)){
                    probll = 0; // Set to 0 because this branch is null
                }
                // Caculate total prob for this enchantment combo (using * because these valves are ANDed)
                double probe = probp * probll;
                //Caculate total prob sofar (using + because these vales are ORed)
                prob = prob + probe;
            }
        }    
        return prob;
    }
    /**
     * Gets the probability that a enchantment will be selected at this depth. 
     * Also checks to see that the power is valid.
     * @param enc the enchantment to check
     * @param power the power of that enchantment
     * @return the probability of that enchantment
     */
    public double getProbability(Enchantment enc,EnchantmentPower power) {
        if(this.getPower(enc) == power) {
            return this.getProbability(enc);
        }
        return 0; // return 0 if bad entry because the probability of nonlisted entried is 0
    }
    /**
     * Gets the power of a enchantment
     * @param enc the enchantment to check
     * @return The power of the enchantment
     */
    public EnchantmentPower getPower(Enchantment enc) {
        int i = this.findEnchantment(enc);
        return this.power[i];
    }
    /**
     * Calculate Subs
     */
    public void calculateSubs() {
        int d = this.depth - 1;
        int submel = this.mel/2;
        
        this.subprobs = new EnchantmentProbability[this.length];
        if(this.subHasSubs) {
            for(int c = 0;c < this.length;c++) {
                this.subprobs[c] = new EnchantmentProbability(this.enc[c].getSubs(),submel,d);
            }
        }
    }
    /**
     * Calculate Subs until depth is 0;
     */
    public void calculateSubsD() {
        if(this.depth > 0) {
            this.calculateSubs();
            for(int c = 0;c < this.length;c++) {
                this.subprobs[c].calculateSubsD();
            }
        }
    }
}
