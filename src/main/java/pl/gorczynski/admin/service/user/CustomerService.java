package pl.gorczynski.admin.service.user;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.gorczynski.admin.dto.user.CustomerDTO;
import pl.gorczynski.admin.mapper.user.CustomerMapper;
import pl.gorczynski.admin.model.shop.user.Customer;
import pl.gorczynski.admin.repository.user.CustomerRepository;

import java.util.List;

@Service
@Getter
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private Integer pageNumberSearchFor;

    @Autowired
    public CustomerService(final CustomerRepository customerRepository,
                           final CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<CustomerDTO> getCustomerDTOListAsc(final Integer numberOfCustomers, final Integer pageNumber) {
        List<Customer> customerList = customerRepository.findAll(PageRequest.of(pageNumber, numberOfCustomers, Sort.by("registrationDate")
                .descending()))
                .toList();

        return customerMapper.toCustomerDTOList(customerList);
    }

    public Integer countAllUser() {
        return Math.toIntExact(customerRepository.count());
    }

    public List<CustomerDTO> getPageWithCustomers(final Integer pageNumber) {
        List<Customer> customerList = customerRepository.findAll(PageRequest.of(pageNumber, 10)).toList();

        return customerMapper.toCustomerDTOList(customerList);
    }

    public List<CustomerDTO> getPageWithCustomersWithSearchFor(final String searchFor,
                                                            final Integer pageNumber) {
        List<Customer> customerList = customerRepository.findAll(searchFor);
        PagedListHolder<Customer> page = new PagedListHolder<>(customerList);
        page.setPageSize(10);
        page.setPage(pageNumber);
        pageNumberSearchFor = page.getPageCount();

        return customerMapper.toCustomerDTOList(page.getPageList());
    }

    public Integer getPagesNumber() {
        return (Integer) (int) Math.ceil(customerRepository.count() / 10.0);
    }

    public CustomerDTO getUserById(final Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow();

        return customerMapper.toCustomerDTO(customer);
    }

    public CustomerDTO getCustomerDTOById(final Integer customerId) {
        Customer customer = getCustomerById(customerId);

        return customerMapper.toCustomerDTO(customer);
    }

    public Customer getCustomerById(final Integer customerId) {
        return customerRepository.findById(customerId).orElseThrow();
    }

    public void deleteUserById(final Integer id) {
        customerRepository.deleteById(id);
    }
}
