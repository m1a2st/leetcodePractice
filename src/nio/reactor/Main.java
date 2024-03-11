package nio.reactor;

public class Main {

    public static void main(String[] args) {
        EchoServerReactor echoServerReactor = new EchoServerReactor();
        echoServerReactor.run();
    }
}
