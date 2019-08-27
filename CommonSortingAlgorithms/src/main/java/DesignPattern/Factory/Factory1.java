package DesignPattern.Factory;

public class Factory1 {

    public static Simple creator(int which){
        if (which == 1){
            return new SimpleA();
        } else if (which == 2){
            return new SimpleB();
        }
        return new Simple();
    }
}
