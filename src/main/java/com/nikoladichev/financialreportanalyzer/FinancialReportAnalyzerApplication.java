package com.nikoladichev.financialreportanalyzer;

import com.nikoladichev.financialreportanalyzer.config.ObjectMapperConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({/* TODO [SWAGGER] OpenApiConfig.class, */ObjectMapperConfig.class})
public class FinancialReportAnalyzerApplication {

  public static void main(String[] args) {
    SpringApplication.run(FinancialReportAnalyzerApplication.class, args);
  }
}
