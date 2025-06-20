import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class AeropuertoControl {

    private static final Random random = new Random();

    public CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia();
            boolean resultado = random.nextDouble() < 0.8; // 80% de probabilidad de éxito
            System.out.println("Pista disponible: " + resultado);
            return resultado;
        });
    }

    public CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia();
            boolean resultado = random.nextDouble() < 0.85; // 85%
            System.out.println("Clima favorable: " + resultado);
            return resultado;
        });
    }

    public CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia();
            boolean resultado = random.nextDouble() < 0.9; // 90%
            System.out.println("Tráfico aéreo despejado: " + resultado);
            return resultado;
        });
    }

    public CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia();
            boolean resultado = random.nextDouble() < 0.95; // 95%
            System.out.println("Personal disponible: " + resultado);
            return resultado;
        });
    }

    private void simularLatencia() {
        try {
            TimeUnit.SECONDS.sleep(2 + random.nextInt(2)); // 2 o 3 segundos
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
