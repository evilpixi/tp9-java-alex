public class Cliente {
    private String nombre;
    private int cuit;
    private String email;
    private int celular;

    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nuevoNombre){
        this.nombre= nuevoNombre;
    }

    public int getCuit(){
        return this.cuit;
    }
    
    public void setCuit(int nuevoCuit){
        this.cuit= nuevoCuit;
    }

    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String nuevoEmail){
        this.email= nuevoEmail;
    }

    public int getCelular(){
        return this.celular;
    }
    
    public void setCelular(int nuevoCelular){
        this.celular= nuevoCelular;
    }
}
