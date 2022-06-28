package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.configuration.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.MyCustomRepository;
import com.fundamentosplatzi.springboot.fundamentos.repository.MyCustomRepositoryWserviceFake;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyCustomRepository myCustomRepository;
	private MyCustomRepositoryWserviceFake myCustomRepositoryWserviceFake;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
								  MyBean myBean,
								  MyBeanWithDependency myBeanWithDependency,
								  MyCustomRepository myCustomRepository,
								  MyCustomRepositoryWserviceFake myCustomRepositoryWserviceFake,
								  MyBeanWithProperties myBeanWithProperties,
								  UserPojo userPojo,
								  UserRepository userRepository
	) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myCustomRepository = myCustomRepository;
		this.myCustomRepositoryWserviceFake = myCustomRepositoryWserviceFake;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			ejemplosAnteriores();
			saveUsersInDatabase();
			getInformationFromUser();
	}

	public void ejemplosAnteriores () {

		myBeanWithDependency.printWithDependency();
		componentDependency.saludar();
		System.out.println(myCustomRepository.getData());
		System.out.println(myCustomRepositoryWserviceFake.getDataFromService());
		myBean.print();
		System.out.println("ejemplo aplicando sobrecarga de metodo...");
		System.out.println(myCustomRepositoryWserviceFake.getDataFromService(1));
		System.out.println("llamado a bean con propiedades leyendo application.propertiess");
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail()+" - "+userPojo.getPassword());
		System.out.println(userPojo.getAge());
		LOGGER.error("esto es un error del aplicativo");
		try {
			int a = 10/0;
			LOGGER.debug("valor de a es: "+a);
		} catch (Exception e) {
			LOGGER.error("ocurrio un error: "+e.getMessage());
			LOGGER.error("info detallada: "+e.getStackTrace());
			LOGGER.error(e.getStackTrace());
		}
	}

	private void getInformationFromUser(){
		LOGGER.info("user con metodo findByUserEmail"+
				userRepository.findByUserEmail("cesara1.vargas1990@gmail.com")
						.orElseThrow(()->
		new RuntimeException("No se encontro")));


		userRepository.findAndSort("cesar", Sort.by("email").descending())
				.stream().forEach(user -> LOGGER.info("user con filtro desc"+user));

		userRepository.findAndSort("cesar", Sort.by("email").ascending())
				.stream().forEach(user -> LOGGER.info("user con filtro asc"+user));
//		LOGGER.info("user con metodo findByUserEmail"+
//				userRepository.findByUserEmail("no existe.vargas1990@gmail.com")
//						.orElseThrow(()->
//								new RuntimeException("No se encontro")));

		userRepository.findByName("cesar1").stream().forEach(user -> LOGGER.info("usuario con query method"+user));

		LOGGER.info("usuario con query method findByNameAndEmail "+userRepository.findByNameAndEmail("cesar1","cesara1.vargas1990@gmail.com"));

		LOGGER.info("query method findByNameLike");
		userRepository.findByNameLike("%cesar%")
				.stream()
				.forEach(user -> LOGGER.info("query method findByNameLike "+user));

		userRepository.findByNameOrEmail(null,"cesara1.vargas1990@gmail.com")
				.stream()
				.forEach(user -> LOGGER.info("query method findByNameOrEmail "+user));

		userRepository.findByBirthDateBetween(LocalDate.of(1990,01,01),LocalDate.of(1991,12,31))
				.stream().forEach(user-> LOGGER.info("metodo  findByBirthDateBetween"+user));

		userRepository.findByNameLikeOrderByIdDesc("%cesar%")
				.stream()
				.forEach(user->LOGGER.info("metodo findByNameLikeOrderByIdDesc "+user));

		userRepository.findByNameContainingOrderByIdDesc("cesar")
				.stream()
				.forEach(user -> LOGGER.info("metodo findByNameContainingOrderByIdDesc "+user));
		userRepository.findByEmailContainingOrderByNameAsc("ces")
				.stream()
				.forEach(user -> LOGGER.info("metodo findByEmailContainingOrderByNameAsc "+user));

		userRepository.getAllByBirthDateAndEmail(
				LocalDate.of(1990,01,01),"cesara1.vargas1990@gmail.com")
				.stream().forEach(userDto -> LOGGER.info("metodo getAllByBirthDateAndEmail" + userDto));
		;


	}

	private void saveUsersInDatabase () {
		User user = new User("acesar1","cesara1.vargas1990@gmail.com", LocalDate.of(1990,01,01));
		User user1 = new User("bcesar2","cesara2.vargas1990@gmail.com", LocalDate.of(1990,12,31));
		User user2 = new User("zcesar3","cesara3.vargas1990@gmail.com", LocalDate.of(1991,01,01));

		User user3 = new User("dcesar4","cesara4.vargas1990@gmail.com", LocalDate.of(1992,01,01));
		User user4 = new User("ecesar5","cesara5.vargas1990@gmail.com", LocalDate.of(1993,01,01));
		User user5 = new User("rcesar6","cesara6.vargas1990@gmail.com", LocalDate.of(1994,01,01));


		User user6 = new User("jtest1","cesara7.vargas1990@gmail.com", LocalDate.of(2005,01,01));
		User user7 = new User("jtest2","cesara8.vargas1990@gmail.com", LocalDate.of(2006,01,31));
		User user8 = new User("jtest3","cesara9.vargas1990@gmail.com", LocalDate.of(2008,01,31));
		List<User> list = Arrays.asList(user,user1,user2,user3,user4,user5,user6,user7,user8);
		list.stream().forEach(userRepository::save);
	}
}
