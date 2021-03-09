package com.framework.api.account.bill.service;


import com.framework.api.account.bill.mapper.AcBillMapper;
import com.framework.api.account.bill.model.AcBill;
import com.framework.api.account.vo.AcParam;
import com.framework.commons.constant.DataConstant;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class AcBillService {
    @Autowired
    private AcBillMapper acBillMapper;


    /**
     * @Description: TODO()
     * @Param: [ ]
     * @return: java.util.List<$ { data.javaModel.className }>
     * @Author: xxx
     * @Date: ${data.date}
     */
    @Transactional(readOnly = true)
    public List<AcBill> find(AcParam acParam) {
        Example example = new Example(AcBill.class);
        PageHelper.startPage(acParam.getPage(), acParam.getRows());
        example.createCriteria().andEqualTo("deleteFlag", DataConstant.DELETE_FLAG_0);
        return acBillMapper.selectByExample(example);
    }

    /**
     * @Description: TODO(添加)
     * @Param: [ ${data.javaModel.lowerClassName} ]
     * @return: void
     * @Author: xxx
     * @Date: ${data.date}
     */
    @Transactional
    public void insert(AcBill acBill) {
        //Example example = new Example(${data.javaModel.className}.class);
        //example.createCriteria().andEqualTo("deleteFlag", DataConstant.DELETE_FLAG_0);
        //if (${data.lowerMapperClassName}.selectOneByExample(example) != null) {
        //    throw new BizException("不允许重复");
        //}
        acBillMapper.insertSelective(acBill);
    }

    /**
     * @Description: TODO(获取)
     * @Param: [ id ]
     * @return: ${data.javaModel.packageName}.${data.javaModel.className}
     * @Author: xxx
     * @Date: ${data.date}
     */
    @Transactional(readOnly = true)
    public AcBill get(String id) {
        return acBillMapper.selectByPrimaryKey(id);
    }

    /**
     * @Description: TODO(更新实体)
     * @Param: [ ${data.javaModel.lowerClassName} ]
     * @return: void
     * @Author: xxx
     * @Date: ${data.date}
     */
    @Transactional
    public void update(AcBill acBill) {
        //Example example = new Example(${data.javaModel.className}.class);
        //example.createCriteria().andEqualTo("deleteFlag", DataConstant.DELETE_FLAG_0)
        //.andNotEqualTo("id", ${data.javaModel.lowerClassName}.getId());
        //if (${data.lowerMapperClassName}.selectCountByExample(example) > 0) {
        //    throw new BizException("不允许重复");
        //}
        acBillMapper.updateByPrimaryKeySelective(acBill);
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
        AcBill acBill =new AcBill();
        acBill.setId(id);
        acBill.setDeleteFlag(DataConstant.DELETE_FLAG_1);
        acBillMapper.updateByPrimaryKeySelective(acBill);
    }
}
