import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {

        AeropuertoControl control = new AeropuertoControl();

        System.out.println("Verificando condiciones para aterrizaje...");

        CompletableFuture<Boolean> pista = control.verificarPista();
        CompletableFuture<Boolean> clima = control.verificarClima();
        CompletableFuture<Boolean> trafico = control.verificarTraficoAereo();
        CompletableFuture<Boolean> personal = control.verificarPersonalTierra();

        CompletableFuture<Void> todas = CompletableFuture.allOf(pista, clima, trafico, personal);

        todas.thenRun(() -> {
            try {
                boolean todasAprobadas = pista.get() && clima.get() && trafico.get() && personal.get();
                if (todasAprobadas) {
                    System.out.println("Aterrizaje autorizado: todas las condiciones óptimas.");
                } else {
                    System.out.println("Aterrizaje denegado: condiciones no óptimas.");
                }
            } catch (Exception e) {
                System.out.println("Error al verificar condiciones: " + e.getMessage());
            }
        }).exceptionally(ex -> {
            System.out.println("Error en el proceso: " + ex.getMessage());
            return null;
        }).join(); // Espera a que termine
    }
}
