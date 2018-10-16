package it.pkg.config;


import it.pkg.annotation.CurrentUser;
import it.pkg.entity.SysUser;
import it.pkg.entity.SysUserInfo;
import it.pkg.mapper.SysUserInfoMapper;
import it.pkg.mapper.SysUserMapper;
import it.pkg.utils.JWTUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.annotation.Resource;

/**
 * @author admin
 * @date 2018/8/18
 */
@Component
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysUserInfoMapper sysUserInfoMapper;
    @Autowired
    private JWTUtils jwtUtils;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return (parameter.getParameterType().isAssignableFrom(SysUser.class) || parameter.getParameterType().isAssignableFrom(SysUserInfo.class))
                && parameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Nullable
    @Override
    public Object resolveArgument(MethodParameter methodParameter, @Nullable ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, @Nullable WebDataBinderFactory webDataBinderFactory) throws Exception {
        String jToken = nativeWebRequest.getParameter("jToken");
        if (StringUtils.isNotBlank(jToken)) {
            try {
                Object uid = jwtUtils.parseBody(jToken).get("uid");
                if (uid != null) {
                    if (methodParameter.getParameterType().isAssignableFrom(SysUser.class)) {
                        return sysUserMapper.selectByPrimaryKey(uid);
                    } else if (methodParameter.getParameterType().isAssignableFrom(SysUserInfo.class)) {
                        return sysUserInfoMapper.selectByPrimaryKey(uid);
                    }
                }
            } catch (Exception e) {
                return null;
            }

        }
        return null;
    }
}
