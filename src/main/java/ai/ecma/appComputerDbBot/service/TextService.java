package ai.ecma.appComputerDbBot.service;

import ai.ecma.appComputerDbBot.payload.Product;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import java.util.List;

@Service

public class TextService {
    private final ButtonService buttonService;
    private final BotService botService;
    private final DbService dbService;

    public TextService(ButtonService buttonService, @Lazy BotService botService, DbService dbService) {
        this.buttonService = buttonService;
        this.botService = botService;
        this.dbService = dbService;
    }


    public void text(Message message){
        String text = message.getText();

        if (text.equals("/start")){
            start(message);
        } else if (text.equals("pc")){
            pc(message);
        } else if (text.equals("printer")) {
            printer(message);
        } else if (text.equals("laptop")){
            laptop(message);
        }
    }

    @SneakyThrows
    private void laptop(Message message) {
        List<Product> productList = dbService.getProducts("laptop");

        Long chatId = message.getChatId();

        String text = textBeauty(productList);
        SendMessage sendMessage = new SendMessage();

        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(text);
        sendMessage.enableHtml(true);

        botService.execute(sendMessage);
    }

    @SneakyThrows
    private void printer(Message message) {
        List<Product> productList = dbService.getProducts("printer");

        Long chatId = message.getChatId();

        String text = textBeauty(productList);
        SendMessage sendMessage = new SendMessage();

        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(text);
        sendMessage.enableHtml(true);

        botService.execute(sendMessage);
    }

    @SneakyThrows
    private void pc(Message message) {
        List<Product> productList = dbService.getProducts("pc");
        Long chatId = message.getChatId();

        String text = textBeauty(productList);
        SendMessage sendMessage = new SendMessage();

        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(text);
        sendMessage.enableHtml(true);

        try {
            botService.execute(sendMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String textBeauty(List<Product> productList) {

        StringBuilder text = new StringBuilder();
        for (Product product : productList) {
            text.append("<b>").append(product.getCode()).append("</b>   ")
                    .append("<i>").append(product.getModel()).append("</i>   ")
                    .append("<i><b>").append(product.getPrice()).append("</b></i>   ")
                    .append(product.getType()).append("   ")
                    .append(product.getMaker()).append("   \n");
        }

        return text.toString();
    }

    @SneakyThrows
    public void start(Message message){
        Long chatId = message.getChatId();
        SendMessage sendMessage = new SendMessage(String.valueOf(chatId), "Salom");
        ReplyKeyboardMarkup markup = buttonService.mainButton();
        sendMessage.setReplyMarkup(markup);
        botService.execute(sendMessage);
    }

}
