package chimcar;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by satrioaditya on 13/08/16.
 */
public class QrGenerator {

    public QrGenerator(){}

    public QrGenerator(String text, String fileName) throws IOException {

        ByteArrayOutputStream outputStream = QRCode.from(text).to(ImageType.JPG)
                .withSize(300,300)
                .withColor(0xFFFF0000, 0xFFFFFFAA)
                .stream();

        FileOutputStream fileOutputStream = new FileOutputStream(new File("/home/satrioaditya/Pictures/"+fileName+".JPG"));

        outputStream.writeTo(fileOutputStream);
        fileOutputStream.close();
        outputStream.close();

    }


}
