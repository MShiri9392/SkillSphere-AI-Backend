package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.entity.FileResource;
import com.skillsphere.skillsphereaibackend.service.FileResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/files")
@CrossOrigin("*")
public class FileResourceController {

    @Autowired
    private FileResourceService fileService;

    @PostMapping("/upload/{userId}")
    public FileResource uploadFile(
            @PathVariable Long userId,
            @RequestParam("file") MultipartFile file) throws IOException {

        return fileService.uploadFile(userId, file);
    }

    @GetMapping
    public List<FileResource> getAllFiles() {
        return fileService.getAllFiles();
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id) throws IOException {

        Resource resource = fileService.downloadFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @DeleteMapping("/{id}")
    public String deleteFile(@PathVariable Long id) throws IOException {

        fileService.deleteFile(id);

        return "File deleted successfully";
    }
}