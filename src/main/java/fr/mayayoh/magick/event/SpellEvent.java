package fr.mayayoh.magick.event;

import fr.mayayoh.magick.MagickPlugin;
import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickRegistry;
import fr.mayayoh.magick.util.MagickTypeEnum;
import fr.mayayoh.magick.util.lib.MagickLib;
import fr.mayayoh.magick.util.lib.RandomLib;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.FluidCollisionMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Pose;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

import static fr.mayayoh.magick.event.GatherEvent.startGathering;

public class SpellEvent implements Listener {
    @EventHandler
    public void onPlayerClick(final PlayerInteractEvent e) {
        final Player player = e.getPlayer();
        final MagickRegistry registry = MagickRegistry.getInstance();

        if (registry.isPlayerInMagick(player)) {
            e.setCancelled(true);

            final ItemStack itemHeld = e.getPlayer().getInventory().getItemInMainHand();
            if (itemHeld.getType().equals(Material.PLAYER_HEAD)) {
                final ItemMeta itemMeta = itemHeld.getItemMeta();
                Validate.notNull(itemMeta, "The ItemStack doesn't have any ItemMeta.");
                MagickTypeEnum magickType = null;
                for (MagickTypeEnum type : MagickTypeEnum.values()) {
                    if (ChatColor.stripColor(type.toString()+" Spell").equals(
                            ChatColor.stripColor(Objects.requireNonNull(itemMeta.getLore()).get(0)))) {
                        magickType = type;
                        break;
                    }
                } if (magickType != null) {
                    for (SpellClass spell : magickType.getSpellList()) {
                        if(spell.getSpellIcon().equals(itemHeld)) {
                            spell.castSpell(player, magickType);
                            break;
                        }
                    }
                }
            }
        } else if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)
                && player.isSneaking()
                && player.getInventory().getItemInMainHand().getType().equals(Material.AIR)
        ) {
            if (registry.getGatherInfo(player) != null) {
                if (Objects.requireNonNull(registry.getGatherInfo(player)).get("block").equals(e.getClickedBlock())) {
                    return;
                }
            }
            startGathering(player);
        }
    }


    @EventHandler
    public void onPlayerSwapItem(final PlayerSwapHandItemsEvent e) {
        final Player player = e.getPlayer();
        final MagickRegistry registry = MagickRegistry.getInstance();
        if (player.isSneaking()) {
            e.setCancelled(true);

            if (registry.isPlayerInMagick(player)) {
                registry.loadInventory(player);
                registry.setMode(player, false);
            } else {
                registry.saveInventory(player);
                registry.setMode(player, true);

                for (int i = 0; i < 9; i++) {
                    player.getInventory().setItem(i, MagickLib.getSpellConfig(player)[i]);
                }
                for (int i = 10; i < 36; i++) {
                    player.getInventory().setItem(i, null);
                }

                showEssenceCount(player);

                final Material[] sgp = new Material[]{Material.WHITE_STAINED_GLASS_PANE, Material.ORANGE_STAINED_GLASS_PANE, Material.MAGENTA_STAINED_GLASS_PANE, Material.LIGHT_BLUE_STAINED_GLASS_PANE, Material.YELLOW_STAINED_GLASS_PANE, Material.LIME_STAINED_GLASS_PANE, Material.PINK_STAINED_GLASS_PANE, Material.GRAY_STAINED_GLASS_PANE, Material.CYAN_STAINED_GLASS_PANE, Material.PURPLE_STAINED_GLASS_PANE, Material.BLUE_STAINED_GLASS_PANE, Material.BROWN_STAINED_GLASS_PANE, Material.GREEN_STAINED_GLASS_PANE, Material.RED_STAINED_GLASS_PANE};
                final ItemStack defaultSeparator = ItemBuilder.createItem(Material.BLACK_STAINED_GLASS_PANE);
                final ItemStack randomSeparator = ItemBuilder.createItem(sgp[RandomLib.randomInteger(sgp.length - 1)]);
                final int[] defaultSepPos = new int[]{9, 11, 13, 15, 17, 27, 29, 31, 33, 35};
                final int[] randomSepPos = new int[]{10, 12, 14, 16, 18, 26, 28, 30, 32, 34};

                for (int pos : defaultSepPos) player.getInventory().setItem(pos, defaultSeparator);
                for (int pos : randomSepPos) player.getInventory().setItem(pos, randomSeparator);

                player.getInventory().setItem(22, ItemBuilder.createItem(Material.PAPER, 1, true,
                        ChatColor.RESET + "Press Shift+F to quit Magick Mode",
                        ChatColor.RESET.toString() + ChatColor.DARK_GRAY + "Click outside your inventory",
                        ChatColor.RESET.toString() + ChatColor.DARK_GRAY + "window to preview your inventory."));
            }
        } else e.setCancelled(registry.isPlayerInMagick(player));
    }



    @EventHandler
    public void onPlayerChangeSlot(final PlayerItemHeldEvent e) {
        final Player player = e.getPlayer();
        if (MagickRegistry.getInstance().isPlayerInMagick(player))
            Bukkit.getScheduler().runTaskLater(MagickPlugin.getInstance(), () -> showEssenceCount(player), 1);
    }




    public static void showEssenceCount(final Player player) {
        final MagickRegistry registry = MagickRegistry.getInstance();

        final ItemStack itemHeld = player.getInventory().getItemInMainHand();
        if (itemHeld.getType().equals(Material.PLAYER_HEAD)) {
            final ItemMeta itemMeta = itemHeld.getItemMeta();
            Validate.notNull(itemMeta, "The ItemStack doesn't have any ItemMeta.");
            MagickTypeEnum magickType = MagickTypeEnum.NONE;
            for (MagickTypeEnum type : MagickTypeEnum.values()) {
                if (ChatColor.stripColor(type.toString() + " Spell").equals(ChatColor.stripColor(Objects.requireNonNull(itemMeta.getLore()).get(0)))) {
                    magickType = type;
                    break;
                }
            }

            player.getInventory().setItemInOffHand(
                    magickType.getRelativeIcon(
                            Integer.parseInt(MagickLib.getMagickData((MagickLib.getMagickType(player, true) == magickType ? "first" : "second") + ".essences", player)),
                            ChatColor.RESET + "Number of " + magickType + ChatColor.RESET+ " essences")
            );
        } else player.getInventory().setItemInOffHand(new ItemStack(Material.AIR));
    }
}

