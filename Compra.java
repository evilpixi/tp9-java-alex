import java.util.List;
import java.time.LocalDate;

public class Compra {
    private Cliente cliente;
    private List<LineaCompra> lineasCompra;
    private LocalDate fechaCompra;

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente nuevoCliente) {
        this.cliente = nuevoCliente;
    }

    public List<LineaCompra> getLineasCompra() {
        return this.lineasCompra;
    }

    public void setLineasCompra(List<LineaCompra> nuevoLineasCompra) {
        this.lineasCompra = nuevoLineasCompra;
    }

    public LocalDate getFechaCompra() {
        return this.fechaCompra;
    }

    public void setFechaCompra(LocalDate nuevoFechaCompra) {
        this.fechaCompra = nuevoFechaCompra;
    }

    public double calcularTotal() {
        double total = 0;
        for (LineaCompra linea : this.lineasCompra) {
            total += linea.calcularSubtotal();
        }
        return total;
    }


}