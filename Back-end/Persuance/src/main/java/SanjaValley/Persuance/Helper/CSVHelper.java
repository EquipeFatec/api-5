package SanjaValley.Persuance.Helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import SanjaValley.Persuance.Entity.CSVUploadData;

public class CSVHelper {
  public static String TYPE = "text/csv";
  public static boolean hasCSVFormat(MultipartFile file) {
      return TYPE.equals(file.getContentType());
  }
  public static List<CSVUploadData> csvToUploadedData(InputStream is) {
    try (
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            CSVParser csvParser = new CSVParser(
        fileReader,
        CSVFormat.EXCEL.withDelimiter(';').withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()
      )
    ) {
      List<CSVUploadData> uploadedData = new ArrayList<CSVUploadData>();
      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
      for (CSVRecord csvRecord : csvRecords) {
        String palavra = csvRecord.get("palavra");
        String conjugacao = csvRecord.get("conjugacao");
        String tradução = csvRecord.get("tradução");
        String aprovada = csvRecord.get("aprovada");
        String significadoAlternativa = csvRecord.get("significadoAlternativa");
        String exemploAprovado = csvRecord.get("exemploAprovado");
        String classeGramatical = csvRecord.get("classeGramatical");
        String categoriaNomesTecnicos = csvRecord.get("categoriaNomesTecnicos");

        CSVUploadData csvUploadData = new CSVUploadData(palavra, conjugacao, tradução, aprovada, significadoAlternativa, exemploAprovado, classeGramatical, categoriaNomesTecnicos);
      
        uploadedData.add(csvUploadData);
      }
      return uploadedData;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  private static Date parseDateFromString(String stringDate) {
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    try {
      Date date = format.parse(stringDate);
      return date;
    } catch(ParseException error) {
      System.err.println(error);
    }
    return null;
  }
}
