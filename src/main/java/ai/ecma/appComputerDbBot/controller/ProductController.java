package ai.ecma.appComputerDbBot.controller;

import ai.ecma.appComputerDbBot.payload.FormDataDTO;
import ai.ecma.appComputerDbBot.payload.Product;
import ai.ecma.appComputerDbBot.service.DbService;
import ai.ecma.appComputerDbBot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
@RequestMapping("/form")
public class ProductController {
    private final DbService dbService;
    private final ProductService productService;

    @GetMapping()
    public String getForm(Model model){
        FormDataDTO formData = dbService.getFormData();
        model.addAttribute("types",formData.getTypes());
        model.addAttribute("models",formData.getModels());
        model.addAttribute("makers",formData.getMakers());
        model.addAttribute("pcList",new ArrayList<>());//new arraylist ni o'rnida pc lar bo'lishi kerak
        return "form";
    }

    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute Product product){
        productService.saveProduct(product);
        //todo FORM NI TAGIDA BARCHA MAHSULOTLAR ALOHIDA ALOHIDA TABLE LARDA CHIQARILSIN
        return "form";
    }

}
