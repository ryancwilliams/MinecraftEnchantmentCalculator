
import com.github.ryancwilliams.minecraftenchantmentcalculator.Enchantment;
import com.github.ryancwilliams.minecraftenchantmentcalculator.EnchantmentTools;
import com.github.ryancwilliams.minecraftenchantmentcalculator.Item;

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
        
        Enchantment[] enchantments = EnchantmentTools.getPossible(1, Item.CHESTPLATE);
        int o = enchantments.length;
        
        
        System.out.println(output);
        System.out.println("Done");
    }
}
