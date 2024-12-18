package org.dromara.system.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.system.domain.BkRecyclingAppointment;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 预约回收视图对象 bk_recycling_appointment
 *
 * @author scott
 * @date 2024-12-05
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BkRecyclingAppointment.class)
public class BkRecyclingAppointmentVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 预约回收记录ID
     */
    @ExcelProperty(value = "预约回收记录ID")
    private Long id;

    /**
     * 预约开始时间
     */
    @ExcelProperty(value = "预约开始时间")
    private Date appointmentStart;

    /**
     * 预约结束时间
     */
    @ExcelProperty(value = "预约结束时间")
    private Date appointmentEnd;

    /**
     * 回收地址
     */
    @ExcelProperty(value = "回收地址")
    private String address;

    /**
     * 回收品类
     */
    @ExcelProperty(value = "回收品类")
    private String category;

    /**
     * 回收物品图片URL（JSON格式存储）
     */
    @ExcelProperty(value = "回收物品图片URL", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "J=SON格式存储")
    private String images;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}
