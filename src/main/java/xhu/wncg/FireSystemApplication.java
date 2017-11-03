package xhu.wncg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author BZhao
 * @version 2017/10/24.
 */
@SpringBootApplication
@Controller
public class FireSystemApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FireSystemApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(FireSystemApplication.class);
	}

	/**
	 * 进入网站，跳转到登录界面
	 * @return index
	 */
	@RequestMapping("/")
	public String index(){
		return "forward:/login.html";
	}
}
