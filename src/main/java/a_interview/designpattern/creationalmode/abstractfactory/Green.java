package a_interview.designpattern.creationalmode.abstractfactory;

public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
