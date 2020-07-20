package com.hairo.springbootmybatis_enum;

import com.hairo.springbootmybatis_enum.mappers.NrCellParamMapper;
import com.hairo.springbootmybatis_enum.model.CellWorkParam;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisEnumApplicationTests {

    @Resource
    private NrCellParamMapper nrCellParamMapper;

    @Test
    public void contextLoads() {
        List<CellWorkParam> paramList = nrCellParamMapper.selectAllNrCellParamByStatus(Lists.newArrayList("现网有业务", "工程有业务", "应急/备份", "应急容灾"));
        paramList.forEach(o-> System.out.println(o.getCity()));

    }

}
