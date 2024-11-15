import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CompraService {

    private List<Compra> compras; // Lista de compras.
    private ClienteService clienteService; // Para validar clientes si es necesario.

    public CompraService(List<Compra> compras, ClienteService clienteService) {
        this.compras = compras;
        this.clienteService = clienteService;
    }

    // Validar la fecha de compra (debe ser la fecha actual)
    public LocalDate obtenerFechaCompra() {
        return LocalDate.now();

    // Ver todas las compras: Da las info del cliente y la compra!
    public List<String> verTodasLasCompras() {
        return compras.stream()
                .map(compra -> String.format("Fecha: %s, Cliente: %s (%s), Importe Total: %.2f",
                        compra.getFechaCompra().toString(),
                        compra.getCliente().getNombre(),
                        compra.getCliente().getCuit(),
                        calcularImporteTotal(compra)))
                .collect(Collectors.toList());
    }

    // Filtrar por cliente (por nombre o CUIT).
    public List<Compra> filtrarPorCliente(String terminoCliente) {
        if (terminoCliente == null || terminoCliente.isEmpty()) {
            return compras; // Devuelve todas las compras si no se especifica cliente
        }

        return compras.stream()
                .filter(compra -> compra.getCliente().getNombre().toLowerCase().contains(terminoCliente.toLowerCase()) ||
                        compra.getCliente().getCuit().contains(terminoCliente))
                .collect(Collectors.toList());
    }

    // Filtrar compras por un rango de fechas!
    public List<Compra> filtrarPorFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        return compras.stream()
                .filter(compra -> !compra.getFechaCompra().isBefore(fechaInicio) &&
                                  !compra.getFechaCompra().isAfter(fechaFin))
                .collect(Collectors.toList());
    }

    // Calcular el importe total de una compra.
    private double calcularImporteTotal(Compra compra) {
        return compra.getLineasCompra().stream()
                .mapToDouble(linea -> linea.getProducto().getPrecio() * linea.getCantidad())
                .sum();
    // Validar las líneas de compra
    public boolean validarLineasDeCompra(List<LineaCompra> lineasCompra) {
        for (LineaCompra linea : lineasCompra) {
            Producto producto = linea.getProducto();
            int cantidad = linea.getCantidad();
            
            // Validar que el producto exista
            if (producto == null || !productoService.validarNombreProducto(producto.getNombre())) {
                return false;
            }

            // Validar que la cantidad sea > 0 y <= al stock del producto
            if (cantidad <= 0 || cantidad > producto.getStock()) {
                return false;
            }
        }
        return true;
    }
}