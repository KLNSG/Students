package domain;

public class Something {
    private String name;;
    private Integer minage;
    private Integer maxage;
    private String gender;

    public Something() {
    }

    public Something(String name, Integer minage, Integer maxage, String gender) {
        this.name=name;
        this.minage = minage;
        this.maxage = maxage;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinage() {
        return minage;
    }

    public void setMinage(Integer minage) {
        this.minage = minage;
    }

    public Integer getMaxage() {
        return maxage;
    }

    public void setMaxage(Integer maxage) {
        this.maxage = maxage;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
