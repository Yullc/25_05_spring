
package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    private int id;
    private int articleId;
    private int memberId;
    private String regDate;
    private String updateDate;
    private String commentBody;
    
    private String extra__writer;

}
