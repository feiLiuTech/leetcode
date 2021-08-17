package Interview;

import java.util.HashMap;

public class HangrySingleTon {
    private static final HangrySingleTon instance=new HangrySingleTon();
    private HangrySingleTon(){};
    public static HangrySingleTon getInstance() {
        return instance;
    }
}
