package client;

import common.RMIChatClientInterface;
import common.RMIChatServerInterface;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Connection {

    RMIChatClientInterface clientInterface;
    RMIChatServerInterface serverInterface;
    Registry registry;

    /*Start Yasmin*/
    public void getConnection() {
        try {
            clientInterface = new RMIChatClientImplementation();
            registry = LocateRegistry.getRegistry("127.0.0.1", 5678);
            serverInterface = (RMIChatServerInterface) registry.lookup("ChatService");
            serverInterface.register(clientInterface);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        } catch (NotBoundException ex) {
            ex.printStackTrace();
        }
    }

}
