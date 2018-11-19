package main.java;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;


public class Messages extends GreatestGameBot {
    public void sendThumbnail(Message message, String url, String title){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setCaption(title);
        sendPhoto.setPhoto(url);
        sendPhoto.setChatId(message.getChatId().toString());
        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public  void sendMsg(Message message, String s){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(s);
        sendMessage.disableWebPagePreview();
        try {
            execute(sendMessage);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
    public void Keys(Message message, ArrayList<String> comandList){
        SendMessage sendMessage = new SendMessage();

        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.enableMarkdown(true);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboar = new ArrayList<>();

        int i = 0;
        KeyboardRow row = new KeyboardRow();
        for (String comand:  comandList) {
            row.add(comand);
            i++;
            if (i % 2 == 0){
                keyboar.add(row);
                row = new KeyboardRow();
            }
        }
        replyKeyboardMarkup.setKeyboard(keyboar);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setText("Выберите действие из меню");
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMessage.disableWebPagePreview();
        try {
            execute(sendMessage);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
