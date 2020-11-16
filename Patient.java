
public class Patient {
    String name, dob, gender, bld, height, weight;
    int age;

    Patient(String n, String a, String d, String g, String h, String w, String b) {
        this.name = n;
        this.age = Integer.parseInt(a);
        this.dob = d;
        this.gender = g;
        this.height = h;
        this.weight = w;
        this.bld = b;
    }

    @Override
    public String toString() {
        String res = "<html><h3>Welcome!</h3> <br> " + name + "<br>" + "Date : " + height + "<br>" + "Time : " + weight
                + "<br>" + "<br></html>";
        return res;
    }
}