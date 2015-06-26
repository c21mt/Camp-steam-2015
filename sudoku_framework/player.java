import java.util.Scanner;

public class Player{
    Board board;
    int rowMove;
    int colMove;
    int valMove;



    public Player(Board board){
        this.board = board;
    }

    public int getRowMove(){
        return this.rowMove;
    }

    public int getColMove(){
        return this.colMove;
    }

    public int getValMove(){
        return this.valMove;
    }


    private void checkRow(int row,int col){

        int j = 0;
        Tile t;
        while (j<9){
            t = board.getTileAt(j, col);
            if(t.getState() == State.PERMANENT || t.getState() == State.FILLED) {
                int value = t.getValue();
                board.getTileAt(row,col).crossOut(value);
            }
            j=j+1;
        }


    }

    private void checkCol(int row,int col){

        int k = 0;
        Tile t;
        while (k <9){
            t = board.getTileAt(row, k);
            if(t.getState() == State.PERMANENT || t.getState() == State.FILLED) {
                int value = t.getValue();
                board.getTileAt(row,col).crossOut(value);
            }
            k=k+1;
        }

    }


    private void checkBox(int row, int col){
        Tile t;
        int box = board.getBoxFromRowCol(row,col);
        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 9; ++j){
                if(box != board.getBoxFromRowCol(i,j)){
                    continue;
                }
                t = board.getTileAt(i,j);
                if(t.getState() == State.PERMANENT || t.getState() == State.FILLED){
                    board.getTileAt(row,col).crossOut(t.getValue());
                }
            }
        }   
    }

    private void checkBox2(int row,int col){

        //box 1
        if(col<=2 && row <=2){	
            int s = 0;
            while (s <= 2){
                int h = 0;
                while(h <=2){

                    int value = board.getTileAt(s,h).getValue();
                    board.getTileAt(row,col).crossOut(value);
                    h=h+1;
                }
                s=s+1;	
            }	
        }
        //box 2
        else if(col<=5 && row <=2){	
            int s = 0;
            while (s <= 2){
                int h = 2;
                while(h <=5){

                    int value = board.getTileAt(s,h).getValue();
                    board.getTileAt(row,col).crossOut(value);

                    h=h+1;
                }

                s=s+1;
            }	
        }
        //box 3
        else if(col<=8 && row <=2){	
            int s = 0;
            while (s <= 2){
                int h = 5;
                while(h <=8){

                    int value = board.getTileAt(s,h).getValue();
                    board.getTileAt(row,col).crossOut(value);

                    h=h+1;
                }

                s=s+1;
            }	
        }
        //box 4
        else if(col<=2 && row <=5){	
            int s = 2;
            while (s <= 5){
                int h = 0;
                while(h <=2){

                    int value = board.getTileAt(s,h).getValue();
                    board.getTileAt(row,col).crossOut(value);

                    h=h+1;
                }

                s=s+1;	
            }	
        }

        //box 5
        else if(col<=2 && row <=8){	
            int s = 5;
            while (s <= 8){
                int h = 0;
                while(h <=2){

                    int value = board.getTileAt(s,h).getValue();
                    board.getTileAt(row,col).crossOut(value);

                    h=h+1;
                }

                s=s+1;
            }	
        }
        //box 6
        else if(col<=5 && row <=5){	
            int s = 2;
            while (s <= 5){
                int h = 2;
                while(h <=5){

                    int value = board.getTileAt(s,h).getValue();
                    board.getTileAt(row,col).crossOut(value);

                    h=h+1;
                }

                s=s+1;
            }	
        }
        //box 7
        else if(col<=8 && row <=5){	
            int s = 2;
            while (s <= 5){
                int h = 5;
                while(h <=8){

                    int value = board.getTileAt(s,h).getValue();
                    board.getTileAt(row,col).crossOut(value);

                    h=h+1;
                }

                s=s+1;	
            }	
        }
        //box
        else if(col<=5 && row <=8){	
            int s = 5;
            while (s <= 8){
                int h = 2;
                while(h <=5){

                    int value = board.getTileAt(s,h).getValue();
                    board.getTileAt(row,col).crossOut(value);

                    h=h+1;
                }

                s=s+1;	
            }	
        }

        else if(col<=8 && row <=8){	
            int s = 5;
            while (s <= 8){
                int h = 5;
                while(h <=8){

                    int value = board.getTileAt(s,h).getValue();
                    board.getTileAt(row,col).crossOut(value);

                    h=h+1;
                }

                s=s+1;
            }	
        }
    }

    public void getMoveFromUser(){
    Scanner scan = new Scanner(System.in);
        rowMove = scan.nextInt();
        colMove = scan.nextInt();
        valMove = scan.nextInt();
    }


    public void computeMove(){
        int c = 0;
        while(c<9){
            int r = 0;
            while(r<9){
                Tile t = board.getTileAt(r,c);
                if(t.getState() == State.EMPTY){
                    checkRow(r, c);
                    checkCol(r,c);
                    checkBox(r,c);
                    int [] moves = t.getAvailableMoves();
                    int numAvailable = moves.length;
                    if(numAvailable == 1){
                        rowMove = r;
                        colMove = c;
                        valMove = moves[0];
                    }
                }
                r = r+1;
            }		
            c=c+1;
        }

    }
}
