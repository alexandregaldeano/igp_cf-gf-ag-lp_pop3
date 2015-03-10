package base.client;

import base.email.Email;
import util.CurrentState;

public interface Client {
    String getSucessMessage();

    Email getMessage();

    String getErrorMessage();

    CurrentState getCurrentState();

    int getUnreadMessage();

    void openConnexion(String hostname, int port);

    void closeConnexion();

    void signIn(String username);

    void signIn(String username, String password);

    void getMessageList();

    void getMessageDetails(int i);

    void enterLogin(String username);

    void enterPassword(String password);

    void getMessage(int num);

    void getStat();
}
