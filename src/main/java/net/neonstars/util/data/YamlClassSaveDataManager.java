package net.neonstars.util.data;

import java.io.File;

/**
 * Created by wintermaples on 2017/07/26.
 */
public abstract class YamlClassSaveDataManager<T> extends YamlSaveDataManager implements DeserializableClassRegisterer {

  public YamlClassSaveDataManager(File file) {
    super(file);
  }

  public T getInstance() {
    return (T) getData().get("INSTANCE", null);
  }

  public void setInstance(T instance) {
    getData().set("INSTANCE", instance);
  }

}
