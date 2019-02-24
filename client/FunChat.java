package client;

import common.RMIChatServerInterface;
import common.User;
import java.rmi.RemoteException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FunChat extends Application {

    RMIChatServerInterface serverInterface;
    Connection connection;
    FXMLLoader loader;
    User user;

    public FunChat() {
        connection = new Connection();
        connection.getConnection();
    }

    /*Start Yasmin*/
    @Override
    public void start(Stage stage) throws Exception {
        RegistController registController = new RegistController(stage, connection.serverInterface, connection.clientInterface);

        loader = new FXMLLoader();
        loader.setController(registController);
        Parent regist = loader.load(getClass().getResource("Regist.fxml").openStream());

        Scene scene = new Scene(regist);
        scene.getStylesheets().add(getClass().getResource("style.css").toString());
        stage.setScene(scene);
        stage.setOnCloseRequest((event) -> {
            event.consume();
            try {
                connection.serverInterface.unRegister(connection.clientInterface);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
            System.exit(0);
        });
        stage.setTitle("Fun Chat");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
