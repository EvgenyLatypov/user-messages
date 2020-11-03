package letscode.sarafan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SarafanApplication {

	public static void main(String[] args) {
		SpringApplication.run(SarafanApplication.class, args);
	}

}
/*
CREATE TABLE APPLICATION (     SHORT_APP_ID         VARCHAR2(20 CHAR) PRIMARY KEY,
     MOBILE_PHONE         VARCHAR2(10 CHAR),     DELIVERY_TYPE        VARCHAR2(12 CHAR),
     RISK_APP_NUMBER      VARCHAR2(20 CHAR),     ZET_SCORING_RESULT   VARCHAR2(64 CHAR), 
     RQ_ID                VARCHAR2(8 CHAR),      PLASTIC_ID           VARCHAR2(24 CHAR), 
     LOGISTIC_DELIVERY_ID VARCHAR2(36 CHAR),     CREATED_AT           TIMESTAMP DEFAULT CURRENT_TIMESTAMP ); 
 */