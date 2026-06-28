public class DependencyInjectionExample {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();

        CustomerService svc = new CustomerService(repo);

        System.out.println("Starting Application");
        
        svc.processCustomer("10425");
    }
}