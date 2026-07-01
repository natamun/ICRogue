package icrogue.engine.game.areagame.actor;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import icrogue.engine.game.actor.Entity;
import icrogue.engine.math.DiscreteCoordinates;
import icrogue.engine.math.Polyline;
import icrogue.engine.math.Vector;
import icrogue.engine.window.Canvas;


/**
 * Path Overlay entity
 * Draw a path on the DiscreteCoordinate Lines:
 */
public class Path extends Entity {

    private final Polyline pathLine;

    /**
     * Default Path Constructor
     * @param start (Vector): the origin of the path
     * @param path (Queue<Orientation>): the successive orientation of the path 
     */
    public Path(Vector start, Queue<Orientation> path){
        super(DiscreteCoordinates.ORIGIN.toVector());

        final List<Vector> points = new ArrayList<>();

        Vector prevPoint = start.add(new Vector(0.5f, 0.5f));
        points.add(prevPoint);
        
        while(!path.isEmpty()) {
        	Vector newPoint = prevPoint.add(path.poll().toVector());
        	points.add(newPoint);
        	prevPoint = newPoint;
        }
        
        // Convert the point into a opened poly line
        if(points.size() >= 2)
        	pathLine = new Polyline(points);
        else
        	pathLine = null;
    }

    /// Path implements Graphics

    @Override
    public void draw(Canvas canvas) {
    	if(pathLine != null)
    		canvas.drawShape(pathLine, getTransform(), null, java.awt.Color.RED, 0.2f, 1f, 10000);
    }
}
