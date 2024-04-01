package br.com.zuconvitor.ClientesNutricionistas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ConnTest implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ConnTest.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String sql = "SELECT 1";
        Integer result = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("Conexão com o banco de dados bem-sucedida. Resultado: " + result);
    }
}
