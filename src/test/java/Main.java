public class Main {
    public static void main(String[] args) throws Exception {
        SimpleHttpServer route = new SimpleHttpServer("0.0.0.0",23652);
        route.path("/", SimpleHttpServerController.class);
        route.path("/test", SimpleHttpServerController.class);
    }
}
