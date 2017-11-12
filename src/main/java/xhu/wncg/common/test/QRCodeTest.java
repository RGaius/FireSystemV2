package xhu.wncg.common.test;

import com.google.zxing.WriterException;
import xhu.wncg.common.utils.QRCode;

import java.io.IOException;

/**
 * @author BZhao
 * @version 2017/11/12.
 */
public class QRCodeTest {
    public static void main(String[] args) throws IOException, WriterException {
        QRCode.createQRCode("D://", "http://kesun-shy.iteye.com/blog/2154169");
    }
}
