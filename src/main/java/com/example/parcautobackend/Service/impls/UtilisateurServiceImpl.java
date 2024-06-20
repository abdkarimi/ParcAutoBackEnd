package com.example.parcautobackend.Service.impls;

import com.example.parcautobackend.Service.UtilisateurService;
import com.example.parcautobackend.model.entities.Utilisateur;
import com.example.parcautobackend.model.repositories.UtilisateurRepository;
import com.example.parcautobackend.utils.EmailUtil;
import com.example.parcautobackend.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import java.util.stream.Collectors;

@Service
public class UtilisateurServiceImpl implements UtilisateurService, UserDetailsService {
    @Value("${file.upload-dir}")
    private String uploadDir;
    private final UtilisateurRepository utilisateurRepository;
    private final EmailUtil emailUtil;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, JwtUtil jwtUtil, EmailUtil emailUtil, PasswordEncoder passwordEncoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.jwtUtil = jwtUtil;
        this.emailUtil = emailUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @Override
    public boolean isUtilisateurExists(Utilisateur utilisateur) {
        return utilisateurRepository.existsByMatricule(utilisateur.getMatricule()) ||
                utilisateurRepository.existsByUsername(utilisateur.getUsername()) ||
                utilisateurRepository.existsByEmail(utilisateur.getEmail());
    }

    @Override
    public Utilisateur saveUtilisateur(MultipartFile file, Utilisateur utilisateur) throws IOException {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String formattedDate = dateFormat.format(currentDate);

        // Check if the utilisateur already exists
        if (isUtilisateurExists(utilisateur)) {
            throw new RuntimeException("Un utilisateur avec le même Matricule, nom d'utilisateur ou email existe déjà.");
        }

        // Hash the password before saving the user
        String hashedPassword = passwordEncoder.encode(utilisateur.getPassword());
        utilisateur.setPassword(hashedPassword);
        utilisateur.setAccount(true);
        if (file != null && !file.isEmpty()) {
            // Create the directory if it doesn't exist
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Generate a unique filename based on original filename and current date
            String originalFilename = file.getOriginalFilename();
            String[] filenameParts = originalFilename.split("\\.");
            String fileExtension = filenameParts.length > 1 ? filenameParts[filenameParts.length - 1] : "";
            String newFilename = "image_" + formattedDate + "_" + UUID.randomUUID().toString() + "." + fileExtension;

            // Get the file path
            String filePath = uploadDir + File.separator + newFilename;
            Path destPath = Paths.get(filePath);
            // Save the file to the specified path
            Files.copy(file.getInputStream(), destPath);

            // Set the image path in the Utilisateur object
            utilisateur.setPhoto(newFilename);
        }

        // Save the utilisateur
        utilisateur = utilisateurRepository.save(utilisateur);

        // Return the saved utilisateur
        return utilisateur;
    }

