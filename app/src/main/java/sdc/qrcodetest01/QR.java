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
    public void addOne(int numId)
    {
        isScanned[numId] = true;
        x.scoreOne();
    }
    public void addFive(int numId)
    {
        isScanned[numId] = true;
        x.scoreFive();
    }
    public void addTen(int numId)
    {
        isScanned[numId] = true;
        x.scoreTen();
    }
    public int getScore()
    {
        return x.getScore();
    }

    public void toBooleanArrray(String booleans)
    {
        char[] dumb = new char[30];
        dumb = booleans.toCharArray();
        for(int i=0; i<booleans.length(); i++)
        {
            if(dumb[i]=='f')
                isScanned[i] = false;
            else
                isScanned[i] = true;
        }
    }

    public String saveData()
    {
        String data = "";

        for(boolean n : isScanned)
        {
            if(n)
                data+="t";
            else
                data+="f";
        }

        return data;
    }
}
