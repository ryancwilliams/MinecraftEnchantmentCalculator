
import com.github.ryancwilliams.minecraftenchantmentcalculator.*;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ryanwilliams
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String output = null;
        
        EnchantmentSet enchantments = EnchantmentTools.getPossibleSet(20, Item.BOW);
        int o = 0;
        
        boolean flag = EnchantmentTools.isConflicting(Enchantment.AQUAAFFINITY, Enchantment.EFFICIENCY);
        
        System.out.println(output);
        System.out.println("Done");
    }
}
