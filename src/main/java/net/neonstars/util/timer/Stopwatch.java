package net.neonstars.util.timer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 簡易的なタイマー機能を提供するクラスです。<br>
 * 精度はtick単位(1/20)です。
 *
 * @author wintermaples
 */
public class Stopwatch {

  /**
   * 現在のタイム(Tick)
   */
  protected int time = -1;

  /**
   * タイマーのスレッド
   */
  private CountThread countThread;

  public Stopwatch() {
  }

  /**
   * タイマーをスタートします。
   *
   * @return
   */
  public boolean start() {
    if (countThread == null) {
      CountThread runnable = new CountThread();
      Thread thread = new Thread(runnable);
      thread.start();
      countThread = runnable;
      return true;
    }
    return false;
  }

  /**
   * タイマーをストップします。
   */
  public void stop() {
    if (countThread != null) {
      countThread.stopped = true;
      countThread = null;
    }
  }

  /**
   * タイマーをリセットします。
   */
  public void reset() {
    time = -1;
  }

  /**
   * フォーマット済みのタイムを返します。
   *
   * @param format フォーマット
   * @return フォーマット済みのタイム
   */
  public String formattedTime(String format) {
    int second = time / 20 % 60;
    int min = time / (20 * 60);
    return String.format(format, min, second);
  }

  /**
   * 現在のタイムを返します。
   *
   * @return 現在のタイム
   */
  public int getTime() {
    return time;
  }

  /**
   * タイマーが稼働しているかどうかを返します。
   *
   * @return タイマーが稼動していればtrue
   */
  public boolean running() {
    return time != -1;
  }

  class CountThread implements Runnable {

    boolean stopped;

    @Override
    public void run() {
      while (!stopped) {
        time++;
        try {
          Thread.sleep(50);
        } catch (InterruptedException ex) {
          Logger.getLogger(Stopwatch.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
  }

}
