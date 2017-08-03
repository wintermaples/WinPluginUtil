package net.neonstars.util.entity;

import lombok.Getter;
import net.neonstars.util.location.SimpleLocation;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.util.Vector;

public class EntityUtil {

  @Getter
  protected static Vector ZOMBIE_SIZE = new Vector(0.6, 1.95, 0.6);
  @Getter
  protected static Vector BABY_ZOMBIE_SIZE = new Vector(0.6, 0.9, 0.6);
  @Getter
  protected static Vector SKELETON_SIZE = new Vector(0.6, 1.8, 0.6);
  @Getter
  protected static Vector CREEPER_SIZE = new Vector(0.6, 1.8, 0.6);
  @Getter
  protected static Vector SPIDER_SIZE = new Vector(1.4, 0.9, 1.4);
  @Getter
  protected static Vector ENDERMAN_SIZE = new Vector(0.6, 2.9, 0.6);
  @Getter
  protected static Vector CAVE_SPIDER_SIZE = new Vector(0.7, 0.5, 0.7);
  @Getter
  protected static Vector SILVERFISH_SIZE = new Vector(0.3, 0.7, 0.3);
  @Getter
  protected static Vector WITCH_SIZE = new Vector(0.6, 1.95, 0.6);
  @Getter
  protected static Vector ENDERMITE_SIZE = new Vector(0.43, 0.31, 0.43);
  @Getter
  protected static Vector GUARDIAN_SIZE = new Vector(0.9, 0.9, 0.9);
  @Getter
  protected static Vector ELDER_GUARDIAN_SIZE = new Vector(2, 2, 2);
  @Getter
  protected static Vector ZOMBIE_PIGMAN_SIZE = new Vector(0.6, 1.8, 0.6);
  @Getter
  protected static Vector BABY_ZOMBIE_PIGMAN_SIZE = new Vector(0.6, 0.9, 0.6);
  @Getter
  protected static Vector GHAST_SIZE = new Vector(4.0, 4.0, 4.0);
  @Getter
  protected static Vector BLAZE_SIZE = new Vector(0.6, 1.8, 0.6);
  @Getter
  protected static Vector WITHER_SKELETON_SIZE = new Vector(0.72, 2.535, 0.72);
  @Getter
  protected static Vector PIG_SIZE = new Vector(0.9, 0.9, 0.9);
  @Getter
  protected static Vector COW_SIZE = new Vector(0.9, 1.3, 0.9);
  @Getter
  protected static Vector SHEEP_SIZE = new Vector(0.9, 1.3, 0.9);
  @Getter
  protected static Vector CHICKEN_SIZE = new Vector(0.3, 0.7, 0.3);
  @Getter
  protected static Vector RABBIT_SIZE = new Vector(0.6, 0.7, 0.6);
  @Getter
  protected static Vector SQUID_SIZE = new Vector(0.95, 0.95, 0.95);
  @Getter
  protected static Vector BAT_SIZE = new Vector(0.5, 0.9, 0.5);
  @Getter
  protected static Vector WOLF_SIZE = new Vector(0.6, 0.8, 0.6);
  @Getter
  protected static Vector OCELOT_SIZE = new Vector(0.6, 0.8, 0.6);
  @Getter
  protected static Vector HORSE_SIZE = new Vector(2, 2, 2);
  @Getter
  protected static Vector SNOW_GOLEM_SIZE = new Vector(0.4, 1.8, 0.4);
  @Getter
  protected static Vector IRON_GOLEM_SIZE = new Vector(1.4, 2.9, 1.4);
  @Getter
  protected static Vector VILLAGER_SIZE = new Vector(0.6, 1.8, 0.6);
  @Getter
  protected static Vector MINIMAL_SLIZE_SIZE = new Vector(0.6, 0.6, 0.6);
  @Getter
  protected static Vector MINIMAL_MAGMA_CUBE_SIZE = new Vector(0.6, 0.6, 0.6);

  /**
   * If specified entity can spawn at specified loc, it returns true.
   *
   * @param loc Location
   * @param type Entity Type
   * @return If specified entity can spawn at specified loc, it returns true.
   */
  public static boolean canSpawn(Location loc, EntityType type) {
    return canSpawn(new SimpleLocation(loc), type);
  }

