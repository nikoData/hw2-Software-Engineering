import java.util.Date;

public class File extends StorageItem {
    String fileType;
    StringBuilder content;

    public File(String name, String fileType) {
        super(name, 0);
        this.fileType = fileType;
        this.content = new StringBuilder();
    }

    @Override
    public int getSize() {
        return super.size;
    }

    @Override
    public String getName() {
        return super.getName() + "." + this.fileType;
    }

    public void addContent(String s) {
        this.content.append(s);
    }

    public void printContent() {

        System.out.println(toString());
    }

    @Override
    public String toString() {
         return super.toString() + "\n" + content.toString();
    }
}
