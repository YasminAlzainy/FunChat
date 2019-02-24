package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIChatServer {

    public RMIChatServer() {
        try {
            RMIChatServerImplementation chatServerImplementation = new RMIChatServerImplementation();
            Registry registry = LocateRegistry.createRegistry(5678);
            registry.rebind("ChatService", chatServerImplementation);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new RMIChatServer();
    }

}
