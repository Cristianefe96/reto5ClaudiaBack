package retosciclo4.reto05;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import retosciclo4.reto05.interfaces.InterfaceCloneEq;
import retosciclo4.reto05.interfaces.InterfaceUser;

@Component
@SpringBootApplication
public class Reto02Application implements CommandLineRunner{
	
	@Autowired
	private InterfaceCloneEq interfaceCloneEq;
	@Autowired
	private InterfaceUser interfaceUser;
	public static void main(String[] args) {
		SpringApplication.run(Reto02Application.class, args);
	}

	@Override
	public void run(String...args) throws Exception {

		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        interfaceCloneEq.deleteAll();
		interfaceCloneEq.deleteAll();
		interfaceUser.deleteAll();
	}

}
