package net.neonstars.util.location;

import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 範囲を表すクラスです。
 *
 * @author wintermaples
 */
public class Area implements ConfigurationSerializable {

  /**
   * Point 1
   */
  public SimpleLocation p1;

  /**
   * Point 2
   */
  public SimpleLocation p2;

  public Area(SimpleLocation p1, SimpleLocation p2) {
    this.p1 = p1;
    this.p2 = p2;
  }

  public Area(Location p1, Location p2) {
    this.p1 = new SimpleLocation(p1);
    this.p2 = new SimpleLocation(p2);
  }

  /**
   * 範囲内にあるかを判定します。
   *
   * @param location 判定される座標
   * @return 引数locationが範囲内にある場合はtrue
   */
  public boolean isInArea(SimpleLocation location) {
    if (!location.getWorld().equals(p1.getWorld()) || !location.getWorld().equals(p2.getWorld()))
      return false;

    if (this.p1.getX() <= this.p2.getX()) {
      if (location.getX() < this.p1.getX() || this.p2.getX() + 1 <= location.getX())
        return false;
    } else {
      if (location.getX() < this.p2.getX() || this.p1.getX() + 1 <= location.getX())
        return false;
    }
    if (this.p1.getY() <= this.p2.getY()) {
      if (location.getY() < this.p1.getY() || this.p2.getY() + 1 <= location.getY())
        return false;
    } else {
      if (location.getY() < this.p2.getY() || this.p1.getY() + 1 <= location.getY())
        return false;
    }
    if (this.p1.getZ() <= this.p2.getZ()) {
      if (location.getZ() < this.p1.getZ() || this.p2.getZ() + 1 <= location.getZ())
        return false;
    } else {
      if (location.getZ() < this.p2.getZ() || this.p1.getZ() + 1 <= location.getZ())
        return false;
    }

    return true;
  }

  /**
   * 範囲拡大します。<br>
   * このメソッドはこのAreaインスタンスを変更しません。
   *
   * @param x 範囲拡大量X
   * @param y 範囲拡大量Y
   * @param z 範囲拡大量Z
   * @return 拡張したエリア
   */
  public Area expand(double x, double y, double z) {
    SimpleLocation[] locations = new SimpleLocation[2];
    locations[0] = new SimpleLocation(p1.getWorld(), p1.getX(), p1.getY(), p1.getZ());
    locations[1] = new SimpleLocation(p2.getWorld(), p2.getX(), p2.getY(), p2.getZ());
    if (locations[0].getX() < locations[1].getX()) {
      locations[0].setX(locations[0].getX() - x);
      locations[1].setX(locations[1].getX() + x);
    } else {
      locations[0].setX(locations[0].getX() + x);
      locations[1].setX(locations[1].getX() - x);
    }
    if (locations[0].getY() < locations[1].getY()) {
      locations[0].setY(locations[0].getY() - y);
      locations[1].setY(locations[1].getY() + y);
    } else {
      locations[0].setY(locations[0].getY() + y);
      locations[1].setY(locations[1].getY() - y);
    }
    if (locations[0].getZ() < locations[1].getZ()) {
      locations[0].setZ(locations[0].getZ() - z);
      locations[1].setZ(locations[1].getZ() + z);
    } else {
      locations[0].setZ(locations[0].getZ() + z);
      locations[1].setZ(locations[1].getZ() - z);
    }
    return new Area(locations[0], locations[1]);
  }

  @SuppressWarnings("rawtypes")
  public Area(Map map) {
    this.p1 = (SimpleLocation) map.get("P1");
    this.p2 = (SimpleLocation) map.get("P2");
  }

  @Override
  public Map<String, Object> serialize() {
    Map<String, Object> map = new HashMap<>();
    map.put("P1", p1);
    map.put("P2", p2);
    return map;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 23 * hash + Objects.hashCode(this.p1);
    hash = 23 * hash + Objects.hashCode(this.p2);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final Area other = (Area) obj;
    if (!Objects.equals(this.p1, other.p1))
      return false;
    if (!Objects.equals(this.p2, other.p2))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Area{" + "p1=" + p1 + ", p2=" + p2 + '}';
  }

}
