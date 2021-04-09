package com.w.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName File
 * @Description [文件类型检查]
 * @Author ANGLE0
 * @Date 2020/8/21 16:28
 * @Version V1.0
 **/
public enum FileType {
    /*
        jpeg
     */
    JPEG("FFD8FF"),
    /*
        PNG
     */
    PNG("89504E47"),
    /*
        GIF
     */
    GIF("47494638"),
    /*
        TIFF
     */
    TIFF("49492A00"),
    /*
        BIT MAP
     */
    BMP("424D"),
    /*
        CAD
     */
    DWG("41433130"),
    /*
        photoshop
     */
    PSD("38425053"),
    /*
        XML
     */
    XML("3C3F786D6C"),
    /*
        HTML
     */
    HTML("68746D6C3E"),
    /*
        Adobe Acrobat
     */
    PDF("255044462D312E"),
    /*
        ZIP Archive
     */
    ZIP("504B0304"),
    /*
        RAR Archive
     */
    RAR("52617221"),
    /*
        WAVE
     */
    WAV("57415645"),
    /*
        AVI
     */
    AVI("41564920");

    private String value = "";

    private FileType(String fileType) {
        this.value  = fileType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private static String getFileHeader(String filePath) throws IOException {
        byte[] b = new byte[28];
        InputStream inputStream = new FileInputStream(filePath);
        inputStream.read(b, 0, 28);
        inputStream.close();
//        return bytes2hex(b);
        return null;
    }

    public static FileType getFileType(String filePath) throws IOException {
        String fileHeader = getFileHeader(filePath);
        if (fileHeader == null || fileHeader.length() == 0) {
            return null;
        }
        fileHeader = fileHeader.toUpperCase();
        FileType[] values = FileType.values();
        for (FileType type : values) {
            if (fileHeader.startsWith(type.getValue())) return type;
        }
        return null;
    }
}
