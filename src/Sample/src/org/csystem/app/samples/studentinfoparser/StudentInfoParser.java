package org.csystem.app.samples.studentinfoparser;

public class StudentInfoParser {
    private final StudentInfo m_studentInfo;

    //...
    public StudentInfoParser(String str)
    {
        /*
            <isim>:<gg/aa/yyyy>:<ders adı>:<vize>:<final>
            Oğuz Karan:10/09/1976:Programlamaya Giriş:76:89
        */
        String [] studentInfoStr = str.split("[:]+");

        //...

        m_studentInfo = new StudentInfo(studentInfoStr[0], studentInfoStr[1], studentInfoStr[2],
                Integer.parseInt(studentInfoStr[3]), Integer.parseInt(studentInfoStr[4]));
    }

    public StudentInfo getStudentInfo()
    {
        return m_studentInfo;
    }
}
