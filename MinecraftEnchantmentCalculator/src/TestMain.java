
import com.github.ryancwilliams.minecraftenchantmentcalculator.Enchantment;
import com.github.ryancwilliams.minecraftenchantmentcalculator.EnchantmentSet;
import com.github.ryancwilliams.minecraftenchantmentcalculator.EnchantmentTools;
import com.github.ryancwilliams.minecraftenchantmentcalculator.Item;
import com.github.ryancwilliams.minecraftenchantmentcalculator.math.Factorial;


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
        int o = (int) Factorial.Factorial((byte) 30);
        
        boolean flag = EnchantmentTools.isConflicting(Enchantment.AQUAAFFINITY, Enchantment.EFFICIENCY);
        
        System.out.println(output);
        System.out.println("Done");
    }
}
