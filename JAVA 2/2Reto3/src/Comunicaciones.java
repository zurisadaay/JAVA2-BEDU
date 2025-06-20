import java.util.concurrent.Callable;

public class Comunicaciones implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(1200);
        return "Comunicaciones: enlace con estación terrestre establecido.";
    }
}
