public class Main {
    public static void main(String[] args) {
        MovilidadApp.combinarOperaciones()
                .thenAccept(System.out::println);

        // Evitar que el programa termine antes de que se completen las tareas
        try {
            Thread.sleep(4000); // Espera un poco más del máximo de latencia (3s)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
