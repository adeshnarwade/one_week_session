import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomerManager {
	private List<Customer> customers;

	public CustomerManager() {
		customers = new ArrayList<>();
	}

	// Add
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}

	// Remove
	public boolean removeCustomer(int id) {
		for (Customer customer : customers) {
			if (customer.getId() == id) {
				customers.remove(customer);
				return true;
			}
		}
		return false;
	}

	// Search
	public Customer searchCustomer(int id) {
		for (Customer customer : customers) {
			if (customer.getId() == id) {
				return customer;
			}
		}
		return null;
	}

	// List All Customers
	public void listAllCustomers() {
		if (customers.isEmpty()) {
			System.out.println("No customers found.");
		} else {
			for (Customer customer : customers) {
				System.out.println(customer);
			}
		}
	}

	// Sort by Name
	public void sortCustomersByName() {
		Collections.sort(customers, new Comparator<Customer>() {
			@Override
			public int compare(Customer c1, Customer c2) {
				return c1.getName().compareTo(c2.getName());
			}
		});
	}

	// Sort by ID
	public void sortCustomersById() {
		Collections.sort(customers, new Comparator<Customer>() {
			@Override
			public int compare(Customer c1, Customer c2) {
				return Integer.compare(c1.getId(), c2.getId());
			}
		});
	}

	public static void main(String[] args) {
		CustomerManager manager = new CustomerManager();

		manager.addCustomer(new Customer(1, "Rushak Pachpande", "rushak@mail.com"));
		manager.addCustomer(new Customer(2, "Vikas Gawande", "vikas@mail.com"));
		manager.addCustomer(new Customer(3, "Mohammad Rafi Shaikh", "mohammad@mail.com"));

		System.out.println("All Customers :");
		manager.listAllCustomers();

		System.out.println("\nSorted by Name :");
		manager.sortCustomersByName();
		manager.listAllCustomers();

		System.out.println("\nSorted by ID :");
		manager.sortCustomersById();
		manager.listAllCustomers();

		System.out.println("\nSearch for Customer with ID 2 :");
		Customer customer = manager.searchCustomer(2);
		if (customer != null) {
			System.out.println(customer);
		} else {
			System.out.println("Customer not found.");
		}

		System.out.println("\nRemoving Customer with ID 2 :");
		manager.removeCustomer(2);
		manager.listAllCustomers();
	}
}
