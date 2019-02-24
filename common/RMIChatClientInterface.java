package common;

import java.rmi.*;

public interface RMIChatClientInterface extends Remote {

    public void receive(Message messasge) throws RemoteException;
}
