package net.neonstars.util.timer;

/**
 * カウントダウンの開始・終了・カウント時に呼び出されるメソッドを作るためのインターフェイスです。
 *
 * @author wintermaples
 */
public interface CountdownListener {

  /**
   * 開始時に呼び出されるメソッド
   */
  void start();

  /**
   * 終了時に呼び出されるメソッド
   */
  void end();

  /**
   * カウント時に呼び出されるメソッド
   *
   * @param timeLeft 残り時間
   */
  void count(int timeLeft);

}
