package qiang.redis.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Qiang.wei
 * @date 2019/8/12 14:52
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Programmer implements Serializable {

    private String name;

    private int age;

    private float salary;

    private Date birthday;
}
