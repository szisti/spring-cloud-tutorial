package solution.steve.domain;

public class DataFormat {
    private long id;
    private int portNumber;
    private long value;

    public DataFormat() {
    }

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public DataFormat(int portNumber, long value) {

        this.portNumber = portNumber;
        this.value = value;
    }
}
