import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car {
    String brand;
    String model;
    int year;
    double price;

    public Car(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }
}

class Customer {
    String name;
    String address;
    String phone;
    String email;

    public Customer(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}

class Salesperson {
    String name;
    String position;
    double commission;

    public Salesperson(String name, String position, double commission) {
        this.name = name;
        this.position = position;
        this.commission = commission;
    }
}

public class SalesManagementSystem {
    private List<Car> cars = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Salesperson> salespeople = new ArrayList<>();
    private static final String CLEAR_CONSOLE = "\033[H\033[2J"; // Código de escape ANSI para limpar o console

    public static void main(String[] args) {
        SalesManagementSystem system = new SalesManagementSystem();
        Scanner scanner = new Scanner(System.in);

        // Exemplo: Adicionar um carro
        system.cars.add(new Car("Toyota", "Corolla", 2022, 125000));
        system.cars.add(new Car("Chevrolet", "Onix", 2022, 95000));
        // Exemplo: Adicionar um cliente
        system.customers.add(new Customer("Felipe", "Rua ABC", "85987654321", "felipe@email.com"));
        system.customers.add(new Customer("Jefferson", "Rua XYZ", "85912345678", "jefferson@email.com"));
        // Exemplo: Adicionar um funcionario
        system.salespeople.add(new Salesperson("Afonso", "Gerente", 5));
        system.salespeople.add(new Salesperson("Jorge", "Vendedor", 2));
        
        while (true) {
            System.out.print(CLEAR_CONSOLE); // Limpar o console
            System.out.println("\nOpções:");
            System.out.println("1. Listar carros");
            System.out.println("2. Listar clientes");
            System.out.println("3. Listar funcionários");
            System.out.println("------------------------");
            System.out.println("4. Adicionar carro");
            System.out.println("5. Adicionar cliente");
            System.out.println("6. Adicionar funcionário");
            System.out.println("------------------------");
            System.out.println("7. Editar informação");
            System.out.println("8. Excluir");
            System.out.println("------------------------");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listCars(system.cars);
                    break;
                case 2:
                    listCustomers(system.customers);
                    break;
                case 3:
                    listSalespeople(system.salespeople);
                    break;
                case 4:
                    addCar(system);
                    break;
                case 5:
                    addCustomer(system);
                    break;
                case 6:
                    addSalesperson(system);
                    break;
                case 7:
                    editInformation(system, scanner);
                    break;
                case 8:
                    deleteInformation(system, scanner);
                    break;
                case 9:
                    System.out.println("Saindo do sistema. Até logo!");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.print("\nPressione Enter para continuar...");
            scanner.nextLine(); // Consumir a nova linha
            scanner.nextLine(); // Aguardar a entrada do usuário
        }
    }

    private static void listCars(List<Car> cars) {
        System.out.println("\nCarros disponíveis:");
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            System.out.println(i + ". " + car.brand + " " + car.model + " (" + car.year + ") - R$" + car.price);
        }
    }

    private static void listCustomers(List<Customer> customers) {
        System.out.println("\nClientes cadastrados:");
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            System.out.println(i + ". " + customer.name);
            System.out.println("Endereço: " + customer.address);
            System.out.println("Telefone: " + customer.phone);
            System.out.println("E-mail: " + customer.email);
            System.out.println();
        }
    }

    private static void listSalespeople(List<Salesperson> salespeople) {
        System.out.println("\nFuncionários cadastrados:");
        for (int i = 0; i < salespeople.size(); i++) {
            Salesperson salesperson = salespeople.get(i);
            System.out.println(i + ". " + salesperson.name);
            System.out.println("Cargo: " + salesperson.position);
            System.out.println("Comissão: " + salesperson.commission + "%");
            System.out.println();
        }
    }

    private static void addCar(SalesManagementSystem system) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adicionar um novo carro:");

        System.out.print("Marca: ");
        String brand = scanner.nextLine();

        System.out.print("Modelo: ");
        String model = scanner.nextLine();

        System.out.print("Ano: ");
        int year = scanner.nextInt();

        System.out.print("Preço: ");
        double price = scanner.nextDouble();

        system.cars.add(new Car(brand, model, year, price));
        System.out.println("Carro adicionado com sucesso!");
    }

    private static void addCustomer(SalesManagementSystem system) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adicionar um novo cliente:");

        System.out.print("Nome: ");
        String name = scanner.nextLine();

        System.out.print("Endereço: ");
        String address = scanner.nextLine();

        System.out.print("Telefone: ");
        String phone = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        system.customers.add(new Customer(name, address, phone, email));
        System.out.println("Cliente adicionado com sucesso!");
    }

    private static void addSalesperson(SalesManagementSystem system) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adicionar um novo funcionário:");

        System.out.print("Nome: ");
        String name = scanner.nextLine();

        System.out.print("Cargo: ");
        String position = scanner.nextLine();

        System.out.print("Comissão: ");
        double commission = scanner.nextDouble();

        system.salespeople.add(new Salesperson(name, position, commission));
        System.out.println("Funcionário adicionado com sucesso!");
    }

    private static void editInformation(SalesManagementSystem system, Scanner scanner) {
        System.out.println("\nEditar informação:");
        System.out.println("1. Editar carro");
        System.out.println("2. Editar cliente");
        System.out.println("3. Editar funcionário");
        System.out.print("Escolha uma opção: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                editCar(system);
                break;
            case 2:
                editCustomer(system);
                break;
            case 3:
                editSalesperson(system);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void editCar(SalesManagementSystem system) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\nEditar carro:");
    listCars(system.cars);
    System.out.print("Escolha o índice do carro a ser editado: ");
    int index = scanner.nextInt();
    scanner.nextLine(); // Consumir a nova linha

    if (index >= 0 && index < system.cars.size()) {
        Car car = system.cars.get(index);
        System.out.print("Nova marca: ");
        car.brand = scanner.nextLine();
        System.out.print("Novo modelo: ");
        car.model = scanner.nextLine();
        System.out.print("Novo ano: ");
        car.year = scanner.nextInt();
        System.out.print("Novo preço: ");
        car.price = scanner.nextDouble();
        System.out.println("Carro editado com sucesso!");
    } else {
        System.out.println("Índice inválido.");
    }
}

private static void editCustomer(SalesManagementSystem system) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\nEditar cliente:");
    listCustomers(system.customers);
    System.out.print("Escolha o índice do cliente a ser editado: ");
    int index = scanner.nextInt();
    scanner.nextLine(); // Consumir a nova linha

    if (index >= 0 && index < system.customers.size()) {
        Customer customer = system.customers.get(index);
        System.out.print("Novo nome: ");
        customer.name = scanner.nextLine();
        System.out.print("Novo endereço: ");
        customer.address = scanner.nextLine();
        System.out.print("Novo telefone: ");
        customer.phone = scanner.nextLine();
        System.out.print("Novo e-mail: ");
        customer.email = scanner.nextLine();
        System.out.println("Cliente editado com sucesso!");
    } else {
        System.out.println("Índice inválido.");
    }
}

