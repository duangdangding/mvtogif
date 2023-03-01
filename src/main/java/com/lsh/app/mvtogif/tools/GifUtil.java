package com.lsh.app.mvtogif.tools;

import com.lsh.app.mvtogif.pojo.FileResponse;
import com.madgag.gif.fmsware.AnimatedGifEncoder;
import org.bytedeco.javacv.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;

/**
 * gif工具类
 */
public class GifUtil {
    // 每截取一次跳过多少帧
    private static Integer DEFAULT_MARGIN = 2;
    //    帧频率
    private static Integer DEFAULT_FRAME_RATE = 10;

    /**
     * 转换成Gif
     * @param filePath 视频文件
     * @param startFrame 开始帧
     * @param frameCount 截取帧数
     * @param frameRate 帧频率
     * @param margin 每截取一次跳过多少帧
     * @param tarPath 保存的位置
     */
    public static FileResponse buileGif(String filePath,int startFrame,int frameCount,
                                Integer frameRate,Integer margin,String tarPath) throws FileNotFoundException, FrameGrabber.Exception {
        FileResponse file = new FileResponse();
        if (margin == null) {
            margin = DEFAULT_MARGIN;
        }
        if (frameRate == null) {
            frameRate = DEFAULT_FRAME_RATE;
        }
        String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
        String gifName = fileName.substring(0, fileName.indexOf(".")) + ".gif";
        String gifPath = tarPath + File.separator + gifName;
//        写文件
        FileOutputStream outputStream = new FileOutputStream(gifPath);
//        读取文件
        FFmpegFrameGrabber ff = new FFmpegFrameGrabber(filePath);
        Java2DFrameConverter converter = new Java2DFrameConverter();
        AnimatedGifEncoder en = new AnimatedGifEncoder();
        en.setRepeat(0);
        ff.start();
        try {
            int videoLen = ff.getLengthInFrames();
//        如果用户上传的视频时间很短，不符合自己定义的帧数取值区间，重新设置区间
            /*if (startFrame > videoLen || (startFrame + frameCount * margin) > videoLen) {
                startFrame = videoLen / 5;
                frameCount = (videoLen - startFrame - 5) / margin;
            }*/

//            ff.setFrameNumber(startFrame);
//            en.setFrameRate(frameRate);
            en.start(outputStream);
            // 预览图、当前未生成
//            boolean poster = false;
            for (int i = 0; i < frameCount; i++) {
                // BufferedImage image = (BufferedImage)
                // converter.convert(ff.grabFrame()).getScaledInstance(300, 400,
                // Image.SCALE_DEFAULT);
                // log.info("图片质量压缩");
                // 截取一帧,确保截取的当前帧存在图片！
                /*if (!poster) {
                    Frame f = ff.grabFrame();
                    if (f != null) {
                        // 图片宽高即为视频宽高
                        file.setHeight(f.imageHeight);
                        file.setWidth(f.imageWidth);
//                        File filePicture = new File(
//                                filePath.substring(0, filePath.lastIndexOf(".")) + ",jpg");
                        // 获取图片信息
                        BufferedImage image = (BufferedImage) converter.getBufferedImage(f);
                        BufferedImage bi = new BufferedImage(file.getWidth(), file.getHeight(),
                                BufferedImage.TYPE_3BYTE_BGR);
                        bi.getGraphics().drawImage(
                                image.getScaledInstance(file.getWidth(), file.getHeight(), image.SCALE_DEFAULT), 0, 0,
                                null);
                        // 生成视频预览图
//                        ImageIO.write(image, "jpg", filePicture);
                        poster = true;
//                        file.setPosterUrl(filePicture.getPath());
                    }
                }*/
                en.addFrame(converter.convert(ff.grabFrame()));
                // log.info("取帧位置[{}],参数[{}]", frameCount, ff.grabFrame());
//                ff.setFrameNumber(ff.getFrameNumber() + margin);
                // log.info("设置下一帧位置:[{}]", ff.getFrameNumber());
            }
            en.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ff.stop();
            ff.close();
        }
        file.setGifUrl(gifPath);
        return file;
    }

    public static void main(String[] args) {
        String video = "C:\\Users\\Administrator\\Desktop\\Video_2021-02-06_190411.wmv";
        try {
            buileGif(video,3,40,9,1,"C:\\Users\\Administrator\\Desktop\\");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (FrameGrabber.Exception e) {
            e.printStackTrace();
        }
    }
}