  /**
   * If specified entity can spawn at specified loc, it returns true.
   *
   * @param loc Location
   * @param type Entity Type
   * @return If specified entity can spawn at specified loc, it returns true.
   */
  public static boolean canSpawn(SimpleLocation loc, EntityType type) {
    return canSpawn(loc, type, false);
  }

  /**
   * If specified entity can spawn at specified loc, it returns true.
   *
   * @param loc Location
   * @param type Entity Type
   * @param flag This is used as isBaby or isWitherSkeleton or isElderGuardian
   * @return If specified entity can spawn at specified loc, it returns true.
   */
  public static boolean canSpawn(Location loc, EntityType type, boolean flag) {
    double x_size;
    double y_size;
    double z_size;
    switch (type) {
      case ZOMBIE:
        if (!flag) {
          x_size = ZOMBIE_SIZE.getX();
          y_size = ZOMBIE_SIZE.getY();
          z_size = ZOMBIE_SIZE.getZ();
        } else {
          x_size = BABY_ZOMBIE_SIZE.getX();
          y_size = BABY_ZOMBIE_SIZE.getY();
          z_size = BABY_ZOMBIE_SIZE.getZ();
        }
        break;
      case SKELETON:
        if (!flag) {
          x_size = SKELETON_SIZE.getX();
          y_size = SKELETON_SIZE.getY();
          z_size = SKELETON_SIZE.getZ();
        } else {
          x_size = WITHER_SKELETON_SIZE.getX();
          y_size = WITHER_SKELETON_SIZE.getY();
          z_size = WITHER_SKELETON_SIZE.getZ();
        }
        break;
      case CREEPER:
        x_size = CREEPER_SIZE.getX();
        y_size = CREEPER_SIZE.getY();
        z_size = CREEPER_SIZE.getZ();
        break;
      case SPIDER:
        x_size = SPIDER_SIZE.getX();
        y_size = SPIDER_SIZE.getY();
        z_size = SPIDER_SIZE.getZ();
        break;
      case ENDERMAN:
        x_size = ENDERMAN_SIZE.getX();
        y_size = ENDERMAN_SIZE.getY();
        z_size = ENDERMAN_SIZE.getZ();
        break;
      case CAVE_SPIDER:
        x_size = CAVE_SPIDER_SIZE.getX();
        y_size = CAVE_SPIDER_SIZE.getY();
        z_size = CAVE_SPIDER_SIZE.getZ();
        break;
      case SILVERFISH:
        x_size = SILVERFISH_SIZE.getX();
        y_size = SILVERFISH_SIZE.getY();
        z_size = SILVERFISH_SIZE.getZ();
        break;
      case WITCH:
        x_size = WITCH_SIZE.getX();
        y_size = WITCH_SIZE.getY();
        z_size = WITCH_SIZE.getZ();
        break;
      case ENDERMITE:
        x_size = ENDERMITE_SIZE.getX();
        y_size = ENDERMITE_SIZE.getY();
        z_size = ENDERMITE_SIZE.getZ();
        break;
      case GUARDIAN:
        if (!flag) {
          x_size = GUARDIAN_SIZE.getX();
          y_size = GUARDIAN_SIZE.getY();
          z_size = GUARDIAN_SIZE.getZ();
        } else {
          x_size = ELDER_GUARDIAN_SIZE.getX();
          y_size = ELDER_GUARDIAN_SIZE.getY();
          z_size = ELDER_GUARDIAN_SIZE.getZ();
        }
        break;
      case PIG_ZOMBIE:
        if (!flag) {
          x_size = ZOMBIE_PIGMAN_SIZE.getX();
          y_size = ZOMBIE_PIGMAN_SIZE.getY();
          z_size = ZOMBIE_PIGMAN_SIZE.getZ();
        } else {
          x_size = BABY_ZOMBIE_PIGMAN_SIZE.getX();
          y_size = BABY_ZOMBIE_PIGMAN_SIZE.getY();
          z_size = BABY_ZOMBIE_PIGMAN_SIZE.getZ();
        }
        break;
      case GHAST:
        x_size = GHAST_SIZE.getX();
        y_size = GHAST_SIZE.getY();
        z_size = GHAST_SIZE.getZ();
        break;
      case BLAZE:
        x_size = BLAZE_SIZE.getX();
        y_size = BLAZE_SIZE.getY();
        z_size = BLAZE_SIZE.getZ();
        break;
      case PIG:
        if (!flag) {
          x_size = PIG_SIZE.getX();
          y_size = PIG_SIZE.getY();
          z_size = PIG_SIZE.getZ();
        } else {
          x_size = PIG_SIZE.getX() / 2;
          y_size = PIG_SIZE.getY() / 2;
          z_size = PIG_SIZE.getZ() / 2;
        }
        break;
      case COW:
        if (!flag) {
          x_size = COW_SIZE.getX();
          y_size = COW_SIZE.getY();
          z_size = COW_SIZE.getZ();
        } else {
          x_size = COW_SIZE.getX() / 2;
          y_size = COW_SIZE.getY() / 2;
          z_size = COW_SIZE.getZ() / 2;
        }
        break;
      case MUSHROOM_COW:
        if (!flag) {
          x_size = COW_SIZE.getX();
          y_size = COW_SIZE.getY();
          z_size = COW_SIZE.getZ();
        } else {
          x_size = COW_SIZE.getX() / 2;
          y_size = COW_SIZE.getY() / 2;
          z_size = COW_SIZE.getZ() / 2;
        }
        break;
      case SHEEP:
        if (!flag) {
          x_size = SHEEP_SIZE.getX();
          y_size = SHEEP_SIZE.getY();
          z_size = SHEEP_SIZE.getZ();
        } else {
          x_size = SHEEP_SIZE.getX() / 2;
          y_size = SHEEP_SIZE.getY() / 2;
          z_size = SHEEP_SIZE.getZ() / 2;
        }
        break;
      case CHICKEN:
        if (!flag) {
          x_size = CHICKEN_SIZE.getX();
          y_size = CHICKEN_SIZE.getY();
          z_size = CHICKEN_SIZE.getZ();
        } else {
          x_size = CHICKEN_SIZE.getX() / 2;
          y_size = CHICKEN_SIZE.getY() / 2;
          z_size = CHICKEN_SIZE.getZ() / 2;
        }
        break;
      case RABBIT:
        if (!flag) {
          x_size = RABBIT_SIZE.getX();
          y_size = RABBIT_SIZE.getY();
          z_size = RABBIT_SIZE.getZ();
        } else {
          x_size = RABBIT_SIZE.getX() / 2;
          y_size = RABBIT_SIZE.getY() / 2;
          z_size = RABBIT_SIZE.getZ() / 2;
        }
        break;
      case SQUID:
        x_size = SQUID_SIZE.getX();
        y_size = SQUID_SIZE.getY();
        z_size = SQUID_SIZE.getZ();
        break;
      case BAT:
        x_size = BAT_SIZE.getX();
        y_size = BAT_SIZE.getY();
        z_size = BAT_SIZE.getZ();
        break;
      case WOLF:
        if (!flag) {
          x_size = WOLF_SIZE.getX();
          y_size = WOLF_SIZE.getY();
          z_size = WOLF_SIZE.getZ();
        } else {
          x_size = WOLF_SIZE.getX() / 2;
          y_size = WOLF_SIZE.getY() / 2;
          z_size = WOLF_SIZE.getZ() / 2;
        }
        break;
      case OCELOT:
        if (!flag) {
          x_size = OCELOT_SIZE.getX();
          y_size = OCELOT_SIZE.getY();
          z_size = OCELOT_SIZE.getZ();
        } else {
          x_size = OCELOT_SIZE.getX() / 2;
          y_size = OCELOT_SIZE.getY() / 2;
          z_size = OCELOT_SIZE.getZ() / 2;
        }
        break;
      case HORSE:
        if (!flag) {
          x_size = HORSE_SIZE.getX();
          y_size = HORSE_SIZE.getY();
          z_size = HORSE_SIZE.getZ();
        } else {
          x_size = HORSE_SIZE.getX() / 2;
          y_size = HORSE_SIZE.getY() / 2;
          z_size = HORSE_SIZE.getZ() / 2;
        }
        break;
      case SNOWMAN:
        x_size = SNOW_GOLEM_SIZE.getX();
        y_size = SNOW_GOLEM_SIZE.getY();
        z_size = SNOW_GOLEM_SIZE.getZ();
        break;
      case IRON_GOLEM:
        x_size = IRON_GOLEM_SIZE.getX();
        y_size = IRON_GOLEM_SIZE.getY();
        z_size = IRON_GOLEM_SIZE.getZ();
        break;
      case VILLAGER:
        x_size = VILLAGER_SIZE.getX();
        y_size = VILLAGER_SIZE.getY();
        z_size = VILLAGER_SIZE.getZ();
        break;
      default:
        return false;
    }

    return canSpawn(loc, x_size, y_size, z_size);
  }

