package com.lsh.app.mvtogif.pojo;

public class FileResponse {
    /**
     * 是否转码成功,默认成功
     */
    private boolean encode = true;
    /**
     * gif创建是否成功
     */
    private boolean gif = true;
    /**
     * 本地gif文件路径
     */
    private String gifUrl;
    /**
     * 本地视频路径
     */
    private String url;
    /**
     * 预览图本地存储路径
     */
    private String posterUrl;
    /**
     * 视频高
     */
    private Integer height = 400;
    /**
     * 视频宽
     */
    private Integer width = 300;


    public boolean isEncode() {
        return encode;
    }

    public void setEncode(boolean encode) {
        this.encode = encode;
    }

    public boolean isGif() {
        return gif;
    }

    public void setGif(boolean gif) {
        this.gif = gif;
    }

    public String getGifUrl() {
        return gifUrl;
    }

    public void setGifUrl(String gifUrl) {
        this.gifUrl = gifUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public FileResponse() {
        super();
    }
}
