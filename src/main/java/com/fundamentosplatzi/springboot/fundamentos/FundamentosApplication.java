package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.configuration.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.MyCustomRepository;
import com.fundamentosplatzi.springboot.fundamentos.repository.MyCustomRepositoryWserviceFake;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
								  MyBean myBean,
								  MyBeanWithDependency myBeanWithDependency,
								  MyCustomRepository myCustomRepository,
								  MyCustomRepositoryWserviceFake myCustomRepositoryWserviceFake,
								  MyBeanWithProperties myBeanWithProperties,
								  UserPojo userPojo) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myCustomRepository = myCustomRepository;
		this.myCustomRepositoryWserviceFake = myCustomRepositoryWserviceFake;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


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
}
