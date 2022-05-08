package fr.mayayoh.magick.util;

import fr.mayayoh.magick.spell.DefaultSpell;
import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.spell.water.*;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MagickTypeEnum enum used to get all information linked to a Magick type.
 *
 * @author maYayoh
 * @version 1.0
 */
public enum MagickTypeEnum {
    NONE(),

    /**
     * Fire Magick Type.
     */
    FIRE(
            ChatColor.RED + "\u24BBire",
            "dec65fc87c504415eff730a2f4fe7d06d2f116ea2a313481f362d0a25d65e500",
            "7619bf62863ec11577d6ef65efdc3f9de4df414202ed1ff1de9ec76b61a3f667",
            new SpellClass[]{
                    new fr.mayayoh.magick.spell.fire.Placeholder1(),
                    new fr.mayayoh.magick.spell.fire.Placeholder2(),
                    new fr.mayayoh.magick.spell.fire.Placeholder3(),
                    new fr.mayayoh.magick.spell.fire.Placeholder4(),
                    new fr.mayayoh.magick.spell.fire.Placeholder5(),
                    new fr.mayayoh.magick.spell.fire.Placeholder6(),
                    new fr.mayayoh.magick.spell.fire.Placeholder7(),
                    new fr.mayayoh.magick.spell.fire.Placeholder8(),
                    new fr.mayayoh.magick.spell.fire.Placeholder9(),
            },
            Particle.FLAME,
            new HashMap<>(){{
                put(Material.CAMPFIRE, null); put(Material.ANCIENT_DEBRIS, null);
                put(Material.FIRE, null); put(Material.MAGMA_BLOCK, null);
                put(Material.LAVA, "minecraft:lava[level=0]");
            }}
    ),

    /**
     * Water Magick Type.
     */
    WATER(
            ChatColor.BLUE + "\u24CCater",
            "9e52f7960ff3cec2f519a6353648c6e33bc51e131cc80917cf13081decbff24d",
            "c487ffab15d628cb0ed493919e154da0b97b0613bb40f8b38757de507bbd6094",
            new SpellClass[]{
                    new Placeholder1(),
                    new Placeholder2(),
                    new Placeholder3(),
                    new Placeholder4(),
                    new IllusionSpell(),
                    new Placeholder6(),
                    new Placeholder7(),
                    new Placeholder8(),
                    new Placeholder9(),
            },
            Particle.SOUL_FIRE_FLAME,
            new HashMap<>(){{
                put(Material.BLUE_ICE, null); put(Material.FROSTED_ICE, null);
                put(Material.ICE, null); put(Material.PACKED_ICE, null);
                put(Material.WATER, "minecraft:water[level=0]");
                put(Material.SNOW, "minecraft:snow[layers=8]");
            }}
    ),

    /**
     * Plant Magick Type.
     */
    PLANT(
            ChatColor.GREEN + "\u24C5lant",
            "684380ad4dc388f561254c8409fa704d44747eb6e5feacba343e7c243cfac6a1",
            "964ad8da319e6eb37721e02c78864990b45fc0fea06ee52ed4c24ac197278cb7",
            new SpellClass[]{
                    new fr.mayayoh.magick.spell.plant.Placeholder1(),
                    new fr.mayayoh.magick.spell.plant.Placeholder2(),
                    new fr.mayayoh.magick.spell.plant.Placeholder3(),
                    new fr.mayayoh.magick.spell.plant.Placeholder4(),
                    new fr.mayayoh.magick.spell.plant.Placeholder5(),
                    new fr.mayayoh.magick.spell.plant.Placeholder6(),
                    new fr.mayayoh.magick.spell.plant.Placeholder7(),
                    new fr.mayayoh.magick.spell.plant.Placeholder8(),
                    new fr.mayayoh.magick.spell.plant.Placeholder9(),
            },
            Particle.COMPOSTER,
            new HashMap<>(){{
                put(Material.OAK_LEAVES, null); put(Material.SPRUCE_LEAVES, null);
                put(Material.BIRCH_LEAVES, null); put(Material.JUNGLE_LEAVES, null);
                put(Material.ACACIA_LEAVES, null); put(Material.DARK_OAK_LEAVES, null);
                put(Material.GRASS, null); put(Material.MYCELIUM, null);
                put(Material.GRASS_BLOCK, "minecraft:grass_block[snowy=false]");
                put(Material.TALL_GRASS, null); put(Material.FERN, null);
                put(Material.DANDELION, null); put(Material.POPPY, null);
                put(Material.BLUE_ORCHID, null); put(Material.ALLIUM, null);
                put(Material.AZURE_BLUET, null); put(Material.RED_TULIP, null);
                put(Material.ORANGE_TULIP, null); put(Material.WHITE_TULIP, null);
                put(Material.PINK_TULIP, null); put(Material.OXEYE_DAISY, null);
                put(Material.CORNFLOWER, null); put(Material.LILY_OF_THE_VALLEY, null);
            }}
    ),

