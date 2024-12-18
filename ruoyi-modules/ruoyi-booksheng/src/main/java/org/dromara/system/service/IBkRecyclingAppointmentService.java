package org.dromara.system.service;

import org.dromara.system.domain.vo.BkRecyclingAppointmentVo;
import org.dromara.system.domain.bo.BkRecyclingAppointmentBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 预约回收Service接口
 *
 * @author scott
 * @date 2024-12-05
 */
public interface IBkRecyclingAppointmentService {

    /**
     * 查询预约回收
     *
     * @param id 主键
     * @return 预约回收
     */
    BkRecyclingAppointmentVo queryById(Long id);

    /**
     * 分页查询预约回收列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 预约回收分页列表
     */
    TableDataInfo<BkRecyclingAppointmentVo> queryPageList(BkRecyclingAppointmentBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的预约回收列表
     *
     * @param bo 查询条件
     * @return 预约回收列表
     */
    List<BkRecyclingAppointmentVo> queryList(BkRecyclingAppointmentBo bo);

    /**
     * 新增预约回收
     *
     * @param bo 预约回收
     * @return 是否新增成功
     */
    Boolean insertByBo(BkRecyclingAppointmentBo bo);

    /**
     * 修改预约回收
     *
     * @param bo 预约回收
     * @return 是否修改成功
     */
    Boolean updateByBo(BkRecyclingAppointmentBo bo);

    /**
     * 校验并批量删除预约回收信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
