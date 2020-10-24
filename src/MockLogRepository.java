import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.*;
import org.springframework.context.annotation.*;
import org.springframework.transaction.*;
import org.springframework.transaction.annotation.*;

interface LogRepository {
    public void createLog(String text);
}

public class MockLogRepository implements LogRepository {

    @Autowired
    private JdbcTemplate template;

    @PostConstruct
    public void createTable() {
    }

    @Override
    public void createLog(String text) {
        try {
            template.update("insert into logs (text) values('" + text + "');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

@Configuration
@EnableTransactionManagement
class Config {
    @Bean
    public PlatformTransactionManager transactionManager(DriverManagerDataSource ds) {
        return new DataSourceTransactionManager(ds);
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DriverManagerDataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean
    public MockLogRepository mockLogRepository() {
        return new MockLogRepository();
    }
}
