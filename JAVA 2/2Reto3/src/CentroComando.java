import java.util.concurrent.*;

public class CentroComando {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Future<String> nav = executor.submit(new Navegacion());
        Future<String> com = executor.submit(new Comunicaciones());
        Future<String> vital = executor.submit(new SoporteVital());
        Future<String> term = executor.submit(new ControlTermico());

        System.out.println("Simulación de misión espacial iniciada...");
        System.out.println(com.get());
        System.out.println(vital.get());
        System.out.println(term.get());
        System.out.println(nav.get());
        System.out.println("Todos los sistemas reportan estado operativo.");

        executor.shutdown();
    }
}
