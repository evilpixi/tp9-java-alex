public class LineaCompra {
    private Producto producto;
    private int cantidad;

    public Producto getProducto(){
        return this.producto;
    }
    
    public void setProducto(Producto nuevoProducto){
        this.producto= nuevoProducto;
    }

    public int getCantidad(){
        return this.cantidad;
    }
    
    public void setCantidad(int nuevoCantidad){
        this.cantidad= nuevoCantidad;
    }

    public double calcularSubtotal() {
        return this.cantidad * this.producto.getPrecio();
    }
}