  /**
   * If a slime can spawn at specified loc, it returns true.
   *
   * @param loc Location
   * @param isMagmaCube is Magma cube
   * @param size Slime size
   * @return If a slime can spawn at specified loc, it returns true.
   */
  public static boolean canSpawnSlime(Location loc, boolean isMagmaCube, int size) {
    double x_size;
    double y_size;
    double z_size;
    if (!isMagmaCube) {
      Vector multiplied_size = MINIMAL_SLIZE_SIZE.multiply(size);
      x_size = multiplied_size.getX();
      y_size = multiplied_size.getY();
      z_size = multiplied_size.getZ();
    } else {
      Vector multiplied_size = MINIMAL_MAGMA_CUBE_SIZE.multiply(size);
      x_size = multiplied_size.getX();
      y_size = multiplied_size.getY();
      z_size = multiplied_size.getZ();
    }
    return canSpawn(loc, x_size, y_size, z_size);
  }

  /**
   * If a slime can spawn at specified loc, it returns true.
   *
   * @param loc Location
   * @param isMagmaCube is Magma cube
   * @param size Slime size
   * @return If a slime can spawn at specified loc, it returns true.
   */
  public static boolean canSpawnSlime(SimpleLocation loc, boolean isMagmaCube, int size) {
    return canSpawnSlime(loc.castToLocation(), isMagmaCube, size);
  }