    /**
     * Earth Magick Type.
     */
    EARTH(
            ChatColor.GOLD + "\u24BAarth",
            "d774e5ef3d8bcde9ea21c34b84827d34531e68f111510f3383055ecaa74bebcc",
            "16a18f9d1ae5ab04461127e31c5190c76b442da502877aa647fd0340507b33a5",
            new SpellClass[]{
                    new fr.mayayoh.magick.spell.earth.Placeholder1(),
                    new fr.mayayoh.magick.spell.earth.Placeholder2(),
                    new fr.mayayoh.magick.spell.earth.Placeholder3(),
                    new fr.mayayoh.magick.spell.earth.Placeholder4(),
                    new fr.mayayoh.magick.spell.earth.Placeholder5(),
                    new fr.mayayoh.magick.spell.earth.Placeholder6(),
                    new fr.mayayoh.magick.spell.earth.Placeholder7(),
                    new fr.mayayoh.magick.spell.earth.Placeholder8(),
                    new fr.mayayoh.magick.spell.earth.Placeholder9(),
            },
            Particle.CRIT,
            new HashMap<>(){{
                put(Material.COARSE_DIRT, null); put(Material.COBBLESTONE, null);
                put(Material.DIRT, null); put(Material.OBSIDIAN, null);
            }}
    ),

    /**
     * Light Magick Type.
     */
    LIGHT(
            ChatColor.YELLOW + "\u24c1ight",
            "21469ce67dfc28433aea8a45ab816e51bd39ba9eb815d22579e77698da0bf295",
            "dc6999c1f59646fe0121a99d9b0fef3996ed78c6dc55531dabcca708c1dcf916",
            new SpellClass[]{
                    new fr.mayayoh.magick.spell.light.Placeholder1(),
                    new fr.mayayoh.magick.spell.light.Placeholder2(),
                    new fr.mayayoh.magick.spell.light.Placeholder3(),
                    new fr.mayayoh.magick.spell.light.Placeholder4(),
                    new fr.mayayoh.magick.spell.light.Placeholder5(),
                    new fr.mayayoh.magick.spell.light.Placeholder6(),
                    new fr.mayayoh.magick.spell.light.Placeholder7(),
                    new fr.mayayoh.magick.spell.light.Placeholder8(),
                    new fr.mayayoh.magick.spell.light.Placeholder9(),
            },
            Particle.END_ROD,
            new HashMap<>(){{
                put(Material.BEACON, null); put(Material.CRYING_OBSIDIAN, null);
                put(Material.GLOWSTONE, null); put(Material.RESPAWN_ANCHOR, null);
            }}
    ),

