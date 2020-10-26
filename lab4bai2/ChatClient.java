package lab4bai2;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
/**
 * *
 * @author HuynhTrieuThanhSu_18050621
 *
 */
public class ChatClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket socket = new Socket("localhost", 3333);
		DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
		Scanner scanner = new Scanner(System.in);
		while(true) {
		
			//truyen du lieu len server
			String str = scanner.nextLine();
			dataOutputStream.writeUTF(str);
			
			if(str.equals("q")) {
				break;
			}
			// doc du lieu ve tu server
			String str2 = dataInputStream.readUTF();
			System.out.println("Messenger Server:" + str2);
		}
		
	}

}
