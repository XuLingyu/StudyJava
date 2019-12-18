package designpattern.structuralmode.adapter;

/**
 * @Author:xuly
 * @Date: 2019/12/12 16:27
 * @Description:
 */
public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
