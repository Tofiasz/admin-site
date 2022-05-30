package pl.gorczynski.admin.dto.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShipperDTO {

    private Integer id;
    private Integer shipperId;
    private String companyName;
}
