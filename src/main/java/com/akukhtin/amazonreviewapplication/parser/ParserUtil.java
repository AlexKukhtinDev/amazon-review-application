package com.akukhtin.amazonreviewapplication.parser;

import com.akukhtin.amazonreviewapplication.entity.Comment;
import com.akukhtin.amazonreviewapplication.entity.Product;
import com.akukhtin.amazonreviewapplication.entity.User;
import com.akukhtin.amazonreviewapplication.repository.CommentRepository;
import com.akukhtin.amazonreviewapplication.repository.ProductRepository;
import com.akukhtin.amazonreviewapplication.repository.UserRepository;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParserUtil {
 private static final String CSV_FILE_PATH = "/Users/akukhtin/Downloads/Reviews.csv";

 @Autowired
 private ProductRepository productRepository;
 @Autowired
 private UserRepository userRepository;
 @Autowired
 private CommentRepository commentRepository;

 public void parse() {
  CSVReader reader = null;
  try {
   reader = getSetCSVReaderProperties();
   String[] line;
   while ((line = reader.readNext()) != null) {
    final User user = new User(line[2], line[3]);
    saveIntoUserBd(user);
    final Product product = new Product(
            line[1], Long.parseLong(line[5]), Long.parseLong(line[4]),
            Long.parseLong(line[6]), line[8]);
    saveIntoProductBd(product);
    final Comment comment = new Comment(line[9]);
    saveIntoCommentBd(comment);
   }
  } catch (IOException e) {
   e.printStackTrace();
  }
 }

 private CSVReader getSetCSVReaderProperties() throws IOException {
  CSVReader reader;
  reader = new CSVReader(new FileReader(CSV_FILE_PATH));
  reader.skip(1);
  return reader;
 }

 private void saveIntoProductBd(Product product) {
  productRepository.save(product);
 }

 private void saveIntoUserBd(User user) {
  userRepository.save(user);
 }

 private void saveIntoCommentBd(Comment comment) {
  commentRepository.save(comment);
 }

}
