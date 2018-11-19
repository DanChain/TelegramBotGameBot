package main.java;

import org.jsoup.Jsoup;
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
        Elements wrapBlocks = document.select("div#dle-content");
        for (Element blockGame: wrapBlocks.select("div.shorbox")) {
            Element thumbnailWrap = blockGame.selectFirst("div.postershort a img.postr");
            String gameThumbnail = thumbnailWrap.attr("src");
            String gameTitle = thumbnailWrap.attr("title");
            String gameOnline = blockGame.selectFirst("div.postershort a").attr("href");


            Element listInfo = blockGame.selectFirst("div.shortboxh");
            String gameCountry = listInfo.selectFirst("div.godshort:eq(1) span.orange").text();
            String gameGenre = listInfo.selectFirst("div.godshort:eq(2) span.orange").text();
            String GameDescription = listInfo.selectFirst("div.shorttext").text();

            if (gameOnline == null){
                Messages messages = new Messages();
                messages.sendMsg(message, "Страница не найдена");
                break;
            }

            Game game = new Game(gameTitle, gameCountry, gameGenre, GameDescription, gameThumbnail, gameOnline);


            game.getBlockThumnail(game,message);
            game.getBlockInfo(game,message);
            game.getBlockOnline(game,message);
            game.getBlockTparser(game,message);
        }
    }
}
