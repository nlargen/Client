import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket; 
 

public class byteRequestThread extends clientHelperThread
{
	private Socket theSocket; 
	
	
	public byteRequestThread(int[] theFileArray, Socket theSocket)
	{
		super(theFileArray, theSocket);
		this.theSocket = theSocket; 
		}
	
	public void run()
	{
		//this guy constantly listens for a request from the server
		//for a certain byte and responds with that byte
		while(true)
		{
			
			//*****Write Code HERE****
			
			//moves through existing array looking to see if we have the byte
			for(int i = 0; i <= theFileArray.length; i++) 
			{
				
			if(theFileArray[i] == 1);
			{
				//sends specific byte at index i out to the server 
				try {
					//I found this by mistyping something it sends just one byte over the socket as an integer
					// i think this does what i want it to for responding with the byte that would be at i
					this.theSocket.sendUrgentData(i);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			}
			
		}
	}
}