package sample;

import javafx.collections.ObservableList;
import users.Client;

/**
 * Created by elad on 11/08/2017.
 */
public class DataTransfer {
    private static DataTransfer ourInstance = new DataTransfer();

    private String action= "";
    private Client client =null;
    private ObservableList<Client> clientList;
    public ObservableList<Client> getClientList() {
        return clientList;
    }

    public void setClientList(ObservableList<Client> clientList) {
        this.clientList = clientList;
    }




    public Client getClient() {
        return client;
    }


    public void setClient(Client client) {
        this.client =null;
        this.client = client;
        System.out.println("data:"+this.client);

    }




    public static DataTransfer getInstance() {

        return ourInstance;
    }

    private DataTransfer() {
    }

    public void setAction(String action) {
        this.action=action;
    }
    public String getAction(){
        return action;
    }


}
