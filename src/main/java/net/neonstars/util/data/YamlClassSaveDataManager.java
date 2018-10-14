package net.neonstars.util.data;

import java.io.File;
import java.util.Optional;

/**
 * Created by wintermaples on 2017/07/26.
 */
public abstract class YamlClassSaveDataManager<T> extends YamlSaveDataManager implements DeserializableClassRegisterer {

  protected boolean isCalledRegisterDeserializableClass;

  public YamlClassSaveDataManager(File file) {
    super(file);
    if (!isCalledRegisterDeserializableClass) {
      registerDeserializableClasses();
      isCalledRegisterDeserializableClass = true;
    }
  }

  public Optional<T> getInstance() {
    return Optional.ofNullable((T) getData().get("INSTANCE", null));
  }

  public void setInstance(T instance) {
    getData().set("INSTANCE", instance);
  }

}
