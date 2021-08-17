package Interview;

public class DoubleCheakSingleTon {
    private static DoubleCheakSingleTon instance=null;
    private DoubleCheakSingleTon(){};

    public static DoubleCheakSingleTon getInstance() {
        if(instance==null){
            synchronized(DoubleCheakSingleTon.class) {
                if(instance==null){
                    instance=new DoubleCheakSingleTon();
                }
            }

        }
        return instance;
    }
}
