public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(String id) {
        System.out.println("[Database] Fetching record for ID: " + id);
        return new Customer(id, "Alice Smith");
    }
}