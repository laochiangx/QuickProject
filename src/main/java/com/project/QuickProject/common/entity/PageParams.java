package com.project.QuickProject.common.entity;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;

@Data
public class PageParams implements Serializable {

    private static final long serialVersionUID = -1537176372467984421L;

    private int page = 1;

    private int pageSize = 10;

    public <T> Page<T> getIPage() {
        return new Page<T>(page, pageSize);
    }

}
