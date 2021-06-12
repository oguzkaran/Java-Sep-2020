package org.csystem.app.samples.company;

public final class CompanyApp {
    private CompanyApp()
    {
    }

    public static void run()
    {
        HumanResources hr = new HumanResources();
        Manager m = new Manager();

        m.setName("Ali");
        m.setAddress("Mecidiyeköy");
        m.setCitizenId("12345678912");
        m.setSalary(20000);
        m.setDepartment("Yazılım");

        Worker w = new Worker();

        w.setName("Veli");
        w.setAddress("Şişli");
        w.setCitizenId("12345677912");
        w.setFeePerHour(100);
        w.setHourPerDay(8);

        SalesManager sm = new SalesManager();

        sm.setName("Ayşe");
        sm.setAddress("Beylikdüzü");
        sm.setCitizenId("12345678916");
        sm.setSalary(20000);
        sm.setDepartment("Yazılım");
        sm.setExtra(1200.34);

        ProjectWorker pw = new ProjectWorker();

        pw.setName("Zeynep");
        pw.setAddress("Fatih");
        pw.setCitizenId("12345577912");
        pw.setFeePerHour(89.78);
        pw.setHourPerDay(8);
        pw.setProjectName("network system");
        pw.setRatio(20.5);

        hr.payInsurance(m);
        hr.payInsurance(w);
        hr.payInsurance(sm);
        hr.payInsurance(pw);
    }
}
