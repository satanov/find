import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Find {
    private boolean fileIsFounded = false;
    private List<String> paths = new ArrayList<>();
    private int level = 0;

    private List<String> searching(String directory, String filename, boolean deepFind) {
        File f = new File(directory);
        if (!f.exists()) {
            paths.add("invalid directory");
            return paths;
        }
        String[] list = f.list();
        assert list != null;
        for (String piece : list) {
            File pieceFile = new File(directory, piece);
            if (pieceFile.isFile()) {
                if (!filename.equals(piece)) continue;
                fileIsFounded = true;
                paths.add(directory + "\\" + filename);
            }
            if (pieceFile.isDirectory() && deepFind) {
                level++;
                searching(directory + "\\" + piece, filename, true);
                level--;
            }
        }
        if (level != 0 || fileIsFounded) return paths;
        else {
            paths.add("file not found");
            return paths;
        }
    }

    public List<String> find(String directory, String filename, boolean deepFind) {
        return searching(directory, filename, deepFind);
    }
}