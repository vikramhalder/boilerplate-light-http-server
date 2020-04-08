public class Main {
    public static void main(String[] args) throws Exception {
        SimpleHttpServer route = new SimpleHttpServer(23652);
        route.path("/", ControllerClass.class);
        route.path("/test", ControllerClass.class);
    }
}
