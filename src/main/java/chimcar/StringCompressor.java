package chimcar;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by satrioaditya on 13/08/16.
 */
public class StringCompressor {

    private static Logger logger = LoggerFactory.getLogger(StringCompressor.class);

    public static byte[] compress(String text) throws IOException {
        logger.info("text length = "+text.getBytes().length);

        ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
        GZIPOutputStream gzipOutput = new GZIPOutputStream(byteArrayStream);

        gzipOutput.write(text.getBytes("UTF-8"));
        gzipOutput.close();

        byte[] compressed = byteArrayStream.toByteArray();
        logger.info("compressed text = "+ compressed.length);

        return compressed;

    }

    public static String decompress(byte[] byteArray) throws IOException{

        logger.info("compressed text = "+byteArray.length);

        ByteArrayInputStream byteArrayStream = new ByteArrayInputStream(byteArray);
        GZIPInputStream gzipInput = new GZIPInputStream(byteArrayStream);

        BufferedReader br = new BufferedReader(new InputStreamReader(gzipInput, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        String line;

        while((line = br.readLine()) != null){
            sb.append(line);
        }

        br.close();
        gzipInput.close();
        byteArrayStream.close();

        String decompressedString = sb.toString();
        logger.info("compressed text = "+decompressedString.length());

        return decompressedString;
    }

    public static String compressToBase64(String text) throws IOException{
        byte[] byteArray = compress(text);
        String encodedString = Base64.encode(byteArray);

        return encodedString;
    }

    public static String decompressFromBase64(String decodedString) throws IOException {
        byte[] byteArray = Base64.decoded(decodedString);
        String decompressedString = decompress(byteArray);

        return decompressedString;

    }

}
