package icrogue.engine.recorder.recordEntry;

import java.awt.Robot;

import icrogue.engine.window.Window;

public class KeyboardReleasedRecordEntry extends RecordEntry{
	private static final long serialVersionUID = 1;
	private int keycode;
	
	public KeyboardReleasedRecordEntry(long time, int keycode) {
		super(time);
		this.keycode = keycode;
	}

	@Override
	public void replay(Robot robot, Window window) {
		robot.keyRelease(keycode);
	}
}
