public class Student extends User{
    private String name;
    private String majar;
    private String phone;

    public Student(String major, String phone){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajar() {
        return majar;
    }

    public void setMajar(String majar) {
        this.majar = majar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
