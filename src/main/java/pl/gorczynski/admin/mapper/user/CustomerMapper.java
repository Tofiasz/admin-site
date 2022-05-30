package pl.gorczynski.admin.mapper.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gorczynski.admin.dto.user.CustomerDTO;
import pl.gorczynski.admin.model.shop.user.Customer;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    private final AddressMapper addressMapper;

    @Autowired
    public CustomerMapper(final AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public CustomerDTO toCustomerDTO(final Customer customer) {
        return new CustomerDTO(customer.getId(),
                customer.getLogin(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmailAddress(),
                addressMapper.toAddressDTO(customer.getAddress()),
                customer.getRegistrationDate(),
                customer.getIsAccountVerified());
    }

    public List<CustomerDTO> toCustomerDTOList(final List<Customer> customerList) {

        return customerList.stream()
                .map(this::toCustomerDTO)
                .collect(Collectors.toList());
    }

    public Customer toCustomer(final CustomerDTO customerDTO) {
        return new Customer(customerDTO.getId(),
                customerDTO.getLogin(),
                customerDTO.getFirstName(),
                customerDTO.getLastName(),
                customerDTO.getEmailAddress(),
                addressMapper.toAddress(customerDTO.getAddressDTO()),
                customerDTO.getRegistrationDate(),
                customerDTO.getIsAccountVerified());
    }
}
