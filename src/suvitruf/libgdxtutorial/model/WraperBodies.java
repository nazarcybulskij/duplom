package suvitruf.libgdxtutorial.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public class WraperBodies {

	ArrayList<Vector2> position_vector=new ArrayList<Vector2>();

	public ArrayList<Vector2> getPosition_vector() {
		return position_vector;
	}

	public void setPosition_vector(ArrayList<Vector2> position_vector) {
		this.position_vector = position_vector;
	}

	public WraperBodies(Iterator<Body> iter) {
		for (Iterator<Body> iter1 = iter; iter1.hasNext();) {
			 Body body = iter1.next();

			 if( body != null &&  body.getFixtureList().get(0).getUserData() != null &&  body.getFixtureList().get(0).getUserData().equals("runner")){
				 if (body!=null)
					 position_vector.add(body.getPosition());
			 }
		
		
		
	}
		}	}



