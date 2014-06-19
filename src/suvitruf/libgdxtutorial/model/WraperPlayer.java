package suvitruf.libgdxtutorial.model;

import com.badlogic.gdx.math.Vector2;

public class WraperPlayer {
	
	Vector2 	velocity;
	float Friction;
	Vector2 position;
	boolean isJump;
	

	public Vector2 getVelocity() {
		return velocity;
	}


	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}


	public float getFriction() {
		return Friction;
	}


	public void setFriction(float friction) {
		Friction = friction;
	}


	public Vector2 getPosition() {
		return position;
	}


	public void setPosition(Vector2 position) {
		this.position = position;
	}


	public WraperPlayer(Player player) {
		velocity=player.getVelocity();		
		Friction=player.getFriction();
		position= player.getPosition();
		isJump=player.isJump();
		
	}
	
	
	

}
