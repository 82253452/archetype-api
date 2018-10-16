#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dto;

import ${package}.entity.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class SysUserDto extends SysUser {
}
