package com.poly.lab5.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ParamService {

    @Autowired
    HttpServletRequest request;

    // ------------------- LẤY DỮ LIỆU FORM -------------------
    public String getString(String name, String defaultValue) {
        String value = request.getParameter(name);
        return (value != null) ? value : defaultValue;
    }

    public int getInt(String name, int defaultValue) {
        try {
            return Integer.parseInt(request.getParameter(name));
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public double getDouble(String name, double defaultValue) {
        try {
            return Double.parseDouble(request.getParameter(name));
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public boolean getBoolean(String name, boolean defaultValue) {
        String value = request.getParameter(name);
        if (value == null) return defaultValue;
        return Boolean.parseBoolean(value);
    }

    public Date getDate(String name, String pattern) {
        try {
            String value = request.getParameter(name);
            if (value == null) return null;
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // ------------------- LƯU FILE  -------------------
    public String save(MultipartFile file, String path) {
        if (file.isEmpty()) return null;

        try {
            // Lưu vào thư mục resources/uploads/
            String realPath = new File("src/main/resources/static/uploads/").getAbsolutePath();
            File dir = new File(realPath);
            if (!dir.exists()) dir.mkdirs();

            File savedFile = new File(dir, file.getOriginalFilename());
            file.transferTo(savedFile);

            return file.getOriginalFilename();
        } catch (IOException e) {
            throw new RuntimeException("Lỗi lưu file: " + e.getMessage(), e);
        }
    }
}
