import com.sun.net.httpserver.HttpExchange;

public interface Controller {
      String init(HttpExchange httpExchange);
}
