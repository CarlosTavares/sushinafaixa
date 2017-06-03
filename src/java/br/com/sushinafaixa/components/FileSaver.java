/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.components;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Carlos.Tavares
 */
@Component
public class FileSaver {

    @Autowired
    private HttpServletRequest request;

    public String write(String baseFolder, MultipartFile file) {
        String realPath = request.getServletContext()
                .getRealPath("/" + baseFolder);
        try {
            String path
                    = realPath + "/" + file.getOriginalFilename();
            File realFile = new File(path);
            FileUtils.writeByteArrayToFile(realFile, file.getBytes());
            return baseFolder + "/" + file.getOriginalFilename();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
