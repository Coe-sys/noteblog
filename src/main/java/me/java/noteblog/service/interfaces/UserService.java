package me.java.noteblog.service.interfaces;

import com.baomidou.mybatisplus.extension.service.IService;
import me.java.noteblog.model.entity.User;

public interface UserService extends IService<User> {

    /**
     * 根据openId查找用户
     *
     * @param openId
     * @param enable
     * @return
     */
    User findByQqOpenId(String openId, Boolean enable);

    /**
     * 查找GitHub用户
     *
     * @param username
     * @param enable
     * @return
     */
    User findByGithub(String username, Boolean enable);

    /**
     * 统计nickname
     *
     * @param nickname
     * @return
     */
    int countNickname(String nickname);

    /**
     * 统计今日用户数量
     *
     * @return
     */
    long findTodayUser();

    /**
     * 统计邮箱和用户名的数量
     *
     * @param email
     * @param username
     * @return
     */
    int countEmailAndUsername(String email, String username);

    /**
     * 注册用户
     *
     * @param username
     * @param password
     * @param email
     * @param nickname
     */
    int userRegister(String username, String password, String email, String nickname);
}
