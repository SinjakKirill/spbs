package com.example.sinyakkirill.lab_4_5.educationmanager;

import com.example.sinyakkirill.lab_4_5.exception.EduException;
import com.example.sinyakkirill.lab_4_5.staff.Staff;

/**
 * Created by Sinyak Kirill on 27.09.2016.
 */

public interface IAction {
    public Staff createCourseJson(Staff someCourse, int maxStudent, int maxListner, String fileNameListener, String fileNameStudent) throws EduException;
    public Staff createCourseRandom(Staff someCourse, int maxStudent, int maxListener) throws EduException;
    public int sumRange(Staff anyCourse);
    public int countListner(Staff anyCourse);
}
