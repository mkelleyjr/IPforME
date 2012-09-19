/**
 * @(#)IPforME.java
 * Get host name, IP address, and mac address of computer.
 *
 * @author Michael L. Kelley Jr.
 * @version 1.00 2012/3/7

 */

   // Imports

   import javax.swing.*;
   import java.net.InetAddress;
   import java.net.NetworkInterface;
   import java.net.SocketException;
   import java.net.UnknownHostException;

public class IPforME
{
    public static void main(String[] args)
    	{

		 InetAddress IP; // IP variable

			try			// Start of try-catch block
			{

				IP = InetAddress.getLocalHost();
				String HostName = IP.getHostName(); 	// Pull in host name
				String IPAddress = IP.getHostAddress(); // Pull in host IP address


				 // Mac address

				NetworkInterface network = NetworkInterface.getByInetAddress(IP);
				byte[] MacAddress = network.getHardwareAddress();

				// sb is used to hold the value of the mac address

				StringBuilder sb = new StringBuilder();
				  for (int i = 0; i < MacAddress.length; i++)
				  {
				   sb.append(String.format("%02X%s", MacAddress[i], (i < MacAddress.length - 1) ? "-" : ""));
				   sb.toString(); 	// Place into string
				  }


				// JOptionPane to display the outputs

				JOptionPane.showMessageDialog(null, "The host computer is: " + HostName + "\n\n" + HostName + " has the IP address of: " + IPAddress + "\n\n" +
				HostName + " has the mac address of: " + sb + "\n\n\n\n" + "Programmed by: Michael L. Kelley Jr." + "\n\n", "IPforME", JOptionPane.INFORMATION_MESSAGE);

				} 	catch (Exception e)
				{
					e.printStackTrace();
				}

				System.exit(0); // Exit
    }
}
