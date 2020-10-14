package com.akukhtin.amazonreviewapplication.controller;

import com.akukhtin.amazonreviewapplication.parser.ParserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parser")
public class ParserController {
  @Autowired
  private ParserUtil parserUtil;

  @PostMapping("/parse")
  public void parseFile() {
    parserUtil.parse();
  }
}
