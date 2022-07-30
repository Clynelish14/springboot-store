package com.pirvate.store.service.impl;


import com.pirvate.store.entity.User;
import com.pirvate.store.entity.UserExample;
import com.pirvate.store.mapper.UserMapper;
import com.pirvate.store.service.UserService;
import com.pirvate.store.service.ex.*;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/21  16:37
 * Description(说明)):
 */
@Service
public class UserServiceImpl implements UserService {

    UserMapper userMapper;
    UserExample userExample;

    @Autowired
    public UserServiceImpl(UserMapper UserMapper, UserExample userExample) {
        this.userMapper=UserMapper;
        this.userExample=userExample;
    }

    /**
     *   给密码进行MD5加密处理
     *   (字符串+password+字符串) 三次加密
     * @param password
     * @param salt
     * @return
     */
    public String getMD5password(String password,String salt){

        for(int i=0;i<3;i++){
            // MD5加密算法的调用                                                          转为全大写
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }

    /**
     *  用户注册
     * @param user 用户信息
     */
    @Override
    public void reg(User user) {
        /* 先检测用户名是否被占用了 ∵用户名字段唯一 */
        userExample.createCriteria().andUsernameEqualTo(user.getUsername());
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size()>0){
            throw new UserNameDuplicatedException("用户名被占用了");
        }

        /* 密码MD三次加密 */
        String salt = UUID.randomUUID().toString().toUpperCase(); // 生成大写UUID随机字符串 作为加密盐值
        String password = user.getPassword();
        String md5password = getMD5password(password, salt);
        user.setPassword(md5password);

        /* 补全日志数据  */
        user.setSalt(salt); // salt  加密用的盐值
        user.setIsDelete(0); // isDelete 账号是否删除：0-未删除，1-已删除
        user.setCreatedUser(user.getUsername());// createdUser '日志-创建人',
        Date date = new Date();
        user.setCreatedTime(date);// createdTime  '日志-创建时间',
        user.setModifiedUser(user.getUsername());//	modifiedUser  '日志-最后修改执行人',
        user.setModifiedTime(date);//	modifiedTime '日志-最后修改时间',

        /* 向数据库添加数据 */
        int i = userMapper.insertSelective(user);
        if(i != 1){
            throw new InsertException("账号注册中出现了未知问题，请重试。");
        }
    }

    /**
     * 登录验证
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        userExample.createCriteria().andUsernameEqualTo(user.getUsername());
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size() == 0 || users.get(0).getIsDelete()== 1){
            throw new UserNotFoundException("用户数据不存在");
        }

        String password = user.getPassword(); // 前台输入的未加密密码
        String md5Password = users.get(0).getPassword(); // 数据库里加密过的密码
        String newPassword = getMD5password(password, users.get(0).getSalt()); // 根据盐值加密
        if(!md5Password.equals(newPassword)){
            throw new PasswordNotMatchException("密码错误");
        }

        User simplifyUser = new User();
        simplifyUser.setUid(users.get(0).getUid());
        simplifyUser.setUsername(users.get(0).getUsername());
        simplifyUser.setAvatar(users.get(0).getAvatar());

        return simplifyUser;
    }

    /**
     * 修改密码
     * @param uid
     * @param oldPassword
     * @param newPassword
     */
    @Override
    public void changePassword(Integer uid, String oldPassword, String newPassword) {
        User user = userMapper.selectByPrimaryKey(uid);
        if(user == null || user.getIsDelete() == 1){
                throw new UserNotFoundException("用户数据不存在");
        }

        String md5password = getMD5password(oldPassword, user.getSalt());
        if(!md5password.equals(user.getPassword())){
            throw new PasswordNotMatchException("密码错误");
        }

        String newMd5password = getMD5password(newPassword, user.getSalt());
        Date date = new Date();
        User newUser = new User();
        newUser.setUid(uid);
        newUser.setPassword(newMd5password);
        newUser.setModifiedUser(user.getUsername()); //最后修改人
        newUser.setModifiedTime(date); // 最后修改时间
        int i = userMapper.updateByPrimaryKeySelective(newUser);
        if(i!=1){
            throw new UpdateException("发生错误，修改失败");
        }
    }

    /**
     *  个人信息展示  用户名、电话、邮箱、性别
     * @param uid
     * @return
     */
    @Override
    public User getUserById(Integer uid) {
        User user = userMapper.selectByPrimaryKey(uid);
        if(user==null){
            throw new UserNotFoundException("用户数据不存在");
        }
        User simplifyUser = new User();
        simplifyUser.setUsername(user.getUsername());
        simplifyUser.setPhone(user.getPhone());
        simplifyUser.setEmail(user.getEmail());
        simplifyUser.setGender(user.getGender());

        return simplifyUser;
    }

    /**
     * 修改个人信息
     * @param user
     */
    @Override
    public void changeInfo(User user) {
        User userInfo = userMapper.selectByPrimaryKey(user.getUid());
        if(user==null){
            throw new UserNotFoundException("用户数据不存在");
        }
        user.setModifiedUser(userInfo.getModifiedUser()); //最后修改人
        Date date = new Date();
        user.setModifiedTime(date);  //最后修改时间

        int i = userMapper.updateByPrimaryKeySelective(user);
        if(i != 1){
            throw new UpdateException("发生错误，修改失败");
        }

    }

    /**
     *      上传头像
     * @param user
     */
    @Override
    public void uploadAvatar(User user) {
        User userInfo = userMapper.selectByPrimaryKey(user.getUid());
        if(userInfo==null){
            throw new UserNotFoundException("用户数据不存在");
        }
        user.setModifiedTime(new Date());
        int i = userMapper.updateByPrimaryKeySelective(user);
        if(i != 1){
            throw new UpdateException("发生错误，修改失败");
        }
    }


}