    /**
     * Death Magick Type.
     */
    DEATH(
            ChatColor.DARK_PURPLE + "\u24B9eath",
            "6db32b15d7f32704ed626fa52d06fb2b4071d336fdbfe61e6e41c669d6e37f47",
            "3aa4a7bb2cb88c7d11ee1adfa40d9acd75d8fb06b11a4969ce0715cf98e0c5ca",
            new SpellClass[]{
                    new fr.mayayoh.magick.spell.death.Placeholder1(),
                    new fr.mayayoh.magick.spell.death.Placeholder2(),
                    new fr.mayayoh.magick.spell.death.Placeholder3(),
                    new fr.mayayoh.magick.spell.death.Placeholder4(),
                    new fr.mayayoh.magick.spell.death.Placeholder5(),
                    new fr.mayayoh.magick.spell.death.Placeholder6(),
                    new fr.mayayoh.magick.spell.death.Placeholder7(),
                    new fr.mayayoh.magick.spell.death.Placeholder8(),
                    new fr.mayayoh.magick.spell.death.Placeholder9(),
            },
            Particle.SPELL_WITCH,
            new HashMap<>(){{
                put(Material.BONE_BLOCK, null); put(Material.WITHER_ROSE, null);
                put(Material.SOUL_SAND, null); put(Material.SPAWNER, null);
            }}
    );


    final private String display;
    final private String texture;
    final private String textureZero;
    @Getter final private SpellClass[] spellList;
    @Getter final private Particle particle;
    @Getter final private Map<Material, String> sources;

    /**
     * MagickTypeEnum constructor.
     *
     * @author maYayoh
     * {@code display} defaults to Error.
     * {@code texture} defaults to a texture of missing block.
     * {@code textureZero} defaults to {@code texture}.
     * {@code spellList} defaults to an Array of 9 DefaultSpell, making the plugin disable itself if activated.
     * {@code particle} defaults to Particle.BARRIER.
     * @see MagickTypeEnum#MagickTypeEnum(String, String, String, SpellClass[], Particle, Map)
     */
    MagickTypeEnum() {
        this.display = "Error";
        this.texture = "4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c";
        this.textureZero = texture;
        this.spellList = new SpellClass[]{
                new DefaultSpell(),
                new DefaultSpell(),
                new DefaultSpell(),
                new DefaultSpell(),
                new DefaultSpell(),
                new DefaultSpell(),
                new DefaultSpell(),
                new DefaultSpell(),
                new DefaultSpell()
        };
        this.particle = Particle.BARRIER;
        this.sources = new HashMap<>();
    }


    /**
     * MagickTypeEnum constructor.
     *
     * @author maYayoh
     * @param display How the Magick type should be display with text.
     * @param texture The texture to apply on custom heads.
     * @param textureZero The texture to apply on custom heads if the essence's value equals zero.
     * @param spellList An SpellClass Array containing all classes for the spells.
     * @param particle A particle used when gathering essences or casting spell.
     * @param sources A Map of all Materials and States used to gather essences.
     * @see SpellClass
     */
    MagickTypeEnum(final String display, final String texture, final String textureZero, final SpellClass[] spellList, final Particle particle, final Map<Material, String> sources) {
        this.display = display;
        this.texture = texture;
        this.textureZero = textureZero;
        this.spellList = spellList;
        this.particle = particle;
        this.sources = sources;
    }



    /**
     * Get the ID associated with the Magick Type.
     *
     * @return The ID.
     */
    public int getId() { return this.ordinal(); }

    /**
     * Get the Magick Type associated with the ID.
     *
     * @param id The ID between 1 and 6.
     * @return The Magick type.
     */
    @NotNull
    public static MagickTypeEnum getById(final int id) {
        for (MagickTypeEnum type : MagickTypeEnum.values()) {
            if (type.ordinal() == id) {
                return type;
            }
        }
        return MagickTypeEnum.NONE;
    }


    /**
     * Get Magick type from an essence's source block.
     *
     * @param source The source block.
     * @return The Magick type.
     */
    @NotNull
    public static MagickTypeEnum getTypeFromBlock(final Block source) {
        for (MagickTypeEnum type : MagickTypeEnum.values()) {
            final Map<Material, String> typeSources = type.getSources();
            for(Material material : typeSources.keySet()) {
                if (source.getType().equals(material)) {
                    if (typeSources.get(material) == null || source.getBlockData().getAsString(true).equals(typeSources.get(material)))
                        return type;
                }
            }
        } return  MagickTypeEnum.NONE;
    }



