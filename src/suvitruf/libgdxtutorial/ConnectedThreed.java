package suvitruf.libgdxtutorial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

import com.google.gson.Gson;

import suvitruf.libgdxtutorial.model.MyWorld;
import suvitruf.libgdxtutorial.model.WraperBodies;
import suvitruf.libgdxtutorial.model.WraperPlayer;
import suvitruf.libgdxtutorial.screens.GameScreen;
import android.bluetooth.BluetoothSocket;
import android.util.Log;

class ConnectedThred extends Thread{
    private  BluetoothSocket copyBtSocket;
    private  OutputStream OutStrem;
    private  InputStream inStrem;
    
    private BufferedReader  input;
    private BufferedWriter output;
    
    public ConnectedThred(BluetoothSocket socket) throws IOException{
        copyBtSocket = socket;
        OutputStream tmpOut = null;
        try{
        	
            tmpOut = socket.getOutputStream();
        } catch (IOException e){}
        
        inStrem=socket.getInputStream();
        
        
        OutStrem = tmpOut;
    }
    
    
    
    
    @Override
	public void run() {
    	
    	input=new BufferedReader(new InputStreamReader(inStrem));
    	output=new BufferedWriter(new OutputStreamWriter(OutStrem));
    	Gson gson=new Gson();
    	
    	while (true){
    		
    		 try {
 				Thread.sleep(1000);
 			} catch (InterruptedException e) {
 				e.printStackTrace();
 			}
 			String json=gson.toJson(new WraperPlayer(GameScreen.world.getPlayer()));
 		 	Log.v("12345",json);
 		 	try {
				output.write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		 	json=gson.toJson(new WraperBodies(((MyWorld)GameScreen.world).getWorld().getBodies()));
 		 	Log.v("12345",json);
 		 	try {
				output.write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		 	try {
				output.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    	
    	}
		
	}




	public void sendData(String message) {
           byte[] msgBuffer = message.getBytes();
           Log.v("12345", "***Отправляем данные: " + message + "***"  );
         
           try {
           	OutStrem.write(msgBuffer);
           } catch (IOException e) {}
   }
    
    public void cancel(){
        try {
            copyBtSocket.close();
        }catch(IOException e){}			 
    }
    
    public Object status_OutStrem(){
        if (OutStrem == null){return null;		
        }else{return OutStrem;}
    }
}  