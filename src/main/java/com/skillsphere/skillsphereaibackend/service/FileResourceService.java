package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.entity.FileResource;
import com.skillsphere.skillsphereaibackend.entity.User;
import com.skillsphere.skillsphereaibackend.exception.ResourceNotFoundException;
import com.skillsphere.skillsphereaibackend.repository.FileResourceRepository;
import com.skillsphere.skillsphereaibackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FileResourceService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Autowired
    private FileResourceRepository fileRepository;

    @Autowired
    private UserRepository userRepository;

    public FileResource uploadFile(Long userId, MultipartFile file) throws IOException {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        Path filePath = uploadPath.resolve(fileName);

        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        FileResource fileResource = new FileResource();
        fileResource.setFileName(fileName);
        fileResource.setFileType(file.getContentType());
        fileResource.setFileSize(file.getSize());
        fileResource.setFilePath(filePath.toString());
        fileResource.setUploadedAt(LocalDateTime.now());
        fileResource.setUser(user);

        return fileRepository.save(fileResource);
    }

    public List<FileResource> getAllFiles() {
        return fileRepository.findAll();
    }

    public Resource downloadFile(Long id) throws MalformedURLException {

        FileResource file = fileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("File not found"));

        Path path = Paths.get(file.getFilePath());

        return new UrlResource(path.toUri());
    }

    public void deleteFile(Long id) throws IOException {

        FileResource file = fileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("File not found"));

        Files.deleteIfExists(Paths.get(file.getFilePath()));

        fileRepository.delete(file);
    }
}