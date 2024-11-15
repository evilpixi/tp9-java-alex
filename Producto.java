public class Producto {
    private String nombre;
    private int stock;
    private double precio;

    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nuevoNombre){
        this.nombre= nuevoNombre;
    }

    public int getstock(){
        return this.stock;
    }
    
    public void setStock(int nuevoStock){
        this.stock= nuevoStock;
    }

    public double getPrecio(){
        return this.precio;
    }
    
    public void setPrecio(double nuevoPrecio){
        this.precio= nuevoPrecio;
    }
}
