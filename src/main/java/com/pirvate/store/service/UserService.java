package com.pirvate.store.service;


import com.pirvate.store.entity.User;


/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/21  16:33
 * Description(说明)):
 *  用户模块业务层接口
 */
public interface UserService {

    /**
     *  用户注册方法 REG有注册文件信息的意思
     * @param user 用户信息
     */
    void reg(User user);

    /**
     *  用户登录方法
     * @param user
     */
    User login(User user);

    /**
     * 修改密码
     * @param uid
     * @param oldPassword
     * @param newPassword
     */
    void changePassword(Integer uid,String oldPassword,String newPassword);

    /**
     *  根据id查询用户信息
     * @param uid
     * @return
     */
    User getUserById(Integer uid);

    /**
     *  完善个人资料【电话、邮箱、性别】
     * @param user
     */
    void changeInfo(User user);

    /**
     *  上传头像
     * @param user
     */
    void uploadAvatar(User user);
}
