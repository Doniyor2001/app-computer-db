package ai.ecma.appComputerDbBot.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

//@RequiredArgsConstructor
public class BotService extends TelegramLongPollingBot {
    @Autowired
    private ButtonService buttonService;
    @Autowired
    private TextService textService;


    @Override
    public String getBotUsername() {
        return "comp_db_bot";
    }

    @Override
    public String getBotToken() {
        return "5523385220:AAHmXrHiTPmcAwx0enHp0EFlOEfVswNrC88";
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        try {

            if (update.hasMessage()) {

                Message message = update.getMessage();

                if (message.hasText()) {

                    textService.text(message);

                }
            } else if (update.hasCallbackQuery()) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