  /**
   * If specified entity can spawn at specified loc, it returns true.
   *
   * @param loc Location
   * @param type Entity Type
   * @param flag This is used as isBaby or isWitherSkeleton or isElderGuardian
   * @return If specified entity can spawn at specified loc, it returns true.
   */
  public static boolean canSpawn(SimpleLocation loc, EntityType type, boolean flag) {
    return canSpawn(loc.castToLocation(), type, flag);
  }

  /**
   * If an entity whose size is specified size can spawn at specified loc, it returns true.
   *
   * @param loc Location
   * @param x_size X size
   * @param y_size Y size
   * @param z_size Z size
   * @return If an entity whose size is specified size can spawn at specified loc, it returns true.
   */
  public static boolean canSpawn(Location loc, double x_size, double y_size, double z_size) {
    World world = loc.getWorld();
    Location checkBaseLoc = loc.subtract(x_size / 2, 0, z_size / 2);
    for (int i = 0; i < Math.ceil(x_size); i++) {
      for (int j = 0; j < Math.ceil(y_size); j++) {
        for (int k = 0; k < Math.ceil(z_size); k++) {
          if (world.getBlockAt(checkBaseLoc.add(i, j, k)).getType().isSolid())
            return false;
        }
      }
    }
    return true;
  }

  /**
   * If an entity whose size is specified size can spawn at specified loc, it returns true.
   *
   * @param loc Location
   * @param x_size X size
   * @param y_size Y size
   * @param z_size Z size
   * @return If an entity whose size is specified size can spawn at specified loc, it returns true.
   */
  public static boolean canSpawn(SimpleLocation loc, double x_size, double y_size, double z_size) {
    return canSpawn(loc.castToLocation(), x_size, y_size, z_size);
  }

}