    /**
     * Get the icon associated with the Magick Type.
     *
     * {@code amount} defaults to 1.
     * {@code displayName} defaults to a blank name.
     * {@code displayLore} defaults to an empty Array.
     * @see MagickTypeEnum#getIcon(int, String, String...)
     * @return An ItemStack of the wanted icon.
     */
    public ItemStack getIcon() { return getIcon(1, " "); }

    /**
     * Get the icon associated with the Magick Type.
     *
     * @param amount The amount of essence, which will correspond the amount of item in the ItemStack.
     * {@code displayName} defaults to a blank name.
     * {@code displayLore} defaults to an empty Array.
     * @see MagickTypeEnum#getIcon(int, String, String...)
     * @return An ItemStack of the wanted icon.
     */
    public ItemStack getIcon(final int amount) { return getIcon(amount, " "); }

    /**
     * Get the icon associated with the Magick Type.
     *
     * @param displayName The custom display name of the ItemStack.
     * @param displayLore The custom lore of the ItemStack.
     *                    Entering multiple String will create multiple lines in the lore.
     *                    Can be empty.
     * {@code amount} defaults to 1.
     * @see MagickTypeEnum#getIcon(int, String, String...)
     * @return An ItemStack of the wanted icon.
     */
    public ItemStack getIcon(@NotNull final String displayName, final String... displayLore) { return getIcon(1, displayName, displayLore); }

    /**
     * Get the icon associated with the Magick Type.
     *
     * @param amount The amount of essence, which will correspond the amount of item in the ItemStack.
     * @param displayName The custom display name of the ItemStack.
     * @param displayLore The custom lore of the ItemStack.
     *                    Entering multiple String will create multiple lines in the lore.
     *                    Can be empty.
     * @see ItemBuilder#getCustomHead(String, int, String, String...)
     * @return An ItemStack of the wanted icon.
     */
    public ItemStack getIcon(final int amount, @NotNull final String displayName, final String... displayLore) {
        return ItemBuilder.getCustomHead(this.texture, amount, displayName, displayLore);
    }


    /**
     * Get the icon associated with the Magick Type with an essence's value of zero.
     *
     * {@code displayName} defaults to a blank name.
     * {@code displayLore} defaults to an empty Array.
     * @see MagickTypeEnum#getZeroIcon(String, String...)
     * @return An ItemStack of the wanted icon.
     */
    public ItemStack getZeroIcon() { return getIcon(1, " "); }

    /**
     * Get the icon associated with the Magick Type with an essence's value of zero.
     *
     * @param displayName The custom display name of the ItemStack.
     * @param displayLore The custom lore of the ItemStack.
     *                    Entering multiple String will create multiple lines in the lore.
     *                    Can be empty.
     * @see ItemBuilder#getCustomHead(String, int, String, String...)
     * @return An ItemStack of the wanted icon.
     */
    public ItemStack getZeroIcon(@NotNull final String displayName, final String... displayLore) {
        return ItemBuilder.getCustomHead(this.textureZero, 1, displayName, displayLore);
    }


    /**
     * Get the icon associated with the Magick Type.
     *
     * @param amount The amount of essence, which will correspond the amount of item in the ItemStack.
     *                    Entering multiple String will create multiple lines in the lore.
     * @see ItemBuilder#getCustomHead(String, int, String, String...)
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



    /**
     * Get the spells icons Array for this Magick Type.
     *
     * @return An ItemStack Array of the spells icons.
     */
    public ItemStack[] getSpellIconList() {
        final List<ItemStack> spellIcon = new ArrayList<>();
        for (SpellClass spell : spellList) {
            spellIcon.add(spell.getSpellIcon());
        }
        return spellIcon.toArray(new ItemStack[0]);
    }



    /**
     * Returns the display for the Magick Type.
     *
     * @return The display of the Magick Type.
     */
    public String toString() {
        return this.display;
    }
}
