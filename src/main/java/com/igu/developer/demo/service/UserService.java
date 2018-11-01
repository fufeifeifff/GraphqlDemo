//package com.igu.developer.demo.service;
//
//import cn.wewin.modules.core.utils.Digests;
//import cn.wewin.modules.core.utils.Encodes;
//import com.igu.developer.demo.dao.PermissionDao;
//import com.igu.developer.demo.dao.RoleDao;
//import com.igu.developer.demo.dao.UserDao;
//import com.igu.developer.demo.entity.MPermissionEntity;
//import com.igu.developer.demo.entity.MRoleEntity;
//import com.igu.developer.demo.entity.MUserEntity;
//import com.igu.developer.demo.framework.security.LoginFailureException;
//import com.igu.developer.demo.framework.security.ShiroDbRealm;
//import com.igu.developer.demo.framework.util.Constants;
//import com.igu.developer.demo.framework.util.MD5;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
///**
// * 用户管理类.
// *
// * @author Jession
// */
//@Service
//@Component
//@Transactional
//public class UserService {
//
//    private static final int SALT_SIZE = 8;
//
//    private static Logger logger = LoggerFactory.getLogger(UserService.class);
//
//    @Autowired
//    private UserDao userDao;
//    @Autowired
//    private PermissionDao permissionDao;
//    @Autowired
//    private RoleDao roleDao;
//
////    public Page<Map<String,Object>> findPageByParams(Pageable pageable, Map<String, Object> allParams) {
////        return userDao.findPageByNativeQuery( "findPageByParams",pageable, allParams);
////    }
////
////    public Page<MUserEntity> findPageApartmentuserByParams(Pageable pageable, Map<String, Object> allParams) {
////        return userDao.findPageByHql(pageable, "findPageManagedUser", allParams);
////    }
//
//    public List<MUserEntity> findAll() {
//        return userDao.findAll();
//    }
//
//    public MUserEntity getUser(long id) {
//        return userDao.findByIdAndFlgDeletedFalse(id);
//    }
//
//    public MUserEntity findUserByLoginName(String loginName) {
//        return userDao.findByLoginNameAndFlgDeletedFalse(loginName);
//    }
//
//    public void save(MUserEntity userEntity) {
//        userDao.save(userEntity);
//    }
//
//    /**
//     * 根据手机号查询用户
//     *
//     * @param mobile
//     * @return
//     */
//    public MUserEntity findUserByMobile(String mobile) {
//        return userDao.findByMobileAndFlgDeletedFalse(mobile);
//    }
//
//    /**
//     * 根据用户id
//     *
//     * @param userId
//     * @return
//     */
//    public MUserEntity findUserByUserId(long userId) {
//        return userDao.getOne(userId);
//    }
//
//    public void saveUser(MUserEntity user, List<Long> roleIds, long identityType) {
//        // 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
//        if (StringUtils.isNotBlank(user.getPlainPassword())) {
//            entryptPassword(user);
//        }
//
//        user.setRoles(getRolesByIds(roleIds));
//
//        userDao.save(user);
//
//    }
//
//    public void saveUserInfo(MUserEntity userEntity) {
//        userDao.save(userEntity);
//    }
//
//    public void deleteUser(Long userId) {
//        userDao.setFixedFlgDeletedFor(true, userId);
//    }
//
//    public void updateUser(MUserEntity user) {
//        if (StringUtils.isNotBlank(user.getPlainPassword())) {
//            entryptPassword(user);
//        }
//        userDao.save(user);
//    }
//
//    public boolean changePassword(Long userId, String newPassword) {
//        MUserEntity user = userDao.findOne(userId);
//        if (user!= null) {
//            user.setPlainPassword(newPassword);
//            //setPlainPassword(newPassword);
//            updateUser(user);
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 取得所有权限菜单
//     */
//    public List<MPermissionEntity> getPermissionMenu() {
//        return permissionDao.findByFlgMenuAndParentIdIsNullOrderByCdSortAsc(true);
//    }
//
//    public List<MPermissionEntity> getPermissions() {
//        Sort sort = new Sort("cdSort");
//        return permissionDao.findAll(sort);
//    }
//
////    public Page<MRoleEntity> findRolePageByParams(Pageable pageable, Map<String, Object> allParams) {
////        return roleDao.findPageByHql(pageable, "findPageByParams", allParams);
////    }
//
//    public List<MRoleEntity> getRoles(String name) {
//        if (StringUtils.isBlank(name)) {
//            return roleDao.findAll(new Sort("nmDisplay"));
//        } else {
//            return roleDao.findByNameContainingOrderByNmDisplayAsc(name.trim());
//        }
//    }
//
//    public List<MRoleEntity> getRolesByIds(List<Long> ids) {
//        if (ids == null) {
//            return null;
//        }
////        return roleDao.findAll(ids);
//        return roleDao.findAll();
//    }
//
//    public MRoleEntity getRoleByName(String name) {
//        return roleDao.findByName(name);
//    }
//
//    public MRoleEntity getRoleByNmDisplay(String nmDisplay) {
//        return roleDao.findByNmDisplay(nmDisplay);
//    }
//
//    public MRoleEntity getRole(Long id) {
//        return roleDao.findOne(id);
//    }
//
//    public void deleteRole(Long id) {
//        roleDao.delete(id);
//    }
//
//    public void saveRole(MRoleEntity role) {
//        roleDao.save(role);
//    }
//
//    public List<MRoleEntity> getAllRole() {
//        return roleDao.findAll();
//    }
//
//    /**
//     * 判断是否超级管理员.
//     */
//    private boolean isSupervisor(Long id) {
//        return id == 1;
//    }
//
//    /**
//     * 判断是否超级管理员.
//     */
//    public boolean isSupervisor(MUserEntity user) {
//        return ((user.getId() != null) && (user.getId() == 1L));
//    }
//
//    /**
//     * 取出Shiro中的当前用户LoginName.
//     */
//    public String getCurrentUserName() {
//        ShiroDbRealm.ShiroUser user = (ShiroDbRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal();
//        return user.getName();
//    }
//
//
//    /**
//     * 验证用户登录状态，验证失败，拋出异常，画面将直接显示异常的消息内容
//     *
//     * @param authcToken
//     */
//    public void doLoginValidate(AuthenticationToken authcToken) throws LoginFailureException {
//        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
//        MUserEntity user = userDao.findByLoginNameAndFlgDeletedFalse(token.getUsername());
//
//        //TODO:用户状态验证，验证失败时，拋出Exception
//    }
//
//    /**
//     * 设定安全的密码，生成随机的salt并经过MD5加密
//     */
//    private void entryptPassword(MUserEntity user) {
//        byte[] salt = Digests.generateSalt(SALT_SIZE);
//        user.setSalt(Encodes.encodeHex(salt));
//
//        String hashPassword = "";
//        try {
//            hashPassword = MD5.INSTANCE.generateDigest(user.getPlainPassword(), salt);
//        } catch (Exception e) {
//            logger.error("密码加密失败。", e.getMessage());
//        }
//        user.setPassword(hashPassword);
//    }
//
//    public Long getCurrentUserId() {
//        ShiroDbRealm.ShiroUser user = (ShiroDbRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal();
//        return user.getId();
//    }
//
//    public MUserEntity getCurrentUser() {
//        return getUser(getCurrentUserId());
//    }
//
//    public MPermissionEntity getPermission(Long id) {
//        return permissionDao.getOne(id);
//    }
//
//    public void deletePermission(Long id) {
//        permissionDao.delete(id);
//    }
//
//    public void savePermission(MPermissionEntity perm) {
//        permissionDao.save(perm);
//    }
//
//
//    public boolean isSuperUser(Long userId) {
//        List<MRoleEntity> roles = userDao.getOne(userId).getRoles();
//        return roles.contains(new MRoleEntity(Constants.ROLE_NAME_SYS_ROLE_SUPER_ADMIN));
//    }
//
//    public MUserEntity  findUserById(Long id) {
//        return userDao.findOne(id);
//    }
//
//    public void resetPassword(String password, String salt, Long userid) {
//        userDao.resetPssword(password, salt, userid);
//    }
//
//
//    private List<MRoleEntity> findRolesByRoleNames(List<String> roleNamesByApartmentAdminManaged) {
//        return roleDao.findByNameInAndFlgDeletedIsFalse(roleNamesByApartmentAdminManaged);
//    }
//
//}
