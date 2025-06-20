import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimuladorMedico {
    public static void main(String[] args) {
        System.out.println("🧪 Iniciando acceso a la Sala de cirugía...");

        RecursoMedico sala = new RecursoMedico("Sala de cirugía");

        Runnable draSundiata = () -> sala.usar("Dra. Sundiata");
        Runnable drElena = () -> sala.usar("Dr. Elena");
        Runnable draSundiata2 = () -> sala.usar("Dra. Sundiata");
        Runnable drElena2 = () -> sala.usar("Dr. Elena");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(draSundiata);
        executor.submit(drElena);
        executor.submit(draSundiata2);
        executor.submit(drElena2);

        executor.shutdown();
    }
}
