package fr.mayayoh.magick.spell.water;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import fr.mayayoh.magick.MagickPlugin;
import fr.mayayoh.magick.spell.SpellClass;
import fr.mayayoh.magick.util.ItemBuilder;
import net.minecraft.server.v1_16_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.craftbukkit.v1_16_R3.CraftServer;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class IllusionSpell extends SpellClass {

    public IllusionSpell() {
        super(3, 4, ItemBuilder.getCustomHead("ecc67def90cde4b42bc157fce411d70710961c8ede38a32f93d24f471eb12226",
                1, ChatColor.BLUE + "Illusion", ChatColor.DARK_GRAY.toString() + ChatColor.ITALIC + "\u24CCater Spell")
        );
    }

    @Override
    protected void spellEffect(final Player player) {
        final Location loc = player.getLocation();

        final GameProfile playerProfile = ((CraftPlayer) player).getHandle().getProfile();
        final GameProfile illusionProfile = new GameProfile(new UUID(player.getUniqueId().hashCode(), player.getUniqueId().hashCode()), player.getName());

        final Property property = playerProfile.getProperties().get("textures").iterator().next();
        final String texture = property.getValue();
        final String signature = property.getSignature();

        illusionProfile.getProperties().put("textures", new Property("textures", texture, signature));

        final WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
        final EntityPlayer entityPlayer = new EntityPlayer(
                ((CraftServer) Bukkit.getServer()).getServer(), world, illusionProfile, new PlayerInteractManager(world));
        entityPlayer.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());

        final Scoreboard score = new Scoreboard();
        final ScoreboardTeam scoreTeam = new ScoreboardTeam(score, "trans-" + player.getEntityId());
        scoreTeam.setCanSeeFriendlyInvisibles(true);
        scoreTeam.setCollisionRule(ScoreboardTeamBase.EnumTeamPush.NEVER);
        final ArrayList<String> list = new ArrayList<>();
        list.add(entityPlayer.getBukkitEntity().getName());

        Bukkit.getOnlinePlayers().forEach(onlinePlayer -> {

            if(!onlinePlayer.getName().equals(entityPlayer.getName())) list.add(onlinePlayer.getName());

            final PlayerConnection con = ((CraftPlayer) onlinePlayer).getHandle().playerConnection;

            con.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, entityPlayer)); // Declare player entity
            con.sendPacket(new PacketPlayOutNamedEntitySpawn(entityPlayer)); // Spawn the player
            con.sendPacket(new PacketPlayOutEntityHeadRotation(entityPlayer, (byte) (loc.getYaw() * 256.0f / 360.0f))); // Rotate yaw
            con.sendPacket(new PacketPlayOutEntity.PacketPlayOutEntityLook(entityPlayer.getId(), (byte) (loc.getYaw() * 256.0f / 360.0f), (byte) (loc.getPitch() * 256.0f / 360.0f), true)); // Rotate pitch and body

            entityPlayer.setInvisible(true);

            final DataWatcher dw = entityPlayer.getDataWatcher();
            dw.set(new DataWatcherObject<>(16, DataWatcherRegistry.a), (byte) 0xFF);

            con.sendPacket(new PacketPlayOutEntityMetadata(entityPlayer.getId(), dw, true)); // Invisible

            con.sendPacket(new PacketPlayOutScoreboardTeam(scoreTeam, 0));
            con.sendPacket(new PacketPlayOutScoreboardTeam(scoreTeam, list, 3));

            Bukkit.getScheduler().runTaskLater(MagickPlugin.getInstance(), () -> {
                con.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, entityPlayer)); // Remove from tab
            }, 5);

            Bukkit.getScheduler().runTaskLater(MagickPlugin.getInstance(), () -> {
                ((CraftPlayer) onlinePlayer).getHandle().playerConnection.sendPacket(new PacketPlayOutEntityDestroy(entityPlayer.getId())); // Remove from tab
            }, 5 * 20);

        });

        Bukkit.getScheduler().runTaskLater(MagickPlugin.getInstance(), () ->
                Objects.requireNonNull(loc.getWorld()).spawnParticle(Particle.FLASH, loc, 1, 0, 0, 0, 0.5),
                5 * 20);

        player.setVelocity(player.getLocation().getDirection().setY(-0.5).multiply(-1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5 * 20, 2, false, false));
    }
}
