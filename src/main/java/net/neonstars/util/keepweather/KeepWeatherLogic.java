package net.neonstars.util.keepweather;

import java.util.HashMap;
import lombok.Getter;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class KeepWeatherLogic extends BukkitRunnable {

  @Getter
  protected HashMap<World, EnumWeatherType> weatherTypeMap = new HashMap<>();

  @Override
  public void run() {
    weatherTypeMap.forEach((world, weather) -> {
      world.setWeatherDuration(Integer.MAX_VALUE);
      switch (weather) {
        case SUNNY:
          world.setStorm(false);
          world.setThundering(false);
          break;
        case RAINY:
          world.setStorm(true);
          break;
        case STORMY:
          world.setStorm(true);
          world.setThundering(true);
          break;
      }
    });
  }

}
