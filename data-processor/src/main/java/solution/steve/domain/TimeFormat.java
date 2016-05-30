package solution.steve.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.DateTime;

public class TimeFormat {
    private long id;
    private int portNumber;
    private DateTime value;

    public TimeFormat() {
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

    public String getValue() {
        return value.toDateTimeISO().toString();
    }

    public void setValue(DateTime value) {
        this.value = value;
    }

    public TimeFormat(int portNumber, DateTime value) {
        this.portNumber = portNumber;
        this.value = value;
    }

    public TimeFormat(int portNumber, long value) {

        this.portNumber = portNumber;
        this.value = new DateTime(value);
    }

    public TimeFormat(DataFormat dataFormat) {
        this.id = dataFormat.getId();
        this.portNumber = dataFormat.getPortNumber();
        this.value = new DateTime(dataFormat.getValue());
    }

    @Override
    public String toString() {
        return "Added @ " + value +
                " by " + portNumber;
    }
}
