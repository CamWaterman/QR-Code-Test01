package sdc.qrcodetest01;

/**
 * Created by Cameron on 10/8/2014.
 */
public class QR {

    Score x = new Score();
    boolean isScanned[] = new boolean[30];
    public QR()
    {
        int score = x.score;
        String scoreStr = Integer.toString(score);
        for(boolean i : isScanned)
        {
            i = false;
        }
    }
    public void addOne()
    {
        //check
        x.scoreOne();
    }
    public void addFive()
    {
        //check
        x.scoreFive();
    }
    public void addTen()
    {
        //check
        x.scoreTen();
    }
    public int getScore()
    {
        return x.getScore();
    }
}
