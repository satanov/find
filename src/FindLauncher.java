import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.Option;

import java.util.List;

public class FindLauncher {
    @Option(name = "-r", usage = "поиск в поддиректориях")
    private boolean deepFind;//??

    @Option(name = "-d", required = true, usage = "директория")
    private String directory;

    @Argument(required = true, usage = "имя файла для поиска")
    private String filename;

    public static void main(String[] args) {
        new FindLauncher().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java -jar Find.jar [-r] [-d directory] filename.txt");
            parser.printUsage(System.err);
            return;
        }

        Find find = new Find();
        List<String> paths = find.find(directory, filename, deepFind);
        for (String path : paths) {
            System.out.println(path);
        }
    }
}