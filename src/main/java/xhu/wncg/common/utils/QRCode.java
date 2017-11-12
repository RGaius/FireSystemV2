package xhu.wncg.common.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.UUID;

/**
 * 二维码工具类
 *
 * @author BZhao
 * @version 2017/11/12.
 */
public class QRCode {
    /**
     * 生成二维码
     *
     * @param imgPath 图片存储位置
     * @param content 二维码内容
     * @return 图片保存地址
     */
    public static String createQRCode(String imgPath, String content) throws WriterException, IOException {
        //图像宽度
        int width = 200;
        //图像高度
        int height = 200;
        //图片格式
        String format = "png";

        //通过UUID随机生成文件名
        String fileName = UUID.randomUUID().toString().substring(0, 8) + "." + format;

        HashMap<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        //设置边框
        hints.put(EncodeHintType.MARGIN, 1);

        //生成矩阵
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);

        Path path = FileSystems.getDefault().getPath(imgPath, fileName);

        // 输出图像
        MatrixToImageWriter.writeToPath(bitMatrix, format, path);

        return imgPath + fileName;
    }
}
