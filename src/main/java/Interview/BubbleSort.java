package Interview;

public class BubbleSort {
    public static <T extends Comparable<T>> T[] bubblesort(T [] nums){
        if(nums==null || nums.length==0){
            return null;
        }
        boolean flag=false;
        for(int i=nums.length-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(nums[j].compareTo(nums[j+1])>0){
                    //出现逆序
                    T temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                    flag=true;
                }
            }
            if(!flag){
                break;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Integer [] numsint=new Integer[]{3,2,1,6,9,8};
        numsint=BubbleSort.bubblesort(numsint);
        for(int i=0;i<numsint.length;i++){
            System.out.print(numsint[i]+" ");
        }
        System.out.print("\n");

        Float [] numsfloat=new Float[]{1.3f,3.2f,1.2f,9.8f};
        numsfloat=BubbleSort.bubblesort(numsfloat);
        for(int i=0;i<numsfloat.length;i++){
            System.out.print(numsfloat[i]+" ");
        }
        System.out.print("\n");

        Person [] numsPerson=new Person[]{new Person(12,"aa"),new Person(13,"bb"),new Person(11,"cc")};
        numsPerson=BubbleSort.bubblesort(numsPerson);

        for(int i=0;i<numsPerson.length;i++){
            System.out.println("姓名："+numsPerson[i].getName()+" 年龄："+numsPerson[i].getAge());
        }
    }

    static class  Person implements Comparable<Person>{
        private  int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            return this.age-o.age;
        }
    }
}
