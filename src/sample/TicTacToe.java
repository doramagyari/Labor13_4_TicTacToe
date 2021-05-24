package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Cell;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    private char player = 'X';
    private Cell[][] cell = new Cell[3][3];
    private Label status = new Label("X must play");

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane pane = new GridPane();
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                cell[i][j] = new Cell();
                pane.add(cell[i][j], j, i);
            }
        }
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(status);

        Scene scene = new Scene(borderPane, 450, 300);
        primaryStage.setTitle("TIC-TAC-TOE");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public boolean isBoardFull(){
        for(int i=0; i< 3; i++){
            for(int j=0; j<3; j++){
                if(cell[i][j].getPlayer()== ' '){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWon(char player){
        for(int i=0; i<3; i++){
            if(cell[i][0].getPlayer() == player && cell[i][1].getPlayer == player && cell[i][2] == player){
                return true;
            }
        }

        for(int i=0; i<3; i++){
            if(cell[0][i].getPlayer() == player && cell[1][i] == player && cell[2][i] == player){
                return true;
            }

        if(cell[0][0].getPlayer() == player && cell[1][1] == player && cell[2][2] == player){
                    return true;
           }

        if(cell[0][2].getPlayer() == player && cell[1][1] == player && cell[2][0] == player){
            return true;
        }
        return false;
    }

    class Cell extends Pane {
           private char player = ' ';

           public Cell() {
               setStyle("-fx-border-color : black");
               this.setPrefSize(300, 300);
           }

        public char getPlayer() {
            return player;
        }

        public void setPlayer(char player) {
            this.player = player;
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
