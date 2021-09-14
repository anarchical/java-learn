package vo;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YeYaqiao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    @NotNull
    private int id;
    @NotNull
    private String name;
}
