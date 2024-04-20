package upb.sgttp.rmiTest;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloWithName extends Remote{

    String sayHello() throws RemoteException;
    void setName(String name) throws RemoteException;

}
