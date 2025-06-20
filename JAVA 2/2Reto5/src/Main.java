import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        List<Pedido> pedidos = Arrays.asList(
                new Pedido("Zuri", "domicilio", "58081861"),
                new Pedido("Sundiata", "local", "55667788"),
                new Pedido("ELena", "local", "5514572768"),
                new Pedido("Alika", "domicilio", null)
        );

        List<String> mensajes = pedidos.stream()
                .filter(p -> p.getTipoEntrega().equalsIgnoreCase("domicilio"))
                .map(Pedido::getTelefono)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(tel -> "Confirmación enviada al número: " + tel)
                .collect(Collectors.toList());

        mensajes.forEach(System.out::println);
    }
}
