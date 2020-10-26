package lab4bai2;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/**
 * *
 * @author HuynhTrieuThanhSu_18050621
 *
 */
public class ChatServer {
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = new ServerSocket(3333);
		Socket socket = serverSocket.accept();
		DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			//doc du lieu tu client truyen len
			String str = dataInputStream.readUTF();
			if(str.equals("q")) {
				break;
			}
			System.out.println("Messenger client: "+str);
			//truyen du lieu server ve
			String str2= scanner.nextLine();
			dataOutputStream.writeUTF(str2);
			dataOutputStream.flush();
		}
		dataOutputStream.close();
		dataInputStream.close();
		socket.close();
	}

	
}
