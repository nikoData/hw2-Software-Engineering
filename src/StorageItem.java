import java.util.Date;
import java.sql.Timestamp;


abstract public class StorageItem {
    protected String name;
    protected int size;
    protected long date;

    public StorageItem(String name, int size) {
        this.name = name;
        this.size = size;
        Date startDate = new Date(1970, 1, 1, 0, 0, 0);
        Date endDate = new Date(2021, 12, 31, 23, 59, 59);
        long first = startDate.getTime();
        long last = endDate.getTime();

        long result = Main.rnd.nextLong();
        result = result % (last - first) + first;       // not sure
        this.date = result;
    }

    public abstract int getSize();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getDate() {
        return date;
    }

    public boolean equal(StorageItem other) {
        return getName().equals(other.getName());
    }

    public void printTree(SortingField field) {
    }

    @Override
    public String toString() {
        Timestamp tempDate = new Timestamp(date);
        return getName() + " Size: " + getSize() + " Created: " + tempDate.toString();
    }
}
