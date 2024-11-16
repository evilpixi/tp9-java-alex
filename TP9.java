import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TP9 {
  public static void main(String[] args) {
    List<Compra> compras = new ArrayList<Compra>();
    List<Producto> productos = new ArrayList<Producto>();

    ClienteService clienteService = new ClienteService();
    ProductoService productoService = new ProductoService(productos);
    CompraService compraService = new CompraService(compras, clienteService, productoService);

    System.out.println("=== TP9 ===");

    Scanner scanner = new Scanner(System.in);
    int option = 0;

    while (option != 4) {
      System.out.println("Menu:");
      System.out.println("1. Registrar Cliente");
      System.out.println("2. Option 2");
      System.out.println("3. Option 3");
      System.out.println("4. Exit");
      System.out.print("Choose an option: ");

      option = scanner.nextInt();

      switch (option) {
        case 1:
          System.out.print("Ingrese el nombre del cliente: ");
          String nombreCliente = scanner.next();

          // pedir todos los datos
          Cliente cliente = new Cliente();
          cliente.setNombre(nombreCliente);

          break;

        case 2:
          System.out.println("You chose option 2");
          break;
        case 3:
          System.out.println("You chose option 3");
          break;
        case 4:
          System.out.println("Exiting...");
          break;
        default:
          System.out.println("Invalid option. Please try again.");
          break;
      }
    }

    scanner.close();
  }
}
