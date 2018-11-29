package main.java;

import org.telegram.telegrambots.meta.api.objects.Message;


public class User extends AllUsers implements UserSetting{
    String user_first_name;
    String user_last_name;
    String user_username;
    long user_id;
    String message_text;
    long chat_id;
    String category;
    int page;
    int max_page;

    public User createUser(Message message){
        User user = new User();
        user.user_first_name = message.getChat().getFirstName();
        user.user_last_name = message.getChat().getUserName();
        user.user_username = message.getChat().getUserName();
        user.user_id = message.getChat().getId();
        user.message_text = message.getText();
        user.chat_id = message.getChatId();
        user.category = "top100";
        user.page = 1;
        return user;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getMax_page() {
        return max_page;
    }

    public void setMax_page(int max_page) {
        this.max_page = max_page;
    }
}
