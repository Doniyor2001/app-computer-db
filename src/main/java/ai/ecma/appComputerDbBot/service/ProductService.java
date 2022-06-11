package ai.ecma.appComputerDbBot.service;

import ai.ecma.appComputerDbBot.payload.Product;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final DbService dbService;

    public boolean saveProduct(Product product) {
        String type = product.getType();
        if (Objects.equals(type, "pc")) {
            return savePc(product);
        } else if (Objects.equals(type, "laptop")) {
            return saveLaptop(product);
        } else if (Objects.equals(type, "printer")) {
            return savePrinter(product);
        }
        return false;
    }

    private boolean savePrinter(Product product) {
        // TODO: 07/06/22 Yozilsin
        return false;
    }

    private boolean saveLaptop(Product product) {
        // TODO: 07/06/22 Yozilsin
        return false;
    }

    private boolean savePc(Product product) {
        // TODO: 07/06/22 Yozilsin
        return false;
    }


}
