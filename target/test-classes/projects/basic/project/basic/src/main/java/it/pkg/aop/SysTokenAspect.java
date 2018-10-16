package it.pkg.aop;

import it.pkg.utils.JWTUtils;
import it.pkg.utils.R;
import io.jsonwebtoken.ExpiredJwtException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;


/**
 * @author admin
 */
@Aspect
@Component
public class SysTokenAspect {
	@Resource
	private JWTUtils jwtUtils;
	@Pointcut("@annotation(it.pkg.annotation.SysTokenIntercept)")
	public void tockenIntercept() {

	}

	@Around(value = "tockenIntercept()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		Map<String, String[]> map = request.getParameterMap();
		if (map.get("jToken") == null) {
			return R.error(3000, "jToken不能为空");
		}
		String jToken = map.get("jToken")[0];
		if (jToken == null) {
			return R.error(3000, "jToken不能为空");
		}
		try {
			jwtUtils.parseBody(jToken);
		} catch (ExpiredJwtException e) {
			return R.error(3000, "jToken已过期");
		} catch (Exception e) {
			return R.error(3000, "jToken异常");
		}
		return pjp.proceed();
	}
}
