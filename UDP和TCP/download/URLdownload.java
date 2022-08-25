package src.download;

import javax.net.ssl.HttpsURLConnection;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLdownload {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://m801.music.126.net/20220824224552/3d70f313c4ce578df862184e02e3e349/jdyyaac/obj/w5rDlsOJwrLDjj7CmsOj/14096421831/f20b/4732/99fc/35587ff72a513a0adf718b4e68e79f95.m4a");

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("ms.m4a");

        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes))!=-1){
//            System.out.println(len);
            fileOutputStream.write(bytes,0,len);
        }

        fileOutputStream.close();
        inputStream.close();
        urlConnection.disconnect();
    }
}
