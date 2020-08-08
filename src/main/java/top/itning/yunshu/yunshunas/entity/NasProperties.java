package top.itning.yunshu.yunshunas.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Email 配置
 *
 * @author itning
 */
@ConfigurationProperties(prefix = "nas")
@Component
public class NasProperties {
    /**
     * 文件输出目录
     */
    private String outDir;
    /**
     * ffmpeg bin 目录
     */
    private String ffmpegBinDir;
    /**
     * aria2c文件
     */
    private String aria2cFile;

    /**
     * 允许显示的路径
     */
    private String showDir;

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    public String getShowDir() {
        return showDir;
    }

    public void setShowDir(String showDir) {
        this.showDir = showDir;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOutDir() {
        return outDir;
    }

    public void setOutDir(String outDir) {
        this.outDir = outDir;
    }

    public String getFfmpegBinDir() {
        return ffmpegBinDir;
    }

    public void setFfmpegBinDir(String ffmpegBinDir) {
        this.ffmpegBinDir = ffmpegBinDir;
    }

    public String getAria2cFile() {
        return aria2cFile;
    }

    public void setAria2cFile(String aria2cFile) {
        this.aria2cFile = aria2cFile;
    }
}
