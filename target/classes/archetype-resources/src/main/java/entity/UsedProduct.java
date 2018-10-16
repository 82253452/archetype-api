#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * createBy:2018-10-16 16:36:26
 * @author yp
 */
@Table(name = "`used_product`")
@Data
public class UsedProduct extends BaseEntity {

    /**
     * 
     */
    private Long userId;
    /**
     * 
     */
    private BigDecimal price;
    /**
     * 
     */
    private String city;
    /**
     * 
     */
    private Integer cityId;
    /**
     * 
     */
    private Boolean setTop;
    /**
     * 
     */
    private Boolean deleted;
    /**
     * 
     */
    private Date createTime;
    /**
     * 
     */
    private Date updateTime;
    /**
     * 
     */
    private Integer status;
    /**
     * 浏览量
     */
    private Integer numBrowse;
    /**
     * 成色 1超值 2八成新 3全新
     */
    private Integer quality;

}
