package net.neonstars.util.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author wintermaples
 */
public class FileUtil {

  public static void copyFileInJarToPluginFolder(JavaPlugin pl, String fileName) {
    ClassLoader cl = pl.getClass().getClassLoader();
    File outputFile = new File(pl.getDataFolder().getAbsolutePath() + "/" + fileName);

    try {
      if (!pl.getDataFolder().exists())
        pl.getDataFolder().mkdirs();
      if (!outputFile.exists())
        outputFile.createNewFile();
    } catch (IOException ex) {
      Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null, ex);
    }

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(cl.getResourceAsStream(fileName), "utf-8"));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "utf-8"));) {

      String readStr;
      while ((readStr = reader.readLine()) != null) {
        writer.write(readStr);
        writer.newLine();
      }
    } catch (IOException ex) {
      Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

}
