package common;

import java.rmi.*;

public interface RMIChatServerInterface extends Remote {

    public void brodcast(Message messasge) throws RemoteException;

    public void register(RMIChatClientInterface client) throws RemoteException;

    public void unRegister(RMIChatClientInterface client) throws RemoteException;
}
