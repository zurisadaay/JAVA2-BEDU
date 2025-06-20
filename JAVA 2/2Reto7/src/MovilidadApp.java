import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MovilidadApp {

    public static CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                int delay = ThreadLocalRandom.current().nextInt(2000, 3000); // 2-3 segundos
                TimeUnit.MILLISECONDS.sleep(delay);
                return "Ruta: Sur -> Norte";
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al calcular la ruta");
            }
        });
    }

    public static CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                int delay = ThreadLocalRandom.current().nextInt(1000, 2000); // 1-2 segundos
                TimeUnit.MILLISECONDS.sleep(delay);
                return 450.87;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al estimar la tarifa");
            }
        });
    }

    public static CompletableFuture<String> combinarOperaciones() {
        return calcularRuta().thenCombine(estimarTarifa(), (ruta, tarifa) ->
                "🚗 " + ruta + " | Tarifa estimada: $" + tarifa
        ).exceptionally(ex ->
                "❌ Ocurrió un error durante la operación: " + ex.getMessage()
        );
    }
}
