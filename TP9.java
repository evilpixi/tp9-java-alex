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
          Cliente nuevoCliente = new Cliente();

          System.out.print("Ingrese el nombre del cliente: ");
          String nombre = scanner.next();
          while (!clienteService.validarNombre(nombre)) {
            System.out.print("Nombre inválido. Ingrese nuevamente: ");
            nombre = scanner.next();
          }
          nuevoCliente.setNombre(nombre);

          System.out.print("Ingrese el CUIT del cliente: ");
          String cuit = scanner.next();
          while (!clienteService.validarCuit(cuit)) {
            System.out.print("CUIT inválido. Ingrese nuevamente: ");
            cuit = scanner.next();
          }
          nuevoCliente.setCuit(Integer.parseInt(cuit.replace("-", "")));

          System.out.print("Ingrese el email del cliente: ");
          String email = scanner.next();
          while (!clienteService.validarEmail(email)) {
            System.out.print("Email inválido. Ingrese nuevamente: ");
            email = scanner.next();
          }
          nuevoCliente.setEmail(email);

          System.out.print("Ingrese el celular del cliente: ");
          String celular = scanner.next();
          while (!clienteService.validarCelular(celular)) {
            System.out.print("Celular inválido. Ingrese nuevamente: ");
            celular = scanner.next();
          }
          nuevoCliente.setCelular(Integer.parseInt(celular));

          System.out.println("Cliente registrado con éxito.");
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
