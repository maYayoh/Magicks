package fr.mayayoh.magick.util;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class MagickRegistry {
    private static MagickRegistry instance = null;

    private final Map<UUID, ItemStack[]> inventoryBackups;
    private final Map<UUID, Boolean> isPlayerInMagick;
    private final Map<UUID, Boolean> isPlayerInPreview;

    public void saveInventory(final Player p) {
        this.inventoryBackups.put(p.getUniqueId(), p.getInventory().getContents());
    }

    public void loadInventory(final Player p) {
        p.getInventory().setContents(this.inventoryBackups.get(p.getUniqueId()));
        this.inventoryBackups.remove(p.getUniqueId());
    }

    public boolean isPlayerInMagick(final Player p) {
        return (this.isPlayerInMagick.get(p.getUniqueId()) != null);
    }

    public void setMode(final Player p, final boolean inMagick) {
        if(inMagick && this.isPlayerInMagick.get(p.getUniqueId()) == null) this.isPlayerInMagick.put(p.getUniqueId(), true);
        if(!inMagick && this.isPlayerInMagick.get(p.getUniqueId()) != null) this.isPlayerInMagick.remove(p.getUniqueId());
    }

    public boolean isPlayerInPreview(final Player p) {
        return this.isPlayerInPreview.get(p.getUniqueId()) != null;
    }

    public void setPreview(final Player p, final boolean inMagick) {
        if(inMagick && this.isPlayerInPreview.get(p.getUniqueId()) == null) this.isPlayerInPreview.put(p.getUniqueId(), true);
        if(!inMagick && this.isPlayerInPreview.get(p.getUniqueId()) != null) this.isPlayerInPreview.remove(p.getUniqueId());
    }

    private MagickRegistry() {
        this.inventoryBackups = new HashMap<>();
        this.isPlayerInMagick = new HashMap<>();
        this.isPlayerInPreview = new HashMap<>();
    }

    public static MagickRegistry getInstance() {

        if(instance == null) {
            instance = new MagickRegistry();
        }
        return instance;

    }
}
