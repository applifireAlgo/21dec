package dec22.app.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.athena.config.server.WebConfig;
import org.springframework.context.annotation.Bean;

/**
 *
 *
 * @author Anant
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.athena", "com.spartan", "dec22.app" })
public class WebConfigExtended extends WebConfig {
}
