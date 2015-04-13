import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class fileFillThread extends clientHelperThread
{
	private Scanner serverInput;
	private Socket theSocket; 
	
	public fileFillThread(int[] theFileArray, Socket theSocket)
	{
		super(theFileArray, theSocket);
		this.theSocket = theSocket; 
	}

	public void run()
	{
		//this guy constantly tries to fill the byte array for the
		//receiving file
		System.out.println("Downloading file...");
		while(true)
		{
			// constantly trying to fill theFileArray
			for(int i =0; i <= theFileArray.length; i++ )
			{
				if(theFileArray[i] == -1)
				{
					Arrays.fill(theFileArray, Integer.parseInt(serverInput.nextLine()));
				}

			}
		}			
	}
}