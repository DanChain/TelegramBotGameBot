package main.java;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.IOException;


public class ParserContent{



    public void getParsing(Message message, String parserUrl){
        org.jsoup.nodes.Document document = null;
        try {
            document = Jsoup.connect(parserUrl).timeout(6000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements wrapBlocks = document.select("div.articles");
        for (Element blockGame: wrapBlocks.select("div.article-film")) {
            Element thumbnailWrap = blockGame.selectFirst("img.article-img");
            System.out.println(thumbnailWrap);
            String gameThumbnail = thumbnailWrap.attr("src");
            System.out.println(gameThumbnail);
            String gameTitle = thumbnailWrap.attr("title");
            String gameOnline = blockGame.selectFirst("div.article-film-image a").attr("href");

            if (gameOnline == null){
                Messages messages = new Messages();
                messages.sendMsg(message, "Страница не найдена");
                break;
            }

            Game game = new Game(gameTitle,  gameThumbnail, gameOnline);
            String gogleUrl = "https://www.google.com.ua/search?ei=4rv7W83JJqWWjgaoj7Uo&q=" +
                    gameTitle.replace(" ", "+") +
                    "&oq=" +
                    gameTitle.replace(" ", "+") +
                    "&gs_l=psy-ab.3.1.0i131j0l9.4070880.4070880..4072181...0.0..0.71.71.1......0....1j2..gws-wiz.bvcRpJ72Qzk";
            System.out.println(gogleUrl);

            game.getBlockThumnail(game,message);
            getParsingInfo(message, gogleUrl);
//            game.getBlockInfo(game,message);
            getParsingIn(message, gameOnline);
            game.getBlockTparser(game,message);
        }
    }


    public void getParsingIn(Message message, String parserUrl){
        org.jsoup.nodes.Document document = null;
        try {
            document = Jsoup.connect(parserUrl).timeout(6000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String urlVideo = document.selectFirst("div.global-container div.content-left-column #dle-content center iframe").attr("src");
        urlVideo = urlVideo.replace("//", "️\t Тизер:");
        Messages messages = new Messages();
        messages.sendMsg(message, urlVideo);
    }
    public void getParsingInfo(Message message, String parserUrl){
        Document document = null;
        try {
            document = Jsoup.connect(parserUrl).timeout(6000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String info = "";
        for (Element blockGame: document.select("div.xpdopen div.SALvLe.farUxc.mJ2Mod span.LrzXr.kno-fv")) {
            System.out.println(blockGame.text());
            info = info + blockGame.text() + "\n";
        }
        Messages messages = new Messages();
        messages.sendMsg(message, info);
    }
}

