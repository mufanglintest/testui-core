package com.jorge.testui.convert.converter;

import com.jorge.testui.CaseConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToStringConverter implements Converter<Date, String> {

  private static Logger logger = LoggerFactory.getLogger(DateToStringConverter.class);

  @Override
  public String convert(Date source) {
    if (source == null) {
      return null;
    }
    try {
      return new SimpleDateFormat(CaseConstants.DATA_FORMAT).format(source);
    } catch (Exception e) {
      logger.warn("StringToDate转换失败,source:" + source, e);
      return null;
    }
  }
}
