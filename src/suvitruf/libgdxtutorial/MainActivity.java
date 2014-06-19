package suvitruf.libgdxtutorial;



import java.io.IOException;
import java.util.Set;
import java.util.UUID;

import javax.crypto.Mac;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.net.Socket;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AndroidApplication {
	
	private static final int REQUEST_ENABLE_BT = 0;
	private static  String MacAdress = null;
	private static final UUID MY_UUID =UUID.fromString("fa87c0d0-afac-11de-8a39-0800200c9a66"); //UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    public BluetoothAdapter btAdapter;
    private static final String NAME = "BluetoothChatSecure";
    //private BluetoothSocket btSocket = null;
  

    private ConnectedThred MyThred = null;
    private AsseptThread MyServerTread=null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.useAccelerometer = false;
		config.useCompass = false;
		config.useWakelock = true;
		config.useGL20 = true;
		
		/*
		
         
       */ 
        
        
        	
       
    
        
        
        
        
		initialize(new MyGame(), config);
		/*try {
			MyThred = new ConnectedThred(find_device());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		 MyServerTread = new AsseptThread(connect_server());
	     Log.v("12345","create");
	        
	        
	     MyServerTread.start();
	     Log.v("12345","post");      
    }
    
    @Override
    public void onResume() {
        super.onResume();
        
        
      }
    public BluetoothSocket find_device(){
      	
    	BluetoothSocket btSocket = null;
    	
    	Log.v("12345","Bluetooth start");
    	
		BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter(); 
        if (btAdapter != null){
        	Log.v("12345","Bluetooth присутствует");
        	if (btAdapter.isEnabled()){
            	Log.v("12345","Bluetooth включен. Все отлично.");			
            }else
            {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                   	startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            }
        }else
        {
        	Log.v("12345","Bluetooth отсутствует");
        }
        
        Log.v("12345","Bluetooth finish");
        Set<BluetoothDevice> pairedDevices = btAdapter.getBondedDevices();
        
        if (pairedDevices.size() > 0) {
            // Loop through paired devices
            for (BluetoothDevice device : pairedDevices) {
                if (device.getName().toString().equals("Gigabyte RIO R1")){
           	 		Log.v("12345",device.getName() + " : " + device.getAddress());
           	 		MacAdress=device.getAddress();
           	 		
           	 		try {
						btSocket = device.createRfcommSocketToServiceRecord(MY_UUID);
					} catch (IOException e) {
						e.printStackTrace();
					}
           	 		
           	 		btAdapter.cancelDiscovery();
           	 		
           	 		try {
						btSocket.connect();
						return btSocket;
					} catch (IOException e) {
						try {
							btSocket.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
                }
            }
        }
		return btSocket;
        
		
    	
    }
    
    public BluetoothServerSocket connect_server(){
    	
    	BluetoothServerSocket mmServerSocket;

      	
    	
    	Log.v("12345","Bluetooth start");
    	
		BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter(); 
        if (btAdapter != null){
        	Log.v("12345","Bluetooth присутствует");
        	if (btAdapter.isEnabled()){
            	Log.v("12345","Bluetooth включен. Все отлично.");			
            }else
            {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                   	startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            }
        }else
        {
        	Log.v("12345","Bluetooth отсутствует");
        	return  null;
        }
        
        
        BluetoothServerSocket tmp = null;
        try {
            tmp = btAdapter.listenUsingRfcommWithServiceRecord(NAME, MY_UUID);
        } catch (IOException e) { }
        mmServerSocket = tmp;
		return mmServerSocket;

    	
    }
    
    
    
	 
}