package IKT446.dbiola;

import IKT446.dbiola.api.UpdateController;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
@EnableScheduling
public class DBiolaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DBiolaApplication.class, args);
        /*UpdateController updateController = context.getBean(UpdateController.class);
        updateController.updateODB();*/
    }

}
