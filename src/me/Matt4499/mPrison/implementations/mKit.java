package me.Matt4499.mPrison.implementations;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Matt4499.mPrison.Main;

public class mKit {

    static ItemStack basicguardsword = new ItemStack(Material.DIAMOND_SWORD);
    static ItemStack wardensword = new ItemStack(Material.NETHERITE_SWORD); // might change these around soon but basic starting point
    static ItemStack arreststick = new ItemStack(Material.STICK);
    
    public static void init() {

        // Basic Guard Sword
        ItemMeta bgsMeta = basicguardsword.getItemMeta();
        bgsMeta.setDisplayName(Main.color("&bGuard Sword"));
        List<String> bgsMetaLines = new ArrayList<String>();
        bgsMetaLines.add(Main.color("&4Contraband"));
        bgsMetaLines.add(Main.color("&cSword for emergency use only!"));
        bgsMeta.setLore(bgsMetaLines);
        basicguardsword.setItemMeta(bgsMeta);


        // Warden Sword
        ItemMeta wardenMeta = wardensword.getItemMeta();
        wardenMeta.setDisplayName(Main.color("&cWarden Sword"));
        List<String> wardenMetaLines = new ArrayList<String>();
        wardenMetaLines.add(Main.color("&4Contraband"));
        wardenMetaLines.add(Main.color("&cSword for emergency use only!"));
        wardenMeta.setLore(wardenMetaLines);
        wardensword.setItemMeta(wardenMeta);

        // Arrest Stick
        ItemMeta arrestMeta = arreststick.getItemMeta();
        arrestMeta.setDisplayName(Main.color("&6Arrest Prisoner"));
        List<String> arrestMetaLines = new ArrayList<String>();
        arrestMetaLines.add(Main.color("&4Contraband"));
        arrestMetaLines.add(Main.color("&cSend prisoners back to their cell."));
        arrestMetaLines.add(Main.color("&cRemoves contrabrand upon arrest"));
        arrestMeta.setLore(arrestMetaLines);
        arreststick.setItemMeta(arrestMeta);





    }
    

    public static void giveBasicGuardKit(Player player) {

    }

    public static void giveArrestStick(Player player) {
        player.getInventory().addItem(arreststick);
    }

    public static void giveBasicGuardSword(Player player) {
        player.getInventory().addItem(basicguardsword);
    }
    
}
