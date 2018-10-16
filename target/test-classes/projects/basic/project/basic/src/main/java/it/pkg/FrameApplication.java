package it.pkg;

import it.pkg.entity.SysUser;
import it.pkg.mapper.SysUserMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import tk.mybatis.spring.annotation.MapperScan;

import javax.annotation.Resource;

/**
 * @author admin
 */
@SpringBootApplication
@MapperScan(basePackages = "it.pkg.mapper")
@EnableWebMvc
@RestController
public class FrameApplication {
    @Resource
    private SysUserMapper sysUserMapper;

    public static void main(String[] args) {
        SpringApplication.run(FrameApplication.class, args);
    }

    @RequestMapping("/")
    public Long test() {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(18);
        return sysUser.getId();
    }
}
