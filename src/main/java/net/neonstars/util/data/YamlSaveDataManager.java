package net.neonstars.util.data;

import lombok.Getter;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * This class allows us to manage save data with YAML file.
 */
public abstract class YamlSaveDataManager implements SaveDataManager {

  protected File file;

  @Getter
  protected YamlConfiguration data;

  public YamlSaveDataManager(File file) {
    this.file = file;
  }

  public YamlSaveDataManager(File file, DeserializableClassRegisterer registerer) {
    this.file = file;
    registerer.registerDeserializableClasses();
  }

  @Override
  public void load() throws IOException {
    if (!file.getParentFile().exists()) {
      if (!file.getParentFile().mkdirs()) {
        throw new IOException("It cannot make a directory! : " + file.getParentFile().getAbsolutePath());
      }
    }

    if (!file.exists()) {
      if (!file.createNewFile())
        throw new IOException("It cannot create new file! : " + file.getAbsolutePath());
    }

    if (!file.isFile()) {
      throw new IOException("Specified file isn't file! : " + file.getAbsolutePath());
    }

    if (!file.canRead() || !file.canWrite()) {
      throw new IOException("Specified file cannot be written or read! : " + file.getAbsolutePath());
    }

    try {
      data = new YamlConfiguration();
      data.load(file);
    } catch (InvalidConfigurationException e) {
      e.printStackTrace();
    }
  }

  public void save() throws IOException {
    if (data == null)
      throw new IllegalStateException("You have yet not load a file!");
    data.save(file);
  }

}
