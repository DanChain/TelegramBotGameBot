package main.java;

import org.telegram.telegrambots.meta.api.objects.Message;


public class Game extends Messages {
    public String GameTitle;
    public String GameCountry;
    public String GameGenre;
    public String GameDescription;
    public String GameThumnail;
    public String GameOnline;
    public String GameTparser;

    public Game(String GameTitle, String GameThumnail, String GameOnline) {
        this.GameTitle = GameTitle;
        this.GameThumnail = GameThumnail;
        this.GameOnline = GameOnline;

        this.GameTparser = tparserTorrent(GameTitle);
    }
    public void grtBlockTitle(Game game, Message message){
        sendMsg(message, GameTitle);
    }
    public void getBlockInfoWitoutDescription(Game game, Message message){
        String descriptionFilm = "\uD83C\uDFF4 Страна: " + game.GameCountry +  "\n" + "✅ Жанр: " + game.GameGenre + "\n";
        sendMsg(message, descriptionFilm);
    }
    public void getBlockThumnail(Game game, Message message){
        sendThumbnail(message, game.GameThumnail, GameTitle);
    }
    public void getBlockInfo(Game game, Message message){
        String descriptionFilm = "\uD83C\uDFF4 Страна: " + game.GameCountry +  "\n" + "✅ Жанр: " + game.GameGenre + "\n" + "\uD83D\uDCDD Описание: " + game.GameDescription;
        sendMsg(message, descriptionFilm);
    }
    public void getBlockOnline(Game game, Message message){
        sendMsg(message, "️ Онлайн - " + game.GameOnline);
    }
    public void getBlockTparser(Game game, Message message){
        sendMsg(message,"️ Торрент - " + game.GameTparser);
    }
    public String tparserTorrent(String title){
        String newTitle = title.replace(' ', '+');
        newTitle = title.replace('"', '+');
        newTitle = title.replace(' ', '+');
        return "http://tparser.org/" + newTitle;
    }
}