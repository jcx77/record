package com.framework.api.account.detailed.service;


import com.framework.api.account.detailed.mapper.AcDetailedMapper;
import com.framework.api.account.detailed.model.AcDetailed;
import com.framework.api.account.vo.AcParam;
import com.framework.commons.constant.DataConstant;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AcDetailedService {
    @Autowired
    private AcDetailedMapper acDetailedMapper;


    /**
     * @Description: TODO()
     * @Param: [ ]
     * @return: java.util.List<$ { data.javaModel.className }>
     * @Author: xxx
     * @Date: ${data.date}
     */
    @Transactional(readOnly = true)
    public List<AcDetailed> find(AcParam acParam){
        Example example = new Example(AcDetailed.class);
        PageHelper.startPage(acParam.getPage(), acParam.getRows());
        example.createCriteria().andEqualTo("deleteFlag", DataConstant.DELETE_FLAG_0)
                                .andEqualTo("billId",acParam.getBillId());
        example.orderBy("time").desc();
        return acDetailedMapper.selectByExample(example);
    }

    /**
     * @Description: TODO(添加)
     * @Param: [ ${data.javaModel.lowerClassName} ]
     * @return: void
     * @Author: xxx
     * @Date: ${data.date}
     */
    @Transactional
    public void insert(AcDetailed acDetailed) {
        //Example example = new Example(${data.javaModel.className}.class);
        //example.createCriteria().andEqualTo("deleteFlag", DataConstant.DELETE_FLAG_0);
        //if (${data.lowerMapperClassName}.selectOneByExample(example) != null) {
        //    throw new BizException("不允许重复");
        //}
        acDetailedMapper.insertSelective(acDetailed);
    }

    /**
     * @Description: TODO(获取)
     * @Param: [ id ]
     * @return: ${data.javaModel.packageName}.${data.javaModel.className}
     * @Author: xxx
     * @Date: ${data.date}
     */
    @Transactional(readOnly = true)
    public AcDetailed get(String id) {
        return acDetailedMapper.selectByPrimaryKey(id);
    }

    /**
     * @Description: TODO(更新实体)
     * @Param: [ ${data.javaModel.lowerClassName} ]
     * @return: void
     * @Author: xxx
     * @Date: ${data.date}
     */
    @Transactional
    public void update(AcDetailed acDetailed) {
        //Example example = new Example(${data.javaModel.className}.class);
        //example.createCriteria().andEqualTo("deleteFlag", DataConstant.DELETE_FLAG_0)
        //.andNotEqualTo("id", ${data.javaModel.lowerClassName}.getId());
        //if (${data.lowerMapperClassName}.selectCountByExample(example) > 0) {
        //    throw new BizException("不允许重复");
        //}
        acDetailedMapper.updateByPrimaryKeySelective(acDetailed);
    }

    /**
     * @Description: TODO(删除 ， 将实体状态修改为1 。)
     * @Param: [ id ]
     * @return: void
     * @Author: xxx
     * @Date: ${data.date}
     */
    @Transactional
    public void delete(String id) {
        AcDetailed acDetailed =new AcDetailed();
        acDetailed.setId(id);
       // acDetailed.setDeleteFlag(DataConstant.DELETE_FLAG_1);
        acDetailedMapper.updateByPrimaryKeySelective(acDetailed);
    }
}
