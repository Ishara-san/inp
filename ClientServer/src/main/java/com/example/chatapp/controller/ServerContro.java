package com.example.chatapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ServerContro implements Initializable {
    @FXML
    private TextField txtMg;

    @FXML
    private TextArea txtMessageArea;

    @FXML
    private Button btnSend;

    private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new Thread(()->{

            try {
                serverSocket = new ServerSocket(5000);
                txtMessageArea.appendText("Server Started!\n");

                socket = serverSocket.accept();
                txtMessageArea.appendText("\nClient Connected...!!!\n");

                while (true){
                    dataInputStream = new DataInputStream(socket.getInputStream());
                    txtMessageArea.appendText("\n" + dataInputStream.readUTF() + "\n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }).start();
    }


    @FXML
    void sendMessage(ActionEvent event) throws IOException {
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF(txtMg.getText());
        dataOutputStream.flush();

        txtMessageArea.appendText(txtMg.getText());
    }
}