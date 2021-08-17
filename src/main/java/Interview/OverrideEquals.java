package Interview;

public class OverrideEquals {

    public static void main(String[] args) {
        Person p1=new Person(11,"liufei");
        Person p2=new Person(11,"liufei");
        System.out.println(p1.equals(p1));
    }

}

class Person{
    private int age;
    private String name;
    public Person(int age , String name ){
        this.name=name;
        this.age=age;
    }

    @Override
    public boolean equals(Object obj) {
        //自反性
        if(this==obj){
            System.out.println("自己和自己当然相同");
            return true;
        }
        //非空性
        if(obj==null){
            return false;
        }
        if(!(obj instanceof Person)){
            return false;
        }
        Person person=(Person) obj;
        if(this.name==null){
            return false;
        }

        return this.name.equals(person.name) && this.age==person.age;
    }
}