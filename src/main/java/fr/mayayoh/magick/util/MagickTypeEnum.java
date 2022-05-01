package fr.mayayoh.magick.util;

import fr.mayayoh.magick.spell.SpellClass;
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
    NONE(),

    /**
     * Fire Magick Type.
     */
    FIRE(
            ChatColor.RED + "\u24BBire",
            "dec65fc87c504415eff730a2f4fe7d06d2f116ea2a313481f362d0a25d65e500",
            "7619bf62863ec11577d6ef65efdc3f9de4df414202ed1ff1de9ec76b61a3f667",
            new ItemStack[]{
                    // Spell 1
                    ItemBuilder.getCustomHead("64b1b9ce2e9a6ce8a985d39776e2908077b82e6a333d2a81a441438eab39f8e1",
                            1, ChatColor.RED + "Fire Wave", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24BBire Spell"),

                    // Spell 2 | Missing texture
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.RED + "Fireball", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24BBire Spell"),

                    // Spell 3
                    ItemBuilder.getCustomHead("bb508c779f312daff337d137f34dd365a3f9c132bd92eb0c5ffab7c5b4a55c5",
                            1, ChatColor.RED + "Burning Snip", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24BBire Spell"),

                    // Spell 4
                    ItemBuilder.getCustomHead("7717933c40fbf936aa9288513efe19bda4601efc0e4ecad2e023b0c1d28444b",
                            1, ChatColor.RED + "Turret", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24BBire Spell"),

                    // Spell 5
                    ItemBuilder.getCustomHead("33f8a9fe3339c2f22704bf1c03394df071ee4ef3d72eebeaabaf3105cffe142",
                            1, ChatColor.RED + "Trap", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24BBire Spell"),

                    // Spell 6
                    ItemBuilder.getCustomHead("6ebb4d93feb49d904c61a8fa0eaeac41fe34442cafea7801038ebf7c381c8397",
                            1, ChatColor.RED + "Blaze Buddy", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24BBire Spell"),

                    // Spell 7
                    ItemBuilder.getCustomHead("967963cab657d2549dea534be238499d64d6165a592ca361512687a96ed960",
                            1, ChatColor.RED + "Lava Splash", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24BBire Spell"),

                    // Spell 8
                    ItemBuilder.getCustomHead("602a1169309f05ef2f061b1fa0fe225f29d73a24f8f07ccc2a705deeaca069d1",
                            1, ChatColor.RED + "Self Destruct", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24BBire Spell"),

                    // Spell 9
                    ItemBuilder.getCustomHead("2c915db3fc40a79b63c2c453f0c490981e5227c5027501283272138533dea519",
                            1, ChatColor.RED + "HellScape", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24BBire Spell")

            }
    ),

    /**
     * Water Magick Type.
     */
    WATER(
            ChatColor.BLUE + "\u24CCater",
            "9e52f7960ff3cec2f519a6353648c6e33bc51e131cc80917cf13081decbff24d",
            "c487ffab15d628cb0ed493919e154da0b97b0613bb40f8b38757de507bbd6094",
            new ItemStack[]{
                    // Spell 1 | Missing texture
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.BLUE + "Wave", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24CCater Spell"),

                    // Spell 2
                    ItemBuilder.getCustomHead("b2d6d935f3714662c1e3b2826f663bb623ce09b1dfd9004b8cda46550f426580",
                            1, ChatColor.BLUE + "Ice Path", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24CCater Spell"),

                    // Spell 3
                    ItemBuilder.getCustomHead("df0d96336ffcc7f12a8a8f5e3bd258ec2d8037ba24a435917c3d531b216de6d7",
                            1, ChatColor.BLUE + "Rainy Cloud", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24CCater Spell"),

                    // Spell 4
                    ItemBuilder.getCustomHead("ddba642efffa13ec3730eafc5914ab68115c1f998803f74452e2e0cd26af0b8",
                            1, ChatColor.BLUE + "Ice Throw", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24CCater Spell"),

                    // Spell 5
                    ItemBuilder.getCustomHead("ecc67def90cde4b42bc157fce411d70710961c8ede38a32f93d24f471eb12226",
                            1, ChatColor.BLUE + "Illusion", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24CCater Spell"),

                    // Spell 6
                    ItemBuilder.getCustomHead("26e429c60932ebc366e791a42e186af888de08e5d8eb8ac6f5b6f4d440db486c",
                            1, ChatColor.BLUE + "Ice Spear", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24CCater Spell"),

                    // Spell 7 | Placeholder
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.BLUE + "Placeholder", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24CCater Spell"),

                    // Spell 8 | Placeholder
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.BLUE + "Placeholder", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24CCater Spell"),

                    // Spell 9 | Placeholder
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.BLUE + "Placeholder", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24CCater Spell")

            }
    ),

    /**
     * Plant Magick Type.
     */
    PLANT(
            ChatColor.GREEN + "\u24C5lant",
            "684380ad4dc388f561254c8409fa704d44747eb6e5feacba343e7c243cfac6a1",
            "964ad8da319e6eb37721e02c78864990b45fc0fea06ee52ed4c24ac197278cb7",
            new ItemStack[]{
                    // Spell 1
                    ItemBuilder.getCustomHead("5f497786d7ba192369932966686aa9fb7147fa5884f9a6209c4a73e2d60f39f5",
                            1, ChatColor.GREEN + "Tree Grow", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24C5lant Spell"),

                    // Spell 2 | Temp Texture?
                    ItemBuilder.getCustomHead("ca8d3d3b2e6babece55264136057a26821c3704132966ee9ecca93acc9887a0",
                            1, ChatColor.GREEN + "Fireball", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24C5lant Spell"),

                    // Spell 3 | Placeholder
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.GREEN + "Placeholder", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24C5lant Spell"),

                    // Spell 4
                    ItemBuilder.getCustomHead("3795edeeb6b7ed41c268cefeafbe960b7c49550daeb631b56156bf5feb9847",
                            1, ChatColor.GREEN + "Razor Leaf", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24C5lant Spell"),

                    // Spell 5
                    ItemBuilder.getCustomHead("eb8418c461f63d6aad3932a639fce3fec227a3774a59b851ffbe655874eb791",
                            1, ChatColor.GREEN + "Become blok.", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24C5lant Spell"),

                    // Spell 6 | Placeholder
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.GREEN + "Placeholder", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24C5lant Spell"),

                    // Spell 7 | Placeholder
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.GREEN + "Placeholder", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24C5lant Spell"),

                    // Spell 8 | Placeholder
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.GREEN + "Placeholder", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24C5lant Spell"),

                    // Spell 9 | Placeholder
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.GREEN + "Placeholder", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24C5lant Spell"),

            }
    ),

    /**
     * Earth Magick Type.
     */
    EARTH(
            ChatColor.GOLD + "\u24BAarth",
            "d774e5ef3d8bcde9ea21c34b84827d34531e68f111510f3383055ecaa74bebcc",
            "16a18f9d1ae5ab04461127e31c5190c76b442da502877aa647fd0340507b33a5",
            new ItemStack[]{
                    // Spell 1 | Missing texture
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.GOLD + "Rock Throw", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24BAarth Spell"),

                    // Spell 2 | Missing Texture
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.GOLD + "Wall Rising", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24BAarth Spell"),

                    // Spell 3 | Placeholder
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.GOLD + "Placeholder", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24BAarth Spell"),

                    // Spell 4 | Missing Texture
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.GOLD + "Earthquake", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24BAarth Spell"),

                    // Spell 5 | Placeholder
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.GOLD + "Placeholder", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24BAarth Spell"),

                    // Spell 6 | Placeholder
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.GOLD + "Placeholder", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24BAarth Spell"),

                    // Spell 7 | Placeholder
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.GOLD + "Placeholder", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24BAarth Spell"),

                    // Spell 8 | Placeholder
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.GOLD + "Placeholder", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24BAarth Spell"),

                    // Spell 9 | Placeholder
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.GOLD + "Placeholder", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24BAarth Spell"),

            }
    ),

    /**
     * Light Magick Type.
     */
    LIGHT(
            ChatColor.YELLOW + "\u24c1ight",
            "21469ce67dfc28433aea8a45ab816e51bd39ba9eb815d22579e77698da0bf295",
            "dc6999c1f59646fe0121a99d9b0fef3996ed78c6dc55531dabcca708c1dcf916",
            new ItemStack[]{
                    // Spell 1 | Missing texture
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.YELLOW + "Light Orb", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24c1ight Spell"),

                    // Spell 2 | Missing texture
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.YELLOW + "Poison Cure", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24c1ight Spell"),

                    // Spell 3 | Placeholder
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.YELLOW + "Placeholder", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24c1ight Spell"),

                    // Spell 4 | Missing texture
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.YELLOW + "Wither Cure", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24c1ight Spell"),

                    // Spell 5 | Missing texture
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.YELLOW + "Home Call", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24c1ight Spell"),

                    // Spell 6 | Missing texture
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.YELLOW + "Light Beam", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24c1ight Spell"),

                    // Spell 7 | Placeholder
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.YELLOW + "Placeholder", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24c1ight Spell"),

                    // Spell 8 | Placeholder
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.YELLOW + "Placeholder", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24c1ight Spell"),

                    // Spell 9 | Missing texture
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.YELLOW + "Ultra Laser", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24c1ight Spell"),

            }
    ),

    /**
     * Death Magick Type.
     */
    DEATH(
            ChatColor.DARK_PURPLE + "\u24B9eath",
            "6db32b15d7f32704ed626fa52d06fb2b4071d336fdbfe61e6e41c669d6e37f47",
            "3aa4a7bb2cb88c7d11ee1adfa40d9acd75d8fb06b11a4969ce0715cf98e0c5ca",
            new ItemStack[]{
                    // Spell 1
                    ItemBuilder.getCustomHead("06aea6aca1a81b23bd8c5e508fe76648fc2e41faa1c8fc26cfa8bdce4163",
                            1, ChatColor.DARK_PURPLE + "Zombie Buddy", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24B9eath Spell"),

                    // Spell 2
                    ItemBuilder.getCustomHead("3e708a925e10f29f2232a91e411835376a1db15c8fd396dbcb95b3df9db055b1",
                            1, ChatColor.DARK_PURPLE + "Skelly Buddy", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24B9eath Spell"),

                    // Spell 3 | Placeholder
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.DARK_PURPLE + "Placeholder", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24B9eath Spell"),

                    // Spell 4 | Placeholder
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.DARK_PURPLE + "Placeholder", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24B9eath Spell"),

                    // Spell 5 | Placeholder
                    ItemBuilder.getCustomHead("7a70c5d07b79c5be43d0b21c6d4e37472db2ab3fa634a5f13cf89fb987b2e5",
                            1, ChatColor.DARK_PURPLE + "Nether Buddy", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24B9eath Spell"),

                    // Spell 6
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.DARK_PURPLE + "Placeholder", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24B9eath Spell"),

                    // Spell 7 | Placeholder
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.DARK_PURPLE + "Placeholder", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24B9eath Spell"),

                    // Spell 8 | Placeholder
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.DARK_PURPLE + "Placeholder", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24B9eath Spell"),

                    // Spell 9 | Placeholder
                    ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c",
                            1, ChatColor.DARK_PURPLE + "Placeholder", ChatColor.RESET.toString() + ChatColor.DARK_GRAY + ChatColor.ITALIC + "\u24B9eath Spell")

            }
    );


    final private String display;
    final private String texture;
    final private String textureZero;
    @Getter final private ItemStack[] spellList;

    /**
     * MagickTypeEnum constructor.
     *
     * @author maYayoh
     * {@code display} defaults to Error.
     * {@code texture} defaults to a texture of missing block.
     * {@code textureZero} defaults to {@code texture}.
     * {@code spellList} defaults to an Array of 9 ItemStack (custom heads) with {@code texture}.
     * @see MagickTypeEnum#MagickTypeEnum(String, String, String, ItemStack[])
     */
    MagickTypeEnum() {
        this.display = "Error";
        this.texture = "4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c";
        this.textureZero = texture;
        this.spellList = new ItemStack[]{
                ItemBuilder.getCustomHead(texture),
                ItemBuilder.getCustomHead(texture),
                ItemBuilder.getCustomHead(texture),
                ItemBuilder.getCustomHead(texture),
                ItemBuilder.getCustomHead(texture),
                ItemBuilder.getCustomHead(texture),
                ItemBuilder.getCustomHead(texture),
                ItemBuilder.getCustomHead(texture),
                ItemBuilder.getCustomHead(texture),
        };
    }


    /**
     * MagickTypeEnum constructor.
     *
     * @author maYayoh
     * @param display How the Magick type should be display with text.
     * @param texture The texture to apply on custom heads.
     * @param textureZero The texture to apply on custom heads if the essence's value equals zero.
     * @param spellList An ItemStack Array containing the items representing the spells of the Magick type.
     * @see ItemStack
     */
    MagickTypeEnum(final String display, final String texture, final String textureZero, final ItemStack[] spellList) {
        this.display = display;
        this.texture = texture;
        this.textureZero = textureZero;
        this.spellList = spellList;
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
    public static MagickTypeEnum getById(final int id) {
        for (MagickTypeEnum type : MagickTypeEnum.values()) {
            if (type.getId() == id) {
                return type;
            }
        }
        return MagickTypeEnum.NONE;
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
     * Get the spell icon by its id.
     *
     * @param spellId The id of the spell wanted.
     * @return An ItemStack of the wanted spell icon.
     */
    public ItemStack getSpellIcon(final int spellId) {
        try {
            return this.spellList[spellId];
        } catch (final NullPointerException e) {
            return null;
        }
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
