import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SistemasCriticos {

    public static void main(String[] args) throws InterruptedException {

        // 1. Sensores de tráfico (nivel de congestión 0-100)
        Flux<Integer> trafico = Flux.interval(Duration.ofMillis(500))
                .map(i -> ThreadLocalRandom.current().nextInt(101))
                .onBackpressureBuffer()
                .delayElements(Duration.ofMillis(1000))
                .filter(nivel -> nivel > 70)
                .doOnNext(n -> System.out.println("Evento crítico: Congestión vial del " + n + "%"))
                .subscribeOn(Schedulers.parallel());

        // 2. Contaminación del aire (PM2.5)
        Flux<Double> contaminacion = Flux.interval(Duration.ofMillis(600))
                .map(i -> ThreadLocalRandom.current().nextDouble(0, 100))
                .filter(pm -> pm > 50)
                .doOnNext(pm -> System.out.println("Evento crítico: Contaminación PM2.5 de " + pm + " ug/m3"))
                .subscribeOn(Schedulers.parallel());

        // 3. Accidentes viales (prioridad)
        List<String> prioridades = Arrays.asList("Baja", "Media", "Alta");
        Flux<String> accidentes = Flux.interval(Duration.ofMillis(800))
                .map(i -> prioridades.get(ThreadLocalRandom.current().nextInt(prioridades.size())))
                .filter(prioridad -> prioridad.equals("Alta"))
                .doOnNext(p -> System.out.println("Evento crítico: Accidente con prioridad ALTA"))
                .subscribeOn(Schedulers.parallel());

        // 4. Trenes maglev (retraso en minutos 0-10)
        Flux<Integer> trenes = Flux.interval(Duration.ofMillis(700))
                .map(i -> ThreadLocalRandom.current().nextInt(11))
                .filter(min -> min > 5)
                .doOnNext(min -> System.out.println("Evento crítico: Retraso en tren maglev de " + min + " minutos"))
                .subscribeOn(Schedulers.parallel());

        // 5. Semáforos inteligentes (Verde, Amarillo, Rojo)
        List<String> semaforos = Arrays.asList("Verde", "Amarillo", "Rojo");
        Flux<String> flujoSemaforos = Flux.interval(Duration.ofMillis(400))
                .map(i -> semaforos.get(ThreadLocalRandom.current().nextInt(semaforos.size())))
                .buffer(3, 1)
                .filter(buffer -> buffer.stream().allMatch(color -> color.equals("Rojo")))
                .doOnNext(b -> System.out.println("Evento crítico: Semáforo en rojo 3 veces seguidas: " + b))
                .subscribeOn(Schedulers.parallel());

        // Mantener el programa activo unos segundos para ver los eventos
        Thread.sleep(15000);
    }
}
