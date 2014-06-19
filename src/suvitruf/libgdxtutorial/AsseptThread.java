package suvitruf.libgdxtutorial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

import suvitruf.libgdxtutorial.model.MyWorld;
import suvitruf.libgdxtutorial.model.WraperBodies;
import suvitruf.libgdxtutorial.model.WraperPlayer;
import suvitruf.libgdxtutorial.model.filters.modelTest;
import suvitruf.libgdxtutorial.screens.GameScreen;

import com.badlogic.gdx.math.Vector2;
import com.google.gson.Gson;

import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.util.Log;

public class AsseptThread extends Thread {
	MyGame Game;
	private BluetoothServerSocket mmServerSocket;
	private BluetoothSocket socket = null;

	@Override
	public void run() {
		 Gson gson=new Gson();
		
		 while (true){
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String json=gson.toJson(new WraperPlayer(GameScreen.world.getPlayer()));
		 	Log.v("12345",json); 
		
		 	json=gson.toJson(new WraperBodies(((MyWorld)GameScreen.world).getWorld().getBodies()));
		 	Log.v("12345",json);
		 	
		 	
		 } 
		 	
		

		

	
		
			 	 
		/* while (true) {
			 Log.v("12345", "socket create");
            try {
                socket = mmServerSocket.accept();               
            } catch (IOException e) {
            	 Log.v("12345", "socket fail");
                break;
            }
         
            if (socket != null) {
                
                try {
					manageConnectedSocket(socket);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
                try {
					mmServerSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                break;
            }
        

	}*/
	}

	private void manageConnectedSocket(BluetoothSocket socket) throws IOException {
		
		
		
		
		
		
		
		
		
	}

	public AsseptThread(BluetoothServerSocket mmServerSocket) {
		super();
		this.mmServerSocket = mmServerSocket;
	}
	
	
	

}
