import java.io.*;
import java.util.*;

public class Needle {
    public static int count(String needle, InputStream haystack) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(haystack));
        int res = 0;
        while(r.ready()) {
           if  (r.readLine().contains(needle)) res++;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        String inMessage = "Hello, there!\nHow are you today?\nYes, you over there.";

        try(InputStream inStream = new ByteArrayInputStream(inMessage.getBytes())) {
            System.out.println(Needle.count("there", inStream));
        }
    }
}
