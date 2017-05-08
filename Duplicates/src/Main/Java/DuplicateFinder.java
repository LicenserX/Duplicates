import java.io.File;
import java.io.FileNotFoundException;

class DuplicateFinder {
    private final ProcessingFile pf = new ProcessingFile();

    public static void main(String[] args) {
        File inputFileName = new File("1.txt").getAbsoluteFile();
        File outFileName = new File("2.txt").getAbsoluteFile();
        CreateFile cf = new CreateFile();
        cf.createNewFile(inputFileName);
        DuplicateFinder d = new DuplicateFinder();
        d.process(inputFileName, outFileName);
    }

    private void process(File inputFileName, File outFileName) {
        try {
            pf.startProcessing(inputFileName);
        } catch (FileNotFoundException e) {
            System.out.println("false");
            return;
        }
        FileWorker.write(outFileName, pf.toString());
        System.out.println("true");
    }
}
