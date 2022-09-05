package SanjaValley.Persuance.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import SanjaValley.Persuance.Helper.CSVHelper;
import SanjaValley.Persuance.Repository.CSVUploadDataRepository;
import SanjaValley.Persuance.entity.CSVUploadData;

@Service
public class CSVService {
  @Autowired
  CSVUploadDataRepository csvUploadDataRepository;

  public void save(MultipartFile file) {
    try {
      List<CSVUploadData> csvUploadData = CSVHelper.csvToUploadedData(file.getInputStream());
      csvUploadDataRepository.saveAll(csvUploadData);
    } catch(IOException e) {
      throw new RuntimeException("Failed to store csv data: " + e.getMessage());
    }
  }

  public List<CSVUploadData> getAllCSVUploadData() {
    return csvUploadDataRepository.findAll();
  }
}
