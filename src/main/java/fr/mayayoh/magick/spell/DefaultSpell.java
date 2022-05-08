package fr.mayayoh.magick.spell;

import fr.mayayoh.magick.MagickPlugin;
import fr.mayayoh.magick.util.ItemBuilder;
import fr.mayayoh.magick.util.MagickTypeEnum;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class DefaultSpell extends SpellClass {

    public DefaultSpell() {
        super(MagickTypeEnum.NONE, -1,
                ItemBuilder.getCustomHead("4e2ce3372a3ac97fdda5638bef24b3bc49f4facf751fe9cad645f15a7fb8397c"));
    }

    @Override
    protected void spellEffect(final Player player) {
        Bukkit.getConsoleSender().sendMessage("Something really weird happened.");
        MagickPlugin.getInstance().getPluginLoader().disablePlugin(MagickPlugin.getInstance());
    }
}
