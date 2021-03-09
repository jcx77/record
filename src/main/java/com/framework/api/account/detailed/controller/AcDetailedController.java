package com.framework.api.account.detailed.controller;


import com.framework.api.account.detailed.model.AcDetailed;
import com.framework.api.account.detailed.service.AcDetailedService;
import com.framework.api.account.vo.AcParam;
import com.framework.commons.vo.response.Response;
import com.framework.commons.vo.response.ResponseResult;
import com.framework.commons.vo.ui.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/ac/detailed")
public class AcDetailedController {
    @Autowired
    private AcDetailedService acDetailedService;

    /**
     * @Description: TODO(  )
     * @Param: [  ]
     * @return: AcDetailed
     * @Author: xxx
     * @Date: 2021年3月7日 12:18:35
     */
    @RequestMapping(value = "/find")
    public ResponseResult<PageList<AcDetailed>> find(@RequestBody AcParam acParam) {
        return new ResponseResult<>(new PageList<>(acDetailedService.find(acParam)));
    }


    /**
     * @Description: TODO()
     * @Param: [acDetailed]
     * @return:
     * @Author: xxx
     * @Date: 2021年3月7日 12:18:35
     */
    @RequestMapping(value = "/insert")
    //@RequiresPermissions("mlb:insert")
    public Response insert(@RequestBody @Validated AcDetailed acDetailed) {
        acDetailedService.insert(acDetailed);
        return Response.success();
    }


    /**
     * @Description: TODO( 获取 )
     * @Param: [ id ]
     * @return: AcDetailed
     * @Author: xxx
     * @Date: 2021年3月7日 12:18:35
     */
    @RequestMapping(value = "/get/{id}")
    public ResponseResult<AcDetailed> get(@PathVariable String id) {
        return new ResponseResult<>(acDetailedService.get(id));
    }

    /**
     * @Description: TODO( 更新 )
     * @Param: [  ]
     * @return:
     * @Author: xxx
     * @Date: 2021年3月7日 12:18:35
     */
    @RequestMapping(value = "/update")
    public Response update(@RequestBody @Validated AcDetailed acDetailed) {
        acDetailedService.update(acDetailed);
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
        acDetailedService.delete(id);
        return Response.success();
    }
}
