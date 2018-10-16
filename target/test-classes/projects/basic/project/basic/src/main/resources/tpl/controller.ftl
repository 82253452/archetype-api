package ${package};


import com.ffcs.entity.${tableClass.shortClassName};
import com.ffcs.mapper.${tableClass.shortClassName}Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.MapUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/${tableClass.variableName}")
public class ${tableClass.shortClassName}Controller {
    @Resource
    private ${tableClass.shortClassName}Mapper ${tableClass.variableName}Mapper;

    @RequestMapping("/selectByPage")
    private PageInfo<${tableClass.shortClassName}> selectByPage(@RequestParam Map map) {
        PageHelper.startPage(MapUtils.getIntValue(map, "page", 1), MapUtils.getIntValue(map, "rows", 10));
        PageInfo<${tableClass.shortClassName}> page =new PageInfo<>(${tableClass.variableName}Mapper.selectAll());
    return page;
    }

        @RequestMapping("/insert")
        private int insert(@RequestBody ${tableClass.shortClassName} ${tableClass.shortClassName}) {
        return ${tableClass.variableName}Mapper.insert(${tableClass.shortClassName});
    }

        @RequestMapping("/selectById")
        private ${tableClass.shortClassName} selectById(String id) {
        return ${tableClass.variableName}Mapper.selectByPrimaryKey(id);
    }

        @RequestMapping("/updateById")
        private int updateById(@RequestBody ${tableClass.shortClassName} ${tableClass.shortClassName}) {
        return ${tableClass.variableName}Mapper.updateByPrimaryKeySelective(${tableClass.shortClassName});
    }

        @RequestMapping("/deleteByIds")
        private int deleteByIds(@RequestBody String ids) {
            return ${tableClass.variableName}Mapper.deleteByIds(ids);
    }

            @RequestMapping("/deleteById")
            private int deleteById(@RequestBody Map param) {
            return ${tableClass.variableName}Mapper.deleteByPrimaryKey(MapUtils.getInteger(param, "id"));
        }
}





