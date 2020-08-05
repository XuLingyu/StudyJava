package Exams.chuanglin.bolwling;

/**
 * @Author: xuly
 * @Date: 2020/8/5 13:24
 * @Description:
 */
public class Bolwling {

    private static int totalScore = 0;
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Frame[] frames = new Frame[10];

        frames[0] = new Frame(1,4,0);
        frames[1] = new Frame(4,5,0);
        frames[2] = new Frame(6,4,0);
        frames[3] = new Frame(5,5,0);
        frames[4] = new Frame(10,0,0);
        frames[5] = new Frame(0,1,0);
        frames[6] = new Frame(7,3,0);
        frames[7] = new Frame(6,4,0);
        frames[8] = new Frame(10,0,0);
        frames[9] = new Frame(2,8,6);

        for(int i = 0; i < 10; i++){
            if(i != 9){
                if(frames[i].getFirstscore() == 10){
                    totalScore += frames[i+1].getFirstscore()+10;
                    if (frames[i+1].getFirstscore() == 10 && i+2 < 10) {
                        totalScore += frames[i+2].getFirstscore();
                    } else {
                        totalScore += frames[i+1].getSecondscore();
                    }
                }
                else if(frames[i].getFirstscore()+frames[i].getSecondscore()==10){
                    totalScore += frames[i+1].getFirstscore()+10;
                }else {
                    totalScore += frames[i].getFirstscore()+frames[i].getSecondscore();
                }
            }
            else{
                totalScore += frames[i].getFirstscore()
                        +frames[i].getSecondscore()
                        +frames[i].getThiredscore();
            }
        }

        System.out.println("total score is " + totalScore);
    }
}

class Frame {

    public Frame(int firstscore,int secondscore,int thiredscore){
        this.firstscore = firstscore;
        this.secondscore = secondscore;
        this.thiredscore = thiredscore;
    }

    private int firstscore;
    private int secondscore;
    private int thiredscore = 0;

    public int getFirstscore() {
        return firstscore;
    }
    public void setFirstscore(int firstscore) {
        this.firstscore = firstscore;
    }
    public int getSecondscore() {
        return secondscore;
    }
    public void setSecondscore(int secondscore) {
        this.secondscore = secondscore;
    }
    public int getThiredscore() {
        return thiredscore;
    }
    public void setThiredscore(int thiredscore) {
        this.thiredscore = thiredscore;
    }
}
