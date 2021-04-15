package org.learn.springbootlearn.authenticatingldap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/* Spring이 내장 스캔 기능을 사용하여 @RestController 컨트롤러를 자동으로 감지하고
 필요한 웹 경로를 자동으로 구성
 */
@RestController
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "Welcome to the home Page!";
	}
}
