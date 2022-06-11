package ai.ecma.appComputerDbBot.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    private String model;

    private String maker;

    private String type;

    private Double price;

    private Integer code;
}
