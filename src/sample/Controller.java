package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;
import javafx.scene.shape.Sphere;
import javafx.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;



public class Controller {

    static Socket socket;
    static DataInputStream fromServer;
    static DataOutputStream toServer;
    private static final int PORTNUMBER = 7777;
    private static final String ADDRESS = "localhost";
    private String win;
    private String loss;
    private String wordToGuess;
    private int livesLeft;
    private Boolean gameOver;

    @FXML
    private Button connectServerButton;

    @FXML
    private Line rightArm;

    @FXML
    private Line leftLeg;

    @FXML
    private Sphere hangmanHead;

    @FXML
    private Label winLabel;

    @FXML
    private Label lossLabel;

    @FXML
    private Line leftArm;

    @FXML
    private Sphere rightHand;

    @FXML
    private Sphere rightFoot;

    @FXML
    private Line hangmanSpine;

    @FXML
    private Label wordGuessLabel;

    @FXML
    private Button a;

    @FXML
    private Button b;

    @FXML
    private Button c;

    @FXML
    private Button d;

    @FXML
    private Button e;

    @FXML
    private Button f;

    @FXML
    private Button g;

    @FXML
    private Button h;

    @FXML
    private Button i;

    @FXML
    private Button j;

    @FXML
    private Button k;

    @FXML
    private Button l;

    @FXML
    private Button m;

    @FXML
    private Button n;

    @FXML
    private Button o;

    @FXML
    private Button p;

    @FXML
    private Button q;

    @FXML
    private Sphere leftHand;

    @FXML
    private Button r;

    @FXML
    private Button s;

    @FXML
    private Sphere leftFoot;

    @FXML
    private Button t;

    @FXML
    private Line rightLeg;

    @FXML
    private Button u;

    @FXML
    private Button v;

    @FXML
    private Button w;

    @FXML
    private Button x;

    @FXML
    private Button y;

    @FXML
    private Button z;

    @FXML
    private Button quitGameButton;

    @FXML
    private Button newGameButton;


    @FXML
    void sendLetter(ActionEvent event) throws Exception{

        if (event.getSource() == a) {
//            System.out.println("A");
            toServer.writeUTF("A");
            toServer.flush();
            a.setDisable(true);
        }
        else if (event.getSource() == b){
//            System.out.println("B");
            toServer.writeUTF("B");
            toServer.flush();
            b.setDisable(true);
        }
        else if (event.getSource() == c){
//            System.out.println("C");
            toServer.writeUTF("C");
            toServer.flush();
            c.setDisable(true);
        }
        else if (event.getSource() == d){
//            System.out.println("D");
            toServer.writeUTF("D");
            toServer.flush();
            d.setDisable(true);
        }
        else if (event.getSource() == e){
//            System.out.println("E");
            toServer.writeUTF("E");
            toServer.flush();
            e.setDisable(true);
        }
        else if (event.getSource() == f){
//            System.out.println("F");
            toServer.writeUTF("F");
            toServer.flush();
            f.setDisable(true);
        }
        else if (event.getSource() == g){
//            System.out.println("G");
            toServer.writeUTF("G");
            toServer.flush();
            g.setDisable(true);
        }
        else if (event.getSource() == h){
//            System.out.println("H");
            toServer.writeUTF("H");
            toServer.flush();
            h.setDisable(true);
        }
        else if (event.getSource() == i){
//            System.out.println("I");
            toServer.writeUTF("I");
            toServer.flush();
            i.setDisable(true);
        }
        else if (event.getSource() == j){
//            System.out.println("J");
            toServer.writeUTF("J");
            toServer.flush();
            j.setDisable(true);
        }
        else if (event.getSource() == k){
//            System.out.println("K");
            toServer.writeUTF("K");
            toServer.flush();
            k.setDisable(true);
        }
        else if (event.getSource() == l){
//            System.out.println("L");
            toServer.writeUTF("L");
            toServer.flush();
            l.setDisable(true);
        }
        else if (event.getSource() == m){
//            System.out.println("M");
            toServer.writeUTF("M");
            toServer.flush();
            m.setDisable(true);
        }
        else if (event.getSource() == n){
//            System.out.println("N");
            toServer.writeUTF("N");
            toServer.flush();
            n.setDisable(true);
        }
        else if (event.getSource() == o){
//            System.out.println("O");
            toServer.writeUTF("O");
            toServer.flush();
            o.setDisable(true);
        }
        else if (event.getSource() == p){
//            System.out.println("P");
            toServer.writeUTF("P");
            toServer.flush();
            p.setDisable(true);
        }
        else if (event.getSource() == q){
//            System.out.println("Q");
            toServer.writeUTF("Q");
            toServer.flush();
            q.setDisable(true);
        }
        else if (event.getSource() == r){
//            System.out.println("R");
            toServer.writeUTF("R");
            toServer.flush();
            r.setDisable(true);
        }
        else if (event.getSource() == s){
//            System.out.println("S");
            toServer.writeUTF("S");
            toServer.flush();
            s.setDisable(true);
        }
        else if (event.getSource() == t){
//            System.out.println("T");
            toServer.writeUTF("T");
            toServer.flush();
            t.setDisable(true);
        }
        else if (event.getSource() == u){
//            System.out.println("U");
            toServer.writeUTF("U");
            toServer.flush();
            u.setDisable(true);
        }
        else if (event.getSource() == v){
//            System.out.println("V");
            toServer.writeUTF("V");
            toServer.flush();
            v.setDisable(true);
        }
        else if (event.getSource() == w){
//            System.out.println("W");
            toServer.writeUTF("W");
            toServer.flush();
            w.setDisable(true);
        }
        else if (event.getSource() == x){
            //System.out.println("X");
            toServer.writeUTF("X");
            toServer.flush();
            x.setDisable(true);
        }
        else if (event.getSource() == y){
            //System.out.println("Y");
            toServer.writeUTF("Y");
            toServer.flush();
            y.setDisable(true);
        }else if (event.getSource() == z){
            //System.out.println("Z");
            toServer.writeUTF("Z");
            toServer.flush();
            z.setDisable(true);
        }

        //System.out.println(fromServer.readInt());
        showHangman(10 - fromServer.readInt());

        wordGuessLabel.setAlignment(Pos.CENTER);
        //System.out.println(fromServer.readUTF());
        wordGuessLabel.setText(fromServer.readUTF());

        win = fromServer.readUTF();
        winLabel.setText(win);
        System.out.println(win);
        loss = fromServer.readUTF();
        lossLabel.setText(loss);
        System.out.println(loss);
        gameOver = fromServer.readBoolean();
        System.out.println(gameOver);

        if (gameOver){
            //System.out.println("new game true");
            showHangman(10 - fromServer.readInt());
            //System.out.println("hangman changed");
            wordGuessLabel.setAlignment(Pos.CENTER);
            wordGuessLabel.setText(fromServer.readUTF());
            //System.out.println("guess word recorded");
            for (int i = 0;i>1000;i++){}
            resetLetters();
            gameOver = false;
        }

    }

