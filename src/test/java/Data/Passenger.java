package Data;

public class Passenger {
    String name;
    String age;
    String passportNo;

    public Passenger(String name, String age, String passportNo){
        this.name = name;
        this.age = age;
        this.passportNo = passportNo;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getPassportNo() {
        return passportNo;
    }
}
