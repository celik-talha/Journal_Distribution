package code;
import java.io.Serial;
import java.io.Serializable;
public class DateInfo implements Serializable{
    private int startMonth, startYear, endMonth;
    @Serial
    private static final long serialVersionUID = 1L;

    public DateInfo(int startMonth, int startYear, int endMonth){
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.endMonth = endMonth;
    }

    public int getStartMonth() {
        return startMonth;
    }
    public int getStartYear() {
        return startYear;
    }
    public int getEndMonth() {
        return endMonth;
    }
}
