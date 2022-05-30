package pl.gorczynski.admin.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.Base64;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductImageDTO {

    private Integer id;
    private String name;
    private Date uploadedAt;
    private byte[] image;
    private String encodedImage;

    public ProductImageDTO(final @NotNull String name,
                        final byte[] image) {
        this.name = name;
        this.uploadedAt = new Date();
        this.image = image;
    }

    public ProductImageDTO(final Integer id,
                           final String name,
                           final Date uploadedAt,
                           final byte[] image) {
        this.id = id;
        this.name = name;
        this.uploadedAt = uploadedAt;
        this.image = image;
    }

    public String getEncodedImage() {
        return Base64.getEncoder().encodeToString(this.image);
    }

    public void setEncodedImage() {
        this.encodedImage = Base64.getEncoder().encodeToString(this.image);
    }
}