    @Override
    public Utilisateur getUtilisateurByUsername(String username) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findByUsername(username);
        return optionalUtilisateur.orElse(null); // or throw exception if not found
    }

    @Override
    public Utilisateur editUtilisateur(MultipartFile file, Utilisateur utilisateur) throws IOException {
        // Check if the utilisateur with the given ID exists
        Optional<Utilisateur> existingUtilisateurOpt = utilisateurRepository.findById(utilisateur.getId());
        if (existingUtilisateurOpt.isPresent()) {
            Utilisateur existingUtilisateur = existingUtilisateurOpt.get();

            // Check for changes in Matricule, Username, and Email
            boolean isMatriculeChanged = !existingUtilisateur.getMatricule().equals(utilisateur.getMatricule());
            boolean isUsernameChanged = !existingUtilisateur.getUsername().equals(utilisateur.getUsername());
            boolean isEmailChanged = !existingUtilisateur.getEmail().equals(utilisateur.getEmail());

            // If any of the key fields are changed, check for existing users with the same fields
            if ((isMatriculeChanged && utilisateurRepository.existsByMatricule(utilisateur.getMatricule())) ||
                    (isUsernameChanged && utilisateurRepository.existsByUsername(utilisateur.getUsername())) ||
                    (isEmailChanged && utilisateurRepository.existsByEmail(utilisateur.getEmail()))) {
                throw new RuntimeException("Un utilisateur avec le même Matricule, nom d'utilisateur ou email existe déjà.");
            }

            // Update the existing utilisateur with new data if there are changes
            if (isMatriculeChanged) existingUtilisateur.setMatricule(utilisateur.getMatricule());
            if (!existingUtilisateur.getNom().equals(utilisateur.getNom())) existingUtilisateur.setNom(utilisateur.getNom());
            if (!existingUtilisateur.getPrenom().equals(utilisateur.getPrenom())) existingUtilisateur.setPrenom(utilisateur.getPrenom());
            if (isUsernameChanged) existingUtilisateur.setUsername(utilisateur.getUsername());
            if (isEmailChanged) existingUtilisateur.setEmail(utilisateur.getEmail());
            if (!existingUtilisateur.getTel().equals(utilisateur.getTel())) existingUtilisateur.setTel(utilisateur.getTel());
            if (!existingUtilisateur.getAdresse().equals(utilisateur.getAdresse())) existingUtilisateur.setAdresse(utilisateur.getAdresse());
            if (!existingUtilisateur.getDateDeNaissance().equals(utilisateur.getDateDeNaissance())) existingUtilisateur.setDateDeNaissance(utilisateur.getDateDeNaissance());
            if (!existingUtilisateur.getStructure().getIdStructure().equals(utilisateur.getStructure().getIdStructure())) existingUtilisateur.setStructure(utilisateur.getStructure());
            if (!existingUtilisateur.getIdRole().getId().equals(utilisateur.getIdRole().getId())) existingUtilisateur.setIdRole(utilisateur.getIdRole());

            // Hash the password before saving the updated user (if password is changed and not null)
            String newPassword = utilisateur.getPassword();
            if (newPassword != null && !passwordEncoder.matches(newPassword, existingUtilisateur.getPassword())) {
                String hashedPassword = passwordEncoder.encode(newPassword);
                existingUtilisateur.setPassword(hashedPassword);
            }

            if (file != null && !file.isEmpty()) {
                // If file is provided, delete the old image
                deleteOldImage(existingUtilisateur.getPhoto());

                // Save the new image
                existingUtilisateur.setPhoto(saveNewImage(file));
            }

            // Save the updated utilisateur
            utilisateurRepository.save(existingUtilisateur);

            // Return the updated utilisateur
            return existingUtilisateur;
        } else {
            // Handle the case where the utilisateur with the given ID does not exist
            throw new RuntimeException("Utilisateur with ID " + utilisateur.getId() + " does not exist.");
        }
    }

    @Override
    public Utilisateur updateUtilisateurWithoutImage(Utilisateur utilisateur) {
        Optional<Utilisateur> existingUtilisateurOpt = utilisateurRepository.findById(utilisateur.getId());
        if (existingUtilisateurOpt.isPresent()) {
            Utilisateur existingUtilisateur = existingUtilisateurOpt.get();

            // Check for changes in Matricule, Username, and Email
            boolean isMatriculeChanged = !existingUtilisateur.getMatricule().equals(utilisateur.getMatricule());
            boolean isUsernameChanged = !existingUtilisateur.getUsername().equals(utilisateur.getUsername());
            boolean isEmailChanged = !existingUtilisateur.getEmail().equals(utilisateur.getEmail());

            // If any of the key fields are changed, check for existing users with the same fields
            if ((isMatriculeChanged && utilisateurRepository.existsByMatricule(utilisateur.getMatricule())) ||
                    (isUsernameChanged && utilisateurRepository.existsByUsername(utilisateur.getUsername())) ||
                    (isEmailChanged && utilisateurRepository.existsByEmail(utilisateur.getEmail()))) {
                throw new RuntimeException("Un utilisateur avec le même Matricule, nom d'utilisateur ou email existe déjà.");
            }

            // Update the existing utilisateur with new data if there are changes
            if (isMatriculeChanged) existingUtilisateur.setMatricule(utilisateur.getMatricule());
            if (!existingUtilisateur.getNom().equals(utilisateur.getNom())) existingUtilisateur.setNom(utilisateur.getNom());
            if (!existingUtilisateur.getPrenom().equals(utilisateur.getPrenom())) existingUtilisateur.setPrenom(utilisateur.getPrenom());
            if (isUsernameChanged) existingUtilisateur.setUsername(utilisateur.getUsername());
            if (isEmailChanged) existingUtilisateur.setEmail(utilisateur.getEmail());
            if (!existingUtilisateur.getTel().equals(utilisateur.getTel())) existingUtilisateur.setTel(utilisateur.getTel());
            if (!existingUtilisateur.getAdresse().equals(utilisateur.getAdresse())) existingUtilisateur.setAdresse(utilisateur.getAdresse());
            if (!existingUtilisateur.getDateDeNaissance().equals(utilisateur.getDateDeNaissance())) existingUtilisateur.setDateDeNaissance(utilisateur.getDateDeNaissance());
            if (!existingUtilisateur.getStructure().getIdStructure().equals(utilisateur.getStructure().getIdStructure())) existingUtilisateur.setStructure(utilisateur.getStructure());
            if (!existingUtilisateur.getIdRole().getId().equals(utilisateur.getIdRole().getId())) existingUtilisateur.setIdRole(utilisateur.getIdRole());

            // Hash the password before saving the updated user (if password is changed and not null)
            String newPassword = utilisateur.getPassword();
            if (newPassword != null && !passwordEncoder.matches(newPassword, existingUtilisateur.getPassword())) {
                String hashedPassword = passwordEncoder.encode(newPassword);
                existingUtilisateur.setPassword(hashedPassword);
            }

            // Save the updated utilisateur
            utilisateurRepository.save(existingUtilisateur);

            // Return the updated utilisateur
            return existingUtilisateur;
        } else {
            // Handle the case where the utilisateur with the given ID does not exist
            throw new RuntimeException("Utilisateur with ID " + utilisateur.getId() + " does not exist.");
        }
    }

    @Override
    public void deleteUtilisateur(Long id) {
        Optional<Utilisateur> existingUtilisateur = utilisateurRepository.findById(id);
        if (existingUtilisateur.isPresent()) {
            Utilisateur currentUtilisateur = existingUtilisateur.get();

            currentUtilisateur.setAccount(false);
            // Save the updated utilisateur
            utilisateurRepository.save(currentUtilisateur);
        } else {
            // Handle the case where the utilisateur with the given ID does not exist
            throw new RuntimeException("Utilisateur with ID " + id + " does not exist.");
        }
        // utilisateurRepository.deleteById(id);
    }

    @Override
    public Utilisateur getUtilisateurById(Long id) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
        return optionalUtilisateur.orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return utilisateurRepository.findByUsernameAndAccountIsTrue(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    private void deleteOldImage(String imageName) {
        if (imageName != null && !imageName.isEmpty()) {
            // Construct old image file path
            String oldImagePath = uploadDir + File.separator + imageName;
            // Delete the old image file
            File oldImageFile = new File(oldImagePath);
            oldImageFile.delete();
        }
    }

    private String saveNewImage(MultipartFile file) throws IOException {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String formattedDate = dateFormat.format(currentDate);

        // Generate a unique filename based on original filename and current date
        String originalFilename = file.getOriginalFilename();
        String[] filenameParts = originalFilename.split("\\.");
        String fileExtension = filenameParts.length > 1 ? filenameParts[filenameParts.length - 1] : "";
        String newFilename = "image_" + formattedDate + "_" + UUID.randomUUID().toString() + "." + fileExtension;

        // Get the file path
        String filePath = uploadDir + File.separator + newFilename;
        Path destPath = Paths.get(filePath);
        // Save the file to the specified path
        Files.copy(file.getInputStream(), destPath);

        return newFilename;
    }
}
