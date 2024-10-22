package algo_BFS2;

abstract class Vehicle {
    private String name;
    abstract public String getName(String val);

    public String getName(){
        return "Vehicle name : " + name;
    }
    public void setName(String val){
        name = val;
    }
}

class Car extends Vehicle{
    private String name;
    public Car(String val){
        setName(val);
    }
    @Override
    public String getName(){
        return "Car name : " + this.name;
    }
    public String getName(String val){
        return "Car name : " + val;
    }
    public String getName(byte val[]){
        return "Car name : " + val;
    }
}

public class ex {
    public static void main(String[] args){
        Vehicle obj = new Car("spark");
        System.out.print(obj.getName());

    }
}
