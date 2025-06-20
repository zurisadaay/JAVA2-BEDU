import java.util.concurrent.Callable;

public class ControlTermico implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(900);
        return "Control térmico: temperatura estable (36°C).";
    }
}
