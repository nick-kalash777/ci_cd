import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public class AddingApp {
    public static void main(String[] args) {
        // Устанавливаем порт для прослушивания
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/", new HttpHandler() {
                @Override
                public void handle(HttpExchange exchange) throws IOException {
                    String response = String.valueOf(add(2, 4));
                    exchange.sendResponseHeaders(200, response.getBytes().length);
                    OutputStream os = exchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                }
            });
            server.start();
            System.out.println("Server started at port 8080...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int add(int a, int b) {
        return a + b;
    }
}