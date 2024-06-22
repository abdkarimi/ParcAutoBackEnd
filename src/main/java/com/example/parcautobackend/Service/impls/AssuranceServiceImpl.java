package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.model.entities.Assurance;
import com.example.parcautobackend.model.repositories.AssuranceRepository;
import com.example.parcautobackend.Service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AssuranceServiceImpl implements AssuranceService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Autowired
    private AssuranceRepository assuranceRepository;

    @Override
    public Assurance saveAssurance(MultipartFile file, Assurance assurance) throws IOException {
        if (file != null && !file.isEmpty()) {
            String fileName = saveFile(file);
            assurance.setCheminPolice(fileName);
        }
        return assuranceRepository.save(assurance);
    }

    @Override
    public Optional<Assurance> getAssuranceById(Long id) {
        return assuranceRepository.findById(id);
    }

    @Override
    public List<Assurance> getAllAssurances() {
        return assuranceRepository.findAll();
    }

    @Override
    public Assurance updateAssurance(Long id, MultipartFile file, Assurance assurance) throws IOException {
        if (assuranceRepository.existsById(id)) {
            if (file != null && !file.isEmpty()) {
                Assurance existingAssurance = assuranceRepository.findById(id).orElseThrow();
                deleteOldFile(existingAssurance.getCheminPolice());
                String fileName = saveFile(file);
                assurance.setCheminPolice(fileName);
            }
            assurance.setIdAssurance(id);
            return assuranceRepository.save(assurance);
        }
        return null;
    }

    @Override
    public void deleteAssurance(Long id) {
        assuranceRepository.deleteById(id);
    }

    private String saveFile(MultipartFile file) throws IOException {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String formattedDate = dateFormat.format(currentDate);

        String originalFilename = file.getOriginalFilename();
        String[] filenameParts = originalFilename.split("\\.");
        String fileExtension = filenameParts.length > 1 ? filenameParts[filenameParts.length - 1] : "";
        String newFilename = "file_" + formattedDate + "_" + UUID.randomUUID().toString() + "." + fileExtension;

        String filePath = uploadDir + File.separator + newFilename;
        Path destPath = Paths.get(filePath);
        Files.copy(file.getInputStream(), destPath);

        return newFilename;
    }

    private void deleteOldFile(String fileName) {
        if (fileName != null && !fileName.isEmpty()) {
            String oldFilePath = uploadDir + File.separator + fileName;
            File oldFile = new File(oldFilePath);
            oldFile.delete();
        }
    }
}
