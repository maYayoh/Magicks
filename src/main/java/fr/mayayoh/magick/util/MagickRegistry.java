package fr.mayayoh.magick.util;

import fr.mayayoh.magick.gui.GUIClass;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class MagickRegistry {
    private static MagickRegistry instance = null;

    private MagickRegistry() {
        this.currentMenu = new HashMap<>();
        this.inventoryBackups = new HashMap<>();
        this.isPlayerInMagick = new HashMap<>();
        this.isPlayerInPreview = new HashMap<>();

        this.gatheringInfo = new HashMap<>();
    }


    private final Map<UUID, GUIClass> currentMenu;
    private final Map<UUID, ItemStack[]> inventoryBackups;
    private final Map<UUID, Boolean> isPlayerInMagick;
    private final Map<UUID, Boolean> isPlayerInPreview;
    @Getter private final Map<UUID, Map<String, Object>> gatheringInfo;

    public void saveInventory(final Player p) { saveInventory(p.getUniqueId());}
    public void saveInventory(final UUID u) {
        this.inventoryBackups.put(u, Objects.requireNonNull(Bukkit.getPlayer(u)).getInventory().getContents());
    }

    public void loadInventory(final Player p) { loadInventory(p.getUniqueId()); }
    public void loadInventory(final UUID u) {
        Objects.requireNonNull(Bukkit.getPlayer(u)).getInventory().setContents(inventoryBackups.get(u));
        this.inventoryBackups.remove(u);
    }

    @Nullable public ItemStack[] getBackup(final Player p) { return getBackup(p.getUniqueId()); }
    @Nullable public ItemStack[] getBackup(final UUID u) { return inventoryBackups.get(u); }

    public void removeBackup(@NotNull final Player p) { removeBackup(p.getUniqueId()); }
    public void removeBackup(@NotNull final UUID u) { if (inventoryBackups.get(u) != null) inventoryBackups.remove(u); }

    public boolean isPlayerInMagick(final Player p) { return isPlayerInMagick(p.getUniqueId()); }
    public boolean isPlayerInMagick(final UUID u) {
        return (this.isPlayerInMagick.get(u) != null);
    }

    public void setMode(final Player p, final boolean inMagick) { setMode(p.getUniqueId(), inMagick); }
    public void setMode(final UUID u, final boolean inMagick) {
        if(inMagick && this.isPlayerInMagick.get(u) == null) this.isPlayerInMagick.put(u, true);
        if(!inMagick && this.isPlayerInMagick.get(u) != null) this.isPlayerInMagick.remove(u);
    }

    public boolean isPlayerInPreview(final Player p) { return isPlayerInPreview(p.getUniqueId()); }
    public boolean isPlayerInPreview(final UUID u) {
        return this.isPlayerInPreview.get(u) != null;
    }

    public void setPreview(final Player p, final boolean inPreview) {
        if(inPreview && this.isPlayerInPreview.get(p.getUniqueId()) == null) this.isPlayerInPreview.put(p.getUniqueId(), true);
        if(!inPreview && this.isPlayerInPreview.get(p.getUniqueId()) != null) this.isPlayerInPreview.remove(p.getUniqueId());
    }

    @Nullable public GUIClass getCurrentMenu(@NotNull final Player p) { return getCurrentMenu(p.getUniqueId()); }
    @Nullable public GUIClass getCurrentMenu(@NotNull final UUID u) {
        return currentMenu.get(u);
    }

    public void setCurrentMenu(@NotNull final Player p, @Nullable final GUIClass menu) { setCurrentMenu(p.getUniqueId(), menu); }
    public void setCurrentMenu(@NotNull final UUID u, @Nullable final GUIClass menu) {
        if (menu == null)
            removeCurrentMenu(u);
        else
            currentMenu.put(u, menu);
    }

    public void removeCurrentMenu(@NotNull final Player p) { removeCurrentMenu(p.getUniqueId()); }
    public void removeCurrentMenu(@NotNull final UUID u) { if (currentMenu.get(u) != null) currentMenu.remove(u); }


    @Nullable public Map<String, Object> getGatherInfo(@NotNull final Player p) { return getGatherInfo(p.getUniqueId()); }
    @Nullable public Map<String, Object> getGatherInfo(@NotNull final UUID u) {
        return gatheringInfo.get(u);
    }

    public void setGatherInfo(@NotNull final Player p, final Block block, final Integer timer) { setGatherInfo(p.getUniqueId(), block, timer);}
    public void setGatherInfo(@NotNull final UUID u, final Block block, final Integer timer) { setGatherInfo(u, new HashMap<>(){{
        put("block", block);
        put("timer", timer);
    }});}

    public void setGatherInfo(@NotNull final Player p, @Nullable final Map<String, Object> pair) { setGatherInfo(p.getUniqueId(), pair); }
    public void setGatherInfo(@NotNull final UUID u, @Nullable final Map<String, Object> pair) {
        if (pair == null)
            removeGatherInfo(u);
        else
            gatheringInfo.put(u, pair);
    }

    public void removeGatherInfo(@NotNull final Player p) { removeGatherInfo(p.getUniqueId()); }
    public void removeGatherInfo(@NotNull final UUID u) { if (gatheringInfo.get(u) != null) gatheringInfo.remove(u); }



    public static MagickRegistry getInstance() {
        if(instance == null) {
            instance = new MagickRegistry();
        }
        return instance;
    }
}