/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author 16221
 */
public class UploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory(10 * 1024, new File("e:/temp"));

            ServletFileUpload upload = new ServletFileUpload(factory);

            upload.setHeaderEncoding("utf-8");

            List<FileItem> list = upload.parseRequest(request);

            if (list != null) {
                //FileEntity fileEntity = null;

                for (FileItem item : list) {

                    if (!item.isFormField()) {
                        String uuid = UUID.randomUUID().toString();
                        String fileName = item.getName();

                        fileName = uuid + fileName.substring(fileName.lastIndexOf("."));

                        // String baseDir = "e:/photo";
                        // String baseDir = this.getServletContext().getRealPath("/upload");
                        String baseDir = "E:/Netbeanscode/Upload2018-6-5/web/uploadimages";

                        String subDir = makeDirectory(fileName);

                        String finalDir = baseDir + "/" + subDir;

                        FileUtils.copyInputStreamToFile(item.getInputStream(), new File(finalDir + fileName));

                        item.delete();
                        String realpath = baseDir + "/" + subDir + fileName;
                        System.out.println("the realpath is "+realpath);
                        
                        
                    }

                    // fileEntity.setFile_path(relativ);
                }
            }

        } catch (FileUploadException ex) {
            Logger.getLogger(UploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private String makeDirectory(String fileName) {
        int code = fileName.hashCode();

        int first = code & 0xF;

        int second = code & (0xF >> 1);
        return first + "/" + second + "/";
    }

}
