import java.util.Arrays;

public class fileFillThread extends clientHelperThread
{
	public fileFillThread(int[] theFileArray)
	{
		super(theFileArray);
	}
	
	public void run()
	{
		//this guy constantly tries to fill the byte array for the
		//receiving file
		
		while(true)
		{
			// constantly trying to fill theFileArray 
			Arrays.fill(theFileArray, 1);
		}
	}
}