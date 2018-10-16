package it.pkg.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * createBy:2018-09-25 19:15:13
 * @author yp
 */
@EqualsAndHashCode(callSuper = true)
@Table(name = "`sys_user_info`")
@Data
public class SysUserInfo extends BaseEntity {

}
