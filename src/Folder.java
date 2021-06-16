import java.util.ArrayList;

public class Folder extends StorageItem {
    ArrayList<StorageItem> items;

    public Folder(String name) {
        super(name, 0);
        items = new ArrayList<StorageItem>();
    }

    @Override
    public int getSize() {
        int sum = 0;
        for (StorageItem item : this.items) {
            sum += item.getSize();
        }
        return sum;
    }


    public boolean addItem(StorageItem item) {
        if(findItemInFolder(item.getName()) == null){
            this.items.add(item);
            return true;
        }
        return false;
    }

    private StorageItem findItemInFolder(String name){
        for (StorageItem elem : this.items) {
            if (name.equals(elem.getName()))
                return elem;
        }
        return null;
    }

    public File findFile(String path) {
        int index = path.indexOf('/');
        if (path.indexOf('/') < 0){
            return (File) findItemInFolder(path);
        }
        String subPath = path.substring(index+1);
        String subFolderName = path.substring(0,index);
        Folder subFolder =(Folder)(findItemInFolder(subFolderName));
        return subFolder.findFile(subPath);
    }
}
