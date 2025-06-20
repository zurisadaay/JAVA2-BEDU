import java.util.concurrent.Callable;

public class SoporteVital implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(1100);
        return "Soporte vital: presión y oxígeno dentro de parámetros normales.";
    }
}
