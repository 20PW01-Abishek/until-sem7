import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;


class getMove extends Thread{
    private Socket client;
    private App app;
    private BufferedReader is;
    Character player;
    public getMove(Socket client, App app,Character player) throws Exception {
        this.player = player;
        this.client = client;
        this.app = app;
        this.is = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
    }

    @Override
    public void run(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String mes,turn;
            while(true) {
                System.out.println("Waiting for move2");
                mes = in.readLine();
                System.out.println(mes);
                if(mes.length() > 1){
                    app.gameStatus.setText(mes);
                    break;
                }
                if(mes==null) break;
                int pos = Integer.parseInt(mes);
                if(Character.compare(player,'X') == 0){

                    app.gameStatus.setText("Your Turn");
                    app.places[pos].setText("O");
                    System.out.println(app.makeMove);
                    app.makeMove = !app.makeMove;
                    app.setTurn(app.makeMove);
                    System.out.println(app.makeMove);
                }else{
                    app.gameStatus.setText("Your Turn");
                    app.places[pos].setText("X");
                    System.out.println(app.makeMove);
                    app.makeMove = !app.makeMove;
                    app.setTurn(app.makeMove);
                    System.out.println(app.makeMove);
                }

            }
        }catch (Exception e){
            System.out.println("Exception in getMove");
            System.out.println(e.getMessage());
        }
    }
}
class App{
    JFrame f;
    Character player;
    JButton places[];
    JLabel gameText;
    JLabel gameStatus;
    JButton playAgain;
    private PrintWriter os;
    private Socket client;
    int x,y;
    static boolean makeMove ;
    public void setTurn(boolean makeMove){
        for(int i=0;i<9;i++){
            if(places[i].getText().equals("")){
                places[i].setEnabled(makeMove);
            }
        }
    }
    public App(Socket client,Character player,String gameText) throws Exception {

        if(player=='X'){
            this.makeMove = true;
        }
        else{
            this.makeMove = false;
        }

        this.client = client;
        os = new PrintWriter(this.client.getOutputStream());

        this.x = 120;
        this.y=100;
        this.f = new JFrame();
        this.player = player;
        this.places = new JButton[9];

        for(int i=0;i<9;i++){
            UIManager.put("Button.disabledText", new ColorUIResource(Color.RED));
            places[i] = new JButton("");
            places[i].setBounds(x,y,80,80);
            places[i].setBackground(Color.WHITE);
            places[i].setForeground(Color.RED);
            places[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            places[i].setFont(new Font("Arial", Font.PLAIN, 40));
            places[i].setFocusPainted(false);
            places[i].setEnabled(makeMove);

            if(x<240){
                x+=80;
            }else{
                x = 120;
                y+=80;
            }
            f.add(places[i]);
            int pos = i;
            places[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameStatus.setText("Their Turn");
                    places[pos].setText(player.toString());
                    places[pos].setEnabled(false);
                    os.println(pos);
                    os.flush();
                    makeMove = false;
                    setTurn(makeMove);
                }
            });




        }

        this.gameText = new JLabel(gameText);
        this.gameStatus = new JLabel("hello");

        if(player=='X') {
            this.gameStatus = new JLabel("Waiting For Other Player");
        }else{
            this.gameStatus = new JLabel("Player X Turn");
        }

        this.playAgain = new JButton("Play Again");
        this.gameText.setBounds(180,10,250,40);
        this.gameStatus.setBounds(180,50,250,40);
        this.gameText.setFont(new Font("Serif", Font.PLAIN, 24));
        this.gameStatus.setFont(new Font("Serif", Font.PLAIN, 14));
        f.add(this.gameText);
        f.add(this.gameStatus);
        f.setSize(500,550);
        f.setLayout(null);
        f.setVisible(true);
    }
}

public class client {
    public static void main(String[] args) throws Exception {

        Socket client = new Socket("localhost", 8000);
        BufferedReader is =new BufferedReader(new InputStreamReader(client.getInputStream()));
        String str = is.readLine();

        char player = str.charAt(0);
        App app = new App(client,player,"You play "+player);
        System.out.println("You play "+player);
        if(Character.compare(player,'X')==0){
            System.out.println("Waiting for other player");
            app.setTurn(false);
            str = is.readLine();
            if(str.equals("start")){
                app.gameStatus.setText("Player X Turn");
                app.setTurn(true);
                Thread t = new getMove(client,app,player);
                t.start();
            }

            System.out.println(str);
        }else{
            app.gameStatus.setText("Player X Turn");
            app.setTurn(true);
            Thread t = new getMove(client,app,player);
            t.start();
        }
    }
}