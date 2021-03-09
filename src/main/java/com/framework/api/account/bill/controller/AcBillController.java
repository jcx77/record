package com.framework.api.account.bill.controller;


import com.framework.api.account.bill.model.AcBill;
import com.framework.api.account.bill.service.AcBillService;
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
@RequestMapping(value = "/api/ac/bill")
public class AcBillController {
    @Autowired
    private AcBillService acBillService;

    /**
     * @Description: TODO(  )
     * @Param: [  ]
     * @return: AcBill
     * @Author: xxx
     * @Date: ${data.date}
     */
    @RequestMapping(value = "/find")
    public ResponseResult<PageList<AcBill>> find(@RequestBody AcParam acParam) {
        return new ResponseResult<>(new PageList<>(acBillService.find(acParam)));
    }


    /**
     * @Description: TODO()
     * @Param: [acBill]
     * @return:
     * @Author: xxx
     * @Date: ${data.date}
     */
    @RequestMapping(value = "/insert")
    //@RequiresPermissions("mlb:insert")
    public Response insert(@RequestBody @Validated AcBill acBill) {
        acBillService.insert(acBill);
        return Response.success();
    }


    /**
     * @Description: TODO( 获取 )
     * @Param: [ id ]
     * @return: AcBill
     * @Author: xxx
     * @Date: ${data.date}
     */
    @RequestMapping(value = "/get/{id}")
    public ResponseResult<AcBill> get(@PathVariable String id) {
        return new ResponseResult<>(acBillService.get(id));
    }

    /**
     * @Description: TODO( 更新 )
     * @Param: [  ]
     * @return:
     * @Author: xxx
     * @Date: ${data.date}
     */
    @RequestMapping(value = "/update")
    public Response update(@RequestBody @Validated AcBill acBill) {
        acBillService.update(acBill);
        return Response.success();
    }


    /**
     * @Description: TODO(  )
     * @Param: [ id ]
     * @return:
     * @Author: xxx
     * @Date: ${data.date}
     */
    @RequestMapping(value = "/delete/{id}")
    public Response delete(@PathVariable String id) {
        acBillService.delete(id);
        return Response.success();
    }
}
