package net.neonstars.util.localize;

import lombok.Getter;

/**
 * ローカライズされた文字列を意味するクラスです。<br>
 * このクラスはCmdLangUtilにある変数機能も実装されています。
 *
 * @author wintermaples
 */
public class LocalizedString {

  /**
   * ローカライズされた文字列
   */
  @Getter
  protected final String str;

  public LocalizedString(String str) {
    this.str = str;
  }
  
  public LocalizedString replaceVar(String[] replaceVar, Object[] replaceStr) {
    String str_ = str;
    for (int i = 0; i < replaceVar.length; i++) {
      str_ = str_.replaceAll("<%" + replaceVar[i] + "%>", String.valueOf(replaceStr[i]));
    }
    return new LocalizedString(str_);
  }
  
}
