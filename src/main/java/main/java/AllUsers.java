package main.java;

import java.util.ArrayList;


public class AllUsers {
    public ArrayList<User> arrayListUsers = new ArrayList<User>();

    public ArrayList<User> getArrayListUsers() {
        return arrayListUsers;
    }

    public boolean ifUserCreated(long id){
        for (User user :arrayListUsers) {
            if (user.user_id == id){
                return true;
            }
        }
        return false;
    }

    public User getUser(long user_id){
        int index = 0;
        for (User user :arrayListUsers) {
            if (user.user_id == user_id){
                break;
            }
            index++;
        }
        User user = arrayListUsers.get(index);
        return user;
    }
}
