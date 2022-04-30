package fr.mayayoh.magick.util;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;

/**
 * ItemBuilder class used to create specific ItemStack more easily.
 *
 * @author maYayoh
 * @version 1.0
 */
public final class ItemBuilder {

    /**
     * Add an enchanted glint to an ItemStack
     *
     * @param itemStack The ItemStack that will get glint.
     */
    public static void addGlint(final ItemStack itemStack) {
        final ItemMeta meta = itemStack.getItemMeta();
        Validate.notNull(meta, "The ItemStack doesn't have any ItemMeta.");
        meta.addEnchant(Enchantment.LURE, 0, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemStack.setItemMeta(meta);
    }

    /**
     * Create an ItemStack.
     *
     * @param material The material of the ItemStack.
     * {@code amount} defaults to 1.
     * {@code isGlowing} defaults to false.
     * {@code displayName} defaults to a blank name.
     * {@code displayLore} defaults to an empty Array.
     * @see ItemBuilder#createItem(Material, int, boolean, String, String...)
     * @return An ItemStack.
     */
    public static ItemStack createItem(final Material material) {
        return createItem(material, 1, false, " ");
    }

    /**
     * Create an ItemStack.
     *
     * @param material The material of the ItemStack.
     * @param amount The amount of items in the ItemStack.
     * {@code isGlowing} defaults to false.
     * {@code displayName} defaults to a blank name.
     * {@code displayLore} defaults to an empty Array.
     * @see ItemBuilder#createItem(Material, int, boolean, String, String...)
     * @return An ItemStack.
     */
    public static ItemStack createItem(final Material material, final int amount) { return createItem(material, amount, false, " "); }

    /**
     * Create an ItemStack.
     *
     * @param material The material of the ItemStack.
     * @param isGlowing If the ItemStack have an enchanted glint.
     * {@code amount} defaults to 1.
     * {@code displayName} defaults to a blank name.
     * {@code displayLore} defaults to an empty Array.
     * @see ItemBuilder#createItem(Material, int, boolean, String, String...)
     * @return An ItemStack.
     */
    public static ItemStack createItem(final Material material, final boolean isGlowing) { return createItem(material, 1, isGlowing, " "); }

    /**
     * Create an ItemStack.
     *
     * @param material The material of the ItemStack.
     * @param amount The amount of items in the ItemStack.
     * @param isGlowing If the ItemStack have an enchanted glint.
     * {@code displayName} defaults to a blank name.
     * {@code displayLore} defaults to an empty Array.
     * @see ItemBuilder#createItem(Material, int, boolean, String, String...)
     * @return An ItemStack.
     */
    public static ItemStack createItem(final Material material, final int amount, final boolean isGlowing) { return createItem(material, amount, isGlowing, " "); }

    /**
     * Create an ItemStack.
     *
     * @param material The material of the ItemStack.
     * @param amount The amount of items in the ItemStack.
     * @param displayName The custom display name of the ItemStack.
     * {@code isGlowing} defaults to false.
     * {@code displayLore} defaults to an empty Array.
     * @see ItemBuilder#createItem(Material, int, boolean, String, String...)
     * @return An ItemStack.
     */
    public static ItemStack createItem(final Material material, final int amount, @NotNull final String displayName) { return createItem(material, amount, false, displayName); }

    /**
     * Create an ItemStack.
     *
     * @param material The material of the ItemStack.
     * @param isGlowing If the ItemStack have an enchanted glint.
     * @param displayName The custom display name of the ItemStack.
     * {@code amount} defaults to 1.
     * {@code displayLore} defaults to an empty Array.
     * @see ItemBuilder#createItem(Material, int, boolean, String, String...)
     * @return An ItemStack.
     */
    public static ItemStack createItem(final Material material, final boolean isGlowing, @NotNull final String displayName) { return createItem(material, 1, isGlowing, displayName); }

    /**
     * Create an ItemStack.
     *
     * @param material The material of the ItemStack.
     * @param amount The amount of items in the ItemStack.
     * @param displayName The custom display name of the ItemStack.
     * @param displayLore The custom lore of the ItemStack.
     *                    Entering multiple String will create multiple lines in the lore.
     *                    Can be empty.
     * @return An ItemStack.
     */
    public static ItemStack createItem(final Material material, final int amount, final boolean isGlowing, @NotNull final String displayName, final String... displayLore) {
        final ItemStack item = new ItemStack(material, amount);

        final ItemMeta meta = item.getItemMeta();
        Validate.notNull(meta, "The ItemStack doesn't have any ItemMeta.");

        meta.setDisplayName(displayName);
        meta.setLore(Arrays.asList(displayLore));
        item.setItemMeta(meta);

        if (isGlowing)
            addGlint(item);

        return item;
    }


    /**
     * Get a custom head.
     *
     * @param texture The texture to apply to the custom head.
     * {@code amount} defaults to 1.
     * {@code displayName} defaults to a blank name.
     * {@code displayLore} defaults to an empty Array.
     * @see ItemBuilder#getCustomHead(String, int, String, String...)
     * @return An ItemStack of the wanted head.
     */
    static public ItemStack getCustomHead(final String texture) { return getCustomHead(texture, 1, " "); }

    /**
     * Get a custom head.
     *
     * @param texture The texture to apply to the custom head.
     * @param amount The amount of items in the ItemStack.
     * {@code displayName} defaults to a blank name.
     * {@code displayLore} defaults to an empty Array.
     * @see ItemBuilder#getCustomHead(String, int, String, String...)
     * @return An ItemStack of the wanted head.
     */
    static public ItemStack getCustomHead(final String texture, final int amount) { return getCustomHead(texture, amount, " "); }

    /**
     * Get a custom head.
     *
     * @param texture The texture to apply to the custom head.
     * @param displayName The custom display name of the ItemStack.
     * {@code amount} defaults to 1.
     * {@code displayLore} defaults to an empty Array.
     * @see ItemBuilder#getCustomHead(String, int, String, String...)
     * @return An ItemStack of the wanted head.
     */
    static public ItemStack getCustomHead(final String texture, final String displayName) { return getCustomHead(texture, 1, displayName); }

    /**
     * Get a custom head.
     *
     * @param texture The texture to apply to the custom head.
     * @param amount The amount of items in the ItemStack.
     * @param displayName The custom display name of the ItemStack.
     * @param displayLore The custom lore of the ItemStack.
     *                    Entering multiple String will create multiple lines in the lore.
     *                    Can be empty.
     * @return An ItemStack of the wanted head.
     */
    static public ItemStack getCustomHead(final String texture, final int amount, @NotNull final String displayName, final String... displayLore) {

        final ItemStack finalSkull = new ItemStack(Material.PLAYER_HEAD, amount);
        if (texture.isEmpty()) return finalSkull;

        final SkullMeta skullMeta = (SkullMeta) finalSkull.getItemMeta();
        Validate.notNull(skullMeta, "The ItemStack doesn't have any ItemMeta.");
        final GameProfile profile = new GameProfile(new UUID(texture.hashCode(), texture.hashCode()), null);

        final String encodedData = Base64.getEncoder().encodeToString(String.format("{textures:{SKIN:{url:\"https://textures.minecraft.net/texture/%s\"}}}", texture).getBytes());
        profile.getProperties().put("textures", new Property("textures", encodedData));

        try {
            final Method mtd = skullMeta.getClass().getDeclaredMethod("setProfile", GameProfile.class);
            mtd.setAccessible(true);
            mtd.invoke(skullMeta, profile);
        } catch (final IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        skullMeta.setDisplayName(displayName);
        try { skullMeta.setLore(Arrays.asList(displayLore)); } catch (NullPointerException ignored) {}
        finalSkull.setItemMeta(skullMeta);

        return finalSkull;

    }
}
