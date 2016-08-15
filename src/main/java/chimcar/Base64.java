package chimcar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by satrioaditya on 14/08/16.
 */
public class Base64 {

    private static Logger logger = LoggerFactory.getLogger(Base64.class);

    public static String encode(byte[] byteArray){
        String encodedString = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray);
        logger.info("encoded String = "+encodedString.getBytes().length);
        logger.info("encoded String = "+encodedString);
        return encodedString;
    }

    public static byte[] decoded(String encodedString){
        byte[] byteArray = org.apache.commons.codec.binary.Base64.decodeBase64(encodedString);
        logger.info("decoded String = "+byteArray.length);

        return byteArray;
    }


}
