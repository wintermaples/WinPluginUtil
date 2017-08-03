package net.neonstars.util.localize;

import lombok.Getter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;

/**
 * ローカライズを簡単に実装するためのクラスです。<br>
 * このクラスで一つの言語のローカライズされた文字列を保持します。<br>
 * 一度指定したロケールとフォルダーは変更できません。
 *
 * @author wintermaples
 */
public class Localizer {

  /**
   * 使用するファイルに対応したロケール
   */
  @Getter
  protected final Locale locale;

  /**
   * ローカライズされたファイルが保存されているフォルダ
   */
  @Getter
  protected final File folder;

  /**
   * ローカライズされた文字列が格納されているマップ
   */
  protected HashMap<String, LocalizedString> localizedStringMap = new HashMap<>();

  /**
   * Version.
   */
  @Getter
  protected int ver = -1;

  public Localizer(File folder, Locale locale) {
    this.folder = folder;
    this.locale = locale;
  }

  /**
   * ロケールに対応した言語ファイルを読み込みます。<br>
   * 読み込むファイルは、「[コンストラクタに指定されたフォルダ]/[コンストラクタに指定されたロケール].lang」が読み込まれます。
   *
   * @return 読み込みが正常に完了した場合はtrue
   * @throws java.io.IOException 何らかの入出力障害があった場合にスローされます
   */
  public boolean loadLangFile() throws IOException {
    try (
            final InputStreamReader reader = new InputStreamReader(new FileInputStream(folder + "/" + locale.getLanguage() + "_" + locale.getCountry() + ".lang"), "utf-8")
    ) {
      final Properties prop = new Properties();
      prop.load(reader);

      for (Object key : prop.keySet()) {
        Object value = prop.get(key);
        LocalizedString lstr = new LocalizedString((String) value);
        localizedStringMap.put((String) key, lstr);
      }

      //Get ver.
      ver = Integer.parseInt(prop.getProperty("__version__"));
    }
    return true;
  }

  /**
   * 指定したキーからローカライズされた文字列を返します。
   *
   * @param key キー
   * @return 指定したキーからのローカライズされた文字列
   */
  public String get(String key) {
    LocalizedString s = localizedStringMap.get(key);
    return s != null ? s.getStr() : key + " is NULL";
  }

  /**
   * 指定したキーからローカライズされた文字列を返します。<br>
   * このメソッドはreplaceVar[i]に指定された文字列をreplaceStr[i]に置き換えます。
   *
   * @param key キー
   * @param replaceVar 置き換えられる文字列
   * @param replaceStr 置き換える文字列
   * @return 指定したキーからのローカライズされた文字列
   */
  public String get(String key, String[] replaceVar, Object[] replaceStr) {
    LocalizedString s = localizedStringMap.get(key);
    if (s == null)
      return key + " is NULL";
    return s.replaceVar(replaceVar, replaceStr).getStr();
  }

}
