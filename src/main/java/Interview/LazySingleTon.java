package Interview;

public class LazySingleTon {
    private static  volatile LazySingleTon instance=null;
    private LazySingleTon(){};

    public static synchronized LazySingleTon getInstance() {
        if(instance==null){
            instance=new LazySingleTon();
        }
        return instance;
    }
}
