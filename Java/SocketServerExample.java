import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
* This class implements java Socket server
* @author pankaj
*
*/
public class SocketServerExample {

	//static ServerSocket variable
	private static ServerSocket server;
	//socket server port on which it will listen
	private static int port = 9876;

	public static void main(String args[]) throws IOException, ClassNotFoundException{
		//create the socket server object
		server = new ServerSocket(port);
		Random random = new Random();


		//keep listens indefinitely until receives 'exit' call or program terminates
		while(true){
			System.out.println("Waiting for the client request");
			//creating socket and waiting for client connection
			Socket socket = server.accept();

			//read from socket to ObjectInputStream object
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

			//create ObjectOutputStream object
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

			String response = (String) ois.readObject();
			System.out.println(response);

			if(response.equalsIgnoreCase("yes")){
				System.out.println("A");

				oos.writeObject("Choose an object: ");
				System.out.println("B");

				response = (String) ois.readObject();
				int serverChosenWord = random.nextInt(3) + 1;

				switch (serverChosenWord){
					case 1:
						//Server chose Rock
						if(response.equalsIgnoreCase("Rock"))
							oos.writeObject("It's a draw: You chose " + response + " and the server chose Rock");

						else if(response.equalsIgnoreCase("Paper"))
							oos.writeObject("You won: You chose " + response + " and the server chose Rock");

						else if(response.equalsIgnoreCase("Scissors"))
							oos.writeObject("You lost: You chose " + response + " and the server chose Rock");
						else
							oos.writeObject("Invalid option in game");
					break;

					case 2:
						//Server chose Paper
						if(response.equalsIgnoreCase("Rock"))
							oos.writeObject("You lost: You chose " + response + " and the server chose Paper");

						else if(response.equalsIgnoreCase("Paper"))
							oos.writeObject("It's a draw: You chose " + response + " and the server chose Paper");

						else if(response.equalsIgnoreCase("Scissors"))
							oos.writeObject("You won: You chose " + response + " and the server chose Paper");
						else
							oos.writeObject("Invalid option in game");
					break;

					case 3:
						//Server chose Scissors
						if(response.equalsIgnoreCase("Rock"))
							oos.writeObject("You won: You chose " + response + " and the server chose Scissors");

						else if(response.equalsIgnoreCase("Paper"))
							oos.writeObject("You lost: You chose " + response + " and the server chose Scissors");

						else if(response.equalsIgnoreCase("Scissors"))
							oos.writeObject("It's a draw: You chose " + response + " and the server chose Scissors");
						else
							oos.writeObject("Invalid option in game");
					break;

				}

			}
			else if(response.equalsIgnoreCase("no")){
				continue;
			}
			else if(response.equalsIgnoreCase("exit"))
				break;
			
			else{
				oos.writeObject("Invalid option");
				continue;
			}

			/*//convert ObjectInputStream object to String
		    String chosenWord = (String) ois.readObject();  
		    System.out.println("Do you want to play Rock Paper Scissors? " + chosenWord);


			//write object to Socket
			oos.writeObject("Your chosen letter was: " + chosenWord);
			*/
			//close resources
			ois.close();
			oos.close();
			socket.close();

			//terminate the server if client sends exit request
			if(response.equalsIgnoreCase("exit")) break;
		}	
				
		
		System.out.println("Shutting down Socket server!!");
		//close the ServerSocket object

		server.close();
	}

}