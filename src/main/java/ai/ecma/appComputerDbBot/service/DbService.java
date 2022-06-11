package ai.ecma.appComputerDbBot.service;

import ai.ecma.appComputerDbBot.payload.FormDataDTO;
import ai.ecma.appComputerDbBot.payload.Product;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DbService {
    private final String url = "jdbc:postgresql://localhost:5432/computer";
    private final String dbUser = "postgres";
    private final String dbPassword = "root123";


    public List<Product> getProducts(String tableName){

        List<Product> productList = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(url, dbUser, dbPassword);
            String query = "select p.model, maker, p.type, price, code from " + tableName + " t join product p on t.model=p.model";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                String model = resultSet.getString("model");
                String maker = resultSet.getString("maker");
                String type = resultSet.getString("type");
                Double price = resultSet.getDouble("price");
                Integer code = resultSet.getInt("code");

                Product product = new Product(
                        model,
                        maker,
                        type,
                        price,
                        code
                );
                productList.add(product);
            }

            connection.close();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return productList;
    }

    public FormDataDTO getFormData() {

        FormDataDTO formDataDTO = new FormDataDTO();
        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(url, dbUser, dbPassword);
            String query = "select * from product";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            formDataDTO.setMakers(new HashSet<>());
            formDataDTO.setModels(new HashSet<>());
            formDataDTO.setTypes(new HashSet<>());

            while (resultSet.next()){
                String model = resultSet.getString("model");
                String maker = resultSet.getString("maker");
                String type = resultSet.getString("type");

                Set<String> makers = formDataDTO.getMakers();
                Set<String> models = formDataDTO.getModels();
                Set<String> types = formDataDTO.getTypes();

                makers.add(maker);
                models.add(model);
                types.add(type);
            }

            connection.close();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return formDataDTO;
    }
}
