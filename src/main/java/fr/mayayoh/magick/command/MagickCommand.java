package fr.mayayoh.magick.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class MagickCommand implements CommandExecutor {

    public boolean onCommand(@NotNull final CommandSender sender, @NotNull final Command cmd, @NotNull final String label, final String[] args) {
        if (args.length == 0) {
            this.showHelp(sender);
        } else {
            switch (args[0].toLowerCase(Locale.ROOT)) {
                case "playerinfo" -> {
                    final String[] pInfoArgs = new String[args.length - 2];
                    System.arraycopy(args, 1, pInfoArgs, 0, pInfoArgs.length);
                    PlayerInfoCommand.playerInfo((Player) sender, pInfoArgs);
                }
                case "editspells" -> EditSpellCommand.editSpells((Player) sender);
                case "?", "help" -> this.showHelp(sender);
                default -> this.showHelp(sender, args[0]);
            }
        }
        return true;
    }

    private void showHelp(final CommandSender sender) {
        this.showHelp(sender, "dontSendInvalidArg");
    }

    private void showHelp(final CommandSender sender, final String invalidArg) {
        String message = "";
        if (!invalidArg.equals("dontSendInvalidArg"))
            message += "The argument \"" + ChatColor.RED + invalidArg + ChatColor.RESET + "\" is not a valid one.\n" + ChatColor.ITALIC + "Check below for the syntax.\n";

        message += ChatColor.BOLD + "Help Page for " + ChatColor.RESET + "/" + ChatColor.LIGHT_PURPLE + "magicks" + ChatColor.RESET + ChatColor.BOLD + " :\n" + ChatColor.RESET + ChatColor.ITALIC + "Use \"/magicks <function> help\" to check the help for that function.\n\n" + ChatColor.RESET +
                "Usage: /magicks <function> [parameter1] [parameter2] ...\n";

        if (sender instanceof Player)
            message += """
                    |- playerinfo [player] : Show player's Magick Info.
                    |- editspells : Edit your spell configuration.
                    """;

        sender.sendMessage(message);
    }
}

