import java.io.IOException;

import javax.swing.JOptionPane;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

public class RestServer {
	

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		// TODO Auto-generated method stub
		HttpServer server = HttpServerFactory.create( "http://localhost:8080/" );
		server.start();
		JOptionPane.showMessageDialog( null, "Ende" );
		server.stop( 0 );
	}

}
