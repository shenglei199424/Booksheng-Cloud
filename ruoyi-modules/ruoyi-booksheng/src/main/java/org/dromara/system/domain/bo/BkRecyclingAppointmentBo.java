package org.dromara.system.domain.bo;

import org.dromara.system.domain.BkRecyclingAppointment;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 预约回收业务对象 bk_recycling_appointment
 *
 * @author scott
 * @date 2024-12-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = BkRecyclingAppointment.class, reverseConvertGenerate = false)
public class BkRecyclingAppointmentBo extends BaseEntity {

    /**
     * 预约回收记录ID
     */
    @NotNull(message = "预约回收记录ID不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 预约开始时间
     */
    @NotNull(message = "预约开始时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date appointmentStart;

    /**
     * 预约结束时间
     */
    @NotNull(message = "预约结束时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date appointmentEnd;

    /**
     * 回收地址
     */
    @NotBlank(message = "回收地址不能为空", groups = { AddGroup.class, EditGroup.class })
    private String address;

    /**
     * 回收品类
     */
    @NotBlank(message = "回收品类不能为空", groups = { AddGroup.class, EditGroup.class })
    private String category;

    /**
     * 回收物品图片URL（JSON格式存储）
     */
    @NotBlank(message = "回收物品图片URL（JSON格式存储）不能为空", groups = { AddGroup.class, EditGroup.class })
    private String images;

    /**
     * 备注
     */
    @NotBlank(message = "备注不能为空", groups = { AddGroup.class, EditGroup.class })
    private String remark;


}
