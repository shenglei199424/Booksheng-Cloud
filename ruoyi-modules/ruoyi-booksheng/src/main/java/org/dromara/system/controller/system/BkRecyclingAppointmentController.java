package org.dromara.system.controller.system;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.web.core.BaseController;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.system.domain.vo.BkRecyclingAppointmentVo;
import org.dromara.system.domain.bo.BkRecyclingAppointmentBo;
import org.dromara.system.service.IBkRecyclingAppointmentService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 预约回收
 *
 * @author scott
 * @date 2024-12-05
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/recyclingAppointment")
public class BkRecyclingAppointmentController extends BaseController {

    private final IBkRecyclingAppointmentService bkRecyclingAppointmentService;

    /**
     * 查询预约回收列表
     */
    //@SaCheckPermission("system:recyclingAppointment:list")
    @GetMapping("/list")
    public TableDataInfo<BkRecyclingAppointmentVo> list(BkRecyclingAppointmentBo bo, PageQuery pageQuery) {
        return bkRecyclingAppointmentService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出预约回收列表
     */
    @SaCheckPermission("system:recyclingAppointment:export")
    @Log(title = "预约回收", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BkRecyclingAppointmentBo bo, HttpServletResponse response) {
        List<BkRecyclingAppointmentVo> list = bkRecyclingAppointmentService.queryList(bo);
        ExcelUtil.exportExcel(list, "预约回收", BkRecyclingAppointmentVo.class, response);
    }

    /**
     * 获取预约回收详细信息
     *
     * @param id 主键
     */
    //@SaCheckPermission("system:recyclingAppointment:query")
    @GetMapping("/{id}")
    public R<BkRecyclingAppointmentVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(bkRecyclingAppointmentService.queryById(id));
    }

    /**
     * 新增预约回收
     */
    //@SaCheckPermission("system:recyclingAppointment:add")
    @Log(title = "预约回收", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BkRecyclingAppointmentBo bo) {
        return toAjax(bkRecyclingAppointmentService.insertByBo(bo));
    }

    /**
     * 修改预约回收
     */
    //@SaCheckPermission("system:recyclingAppointment:edit")
    @Log(title = "预约回收", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BkRecyclingAppointmentBo bo) {
        return toAjax(bkRecyclingAppointmentService.updateByBo(bo));
    }

    /**
     * 删除预约回收
     *
     * @param ids 主键串
     */
    //@SaCheckPermission("system:recyclingAppointment:remove")
    @Log(title = "预约回收", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(bkRecyclingAppointmentService.deleteWithValidByIds(List.of(ids), true));
    }
}
