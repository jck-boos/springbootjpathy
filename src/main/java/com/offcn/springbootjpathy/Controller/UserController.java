package com.offcn.springbootjpathy.Controller;

import com.offcn.springbootjpathy.model.User;
import com.offcn.springbootjpathy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jinchuangke
 * @email 1814214586@qq.com
 * @data 2020/5/11
 */
@Controller
@RequestMapping("/manageruser")
public class UserController {
    @Autowired
    private UserService userService;
    /***
     * 获取全部用户信息
     * @return
     */
    @GetMapping("/")
    public String getUserList(Model model){
        List<User> list = userService.getUserList();
        model.addAttribute("page", list);
        return "user/list";
    }

    /***
     * 跳转到新增用户界面
     * @param user
     * @return
     */
    @RequestMapping("/toAdd")
    public String toadd(User user){
        return "user/userAdd";//跳转到userAdd.html
    }
    /***
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/add")
    public String createUser(User user) {
        userService.createUser(user);
        return "redirect:/manageruser/";
    }

    @RequestMapping("/toEdit/{id}")
    public String toEdit(Model model, @PathVariable("id")Long id){
        User user = userService.getUser(id);
        model.addAttribute("user",user);
        return "user/userEdit"; //跳转到userEdit.html页面
    }
    @RequestMapping("/edit")
    public String edit(User user){
        userService.updateUser(user.getId(), user);
        return "redirect:/manageruser/";//获取列表数据并显示
    }


    /***
     * 删除指定id用户
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/manageruser/";

    }

}
