package code;
import java.io.Serial;
import java.io.Serializable;

public abstract class Subscriber implements Serializable{
    protected String name;
    protected String address;
    @Serial
    private static final long serialVersionUID = 1L;

    public Subscriber(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public abstract String getBillingInformation();

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
