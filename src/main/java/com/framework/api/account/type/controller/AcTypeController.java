package com.framework.api.account.type.controller;


import com.framework.api.account.type.model.AcType;
import com.framework.api.account.type.service.AcTypeService;
import com.framework.api.account.vo.AcParam;
import com.framework.commons.vo.response.Response;
import com.framework.commons.vo.response.ResponseResult;
import com.framework.commons.vo.ui.PageList;
import com.framework.commons.vo.ui.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/ac/type")
public class AcTypeController {
    @Autowired
    private AcTypeService acTypeService;

    /**
     * @Description: TODO(  )
     * @Param: [  ]
     * @return: AcType
     * @Author: xxx
     * @Date: 2021年3月7日 12:18:35
     */
    @RequestMapping(value = "/find")
    public ResponseResult<PageList<AcType>> find(@RequestBody AcParam acParam) {
        return new ResponseResult<>(new PageList<>(acTypeService.find(acParam)));
    }
    @RequestMapping(value = "/findTypeSelect")
    public ResponseResult<List<TreeNode>> findTypeSelect() {
        return new ResponseResult<>(acTypeService.findTypeSelect());
    }

    /**
     * @Description: TODO()
     * @Param: [acType]
     * @return:
     * @Author: xxx
     * @Date: 2021年3月7日 12:18:35
     */
    @RequestMapping(value = "/insert")
    //@RequiresPermissions("mlb:insert")
    public Response insert(@RequestBody @Validated AcType acType) {
        acTypeService.insert(acType);
        return Response.success();
    }


    /**
     * @Description: TODO( 获取 )
     * @Param: [ id ]
     * @return: AcType
     * @Author: xxx
     * @Date: 2021年3月7日 12:18:35
     */
    @RequestMapping(value = "/get/{id}")
    public ResponseResult<AcType> get(@PathVariable String id) {
        return new ResponseResult<>(acTypeService.get(id));
    }

    /**
     * @Description: TODO( 更新 )
     * @Param: [  ]
     * @return:
     * @Author: xxx
     * @Date: 2021年3月7日 12:18:35
     */
    @RequestMapping(value = "/update")
    public Response update(@RequestBody @Validated AcType acType) {
        acTypeService.update(acType);
        return Response.success();
    }


    /**
     * @Description: TODO(  )
     * @Param: [ id ]
     * @return:
     * @Author: xxx
     * @Date: 2021年3月7日 12:18:35
     */
    @RequestMapping(value = "/delete/{id}")
    public Response delete(@PathVariable String id) {
        acTypeService.delete(id);
        return Response.success();
    }
}
