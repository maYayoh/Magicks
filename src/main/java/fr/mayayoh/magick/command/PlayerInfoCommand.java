package fr.mayayoh.magick.command;

import fr.mayayoh.magick.gui.playerinfo.PlayerInfoMenu;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.UUID;

public class PlayerInfoCommand implements CommandExecutor {

    public boolean onCommand(@NotNull final CommandSender sender, @NotNull final Command cmd, @NotNull final String label, final String[] args) {
        if (sender instanceof Player player)
            playerInfo(player, args);
        else
            showConsoleError(sender);
        return true;
    }

    public static void playerInfo(@NotNull final Player sender, final String[] args) {
        if (args.length == 0) {
            new PlayerInfoMenu(sender, sender).openInventory();
        } else {
            if (!args[0].equals("help") && !args[0].equals("?")) {
                if (Bukkit.getPlayer(args[0]) != null || Bukkit.getPlayer(UUID.fromString(args[0])) != null) {
                    new PlayerInfoMenu(sender, Bukkit.getPlayer(args[0])).openInventory();
                } else
                    showHelp(sender, args[0]);
            } else
                showHelp(sender);
        }
    }

    private static void showConsoleError(final CommandSender sender) {
        sender.sendMessage(ChatColor.GOLD + "/!\\ " + ChatColor.RED + "You can't use this command from where you are!" + ChatColor.RESET);
    }

    private static void showHelp(final CommandSender sender) {
        showHelp(sender, "dontSendInvalidArg");
    }

    private static void showHelp(final CommandSender sender, final String invalidArg) {
        String message = "";
        if (!invalidArg.equals("dontSendInvalidArg")) {
            message += ChatColor.GOLD + "/!\\ " + ChatColor.RESET + ChatColor.BOLD + invalidArg + ChatColor.RESET + ChatColor.RED + " isn't a valid player (offline or doesn't exist).";
        } else {
            message += ChatColor.BOLD + "Help Page for " + ChatColor.RESET + "/" + ChatColor.LIGHT_PURPLE + "magick " + ChatColor.GREEN + "playerinfo" + ChatColor.RESET + ChatColor.BOLD + " :\n" + ChatColor.RESET + ChatColor.ITALIC + "Show player's Magick Info, like their Magick type or their spell configurations.\n\n" + ChatColor.RESET +
                    "Usage: /magick playerinfo [player]\n" +
                    "|- [player] : If specified, show the Magick Info of the player (must be online). Else, show the Magick Info of the sender.";
        }

        sender.sendMessage(message);
    }

}

