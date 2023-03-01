package com.lsh.app.mvtogif.tools;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * 创建CronTrigger
 * CronTrigger实例可以通过TriggerBuilder（配置主要属性）和CronScheduleBuilder（配置CronTrigger专有的属性）配置。
 * 为了以DSL风格使用这些builder，需要静态导入：下面这3个
 */

/**
 * @Description:
 * @author: LuShao
 * @create: 2020-07-15 14:16
 **/
public class SwingUtil {
	public static final JFileChooser JFILE=new JFileChooser();

	/**
	 * 选择文件或者文件夹
	 * @param model
	 * @return
	 */
	public static int openF(int model) {
		// 1设定只能选择到文件夹 0只能选择文件
		JFILE.setFileSelectionMode(model);
		// 此句是打开文件选择器的触发语句
		return JFILE.showOpenDialog(null);
	}

}
