import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class ProcessingFile {
    private final TreeMap<String, Integer> c = new TreeMap<>();

    public TreeMap<String, Integer> startProcessing(File inputFileName) throws FileNotFoundException {
        String input = FileWorker.read(inputFileName);
        String[] afterSplit = input.split("\n");
        for (int i = 0; i <= afterSplit.length - 1; i++) {
            String r = afterSplit[i];
            Integer freq = c.get(r);
            c.put(r, freq == null ? 1 : freq + 1);
        }
        return c;
    }

    public String toString() {
        Iterator<Map.Entry<String, Integer>> i = c.entrySet().iterator();
        if (!i.hasNext())
            return "Source file wasn't found!";

        StringBuilder sb = new StringBuilder();
        for (; ; ) {
            Map.Entry<String, Integer> e = i.next();
            String key = e.getKey();
            Integer value = e.getValue();
            sb.append(key);
            sb.append(' ');
            sb.append('[');
            sb.append(value);
            sb.append(']');
            sb.append(' ');
            sb.append('\n');
            if (!i.hasNext())
                return sb.append('\n').toString();
        }
    }

}