    @FXML
    void quitGame(ActionEvent event) throws IOException {
        System.out.println("Quit Clicked");
        fromServer.close();
        toServer.close();
        socket.close();
        Platform.exit();

    }

    @FXML
    void newGame(ActionEvent event) throws IOException {
        System.out.println("New Game Clicked");
        newGameButton.setDisable(true);
        toServer.writeBoolean(true);
        toServer.flush();
        System.out.println("new game true");
        showHangman(10 - fromServer.readInt());
        System.out.println("hangman changed");
        wordGuessLabel.setAlignment(Pos.CENTER);
        wordGuessLabel.setText(fromServer.readUTF());
        System.out.println("guess word recorded");

        resetLetters();
    }

    @FXML
    void connectServer(ActionEvent event) throws Exception{

        //connect to server with localhost/127.0.0.1 and port 7777
        if (event.getSource() == connectServerButton){

            socket = new Socket(ADDRESS, PORTNUMBER);
//            System.out.println("Connection Successful");
            //variables to talk with server
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
//            System.out.println("Good to go");
            connectServerButton.setDisable(true);
            newGameButton.setDisable(false);
        }


    }


    void showHangman(int lives) throws IOException {
        livesLeft = lives;
        switch (lives){

            case 10:    hangmanHead.setVisible(false);
                        hangmanSpine.setVisible(false);
                        leftArm.setVisible(false);
                        leftFoot.setVisible(false);
                        leftHand.setVisible(false);
                        leftLeg.setVisible(false);
                        rightArm.setVisible(false);
                        rightFoot.setVisible(false);
                        rightHand.setVisible(false);
                        rightLeg.setVisible(false);
                        break;
            case 9:     hangmanHead.setVisible(true);
                        hangmanSpine.setVisible(false);
                        leftArm.setVisible(false);
                        leftFoot.setVisible(false);
                        leftHand.setVisible(false);
                        leftLeg.setVisible(false);
                        rightArm.setVisible(false);
                        rightFoot.setVisible(false);
                        rightHand.setVisible(false);
                        rightLeg.setVisible(false);
                        break;
            case 8:     hangmanHead.setVisible(true);
                        hangmanSpine.setVisible(true);
                        leftArm.setVisible(false);
                        leftFoot.setVisible(false);
                        leftHand.setVisible(false);
                        leftLeg.setVisible(false);
                        rightArm.setVisible(false);
                        rightFoot.setVisible(false);
                        rightHand.setVisible(false);
                        rightLeg.setVisible(false);
                        break;
            case 7:     hangmanHead.setVisible(true);
                        hangmanSpine.setVisible(true);
                        leftArm.setVisible(true);
                        leftFoot.setVisible(false);
                        leftHand.setVisible(false);
                        leftLeg.setVisible(false);
                        rightArm.setVisible(false);
                        rightFoot.setVisible(false);
                        rightHand.setVisible(false);
                        rightLeg.setVisible(false);
                        break;
            case 6:     hangmanHead.setVisible(true);
                        hangmanSpine.setVisible(true);
                        leftArm.setVisible(true);
                        leftFoot.setVisible(false);
                        leftHand.setVisible(false);
                        leftLeg.setVisible(false);
                        rightArm.setVisible(true);
                        rightFoot.setVisible(false);
                        rightHand.setVisible(false);
                        rightLeg.setVisible(false);
                        break;
            case 5:     hangmanHead.setVisible(true);
                        hangmanSpine.setVisible(true);
                        leftArm.setVisible(true);
                        leftFoot.setVisible(false);
                        leftHand.setVisible(true);
                        leftLeg.setVisible(false);
                        rightArm.setVisible(true);
                        rightFoot.setVisible(false);
                        rightHand.setVisible(false);
                        rightLeg.setVisible(false);
                        break;
            case 4:     hangmanHead.setVisible(true);
                        hangmanSpine.setVisible(true);
                        leftArm.setVisible(true);
                        leftFoot.setVisible(false);
                        leftHand.setVisible(true);
                        leftLeg.setVisible(false);
                        rightArm.setVisible(true);
                        rightFoot.setVisible(false);
                        rightHand.setVisible(true);
                        rightLeg.setVisible(false);
                        break;
            case 3:     hangmanHead.setVisible(true);
                        hangmanSpine.setVisible(true);
                        leftArm.setVisible(true);
                        leftFoot.setVisible(false);
                        leftHand.setVisible(true);
                        leftLeg.setVisible(true);
                        rightArm.setVisible(true);
                        rightFoot.setVisible(false);
                        rightHand.setVisible(true);
                        rightLeg.setVisible(false);
                        break;
            case 2:     hangmanHead.setVisible(true);
                        hangmanSpine.setVisible(true);
                        leftArm.setVisible(true);
                        leftFoot.setVisible(false);
                        leftHand.setVisible(true);
                        leftLeg.setVisible(true);
                        rightArm.setVisible(true);
                        rightFoot.setVisible(false);
                        rightHand.setVisible(true);
                        rightLeg.setVisible(true);
                        break;
            case 1:     hangmanHead.setVisible(true);
                        hangmanSpine.setVisible(true);
                        leftArm.setVisible(true);
                        leftFoot.setVisible(true);
                        leftHand.setVisible(true);
                        leftLeg.setVisible(true);
                        rightArm.setVisible(true);
                        rightFoot.setVisible(false);
                        rightHand.setVisible(true);
                        rightLeg.setVisible(true);
                        break;
            case 0:     hangmanHead.setVisible(true);
                        hangmanSpine.setVisible(true);
                        leftArm.setVisible(true);
                        leftFoot.setVisible(true);
                        leftHand.setVisible(true);
                        leftLeg.setVisible(true);
                        rightArm.setVisible(true);
                        rightFoot.setVisible(true);
                        rightHand.setVisible(true);
                        rightLeg.setVisible(true);
                        break;
            default:
                        break;
        }

    }


    void resetLetters(){


        a.setDisable(false);
        b.setDisable(false);
        c.setDisable(false);
        d.setDisable(false);
        e.setDisable(false);
        f.setDisable(false);
        g.setDisable(false);
        h.setDisable(false);
        i.setDisable(false);
        j.setDisable(false);
        k.setDisable(false);
        l.setDisable(false);
        m.setDisable(false);
        n.setDisable(false);
        o.setDisable(false);
        p.setDisable(false);
        q.setDisable(false);
        r.setDisable(false);
        s.setDisable(false);
        t.setDisable(false);
        u.setDisable(false);
        v.setDisable(false);
        w.setDisable(false);
        x.setDisable(false);
        y.setDisable(false);
        z.setDisable(false);
//        System.out.println("Letters reset");
    }



}

