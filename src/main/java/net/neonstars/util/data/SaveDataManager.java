package net.neonstars.util.data;

import java.io.IOException;

/**
 * This interface has load and save method to manage save data.
 * 
 * @author wintermaples
 */
public interface SaveDataManager {
  
  void load() throws IOException;
  
  void save() throws IOException;

}
