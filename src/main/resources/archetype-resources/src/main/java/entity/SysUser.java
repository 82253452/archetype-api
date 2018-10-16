#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * @author admin
 */
@EqualsAndHashCode(callSuper = true)
@Table(name = "`sys_user`")
@Data
public class SysUser extends BaseEntity {

}