package models;

import enums.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Task {
    private String subject;
    private String comments;
    private StatusTask statusTask;
    private PriorityTask priorityTask;

}
