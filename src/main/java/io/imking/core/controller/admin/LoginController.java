package io.imking.core.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;

import io.imking.core.domain.Result;
import io.imking.core.domain.ResultEnum;
import io.imking.core.domain.User;
import io.imking.core.service.UserService;
import io.imking.core.utils.MD5Tools;
import io.imking.core.vo.RestResponse;

/**
 * Desc: 登陆相关的入口
 *
 * @date: 17/11/2017
 * @author: MoHan
 */
@RestController
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    @RequestMapping(value = "/login", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public RestResponse login(HttpServletRequest request, HttpServletResponse response,
            @RequestBody Map<String, Object> params) {
        
        stringRedisTemplate.opsForValue().set("aaa", "111");

        String username = params != null && params.containsKey("username") ? (String) params.get("username") : null;
        String password = params != null && params.containsKey("password") ? (String) params.get("password") : null;
        String countString = stringRedisTemplate.opsForValue().get(username);
        RestResponse result = null;
        HttpSession session = request.getSession();
        
        if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
            User user = userService.login(username,MD5Tools.MD5(password));
            if(user != null && user.getStatus() == (byte)1) {
                session.setAttribute("admin", user);
                Map<String, Object> responseData = new HashMap<String, Object>();
                responseData.put("id", user.getId());
                responseData.put("username", user.getUserName());
                result = RestResponse.success(responseData);
                stringRedisTemplate.opsForValue().set(username, String.valueOf(0));
            } else if(user != null && user.getStatus() == (byte)2) {
                result = RestResponse.message(403, "用户被禁用");
            } else {
                result = RestResponse.message(403, "用户名或密码错误");
                // 错误计数
                if(countString != null) {
                    int count = Integer.parseInt(countString);
                    count++;
                    stringRedisTemplate.opsForValue().set(username, String.valueOf(count));
                }else {
                    stringRedisTemplate.opsForValue().set(username, String.valueOf(1));
                }
            }
        } else {
            result = RestResponse.failure("参数错误");
        }
        return result;
    }

    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public RestResponse loginCheck(HttpServletRequest request, HttpServletResponse response,
            @RequestBody Map<String, Object> params) {
        
        String username = params != null && params.containsKey("username") ? (String) params.get("username") : null;
        RestResponse result = null;
        String countString = stringRedisTemplate.opsForValue().get(username);
        if(countString != null && Integer.parseInt(countString) >= 3) {
            result = RestResponse.message(403, "请输入验证码");
        }else {
            result = RestResponse.message(200, "无需验证");
        }
        return result;
    }

    @RequestMapping("/loginSuccess")
    public Result<Authentication> loginSuccess() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return new Result<>(ResultEnum.SUCCESS, authentication);
    }
}
