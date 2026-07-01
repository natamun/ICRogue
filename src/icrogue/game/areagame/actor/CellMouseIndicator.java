package icrogue.game.areagame.actor;

import java.util.Collections;
import java.util.List;

import icrogue.game.areagame.Area;
import icrogue.game.areagame.handler.AreaInteractionVisitor;
import icrogue.math.DiscreteCoordinates;
import icrogue.window.Canvas;

public class CellMouseIndicator extends AreaEntity {
    private final Sprite overSprite;

	public CellMouseIndicator(Area area) {
		super(area, Orientation.UP, new DiscreteCoordinates(0, 0));
		overSprite = new Sprite("cellOver", 1, 1, this);
		overSprite.setDepth(1);
	}

	@Override
	public List<DiscreteCoordinates> getCurrentCells() {
		return Collections.singletonList(getCurrentMainCellCoordinates());
	}

	@Override
	public boolean takeCellSpace() {
		return false;
	}

	@Override
	public boolean isCellInteractable() {
		return false;
	}

	@Override
	public boolean isViewInteractable() {
		return false;
	}

	@Override
	public void acceptInteraction(AreaInteractionVisitor v, boolean isCellInteraction) {}
	
	@Override
	public void update(float deltaTime) {
		if(getOwnerArea().getRelativeMouseCoordinates() != getCurrentMainCellCoordinates()) {
			List<DiscreteCoordinates> enteringCells = Collections.singletonList(getOwnerArea().getRelativeMouseCoordinates());
			List<DiscreteCoordinates> leavingCells = getCurrentCells();
			if(getOwnerArea().enterAreaCells(this, enteringCells) && getOwnerArea().leaveAreaCells(this, leavingCells))
				setCurrentPosition(getOwnerArea().getRelativeMouseCoordinates().toVector());
		}
		
		super.update(deltaTime);
	}

	@Override
	public void draw(Canvas canvas) {
		overSprite.draw(canvas);
	}
}
