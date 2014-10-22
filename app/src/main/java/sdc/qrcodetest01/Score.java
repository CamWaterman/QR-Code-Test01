package sdc.qrcodetest01;

public class Score {

    int score;

    public Score()
    {
        this.score = 0;
    }

    /**
     * Adds one to the current score
     */
    public void scoreOne(){

        this.score += 1;

    }

    /**
     * Adds five to the current score
     */
    public void scoreFive(){

        this.score += 5;

    }

    /**
     * Adds ten to the current score
     */
    public void scoreTen(){

        this.score += 10;

    }

    /**
     * Returns the current score
     */
    public int getScore(){

        return this.score;
    }

    /**
     * Sets the current score
     */
    public void setScore(int score){

        this.score = score;

    }






}
