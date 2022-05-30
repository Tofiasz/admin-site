package pl.gorczynski.admin.service.shop.product;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.gorczynski.admin.dto.product.ProductImageDTO;
import pl.gorczynski.admin.model.shop.product.ProductImage;
import pl.gorczynski.admin.repository.shop.product.ProductImageRepository;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
public class ProductImageService {

    private final ProductImageRepository productImageRepository;

    public ProductImageService(final ProductImageRepository productImageRepository) {
        this.productImageRepository = productImageRepository;
    }

    public List<ProductImageDTO> getProductImagesListFromMultipartFileList(final List<MultipartFile> multipartFileList) {
        return multipartFileList.stream()
                .map(this::getProductImageFromMultipartFile)
                .collect(Collectors.toList());
    }

    private ProductImageDTO getProductImageFromMultipartFile(final MultipartFile multipartFile){
        ProductImageDTO productImageDTO = null;
        try {
            productImageDTO = new ProductImageDTO(Objects.requireNonNull(multipartFile.getOriginalFilename()),
                    multipartFile.getBytes());
        }
        catch (IOException ignored) {
        }

        return productImageDTO;
    }

    private byte[] compressBytes(byte[] bytes) {
        Deflater deflater = new Deflater();
        deflater.setInput(bytes);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(bytes.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException ignored) {
        }

        return outputStream.toByteArray();
    }

    private byte[] decompressBytes(byte[] bytes) {
        Inflater inflater = new Inflater();
        inflater.setInput(bytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(bytes.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException | DataFormatException ignored) {
        }

        return outputStream.toByteArray();
    }
}
