package framework;

import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonFunctions {

    private static long fileSizeOnUrl;

    public static String getRegexMatch(String text, String regex, int matcherGroup) {
        Pattern r = Pattern.compile(regex);
        Matcher m = r.matcher(text);
        if(m.find()) return m.group(matcherGroup);
        return "";
    }

    public static void getSizeFileWithURL(String urlFile) {
            try {
                URL url = new URL(urlFile);
                URLConnection conn = url.openConnection();
                fileSizeOnUrl = conn.getContentLength();
                conn.getInputStream().close();
            } catch (Exception e){
                e.fillInStackTrace();
            }
        }

    public static long getSizeFileOnComDirectory(String pathToDirectory, String nameFle){
            File file = new File(pathToDirectory + nameFle);
            return file.length();
    }

    public static long getFileSizeOnUrl() {
        return fileSizeOnUrl;
    }
}

