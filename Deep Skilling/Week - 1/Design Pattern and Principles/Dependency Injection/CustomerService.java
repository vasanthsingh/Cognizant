public class CustomerService {
    private CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public void processCustomer(String id) {
        Customer c = repo.findCustomerById(id);
        
        if (c != null) {
            System.out.println("Processing data for: " + c.getName());
        } else {
            System.out.println("Customer not found.");
        }
    }
}