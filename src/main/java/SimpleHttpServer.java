
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleHttpServer {
    private HttpServer server;

    public SimpleHttpServer(int port) throws IOException {
        this.server = HttpServer.create(new InetSocketAddress(port), 0);
        server.setExecutor(null);
        server.start();
    }

    public void path(String route, Class clazz) {
        server.createContext(route, new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                try {
                    Controller controller = (Controller) clazz.getConstructor().newInstance();
                    String text = controller.init(httpExchange);
                    httpExchange.sendResponseHeaders(200, text.length());
                    OutputStream os = httpExchange.getResponseBody();
                    os.write(text.getBytes());
                    os.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}