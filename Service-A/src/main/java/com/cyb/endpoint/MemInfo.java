package com.cyb.endpoint;
/**
 *作者 : iechenyb<br>
 *类描述: 说点啥<br>
 *创建时间: 2018年1月10日
 */
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;  
  
public class MemInfo {  
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")  
    private Date recordTime;//记录时间.  
      
    private long maxMemory;//能构从操作系统那里挖到的最大的内存，以字节为单位  
    private long totalMemory;//进程当时所占用的所有 内存  
    public Date getRecordTime() {  
        return recordTime;  
    }  
    public void setRecordTime(Date recordTime) {  
        this.recordTime = recordTime;  
    }  
    public long getMaxMemory() {  
        return maxMemory;  
    }  
    public void setMaxMemory(long maxMemory) {  
        this.maxMemory = maxMemory;  
    }  
    public long getTotalMemory() {  
        return totalMemory;  
    }  
    public void setTotalMemory(long totalMemory) {  
        this.totalMemory = totalMemory;  
    }  
}  