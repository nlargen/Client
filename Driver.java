import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Driver
{
	public static void main(String[] args) throws Exception
	{
		//connect to the server
		Socket s = new Socket("localhost",1234);

		//ability to read from server
		Scanner input = new Scanner(s.getInputStream());

		//ability to read from local client
		Scanner terminalInput = new Scanner(System.in);

		//ability to write to the server
		PrintWriter output = new PrintWriter(s.getOutputStream(),true);

		System.out.println(input.nextLine());
		String theAnswer = terminalInput.nextLine();
		output.println(theAnswer);

		if(theAnswer.equals("share"))
		{
			File myFilesDir = new File("./myFiles");
			String[] theFiles = myFilesDir.list();
			int pos = 0;
			for(String fn : theFiles)
			{
				System.out.println(pos + ": " + fn);
				pos++;
			}
			System.out.print("Which file would you like to share?");
			theAnswer = terminalInput.nextLine();
			System.out.println("You chose to share: " + theFiles[Integer.parseInt(theAnswer)]);
			File theFile = new File("./myFiles/" + theFiles[Integer.parseInt(theAnswer)]);
			FileInputStream fis = new FileInputStream(theFile);
			File theClone = new File("./myFiles/clone" + theFiles[Integer.parseInt(theAnswer)]);
			System.out.println("num bytes: " + fis.available());
			byte[] mybytearray = new byte[(int) theFile.length()]; 
			InputStream  in = s.getInputStream(); 
			FileOutputStream fos = new FileOutputStream("clone");
			BufferedOutputStream bos = new BufferedOutputStream(fos); 
			int bytesreadin = in.read(mybytearray, 0, mybytearray.length);
			bos.write(mybytearray, 0, bytesreadin);
			bos.flush(); 
			bos.close();
			//want to read in all of the bytes and display them to the screen
			while(fis.available() > 0)
			{
				fos.write(fis.read());
			}
			System.out.println("Sending File..."); 
			System.out.println("DOnE");
			fos.close();
			fis.close();
			







		}
	}



}
