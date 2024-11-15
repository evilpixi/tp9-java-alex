import java.util.List;
import java.util.stream.Collectors;

public class ProductoService {

    private List<Producto> productos; // Lista de productos.

    public ProductoService(List<Producto> productos) {
        this.productos = productos;
    }

    // Ver todos los productos!
    public List<Producto> verTodosLosProductos() {
        return productos;
    }

    // Filtrar por nombre de producto.
    public List<Producto> filtrarPorNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return productos; // Devuelve todos los productos si no se especifica un nombre
        }
        return productos.stream()
                .filter(p -> p.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Filtrar productos cuyo stock esté por debajo de un stock mínimo.
    public List<Producto> filtrarPorStockMinimo(int stockMinimo) {
        return productos.stream()
                .filter(p -> p.getStock() < stockMinimo)
                .collect(Collectors.toList());
    }

    // Nom. del Producto
    public boolean validarNombreProducto(String nombre) {
        return nombre != null && nombre.length() >= 2;
    }

    // Validación del stock!
    public boolean validarStock(int stock) {
        return stock >= 0;
    }

    // Validación del precio!
    public boolean validarPrecio(double precio) {
        return precio > 0 && ((double) Math.round(precio * 100) / 100) == precio;
    }
}