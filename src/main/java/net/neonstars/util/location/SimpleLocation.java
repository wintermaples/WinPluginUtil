/*
 * Copyright 2015 wintermaples.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.neonstars.util.location;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

/**
 * シンプルなロケーションを提供するクラスです。
 *
 * @author wintermaples
 */
public class SimpleLocation implements ConfigurationSerializable {

  @Getter
  @Setter
  protected String world;

  @Getter
  @Setter
  protected double x;

  @Getter
  @Setter
  protected double y;

  @Getter
  @Setter
  protected double z;

  @Getter
  @Setter
  protected double pitch;

  @Getter
  @Setter
  protected double yaw;

  public SimpleLocation(Map map) {
    this.world = (String) map.get("world");
    this.x = (double) map.get("x");
    this.y = (double) map.get("y");
    this.z = (double) map.get("z");
    this.yaw = (double) map.get("yaw");
    this.pitch = (double) map.get("pitch");
  }

  public SimpleLocation() {
    super();
  }

  public SimpleLocation(String world) {
    this.world = world;
  }

  public SimpleLocation(String world, double x, double y, double z) {
    this.world = world;
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public SimpleLocation(String world, double x, double y, double z, float pitch, float yaw) {
    this.world = world;
    this.x = x;
    this.y = y;
    this.z = z;
    this.pitch = pitch;
    this.yaw = yaw;
  }

  public SimpleLocation(Location loc) {
    this(loc.getWorld().getName(), loc.getX(), loc.getY(), loc.getZ(), loc.getPitch(), loc.getYaw());
  }

  public int getBlockX() {
    return (int) x;
  }

  public int getBlockY() {
    return (int) y;
  }

  public int getBlockZ() {
    return (int) z;
  }

  /**
   * 指定されたSimpleLocationとこのSimpleLocationの距離を返します。<br>
   * Worldが違う場合は、IllegalArgumentExceptionをスローします。
   *
   * @param loc SimpleLocation
   * @return 指定されたSimpleLocationとこのSimpleLocationの距離
   */
  public double distance(SimpleLocation loc) {
    if (!loc.getWorld().equals(world))
      throw new IllegalArgumentException();
    return Math.sqrt(
            Math.pow(loc.x - x, 2)
            + Math.pow(loc.y - y, 2)
            + Math.pow(loc.z - z, 2));
  }

  /**
   * 指定されたSimpleLocationとこのSimpleLocationのXZ距離を返します。
   * Worldが違う場合は、IllegalArgumentExceptionをスローします。
   *
   * @param loc SimpleLocation
   * @return 指定されたSimpleLocationとこのSimpleLocationの距離
   */
  public double distanceXZ(SimpleLocation loc) {
    if (!loc.getWorld().equals(world))
      throw new IllegalArgumentException();
    return Math.sqrt(
            Math.pow(loc.x - x, 2)
            + Math.pow(loc.z - z, 2));
  }

  /**
   * LocationをSimpleLocationにキャストします。
   *
   * @param loc キャストするLocation
   * @return LocationからキャストされたSimpleLocation
   */
  @Deprecated
  public static SimpleLocation castToSimpleLocation(Location loc) {
    return new SimpleLocation(loc.getWorld().getName(), loc.getX(), loc.getY(), loc.getZ(), loc.getPitch(), loc.getYaw());
  }

  /**
   * SimpleLocationをLocationにキャストします。
   *
   * @return SimpleLocationからキャストされたLocation
   */
  public Location castToLocation() {
    return new Location(Bukkit.getWorld(world), x, y, z, (float) yaw, (float) pitch);
  }

  @Override
  public String toString() {
    return "World: " + world + ", Loc: " + x + " / " + y + " / " + z + ", Pitch: " + pitch + ", Yaw: " + yaw;
  }

  @Override
  public Map<String, Object> serialize() {
    Map<String, Object> map = new HashMap<>();
    map.put("world", world);
    map.put("x", x);
    map.put("y", y);
    map.put("z", z);
    map.put("yaw", yaw);
    map.put("pitch", pitch);
    return map;
  }

}
