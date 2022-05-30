package pl.gorczynski.admin.mapper.user;

import org.springframework.stereotype.Component;
import pl.gorczynski.admin.dto.user.AddressDTO;
import pl.gorczynski.admin.model.shop.user.Address;

@Component
public class AddressMapper {

    public AddressDTO toAddressDTO(final Address address) {
        return new AddressDTO(address.getId(),
                address.getCountry(),
                address.getCity(),
                address.getStreet(),
                address.getHouseNumber(),
                address.getApartmentNumber(),
                address.getZipCode(),
                address.getPhoneNumber());
    }

    public Address toAddress(final AddressDTO addressDTO) {
        return new Address(addressDTO.getId(),
                addressDTO.getCountry(),
                addressDTO.getCity(),
                addressDTO.getStreet(),
                addressDTO.getHouseNumber(),
                addressDTO.getApartmentNumber(),
                addressDTO.getZipCode(),
                addressDTO.getPhoneNumber());
    }
}
