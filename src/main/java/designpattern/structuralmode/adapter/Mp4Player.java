package designpattern.structuralmode.adapter;

/**
 * @Author:xuly
 * @Date: 2019/12/12 16:35
 * @Description:
 */
public class Mp4Player implements AdvancedMediaPlayer{

    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
