package net.neonstars.util.timer;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Countdown {

  @Getter
  protected int leftTime = -1;

  protected ArrayList<CountdownListener> listeners = new ArrayList<>();

  protected int taskId;

  @Getter
  @Setter
  protected boolean stopped;

  public void addListener(CountdownListener listener) {
    listeners.add(listener);
  }

  /**
   * カウントダウンをスタートします。
   *
   * @param time
   * @param plugin
   */
  public void start(int time, JavaPlugin plugin) {
    this.leftTime = time;
    this.taskId = Bukkit.getScheduler().runTaskTimer(plugin, new CountdownProcess(), 0, 20).getTaskId();
    listeners.forEach(CountdownListener::start);
  }

  class CountdownProcess implements Runnable {

    @Override
    public void run() {
      if (stopped)
        return;
      for (CountdownListener listener : listeners) {
        listener.count(leftTime);
      }
      if (leftTime == 0) {
        leftTime = -1;
        listeners.forEach(CountdownListener::end);
        endTask();
      }
      leftTime--;
    }
  }

  /**
   * タスクを終了します。
   */
  public void endTask() {
    Bukkit.getScheduler().cancelTask(taskId);
  }

  /**
   * カウントダウンが開始されているか判定します。
   *
   * @return カウントダウンが開始されている場合はtrue
   */
  public boolean started() {
    return leftTime != -1;
  }

  /**
   * カウントダウンが終了しているか判定します。
   *
   * @return カウントダウンが終了している場合はtrue
   */
  public boolean ended() {
    return leftTime <= 0;
  }

}
