package main.java;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;

public class GreatestGameBot extends TelegramLongPollingBot {


    AllUsers allUsers = new AllUsers();
    public Message parserUrl;

    public void onUpdateReceived(Update update) {
        Messages messages = new Messages();

        String result = UsersManager.getInstance().getNameById(update.getMessage().getChat());

        if (update.hasMessage()){

//            Messages messages = new Messages();
            ParserContent parserContent = new ParserContent();

            User currentlyUser;
            if (!allUsers.ifUserCreated(update.getMessage().getChat().getId())){
                User user = new User().createUser(update.getMessage());
                allUsers.arrayListUsers.add(user);
                currentlyUser = user;
                System.out.println("We create user");
                System.out.println("Пользователь создан");
            }
            else{
                System.out.println("User already created");
                currentlyUser = allUsers.getUser(update.getMessage().getFrom().getId());
                System.out.println("Polzovatelia nevozmozno sozdat");
            }

            String comand = update.getMessage().getText();
            if (comand.equals("/start")){
                System.out.println("Programma pobachila start");
                messages.sendMsg(update.getMessage(), "Hi, " + update.getMessage().getFrom().getFirstName() + "!");
                ArrayList<String> comandList = new ArrayList<String>();


                comandList.add("Top-100");
                comandList.add("Next Page");
                comandList.add("2018 Games");
                comandList.add("Race Games");
                comandList.add("Action Games");
                comandList.add("RPG Games");
                comandList.add("Horror Games");
                comandList.add("Fighting Games");
                comandList.add("Arcade Games");
                comandList.add("Sport Games");
                comandList.add("Strategy Games");
                comandList.add("Survival Games");
                comandList.add("Simulator Games");
                comandList.add("Adventure Games");
                comandList.add("Coming Soon Games");




                messages.Keys(update.getMessage(), comandList);
            }
            else if (comand.equals("Top-100")){
                currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://torrent-igruha.org/top100/" + "page/" + currentlyUser.getPage() + "/");
            }
            else if (comand.equals("Next Page")){
                currentlyUser.setPage(currentlyUser.getPage() + 1);
                System.out.println("https://torrent-igruha.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage()+"/");
                parserContent.getParsing(update.getMessage(), "https://torrent-igruha.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/");
            }
            switch (comand){
                case "2018 Games": currentlyUser.setCategory("igry_2018");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://torrent-igruha.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/");break;
                case "Race Games": currentlyUser.setCategory("race");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://torrent-igruha.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Action Games": currentlyUser.setCategory("action");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://torrent-igruha.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "RPG Games": currentlyUser.setCategory("rpg");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://torrent-igruha.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Horror Games": currentlyUser.setCategory("horror-game");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://torrent-igruha.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Fighting Games": currentlyUser.setCategory("fighting");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://torrent-igruha.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Arcade Games": currentlyUser.setCategory("arcade");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://torrent-igruha.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Sport Games": currentlyUser.setCategory("sport");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://torrent-igruha.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Strategy Games": currentlyUser.setCategory("strategy");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://torrent-igruha.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Survival Games": currentlyUser.setCategory("survival-game");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://torrent-igruha.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Simulator Games": currentlyUser.setCategory("simulators");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://torrent-igruha.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Adventure Games": currentlyUser.setCategory("adventure");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://torrent-igruha.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Coming Soon Games": currentlyUser.setCategory("igry_2019");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://torrent-igruha.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;


            }

            if (update.hasCallbackQuery()) {
                CallbackQuery callbackQuery = update.getCallbackQuery();
                String callbackQueryData = callbackQuery.getData();

                if (callbackQueryData.equalsIgnoreCase("action-1")) {

                }
            }
        }
    }

    public String getBotUsername() {
        return "Greatest_Game_Bot";
    }
    public String getBotToken() {
        return "663292538:AAFFp0aMlX2zGCOCx5MqAEqVp9FAST6PiKc";
    }
}
