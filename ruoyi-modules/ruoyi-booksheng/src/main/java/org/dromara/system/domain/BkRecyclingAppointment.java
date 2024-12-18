package org.dromara.system.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 预约回收对象 bk_recycling_appointment
 *
 * @author scott
 * @date 2024-12-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("bk_recycling_appointment")
public class BkRecyclingAppointment extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 预约回收记录ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 预约开始时间
     */
    private Date appointmentStart;

    /**
     * 预约结束时间
     */
    private Date appointmentEnd;

    /**
     * 回收地址
     */
    private String address;

    /**
     * 回收品类
     */
    private String category;

    /**
     * 回收物品图片URL（JSON格式存储）
     */
    private String images;

    /**
     * 备注
     */
    private String remark;


}
