import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Session extends Thread{
    private Socket[] players;
    private char[] board;

    private static int[][] winning_pos = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};

    public Session(Socket p1, Socket p2){
        this.players = new Socket[2];
        this.players[0] = p1;
        this.players[1] = p2;
        this.board = new char[9];
        Arrays.fill(this.board, '-');
    }

    public void send(PrintWriter p, String mes){
        p.println(mes);
        p.flush();
    }

    public boolean winCheck(){
        for(int[] w : winning_pos){
            if(board[w[0]-1]=='X' && board[w[1]-1]=='X' && board[w[2]-1]=='X'){
                return true;
            }
            if(board[w[0]-1]=='O' && board[w[1]-1]=='O' && board[w[2]-1]=='O'){
                return true;
            }
        }
        return false;
    }

    public void run(){
        try {
            PrintWriter[] pw = new PrintWriter[2];
            BufferedReader[] r = new BufferedReader[2];
            pw[0] = new PrintWriter(players[0].getOutputStream());
            pw[1] = new PrintWriter(players[1].getOutputStream());

            r[0] = new BufferedReader(new InputStreamReader(players[0].getInputStream()));
            r[1] = new BufferedReader(new InputStreamReader(players[1].getInputStream()));

            char[] symbol = {'X', 'O'};
            int turn = 0;

            while(true){
                System.out.println("Turn: "+symbol[turn]);
                int pos = Integer.parseInt(r[turn].readLine());
                System.out.println(pos);
                board[pos] = symbol[turn];
                send(pw[1-turn], Integer.toString(pos));

                if(winCheck()){
                    send(pw[turn], "You WIN");
                    send(pw[1-turn], "They WIN, You LOSE!");
                }
                else{
                    turn = 1-turn;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8000);
        while (true){
            Socket s = server.accept();
            PrintWriter out = new PrintWriter(s.getOutputStream());
            System.out.println("Player 1 joined");
            out.println("X");
            out.flush();

            Socket s1 = server.accept();
            PrintWriter out1 = new PrintWriter(s1.getOutputStream());
            System.out.println("Player 2 joined");
            out1.println("O");
            out1.flush();
            out.println("start");
            out.flush();
            new Session(s, s1).start();
            System.out.println("New Session Started");
        }
    }
}