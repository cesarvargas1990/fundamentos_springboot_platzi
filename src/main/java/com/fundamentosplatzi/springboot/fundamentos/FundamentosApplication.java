package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.repository.MyCustomRepository;
import com.fundamentosplatzi.springboot.fundamentos.repository.MyCustomRepositoryWserviceFake;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyCustomRepository myCustomRepository;
	private MyCustomRepositoryWserviceFake myCustomRepositoryWserviceFake;

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
								  MyBean myBean,
								  MyBeanWithDependency myBeanWithDependency, MyCustomRepository myCustomRepository, MyCustomRepositoryWserviceFake myCustomRepositoryWserviceFake) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myCustomRepository = myCustomRepository;
		this.myCustomRepositoryWserviceFake = myCustomRepositoryWserviceFake;
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
		System.out.println("ejemplo aplcando sobrecarga de metodo...");
		System.out.println(myCustomRepositoryWserviceFake.getDataFromService(1));
	}
}
