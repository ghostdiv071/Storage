package models;

public class Provider extends Entity {

    private String name;

    public Provider() {
    }

    public Provider(String name) {
        this.name = name;
    }

    public Provider(int id, String name) {
        setId(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "id='" + id + '\'' +
                ", name=" + name +
                '}';
    }
}
