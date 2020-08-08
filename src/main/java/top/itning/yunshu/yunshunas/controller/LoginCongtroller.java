package top.itning.yunshu.yunshunas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.itning.yunshu.yunshunas.config.UserCache;
import top.itning.yunshu.yunshunas.config.properties.NasAuthProperties;
import top.itning.yunshu.yunshunas.config.properties.NasProperties;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class LoginCongtroller {

    @Autowired
    NasAuthProperties nasProperties;

    /**
     * 登录接口
     * @param username
     * @param password
     * @param map
     * @param session
     * @return
     */
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {

        if(!nasProperties.isEnable())  return "redirect:/home";

        if (nasProperties.getUsername().equals(username) && nasProperties.getPassword().equals(password)) {
            final String s = username + System.currentTimeMillis();
            final String md5DigestAsHex = DigestUtils.md5DigestAsHex(s.getBytes());
            UserCache.add(md5DigestAsHex);
            session.setAttribute("loginUser", md5DigestAsHex);
            //登录成功,防止表单重复提交,可以重定向到主页
            return "redirect:/home";
        }
        map.put("msg", "用户名或密码错误");
        return "index";
    }

    /**
     * 退出跳转登录页面
     * @param session
     * @return
     */
    @RequestMapping("/user/logout")
    public String loginOut(HttpSession session) {
        session.setAttribute("loginUser", null);


        return "index";
    }

    /**
     * 跳转登录页面
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public String toLogin(HttpSession session) {


        return "index";
    }
}
