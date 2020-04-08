import com.sun.net.httpserver.HttpExchange;

public interface SimpleHttpServerController {
      String init(HttpExchange httpExchange);
}
