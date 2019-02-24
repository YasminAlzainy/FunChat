package server;

import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import common.*;

public class RMIChatServerImplementation extends UnicastRemoteObject implements RMIChatServerInterface {

    ArrayList<RMIChatClientInterface> clients;
    Message brodcastMessage;

    public RMIChatServerImplementation() throws RemoteException {
        clients = new ArrayList<>();
    }

    @Override
    public void brodcast(Message messasge) throws RemoteException {
        this.clients.stream().forEach((client) -> {
            try {
                client.receive(messasge);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        });

    }

    @Override
    public void register(RMIChatClientInterface client) throws RemoteException {
        this.clients.add(client);
    }

    @Override
    public void unRegister(RMIChatClientInterface client) throws RemoteException {
        this.clients.remove(client);
    }

}
