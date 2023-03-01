package com.lsh.app.mvtogif;

import com.lsh.app.mvtogif.frame.MainFrame;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.awt.*;

@SpringBootApplication
public class MvtogifApplication {

    public static void main(String[] args) {
        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
        try {
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        SpringApplication.run(MvtogifApplication.class, args);
        ConfigurableApplicationContext run = new SpringApplicationBuilder(MvtogifApplication.class)
                .headless(false).run(args);
        EventQueue.invokeLater(() -> {
            MainFrame main = run.getBean(MainFrame.class);
            main.setTitle("视频转GIF");
            main.setVisible(true);
        });
    }

}
