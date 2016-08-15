package chimcar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        System.out.println("running apps...");

        try {
            String longStringToCompress = "{\"name\":\"Product\",\"properties\":{\"id\":{\"type\":\"number\",\"description\":\"Product identifier\",\"required\":true},\"name\":{\"description\":\"Name of the product\",\"type\":\"string\",\"required\":true},\"price\":{\"type\":\"number\",\"minimum\":0,\"required\":true},\"tags\":{\"type\":\"array\",\"items\":{\"type\":\"string\"}}},\"name\":\"ProductA\",\"properties\":{\"id\":{\"type\":\"number\",\"description\":\"Product identifier\",\"required\":true},\"name\":{\"description\":\"Name of the product\",\"type\":\"string\",\"required\":true},\"price\":{\"type\":\"number\",\"minimum\":0,\"required\":true},\"tags\":{\"type\":\"array\",\"items\":{\"type\":\"string\"}}},\"name\":\"ProductC\",\"properties\":{\"id\":{\"type\":\"number\",\"description\":\"Product identifier\",\"required\":true},\"name\":{\"description\":\"Name of the product\",\"type\":\"string\",\"required\":true},\"price\":{\"type\":\"number\",\"minimum\":0,\"required\":true},\"tags\":{\"type\":\"array\",\"items\":{\"type\":\"string\"}}}}";

//            byte[] compressedByte = StringCompressor.compress(longStringToCompress);
//            String decompressedString = StringCompressor.decompress(compressedByte);
//            System.out.println(decompressedString);

            //process to create QR
            //1. compress the string, return value is base64
            String compressedString = StringCompressor.compressToBase64(longStringToCompress);
            //2. as base64 string, generate QR code from it
            QrGenerator qrGenerator = new QrGenerator(compressedString, "sample1");

            //process from QR to String
            String decompressedString = StringCompressor.decompressFromBase64(compressedString);
            System.out.println(decompressedString);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
