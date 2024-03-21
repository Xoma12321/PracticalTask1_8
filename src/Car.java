public class Car {
    private String marka;
    private int year;
    private String gosnomer;

    public Car() {
    }

    public Car(String marka, int year, String gosnomer) {
        this.marka = marka;
        this.year = year;
        this.gosnomer = gosnomer;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGosnomer() {
        return gosnomer;
    }

    public void setGosnomer(String gosnomer) {
        this.gosnomer = gosnomer;
    }
}
