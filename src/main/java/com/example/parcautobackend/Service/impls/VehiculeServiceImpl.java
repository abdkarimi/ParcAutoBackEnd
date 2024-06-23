package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.model.entities.Utilisateur;
import com.example.parcautobackend.model.entities.Vehicule;
import com.example.parcautobackend.model.repositories.VehiculeRepository;
import com.example.parcautobackend.Service.VehiculeService;
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
public class VehiculeServiceImpl implements VehiculeService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Override
    public Vehicule saveVehicule(MultipartFile file, Vehicule vehicule) throws IOException {
        if (file != null && !file.isEmpty()) {
            String fileName = saveFile(file);
            vehicule.setPhotoVehicule(fileName);
        }
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Optional<Vehicule> getVehiculeById(Long id) {
        return vehiculeRepository.findById(id);
    }

    @Override
    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule updateVehicule(Long id, MultipartFile file, Vehicule vehicule) throws IOException {
        if (vehiculeRepository.existsById(id)) {
            if (file != null && !file.isEmpty()) {
                Vehicule existingVehicule = vehiculeRepository.findById(id).orElseThrow();
                deleteOldFile(existingVehicule.getPhotoVehicule());
                String fileName = saveFile(file);
                vehicule.setPhotoVehicule(fileName);
            }
            vehicule.setIdVehicule(id);
            return vehiculeRepository.save(vehicule);
        }
        return null;
    }

    @Override
    public Vehicule updateVehiculeWithoutImage(Vehicule vehicule) {
        Optional<Vehicule> existingVehiculeOpt = vehiculeRepository.findById(vehicule.getIdVehicule());
        if (existingVehiculeOpt.isPresent()) {
            Vehicule existingVehicule = existingVehiculeOpt.get();
            vehicule.setPhotoVehicule(existingVehicule.getPhotoVehicule());
            if (vehiculeRepository.existsById(vehicule.getIdVehicule())) {
                return vehiculeRepository.save(vehicule);
            }
        }

        return null;
    }

    @Override
    public void deleteVehicule(Long id) {
        vehiculeRepository.deleteById(id);
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
