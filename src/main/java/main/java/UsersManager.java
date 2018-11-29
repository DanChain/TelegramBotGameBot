package main.java;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.telegram.telegrambots.meta.api.objects.Chat;

public class UsersManager {
    private static UsersManager sInstance;
    private static final String DB_HOST = "ds211774.mlab.com";
    private static final int DB_PORT = 11774;
    private static final String DB_NAME = "heroku_16rkwntc";
    private static final String DB_USER = "bot_admin";
    private static final String DB_PASSWORD = "admin1";

    private static final String DB_URL = "mongodb://bot_admin:admin1@ds147190.mlab.com:47190/heroku_wxcccscm";
    private MongoCollection<Document> mUsersCollection;

    private UsersManager() {
        MongoClientURI clientURI = new MongoClientURI(DB_URL);
        MongoClient client = new MongoClient(clientURI);
        MongoDatabase db = client.getDatabase("heroku_wxcccscm");
        this.mUsersCollection = db.getCollection("ManagerUsers");
    }

    public static UsersManager getInstance() {
        if (sInstance == null) {
            sInstance = new UsersManager();
        }

        return sInstance;
    }

    public String getNameById(Chat chat) {
        Document query = new Document("id", chat.getId().toString());
        Document user = (Document)this.mUsersCollection.find(query).first();
        if (user == null) {
            Document newUser = (new Document("id", chat.getId().toString())).append("firstName", chat.getFirstName()).append("lastName", chat.getLastName()).append("username", chat.getUserName());
            this.mUsersCollection.insertOne(newUser);
            return "Вас не було в базі користувачів, але ми вас добавили ;-)";
        } else {
            String firstName = user.getString("firstName");
            String lastName = user.getString("lastName");
            String username = user.getString("username");
            return "*" + firstName + " " + lastName + "*, нікнейм: *" + username + "*";
        }
    }
}
