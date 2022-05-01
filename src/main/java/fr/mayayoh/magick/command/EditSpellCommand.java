package fr.mayayoh.magick.command;

import fr.mayayoh.magick.gui.spelleditor.SpellEditorMenu;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class EditSpellCommand implements CommandExecutor {

    public boolean onCommand(@NotNull final CommandSender sender, @NotNull final Command cmd, @NotNull final String label, final String[] args) {
        if (sender instanceof Player player) {
            editSpells(player);
        } else {
            showConsoleError(sender);
        }
        return true;
    }

    public static void editSpells(final Player sender) {
        new SpellEditorMenu(sender).openInventory();
    }

    private static void showConsoleError(final CommandSender sender) {
        sender.sendMessage(ChatColor.GOLD + "/!\\ " + ChatColor.RED + "You can't use this command from where you are!" + ChatColor.RESET);
    }
}
