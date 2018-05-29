import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTest {
    @Test
    void findTest() {
        Find find1 = new Find();
        find1.find("files", "filename.txt", true);
        Find find2 = new Find();
        find2.find("files", "filename.txt", false);
        Find find3 = new Find();
        find3.find("files", "filenam.txt", true);
        Find find4 = new Find();
        find4.find("fies", "filename.txt", true);
    }

}