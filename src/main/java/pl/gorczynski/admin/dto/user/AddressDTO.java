package pl.gorczynski.admin.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private Integer id;
    private String country;
    private String city;
    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String zipCode;
    private String phoneNumber;
}
