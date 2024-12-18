package org.dromara.system.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.dromara.system.domain.bo.BkRecyclingAppointmentBo;
import org.dromara.system.domain.vo.BkRecyclingAppointmentVo;
import org.dromara.system.domain.BkRecyclingAppointment;
import org.dromara.system.mapper.BkRecyclingAppointmentMapper;
import org.dromara.system.service.IBkRecyclingAppointmentService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 预约回收Service业务层处理
 *
 * @author scott
 * @date 2024-12-05
 */
@RequiredArgsConstructor
@Service
public class BkRecyclingAppointmentServiceImpl implements IBkRecyclingAppointmentService {

    private final BkRecyclingAppointmentMapper baseMapper;

    /**
     * 查询预约回收
     *
     * @param id 主键
     * @return 预约回收
     */
    @Override
    public BkRecyclingAppointmentVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询预约回收列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 预约回收分页列表
     */
    @Override
    public TableDataInfo<BkRecyclingAppointmentVo> queryPageList(BkRecyclingAppointmentBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BkRecyclingAppointment> lqw = buildQueryWrapper(bo);
        Page<BkRecyclingAppointmentVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的预约回收列表
     *
     * @param bo 查询条件
     * @return 预约回收列表
     */
    @Override
    public List<BkRecyclingAppointmentVo> queryList(BkRecyclingAppointmentBo bo) {
        LambdaQueryWrapper<BkRecyclingAppointment> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BkRecyclingAppointment> buildQueryWrapper(BkRecyclingAppointmentBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BkRecyclingAppointment> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getAppointmentStart() != null, BkRecyclingAppointment::getAppointmentStart, bo.getAppointmentStart());
        lqw.eq(bo.getAppointmentEnd() != null, BkRecyclingAppointment::getAppointmentEnd, bo.getAppointmentEnd());
        lqw.eq(StringUtils.isNotBlank(bo.getAddress()), BkRecyclingAppointment::getAddress, bo.getAddress());
        lqw.eq(StringUtils.isNotBlank(bo.getCategory()), BkRecyclingAppointment::getCategory, bo.getCategory());
        lqw.eq(StringUtils.isNotBlank(bo.getImages()), BkRecyclingAppointment::getImages, bo.getImages());
        return lqw;
    }

    /**
     * 新增预约回收
     *
     * @param bo 预约回收
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(BkRecyclingAppointmentBo bo) {
        BkRecyclingAppointment add = MapstructUtils.convert(bo, BkRecyclingAppointment.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改预约回收
     *
     * @param bo 预约回收
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(BkRecyclingAppointmentBo bo) {
        BkRecyclingAppointment update = MapstructUtils.convert(bo, BkRecyclingAppointment.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BkRecyclingAppointment entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除预约回收信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteByIds(ids) > 0;
    }
}
