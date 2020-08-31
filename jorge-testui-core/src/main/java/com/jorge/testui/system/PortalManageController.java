package com.jorge.testui.system;

import com.jorge.testui.platform.service.ParametersService;
import com.jorge.testui.system.dto.ParameterStatusDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2020-04-03 14:51
 */
@Slf4j
@Controller
@RequestMapping(value = "/manage/layout")
public class PortalManageController {
	@Resource
	ParametersService parametersService;
	
	@RequestMapping(value = "/portal")
	public String portal(HttpServletRequest request, HttpServletResponse response, Model model) {
		//        User user = ShiroUtils.getCurrentUser();
		//        log.info("1234"+user.getRealName());
		//        model.addAttribute("socketDomain", request.getServerName() + ":" + request.getServerPort() + "/alarm");
		//查询数据
		int allTestCase = parametersService.getAll().size();
		int allTestCaseSuccess = parametersService.countListParametersByLastImplementResult(true);
		int allTestCaseFail = parametersService.countListParametersByLastImplementResult(false);
        List<ParameterStatusDto> parameterStatusDto = parametersService.countParameterStatus();
		
		model.addAttribute("allTestCase", allTestCase);
		model.addAttribute("allTestCaseSuccess", allTestCaseSuccess);
		model.addAttribute("allTestCaseFail", allTestCaseFail);
		model.addAttribute("parameterStatusDto", parameterStatusDto);

		
		return "/manage/jorge/protal";
	}
}
