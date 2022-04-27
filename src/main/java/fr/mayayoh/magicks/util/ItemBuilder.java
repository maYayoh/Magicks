package fr.mayayoh.magicks.util;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
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
public class ItemBuilder {

    /**
     * Get a custom head.
     *
     * @param texture The texture to apply to the custom head.
     * {@code amount} defaults to 1.
     * {@code displayName} defaults to a blank name.
     * @see ItemBuilder#getCustomSkull(String, int, String, String...)
     * @return An ItemStack of the wanted head.
     */
    static public ItemStack getCustomSkull(final String texture) { return getCustomSkull(texture, 1, " "); }

    /**
     * Get a custom head.
     *
     * @param texture The texture to apply to the custom head.
     * @param amount The amount of items in the ItemStack.
     * {@code displayName} defaults to a blank name.
     * @see ItemBuilder#getCustomSkull(String, int, String, String...)
     * @return An ItemStack of the wanted head.
     */
    static public ItemStack getCustomSkull(final String texture, final int amount) { return getCustomSkull(texture, amount, " "); }

    /**
     * Get a custom head.
     *
     * @param texture The texture to apply to the custom head.
     * @param displayName The custom display name of the ItemStack.
     * {@code amount} defaults to 1.
     * @see ItemBuilder#getCustomSkull(String, int, String, String...)
     * @return An ItemStack of the wanted head.
     */
    static public ItemStack getCustomSkull(final String texture, final String displayName) { return getCustomSkull(texture, 1, displayName); }

    /**
     * Get a custom head.
     *
     * @param texture The texture to apply to the custom head.
     * @param amount The amount of items in the ItemStack.
     * @param displayName The custom display name of the ItemStack.
     * @see GameProfile
     * @see Method#invoke(Object, Object...)
     * @return An ItemStack of the wanted head.
     */
    static public ItemStack getCustomSkull(final String texture, final int amount, @NotNull final String displayName, final String... displayLore) {

        ItemStack finalSkull = new ItemStack(Material.PLAYER_HEAD, amount);
        if (texture.isEmpty()) return finalSkull;

        SkullMeta skullMeta = (SkullMeta) finalSkull.getItemMeta();
        final GameProfile profile = new GameProfile(new UUID(texture.hashCode(), texture.hashCode()), null);

        final String encodedData = Base64.getEncoder().encodeToString(String.format("{textures:{SKIN:{url:\"https://textures.minecraft.net/texture/%s\"}}}", texture).getBytes());
        profile.getProperties().put("textures", new Property("textures", encodedData));

        try {
            final Method mtd = skullMeta.getClass().getDeclaredMethod("setProfile", GameProfile.class);
            mtd.setAccessible(true);
            mtd.invoke(skullMeta, profile);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        skullMeta.setDisplayName(displayName);
        try { skullMeta.setLore(Arrays.asList(displayLore)); } catch (NullPointerException ignored) {}
        finalSkull.setItemMeta(skullMeta);

        return finalSkull;

    }
}
