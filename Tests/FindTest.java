import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindTest {
    @Test
    void findTest() {
        Find find0 = new Find();
        List<String> result0 = find0.find("files\\dir1", "filename.txt", true);
        assertEquals("files\\dir1\\dir2\\dir3\\filename.txt", result0.get(0));
        assertEquals("files\\dir1\\dir2\\filename.txt", result0.get(1));

        Find find1 = new Find();
        List<String> result1 = find1.find("files", "filename.txt", true);
        assertEquals("files\\dir0\\filename.txt", result1.get(0));
        assertEquals("files\\dir1\\dir2\\dir3\\filename.txt", result1.get(1));
        assertEquals("files\\dir1\\dir2\\filename.txt", result1.get(2));

        Find find2 = new Find();
        List<String> result2 = find2.find("files", "filename.txt", false);
        assertEquals("file not found", result2.get(0));

        Find find3 = new Find();
        List<String> result3 = find3.find("files", "filenam.txt", true);
        assertEquals("file not found", result3.get(0));

        Find find4 = new Find();
        List<String> result4 = find4.find("fies", "filename.txt", true);
        assertEquals("invalid directory", result4.get(0));
    }
}