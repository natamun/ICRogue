package icrogue.engine.recorder.recordEntry;

import java.awt.Robot;

import icrogue.engine.window.Window;

public abstract class RecordEntry implements java.io.Serializable{
	private static final long serialVersionUID = 1;
	private long time;
	
	public RecordEntry(long time) {
		this.time = time;
	}
	
	public long getTime() {
		return time;
	}
	
	public abstract void replay(Robot robot, Window window);
}
