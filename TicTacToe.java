import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    private JLabel textFieldLabel;
    JPanel rpanel = new JPanel();
    JButton resButton = new JButton();


    TicTacToe(){
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(0, 153, 0));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setTitle("Tic-Tac-Toe Game");

        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(0, 255, 51));
        textfield.setFont(new Font("Monocraft", Font.PLAIN, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(0, 0, 0));

        rpanel.setLayout(new BorderLayout());
        resButton.setText("Reset");
        resButton.setSize(100, 50);
        resButton.addActionListener(this);

        for(int i =0; i<9; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Monocraft", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        rpanel.add(resButton);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel, BorderLayout.CENTER);
        frame.add(rpanel, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == resButton) {
            frame.remove(button_panel);
            button_panel = new JPanel();
            button_panel.setLayout(new BorderLayout());
            button_panel.setLayout(new GridLayout(3, 3));
            button_panel.setBackground(new Color(0, 0, 0));
            frame.add(button_panel, BorderLayout.CENTER);

            for (int i = 0; i < 9; i++) {
                buttons[i] = new JButton();
                button_panel.add(buttons[i]);
                buttons[i].setFont(new Font("Monocraft", Font.BOLD, 120));

                buttons[i].addActionListener(this);
            }
            if (random.nextInt(2) == 0) {
                // int is 2 for the two players
                player1_turn = true;
                textfield.setText("X turn");
            } else {
                player1_turn = false;
                textfield.setText("O turn");
            }

            SwingUtilities.updateComponentTreeUI(frame);
        }
    

        
        for(int i=0; i<9;i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn=false;
                        textfield.setText("O turn");
                        check();
                    }
                }
                else {
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textfield.setText("X turn");
                        check();
                        
                }
                
                
            }
            for (int x=0 ; x<9 ; x++) {
                // if 1 of 9 button texts is blank
                if (buttons[x].getText().isBlank()) {
                    // the tie condition is not satisfied .
                    break ;
                }
                // if both 9 button texts are not blank .
                if (x == 8) {
                    // game finishes .
                    // the text color of buttons will be disabled as well so they will turn gray .
                    disableButtons() ;
                    resultLabel() ;
                    textFieldLabel.setText("Tie") ;
                }
            }
            

        }
        
        
    }

    

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    private void resultLabel() {
    }

    public void firstTurn(){
        
        
        disableButtons();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } enableButtons();

        if(random.nextInt(2)==0){
            player1_turn = true;
            textfield.setText("X turn");
        }
        else{
                player1_turn = false;
                textfield.setText("O turn");

        }
    }

    public void check(){
        int i =0;
        while(!Objects.equals(buttons[i].getText(), "")) {
        if(i == buttons.length -1) {
        draw();
        break;
        }
        i++;
        }

        if(
            (buttons[0].getText()=="X")&&
            (buttons[1].getText()=="X")&&
            (buttons[2].getText()=="X")){
                xWins(0,1,2);
        }
        if(
            (buttons[3].getText()=="X")&&
            (buttons[4].getText()=="X")&&
            (buttons[5].getText()=="X")){
                xWins(3,4,5);
        }
        if(
            (buttons[6].getText()=="X")&&
            (buttons[7].getText()=="X")&&
            (buttons[8].getText()=="X")){
                xWins(6,7,8);
        }
        if(
            (buttons[0].getText()=="X")&&
            (buttons[3].getText()=="X")&&
            (buttons[6].getText()=="X")){
                xWins(0,3,6);
        }
        if(
            (buttons[1].getText()=="X")&&
            (buttons[4].getText()=="X")&&
            (buttons[7].getText()=="X")){
                xWins(1,4,7);
        }
        if(
            (buttons[2].getText()=="X")&&
            (buttons[5].getText()=="X")&&
            (buttons[8].getText()=="X")){
                xWins(2,5,8);
        }
        if(
            (buttons[0].getText()=="X")&&
            (buttons[4].getText()=="X")&&
            (buttons[8].getText()=="X")){
                xWins(0,4,8);
        }
        if(
            (buttons[2].getText()=="X")&&
            (buttons[4].getText()=="X")&&
            (buttons[6].getText()=="X")){
                xWins(2,4,6);
        }
                if(
            (buttons[0].getText()=="X")&&
            (buttons[1].getText()=="X")&&
            (buttons[2].getText()=="X")){
                xWins(0,1,2);
        }
        if(
            (buttons[3].getText()=="X")&&
            (buttons[4].getText()=="X")&&
            (buttons[5].getText()=="X")){
                xWins(3,4,5);
        }
        if(
            (buttons[6].getText()=="X")&&
            (buttons[7].getText()=="X")&&
            (buttons[8].getText()=="X")){
                xWins(6,7,8);
        }
        if(
            (buttons[0].getText()=="X")&&
            (buttons[3].getText()=="X")&&
            (buttons[6].getText()=="X")){
                xWins(0,3,6);
        }
        if(
            (buttons[1].getText()=="X")&&
            (buttons[4].getText()=="X")&&
            (buttons[7].getText()=="X")){
                xWins(1,4,7);
        }
        if(
            (buttons[2].getText()=="X")&&
            (buttons[5].getText()=="X")&&
            (buttons[8].getText()=="X")){
                xWins(2,5,8);
        }
        if(
            (buttons[0].getText()=="X")&&
            (buttons[4].getText()=="X")&&
            (buttons[8].getText()=="X")){
                xWins(0,4,8);
        }
        if(
            (buttons[2].getText()=="X")&&
            (buttons[4].getText()=="X")&&
            (buttons[6].getText()=="X")){
                xWins(2,4,6);
        }
        //check O conditions
        if(
            (buttons[0].getText()=="O")&&
            (buttons[1].getText()=="O")&&
            (buttons[2].getText()=="O")){
                oWins(0,1,2);
        }
        if(
            (buttons[3].getText()=="O")&&
            (buttons[4].getText()=="O")&&
            (buttons[5].getText()=="O")){
                oWins(3,4,5);
        }
        if(
            (buttons[6].getText()=="O")&&
            (buttons[7].getText()=="O")&&
            (buttons[8].getText()=="O")){
                oWins(6,7,8);
        }
        if(
            (buttons[0].getText()=="O")&&
            (buttons[3].getText()=="O")&&
            (buttons[6].getText()=="O")){
                oWins(0,3,6);
        }
        if(
            (buttons[1].getText()=="O")&&
            (buttons[4].getText()=="O")&&
            (buttons[7].getText()=="O")){
                oWins(1,4,7);
        }
        if(
            (buttons[2].getText()=="O")&&
            (buttons[5].getText()=="O")&&
            (buttons[8].getText()=="O")){
                oWins(2,5,8);
        }
        if(
            (buttons[0].getText()=="O")&&
            (buttons[4].getText()=="O")&&
            (buttons[8].getText()=="O")){
                oWins(0,4,8);
        }
        if(
            (buttons[2].getText()=="O")&&
            (buttons[4].getText()=="O")&&
            (buttons[6].getText()=="O")){
                oWins(2,4,6);

                
        } 
    }
    
    public void disableButtons() {
        for (int b=0 ; b<9 ; b++) {
            buttons[b].setEnabled(false) ;
        }
    }
    public void enableButtons() {
        for (int b=0 ; b<9 ; b++) {
            buttons[b].setEnabled(true) ;
        }
    }
    
    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins!");

    }
    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins!");

        
    }
    public void draw() {
        for(JButton button : buttons) {
        button.setEnabled(false);
        }
        textfield.setText("Game is a draw");
        }
        
        
        
    
    
    
    
}