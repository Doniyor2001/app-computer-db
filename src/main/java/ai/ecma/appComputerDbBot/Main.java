package ai.ecma.appComputerDbBot;

import ai.ecma.appComputerDbBot.config.Mywebconfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main {

    public static void main(String[] args) throws TelegramApiException {
        ApplicationContext context = new AnnotationConfigApplicationContext(Mywebconfig.class);

    }

}
