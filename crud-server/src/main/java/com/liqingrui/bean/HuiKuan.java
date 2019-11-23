package com.liqingrui.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "huikuan")
public class HuiKuan {
    @Id
    private String hkId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hkDate;
    private Double hkMoney; // 回款金额
    private String hname;  //收款人
    private String hkBz;  // 回款备注
    @ManyToOne(optional = false,cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "hid")
    private HeTong heTong;
}
