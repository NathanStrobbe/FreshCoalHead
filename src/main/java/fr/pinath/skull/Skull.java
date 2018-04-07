package fr.pinath.skull;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.UUID;

public class Skull extends ItemStack {
    private String name;
    private String texture;

    /**
     * @param name    Head's name
     * @param texture Value of the head's texture
     * @author Pelt10
     * @author Pinath
     */
    public Skull(String name, String texture) {
        this.name = name;
        this.texture = texture;

        this.setType(Material.SKULL_ITEM);
        this.setAmount(1);
        this.setDurability((short) SkullType.PLAYER.ordinal());

        ItemMeta headM = this.getItemMeta();

        try {
            Field field = headM.getClass().getDeclaredField("profile");
            field.setAccessible(true);

            GameProfile profile = new GameProfile(UUID.randomUUID(), null);
            PropertyMap propertyMap = profile.getProperties();

            if (propertyMap == null)
                throw new IllegalStateException("Profile doesn't contain a property map");

            byte[] encodedData = texture.getBytes();
            propertyMap.put("textures", new Property("textures", new String(encodedData)));

            field.set(headM, profile);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            Bukkit.getLogger().severe(e.getMessage());
        }

        headM.setDisplayName(name);
        this.setItemMeta(headM);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Skull skull = (Skull) o;
        return Objects.equals(name, skull.name) &&
                Objects.equals(texture, skull.texture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, texture);
    }
}
