package com.web.chat.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mimeType;

    @Lob
    private byte[] data;


}
//
//@RestController
//public class ImageController {
//
//    @Autowired
//    private ImageRepository imageRepository;
//
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
//        try {
//            Image image = new Image();
//            image.setName(file.getOriginalFilename());
//            image.setMimeType(file.getContentType());
//            image.setData(file.getBytes());
//            imageRepository.save(image);
//            return ResponseEntity.ok("Image uploaded successfully!");
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image.");
//        }
//    }
//
//    @GetMapping("/images/{id}")
//    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
//        Optional<Image> optionalImage = imageRepository.findById(id);
//        if (optionalImage.isPresent()) {
//            Image image = optionalImage.get();
//            return ResponseEntity.ok()
//                    .contentType(MediaType.parseMediaType(image.getMimeType()))
//                    .body(image.getData());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
//@Repository
//public interface ImageRepository extends JpaRepository<Image, Long> {
//
//}
