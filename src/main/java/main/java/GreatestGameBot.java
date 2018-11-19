package main.java;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;

public class GreatestGameBot extends TelegramLongPollingBot {


    AllUsers allUsers = new AllUsers();
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()){
            Messages messages = new Messages();
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
                comandList.add("Все игры");
                comandList.add("Следующая страница");
                comandList.add("Аркады");
                comandList.add("Выживание");
                comandList.add("воксельная графика");
                comandList.add("Головоломка");
                comandList.add("Гонки");
                comandList.add("Билд. Сим.");
                comandList.add("Кооп");
                comandList.add("Для Слабых ПК");
                comandList.add("Драки");
                comandList.add("Зомби");
                comandList.add("Инди");
                comandList.add("Карты");
                comandList.add("Квесты");
                comandList.add("Конструктор");
                comandList.add("Космос");
                comandList.add("Открытый мир");
                comandList.add("Песочница");
                comandList.add("Пиксельная Графика");
                comandList.add("Платформер");
                comandList.add("Подземелья");
                comandList.add("Пошаговая стратегия");
                comandList.add("Приключения");
                comandList.add("Симульятор");
                comandList.add("Спорт");
                comandList.add("Среднеыековье");
                comandList.add("Стелс");
                comandList.add("Стратегия");
                comandList.add("Строительство");
                comandList.add("Хорор");
                comandList.add("Шутер");
                comandList.add("Экон. Сим");
                comandList.add("ЭкшОн");
                comandList.add("Т. Д.");
                comandList.add("Рагалик");
                comandList.add("Хак'н'слеш");
                comandList.add("Поинт н клик");
                comandList.add("РПГ");
                comandList.add("РТС");
                comandList.add("ФПС");
                comandList.add("ГОГ");
                messages.Keys(update.getMessage(), comandList);
            }
            else if (comand.equals("Все игры")){
                currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/games"+"/page/" + currentlyUser.getPage());
            }
            else if (comand.equals("Следующая страница")){
                currentlyUser.setPage(currentlyUser.getPage() + 1);
                System.out.println("https://vsetop.org/" + currentlyUser.getCategory()+"/"+ currentlyUser.getPage());
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/");
            }
            switch (comand){
                case "Аркады": currentlyUser.setCategory("tags/аркада");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Выживание": currentlyUser.setCategory("tags/выживание");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Головоломка": currentlyUser.setCategory("tags/Головоломка");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Гонки": currentlyUser.setCategory("tags/Гонки");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Билд. Сим.": currentlyUser.setCategory("tags/градостроительный+симулятор");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Кооп": currentlyUser.setCategory("tags/для+нескольких+игроков");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Для Слабых ПК": currentlyUser.setCategory("tags/для+слабых+ПК");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Драки": currentlyUser.setCategory("tags/драки");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Зомби": currentlyUser.setCategory("tags/зомби");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Инди": currentlyUser.setCategory("tags/инди");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Карты": currentlyUser.setCategory("tags/карточная+игра");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Квесты": currentlyUser.setCategory("tags/квест");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Конструктор": currentlyUser.setCategory("tags/конструктор");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Космос": currentlyUser.setCategory("tags/космос");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Открытый мир": currentlyUser.setCategory("tags/открытый+мир");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Песочница": currentlyUser.setCategory("tags/песочница");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Пиксельная Графика": currentlyUser.setCategory("tags/пиксельная+графика");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Платформер": currentlyUser.setCategory("tags/платформер");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Подземелья": currentlyUser.setCategory("tags/подземелье");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Пошаговая стратегия": currentlyUser.setCategory("tags/пошаговая+стратегия");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Приключения": currentlyUser.setCategory("tags/приключение");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Симульятор": currentlyUser.setCategory("tags/симулятор");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Спорт": currentlyUser.setCategory("tags/спорт");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Среднеыековье": currentlyUser.setCategory("tags/средневековье");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Стелс": currentlyUser.setCategory("tags/стелс");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Стратегия": currentlyUser.setCategory("tags/стратегия");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Строительство": currentlyUser.setCategory("tags/строительство");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Хорор": currentlyUser.setCategory("tags/хоррор");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Шутер": currentlyUser.setCategory("tags/шутер");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Экон. Сим": currentlyUser.setCategory("tags/экономический+симулятор");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "ЭкшОн": currentlyUser.setCategory("tags/экшен");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Т. Д.": currentlyUser.setCategory("tags/Tower+Defense");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Рагалик": currentlyUser.setCategory("tags/Roguelike");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Хак'н'слеш": currentlyUser.setCategory("tags/Hack+and+slash");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "Поинт н клик": currentlyUser.setCategory("tags/point-and-click");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "РПГ": currentlyUser.setCategory("tags/RPG");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "РТС": currentlyUser.setCategory("tags/RTS");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "ФПС": currentlyUser.setCategory("tags/FPS");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "ГОГ": currentlyUser.setCategory("tags/GOG");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;
                case "воксельная графика": currentlyUser.setCategory("tags/воксельная+графика");currentlyUser.setPage(1);
                parserContent.getParsing(update.getMessage(), "https://vsetop.org/" + currentlyUser.getCategory()+"/page/"+ currentlyUser.getPage() + "/"); break;

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
