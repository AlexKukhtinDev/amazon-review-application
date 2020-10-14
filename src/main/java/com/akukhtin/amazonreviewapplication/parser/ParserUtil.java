package com.akukhtin.amazonreviewapplication.parser;

import com.akukhtin.amazonreviewapplication.entity.BaseEntity;
import com.akukhtin.amazonreviewapplication.entity.Comment;
import com.akukhtin.amazonreviewapplication.entity.Product;
import com.akukhtin.amazonreviewapplication.entity.User;
import com.akukhtin.amazonreviewapplication.repository.BaseEntityRepository;
import com.akukhtin.amazonreviewapplication.repository.CommentRepository;
import com.akukhtin.amazonreviewapplication.repository.ProductRepository;
import com.akukhtin.amazonreviewapplication.repository.UserRepository;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 @Autowired
 private BaseEntityRepository baseEntityRepository;

 public void parse() {
  CSVReader reader = null;
  try {
   reader = getSetCSVReaderProperties();
   String[] line;
   while ((line = reader.readNext()) != null) {
    final BaseEntity baseEntity = getBaseEntityProperties(line);
    saveIntoBaseEntityBd(baseEntity);
    final User user = getUserProperties(line);
    saveIntoUserBd(user);
    final Product product = getProductProperties(line);
    saveIntoProductBd(product);
    final Comment comment = getCommentProperties(line[10]);
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

 private Comment getCommentProperties(String text) {
  return Comment.builder().text(text).build();
 }

 private Product getProductProperties(String[] line) {
  return Product
          .builder().productId(line[2]).helpfulnessNominator(Long.parseLong(line[5]))
          .helpfulnessDenominator(Long.parseLong(line[6])).summary(line[9])
          .score(Long.parseLong(line[7]))
          .build();
 }

 private User getUserProperties(String[] line) {
  return User
          .builder().userId(line[3]).profileName(line[4])
          .build();
 }

 private BaseEntity getBaseEntityProperties(String[] line) {
  return BaseEntity
          .builder().id(Long.parseLong(line[0])).time(stringDateFormat(line[8]))
          .build();
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

 private void saveIntoBaseEntityBd(BaseEntity baseEntity) {
  baseEntityRepository.save(baseEntity);
 }

 private Date stringDateFormat(String date) {
  Date dateTmp = null;
  try {
   dateTmp = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss").parse(date);
  } catch (ParseException e) {
   e.printStackTrace();
  }
  return dateTmp;
 }

}
