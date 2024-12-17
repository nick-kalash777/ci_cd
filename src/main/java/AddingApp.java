import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public class AddingApp {
    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/", new HttpHandler() {
                @Override
                public void handle(HttpExchange exchange) throws IOException {
                    // Чтение данных из запроса
                    InputStream requestBody = exchange.getRequestBody();
                    String query = new String(requestBody.readAllBytes(), StandardCharsets.UTF_8);

                    // Разбор чисел из строки запроса
                    String[] parameters = query.split("&");
                    int a = 0;
                    int b = 0;
                    for (String parameter : parameters) {
                        String[] keyValue = parameter.split("=");
                        if (keyValue.length == 2) {
                            if (keyValue[0].equals("a")) {
                                a = Integer.parseInt(keyValue[1]);
                            } else if (keyValue[0].equals("b")) {
                                b = Integer.parseInt(keyValue[1]);
                            }
                        }
                    }

                    // Выполнение сложения
                    int result = add(a, b);

                    // Формирование ответа
                    String response = "Result: " + result;
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