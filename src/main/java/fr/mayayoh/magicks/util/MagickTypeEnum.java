package fr.mayayoh.magicks.util;

import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * MagickTypeEnum enum used to get all information linked to a Magick type.
 *
 * @author maYayoh
 * @version 1.0
 */
public enum MagickTypeEnum {
    FIRE(
            ChatColor.RED + "Ⓕire", "", ""
    ),
    WATER(
            ChatColor.BLUE + "Ⓦater", "", ""
    ),
    PLANT(
            ChatColor.GREEN + "Ⓟlant", "", ""
    ),
    EARTH(
            ChatColor.GOLD + "Ⓔarth", "", ""
    ),
    LIGHT(
            ChatColor.YELLOW + "Ⓛight", "", ""
    ),
    DEATH(
            ChatColor.DARK_PURPLE + "Ⓓeath", "", ""
    );

    @Getter final private String display;
    final private String texture;
    final private String textureZero;

    /**
     * MagickTypeEnum constructor.
     *
     * @author maYayoh
     * @param display How the Type should be display.
     * @param texture The texture to apply on custom heads.
     * @param textureZero The texture to apply on custom heads if the essence's value equals zero.
     */
    MagickTypeEnum(final String display, final String texture, final String textureZero) {
        this.display = display;
        this.texture = texture;
        this.textureZero = textureZero;
    }

    /**
     * Get the ID associated with the Magick Type.
     *
     * @return The ID.
     */
    public int getId() { return this.ordinal()+1; }



    /**
     * Get the icon associated with the Magick Type.
     *
     * {@code displayName} defaults to a blank name.
     * {@code amount} defaults to 1.
     * @see MagickTypeEnum#getIcon(int, String, String...)
     * @return An ItemStack of the wanted icon.
     */
    public ItemStack getIcon() { return getIcon(1, " "); }

    /**
     * Get the icon associated with the Magick Type.
     *
     * @param displayName The custom display name of the ItemStack.
     * {@code amount} defaults to 1.
     * @see MagickTypeEnum#getIcon(int, String, String...)
     * @return An ItemStack of the wanted icon.
     */
    public ItemStack getIcon(@NotNull final String displayName) { return getIcon(1, displayName); }

    /**
     * Get the icon associated with the Magick Type.
     *
     * @param amount The amount of essence, which will correspond the amount of item in the ItemStack.
     * @param displayName The custom display name of the ItemStack.
     * @param displayLore The custom lore of the ItemStack.
     *                    Entering multiple String will create multiple lines in the lore.
     * @see ItemBuilder#getCustomSkull(String, int, String, String...) 
     * @return An ItemStack of the wanted icon.
     */
    public ItemStack getIcon(final int amount, @NotNull final String displayName, final String... displayLore) {
        return ItemBuilder.getCustomSkull(this.texture, amount, displayName, displayLore);
    }


    /**
     * Get the icon associated with the Magick Type with an essence's value of zero.
     *
     * @param displayName The custom display name of the ItemStack.
     * @param displayLore The custom lore of the ItemStack.
     *                    Entering multiple String will create multiple lines in the lore.
     *                    Can be empty.
     * @see ItemBuilder#getCustomSkull(String, int, String, String...)
     * @return An ItemStack of the wanted icon.
     */
    public ItemStack getZeroIcon(@NotNull final String displayName, final String... displayLore) {
        return ItemBuilder.getCustomSkull(this.textureZero, 1, displayName, displayLore);
    }

    /**
     * Get the icon associated with the Magick Type.
     *
     * @param amount The amount of essence, which will correspond the amount of item in the ItemStack.
     *                    Entering multiple String will create multiple lines in the lore.
     * @see ItemBuilder#getCustomSkull(String, int, String, String...)
     * @return An ItemStack of the wanted icon.
     */
    public ItemStack getRelativeIcon(final int amount) { return getRelativeIcon(amount, " "); }

    /**
     * Get the icon associated with the Magick Type and relative to the amount.
     *
     * @param amount The amount of essence, which will change the texture.
     * @param displayName The custom display name of the ItemStack.
     * @param displayLore The custom lore of the ItemStack.
     *                    Entering multiple String will create multiple lines in the lore.
     *                    Can be empty.
     * @see MagickTypeEnum#getIcon(int, String, String...)
     * @see MagickTypeEnum#getZeroIcon(String, String...)
     * @return An ItemStack of the wanted icon.
     */
    public ItemStack getRelativeIcon(final int amount, @NotNull final String displayName, final String... displayLore) {
        return amount <= 0 ? getZeroIcon(displayName, displayLore) : getIcon(amount, displayName, displayLore);
    }
}
