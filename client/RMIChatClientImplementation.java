package client;

import common.*;
import java.rmi.*;
import java.rmi.server.*;

public class RMIChatClientImplementation extends UnicastRemoteObject implements RMIChatClientInterface {

    //GroupChatController controller;
    public RMIChatClientImplementation() throws RemoteException {
    }

    /*Start Ahmed*/
    @Override
    public void receive(Message message) throws RemoteException {
        System.out.println(message.getUser().getName() + ": " + message.getMessageString());
        GroupChatController.controller.setMessage(message);

    }

}
