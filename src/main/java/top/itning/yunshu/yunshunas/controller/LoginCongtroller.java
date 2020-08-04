package top.itning.yunshu.yunshunas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.itning.yunshu.yunshunas.config.UserCache;
import top.itning.yunshu.yunshunas.entity.NasProperties;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class LoginCongtroller {

    @Autowired
    NasProperties nasProperties;
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session) {
        if (nasProperties.getUsername().equals(username)&& nasProperties.getPassword().equals(password)){
            final String s = username + System.currentTimeMillis();
            final String md5DigestAsHex = DigestUtils.md5DigestAsHex(s.getBytes());
            UserCache.add(md5DigestAsHex);
            session.setAttribute("loginUser",md5DigestAsHex);
            //登录成功,防止表单重复提交,可以重定向到主页
            return "redirect:/home";
        }
        map.put("msg","用户名或密码错误");
        return "index";
    }
    @RequestMapping("/user/logout")
    public String tologin(HttpSession session){
        session.setAttribute("loginUser",null);


        return "index";
    }
}
