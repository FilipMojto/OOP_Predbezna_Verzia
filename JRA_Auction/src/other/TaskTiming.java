package other;

import java.util.Timer;
import java.util.TimerTask;

import custom_interfaces.Delayable;

public class TaskTiming {
	private Delayable taskToDo;
	
	private Timer timer = new Timer();
	private TimerTask timerTask = new TimerTask() {
	
		@Override
		public void run() {
			taskToDo.performTask();
		}
	};
	
	public void startDelay(int delay) {
		this.timer.schedule(timerTask, delay);
	}
	
	public TaskTiming(Delayable taskToDo) {
		this.taskToDo = taskToDo;
	}
}
