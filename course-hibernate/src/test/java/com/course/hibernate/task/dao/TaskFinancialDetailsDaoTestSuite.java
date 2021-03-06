package com.course.hibernate.task.dao;

import com.course.hibernate.task.Task;
import com.course.hibernate.task.TaskFinancialDetails;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskFinancialDetailsDaoTestSuite {
    private static final String DESCRIPTION = "entity 1:1";
    @Autowired
    TaskFinancialDetailsDao taskFinancialDetailsDao;
    TaskDao taskDao;

    @Test
    public void testFindByPaid() {
        //Given
        TaskFinancialDetails taskFinancialDetails =
                new TaskFinancialDetails(new BigDecimal(115), false);
        taskFinancialDetailsDao.save(taskFinancialDetails);
        int id = taskFinancialDetails.getId();

        //When
        List<TaskFinancialDetails> resultList = taskFinancialDetailsDao.findByPaid(false);

        //Then
        Assert.assertEquals(1, resultList.size());

        //CleanUp
        taskFinancialDetailsDao.deleteById(id);
    }



}