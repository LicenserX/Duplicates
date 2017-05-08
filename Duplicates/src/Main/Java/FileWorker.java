import java.io.*;

class FileWorker {
    public static void write(File file, String text) {

        try {
            //If file isn't exist, than create new File
            if (!file.exists()) {
                file.createNewFile();
            }
            //PrintWriter write info into the File
            try (PrintWriter out = new PrintWriter(new FileWriter(file, true))) {
                //Write text into the File
                out.write(text.toString());
                out.flush();
            }
            //Close File, otherwise File will not be write
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String read(File fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        exists(fileName);
        try {
            try (BufferedReader in = new BufferedReader(new FileReader(fileName.getAbsoluteFile()))) {

                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            }
            //Close File
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //return text from File
        return sb.toString();
    }

    private static void exists(File file) throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }

    }
}
