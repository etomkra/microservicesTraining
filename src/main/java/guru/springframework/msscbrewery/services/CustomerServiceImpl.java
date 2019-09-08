package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .username("Johnny")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto newCustomer) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .username(newCustomer.getUsername())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        // TODO ADD IMPLEMENTATION
    }

    @Override
    public void deleteCustomer(UUID customerId) {

    }
}
