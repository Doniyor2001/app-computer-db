package ai.ecma.appComputerDbBot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Service
public class ButtonService {

    public ReplyKeyboardMarkup mainButton(){
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();

        markup.setOneTimeKeyboard(false);
        markup.setSelective(true);

        KeyboardButton pc = new KeyboardButton();
        pc.setText("pc");

        KeyboardButton laptop = new KeyboardButton();
        laptop.setText("laptop");

        KeyboardButton printer = new KeyboardButton();
        printer.setText("printer");

        KeyboardRow firstRow = new KeyboardRow();
        firstRow.add(pc);
        firstRow.add(laptop);

        KeyboardRow secondRow = new KeyboardRow();
        secondRow.add(printer);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(firstRow);
        rowList.add(secondRow);

        markup.setKeyboard(rowList);

        return markup;
    }

}
