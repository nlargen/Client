import java.io.FileOutputStream;

public class byteRequestThread extends clientHelperThread
{
	public byteRequestThread(int[] theFileArray)
	{
		super(theFileArray);
	}
	
	public void run()
	{
		//this guy constantly listens for a request from the server
		//for a certain byte and responds with that byte
		while(true)
		{
			
			//*****Write Code HERE****
			// not sure how to link it with the current byte we need
			int i = 0; 
			if(theFileArray[] != null)
			{
				//sends specific byte at index i out to the server 
				FileOutputStream fos = new FileOutputStream("" + theFileArray[i]); 
				fos.flush();
			}
			
		}
	}
}