private static void editSalesperson(SalesManagementSystem system) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\nEditar funcionário:");
    listSalespeople(system.salespeople);
    System.out.print("Escolha o índice do funcionário a ser editado: ");
    int index = scanner.nextInt();
    scanner.nextLine(); // Consumir a nova linha

    if (index >= 0 && index < system.salespeople.size()) {
        Salesperson salesperson = system.salespeople.get(index);
        System.out.print("Novo nome: ");
        salesperson.name = scanner.nextLine();
        System.out.print("Novo cargo: ");
        salesperson.position = scanner.nextLine();
        System.out.print("Nova comissão: ");
        salesperson.commission = scanner.nextDouble();
        System.out.println("Funcionário editado com sucesso!");
    } else {
        System.out.println("Índice inválido.");
    }
}
private static void deleteInformation(SalesManagementSystem system, Scanner scanner) {
    System.out.println("\nExcluir:");
    System.out.println("1. Carro");
    System.out.println("2. Cliente");
    System.out.println("3. Funcionário");
    System.out.print("Escolha uma opção: ");
    int choice = scanner.nextInt();

    switch (choice) {
        case 1:
            deleteCar(system, scanner);
            break;
        case 2:
            deleteCustomer(system, scanner);
            break;
        case 3:
            deleteSalesperson(system, scanner);
            break;
        default:
            System.out.println("Opção inválida.");
    }
}

private static void deleteCar(SalesManagementSystem system, Scanner scanner) {
    System.out.println("\nExcluir carro:");
    listCars(system.cars);
    System.out.print("Escolha o índice do carro a ser excluído: ");
    int index = scanner.nextInt();

    if (confirmAction(scanner)) {
        if (index >= 0 && index < system.cars.size()) {
            system.cars.remove(index);
            System.out.println("Carro excluído com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    } else {
        System.out.println("Ação cancelada.");
    }
}

private static void deleteCustomer(SalesManagementSystem system, Scanner scanner) {
    System.out.println("\nExcluir cliente:");
    listCustomers(system.customers);
    System.out.print("Escolha o índice do cliente a ser excluído: ");
    int index = scanner.nextInt();

    if (confirmAction(scanner)) {
        if (index >= 0 && index < system.customers.size()) {
            system.customers.remove(index);
            System.out.println("Cliente excluído com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    } else {
        System.out.println("Ação cancelada.");
    }
}

private static void deleteSalesperson(SalesManagementSystem system, Scanner scanner) {
    System.out.println("\nExcluir funcionário:");
    listSalespeople(system.salespeople);
    System.out.print("Escolha o índice do funcionário a ser excluído: ");
    int index = scanner.nextInt();

    if (confirmAction(scanner)) {
        if (index >= 0 && index < system.salespeople.size()) {
            system.salespeople.remove(index);
            System.out.println("Funcionário excluído com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    } else {
        System.out.println("Ação cancelada.");
    }
}

private static boolean confirmAction(Scanner scanner) {
    System.out.print("Tem certeza que deseja excluir? (S/N): ");
    String confirmation = scanner.next();
    return confirmation.equalsIgnoreCase("S");
}

}
