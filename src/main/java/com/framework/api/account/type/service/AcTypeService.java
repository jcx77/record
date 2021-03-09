package com.framework.api.account.type.service;


import com.framework.api.account.type.mapper.AcTypeMapper;
import com.framework.api.account.type.model.AcType;
import com.framework.api.account.vo.AcParam;
import com.framework.commons.constant.DataConstant;
import com.framework.commons.vo.ui.TreeNode;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class AcTypeService {
    @Autowired
    private AcTypeMapper acTypeMapper;


    /**
     * @Description: TODO()
     * @Param: [ ]
     * @return: java.util.List<$ { data.javaModel.className }>
     * @Author: xxx
     * @Date: ${data.date}
     */
    @Transactional(readOnly = true)
    public List<AcType> find(AcParam acParam) {
        Example example = new Example(AcType.class);
        PageHelper.startPage(acParam.getPage(), acParam.getRows());
        example.createCriteria().andEqualTo("deleteFlag", DataConstant.DELETE_FLAG_0);
        return acTypeMapper.selectByExample(example);
    }
    /**
    * @Description: TODO()
    * @Param: []
    * @return: java.util.List<com.framework.commons.vo.ui.TreeNode>
    * @Author: zcx
    * @Date: 2021/3/8 22:10
    */
    public List<TreeNode> findTypeSelect(){
        Example example = new Example(AcType.class);
        List<AcType> acTypes = acTypeMapper.selectByExample(example);
        List<TreeNode> tree= new ArrayList<>();
        acTypes.forEach(e->{
            TreeNode tr =new TreeNode();
            tr.setId(e.getId());
            tr.setText(e.getName());
            //tr.set
            tree.add(tr);
        });
        return tree;
    }
    /**
     * @Description: TODO(添加)
     * @Param: [ ${data.javaModel.lowerClassName} ]
     * @return: void
     * @Author: xxx
     * @Date: ${data.date}
     */
    @Transactional
    public void insert(AcType acType) {
        //Example example = new Example(${data.javaModel.className}.class);
        //example.createCriteria().andEqualTo("deleteFlag", DataConstant.DELETE_FLAG_0);
        //if (${data.lowerMapperClassName}.selectOneByExample(example) != null) {
        //    throw new BizException("不允许重复");
        //}
        acTypeMapper.insertSelective(acType);
    }

    /**
     * @Description: TODO(获取)
     * @Param: [ id ]
     * @return: ${data.javaModel.packageName}.${data.javaModel.className}
     * @Author: xxx
     * @Date: ${data.date}
     */
    @Transactional(readOnly = true)
    public AcType get(String id) {
        return acTypeMapper.selectByPrimaryKey(id);
    }

    /**
     * @Description: TODO(更新实体)
     * @Param: [ ${data.javaModel.lowerClassName} ]
     * @return: void
     * @Author: xxx
     * @Date: ${data.date}
     */
    @Transactional
    public void update(AcType acType) {
        //Example example = new Example(${data.javaModel.className}.class);
        //example.createCriteria().andEqualTo("deleteFlag", DataConstant.DELETE_FLAG_0)
        //.andNotEqualTo("id", ${data.javaModel.lowerClassName}.getId());
        //if (${data.lowerMapperClassName}.selectCountByExample(example) > 0) {
        //    throw new BizException("不允许重复");
        //}
        acTypeMapper.updateByPrimaryKeySelective(acType);
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
        AcType acType =new AcType();
        acType.setId(id);
       // acType.setDeleteFlag(DataConstant.DELETE_FLAG_1);
        acTypeMapper.updateByPrimaryKeySelective(acType);
    }
}
